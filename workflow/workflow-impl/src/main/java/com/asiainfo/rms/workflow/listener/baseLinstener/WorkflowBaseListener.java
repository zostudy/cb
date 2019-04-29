package com.asiainfo.rms.workflow.listener.baseLinstener;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.TaskService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.asiainfo.rms.workflow.bo.workflow.StakeholderBO;
import com.asiainfo.rms.workflow.bo.workflow.WorkorderBO;
import com.asiainfo.rms.workflow.common.workflow.WorkflowStaticDef;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmStakeholder;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmWorkflow;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmWorkorder;
import com.asiainfo.rms.workflow.mapper.workflow.StakeholderMapper;
import com.asiainfo.rms.workflow.mapper.workflow.WorkorderMapper;
import com.asiainfo.rms.workflow.service.stakeholder.IAlmHisStakeholderSV;
import com.asiainfo.rms.workflow.service.workorder.IAlmHisWorkorderSV;
import com.asiainfo.rms.workflow.service.workorder.IAlmWorkorderSV;

/**
 * 
 * @author 刘超
 * @version 1.4
 *
 */
@SuppressWarnings("rawtypes")
public class WorkflowBaseListener{

	private final static transient Log log = LogFactory.getLog(WorkflowBaseListener.class);
	
	public static enum MethodType {
		
		userPreTask("userPreTask"), userRearTask("userRearTask"), signPreTask("signPreTask"), signRearTask("signRearTask");
		
		private String name;
		
		private MethodType(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	};
	
	@Resource(name="commonDao")
	private CommonDAO commonDAO;
	
	@Resource(name="almWorkorderSV")
	private IAlmWorkorderSV almWorkorderSV;
	
	@Resource(name="hisWorkorderSV")
	private IAlmHisWorkorderSV almHisWorkorderSV;
	
	@Autowired
	private TaskService taskService;
	
	@Resource(name="hisStakeholderSV")
	private IAlmHisStakeholderSV almHisStakeholderSV;
	
	//人工环节前置任务
	@SuppressWarnings({ "unchecked"})
	public List userPreTask(long deployId, String processKey,long procInstId, long taskId, String taskName, String objId, String objType) throws Exception
	{
		List list = new ArrayList();
		String sql = new String();
		sql = "select o from BOAlmWorkflow o where o.processKey=:processKey and o.linkNo=:linkNo";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("processKey", processKey);
		param.put("linkNo", taskName);
		List<BOAlmWorkflow> boAlmWorkflows =  commonDAO.findByJPAQL(sql, param,true);
		if(boAlmWorkflows.size() != 1){
			if (log.isErrorEnabled()) {
				StringBuffer sb = new StringBuffer();
				sb.append("同一环节查询到不唯一的配置信息,查询表：ALM_WORKFLOW；查询条件为【");
				sb.append("processKey:" + processKey + ",");
				sb.append("taskName:" + taskName);
				sb.append("】");
				sb.append("SQL:" + sql.toString());
				log.error(sb);	
				throw new Exception(sb.toString());
			}
		}
		sql = new String();
		sql = "select o from BOAlmStakeholder o where o.processKey=:processKey and o.linkId=:linkId and o.linkNo=:linkNo and o.objId=:objId and objType=:objType and o.stdholdeType=:stdholdeType";
		param.clear();
		param.put("processKey", processKey);
		param.put("linkId", boAlmWorkflows.get(0).getLinkId());
		param.put("linkNo", boAlmWorkflows.get(0).getLinkNo());
		param.put("objId", Long.valueOf(objId));
		param.put("objType", objType);
		param.put("stdholdeType", WorkflowStaticDef.STAKEHOLDERTYPE_WF);
		List<BOAlmStakeholder> boAlmStakeholders = commonDAO.findByJPAQL(sql, param);
		if(boAlmStakeholders.size() != 1){
			if (log.isErrorEnabled()) {
				StringBuffer sb = new StringBuffer();
				sb.append("人工前置任务查询当前环节干系人出错,干系人查询结果不唯一或未查到干系人；查询条件为【");
				sb.append("processKey:" + processKey + ",");
				sb.append("linkId:" + boAlmWorkflows.get(0).getLinkId() + ",");
				sb.append("linkNo:" + boAlmWorkflows.get(0).getLinkNo() + ",");
				sb.append("objId:" + Long.parseLong(objId) + ",");
				sb.append("objType:" + objType + ",");
				sb.append("stdholdeType:" + WorkflowStaticDef.STAKEHOLDERTYPE_WF);
				sb.append("】");
				sb.append("SQL:" + sql.toString());
				log.error(sb);
				throw new Exception(sb.toString());
			}
		}

		BOAlmWorkorder almWorkorder = new BOAlmWorkorder();
		almWorkorder.setDeployId(deployId);
		almWorkorder.setParentOrderId(Long.valueOf(WorkflowStaticDef.WO_NO_PARENT));
		String plantime = (String)taskService.getVariable(String.valueOf(taskId), "plantime");
		almWorkorder.setPlantimeTemp(plantime);
		//查询上一条工单ID
		BOAlmWorkorder lastWorkorder = null;
		BOAlmWorkorder lastWorkorder1 = null;
		
		WorkorderBO workorderBO = almWorkorderSV.getLastWorkorderByObjIdAndObjType(Long.valueOf(objId),objType);
		lastWorkorder = WorkorderMapper.INSTANCE.boToDomain(workorderBO);
		if(lastWorkorder != null){
				//如果当前环节为前一个环节回退后流转到此处
				if("N".equals(lastWorkorder.getResult())){
					workorderBO = almWorkorderSV.getFristWorkorderByObjIdAndObjTypeAndLinkNo(Long.valueOf(objId),objType, taskName);
					lastWorkorder1 = WorkorderMapper.INSTANCE.boToDomain(workorderBO);
					if(lastWorkorder1 != null){
						//woValue.setLastOrderId(lastWorkorder.getOrderId());
						almWorkorder.setLastOrderId(lastWorkorder1.getLastOrderId());
					}else{
						almWorkorder.setLastOrderId(lastWorkorder.getLastOrderId());
					}
				}
				//当前环节的前一个环节正常向下流转
				else{
					workorderBO = almWorkorderSV.getLastWorkorderByObjIdAndObjType(Long.valueOf(objId),objType);
					lastWorkorder = WorkorderMapper.INSTANCE.boToDomain(workorderBO);
					if(lastWorkorder != null){
						almWorkorder.setLastOrderId(lastWorkorder.getOrderId());
					}
				}
		}
		almWorkorder.setActTaskId(taskId);
		almWorkorder.setParentActTaskId(Long.valueOf(WorkflowStaticDef.WO_NO_PARENT_VM_TASK_ID));
		almWorkorder.setLastActTaskId(Long.valueOf(WorkflowStaticDef.WO_NO_LAST_VM_TASK_ID));
		almWorkorder.setLinkId(boAlmWorkflows.get(0).getLinkId());
		almWorkorder.setIsCurrentTask(WorkflowStaticDef.IS_CURRENT_TASK);
		almWorkorder.setOrderType(WorkflowStaticDef.STAKEHOLDERTYPE_WF);
		almWorkorder.setObjId(Long.parseLong(objId));
		almWorkorder.setObjType(objType);
		almWorkorder.setDealType(WorkflowStaticDef.WO_DEAL_TYPE_APPROVE);
		almWorkorder.setIsLock(Long.valueOf(WorkflowStaticDef.NO_LOCK));
		almWorkorder.setProcInstId(procInstId);
		
		Long isPrint = boAlmWorkflows.get(0).getIsPrint();
		if(isPrint==null)
			isPrint = 0l;
		
		if(!"".equals(boAlmStakeholders.get(0).getRoleCode()) && "".equals(boAlmStakeholders.get(0).getStdholderStaffNo())){
			almWorkorder.setFinishPrint(Long.valueOf(WorkflowStaticDef.NO_FINISH_PRINT));
		}else{
			if(isPrint==WorkflowStaticDef.PRINT)
				almWorkorder.setFinishPrint(Long.valueOf(WorkflowStaticDef.NO_FINISH_PRINT));
			if(isPrint==WorkflowStaticDef.NO_PRINT)
				almWorkorder.setFinishPrint(Long.valueOf(WorkflowStaticDef.NOT_NEED_PRINT));
		}
		almWorkorder.setExecRoleId(boAlmStakeholders.get(0).getRoleId());
		almWorkorder.setExecStaffId(boAlmStakeholders.get(0).getStdholderStaffId());
		//***
		//工单加锁代码 为解决
		//****
		if(!"".equals(boAlmStakeholders.get(0).getRoleCode()) && "".equals(boAlmStakeholders.get(0).getStdholderStaffNo())){
			almWorkorder.setStatus(WorkflowStaticDef.WO_STATUS_CREATE);
		}else{
			if(isPrint==WorkflowStaticDef.PRINT)
				almWorkorder.setStatus(WorkflowStaticDef.WO_STATUS_CREATE);
			if(isPrint==WorkflowStaticDef.NO_PRINT )
				almWorkorder.setStatus(WorkflowStaticDef.WO_STATUS_RECEIVE);
		}
		almWorkorder.setCreatTime(new Date());
		if(!"".equals(boAlmStakeholders.get(0).getRoleCode()) && "".equals(boAlmStakeholders.get(0).getStdholderStaffNo())){
			
		}else{
			if(isPrint==WorkflowStaticDef.NO_PRINT){
				almWorkorder.setRecvTime(new Date());
				almWorkorder.setExecTime(new Date());
			}
		}
		commonDAO.save(almWorkorder);
		//将干系人信息移到干系人历史表中
		StakeholderBO stakeholderBO = StakeholderMapper.INSTANCE.domainToBo(boAlmStakeholders.get(0));
		almHisStakeholderSV.copyHisStakeholderByStakeholder(stakeholderBO);
		
		list.add(almWorkorder.getOrderId());
		list.add(boAlmWorkflows.get(0).getLinkId());
		
		return list;
	}
	//人工环节后置任务
	@SuppressWarnings("unchecked")
	public List userRearTask(long deployId, String processKey, long taskId, String objId, String objType) throws Exception
	{
		List list = new ArrayList();
		String sql = new String();
		Map<String, Object> param = new HashMap<String, Object>();
		sql = "select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.actTaskId=:actTaskId and o.orderType=:orderType and o.isCurrentTask=:isCurrentTask";
		param.put("objId",Long.valueOf(objId));
		param.put("objType",objType);
		param.put("actTaskId",taskId);
		param.put("orderType",WorkflowStaticDef.STAKEHOLDERTYPE_WF);
		param.put("isCurrentTask",WorkflowStaticDef.IS_CURRENT_TASK);

		List<BOAlmWorkorder> almWorkorders = commonDAO.findByJPAQL(sql.toString(), param);
		if(almWorkorders!=null && almWorkorders.size() != 1){
			if (log.isErrorEnabled()) {
				StringBuffer sb = new StringBuffer();
				sb.append("查询人工任务当前待处理工单时出错,查询结果不唯一。查询表：ALM_WORKORDER；查询条件为【");
				sb.append("objId:" + Long.parseLong(objId) + ",");
				sb.append("objType:" + objType + ",");
				sb.append("actTaskId:" + taskId + ",");
				sb.append("orderType:" + WorkflowStaticDef.STAKEHOLDERTYPE_WF + ",");
				sb.append("isCurrentTask:" + WorkflowStaticDef.IS_CURRENT_TASK);
				sb.append("】");
				sb.append("SQL:" + sql.toString());
				log.error(sb);
				throw new Exception(sb.toString());
			}
		}
		BOAlmWorkorder almWorkorder = almWorkorders.get(0);
		if(almWorkorder.getIsLock()!=null&&almWorkorder.getIsLock()==WorkflowStaticDef.LOCK){
			throw new Exception("当前工单已被锁定，请先解除锁定！");
		}
		
		if(almWorkorder.getFinishPrint()!=null&&almWorkorder.getFinishPrint()==WorkflowStaticDef.NO_FINISH_PRINT){
			throw new Exception("当前工单需要先进行打单！");
		}
		long exeTime = 0;
		if(almWorkorder.getExecTimes()!=null)
			exeTime = almWorkorder.getExecTimes();
		almWorkorder.setExecTimes(exeTime + new Date().getTime()-almWorkorder.getExecTime().getTime());
		almWorkorder.setFinishTime(new Date());
		almWorkorder.setStatus(WorkflowStaticDef.WO_STATUS_COMPLETE);
		almWorkorder.setIsCurrentTask(WorkflowStaticDef.IS_NOT_CURRENT_TASK);
		
		String result = (String)taskService.getVariable(String.valueOf(taskId), "result");
		String cond = (String)taskService.getVariable(String.valueOf(taskId), "cond");
		String reason = (String)taskService.getVariable(String.valueOf(taskId), "reason");
		if(result==null){
			if(log.isInfoEnabled()){
				log.info("未能从task中获取变量值,变量:result");
			}
			result = "";
		}
		if(cond==null){
			if(log.isInfoEnabled()){
				log.info("未能从task中获取变量值,变量:cond");
			}
			cond = "<conds></conds>";
		}
		if(reason==null){
			if(log.isInfoEnabled()){
				log.info("未能从task中获取变量值,变量:reason");
			}
			reason = "";
		}
		
		almWorkorder.setResult(result);
		almWorkorder.setCond(cond);
		almWorkorder.setOpinion(reason);
		commonDAO.save(almWorkorder);
		
		list.add(almWorkorder.getOrderId());
		return list;
	}
	
	//会签前置任务
	@SuppressWarnings("unchecked")
	public List signPreTask(long deployId, String processKey,long procInstId, long taskId, String taskName, String objId, String objType)
			throws Exception {
		List list = null;
		try{
			String staffId = taskService.getVariable(String.valueOf(taskId), "staffId").toString();
			String sql = new String();
			Map<String, Object> param = new HashMap<String, Object>();
			sql = "select o from BOAlmWorkflow o where o.processKey=:processKey and o.linkNo = :linkNo";
			param.put("processKey", processKey);
			param.put("linkNo", taskName);
			List<BOAlmWorkflow> almWorkflows =  commonDAO.findByJPAQL(sql, param,true);
			if(almWorkflows==null||almWorkflows.size() != 1){
				if (log.isErrorEnabled()) {
					StringBuffer sb = new StringBuffer();
					sb.append("同一环节查询到不唯一的配置信息,查询表：ALM_WORKFLOW；查询条件为【");
					sb.append("processKey:" + processKey + ",");
					sb.append("linkNo:" + taskName);
					sb.append("】");
					sb.append("SQL:" + sql.toString());
					log.error(sb);	
					throw new Exception(sb.toString());
				}
			}
			sql = new String();
			param = new HashMap();
			sql = "select o from BOAlmStakeholder o where o.processKey=:processKey and o.linkId=:linkId and o.linkNo=:linkNo and o.objId=:objId and o.objType=:objType and o.stdholdeType=:stdholdeType and o.stdholderStaffId=:stdholderStaffId";
			param.put("processKey",processKey);
			param.put("linkId", almWorkflows.get(0).getLinkId());
			param.put("linkNo", almWorkflows.get(0).getLinkNo());
			param.put("objId", Long.valueOf(objId));
			param.put("objType", objType);
			param.put("stdholdeType", WorkflowStaticDef.STAKEHOLDERTYPE_WF);
			param.put("stdholderStaffId", Long.valueOf(staffId));
			List<BOAlmStakeholder> almStakeholders = commonDAO.findByJPAQL(sql,param);
			if(almStakeholders==null||almStakeholders.size() != 1){
				if (log.isErrorEnabled()) {
					StringBuffer sb = new StringBuffer();
					sb.append("人工前置任务查询当前环节干系人出错,干系人查询结果未查到干系人；查询条件为【");
					sb.append("processKey:" + processKey + ",");
					sb.append("linkId:" + almWorkflows.get(0).getLinkId() + ",");
					sb.append("linkNo:" + almWorkflows.get(0).getLinkNo() + ",");
					sb.append("objId:" + Long.parseLong(objId) + ",");
					sb.append("objType:" + objType + ",");
					sb.append("stdholdeType:" + WorkflowStaticDef.STAKEHOLDERTYPE_WF);
					sb.append("】");
					sb.append("SQL:" + sql.toString());
					log.error(sb);	
					throw new Exception(sb.toString());
				}
			}
			
			BOAlmStakeholder almStakeholder = almStakeholders.get(0);
			Long isPrint = almWorkflows.get(0).getIsPrint();
			if(isPrint==null)
				isPrint = 0l;
			//生成会签子工单
			
			BOAlmWorkorder iWorkOrderValue = new BOAlmWorkorder();
			iWorkOrderValue.setDeployId(deployId);
			String plantime = (String)taskService.getVariable(String.valueOf(taskId), "plantime");
			iWorkOrderValue.setPlantimeTemp(plantime);
			iWorkOrderValue.setParentOrderId(Long.valueOf(WorkflowStaticDef.WO_NO_PARENT));
			iWorkOrderValue.setActTaskId(taskId);
			iWorkOrderValue.setParentActTaskId(Long.valueOf(WorkflowStaticDef.WO_NO_PARENT_VM_TASK_ID));
			iWorkOrderValue.setLastActTaskId(Long.valueOf(WorkflowStaticDef.WO_NO_LAST_VM_TASK_ID));
			iWorkOrderValue.setLinkId(almWorkflows.get(0).getLinkId());
			iWorkOrderValue.setIsCurrentTask(WorkflowStaticDef.IS_CURRENT_TASK);
			iWorkOrderValue.setOrderType(WorkflowStaticDef.STAKEHOLDERTYPE_WF);
			iWorkOrderValue.setObjId(Long.parseLong(objId));
			iWorkOrderValue.setObjType(objType);
			iWorkOrderValue.setDealType(WorkflowStaticDef.WO_DEAL_TYPE_APPROVE);
			iWorkOrderValue.setIsLock(Long.valueOf(WorkflowStaticDef.NO_LOCK));
			iWorkOrderValue.setProcInstId(procInstId);
			if(!"".equals(almStakeholder.getRoleCode()) && "".equals(almStakeholder.getStdholderStaffNo())){
				if (log.isErrorEnabled()) {
					StringBuffer sb = new StringBuffer();
					sb.append("会签环节不能使用角色！");
					log.error(sb);	
					throw new Exception(sb.toString());
				}
			}else{
				if(isPrint==WorkflowStaticDef.PRINT)
					iWorkOrderValue.setFinishPrint(Long.valueOf(WorkflowStaticDef.NO_FINISH_PRINT));
				if(isPrint==WorkflowStaticDef.NO_PRINT)
					iWorkOrderValue.setFinishPrint(Long.valueOf(WorkflowStaticDef.NOT_NEED_PRINT));
			}
			iWorkOrderValue.setExecRoleId(almStakeholder.getRoleId());
			iWorkOrderValue.setExecStaffId(almStakeholder.getStdholderStaffId());
			//***
			//工单加锁代码 为解决
			//****
			if(isPrint==WorkflowStaticDef.PRINT)
				iWorkOrderValue.setStatus(WorkflowStaticDef.WO_STATUS_CREATE);
			if(isPrint==WorkflowStaticDef.NO_PRINT)
				iWorkOrderValue.setStatus(WorkflowStaticDef.WO_STATUS_RECEIVE);
			iWorkOrderValue.setCreatTime(new Date());
			if(isPrint==WorkflowStaticDef.NO_PRINT){
				iWorkOrderValue.setRecvTime(new Date());
				iWorkOrderValue.setExecTime(new Date());
			}
			commonDAO.save(iWorkOrderValue);
			//将干系人信息移到干系人历史表中
			StakeholderBO stakeholderBO = StakeholderMapper.INSTANCE.domainToBo(almStakeholder);
			almHisStakeholderSV.copyHisStakeholderByStakeholder(stakeholderBO);
			
			list = new ArrayList();
			list.add(iWorkOrderValue.getOrderId());
			list.add(almWorkflows.get(0).getLinkId());
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	
	//会签后置任务
	@SuppressWarnings("unchecked")
	public List signRearTask(long deployId, String processKey, long taskId, String objId, String objType)throws Exception {
		List list = null;
		try{
			String sql = new String();
			Map<String, Object> param = new HashMap<String, Object>();
			sql = "select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.actTaskId=:actTaskId and o.orderType=:orderType and o.isCurrentTask=:isCurrentTask";
			param.put("objId",Long.valueOf(objId));
			param.put("objType",objType);
			param.put("actTaskId",taskId);
			param.put("orderType",WorkflowStaticDef.STAKEHOLDERTYPE_WF);
			param.put("isCurrentTask",WorkflowStaticDef.IS_CURRENT_TASK);

			List<BOAlmWorkorder> almWorkorders = commonDAO.findByJPAQL(sql.toString(), param);
			if(almWorkorders!=null && almWorkorders.size() != 1){
				if (log.isErrorEnabled()) {
					StringBuffer sb = new StringBuffer();
					sb.append("查询人工任务当前待处理工单时出错,查询结果不唯一。查询表：ALM_WORKORDER；查询条件为【");
					sb.append("objId:" + Long.parseLong(objId) + ",");
					sb.append("objType:" + objType + ",");
					sb.append("actTaskId:" + taskId + ",");
					sb.append("orderType:" + WorkflowStaticDef.STAKEHOLDERTYPE_WF + ",");
					sb.append("isCurrentTask:" + WorkflowStaticDef.IS_CURRENT_TASK);
					sb.append("】");
					sb.append("SQL:" + sql.toString());
					log.error(sb);
					throw new Exception(sb.toString());
				}
			}
			
			BOAlmWorkorder almWorkorder = almWorkorders.get(0);
			
			long exeTime = 0;
			if(almWorkorder.getExecTimes()!=null)
				exeTime = almWorkorder.getExecTimes();
			almWorkorder.setExecTimes(exeTime + new Date().getTime()-almWorkorder.getExecTime().getTime());
			almWorkorder.setFinishTime(new Date());
			almWorkorder.setStatus(WorkflowStaticDef.WO_STATUS_COMPLETE);
			almWorkorder.setIsCurrentTask(WorkflowStaticDef.IS_NOT_CURRENT_TASK);
			
			String result = (String)taskService.getVariable(String.valueOf(taskId), "result");
			String cond = (String)taskService.getVariable(String.valueOf(taskId), "cond");
			String reason = (String)taskService.getVariable(String.valueOf(taskId), "reason");
			if(result==null){
				if(log.isInfoEnabled()){
					log.info("未能从task中获取变量值,变量:result");
				}
				result = "";
			}
			if(cond==null){
				if(log.isInfoEnabled()){
					log.info("未能从task中获取变量值,变量:cond");
				}
				cond = "<conds></conds>";
			}
			if(reason==null){
				if(log.isInfoEnabled()){
					log.info("未能从task中获取变量值,变量:reason");
				}
				reason = "";
			}
			
			almWorkorder.setResult(result);
			almWorkorder.setCond(cond);
			almWorkorder.setOpinion(reason);
			commonDAO.save(almWorkorder);
			list = new ArrayList();
			list.add(almWorkorder.getOrderId());
		}catch(Exception e){
			throw e;
		}
		return list;
	}
	
	//流程结束环节任务
	//目的将所有工单移至历史表中
	@SuppressWarnings("unchecked")
	public List finishTask(long deployId, String processKey,long procInstId, String objId, String objType) throws Exception{
		BOAlmWorkflow boAlmWorkflow =null;
		List list = new ArrayList();
		String sql = new String();
		Map<String, Object> param = new HashMap<String, Object>();
		sql = "select o from BOAlmWorkflow o where o.processKey=:processKey and o.linkNoType=:linkNoType";
		param.put("processKey", processKey);
		param.put("linkNoType", WorkflowStaticDef.LINK_NO_TYPE_END);
		List<BOAlmWorkflow> boAlmWorkflows =  commonDAO.findByJPAQL(sql,param,true);
		if(boAlmWorkflows==null|| boAlmWorkflows.size() != 1){
			//经分，boss，电渠流程结束特殊处理
//			if(boAlmWorkflows.size() == 2 && (processKey.equals(ConstDefine.TEMPLATE_KEY_WORKFLOW_REQ)
//				||processKey.equals(ConstDefine.TEMPLATE_KEY_WORKFLOW_BAREQ)
//				||processKey.equals(ConstDefine.TEMPLATE_KEY_WORKFLOW_ELCCHANEL))){
//			}else	
			if (log.isErrorEnabled()) {
				StringBuffer sb = new StringBuffer();
				sb.append("同一环节查询到不唯一的配置信息,查询表：ALM_WORKFLOW；查询条件为【");
				sb.append("processKey:" + processKey + ",");
				sb.append("linkNoType:" +  WorkflowStaticDef.LINK_NO_TYPE_END);
				sb.append("】");
				sb.append("SQL:" + sql.toString());
				log.error(sb);	
				throw new Exception(sb.toString());
			}
		}
		///////////////////////////////////////////////
		BOAlmWorkorder almWorkorder = new BOAlmWorkorder();
		almWorkorder.setDeployId(deployId);
		almWorkorder.setParentOrderId(Long.valueOf(WorkflowStaticDef.WO_NO_PARENT));
		//查询上一条工单ID
		BOAlmWorkorder lastWorkorder = null;
		BOAlmWorkorder lastWorkorder1 = null;
		WorkorderBO workorderBO = almWorkorderSV.getLastWorkorderByObjIdAndObjType(Long.valueOf(objId),objType);
		lastWorkorder = WorkorderMapper.INSTANCE.boToDomain(workorderBO);
		boAlmWorkflow=boAlmWorkflows.get(0);
		//经分，boss，电渠流程结束特殊处理getLastWorkorderByObjIdAndObjTypeNew
//		if(processKey.equals(ConstDefine.TEMPLATE_KEY_WORKFLOW_REQ)
//				|| processKey.equals(ConstDefine.TEMPLATE_KEY_WORKFLOW_BAREQ)
//				|| processKey.equals(ConstDefine.TEMPLATE_KEY_WORKFLOW_ELCCHANEL)){
//			WorkorderBO workorderBONew = almWorkorderSV.getLastWorkorderByObjIdAndObjTypeNew(Long.valueOf(objId),objType);
//			BOAlmWorkorder lastWorkorderNew = WorkorderMapper.INSTANCE.boToDomain(workorderBONew);
//			if(lastWorkorderNew != null){
//				if(lastWorkorderNew.getLinkId()==Long.parseLong(""+BAreqProcessTemplates.LINK_220_ID) 
//						||lastWorkorderNew.getLinkId()==Long.parseLong(""+ReqProcessTemplates.LINK_122_ID)
//						||lastWorkorderNew.getLinkId()==24L){
//					for(BOAlmWorkflow workflow:boAlmWorkflows){
//						if(workflow.getLinkId()==Long.parseLong(""+BAreqProcessTemplates.LINK_222_ID) 
//								||workflow.getLinkId()==Long.parseLong(""+ReqProcessTemplates.LINK_199_ID)
//								||workflow.getLinkId()==27L){
//							boAlmWorkflow=workflow;
//						}
//					}
//					
//				}
//			}
//			 
//		}
		if(lastWorkorder != null){
				//如果当前环节为前一个环节回退后流转到此处
				if("N".equals(lastWorkorder.getResult())){
					workorderBO = almWorkorderSV.getFristWorkorderByObjIdAndObjTypeAndLinkNo(Long.valueOf(objId),objType, boAlmWorkflow.getLinkNo());
					lastWorkorder1 = WorkorderMapper.INSTANCE.boToDomain(workorderBO);
					if(lastWorkorder1 != null){
						//woValue.setLastOrderId(lastWorkorder.getOrderId());
						almWorkorder.setLastOrderId(lastWorkorder1.getLastOrderId());
					}else{
						almWorkorder.setLastOrderId(lastWorkorder.getLastOrderId());
					}
				}
				//当前环节的前一个环节正常向下流转
				else{
					workorderBO = almWorkorderSV.getLastWorkorderByObjIdAndObjType(Long.valueOf(objId),objType);
					lastWorkorder = WorkorderMapper.INSTANCE.boToDomain(workorderBO);
					if(lastWorkorder != null){
						almWorkorder.setLastOrderId(lastWorkorder.getOrderId());
					}
				}
		}
		almWorkorder.setActTaskId(Long.valueOf(WorkflowStaticDef.WO_NO_VM_TASK_ID));
		almWorkorder.setParentActTaskId(Long.valueOf(WorkflowStaticDef.WO_NO_PARENT_VM_TASK_ID));
		almWorkorder.setLastActTaskId(Long.valueOf(WorkflowStaticDef.WO_NO_LAST_VM_TASK_ID));
		almWorkorder.setLinkId(boAlmWorkflow.getLinkId());
		almWorkorder.setIsCurrentTask(WorkflowStaticDef.IS_NOT_CURRENT_TASK);
		almWorkorder.setOrderType(WorkflowStaticDef.STAKEHOLDERTYPE_WF);
		almWorkorder.setObjId(Long.parseLong(objId));
		almWorkorder.setObjType(objType);
		almWorkorder.setDealType(WorkflowStaticDef.WO_DEAL_TYPE_APPROVE);
		almWorkorder.setIsLock(Long.valueOf(WorkflowStaticDef.NO_LOCK));
		almWorkorder.setFinishPrint(Long.valueOf(WorkflowStaticDef.NO_PRINT));
		almWorkorder.setExecStaffId(WorkflowStaticDef.ADMIN_ID);
		almWorkorder.setStatus(WorkflowStaticDef.WO_STATUS_COMPLETE);
		almWorkorder.setCreatTime(new Date());
		almWorkorder.setRecvTime(new Date());
		almWorkorder.setExecTime(new Date());
		almWorkorder.setFinishTime(new Date());
		almWorkorder.setExecTimes(0l);
		almWorkorder.setProcInstId(procInstId);
		commonDAO.save(almWorkorder);
		//////////////////////////////////////////////
		
		
		
		sql = new String();
		param = new HashMap();
		sql = "select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.orderType=:orderType and o.isCurrentTask=:isCurrentTask";
		param.put("objId", Long.parseLong(objId));
		param.put("objType", objType);
		param.put("orderType", WorkflowStaticDef.STAKEHOLDERTYPE_WF);
		param.put("isCurrentTask", WorkflowStaticDef.IS_CURRENT_TASK);

		List<BOAlmWorkorder> boAlmWorkorders = commonDAO.findByJPAQL(sql,param);
		if(boAlmWorkorders==null||boAlmWorkorders.size() > 0){
			if (log.isErrorEnabled()) {
				StringBuffer sb = new StringBuffer();
				sb.append("存在待处理工单，不能将工单移至工单历史表。查询表：ALM_WORKORDER；查询条件为【");
				sb.append("objId:" + Long.parseLong(objId) + ",");
				sb.append("objType:" + objType + ",");
				sb.append("orderType:" + WorkflowStaticDef.IS_CURRENT_TASK + ",");
				sb.append("】");
				sb.append("SQL:" + sql.toString());
				log.error(sb);
				throw new Exception(sb.toString());
			}
		}
		
		sql = new String();
		param = new HashMap();
		//管理工单无WorkflowId
		sql = "select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.orderType=:orderType";
		param.put("objId", Long.parseLong(objId));
		param.put("objType", objType);
		param.put("orderType", WorkflowStaticDef.STAKEHOLDERTYPE_WF);

		boAlmWorkorders = commonDAO.findByJPAQL(sql,param);
		for(BOAlmWorkorder boAlmWorkorder : boAlmWorkorders){
			//将工单copy到工单历史表中
			workorderBO = WorkorderMapper.INSTANCE.domainToBo(boAlmWorkorder);
			almHisWorkorderSV.capyHisWorkorderByWorkorder(workorderBO);
			//删除工单表中工单
			commonDAO.delete(boAlmWorkorder);
		}
		
		sql = new String();
		sql = "select o from BOAlmStakeholder o where o.objId=:objId and o.objType=:objType";
		param = new HashMap();
		param.put("objId", Long.valueOf(objId));
		param.put("objType", objType);
		List<BOAlmStakeholder> almStakeholders = commonDAO.findByJPAQL(sql, param);
		for(BOAlmStakeholder almStakeholder : almStakeholders){
			commonDAO.delete(almStakeholder);
		}
		
		list.add(boAlmWorkflow.getLinkId());
		return list;
	}
	
	//流程结束环节任务 此方法需要人为制定工作流完成时 业务对象当前环节编号
	//目的将所有工单移至历史表中
	@SuppressWarnings("unchecked")
	public List finishTask(long deployId, String processKey,long procInstId, String objId, String objType, String linkNo) throws Exception{
		List list = new ArrayList();
		String sql = new String();
		Map<String, Object> param = new HashMap<String, Object>();
		sql = "select o from BOAlmWorkflow o where o.processKey=:processKey and o.linkNoType=:linkNoType and o.linkNo=:linkNo";
		param.put("processKey", processKey);
		param.put("linkNoType", WorkflowStaticDef.LINK_NO_TYPE_END);
		param.put("linkNo", linkNo);
		List<BOAlmWorkflow> boAlmWorkflows =  commonDAO.findByJPAQL(sql,param,true);
		if(boAlmWorkflows==null||boAlmWorkflows.size() != 1){
			if (log.isErrorEnabled()) {
				StringBuffer sb = new StringBuffer();
				sb.append("同一环节查询到不唯一的配置信息,查询表：ALM_WORKFLOW；查询条件为【");
				sb.append("processKey:" + processKey + ",");
				sb.append("linkNoType:" +  WorkflowStaticDef.LINK_NO_TYPE_END);
				sb.append("】");
				sb.append("SQL:" + sql.toString());
				log.error(sb);	
				throw new Exception(sb.toString());
			}
		}
		///////////////////////////////////////////////
		BOAlmWorkorder almWorkorder = new BOAlmWorkorder();
		almWorkorder.setDeployId(deployId);
		almWorkorder.setParentOrderId(Long.valueOf(WorkflowStaticDef.WO_NO_PARENT));
		//查询上一条工单ID
		BOAlmWorkorder lastWorkorder = null;
		BOAlmWorkorder lastWorkorder1=null;
		WorkorderBO workorderBO = almWorkorderSV.getLastWorkorderByObjIdAndObjType(Long.valueOf(objId),objType);
		lastWorkorder = WorkorderMapper.INSTANCE.boToDomain(workorderBO);
		if(lastWorkorder != null){
				//如果当前环节为前一个环节回退后流转到此处
				if("N".equals(lastWorkorder.getResult())){
					workorderBO = almWorkorderSV.getFristWorkorderByObjIdAndObjTypeAndLinkNo(Long.valueOf(objId),objType, boAlmWorkflows.get(0).getLinkNo());
					lastWorkorder1 = WorkorderMapper.INSTANCE.boToDomain(workorderBO);
					if(lastWorkorder1 != null){
						//woValue.setLastOrderId(lastWorkorder.getOrderId());
						almWorkorder.setLastOrderId(lastWorkorder1.getLastOrderId());
					}else{
						almWorkorder.setLastOrderId(lastWorkorder.getLastOrderId());
					}
				}
				//当前环节的前一个环节正常向下流转
				else{
					workorderBO = almWorkorderSV.getLastWorkorderByObjIdAndObjType(Long.valueOf(objId),objType);
					lastWorkorder = WorkorderMapper.INSTANCE.boToDomain(workorderBO);
					if(lastWorkorder != null){
						almWorkorder.setLastOrderId(lastWorkorder.getOrderId());
					}
				}
		}
		almWorkorder.setActTaskId(Long.valueOf(WorkflowStaticDef.WO_NO_VM_TASK_ID));
		almWorkorder.setParentActTaskId(Long.valueOf(WorkflowStaticDef.WO_NO_PARENT_VM_TASK_ID));
		almWorkorder.setLastActTaskId(Long.valueOf(WorkflowStaticDef.WO_NO_LAST_VM_TASK_ID));
		almWorkorder.setLinkId(boAlmWorkflows.get(0).getLinkId());
		almWorkorder.setIsCurrentTask(WorkflowStaticDef.IS_NOT_CURRENT_TASK);
		almWorkorder.setOrderType(WorkflowStaticDef.STAKEHOLDERTYPE_WF);
		almWorkorder.setObjId(Long.parseLong(objId));
		almWorkorder.setObjType(objType);
		almWorkorder.setDealType(WorkflowStaticDef.WO_DEAL_TYPE_APPROVE);
		almWorkorder.setIsLock(Long.valueOf(WorkflowStaticDef.NO_LOCK));
		almWorkorder.setFinishPrint(Long.valueOf(WorkflowStaticDef.NO_PRINT));
		almWorkorder.setExecStaffId(WorkflowStaticDef.ADMIN_ID);
		almWorkorder.setStatus(WorkflowStaticDef.WO_STATUS_COMPLETE);
		almWorkorder.setCreatTime(new Date());
		almWorkorder.setRecvTime(new Date());
		almWorkorder.setExecTime(new Date());
		almWorkorder.setFinishTime(new Date());
		almWorkorder.setExecTimes(0l);
		almWorkorder.setProcInstId(procInstId);
		commonDAO.save(almWorkorder);
		//////////////////////////////////////////////
		
		
		
		sql = new String();
		param = new HashMap();
		sql = "select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.orderType=:orderType and o.isCurrentTask=:isCurrentTask";
		param.put("objId", Long.parseLong(objId));
		param.put("objType", objType);
		param.put("orderType", WorkflowStaticDef.STAKEHOLDERTYPE_WF);
		param.put("isCurrentTask", WorkflowStaticDef.IS_CURRENT_TASK);

		List<BOAlmWorkorder> boAlmWorkorders = commonDAO.findByJPAQL(sql,param);
		if(boAlmWorkorders==null||boAlmWorkorders.size() > 0){
			if (log.isErrorEnabled()) {
				StringBuffer sb = new StringBuffer();
				sb.append("存在待处理工单，不能将工单移至工单历史表。查询表：ALM_WORKORDER；查询条件为【");
				sb.append("deployId:" + deployId + ",");
				sb.append("objId:" + Long.parseLong(objId) + ",");
				sb.append("objType:" + objType + ",");
				sb.append("orderType:" + WorkflowStaticDef.IS_CURRENT_TASK + ",");
				sb.append("】");
				sb.append("SQL:" + sql.toString());
				log.error(sb);
				throw new Exception(sb.toString());
			}
		}
		
		sql = new String();
		param = new HashMap();
		//管理工单无WorkflowId
		sql = "select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.orderType=:orderType";
		param.put("objId", Long.parseLong(objId));
		param.put("objType", objType);
		param.put("orderType", WorkflowStaticDef.STAKEHOLDERTYPE_WF);

		boAlmWorkorders = commonDAO.findByJPAQL(sql,param);
		for(BOAlmWorkorder boAlmWorkorder : boAlmWorkorders){
			//将工单copy到工单历史表中
			workorderBO = WorkorderMapper.INSTANCE.domainToBo(boAlmWorkorder);
			almHisWorkorderSV.capyHisWorkorderByWorkorder(workorderBO);
			//删除工单表中工单
			commonDAO.delete(boAlmWorkorder);
		}
		
		sql = new String();
		sql = "select o from BOAlmStakeholder o where o.objId=:objId and o.objType=:objType";
		param = new HashMap();
		param.put("objId", Long.valueOf(objId));
		param.put("objType", objType);
		List<BOAlmStakeholder> almStakeholders = commonDAO.findByJPAQL(sql, param);
		for(BOAlmStakeholder almStakeholder : almStakeholders){
			commonDAO.delete(almStakeholder);
		}
		list.add(boAlmWorkflows.get(0).getLinkId());
		return list;
	}
	
}
