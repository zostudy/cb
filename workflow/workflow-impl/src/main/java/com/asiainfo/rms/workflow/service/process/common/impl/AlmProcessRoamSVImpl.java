package com.asiainfo.rms.workflow.service.process.common.impl;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParserFactory;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.pvm.ReadOnlyProcessDefinition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.asiainfo.rms.workflow.bo.process.common.StakeholderOprBO;
import com.asiainfo.rms.workflow.bo.workflow.StakeholderBO;
import com.asiainfo.rms.workflow.bo.workflow.WorkorderBO;
import com.asiainfo.rms.workflow.command.JDJumpTaskCmd;
import com.asiainfo.rms.workflow.common.workflow.WorkflowStaticDef;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmHisStakeholder;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmHisWorkorder;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmStakeholder;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmWorkflow;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmWorkflowTemplate;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmWorkorder;
import com.asiainfo.rms.workflow.mapper.workflow.StakeholderMapper;
import com.asiainfo.rms.workflow.mapper.workflow.WorkorderMapper;
import com.asiainfo.rms.workflow.service.driving.IAlmProcessDrivingSV;
import com.asiainfo.rms.workflow.service.process.common.IAlmProcessRoamSV;
import com.asiainfo.rms.workflow.service.stakeholder.IAlmHisStakeholderSV;
import com.asiainfo.rms.workflow.service.stakeholder.IAlmStakeholderSV;
import com.asiainfo.rms.workflow.service.workorder.IAlmHisWorkorderSV;
import com.asiainfo.rms.workflow.service.workorder.IAlmWorkorderSV;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sun.misc.BASE64Encoder;

/**
 * 
 * @author 刘超
 * @version 1.4
 *
 */
@Service("processRoamSV")
@SuppressWarnings("unchecked")
@Transactional(rollbackOn = Exception.class)
public class AlmProcessRoamSVImpl implements IAlmProcessRoamSV {

	private final static transient Log log = LogFactory.getLog(AlmProcessRoamSVImpl.class);
	
	@Resource(name="commonDao")
	private CommonDAO commonDAO;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@Resource(name="hisStakeholderSV")
	private IAlmHisStakeholderSV almHisStakeholderSV;
	
	
	@Resource(name="almStakeholderSV")
	private IAlmStakeholderSV almStakeholderSV;
	
	@Resource(name="processDrivingSV") @Lazy
	private IAlmProcessDrivingSV almProcessDrivingSV;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;

	@Autowired
	@SuppressWarnings("unused")
	private HistoryService historyService;

	@Autowired
	private ManagementService managementService;
	
	@Resource(name="hisWorkorderSV")
	private IAlmHisWorkorderSV almHisWorkorderSV;

	@Resource(name="almWorkorderSV")
	private IAlmWorkorderSV orderSV;
	
	@Override
	public void createWorkflow(String processKey, String staffId,
			String objectTypeId, String objectId,String cond) throws Exception {
		String sql = new String();
		Map<String, Object> param = new HashMap<String, Object>();
		sql = "select o from BOAlmWorkflow o where o.linkNoType=:linkNoType and o.processKey=:processKey";
		param.put("linkNoType", WorkflowStaticDef.LINK_NO_TYPE_MGR);
		param.put("processKey", processKey);
		List<BOAlmWorkflow> almWorkflows = commonDAO.findByJPAQL(sql, param,true);
		if(almWorkflows==null||almWorkflows.size()!=1){
			StringBuffer bf = new StringBuffer();
			bf.append("查询环节配置错误，查询条件为:");
			bf.append("[linkNoType]="+WorkflowStaticDef.LINK_NO_TYPE_MGR+",");
			bf.append("[processKey]="+processKey+",");
			bf.append("[sql]="+sql);
			if(log.isErrorEnabled())
				log.error(bf);

			throw new Exception(bf.toString());
		}
		
		sql = new String();
		param.clear();
		sql = "select o from BOAlmWorkorder o where o.linkId=:linkId and o.objId=:objId and o.objType=:objType and o.orderType=:orderType and o.status=:status";
		param.put("linkId", almWorkflows.get(0).getLinkId());
		param.put("objId", Long.valueOf(objectId));
		param.put("objType", objectTypeId);
		param.put("orderType", WorkflowStaticDef.STAKEHOLDERTYPE_WF);
		param.put("status", WorkflowStaticDef.WO_STATUS_RECEIVE);
		List<BOAlmWorkorder> adminWorkorders = commonDAO.findByJPAQL(sql,param);
		if(adminWorkorders==null||adminWorkorders.size()!=1){
			StringBuffer bf = new StringBuffer();
			bf.append("查询开始环节工单错误，查询条件为:");
			bf.append("[linkId]="+almWorkflows.get(0).getLinkId()+",");
			bf.append("[objId]="+Long.valueOf(objectId)+",");
			bf.append("[objType]="+objectTypeId+",");
			bf.append("[orderType]="+WorkflowStaticDef.STAKEHOLDERTYPE_WF+",");
			bf.append("[status]="+WorkflowStaticDef.WO_STATUS_RECEIVE+",");
			bf.append("[sql]="+sql);
			if(log.isErrorEnabled())
				log.error(bf);

			throw new Exception(bf.toString());
		}
		
		BOAlmWorkorder almWorkorder = adminWorkorders.get(0);
		almWorkorder.setIsCurrentTask(WorkflowStaticDef.IS_NOT_CURRENT_TASK);
		almWorkorder.setStatus(WorkflowStaticDef.WO_STATUS_COMPLETE);
		almWorkorder.setFinishTime(new Timestamp(System.currentTimeMillis()));
		almWorkorder.setExecTimes(new Timestamp(System.currentTimeMillis()).getTime() - almWorkorder.getCreatTime().getTime());
		commonDAO.save(almWorkorder);
		
		Map<String,String> aVars =  new HashMap<String,String>();
		aVars = this.analyzeCond(aVars, cond);
		aVars.put("objId", objectId);
		aVars.put("objType", objectTypeId);
		aVars.put("staffId", staffId);
		String processInstance = this.startActivitiProcess(almWorkorder.getDeployId().toString(),processKey, aVars);
		if(processInstance==null||processInstance.equals("")){
			if(log.isErrorEnabled()){
				log.error("警告：流程启动出现错误,未能获取到流程的processInstance,流程deployId:"+almWorkorder.getDeployId().toString()+",objId="+objectId+",objType="+objectTypeId+",请核对数据库流程数据。");
			}
		}
	}

	@Override
	public void saveStakeholder(String objId,String objType,List<StakeholderBO> stakeholderBOs)throws Exception {
		try{
			List<Long> hasDelSign = new ArrayList<Long>();
			long id = Long.valueOf(objId);
			List<BOAlmStakeholder> almStakeholder = new LinkedList<BOAlmStakeholder>();
			for (int i = 0; stakeholderBOs != null && stakeholderBOs.size() >= 1 && i < stakeholderBOs.size(); i++) {
				almStakeholder.add(StakeholderMapper.INSTANCE.boToDomain(stakeholderBOs.get(i)));
			}
			for (BOAlmStakeholder holder : almStakeholder) {
				String sql = "select o from BOAlmStakeholder o where o.objId=:objId and o.objType=:objType and o.linkId=:linkId";
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("objId", id);
				param.put("objType", objType);
				param.put("linkId", holder.getLinkId());
				List<BOAlmStakeholder> almStakeholders = commonDAO.findByJPAQL(sql, param);
				
				sql = "select o from BOAlmWorkflow o where o.linkId=:linkId";
				param.clear();
				param.put("linkId", holder.getLinkId());
				List<BOAlmWorkflow> almWorkflows = commonDAO.findByJPAQL(sql, param,true);
				if(almWorkflows==null||almWorkflows.size()==0){
					if(log.isErrorEnabled()){
						log.error("查找环节信息出错,查询条件:[linkId]="+holder.getLinkId()+",[sql]="+sql);
					}
					throw new Exception("查找环节信息出错,查询条件:[linkId]="+holder.getLinkId()+",[sql]="+sql);
				}
				
				if(almWorkflows.get(0).getLinkNoType().equals(WorkflowStaticDef.LINK_NO_TYPE_MGR)||almWorkflows.get(0).getLinkNoType().equals(WorkflowStaticDef.LINK_NO_TYPE_USER)){
					if(almStakeholders!=null&&almStakeholders.size()==1){
						BOAlmStakeholder temp = holder;
						holder = almStakeholders.get(0);
						holder.setStdholderStaffId(temp.getStdholderStaffId());
						holder.setStdholderStaffName(temp.getStdholderStaffName());
						holder.setStdholderStaffNo(temp.getStdholderStaffNo());
						holder.setRoleCode(temp.getRoleCode());
						holder.setRoleId(temp.getRoleId());
						holder.setStdholderStaffOrgId(temp.getStdholderStaffOrgId());
					}
				}else if(almWorkflows.get(0).getLinkNoType().equals(WorkflowStaticDef.LINK_NO_TYPE_SIGN)){
					if(!hasDelSign.contains(almWorkflows.get(0).getLinkId())&&almStakeholders!=null){
						hasDelSign.add(almWorkflows.get(0).getLinkId());
						for(BOAlmStakeholder stakeholder : almStakeholders){
							commonDAO.delete(stakeholder);
						}
					}
				}else{
					if(log.isErrorEnabled()){
						log.error("未知环节类型,类型为:"+almWorkflows.get(0).getLinkNoType());
					}
					throw new Exception("未知环节类型,类型为:"+almWorkflows.get(0).getLinkNoType());
				}
				holder.setCreateTime(new Timestamp(System.currentTimeMillis()));
				holder.setObjId(id);
				holder.setObjType(objType);
				holder.setLinkNo(almWorkflows.get(0).getLinkNo());
				commonDAO.save(holder);
			}
		} catch (Exception e) {
			if(log.isErrorEnabled()){
				log.error("保存处理人出错,方法：com.asiainfo.platform.service.process.impl.AlmProcessRoamSVImpl." +
						"saveStakeholder(String objId,String objType, List<BOAlmStakeholder> almStakeholder)");
			}
			throw new Exception("保存工单和处理人出错:"
					+ (e.getCause() == null ? e.getMessage() : e.getCause()
							.getMessage()), e);
		}
	}

	@Override
	public void finishUserTask(long orderId, String result, String reason,
			String cond) throws Exception {
		String sql = new String();
		sql = "select o from BOAlmWorkorder o where o.orderId=:orderId and o.orderType=:orderType and o.status=:status";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("orderId", orderId);
		param.put("orderType", WorkflowStaticDef.STAKEHOLDERTYPE_WF);
		param.put("status", WorkflowStaticDef.WO_STATUS_RECEIVE);
		List<BOAlmWorkorder> almWorkorders = commonDAO.findByJPAQL(sql,param);
		if(almWorkorders==null||almWorkorders.size() != 1){
			StringBuffer sb = new StringBuffer();
			sb.append("查询工单信息出错，查询条件:");
			sb.append("orderId:" + orderId + ",");
			sb.append("orderType:" + WorkflowStaticDef.STAKEHOLDERTYPE_WF + ",");
			sb.append("status:" + WorkflowStaticDef.WO_STATUS_RECEIVE);
			sb.append(",");
			sb.append("SQL:" + sql.toString());
			if (log.isErrorEnabled())
				log.error(sb);

			throw new Exception(sb.toString());
		}
		BOAlmWorkorder workorder = almWorkorders.get(0);
		
		Map<String, Object> aVars = taskService.getVariables(almWorkorders.get(0).getActTaskId().toString());
		aVars = this.analyzeCond(aVars, cond);
		aVars.put("result", result);
		aVars.put("reason", reason);
		aVars.put("cond", cond);
		taskService.setVariables(almWorkorders.get(0).getActTaskId().toString(), aVars);
		taskService.complete(workorder.getActTaskId().toString());

		almProcessDrivingSV.drivFun(almWorkorders.get(0).getObjId(),almWorkorders.get(0).getObjType(),almWorkorders.get(0).getLinkId(),cond);
	}

	@Override
	public long createStartSaveOrder(String sourcePath,String objId, String objType,
			String processKey, String cond, String opinion) throws Exception {
		List<ProcessDefinition>  definitions = repositoryService.createProcessDefinitionQuery().processDefinitionKey(processKey).latestVersion().list();
		if(definitions.size()==0){
			this.deploymentProcessBySourcePath(sourcePath);
			definitions = repositoryService.createProcessDefinitionQuery().processDefinitionKey(processKey).latestVersion().list();
		}
		String sql = new String();
		sql = "select o from BOAlmWorkflow o where o.processKey=:processKey and o.linkNoType=:linkNoType";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("processKey", processKey);
		param.put("linkNoType", WorkflowStaticDef.LINK_NO_TYPE_MGR);
		List<BOAlmWorkflow> almWorkflows =  commonDAO.findByJPAQL(sql,param,true);
		if(almWorkflows==null||almWorkflows.size() != 1){
			StringBuffer sb = new StringBuffer();
			sb.append("ͬ查找环节配置信息出错，查询条件：");
			sb.append("processKey:" + processKey + ",");
			sb.append("linkNoType:" + WorkflowStaticDef.LINK_NO_TYPE_MGR);
			sb.append(",");
			sb.append("SQL:" + sql.toString());
			if (log.isErrorEnabled())
				log.error(sb);

			throw new Exception(sb.toString());
		}
		
		sql = new String();
		sql = "select o from BOAlmStakeholder o where o.processKey=:processKey and o.linkId=:linkId and o.linkNo=:linkNo and o.objId=:objId and o.objType=:objType and o.stdholdeType=:stdholdeType";
		param.clear();
		param.put("processKey", almWorkflows.get(0).getProcessKey());
		param.put("linkId", almWorkflows.get(0).getLinkId());
		param.put("linkNo", almWorkflows.get(0).getLinkNo());
		param.put("objId", Long.parseLong(objId));
		param.put("objType", objType);
		param.put("stdholdeType", WorkflowStaticDef.STAKEHOLDERTYPE_WF);
		List<BOAlmStakeholder> almStakeholders = commonDAO.findByJPAQL(sql,param);
		if(almStakeholders==null||almStakeholders.size() != 1){
			StringBuffer sb = new StringBuffer();
			sb.append("查找环节处理人出错,查询条件");
			sb.append("processKey:" + processKey + ",");
			sb.append("linkId:" + almWorkflows.get(0).getLinkId() + ",");
			sb.append("linkNo:" + almWorkflows.get(0).getLinkNo() + ",");
			sb.append("objId:" + Long.parseLong(objId) + ",");
			sb.append("objType:" + objType + ",");
			sb.append("stdholdeType:" + WorkflowStaticDef.STAKEHOLDERTYPE_WF);
			sb.append(",");
			sb.append("SQL:" + sql.toString());
			if (log.isErrorEnabled())
				log.error(sb);

			throw new Exception(sb.toString());
		}
		
		sql = new String();
		sql = "select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.linkId=:linkId and o.status=:status";
		param.clear();
		param.put("objId", Long.valueOf(objId));
		param.put("objType", objType);
		param.put("linkId", almWorkflows.get(0).getLinkId());
		param.put("status", WorkflowStaticDef.WO_STATUS_RECEIVE);
		BOAlmWorkorder almWorkorder = null;
		List<BOAlmWorkorder> almWorkorders = commonDAO.findByJPAQL(sql,param);
		if(almWorkorders==null||almWorkorders.size()==0){
			almWorkorder = new BOAlmWorkorder();
			almWorkorder.setDeployId(Long.valueOf(definitions.get(0).getDeploymentId()));
			almWorkorder.setProcInstId(-1l);
			almWorkorder.setParentOrderId(Long.valueOf(WorkflowStaticDef.WO_NO_PARENT));
			almWorkorder.setActTaskId(Long.valueOf(WorkflowStaticDef.WO_NO_VM_TASK_ID));
			almWorkorder.setParentActTaskId(Long.valueOf(WorkflowStaticDef.WO_NO_PARENT_VM_TASK_ID));
			almWorkorder.setLastActTaskId(Long.valueOf(WorkflowStaticDef.WO_NO_LAST_VM_TASK_ID));
			almWorkorder.setLinkId(almWorkflows.get(0).getLinkId());
			almWorkorder.setIsCurrentTask(WorkflowStaticDef.IS_CURRENT_TASK);
			almWorkorder.setOrderType(WorkflowStaticDef.STAKEHOLDERTYPE_WF);
			almWorkorder.setObjId(Long.parseLong(objId));
			almWorkorder.setObjType(objType);
			almWorkorder.setDealType(WorkflowStaticDef.WO_DEAL_TYPE_APPROVE);
			almWorkorder.setIsLock(Long.valueOf(WorkflowStaticDef.NO_LOCK));
			almWorkorder.setFinishPrint(Long.valueOf(WorkflowStaticDef.NOT_NEED_PRINT));
			almWorkorder.setExecRoleId(almStakeholders.get(0).getRoleId());
			almWorkorder.setExecStaffId(almStakeholders.get(0).getStdholderStaffId());
			almWorkorder.setResult(WorkflowStaticDef.WO_APPROVAL_RESULT_PASS);
			almWorkorder.setCond(cond);
			almWorkorder.setOpinion(opinion);
			almWorkorder.setStatus(WorkflowStaticDef.WO_STATUS_RECEIVE);
			almWorkorder.setCreatTime(new Timestamp(System.currentTimeMillis()));
			almWorkorder.setRecvTime(new Timestamp(System.currentTimeMillis()));
			almWorkorder.setExecTime(new Timestamp(System.currentTimeMillis()));
		}
		else if(almWorkorders.size()==1)
		{
			almWorkorder = almWorkorders.get(0);
			almWorkorder.setCond(cond);
			almWorkorder.setOpinion(opinion);
		}
		else
			throw new Exception("查询到的开始工单数量大于1");
		commonDAO.save(almWorkorder);
		StakeholderBO stakeholderBO = StakeholderMapper.INSTANCE.domainToBo(almStakeholders.get(0));
		almHisStakeholderSV.copyHisStakeholderByStakeholder(stakeholderBO);
		return almWorkorder.getOrderId();
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public Map analyzeCond(Map aVars , String cond) throws Exception{
		if(cond !=null&&!"".equals(cond)){
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
			DocumentBuilder builder = factory.newDocumentBuilder(); 
			Document doc = builder.parse(new InputSource(new StringReader(cond)));
			Element root = doc.getDocumentElement();   
			NodeList condList = root.getChildNodes();   
			for(int i = 0; condList.getLength()>i;i++){
				Node condNode = condList.item(i);
				NodeList childlist = condNode.getChildNodes();
				if(condNode.getNodeName().indexOf("List")!=-1||condNode.getNodeName().indexOf("list")!=-1){
					List list = new ArrayList();
					for(int j=0;j<childlist.getLength();j++){
						list.add(childlist.item(j).getFirstChild().getNodeValue());
					}
					aVars.put(condNode.getNodeName(), list);
				}else if(childlist.getLength()==1)
					aVars.put(condNode.getNodeName(), condNode.getFirstChild().getNodeValue());
			}
		}
		return aVars;
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	@Transactional(rollbackOn=Exception.class,value=TxType.REQUIRED)
	public void terminateWorkflow(long deployId,long procInstId,long objId,String objType, String staffId,String staffCode,String staffName, String reason) throws Exception{
		if(procInstId!=-1){
			try{
				runtimeService.deleteProcessInstance(String.valueOf(procInstId), reason);
			}catch(Exception e){
				e.printStackTrace();
				log.error("终止流程，删除activiti实例时发生异常！无法清除procInstId："+procInstId+"的实例！");
			}
		}
		String sql = "select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType order by o.orderId";
		Map param = new HashMap();
		param.put("objId", objId);
		param.put("objType", objType);
		List<BOAlmWorkorder> workorders = commonDAO.findByJPAQL(sql, param);
		if(workorders.size() > 0 ){
			sql = "select o from BOAlmWorkflowTemplate o where o.objType=:objType";
			param = new HashMap();
			param.put("objType", objType);
			List<BOAlmWorkflowTemplate> workflowTemplates =commonDAO.findByJPAQL(sql, param);
			if(workflowTemplates.size() != 1){
				StringBuffer sb = new StringBuffer();
				sb.append("同一模板编号查询到不唯一的配置信息,查询表：ALM_WORKFLOW_TEMPLATE；查询条件为【");
				sb.append("objType:" + objType + ",");
				sb.append("】");
				sb.append("SQL:" + sql.toString());
				if (log.isErrorEnabled())
					log.error(sb);

				throw new Exception(sb.toString());
			}
			sql = "select o from BOAlmWorkflow o where o.processKey=:processKey and o.linkNoType=:linkNoType";
			param = new HashMap();
			param.put("processKey", workflowTemplates.get(0).getProcessKey());
			param.put("linkNoType", WorkflowStaticDef.LINK_NO_TYPE_TERMINATION);
			List<BOAlmWorkflow> terminationWFs =  commonDAO.findByJPAQL(sql, param);
			if(terminationWFs.size() != 1){
				StringBuffer sb = new StringBuffer();
				sb.append("同一环节查询到不唯一的配置信息,查询表：ALM_WORKFLOW；查询条件为【");
				sb.append("processKey:" + workflowTemplates.get(0).getProcessKey() + ",");
				sb.append("linkNoType:" + WorkflowStaticDef.LINK_NO_TYPE_TERMINATION);
				sb.append("】");
				sb.append("SQL:" + sql.toString());
				if (log.isErrorEnabled())
					log.error(sb);

				throw new Exception(sb.toString());
			}
			
			//为获取新的orderId  否则历史轨迹排序会有问题 
			BOAlmWorkorder almWorkorder = new BOAlmWorkorder();
			commonDAO.save(almWorkorder);
			commonDAO.delete(almWorkorder);
			//////////
			
			//生成流程终止操作工单
			BOAlmHisWorkorder almHisWorkorder = new BOAlmHisWorkorder();
			almHisWorkorder.setOrderId(almWorkorder.getOrderId());
			almHisWorkorder.setDeployId(deployId);
			almHisWorkorder.setProcInstId(procInstId);
			almHisWorkorder.setParentOrderId(WorkflowStaticDef.WO_NO_PARENT);
			almHisWorkorder.setLastOrderId(-1l);
			almHisWorkorder.setActTaskId(WorkflowStaticDef.WO_NO_VM_TASK_ID);
			almHisWorkorder.setParentActTaskId(WorkflowStaticDef.WO_NO_PARENT_VM_TASK_ID);
			almHisWorkorder.setLastActTaskId(WorkflowStaticDef.WO_NO_LAST_VM_TASK_ID);
			almHisWorkorder.setLinkId(terminationWFs.get(0).getLinkId());
			almHisWorkorder.setIsCurrentTask(WorkflowStaticDef.IS_NOT_CURRENT_TASK);
			almHisWorkorder.setOrderType(WorkflowStaticDef.STAKEHOLDERTYPE_WF);
			almHisWorkorder.setObjId(objId);
			almHisWorkorder.setObjType(objType);
			almHisWorkorder.setDealType(WorkflowStaticDef.WO_DEAL_TYPE_APPROVE);
			almHisWorkorder.setIsLock(WorkflowStaticDef.NO_LOCK);
			almHisWorkorder.setFinishPrint(WorkflowStaticDef.NOT_NEED_PRINT);
			almHisWorkorder.setExecStaffId(Long.valueOf(staffId));
			almHisWorkorder.setResult("P");
			almHisWorkorder.setStatus(WorkflowStaticDef.WO_STATUS_COMPLETE);
			almHisWorkorder.setOpinion(reason);
			almHisWorkorder.setCreatTime(new Date());
			almHisWorkorder.setRecvTime(new Date());
			almHisWorkorder.setExecTime(new Date());
			almHisWorkorder.setFinishTime(new Date());
			commonDAO.save(almHisWorkorder);
			//保存流转终止操作人的干系人信息
			BOAlmHisStakeholder almHisStakeholder = new BOAlmHisStakeholder();
			almHisStakeholder.setStdholderId(0l);
			almHisStakeholder.setProcessKey(workflowTemplates.get(0).getProcessKey());
			almHisStakeholder.setLinkId(terminationWFs.get(0).getLinkId());
			almHisStakeholder.setLinkNo(terminationWFs.get(0).getLinkNo());
			almHisStakeholder.setObjId(objId);
			almHisStakeholder.setObjType(objType);
			almHisStakeholder.setStdholderStaffOrgId(-1l);
			almHisStakeholder.setStdholderStaffId(Long.valueOf(staffId));
			
			almHisStakeholder.setStdholderStaffNo(staffCode);
			almHisStakeholder.setStdholderStaffName(staffName);
			almHisStakeholder.setStdholdeType(WorkflowStaticDef.STAKEHOLDERTYPE_WF);
			almHisStakeholder.setCreateTime(new Date());
			commonDAO.save(almHisStakeholder);
			
			
			
				
			for(BOAlmWorkorder workorderVal : workorders){
//				sendOaRecord(workorderVal.getObjId()+"",workorderVal.getObjType() ,workorderVal.getOrderId()+"",null,workorderVal.getFinishTime(),"1","","" ,workorderVal.getExecStaffId()+"");
				commonDAO.delete(workorderVal);
				//更新所有工单状态为已完成
				if(!workorderVal.getStatus().equals(WorkflowStaticDef.WO_STATUS_COMPLETE)){
					workorderVal.setFinishTime(new Date());
					workorderVal.setStatus(WorkflowStaticDef.WO_STATUS_COMPLETE);
					workorderVal.setIsCurrentTask(WorkflowStaticDef.IS_NOT_CURRENT_TASK);
				}
				//将工单移到工单历史表中
				WorkorderBO workorderBO = WorkorderMapper.INSTANCE.domainToBo(workorderVal);
				almHisWorkorderSV.capyHisWorkorderByWorkorder(workorderBO);
				
			}
			
			sql = "select o from BOAlmStakeholder o where o.objId=:objId and o.objType=:objType and o.stdholdeType=:stdholdeType";
			param = new HashMap();
			param.put("objId", objId);
			param.put("objType", objType);
			param.put("stdholdeType", WorkflowStaticDef.STAKEHOLDERTYPE_WF);
			List<BOAlmStakeholder> stakeholders=commonDAO.findByJPAQL(sql, param);
			for(BOAlmStakeholder stakeholder : stakeholders){
				commonDAO.delete(stakeholder);
			}
		}
	  }
	
	@SuppressWarnings("rawtypes")
	private String startActivitiProcess(String deployId,String processKey,Map vars)throws Exception{
		
		List<ProcessDefinition> processDefine = repositoryService.createProcessDefinitionQuery().processDefinitionKey(processKey).deploymentId(deployId).list();
		if(processDefine==null||processDefine.size()==0){
			if(log.isErrorEnabled())
				log.error("查询到的部署ID不唯一，请注意是否有调用createStartSaveOrder函数，deployId="+deployId);
			throw new Exception("查询到的部署ID不唯一，请注意是否有调用createStartSaveOrder函数，deployId="+deployId);
		}
		
		if(log.isDebugEnabled()){
			log.debug("正在启动流程，deployId："+deployId);
		}
		
		ProcessInstance instance = runtimeService.startProcessInstanceById(processDefine.get(0).getId(),vars);
		
		if(log.isDebugEnabled()){
			log.debug("流程启动完成,ProcessInstanceId:"+instance.getId());
		}
		
		return instance.getId();
	}
	
	public String deploymentProcessBySourcePath(String sourcePath) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("正在加载流程文件，流程文件资源路径："+sourcePath);
		}
		Deployment deployment = repositoryService.createDeployment().addClasspathResource(sourcePath).deploy();
		
		String deploymentId = deployment.getId();
		
		if(log.isDebugEnabled()){
			log.debug("流程文件加载完成-file="+sourcePath+"，deploymentId："+deploymentId);
		}
		
		return deploymentId;
	}
	
	public String deploymentProcessByZipFile(ZipInputStream stream)
			throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("正在加载流程zip文件");
		}

		Deployment deployment = repositoryService.createDeployment()
				.addZipInputStream(stream).deploy();

		String deploymentId = deployment.getId();
		if (log.isDebugEnabled()) {
			log.debug("流程zip文件加载完成,+deploymentId：" + deploymentId);
		}
		return deploymentId;
	}
	

	@Override
	public String getProcessImageToBase64(long deployId) throws Exception {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			if (deployId == 0)
				throw new Exception("获取图片信息失败，不能传入无法找到deployId=0的信息");

			List<ProcessDefinition> definition = repositoryService
					.createProcessDefinitionQuery()
					.deploymentId(String.valueOf(deployId)).list();
			if (definition.size() != 1)
				throw new Exception("获取图片信息失败，未能查找到deployId=" + deployId
						+ "的信息");

			InputStream is = repositoryService.getProcessDiagram(definition
					.get(0).getId());

			new BASE64Encoder().encode(is, os);
			is.close();
		} catch (Exception e) {
			log.error("错误原因:" + e.getMessage());
			throw new Exception(e);
		}

		return os.toString();
	}

	@Override
	public Map<String,JSONObject> getShapePosition(long deployId)
			throws Exception {
		Shape shape = new Shape();
		try {
			if (deployId == 0)
				throw new Exception("获取环节位置信息失败，不能传入无法找到deployId=0的信息");

			List<ProcessDefinition> definition = repositoryService
					.createProcessDefinitionQuery()
					.deploymentId(String.valueOf(deployId)).list();
			if (definition.size() != 1)
				throw new Exception("获取环节位置信息失败，未能查找到deployId=" + deployId
						+ "的信息");

			InputStream is = repositoryService.getProcessModel(definition
					.get(0).getId());
			SAXParserFactory.newInstance().newSAXParser()
					.parse(is, shape);
		} catch (Exception e) {
			log.error("错误原因:" + e.getMessage());
			throw new Exception(e);
		}
		return shape.getShapes();
	}
	
	private class Shape extends DefaultHandler{
		
		@Override
		public void startElement(String namespaceURI,
				String localName, String qName,
				Attributes attributes) throws SAXException {
			
			switch (qName) {
			case SHAPE:
				n = attributes.getValue("bpmnElement");
				break;
			case EDGE:
				n = attributes.getValue("bpmnElement");
				break;
			case BOUND:
				shape = shapes.get(n);
				if(shape==null)
					throw new SAXException("未能找到相应的元素,id="+n);
				shape.put("x", Double.parseDouble(attributes
						.getValue("x")));
				shape.put("y", Double.parseDouble(attributes
						.getValue("y")));
				shapes.put(n, shape);
				break;
			case WAY_POINT:
				shape = shapes.get(n);
				if(shape==null)
					throw new SAXException("未能找到相应的元素,id="+n);
				if(shape.get("positions")==null)
					positions = new JSONArray();
				else
					positions = JSONArray.fromObject(shape.get("positions"));
				JSONObject position = new JSONObject();
				position.put("x", Double.parseDouble(attributes
						.getValue("x")));
				position.put("y", Double.parseDouble(attributes
						.getValue("y")));
				positions.add(position);
				shape.put("positions", positions);
				break;
			case USER_TASK:
				shape = new JSONObject();
				shape.put("name", attributes.getValue("name"));
				shape.put("type", USER_TASK);
				shapes.put(attributes.getValue("id"), shape);
				break;
			case START_EVENT:
				shape = new JSONObject();
				shape.put("name", attributes.getValue("name"));
				shape.put("type", START_EVENT);
				shapes.put(attributes.getValue("id"), shape);
				break;
			case END_EVENT:
				shape = new JSONObject();
				shape.put("name", attributes.getValue("name"));
				shape.put("type", END_EVENT);
				shapes.put(attributes.getValue("id"), shape);
				break;
			case SEQUENCE_FLOW:
				shape = new JSONObject();
				shape.put("name", attributes.getValue("name"));
				shape.put("type", SEQUENCE_FLOW);
				shape.put("from", attributes.getValue("sourceRef"));
				shape.put("to", attributes.getValue("targetRef"));
				shapes.put(attributes.getValue("id"), shape);
				break;
			case EXCLUSIVE_GATEWAY:
				shape = new JSONObject();
				shape.put("name", attributes.getValue("name"));
				shape.put("type", EXCLUSIVE_GATEWAY);
				shapes.put(attributes.getValue("id"), shape);
				break;
			case PARALLEL_GATEWAY:
				shape = new JSONObject();
				shape.put("name", attributes.getValue("name"));
				shape.put("type", PARALLEL_GATEWAY);
				shapes.put(attributes.getValue("id"), shape);
				break;
			default:
			}
		}

		@Override
		public void endElement(String uri, String localName,
				String qName) throws SAXException {
		}

		private static final String SHAPE = "bpmndi:BPMNShape";
		private static final String EDGE = "bpmndi:BPMNEdge";
		private static final String BOUND = "omgdc:Bounds";
		private static final String USER_TASK = "userTask";
		private static final String START_EVENT = "startEvent";
		private static final String END_EVENT = "endEvent";
		private static final String SEQUENCE_FLOW = "sequenceFlow";
		private static final String EXCLUSIVE_GATEWAY = "exclusiveGateway";
		private static final String PARALLEL_GATEWAY = "parallelGateway";
		private static final String WAY_POINT = "omgdi:waypoint";
		private String n = null;
		private JSONObject shape = null;
		private JSONArray positions = null;
		private Map<String,JSONObject> shapes = new HashMap<String,JSONObject>();
		
		public Map<String,JSONObject> getShapes() {
			return shapes;
		}
		
	}

	@Override
	public void deleteProcessDeploy(long deployId) throws Exception {
		repositoryService.deleteDeployment(String.valueOf(deployId));
	}

	@Override
	@SuppressWarnings("unlikely-arg-type")
	public void reAuthorizeTask(long orderId, StakeholderBO std, String opinion) throws Exception {

		String hql = "select o from BOAlmWorkorder o where o.orderId=:orderId and o.isCurrentTask=:isCurrentTask and o.status=:status";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderId",orderId);
		params.put("isCurrentTask",WorkflowStaticDef.IS_CURRENT_TASK);
		params.put("status",WorkflowStaticDef.WO_STATUS_RECEIVE);

		List<BOAlmWorkorder> orders = commonDAO.findByJPAQL(hql,params);

		if(orders==null || orders.size() != 1){
			StringBuffer sb = new StringBuffer();
			sb.append("查询未完成工单数量不唯一；查询条件为【");
			sb.append("orderId:" + orderId + ",");
			sb.append("isCurrentTask:" + WorkflowStaticDef.IS_CURRENT_TASK + ",");
			sb.append("status:" + WorkflowStaticDef.WO_STATUS_RECEIVE + ",");
			sb.append("】");
			sb.append("hql:" + hql.toString());
			if (log.isErrorEnabled())
				log.error(sb);

			throw new Exception(sb.toString());
		}

		BOAlmWorkorder order = orders.get(0);
		WorkorderBO workorderBO = orderSV.capyWorkorderByWorkorderNoSave(WorkorderMapper.INSTANCE.domainToBo(order));
		BOAlmWorkorder newWorkOrderValue = WorkorderMapper.INSTANCE.boToDomain(workorderBO);
		if(WorkflowStaticDef.LINK_NO_TYPE_USER.equals(orders.get(0))){

		}
		if(WorkflowStaticDef.LINK_NO_TYPE_SIGN.equals(orders.get(0))){
			newWorkOrderValue.setParentOrderId(WorkflowStaticDef.WO_NO_PARENT);
		}
		newWorkOrderValue.setLastOrderId(orders.get(0).getOrderId());
		newWorkOrderValue.setExecStaffId(std.getStdholderStaffId());
		newWorkOrderValue.setCreatTime(new Date());
		newWorkOrderValue.setLockTime(null);
		newWorkOrderValue.setRealseLockTime(null);
		newWorkOrderValue.setLockTimes(0l);
		if(WorkflowStaticDef.NOT_NEED_PRINT == newWorkOrderValue.getFinishPrint()){
			newWorkOrderValue.setRecvTime(new Date());
			newWorkOrderValue.setExecTime(new Date());
			newWorkOrderValue.setExecTimes(0l);
		}
		else if(WorkflowStaticDef.NO_FINISH_PRINT == newWorkOrderValue.getFinishPrint()){
			newWorkOrderValue.setRecvTime(null);
			newWorkOrderValue.setExecTime(null);
			newWorkOrderValue.setExecTimes(0l);
		}
		else if(WorkflowStaticDef.FINISH_PRINT == newWorkOrderValue.getFinishPrint()){
			newWorkOrderValue.setRecvTime(new Date());
			newWorkOrderValue.setExecTime(new Date());
			newWorkOrderValue.setExecTimes(0l);
		}

		commonDAO.save(newWorkOrderValue);
		
		//将转派人的工单状态置为已完成
		order.setOpinion(opinion);
		order.setIsCurrentTask(WorkflowStaticDef.IS_NOT_CURRENT_TASK);
		order.setDealType(WorkflowStaticDef.WO_DEAL_TYPE_REAUTHORIZE);
		order.setResult(WorkflowStaticDef.WO_APPROVAL_RESULT_NO_OPTION);
		order.setStatus(WorkflowStaticDef.WO_STATUS_COMPLETE);
		order.setFinishTime(new Date());
		long exeTime = 0;
		if(order.getExecTimes()!=null)
			exeTime = order.getExecTimes();
		order.setExecTimes(exeTime + new Date().getTime() - order.getExecTime().getTime());
		commonDAO.save(order);
//		try{
//		sendOaRecord(order.getObjId()+"",order.getObjType() ,order.getOrderId()+"", null,order.getFinishTime(),"1","","" ,order.getExecStaffId()+"");
//		}catch(Exception e){
//			log.error("向OA发送转派人关单信息时发送异常：" + e.getMessage());
//			throw e;
//		}
		//********将替换干系人信息为转派后操作员信息***********************
		try{
			// 删除旧的干系人
			String sql = "select o from BOAlmStakeholder o where o.objId=:objId and o.objType=:objType and o.linkId=:linkId and o.stdholderStaffId=:stdholderStaffId";
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("objId", order.getObjId());
			param.put("objType", order.getObjType());
			param.put("linkId", order.getLinkId());
			param.put("stdholderStaffId", order.getExecStaffId());
			
			List<BOAlmStakeholder> delStakeholders = commonDAO.findByJPAQL(sql, param);
			//为新的干系人初始化信息
			BOAlmStakeholder stakeholder = new BOAlmStakeholder();
			for(BOAlmStakeholder delStakeholder : delStakeholders){
				stakeholder.setProcessKey(delStakeholder.getProcessKey());
				stakeholder.setLinkId(delStakeholder.getLinkId());
				stakeholder.setLinkNo(delStakeholder.getLinkNo());
				stakeholder.setObjId(delStakeholder.getObjId());
				stakeholder.setObjType(delStakeholder.getObjType());
				stakeholder.setStdholderStaffId(std.getStdholderStaffId());
				stakeholder.setStdholderStaffName(std.getStdholderStaffName());
				stakeholder.setStdholderStaffNo(std.getStdholderStaffNo());
				stakeholder.setRoleCode(delStakeholder.getRoleCode());
				stakeholder.setRoleId(delStakeholder.getRoleId());
				stakeholder.setStdholderStaffOrgId(std.getStdholderStaffOrgId());
				stakeholder.setStdholdeType(delStakeholder.getStdholdeType());
				stakeholder.setCreateTime(new Timestamp(System.currentTimeMillis()));
				break;
			}
			for(BOAlmStakeholder delStakeholder : delStakeholders){
				commonDAO.delete(delStakeholder);
			}
			// 当环节为会签时，当多人同时将工单转派给同一个人时，避免重复的干系人
			sql = "select o from BOAlmStakeholder o where o.objId=:objId and o.objType=:objType and o.linkId=:linkId and o.stdholderStaffId=:stdholderStaffId";
			param = new HashMap<String, Object>();
			param.clear();
			param.put("objId", newWorkOrderValue.getObjId());
			param.put("objType", newWorkOrderValue.getObjType());
			param.put("linkId", newWorkOrderValue.getLinkId());
			param.put("stdholderStaffId", newWorkOrderValue.getExecStaffId());
			
			delStakeholders = commonDAO.findByJPAQL(sql, param);
			for(BOAlmStakeholder delStakeholder : delStakeholders){
				commonDAO.delete(delStakeholder);
			}
			//插入新的干系人信息
		    commonDAO.save(stakeholder);
		    //将被转派人的干系人信息保存到历史表中
			almHisStakeholderSV.copyHisStakeholderByStakeholder(StakeholderMapper.INSTANCE.domainToBo(stakeholder));
//		    try{
//				sendOaRecord(newWorkOrderValue.getObjId()+"",newWorkOrderValue.getObjType() ,newWorkOrderValue.getOrderId()+"",newWorkOrderValue.getCreatTime(), null,"0","","" ,newWorkOrderValue.getExecStaffId()+"");
//			}catch(Exception e){
//				log.error("向被转派人发送消息时发送异常：" + e.getMessage());
//				throw e;
//			}
		} catch (Exception e) {
			if(log.isErrorEnabled()){
				log.error("工单转派，替换干系人信息时出错,方法：com.asiainfo.platform.service.process.impl.AlmProcessRoamSVImpl." +
						"reAuthorizeTask(long orderId, StakeholderBO std, String opinion)");
			}
			throw new Exception("工单转派，替换干系人信息时出错:"
					+ (e.getCause() == null ? e.getMessage() : e.getCause()
							.getMessage()), e);
		}
	}

	@Override
	public void newNoWFWo(long orderId, String orderType, StakeholderBO std, String lockOption,Long objId, String objType) throws Exception {
		if(!orderType.equals(std.getStdholdeType())){
			StringBuffer sb = new StringBuffer();
			sb.append("干系人 字段StdholdeType取值为"+orderType);
			if (log.isErrorEnabled())
				log.error(sb);

			throw new Exception(sb.toString());
		}
		List<BOAlmWorkorder> iWorkOrderValues = null;
		BOAlmWorkorder order = null;
		String hql = null;
		Map<String,Object> params = new HashMap<String,Object>();
		if(orderId > 0){
			hql = "select o from BOAlmWorkorder o where o.orderId=:orderId    ";
			params = new HashMap<String,Object>();
			params.put("orderId", orderId);
	//		params.put("orderType", WorkflowStaticDef.STAKEHOLDERTYPE_WF);
	//		params.put("isCurrentTask", WorkflowStaticDef.IS_CURRENT_TASK);
	//		params.put("status", WorkflowStaticDef.WO_STATUS_RECEIVE);
	
			iWorkOrderValues = commonDAO.findByJPAQL(hql,params);
			if(iWorkOrderValues==null || iWorkOrderValues.size() != 1){
				StringBuffer sb = new StringBuffer();
				sb.append("查询未完成工单数量不唯一；查询条件为【");
				sb.append("orderId:" + orderId + ",");
				sb.append("orderType:" +  WorkflowStaticDef.STAKEHOLDERTYPE_WF + ",");
				sb.append("isCurrentTask:" + WorkflowStaticDef.IS_CURRENT_TASK + ",");
				sb.append("status:" + WorkflowStaticDef.WO_STATUS_RECEIVE + ",");
				sb.append("】");
				sb.append("SQL:" + hql.toString());
				if (log.isErrorEnabled())
					log.error(sb);
	
				throw new Exception(sb.toString());
			}
			order = iWorkOrderValues.get(0);
		}
		
		

		BOAlmWorkorder iWorkOrderValue = new BOAlmWorkorder();
		iWorkOrderValue.setDeployId(WorkflowStaticDef.WO_NO_WORKFLOW_ID);
		iWorkOrderValue.setProcInstId(WorkflowStaticDef.WO_NO_WORKFLOW_ID);
		if(orderId <= 0){
			iWorkOrderValue.setParentOrderId(new Long(-1));
			iWorkOrderValue.setLastOrderId(new Long(-1));
		}else{
			iWorkOrderValue.setParentOrderId(order.getOrderId());
			iWorkOrderValue.setLastOrderId(order.getOrderId());
		}
		
		iWorkOrderValue.setActTaskId(-1l);
		iWorkOrderValue.setParentActTaskId(WorkflowStaticDef.WO_NO_PARENT_VM_TASK_ID);
		iWorkOrderValue.setLastActTaskId(WorkflowStaticDef.WO_NO_LAST_VM_TASK_ID);
		iWorkOrderValue.setIsCurrentTask(WorkflowStaticDef.IS_NOT_CURRENT_TASK);
		iWorkOrderValue.setOrderType(orderType);
		if(orderId <= 0){
			iWorkOrderValue.setObjId(objId);
			iWorkOrderValue.setObjType(objType);
		}else{
			iWorkOrderValue.setObjId(order.getObjId());
			iWorkOrderValue.setObjType(order.getObjType());
		}
		iWorkOrderValue.setDealType(WorkflowStaticDef.WO_DEAL_TYPE_APPROVE);
		iWorkOrderValue.setIsLock(WorkflowStaticDef.NO_LOCK);
		iWorkOrderValue.setFinishPrint(WorkflowStaticDef.NOT_NEED_PRINT);
		iWorkOrderValue.setExecRoleId(std.getRoleId());
		iWorkOrderValue.setExecStaffId(std.getStdholderStaffId());
		iWorkOrderValue.setStatus(WorkflowStaticDef.WO_STATUS_RECEIVE);
		iWorkOrderValue.setCreatTime(new Date());
		iWorkOrderValue.setRecvTime(new Date());
		iWorkOrderValue.setExecTime(new Date());
		iWorkOrderValue.setLockOpinion(lockOption);
		//抄送工单特殊处理
		iWorkOrderValue.setStatus(WorkflowStaticDef.WO_STATUS_COPY);
		iWorkOrderValue.setLinkId(std.getLinkId());
		
		commonDAO.save(iWorkOrderValue);
		
		hql = "select o from BOAlmWorkflow o where o.linkId=:linkId";
		params.clear();
		params.put("linkId",std.getLinkId());
		List<BOAlmWorkflow> fromWorkflows = commonDAO.findByJPAQL(hql, params,true);
		if(null==fromWorkflows ||fromWorkflows.isEmpty()||fromWorkflows.size()<=0){
			throw new Exception("link_id为【"+std.getLinkId()+"】没有查询到环节编号信息");
		}
		std.setProcessKey(fromWorkflows.get(0).getProcessKey());
		if(orderId <= 0){
			std.setObjId(objId);
			std.setObjType(objType);
		}else{
			std.setObjId(order.getObjId());
			std.setObjType(order.getObjType());
		}
		BOAlmStakeholder bostd=commonDAO.saveOrUpdate(StakeholderMapper.INSTANCE.boToDomain(std), BOAlmStakeholder.class);
		almHisStakeholderSV.copyHisStakeholderByStakeholder(StakeholderMapper.INSTANCE.domainToBo(bostd));
//		sendOaRecord(iWorkOrderValue.getObjId()+"",iWorkOrderValue.getObjType() ,iWorkOrderValue.getOrderId()+"", iWorkOrderValue.getCreatTime(),null,"0","","" ,iWorkOrderValue.getExecStaffId()+"");
	}

	@Override
	public void finishNoWFWo(long orderId, String orderType,String opinion,String result) throws Exception {

		String hql = "select o from BOAlmWorkorder o where o.orderId=:orderId and o.orderType=:orderType and o.status=:status";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderId",orderId);
		params.put("orderType",orderType);
//		params.put("status",WorkflowStaticDef.WO_STATUS_RECEIVE);

		params.put("status",WorkflowStaticDef.WO_STATUS_COPY);
		List<BOAlmWorkorder> iWorkOrderValues = commonDAO.findByJPAQL(hql,params);
		if(iWorkOrderValues==null||iWorkOrderValues.size() ==0 ){
			
			
			String hqlHis = "select o from BOAlmHisWorkorder o where o.orderId=:orderId and o.orderType=:orderType and o.status=:status";
			Map<String, Object> paramsHis = new HashMap<String, Object>();
			paramsHis.put("orderId",orderId);
			paramsHis.put("orderType",orderType);
//			params.put("status",WorkflowStaticDef.WO_STATUS_RECEIVE);

			paramsHis.put("status",WorkflowStaticDef.WO_STATUS_COPY);
			List<BOAlmHisWorkorder> iWorkOrderHisValues = commonDAO.findByJPAQL(hqlHis,paramsHis);
			if(iWorkOrderHisValues==null||iWorkOrderHisValues.size() ==0){
				return;
			}
			BOAlmHisWorkorder orderHis = iWorkOrderHisValues.get(0);
			//修改通知工单状态
			orderHis.setStatus(WorkflowStaticDef.WO_STATUS_COMPLETE);
			orderHis.setFinishTime(new Date());
			long exeTime = 0;
			if(orderHis.getExecTimes()!=null)
				exeTime = orderHis.getExecTimes();
			orderHis.setExecTimes(exeTime + new Date().getTime() - orderHis.getExecTime().getTime());
			orderHis.setOpinion(opinion);
			orderHis.setResult(result);
			commonDAO.save(orderHis);
			
			return;
		}
		else if(iWorkOrderValues.size() > 1){

			StringBuffer sb = new StringBuffer();
			sb.append("查询未完成工单数量不唯一；查询条件为【");
			sb.append("orderId:" + orderId + ",");
			sb.append("orderType:" +  orderType + ",");
			sb.append("status:" + WorkflowStaticDef.WO_STATUS_RECEIVE + ",");
			sb.append("】");
			sb.append("SQL:" + hql.toString());

			if (log.isErrorEnabled())
				log.error(sb);

			throw new Exception(sb.toString());

		}
		BOAlmWorkorder order = iWorkOrderValues.get(0);
		//修改通知工单状态
		order.setStatus(WorkflowStaticDef.WO_STATUS_COMPLETE);
		order.setFinishTime(new Date());
		long exeTime = 0;
		if(order.getExecTimes()!=null)
			exeTime = order.getExecTimes();
		order.setExecTimes(exeTime + new Date().getTime() - order.getExecTime().getTime());
		order.setOpinion(opinion);
		order.setResult(result);
//		sendOaRecord(order.getObjId()+"",order.getObjType() ,order.getOrderId()+"", null, order.getFinishTime(),"1","","" ,order.getExecStaffId()+"");
		almHisWorkorderSV.capyHisWorkorderByWorkorder(WorkorderMapper.INSTANCE.domainToBo(order));
		commonDAO.delete(order);
	}

	@Override
	public void jumpSpecifyNode(long orderId,String processKey, long toLinkId, String conds,String result,String reason) throws Exception {

		String hql = "select o from BOAlmWorkorder o where o.orderId=:orderId and o.orderType=:orderType and o.status=:status";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderId",orderId);
		params.put("orderType",WorkflowStaticDef.STAKEHOLDERTYPE_WF);
		params.put("status",WorkflowStaticDef.WO_STATUS_PRE_RECEIVE);
		List<BOAlmWorkorder> iWorkOrderValues = commonDAO.findByJPAQL(hql,params);
		if(iWorkOrderValues==null||iWorkOrderValues.size() ==0 ){
			if (log.isErrorEnabled()) {
				StringBuffer sb = new StringBuffer();
				sb.append("查询未完成工单数量不唯一；查询条件为【");
				sb.append("orderId:" + orderId + ",");
				sb.append("orderType:" +  WorkflowStaticDef.STAKEHOLDERTYPE_WF + ",");
				sb.append("status:" + WorkflowStaticDef.WO_STATUS_PRE_RECEIVE + ",");
				sb.append("】");
				sb.append("SQL:" + hql.toString());
				log.error(sb);
				throw new Exception(sb.toString());
			}
		}

		BOAlmWorkorder order = iWorkOrderValues.get(0);
		Long actTaskId = order.getActTaskId();
		Task task =  taskService.createTaskQuery().taskId(actTaskId.toString()).singleResult();
		if(task==null){
			if (log.isErrorEnabled()) {
				StringBuffer sb = new StringBuffer();
				sb.append("查询流程引擎task任务不唯一；查询条件为【");
				sb.append("actTaskId:" + actTaskId.toString());
				sb.append("】");
				sb.append("SQL:" + hql.toString());
				log.error(sb);
				throw new Exception(sb.toString());
			}
		}

		hql = "select o from BOAlmWorkflow o where o.processKey=:processKey and o.linkId=:linkId";
		params.clear();
		params.put("processKey",processKey);
		params.put("linkId",order.getLinkId());
		List<BOAlmWorkflow> fromWorkflows = commonDAO.findByJPAQL(hql, params,true);
		if(fromWorkflows==null||fromWorkflows.size()==0){
			StringBuffer sb = new StringBuffer();
			sb.append("查询fromLinkId的workflow配置不唯一；查询条件为【");
			sb.append("processKey:" + processKey +",");
			sb.append("linkId:" + order.getLinkId());
			sb.append("】");
			sb.append("SQL:" + hql.toString());
			if (log.isErrorEnabled())
				log.error(sb);

			throw new Exception(sb.toString());
		}
		String fromLinkNoType = fromWorkflows.get(0).getLinkNoType();
		if(fromLinkNoType==null||fromLinkNoType.equals(WorkflowStaticDef.LINK_NO_TYPE_MGR)||
				fromLinkNoType.equals(WorkflowStaticDef.LINK_NO_TYPE_END)||
				fromLinkNoType.equals(WorkflowStaticDef.LINK_NO_TYPE_TERMINATION)){

			StringBuffer sb = new StringBuffer();
			sb.append("查询fromLinkNoType状态不对，不可以是"+WorkflowStaticDef.LINK_NO_TYPE_MGR+","+WorkflowStaticDef.LINK_NO_TYPE_END+","+WorkflowStaticDef.LINK_NO_TYPE_TERMINATION);

			if (log.isErrorEnabled())
				log.error(sb);

			throw new Exception(sb.toString());
		}

		params.clear();
		params.put("processKey",processKey);
		params.put("linkId",toLinkId);
		List<BOAlmWorkflow> toWorkflows = commonDAO.findByJPAQL(hql, params,true);
		if(toWorkflows==null||toWorkflows.size()==0){

			StringBuffer sb = new StringBuffer();
			sb.append("查询toLinkId的workflow配置不唯一；查询条件为【");
			sb.append("processKey:" + processKey +",");
			sb.append("linkId:" + toLinkId);
			sb.append("】");
			sb.append("SQL:" + hql.toString());
			if (log.isErrorEnabled())
				log.error(sb);

			throw new Exception(sb.toString());
		}

		String toLinkNoType = toWorkflows.get(0).getLinkNoType();

		if(toLinkNoType==null||toLinkNoType.equals(WorkflowStaticDef.LINK_NO_TYPE_MGR)||
				toLinkNoType.equals(WorkflowStaticDef.LINK_NO_TYPE_END)||
				toLinkNoType.equals(WorkflowStaticDef.LINK_NO_TYPE_TERMINATION)){

			StringBuffer sb = new StringBuffer();
			sb.append("查询fromLinkNoType状态不对，不可以是"+WorkflowStaticDef.LINK_NO_TYPE_MGR+","+WorkflowStaticDef.LINK_NO_TYPE_END+","+WorkflowStaticDef.LINK_NO_TYPE_TERMINATION);

			if (log.isErrorEnabled())
				log.error(sb);

			throw new Exception(sb.toString());
		}

		Map<String, Object> aVars = taskService.getVariables(order.getActTaskId().toString());
		aVars = this.analyzeCond(aVars, conds);
		aVars.put("result", result);
		aVars.put("reason", reason);
		aVars.put("cond", conds);

		this.nodeJump(task.getProcessDefinitionId(),task.getExecutionId(),fromWorkflows.get(0).getVmTaskNo(),toWorkflows.get(0).getVmTaskNo(),aVars);
	}

	/**
	 * 指定流转到节点，私有方法
	 * @param processDefId
	 * @param executionId
	 * @param fromTask
	 * @param toTask
	 * @param vars
	 * @throws Exception
	 */
	private void nodeJump(String processDefId,String executionId,String fromTask,String toTask,Map<String, Object> vars) throws Exception {

		ReadOnlyProcessDefinition processDefinitionEntity = (ReadOnlyProcessDefinition) repositoryService
				.getProcessDefinition(processDefId);
		ActivityImpl destinationActivity = (ActivityImpl) processDefinitionEntity
				.findActivity(toTask);
		ActivityImpl currentActivity = (ActivityImpl)processDefinitionEntity
				.findActivity(fromTask);
		managementService.executeCommand(
				new JDJumpTaskCmd(executionId, destinationActivity, vars,
						currentActivity));
	}

	@Override
	public void saveLinkStakeholder(String objId, String objType, List<StakeholderOprBO> stakeholderBOs)
			throws Exception {
		try{
			long id = Long.valueOf(objId);
			Map<Long, List<BOAlmStakeholder>> linkTypeMap = new HashMap<Long, List<BOAlmStakeholder>>();
			Map<Long, List<BOAlmStakeholder>> delLinkTypeMap = new HashMap<Long, List<BOAlmStakeholder>>();
			Set<Long> keys = new HashSet<Long>();
			for (int i = 0; stakeholderBOs != null && stakeholderBOs.size() >= 1 && i < stakeholderBOs.size(); i++) {
				if(stakeholderBOs.get(i).getStdholderStaffId() == null || stakeholderBOs.get(i).getStdholderStaffId().compareTo(0l) <= 0){
					if(log.isErrorEnabled()){
						log.error("保存环节处理人信息出错,员工ID:不合法,[linkId]="+stakeholderBOs.get(i).getLinkId());
					}
					throw new Exception("保存环节处理人信息出错,员工ID:不合法,[linkId]="+stakeholderBOs.get(i).getLinkId());
				}
				if(stakeholderBOs.get(i).getLinkId() == null || stakeholderBOs.get(i).getLinkId().compareTo(0l) <= 0){
					if(log.isErrorEnabled()){
						log.error("保存环节处理人信息出错,LinkId:不合法,[StdholderStaffId]="+stakeholderBOs.get(i).getStdholderStaffId());
					}
					throw new Exception("保存环节处理人信息出错,LinkId:不合法,[StdholderStaffId]="+stakeholderBOs.get(i).getStdholderStaffId());
				}
				List<BOAlmStakeholder> stakeholderList = null;
				if (stakeholderBOs.get(i).getIsDelete() != null && stakeholderBOs.get(i).getIsDelete()) {
					if (delLinkTypeMap.containsKey(stakeholderBOs.get(i).getLinkId())) {
						stakeholderList = delLinkTypeMap.get(stakeholderBOs.get(i).getLinkId());
					} else {
						stakeholderList = new LinkedList<BOAlmStakeholder>();
					}
					stakeholderList.add(StakeholderMapper.INSTANCE.boToDomain(stakeholderBOs.get(i)));
					delLinkTypeMap.put(stakeholderBOs.get(i).getLinkId(), stakeholderList);
				} else {
					if (linkTypeMap.containsKey(stakeholderBOs.get(i).getLinkId())) {
						stakeholderList = linkTypeMap.get(stakeholderBOs.get(i).getLinkId());
					} else {
						stakeholderList = new LinkedList<BOAlmStakeholder>();
					}
					stakeholderList.add(StakeholderMapper.INSTANCE.boToDomain(stakeholderBOs.get(i)));
					linkTypeMap.put(stakeholderBOs.get(i).getLinkId(), stakeholderList);
				}
				keys.add(stakeholderBOs.get(i).getLinkId());
			}
			Iterator<Long> keysIt = null;
			if (!keys.isEmpty()) {
				keysIt = keys.iterator();
			}
			while (keysIt != null && keysIt.hasNext()) {
				Long key = keysIt.next();
				// 查询环节已配置处理人
				String sql = "select o from BOAlmStakeholder o where o.objId=:objId and o.objType=:objType and o.linkId=:linkId";
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("objId", id);
				param.put("objType", objType);
				param.put("linkId", key);
				List<BOAlmStakeholder> almStakeholders = commonDAO.findByJPAQL(sql, param);
				// 查询环节类型
				sql = "select o from BOAlmWorkflow o where o.linkId=:linkId";
				param.clear();
				param.put("linkId", key);
				List<BOAlmWorkflow> almWorkflows = commonDAO.findByJPAQL(sql, param,true);
				if(almWorkflows == null || almWorkflows.size() == 0){
					if(log.isErrorEnabled()){
						log.error("保存环节处理人信息出错,查询条件:[linkId]="+key+",[sql]="+sql);
					}
					throw new Exception("查找环节信息出错,查询条件:[linkId]="+key+",[sql]="+sql);
				}
				// 启动环节和人工环节
				if(almWorkflows.get(0).getLinkNoType().equals(WorkflowStaticDef.LINK_NO_TYPE_MGR) || almWorkflows.get(0).getLinkNoType().equals(WorkflowStaticDef.LINK_NO_TYPE_USER)){
					// 删除处理人部分
					if (!delLinkTypeMap.isEmpty() && delLinkTypeMap.containsKey(key)) {
						if (almStakeholders == null || almStakeholders.isEmpty()) {
							if(log.isErrorEnabled()){
								log.error("删除环节处理人信息出错,[linkId]="+key+",未配置处理人");
							}
							throw new Exception("删除环节处理人信息出错,[linkId]="+key+",未配置处理人");
						}
						if (almStakeholders.get(0).getStdholderStaffId().compareTo(delLinkTypeMap.get(key).get(0).getStdholderStaffId()) == 0) {
							commonDAO.delete(almStakeholders.get(0));
						} else {
							if(log.isErrorEnabled()){
								log.error("删除环节处理人信息出错,[linkId]="+key+",处理人员工ID不符");
							}
							throw new Exception("删除环节处理人信息出错,[linkId]="+key+",处理人员工ID不符");
						}
					}
					// 更新和新增处理人部分
					else {
						BOAlmStakeholder holder = null;
						if (almStakeholders != null && almStakeholders.size() == 1) {
							holder = almStakeholders.get(0);
							holder.setStdholderStaffId(linkTypeMap.get(key).get(0).getStdholderStaffId());
							holder.setStdholderStaffName(linkTypeMap.get(key).get(0).getStdholderStaffName());
							holder.setStdholderStaffNo(linkTypeMap.get(key).get(0).getStdholderStaffNo());
							holder.setRoleCode(linkTypeMap.get(key).get(0).getRoleCode());
							holder.setRoleId(linkTypeMap.get(key).get(0).getRoleId());
							holder.setStdholderStaffOrgId(linkTypeMap.get(key).get(0).getStdholderStaffOrgId());
						} else {
							holder = linkTypeMap.get(key).get(0);
						}
						holder.setCreateTime(new Timestamp(System.currentTimeMillis()));
						holder.setObjId(id);
						holder.setObjType(objType);
						holder.setLinkNo(almWorkflows.get(0).getLinkNo());
						holder.setProcessKey(almWorkflows.get(0).getProcessKey());
						holder.setStdholdeType(WorkflowStaticDef.STAKEHOLDERTYPE_WF);
						commonDAO.save(holder);
					}
				} 
				// 会签环节
				else if(almWorkflows.get(0).getLinkNoType().equals(WorkflowStaticDef.LINK_NO_TYPE_SIGN)){
					Map<Long, BOAlmStakeholder> resultStakeholderMap = new HashMap<Long, BOAlmStakeholder>();
					for (int i = 0; almStakeholders != null && !almStakeholders.isEmpty() && almStakeholders.size() >= 1 && i < almStakeholders.size(); i++) {
						if(almStakeholders.get(i).getStdholderStaffId() == null || almStakeholders.get(i).getStdholderStaffId().compareTo(0l) <= 0){
							if(log.isErrorEnabled()){
								log.error("保存环节处理人信息出错,查询到的员工ID:不合法,[linkId]="+key);
							}
							throw new Exception("保存环节处理人信息出错,查询到的员工ID:不合法,[linkId]="+key);
						}
						resultStakeholderMap.put(almStakeholders.get(i).getStdholderStaffId(), almStakeholders.get(i));
					}
					// 删除处理人部分
					if (!delLinkTypeMap.isEmpty() && delLinkTypeMap.containsKey(key)) {
						if (almStakeholders == null || almStakeholders.isEmpty()) {
							if(log.isErrorEnabled()){
								log.error("删除环节处理人信息出错,[linkId]="+key+",未配置处理人");
							}
							throw new Exception("删除环节处理人信息出错,[linkId]="+key+",未配置处理人");
						}
						List<BOAlmStakeholder> stakeholderList = delLinkTypeMap.get(key);
						for (int i = 0; i < stakeholderList.size(); i++) {
							if (resultStakeholderMap.containsKey(stakeholderList.get(i).getStdholderStaffId())) {
								commonDAO.delete(resultStakeholderMap.get(stakeholderList.get(i).getStdholderStaffId()));
							} else {
								if(log.isErrorEnabled()){
									log.error("删除环节处理人信息出错,[linkId]="+key+",处理人员工ID不符");
								}
								throw new Exception("删除环节处理人信息出错,[linkId]="+key+",处理人员工ID不符");
							}
						}
					}
					// 更新和新增处理人部分
					if (!linkTypeMap.isEmpty() && linkTypeMap.containsKey(key)) {
						BOAlmStakeholder holder = null;
						List<BOAlmStakeholder> stakeholderList = linkTypeMap.get(key);
						for (int i = 0; i < stakeholderList.size(); i++) {
							if (resultStakeholderMap.containsKey(stakeholderList.get(i).getStdholderStaffId())) {
								holder = resultStakeholderMap.get(stakeholderList.get(i).getStdholderStaffId());
								holder.setStdholderStaffId(stakeholderList.get(i).getStdholderStaffId());
								holder.setStdholderStaffName(stakeholderList.get(i).getStdholderStaffName());
								holder.setStdholderStaffNo(stakeholderList.get(i).getStdholderStaffNo());
								holder.setRoleCode(stakeholderList.get(i).getRoleCode());
								holder.setRoleId(stakeholderList.get(i).getRoleId());
								holder.setStdholderStaffOrgId(stakeholderList.get(i).getStdholderStaffOrgId());
							} else {
								holder = stakeholderList.get(i);
							}
							holder.setCreateTime(new Timestamp(System.currentTimeMillis()));
							holder.setObjId(id);
							holder.setObjType(objType);
							holder.setLinkNo(almWorkflows.get(0).getLinkNo());
							holder.setProcessKey(almWorkflows.get(0).getProcessKey());
							holder.setStdholdeType(WorkflowStaticDef.STAKEHOLDERTYPE_WF);
							commonDAO.save(holder);
						}
					}
				}
				// 其他未知环节
				else{
					if(log.isErrorEnabled()){
						log.error("未知环节类型,类型为:"+almWorkflows.get(0).getLinkNoType());
					}
					throw new Exception("未知环节类型,类型为:"+almWorkflows.get(0).getLinkNoType());
				}
			}
		} catch (Exception e) {
			if(log.isErrorEnabled()){
				log.error("保存处理人出错,方法：com.asiainfo.platform.service.process.impl.AlmProcessRoamSVImpl." +
						"saveStakeholder(String objId,String objType, List<BOAlmStakeholder> almStakeholder)");
			}
			throw new Exception("保存工单和处理人出错:"
					+ (e.getCause() == null ? e.getMessage() : e.getCause()
							.getMessage()), e);
		}
	}

	@Override
	public List<StakeholderBO> queryStakeholder(String objId, String objType, Long linkId) throws Exception {
		String sql = "select o from BOAlmStakeholder o where o.objId=:objId and o.objType=:objType and o.linkId=:linkId";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("objId", Long.valueOf(objId));
		param.put("objType", objType);
		param.put("linkId", linkId);
		List<BOAlmStakeholder> almStakeholders = commonDAO.findByJPAQL(sql, param);
		return StakeholderMapper.INSTANCE.domainToBo(almStakeholders);
	}

	@Override
	public List<StakeholderBO> queryStakeholder(String objId, Long linkId) throws Exception {
		String sql = "select o from BOAlmStakeholder o where o.objId=:objId and o.linkId=:linkId";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("objId", Long.valueOf(objId));
		param.put("linkId", linkId);
		List<BOAlmStakeholder> almStakeholders = commonDAO.findByJPAQL(sql, param);
		return StakeholderMapper.INSTANCE.domainToBo(almStakeholders);
	}

	@Override
	public void updateWorkorder(WorkorderBO workorderBO) throws Exception {
		log.info("update alm_workorder");
		String hql = "update alm_workorder set result=?, opinion=?, plantime_temp=? where order_id=?";
		Map<Integer, Object> param = new HashMap<Integer, Object>();
		param.put(1, StringUtils.isBlank(workorderBO.getResult()) ? "" : workorderBO.getResult());
		param.put(2, StringUtils.isBlank(workorderBO.getOpinion()) ? "" : workorderBO.getOpinion());
		param.put(3, StringUtils.isBlank(workorderBO.getPlantimeTemp()) ? "" : workorderBO.getPlantimeTemp());
		if (workorderBO.getOrderId() == null || workorderBO.getOrderId().compareTo(0l) <= 0) {
			throw new Exception("无法更新工单信息, 缺少工单主键");
		} else {
			param.put(4, workorderBO.getOrderId());
		}
		int count = commonDAO.updateBySql(hql, param);
		log.info("count: " + count);
	}

	@Override
	public WorkorderBO queryWorkorder(Long orderId) throws Exception {
		String sql = "select o from BOAlmWorkorder o where o.orderId=:orderId";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("orderId", Long.valueOf(orderId));
		List<BOAlmWorkorder> almWorkorders = commonDAO.findByJPAQL(sql, param);
		if (almWorkorders != null && almWorkorders.size() == 1) {
			return WorkorderMapper.INSTANCE.domainToBo(almWorkorders.get(0));
		} else {
			throw new Exception("无法查询到该条工单");
		}
	}

	@Override
	public String updateTemplate(String templateName,String templatepath) throws Exception {
//		templatepath="D:/workspace/ats/hunan20170821/rms/workflow-xj/workflow-xj-api/src/main/resources/processes/";
		String path=templatepath+templateName;
	    File file=new File(path);
	    FileInputStream fis=new FileInputStream(file);
	    InputStreamReader isr=new InputStreamReader(fis,"utf-8");
	    BufferedReader br=new BufferedReader(isr);
	    StringBuffer line=new StringBuffer();
	    String str=null;
	    while((str=br.readLine())!=null){
		    line.append(str);
		    line.append("\n");
	    }
	    br.close();
	    isr.close();
	    fis.close();
	    String hql = "SELECT o FROM BOactGeBytearray o WHERE 1=1";
        Map<String, Object> param = new HashMap<String, Object>();
//        hql += " and deploymentId=:deploymentId ";
//        param.put("deploymentId", "77501");
        hql += " and name like :name ";
        param.put("name", "%"+templateName);
//        List<BOactGeBytearray> list=null;
//			list = commonDAO.findByJPAQL(hql, param);
//        if (null!=list && list.size() > 0) {
//        	for(BOactGeBytearray value:list){
//        		value.setBytes(line.toString().getBytes());
//					commonDAO.saveOrUpdate(value, BOactGeBytearray.class);
//        	}
//        }
		return "success";
	}
//	
//	@SuppressWarnings("rawtypes")
//	public void sendOaRecord(String objId,String objType ,String orderId,Date starttime, Date closetime,String status,String processKey,String taskId ,String staffId)throws Exception{
//		if("N".equals(isSendOther)){
//			log.error("不发其他平台，接口调用参数列表 ：{objId："+objId+",orderId:"+orderId+"};");
//			return ;
//		}
//		
//		log.error("【发送短信数据】objId:"+ objId + " objType:"  + objType + " orderId:" + orderId + " starttime:" +  starttime + " closetime:" +  closetime + " status:" +  status + " processKey:" +  processKey + " taskId:" +  taskId + " staffId:" +  staffId);
//		
//		String sql = new String();
//		sql = "select o from BOAlmWorkflowTemplate o where o.objType=:objType ";
//		Map param = new HashMap();
//		param.put("objType", objType);
//		List<BOAlmWorkflowTemplate> workflowTemplate = commonDAO.findByJPAQL(sql, param);
//		if(null==workflowTemplate || workflowTemplate.size()<=0){
//			throw new Exception("业务类型objType为 :"+objType+"没有查询到对应的业务类型数据");
//		}
//		sql = new String();
//		sql = "select o from BOAlmWorkorder o where o.objId=:objId and o.orderId=:orderId ";
//		param = new HashMap();
//		param.put("objId", Long.parseLong(objId));
//		param.put("orderId", Long.parseLong(orderId));
//		List<BOAlmWorkorder> workorders = commonDAO.findByJPAQL(sql, param);
//		if(null==workorders || workorders.size()<=0){
//			log.error("业务编号objId为 :"+objId+"工单编号orderId为："+orderId+"没有查询到对应的工单数据");
//			throw new Exception("业务编号objId为 :"+objId+"工单编号orderId为："+orderId+"没有查询到对应的工单数据");
//		}
//		log.error("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@1");
//		sql = new String();
//		param = new HashMap();
//		sql = "select o from BOSysStaff o where   o.staffId=:staffId";
//		param.put("staffId", workorders.get(0).getExecStaffId());
//		List<BOSysStaff> sysStaffs = commonDAO.findByJPAQL(sql,param);
//		if(null==sysStaffs || sysStaffs.size()<=0){
//			log.error("staffId为 :"+staffId+" 没有查询到对应的人员信息");
//			throw new Exception("staffId为 :"+staffId+" 没有查询到对应的人员信息");
//		}
//		String tempBillId = sysStaffs.get(0).getBillId();
//		String tempStaffCode = sysStaffs.get(0).getCode();
//		
////		sql = new String();
////		param = new HashMap();
////		sql = "select o from BOAlmStakeholder o where   o.linkId=:linkId   and o.objId=:objId and o.objType=:objType and o.stdholdeType=:stdholdeType  ";
//////		param.put("processKey",processKey);
////		param.put("linkId", workorders.get(0).getLinkId());
////		param.put("objId", Long.valueOf(objId));
////		param.put("objType", objType);
////		param.put("stdholdeType", WorkflowStaticDef.STAKEHOLDERTYPE_WF);
////		if(!"".equals( staffId)){
////			sql = sql+" and o.stdholderStaffId=:stdholderStaffId";
////			param.put("stdholderStaffId", Long.valueOf(staffId));
////		}
////		List<BOAlmStakeholder> almStakeholders = commonDAO.findByJPAQL(sql,param);
////		if(null==almStakeholders || almStakeholders.size()<=0){
////			log.error("环节编号linkId为 :"+workorders.get(0).getLinkId()+" 业务编号objId为："+objId +"业务类型："+objType +" stdholdeType:2"+" staffId:"+staffId+" 没有查询到对应的干系人数据数据");
////			throw new Exception("环节编号linkId为 :"+workorders.get(0).getLinkId()+" 业务编号objId为："+objId +"业务类型："+objType +" stdholdeType:2"+" staffId:"+staffId+" 没有查询到对应的干系人数据数据");
////		}
//		log.error("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2");
//		String objName = "";
//		String submitStaffName = "";
//		sql = new String();
//		param = new HashMap();
//		sql = "select o from BOWorkorderList o where  o.objId=:objId and o.objType=:objType";
//		param.put("objId", Integer.valueOf(objId));
//		param.put("objType", objType);
//		List<BOWorkorderList> workorderList = commonDAO.findByJPAQL(sql,param);
//		if(null!=workorderList && workorderList.size()>0){
//			objName=workorderList.get(0).getObjName();
//			submitStaffName=workorderList.get(0).getSubmitstaffname();
//		}
//		log.error("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@3");
//		
//		log.error("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@4");
//		log.error(" objId:" + objId);
//		log.error(" objType:" + objType);
//		log.error(" ProcessName:" + workflowTemplate.get(0).getProcessName());
//		log.error(" objName:" + objName);
//		log.error(" orderId:" + orderId);
//		log.error(" StdholderStaffNo:" + tempStaffCode);
//		log.error(" starttime:" + starttime);
//		log.error(" closetime:" + closetime);
//		log.error(" status:" + status);
//		log.error(" submitStaffName:" + submitStaffName);
//		log.error("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@41");
//		
//		
//		
//		log.error("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@5");
//		String secdInfo = "objId:"+objId+" objType:"+objType+" objTypeName:"+workflowTemplate.get(0).getProcessName()+" objTitle"+objName+
//				" orderId:"+orderId+" exeStaffCode:"+tempStaffCode+" starttime:"+starttime+
//				" closetime:"+closetime+" status:"+status+" lastLinkNoStaffName: " ;
//		log.error("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@6");
//		
//		log.error("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@7");
//		
//	}
	
	public void saveWorkorder(WorkorderBO workorderBO) throws Exception{
		commonDAO.saveOrUpdate(WorkorderMapper.INSTANCE.boToDomain(workorderBO), BOAlmWorkorder.class);
	}
	

	 @Override
	 public List<WorkorderBO> queryWorkorder(Long objId, Long linkId) throws Exception {
	  String sql = "select o from BOAlmWorkorder o where o.objId=:objId and o.linkId=:linkId";
	  Map<String, Object> param = new HashMap<String, Object>();
	  param.put("objId", objId);
	  param.put("linkId", linkId);
	  List<BOAlmWorkorder> almWorkorders = commonDAO.findByJPAQL(sql, param);
	  return WorkorderMapper.INSTANCE.domainToBoList(almWorkorders);
	 }
	
}
