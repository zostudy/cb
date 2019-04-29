package com.asiainfo.rms.workflow.service.driving.impl;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.asiainfo.rms.workflow.common.workflow.WorkflowStaticDef;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.driving.BOAlmTopoRule;
import com.asiainfo.rms.workflow.domain.driving.BOAlmTopology;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmWorkorder;
import com.asiainfo.rms.workflow.domain.driving.BOAlmTopoCon;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmWorkflow;
import com.asiainfo.rms.workflow.service.driving.IAlmProcessDrivingSV;
import com.asiainfo.rms.workflow.service.process.common.IAlmProcessRoamSV;
import com.asiainfo.rms.workflow.util.ApplicationContextUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


/**
 * 
 * @author 刘超
 * @version 1.4
 *
 */
@Service("processDrivingSV")
@SuppressWarnings("unchecked")
@Transactional(rollbackOn = Exception.class)
public class AlmProcessDrivingSVImpl implements IAlmProcessDrivingSV {
	
	private final static transient Log log = LogFactory.getLog(AlmProcessDrivingSVImpl.class);

	@Resource(name="processRoamSV") @Lazy
	private IAlmProcessRoamSV almProcessRoamSV;
	
	@Resource(name="commonDao")
	private CommonDAO commonDAO;
	
	@Override
	public void drivFun(Long objId,String objType,Long linkId,String cond) throws Exception {
		String sql = "select o from BOAlmWorkflow o where o.linkId=:linkId";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("linkId", linkId);
		List<BOAlmWorkflow> almWorkflows = commonDAO.findByJPAQL(sql,param,true);
		if(almWorkflows==null||almWorkflows.size()!=1){
			if (log.isErrorEnabled()) {
				StringBuffer sb = new StringBuffer();
				sb.append("查询环节信息出错，查询条件:");
				sb.append("linkId:" + linkId + ",");
				sb.append("，");
				sb.append("SQL:" + sql.toString());
				log.error(sb);
				throw new Exception(sb.toString());
			}
		}
		
		if(WorkflowStaticDef.LINK_NO_TYPE_SIGN.equals(almWorkflows.get(0).getLinkNoType())){
			sql = "select o from BOAlmWorkorder o where o.linkId=:linkId and o.status=:status and o.objId=:objId and o.objType=:objType";
			param.clear();
			param.put("linkId", linkId);
			param.put("objId", objId);
			param.put("objType", objType);
			param.put("status", WorkflowStaticDef.WO_STATUS_RECEIVE);
			List<BOAlmWorkorder> signWorkorders = commonDAO.findByJPAQL(sql, param);
			if(signWorkorders!=null&&signWorkorders.size() != 0){
				return;
			}
		}
		BOAlmTopology topology = this.getTopoByFpointAndCond(String.valueOf(linkId),cond);
		if(topology!=null)
			if(topology.getDrivnos()!=null&&!"".equals(topology.getDrivnos().trim())){
				String[] drivnos = topology.getDrivnos().trim().split(",");
				for(String drivno : drivnos){
					String fun = topology.getDrivnoFun();
					int endIndex = fun.lastIndexOf(".");
					String beanName = fun.substring(0, endIndex);
					String methodName = fun.substring(endIndex+1);
					Object funCase = ApplicationContextUtil.getBean(beanName);
					Class<?> funClass = funCase.getClass();
					
					Class<?>[] parameterTypes = {Long.class,String.class,String.class,String.class};
					Object[] parameterValues = {objId,objType,topology.getNo(),drivno};
					Method method = funClass.getMethod(methodName, parameterTypes);
					
					BOAlmWorkorder[] linkWorkorders = (BOAlmWorkorder[])method.invoke(funCase, parameterValues);
					if(linkWorkorders!=null)
						for(BOAlmWorkorder linkWorkorder : linkWorkorders){
							sql = "select o from BOAlmTopoRule o where o.no=:no";
							param.clear();
							param.put("no", drivno);
							List<BOAlmTopoRule> topoRules = commonDAO.findByJPAQL(sql.toString(), param);
							if(topoRules==null||topoRules.size()!=1){
								if(log.isErrorEnabled()){
									StringBuffer buffer = new StringBuffer();
									buffer.append("查找AlmTopoRule信息出错,查询条件:");
									buffer.append("[no]="+drivno);
									buffer.append(",[sql]:"+sql);
									throw new Exception(buffer.toString());
								}
							}
							String topoConNo = topoRules.get(0).getTopoConNo();
							
							sql = "select o from BOAlmTopoCon o where o.no=:no";
							param.clear();
							param.put("no", topoConNo);
							List<BOAlmTopoCon> topoCons = commonDAO.findByJPAQL(sql.toString(), param);
							if(topoRules==null||topoRules.size()!=1){
								if(log.isErrorEnabled()){
									StringBuffer buffer = new StringBuffer();
									buffer.append("查找AlmTopoCon信息出错,查询条件:");
									buffer.append("[no]="+topoConNo);
									buffer.append(",[sql]:"+sql);
									throw new Exception(buffer.toString());
								}
							}
							if("".equals(linkWorkorder.getCond()) || null == linkWorkorder.getCond() ){
								almProcessRoamSV.finishUserTask(linkWorkorder.getOrderId(),"DRIV_WF", "", topoCons.get(0).getCond());
							}else{
								almProcessRoamSV.finishUserTask(linkWorkorder.getOrderId(),"DRIV_WF", "", linkWorkorder.getCond());
							}
						}
				}
			}
	}
	
	private BOAlmTopology getTopoByFpointAndCond(String fpointLinkId,
			String cond) throws Exception {
	
		BOAlmTopology topology = null;
		boolean equal = true;
		@SuppressWarnings("rawtypes")
		Map aVars = new HashMap();
		aVars = almProcessRoamSV.analyzeCond(aVars, cond);
		String sql = "select o from BOAlmTopology o where o.fpoint=:fpoint";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fpoint", Long.valueOf(fpointLinkId));
		List<BOAlmTopology> topologys = commonDAO.findByJPAQL(sql.toString(), param);
		//在topoView配置表中遍历 找到与入参cond一样的配置信息
		for (BOAlmTopology topo : topologys) {
			equal = true;
			sql = "select o from BOAlmTopoRule o where o.topoNo=:no";
			param.clear();
			param.put("no", topo.getNo());
			List<BOAlmTopoRule> topoRules = commonDAO.findByJPAQL(sql.toString(), param);
			if(topoRules==null||topoRules.size()!=1){
				if(log.isErrorEnabled()){
					StringBuffer buffer = new StringBuffer();
					buffer.append("查找AlmTopoRule信息出错,查询条件:");
					buffer.append("[topoNo]="+topo.getNo());
					buffer.append(",[sql]:"+sql);
					throw new Exception(buffer.toString());
				}
			}
			String topoConNo = topoRules.get(0).getTopoConNo();
			
			sql = "select o from BOAlmTopoCon o where o.no=:no";
			param.clear();
			param.put("no", topoConNo);
			List<BOAlmTopoCon> topoCons = commonDAO.findByJPAQL(sql.toString(), param);
			if(topoRules==null||topoRules.size()!=1){
				if(log.isErrorEnabled()){
					StringBuffer buffer = new StringBuffer();
					buffer.append("查找AlmTopoCon信息出错,查询条件:");
					buffer.append("[no]="+topoConNo);
					buffer.append(",[sql]:"+sql);
					throw new Exception(buffer.toString());
				}
			}
			@SuppressWarnings("rawtypes")
			Map aVarsTemp = new HashMap();
			aVarsTemp = almProcessRoamSV.analyzeCond(aVarsTemp, topoCons.get(0).getCond());
			
			for (Object key : aVarsTemp.keySet()) {
				//在当前配置中查找是否有相同的KEY和VALUE
				if (aVars.containsKey(key)) {
					if (aVars.get(key).toString()
							.equals(aVarsTemp.get(key).toString())) {
						equal = true;
					} else {
						equal = false;
						break;
					}
				} else {
					equal = false;
					break;
				}
			}
			if (equal) {
				topology = topo;
				break;
			}
	
		}
		return topology;
	}

}
