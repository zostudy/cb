package com.asiainfo.rms.workflow.service.driving.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.rms.workflow.common.workflow.WorkflowStaticDef;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.driving.BOAlmTopoRule;
import com.asiainfo.rms.workflow.domain.driving.BOAlmTopology;
import com.asiainfo.rms.workflow.domain.driving.BOAlmWorkflowDriving;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmWorkflow;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmWorkflowTemplate;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmWorkorder;


/**
 * 
 * @author 刘超
 * @version 1.4
 *
 */
public abstract class AlmProcessDrivingFun {

	private final static transient Log log = LogFactory.getLog(AlmProcessDrivingFun.class);
	
	@Resource(name="commonDao")
	private CommonDAO commonDAO;
	
	/**
	 * 根据主动业务ID与主动业务类型与被动业务类型获取被动业务ID，该方法需要实现查找业务表
	 * @param active_obj_id
	 * @param active_obj_type
	 * @param passive_obj_type
	 * @return
	 */
	public abstract Long[] getBusiObjIdByCondition(Long active_obj_id,String active_obj_type,String passive_obj_type);
	
	/**
	 * 只要被动节点回单，主动工单就会被带动
	 * @param active_obj_id
	 * @param active_obj_type
	 * @param activeTopoNo
	 * @param passiveTopoNo
	 * @return 工单
	 * @throws Exception
	 */
	public BOAlmWorkorder[] fristActiveWODrivePassiveWO(Long active_obj_id,String active_obj_type,String activeTopoNo,String drivNo) throws Exception{
		String condition = "select o from BOAlmTopoRule o where o.no=:drivno";
		Map<String,Object> paramter = new HashMap<String,Object>();
		paramter.put("drivno", drivNo);
		List<BOAlmTopoRule> passiveTopoRules = commonDAO.findByJPAQL(condition, paramter);
		if(passiveTopoRules==null||passiveTopoRules.size()==0){
			if(log.isErrorEnabled()){
				log.error("查询带动规则出错，查询条件:[no]="+drivNo+",[sql]="+condition);
			}
			throw new Exception("查询带动规则出错，查询条件:[no]="+drivNo+",[sql]="+condition);
		}
		
		condition = "select o from BOAlmTopology o where o.no=:topoNo";
		paramter = new HashMap<String, Object>();
		paramter.put("passNo", passiveTopoRules.get(0).getTopoNo());
		List<BOAlmTopology> passiveTopos = commonDAO.findByJPAQL(condition, paramter);
		if(passiveTopos==null||passiveTopos.size()==0){
			if(log.isErrorEnabled()){
				log.error("查询节点关系出错，查询条件:[no]="+passiveTopoRules.get(0).getTopoNo()+",[sql]="+condition);
			}
			throw new Exception("查询节点关系出错，查询条件:[no]="+passiveTopoRules.get(0).getTopoNo()+",[sql]="+condition);
		}
		
		condition = "select o from BOAlmWorkflow o where o.linkId=:linkId";
		paramter = new HashMap<String,Object>();
		paramter.put("linkId", passiveTopos.get(0).getFpoint());
		List<BOAlmWorkflow> passiveWorkflows = commonDAO.findByJPAQL(condition, paramter,true);
		
		if(passiveWorkflows==null||passiveWorkflows.size()==0){
			if(log.isErrorEnabled()){
				log.error("查询被动节点出错，查询条件:[linkId]="+passiveTopos.get(0).getFpoint()+",[sql]="+condition);
			}
			throw new Exception("查询被动节点出错，查询条件:[linkId]="+passiveTopos.get(0).getFpoint()+",[sql]="+condition);
		}
		
		condition = "select o from BOAlmWorkflowTemplate o where o.processKey=:processKey";
		paramter = new HashMap<String,Object>();
		paramter.put("processKey", passiveWorkflows.get(0).getProcessKey());
		List<BOAlmWorkflowTemplate> passiveWorkflowTemplates = commonDAO.findByJPAQL(condition, paramter);
		
		if(passiveWorkflowTemplates==null||passiveWorkflowTemplates.size()==0){
			if(log.isErrorEnabled()){
				log.error("查询被动模板信息出错，查询条件:[processKey]="+ passiveWorkflows.get(0).getProcessKey()+",[sql]="+condition);
			}
			throw new Exception("查询被动模板信息出错，查询条件:[processKey]="+ passiveWorkflows.get(0).getProcessKey()+",[sql]="+condition);
		}
		
		String passive_obj_type = passiveWorkflowTemplates.get(0).getObjType();
		Long[] obj_ids = this.getBusiObjIdByCondition(active_obj_id, active_obj_type, passive_obj_type);
		List<BOAlmWorkorder>  passiveWOList = new ArrayList<BOAlmWorkorder>();
		for(long passive_obj_id : obj_ids ){
			String sql = new String();
			sql = "select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.orderType=:orderType and o.linkId=:linkId and o.status=:status";
			paramter = new HashMap();
			paramter.put("objId", passive_obj_id);
			paramter.put("objType", passive_obj_type);
			paramter.put("orderType", WorkflowStaticDef.STAKEHOLDERTYPE_WF);
			paramter.put("linkId", passiveTopos.get(0).getFpoint());
			paramter.put("status", WorkflowStaticDef.WO_STATUS_RECEIVE);
			List<BOAlmWorkorder> workorders =commonDAO.findByJPAQL(sql,paramter);
			for(BOAlmWorkorder wo : workorders){
				passiveWOList.add(wo);
			}
			
		}
		return passiveWOList.toArray(new BOAlmWorkorder[0]);
	}
	
	/**
	 * 当所有主动工单全部完成后带动被动工单
	 * @param active_obj_id
	 * @param active_obj_type
	 * @param activeTopoNo
	 * @param drivNo
	 * @return
	 * @throws Exception
	 */
	public BOAlmWorkorder[] allActiveWODrivePassiveWO(Long active_obj_id,String active_obj_type,String activeTopoNo,String drivNo) throws Exception{
		
		String condition = "select o from BOAlmTopoRule o where o.no=:drivno";
		Map<String,Object> paramter = new HashMap<String,Object>();
		paramter.put("drivno", drivNo);
		List<BOAlmTopoRule> passiveTopoRules = commonDAO.findByJPAQL(condition, paramter);
		if(passiveTopoRules==null||passiveTopoRules.size()==0){
			if(log.isErrorEnabled()){
				log.error("查询带动规则出错，查询条件:[no]="+drivNo+",[sql]="+condition);
			}
			throw new Exception("查询带动规则出错，查询条件:[no]="+drivNo+",[sql]="+condition);
		}
		
		condition = "select o from BOAlmTopology o where o.no=:topoNo";
		paramter = new HashMap<String, Object>();
		paramter.put("topoNo", passiveTopoRules.get(0).getTopoNo());
		List<BOAlmTopology> passiveTopos = commonDAO.findByJPAQL(condition, paramter);
		if(passiveTopos==null||passiveTopos.size()==0){
			if(log.isErrorEnabled()){
				log.error("查询节点关系出错，查询条件:[no]="+passiveTopoRules.get(0).getTopoNo()+",[sql]="+condition);
			}
			throw new Exception("查询节点关系出错，查询条件:[no]="+passiveTopoRules.get(0).getTopoNo()+",[sql]="+condition);
		}
		
		condition = "select o from BOAlmTopology o where o.no=:topoNo";
		paramter = new HashMap<String,Object>();
		paramter.put("topoNo", activeTopoNo);
		List<BOAlmTopology> activeTopos = commonDAO.findByJPAQL(condition, paramter);
		if(activeTopos==null||activeTopos.size()==0){
			if(log.isErrorEnabled()){
				log.error("查询主动节点出错，查询条件:[topoNo]="+activeTopoNo+",[sql]="+condition);
			}
			throw new Exception("查询主动节点出错，查询条件:[topoNo]="+activeTopoNo+",[sql]="+condition);
		}
		
		condition = "select o from BOAlmWorkflow o where o.linkId=:linkId";
		paramter = new HashMap<String,Object>();
		paramter.put("linkId", activeTopos.get(0).getFpoint());
		List<BOAlmWorkflow> activeWorkflows = commonDAO.findByJPAQL(condition, paramter,true);
		if(activeWorkflows==null||activeWorkflows.size()==0){
			if(log.isErrorEnabled()){
				log.error("查询主动环节信息出错，查询条件:[linkId]="+activeTopos.get(0).getFpoint()+",[sql]="+condition);
			}
			throw new Exception("查询主动环节信息出错，查询条件:[linkId]="+activeTopos.get(0).getFpoint()+",[sql]="+condition);
		}
		
		condition = "select o from BOAlmWorkflow o where o.linkId=:linkId";
		paramter = new HashMap<String,Object>();
		paramter.put("linkId", passiveTopos.get(0).getFpoint());
		List<BOAlmWorkflow> passiveWorkflows = commonDAO.findByJPAQL(condition, paramter,true);
		if(passiveWorkflows==null||passiveWorkflows.size()==0){
			if(log.isErrorEnabled()){
				log.error("查询被动环节信息出错，查询条件:[linkId]="+ passiveTopos.get(0).getFpoint()+",[sql]="+condition);
			}
			throw new Exception("查询被动环节信息出错，查询条件:[linkId]="+ passiveTopos.get(0).getFpoint()+",[sql]="+condition);
		}
		
		String activeProcessKey = activeWorkflows.get(0).getProcessKey();
		
		condition = "select o from BOAlmWorkflowDriving o where o.passivePoint=:passivePoint and activeProcessKey=:activeProcessKey";
		paramter = new HashMap<String,Object>();
		paramter.put("passivePoint", passiveTopos.get(0).getFpoint().toString());
		paramter.put("activeProcessKey", activeProcessKey);
		List<BOAlmWorkflowDriving> almWorkflowDrivings = commonDAO.findByJPAQL(condition, paramter);
		if(almWorkflowDrivings==null||almWorkflowDrivings.size()==0){
			if(log.isErrorEnabled()){
				log.error("查询带动信息出错，查询条件:[passivePoint]="+ passiveTopos.get(0).getFpoint()+"，[activeProcessKey]="+activeProcessKey+",[sql]="+condition);
			}
			throw new Exception("查询带动信息出错，查询条件:[passivePoint]="+ passiveTopos.get(0).getFpoint()+"，[activeProcessKey]="+activeProcessKey+",[sql]="+condition);
		}
		
		condition = "select o from BOAlmWorkflowTemplate o where o.processKey=:processKey";
		paramter = new HashMap<String,Object>();
		paramter.put("processKey", passiveWorkflows.get(0).getProcessKey());
		List<BOAlmWorkflowTemplate> passiveWorkflowTemplates = commonDAO.findByJPAQL(condition, paramter);
		if(passiveWorkflowTemplates==null||passiveWorkflowTemplates.size()==0){
			if(log.isErrorEnabled()){
				log.error("查询被动模板信息出错，查询条件:[processKey]="+ passiveWorkflows.get(0).getProcessKey()+",[sql]="+condition);
			}
			throw new Exception("查询被动模板信息出错，查询条件:[processKey]="+ passiveWorkflows.get(0).getProcessKey()+",[sql]="+condition);
		}
		String passive_obj_type = passiveWorkflowTemplates.get(0).getObjType();
		
		Long[] obj_ids = this.getBusiObjIdByCondition(active_obj_id, active_obj_type, passive_obj_type);
		List<BOAlmWorkorder>  passiveWOList = new ArrayList<BOAlmWorkorder>();
		for(long passive_obj_id : obj_ids ){
			String sql = new String();
			sql = "select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.orderType=:orderType and o.linkId=:linkId and o.status=:status";
			paramter = new HashMap();
			paramter.put("objId", passive_obj_id);
			paramter.put("objType", passive_obj_type);
			paramter.put("orderType", WorkflowStaticDef.STAKEHOLDERTYPE_WF);
			paramter.put("linkId", passiveTopos.get(0).getFpoint());
			paramter.put("status", WorkflowStaticDef.WO_STATUS_RECEIVE);
			List<BOAlmWorkorder> workorders =commonDAO.findByJPAQL(sql,paramter);
			for(BOAlmWorkorder wo : workorders){
				passiveWOList.add(wo);
				
				Long[] active_obj_ids = this.getBusiObjIdByCondition(passive_obj_id, passive_obj_type, active_obj_type);
				if(active_obj_ids!=null)
					for(long active_objId : active_obj_ids){
						sql = new String();
						sql = "select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.orderType=:orderType and o.status=:status";
						paramter = new HashMap();
						paramter.put("objId", active_objId);
						paramter.put("objType", active_obj_type);
						paramter.put("orderType", WorkflowStaticDef.STAKEHOLDERTYPE_WF);
						paramter.put("status", WorkflowStaticDef.WO_STATUS_RECEIVE);
						
						List<BOAlmWorkorder> wos =commonDAO.findByJPAQL(sql,paramter);
						if(wos==null||wos.size()==0)
							continue;
						condition = "select o from BOAlmWorkflowDriving o where o.passiveProcessKey=:passiveProcessKey and activeProcessKey=:activeProcessKey and activePoint like :activePoint";
						paramter = new HashMap<String,Object>();
						paramter.put("passiveProcessKey", almWorkflowDrivings.get(0).getPassiveProcessKey());
						paramter.put("activeProcessKey", almWorkflowDrivings.get(0).getActiveProcessKey());
						paramter.put("activePoint", "%|"+wos.get(0).getLinkId()+"|%");
						List<BOAlmWorkflowDriving> tempWorkflowDrivings = commonDAO.findByJPAQL(condition, paramter);
						if(tempWorkflowDrivings != null && tempWorkflowDrivings.size()!=0 && tempWorkflowDrivings.get(0).getLinkRelativePhase() <= almWorkflowDrivings.get(0).getLinkRelativePhase()){
							return null;
						}
					}
			}			
		}
		return passiveWOList.toArray(new BOAlmWorkorder[0]);
	}
}
