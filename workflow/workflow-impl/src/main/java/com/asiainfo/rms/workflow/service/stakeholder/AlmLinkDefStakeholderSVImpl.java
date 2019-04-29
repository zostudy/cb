package com.asiainfo.rms.workflow.service.stakeholder;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.asiainfo.rms.workflow.bo.workflow.StakeholderBO;
import com.asiainfo.rms.workflow.bo.workflow.WorkflowBO;
import com.asiainfo.rms.workflow.common.constance.ConstDefine;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.workflow.BOSysStaffManagerRelat;
import com.asiainfo.rms.workflow.service.workflow.IAlmWorkflowSV;

import lombok.extern.log4j.Log4j;

@Log4j
@Service("linkDefStakeholderSV")
@Transactional(rollbackOn = Exception.class)
public class AlmLinkDefStakeholderSVImpl implements IAlmLinkDefStakeholderSV {
	@Resource(name="commonDao")
	private CommonDAO commonDAO;
	@Resource(name="almStakeholderSV")
	private IAlmStakeholderSV almStakeholderSV;
	@Resource(name="workflowSV")
	private IAlmWorkflowSV workflowSV;
	
	
	private void newStakeholder(String jpqSql, Map param, String linkNo, Long objId, String objType) throws Exception{
		log.info("为需求添加默认干系人需求ID为：" + objId + "!");
		List<BOSysStaffManagerRelat> staffMList = commonDAO.findByJPAQL(jpqSql, param);
		if(staffMList.size() != 1){
			log.error("查询默认干系人配置信息出错，配置不唯一！SQL:" + jpqSql + " 参数为:"+ param + "!");
			throw new Exception("查询默认干系人配置信息出错，配置不唯一！SQL:" + jpqSql + " 参数为:"+ param + "!");
		}
		WorkflowBO wf = workflowSV.getWorkflowByLinkNo(linkNo);
		if(wf == null){
			log.error("查询流程环节配置信息出错，配置不唯一！linkNo:" + linkNo + "!");
			throw new Exception("查询流程环节配置信息出错，配置不唯一！linkNo:" + linkNo + "!");
		}
		StakeholderBO sta = new StakeholderBO();
		sta.setProcessKey(wf.getProcessKey());
		sta.setLinkId(wf.getLinkId());
		sta.setLinkNo(wf.getLinkNo());
		sta.setObjId(objId);
		sta.setObjType(objType);
		sta.setStdholderStaffId(staffMList.get(0).getStaffId());
		sta.setStdholderStaffName(staffMList.get(0).getStaffName());
		sta.setStdholdeType(ConstDefine.STDHOLDE_TYPE_APPROVAL);
		sta.setCreateTime(new Date());
		almStakeholderSV.saveStakeholder(sta);
	}
	
	
	private void newReqResponsibleStakeholder( String linkNo, Long objId, String objType, Long staffId, String staffName, String staffCode) throws Exception{
		log.info("为需求添加默认干系人需求ID为：" + objId + "!");
		WorkflowBO wf = workflowSV.getWorkflowByLinkNo(linkNo);
		if(wf == null){
			log.error("查询流程环节配置信息出错，配置不唯一！linkNo:" + linkNo + "!");
			throw new Exception("查询流程环节配置信息出错，配置不唯一！linkNo:" + linkNo + "!");
		}
		StakeholderBO sta = new StakeholderBO();
		sta.setProcessKey(wf.getProcessKey());
		sta.setLinkId(wf.getLinkId());
		sta.setLinkNo(wf.getLinkNo());
		sta.setObjId(objId);
		sta.setObjType(objType);
		sta.setStdholderStaffId(staffId);
		sta.setStdholderStaffName(staffName);
		sta.setStdholderStaffNo(staffCode);
		sta.setStdholdeType(ConstDefine.STDHOLDE_TYPE_APPROVAL);
		sta.setCreateTime(new Date());
		almStakeholderSV.saveStakeholder(sta);
	}
	@Override
	public void saveDefStakeholders(String processKey, Long sysTag, Long objId) throws Exception {
		List<StakeholderBO> stakeholderList = new ArrayList<StakeholderBO>();
		WorkflowBO  workflowBO = workflowSV.getWorkflowByLinkId(null);
		Map<String,Object> param = new HashMap<String,Object>();
		String jpaSql = "select o from BOSysStaffManagerRelat o where o.sysTag = :sysTag and o.reqType = :reqType";
		String jpaSql2 = "select o from BOSysStaffManagerRelat o where o.sysTag = :sysTag and o.reqType is null";
		
		if(ConstDefine.TEMPLATE_KEY_WORKFLOW_BAREQ.equals(processKey))//经分
		{
			//根据OA给出的需求负责人，插入负责人相关环节的干系人
			//addReqResLink(String.valueOf(reqExtend.getReqRespStaffId()),reqExtend.getReqRespStaffName(),req.getReqId(),IObjectType.REQUISITION,String.valueOf(rt));	
			//根据配置查找需求分配干系人
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "10", String.valueOf(workflowParam.getREQALLOTBA().getLinkId()), workflowParam.getREQALLOTBA().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "10");
			newStakeholder(jpaSql,param,"ReqAllotBA",objId,ConstDefine.OBJ_TYPE_BAREQ);
			//根据配置查找经分需求负责人主管
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "50", String.valueOf(workflowParam.getREQCOMVERIFYBA().getLinkId()), workflowParam.getREQCOMVERIFYBA().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "50");
			newStakeholder(jpaSql,param,"ReqComVerifyBA",objId,ConstDefine.OBJ_TYPE_BAREQ);
			
			//根据配置查找经分需求负责人上线发布
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "5", String.valueOf(workflowParam.getONLINERELBA().getLinkId()), workflowParam.getONLINERELBA().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "5");
			newStakeholder(jpaSql,param,"OnlineRelBA",objId,ConstDefine.OBJ_TYPE_BAREQ);

			//根据配置查找经分业支审核人员
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "18", String.valueOf(workflowParam.getBUSITERMVERIFYBA().getLinkId()), workflowParam.getBUSITERMVERIFYBA().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "18");
			newStakeholder(jpaSql,param,"BusiTermVerifyBA",objId,ConstDefine.OBJ_TYPE_BAREQ);

			//根据配置查找经分开发分配人员
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "18", String.valueOf(workflowParam.getBUSITERMVERIFY().getLinkId()), workflowParam.getBUSITERMVERIFY().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "15");
			newStakeholder(jpaSql,param,"DevAllotBA",objId,ConstDefine.OBJ_TYPE_BAREQ);

			//根据配置查找经分集成商测试分配人员
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "18", String.valueOf(workflowParam.getBUSITERMVERIFY().getLinkId()), workflowParam.getBUSITERMVERIFY().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "16");
			newStakeholder(jpaSql,param,"SIAllotTestBA",objId,ConstDefine.OBJ_TYPE_BAREQ);

			//启动流程
			//x = ComframeClient.getDefaultComframeClient().createWorkflow("com.asiainfo.hunan.req.workflow.BAreq", new Long(reqExtend.getSubmitStaffId()).toString(), IObjectType.REQUISITION, new Long(req.getReqId()).toString(), aVars, null, "经分需求流程");
		}else if(ConstDefine.TEMPLATE_KEY_WORKFLOW_REQ.equals(processKey)){//启动BOSS流程
			//根据OA给出的需求负责人，插入负责人相关环节的干系人
			//addReqResLink(String.valueOf(reqExtend.getReqRespStaffId()),reqExtend.getReqRespStaffName(),req.getReqId(),IObjectType.REQUISITION,String.valueOf(rt));
			//根据配置查找需求分配干系人
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "10", String.valueOf(workflowParam.getREQALLOT().getLinkId()), workflowParam.getREQALLOT().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "10");
			newStakeholder(jpaSql,param,"ReqAllot",objId,ConstDefine.OBJ_TYPE_REQ);
			
			//根据配置查找第三方接单人员
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "17", String.valueOf(workflowParam.getTHIRDREQALLOT().getLinkId()), workflowParam.getTHIRDREQALLOT().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "17");
			newStakeholder(jpaSql,param,"ThirdReqAllot",objId,ConstDefine.OBJ_TYPE_REQ);
			
			//根据配置查找第三方分配人员
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "17", String.valueOf(workflowParam.getTHIRDALLOT().getLinkId()), workflowParam.getTHIRDALLOT().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "17");
			newStakeholder(jpaSql,param,"ThirdAllot",objId,ConstDefine.OBJ_TYPE_REQ);
			
			
			//根据配置查找需求负责人主管
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "50", String.valueOf(workflowParam.getBUSITESTLEADERVERIFY().getLinkId()), workflowParam.getBUSITESTLEADERVERIFY().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "50");
			newStakeholder(jpaSql,param,"BusiTestLeaderVerify",objId,ConstDefine.OBJ_TYPE_REQ);
			
			//根据配置查找需求发布负责人
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "4", String.valueOf(workflowParam.getREQTOBERELEASED().getLinkId()), workflowParam.getREQTOBERELEASED().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "4");
			newStakeholder(jpaSql,param,"ReqTobeReleased",objId,ConstDefine.OBJ_TYPE_REQ);
			
			//根据配置差宅运营室审核人员
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "30", String.valueOf(workflowParam.getOPERATEVERIFY().getLinkId()), workflowParam.getOPERATEVERIFY().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "30");
			newStakeholder(jpaSql,param,"OperateVerify",objId,ConstDefine.OBJ_TYPE_REQ);
			
			//根据配置查找上线发布人员
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "5", String.valueOf(workflowParam.getREQRELEASE().getLinkId()), workflowParam.getREQRELEASE().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "5");
			newStakeholder(jpaSql,param,"ReqRelease",objId,ConstDefine.OBJ_TYPE_REQ);
			
			//根据配置查找运营室交付人员
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "31", String.valueOf(workflowParam.getREQDELIVER().getLinkId()), workflowParam.getREQDELIVER().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "31");
			newStakeholder(jpaSql,param,"ReqDeliver",objId,ConstDefine.OBJ_TYPE_REQ);
			
			//根据配置查找BOSS需求归档人
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "0", String.valueOf(workflowParam.getREQARCHIVE().getLinkId()), workflowParam.getREQARCHIVE().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );				
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "0");
			newStakeholder(jpaSql,param,"ReqArchive",objId,ConstDefine.OBJ_TYPE_REQ);
			
			//根据配置查找BOSS业支审核人员
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "18", String.valueOf(workflowParam.getBUSITERMVERIFY().getLinkId()), workflowParam.getBUSITERMVERIFY().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );				
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "18");
			newStakeholder(jpaSql,param,"BusiTermVerify",objId,ConstDefine.OBJ_TYPE_REQ);

			//根据配置查找BOSS开发分配人员
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "18", String.valueOf(workflowParam.getBUSITERMVERIFY().getLinkId()), workflowParam.getBUSITERMVERIFY().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "15");
			newStakeholder(jpaSql,param,"DevAllot",objId,ConstDefine.OBJ_TYPE_REQ);

			//根据配置查找BOSS集成商测试分配人员
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "18", String.valueOf(workflowParam.getBUSITERMVERIFY().getLinkId()), workflowParam.getBUSITERMVERIFY().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "16");
			newStakeholder(jpaSql,param,"SIAllotTest",objId,ConstDefine.OBJ_TYPE_REQ);
			
			//启动流程
			//x = ComframeClient.getDefaultComframeClient().createWorkflow("com.asiainfo.hunan.req.workflow.req", new Long(reqExtend.getSubmitStaffId()).toString(), IObjectType.REQUISITION, new Long(req.getReqId()).toString(), aVars, null, "BOSS需求流程");
		}else if(ConstDefine.TEMPLATE_KEY_WORKFLOW_ELCCHANEL.equals(processKey)){//启动电渠流程
			//根据OA给出的需求负责人，插入负责人相关环节的干系人
			//addReqResLink(String.valueOf(reqExtend.getReqRespStaffId()),reqExtend.getReqRespStaffName(),req.getReqId(),IObjectType.REQUISITION,String.valueOf(rt));
			//根据配置查找需求分配干系人
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "10", String.valueOf(workflowParam.getREQALLOT_ELC().getLinkId()), workflowParam.getREQALLOT_ELC().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "10");
			newStakeholder(jpaSql,param,"ReqAllot_elc",objId,ConstDefine.OBJ_TYPE_ELCCHANEL);
			
			
			//根据配置查找需求负责人主管
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "50", String.valueOf(workflowParam.getBUSITESTLEADERVERIFY_ELC().getLinkId()), workflowParam.getBUSITESTLEADERVERIFY_ELC().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			//环节已删除
			
			//根据配置查找需求发布负责人
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "4", String.valueOf(workflowParam.getREQTOBERELEASED_ELC().getLinkId()), workflowParam.getREQTOBERELEASED_ELC().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "4");
			newStakeholder(jpaSql,param,"ReqTobeReleased_elc",objId,ConstDefine.OBJ_TYPE_ELCCHANEL);
			
			//根据配置差宅运营室审核人员
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "30", String.valueOf(workflowParam.getOPERATEVERIFY_ELC().getLinkId()), workflowParam.getOPERATEVERIFY_ELC().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "30");
			newStakeholder(jpaSql,param,"OperateVerify_elc",objId,ConstDefine.OBJ_TYPE_ELCCHANEL);
			
			//根据配置查找上线发布人员
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "5", String.valueOf(workflowParam.getREQRELEASE_ELC().getLinkId()), workflowParam.getREQRELEASE_ELC().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "5");
			newStakeholder(jpaSql,param,"ReqRelease_elc",objId,ConstDefine.OBJ_TYPE_ELCCHANEL);
			
			//根据配置查找运营室交付人员
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "31", String.valueOf(workflowParam.getREQDELIVER_ELC().getLinkId()), workflowParam.getREQDELIVER_ELC().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "31");
			newStakeholder(jpaSql,param,"ReqDeliver_elc",objId,ConstDefine.OBJ_TYPE_ELCCHANEL);
			
			//根据配置查找BOSS需求归档人
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "0", String.valueOf(workflowParam.getREQARCHIVE_ELC().getLinkId()), workflowParam.getREQARCHIVE_ELC().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );				
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "0");
			newStakeholder(jpaSql,param,"ReqArchive_elc",objId,ConstDefine.OBJ_TYPE_ELCCHANEL);
			
			//根据配置查找电渠业支审核人
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "18", String.valueOf(workflowParam.getBUSITERMVERIFY_ELC().getLinkId()), workflowParam.getBUSITERMVERIFY_ELC().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );				
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "18");
			newStakeholder(jpaSql,param,"BusiTermVerify_elc",objId,ConstDefine.OBJ_TYPE_ELCCHANEL);

			//根据配置查找电渠开发分配人员
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "18", String.valueOf(workflowParam.getBUSITERMVERIFY().getLinkId()), workflowParam.getBUSITERMVERIFY().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "15");
			newStakeholder(jpaSql,param,"DevAllot_elc",objId,ConstDefine.OBJ_TYPE_ELCCHANEL);

			//根据配置查找电渠集成商测试分配人员
			//iReqTaskService.addStakeholderByConfig(String.valueOf(req.getSysTag()), "18", String.valueOf(workflowParam.getBUSITERMVERIFY().getLinkId()), workflowParam.getBUSITERMVERIFY().getLinkNo(), String.valueOf(req.getReqId()),IObjectType.REQUISITION );
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "16");
			newStakeholder(jpaSql,param,"SIAllotTest_elc",objId,ConstDefine.OBJ_TYPE_ELCCHANEL);
			
			//启动流程
			//x = ComframeClient.getDefaultComframeClient().createWorkflow("com.asiainfo.hunan.req.workflow.ElcChanelReq", new Long(reqExtend.getSubmitStaffId()).toString(), IObjectType.REQUISITION, new Long(req.getReqId()).toString(), aVars, null, "电渠需求流程");
		}else if(ConstDefine.TEMPLATE_KEY_WORKFLOW_VERSION.equals(processKey)){
			//根据配置查找版本修改负责人
			//iReqTaskService.addStakeholderByConfig(String.valueOf(reqReqValue.getSysTag()), "4", String.valueOf(workflowParam.getMODIFYVERSION().getLinkId()), workflowParam.getMODIFYVERSION().getLinkNo(), String.valueOf(versId),IObjectType.VERSION );
			
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "4");
			newStakeholder(jpaSql,param,"ModifyVersion",objId,ConstDefine.OBJ_TYPE_VERSION);
			
			//根据配置查找运营室审核人员，此处由于是多个需求，所以整体上线需求由BOSS运营室审核人员处理
			//iReqTaskService.addStakeholderByConfig(String.valueOf(reqReqValue.getSysTag()), "30", String.valueOf(workflowParam.getOPERVERIFYVERSION().getLinkId()), workflowParam.getOPERVERIFYVERSION().getLinkNo(), String.valueOf(versId),IObjectType.VERSION );
			
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "30");
			newStakeholder(jpaSql,param,"OperVerifyVersion",objId,ConstDefine.OBJ_TYPE_VERSION);
			
			//根据配置查找上线发布人员
			//iReqTaskService.addStakeholderByConfig(String.valueOf(reqReqValue.getSysTag()), "5", String.valueOf(workflowParam.getONLINERESVERSION().getLinkId()), workflowParam.getONLINERESVERSION().getLinkNo(), String.valueOf(versId),IObjectType.VERSION );
			
			param = new HashMap<String,Object>();
			param.put("sysTag", sysTag);
			param.put("reqType", "5");
			newStakeholder(jpaSql,param,"OnlineResVersion",objId,ConstDefine.OBJ_TYPE_VERSION);
			
			
		}
		
		

		
		
	}
	
	
	@Override
	public void saveReqResponsibleStakeholders(String processKey, Long objId, Long staffId, String staffName, String staffCode) throws Exception{
		WorkflowBO  workflowBO = workflowSV.getWorkflowByLinkId(null);
		Map<String,Object> param = new HashMap<String,Object>();

		if (ConstDefine.TEMPLATE_KEY_WORKFLOW_REQ.equals(processKey)) 
		{
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjId, woValue.getObjId());
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjType,IObjectType.REQUISITION);
//			sqlCriteria.addEqual(IBOStakeholderValue.S_LinkNo,workflowParam.getANALYSISVERIFY().getLinkNo());
//			sthValues = iSthSV.getStakeholderByCondition(sqlCriteria.toString(), sqlCriteria.getParameters());
//			sthValues[0].setStdholderStaffId(value.getStdholderStaffId());
//			sthValues[0].setStdholderStaffName(value.getStdholderStaffName());
//			iSthSV.saveStakeholder(sthValues[0]);
			
			newReqResponsibleStakeholder("AnalysisVerify", objId, ConstDefine.OBJ_TYPE_REQ, staffId, staffName, staffCode);
			
//			sqlCriteria.clear();
//			sthValues = null;
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjId, woValue.getObjId());
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjType,IObjectType.REQUISITION);
//			sqlCriteria.addEqual(IBOStakeholderValue.S_LinkNo,workflowParam.getBUSITESTVERIFY().getLinkNo());
//			sthValues = iSthSV.getStakeholderByCondition(sqlCriteria.toString(), sqlCriteria.getParameters());
//			sthValues[0].setStdholderStaffId(value.getStdholderStaffId());
//			sthValues[0].setStdholderStaffName(value.getStdholderStaffName());
//			iSthSV.saveStakeholder(sthValues[0]);
			
			newReqResponsibleStakeholder("BusiTestVerify", objId, ConstDefine.OBJ_TYPE_REQ, staffId, staffName, staffCode);
			
//			sqlCriteria.clear();
//			sthValues = null;
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjId, woValue.getObjId());
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjType,IObjectType.REQUISITION);
//			sqlCriteria.addEqual(IBOStakeholderValue.S_LinkNo,workflowParam.getREQRESVERIFY().getLinkNo());
//			sthValues = iSthSV.getStakeholderByCondition(sqlCriteria.toString(), sqlCriteria.getParameters());
//			sthValues[0].setStdholderStaffId(value.getStdholderStaffId());
//			sthValues[0].setStdholderStaffName(value.getStdholderStaffName());
//			iSthSV.saveStakeholder(sthValues[0]);
			
			newReqResponsibleStakeholder("ReqResVerify", objId, ConstDefine.OBJ_TYPE_REQ, staffId, staffName, staffCode);
			
//			sqlCriteria.clear();
//			sthValues = null;
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjId, woValue.getObjId());
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjType,IObjectType.REQUISITION);
//			sqlCriteria.addEqual(IBOStakeholderValue.S_LinkNo,workflowParam.getREQONLINEVERIFY().getLinkNo());
//			sthValues = iSthSV.getStakeholderByCondition(sqlCriteria.toString(), sqlCriteria.getParameters());
//			sthValues[0].setStdholderStaffId(value.getStdholderStaffId());
//			sthValues[0].setStdholderStaffName(value.getStdholderStaffName());
//			iSthSV.saveStakeholder(sthValues[0]);

			newReqResponsibleStakeholder("ReqOnlineVerify", objId, ConstDefine.OBJ_TYPE_REQ, staffId, staffName, staffCode);
			
//			sqlCriteria.clear();
//			sthValues = null;
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjId, woValue.getObjId());
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjType,IObjectType.REQUISITION);
//			sqlCriteria.addEqual(IBOStakeholderValue.S_LinkNo,workflowParam.getTHIRDAYSVERIFY().getLinkNo());
//			sthValues = iSthSV.getStakeholderByCondition(sqlCriteria.toString(), sqlCriteria.getParameters());
//			if(sthValues!=null && sthValues.length>0){
//				sthValues[0].setStdholderStaffId(value.getStdholderStaffId());
//				sthValues[0].setStdholderStaffName(value.getStdholderStaffName());
//				iSthSV.saveStakeholder(sthValues[0]);
//			}
			newReqResponsibleStakeholder("ThirdAysVerify", objId, ConstDefine.OBJ_TYPE_REQ, staffId, staffName, staffCode);

			newReqResponsibleStakeholder("supSatisftCheck", objId, ConstDefine.OBJ_TYPE_REQ, staffId, staffName, staffCode);
			
			
		} else if (ConstDefine.TEMPLATE_KEY_WORKFLOW_BAREQ.equals(processKey)) 
		{
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjId, woValue.getObjId());
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjType,IObjectType.REQUISITION);
//			sqlCriteria.addEqual(IBOStakeholderValue.S_LinkNo,workflowParam.getANALYSISVERIFYBA().getLinkNo());
//			sthValues = iSthSV.getStakeholderByCondition(sqlCriteria.toString(), sqlCriteria.getParameters());
//			sthValues[0].setStdholderStaffId(value.getStdholderStaffId());
//			sthValues[0].setStdholderStaffName(value.getStdholderStaffName());
//			iSthSV.saveStakeholder(sthValues[0]);
			
			newReqResponsibleStakeholder("AnalysisVerifyBA", objId, ConstDefine.OBJ_TYPE_BAREQ, staffId, staffName, staffCode);
			
//			sqlCriteria.clear();
//			sthValues = null;
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjId, woValue.getObjId());
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjType,IObjectType.REQUISITION);
//			sqlCriteria.addEqual(IBOStakeholderValue.S_LinkNo,workflowParam.getREQRESVERIFYBA().getLinkNo());
//			sthValues = iSthSV.getStakeholderByCondition(sqlCriteria.toString(), sqlCriteria.getParameters());
//			sthValues[0].setStdholderStaffId(value.getStdholderStaffId());
//			sthValues[0].setStdholderStaffName(value.getStdholderStaffName());
//			iSthSV.saveStakeholder(sthValues[0]);
			
			newReqResponsibleStakeholder("ReqResVerifyBA", objId, ConstDefine.OBJ_TYPE_BAREQ, staffId, staffName, staffCode);
			
//			sqlCriteria.clear();
//			sthValues = null;
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjId, woValue.getObjId());
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjType,IObjectType.REQUISITION);
//			sqlCriteria.addEqual(IBOStakeholderValue.S_LinkNo,workflowParam.getREQARCHIVEBA().getLinkNo());
//			sthValues = iSthSV.getStakeholderByCondition(sqlCriteria.toString(), sqlCriteria.getParameters());
//			sthValues[0].setStdholderStaffId(value.getStdholderStaffId());
//			sthValues[0].setStdholderStaffName(value.getStdholderStaffName());
//			iSthSV.saveStakeholder(sthValues[0]);
			
			newReqResponsibleStakeholder("ReqArchiveBA", objId, ConstDefine.OBJ_TYPE_BAREQ, staffId, staffName, staffCode);
			
//			sqlCriteria.clear();
//			sthValues = null;
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjId, woValue.getObjId());
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjType,IObjectType.REQUISITION);
//			sqlCriteria.addEqual(IBOStakeholderValue.S_LinkNo,workflowParam.getREQRESTESTCFMVERIFYBA().getLinkNo());
//			sthValues = iSthSV.getStakeholderByCondition(sqlCriteria.toString(), sqlCriteria.getParameters());
//			if(sthValues != null && sthValues.length > 0){
//				sthValues[0].setStdholderStaffId(value.getStdholderStaffId());
//				sthValues[0].setStdholderStaffName(value.getStdholderStaffName());
//				iSthSV.saveStakeholder(sthValues[0]);
//			}
			
			newReqResponsibleStakeholder("ReqResTestCfmVerifyBA", objId, ConstDefine.OBJ_TYPE_BAREQ, staffId, staffName, staffCode);

			newReqResponsibleStakeholder("supSatisftCheckBA", objId, ConstDefine.OBJ_TYPE_BAREQ, staffId, staffName, staffCode);
			
		}else if (ConstDefine.TEMPLATE_KEY_WORKFLOW_ELCCHANEL.equals(processKey)) 
		{
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjId, woValue.getObjId());
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjType,IObjectType.REQUISITION);
//			sqlCriteria.addEqual(IBOStakeholderValue.S_LinkNo,workflowParam.getANALYSISVERIFY_ELC().getLinkNo());
//			sthValues = iSthSV.getStakeholderByCondition(sqlCriteria.toString(), sqlCriteria.getParameters());
//			sthValues[0].setStdholderStaffId(value.getStdholderStaffId());
//			sthValues[0].setStdholderStaffName(value.getStdholderStaffName());
//			iSthSV.saveStakeholder(sthValues[0]);
			
			newReqResponsibleStakeholder("AnalysisVerify_elc", objId, ConstDefine.OBJ_TYPE_ELCCHANEL, staffId, staffName, staffCode);
			
//			sqlCriteria.clear();
//			sthValues = null;
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjId, woValue.getObjId());
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjType,IObjectType.REQUISITION);
//			sqlCriteria.addEqual(IBOStakeholderValue.S_LinkNo,workflowParam.getBUSITESTVERIFY_ELC().getLinkNo());
//			sthValues = iSthSV.getStakeholderByCondition(sqlCriteria.toString(), sqlCriteria.getParameters());
//			sthValues[0].setStdholderStaffId(value.getStdholderStaffId());
//			sthValues[0].setStdholderStaffName(value.getStdholderStaffName());
//			iSthSV.saveStakeholder(sthValues[0]);
			
			newReqResponsibleStakeholder("BusiTestVerify_elc", objId, ConstDefine.OBJ_TYPE_ELCCHANEL, staffId, staffName, staffCode);
			
//			sqlCriteria.clear();
//			sthValues = null;
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjId, woValue.getObjId());
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjType,IObjectType.REQUISITION);
//			sqlCriteria.addEqual(IBOStakeholderValue.S_LinkNo,workflowParam.getREQRESVERIFY_ELC().getLinkNo());
//			sthValues = iSthSV.getStakeholderByCondition(sqlCriteria.toString(), sqlCriteria.getParameters());
//			sthValues[0].setStdholderStaffId(value.getStdholderStaffId());
//			sthValues[0].setStdholderStaffName(value.getStdholderStaffName());
//			iSthSV.saveStakeholder(sthValues[0]);
			
			newReqResponsibleStakeholder("ReqResVerify_elc", objId, ConstDefine.OBJ_TYPE_ELCCHANEL, staffId, staffName, staffCode);
			
//			sqlCriteria.clear();
//			sthValues = null;
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjId, woValue.getObjId());
//			sqlCriteria.addEqual(IBOStakeholderValue.S_ObjType,IObjectType.REQUISITION);
//			sqlCriteria.addEqual(IBOStakeholderValue.S_LinkNo,workflowParam.getREQONLINEVERIFY_ELC().getLinkNo());
//			sthValues = iSthSV.getStakeholderByCondition(sqlCriteria.toString(), sqlCriteria.getParameters());
//			sthValues[0].setStdholderStaffId(value.getStdholderStaffId());
//			sthValues[0].setStdholderStaffName(value.getStdholderStaffName());
//			iSthSV.saveStakeholder(sthValues[0]);
			
			//无此环节
			newReqResponsibleStakeholder("supSatisftCheck_elc", objId, ConstDefine.OBJ_TYPE_ELCCHANEL, staffId, staffName, staffCode);
			
		}
	}

	@Override
	public void saveReqSubmitStakeholders(String processKey, Long objId, Long staffId, String staffName, String staffCode) throws Exception{
		WorkflowBO  workflowBO = workflowSV.getWorkflowByLinkId(null);
		Map<String,Object> param = new HashMap<String,Object>();

		if (ConstDefine.TEMPLATE_KEY_WORKFLOW_REQ.equals(processKey))
		{

			newReqResponsibleStakeholder("ReqInput", objId, ConstDefine.OBJ_TYPE_REQ, staffId, staffName, staffCode);

			newReqResponsibleStakeholder("ReqSubStaffTestCfm", objId, ConstDefine.OBJ_TYPE_REQ, staffId, staffName, staffCode);

			newReqResponsibleStakeholder("BusiGrayTest", objId, ConstDefine.OBJ_TYPE_REQ, staffId, staffName, staffCode);

			newReqResponsibleStakeholder("ReqSubStaffSatiAsse", objId, ConstDefine.OBJ_TYPE_REQ, staffId, staffName, staffCode);

			newReqResponsibleStakeholder("ReqSubStaffAysCfm", objId, ConstDefine.OBJ_TYPE_REQ, staffId, staffName, staffCode);

		} else if (ConstDefine.TEMPLATE_KEY_WORKFLOW_BAREQ.equals(processKey))
		{

			newReqResponsibleStakeholder("ReqInputBA", objId, ConstDefine.OBJ_TYPE_BAREQ, staffId, staffName, staffCode);

			newReqResponsibleStakeholder("ReqSubmitTestBA", objId, ConstDefine.OBJ_TYPE_BAREQ, staffId, staffName, staffCode);

			newReqResponsibleStakeholder("ReqSubStaffAsseBA", objId, ConstDefine.OBJ_TYPE_BAREQ, staffId, staffName, staffCode);

			newReqResponsibleStakeholder("ReqSubStaffPlanComBA", objId, ConstDefine.OBJ_TYPE_BAREQ, staffId, staffName, staffCode);


		}else if (ConstDefine.TEMPLATE_KEY_WORKFLOW_ELCCHANEL.equals(processKey))
		{

			newReqResponsibleStakeholder("ReqInput_elc", objId, ConstDefine.OBJ_TYPE_ELCCHANEL, staffId, staffName, staffCode);

			newReqResponsibleStakeholder("ReqSubStaffTestCfm_elc", objId, ConstDefine.OBJ_TYPE_ELCCHANEL, staffId, staffName, staffCode);

			newReqResponsibleStakeholder("BusiGrayTest_elc", objId, ConstDefine.OBJ_TYPE_ELCCHANEL, staffId, staffName, staffCode);

			newReqResponsibleStakeholder("ReqSubStaffSatiAsse_elc", objId, ConstDefine.OBJ_TYPE_ELCCHANEL, staffId, staffName, staffCode);

			newReqResponsibleStakeholder("ReqSubStaffAysCfm_elc", objId, ConstDefine.OBJ_TYPE_ELCCHANEL, staffId, staffName, staffCode);
		}
	}
	

	public void updateReqResponsibleStakeholders(String processKey, Long objId, Long staffId, String staffName, String staffCode) throws Exception{
		updateReqResponsibleStakeholder("AnalysisVerifyBA", objId, ConstDefine.OBJ_TYPE_BAREQ, staffId, staffName, staffCode);
		updateReqResponsibleStakeholder("ReqResVerifyBA", objId, ConstDefine.OBJ_TYPE_BAREQ, staffId, staffName, staffCode);
		updateReqResponsibleStakeholder("ReqArchiveBA", objId, ConstDefine.OBJ_TYPE_BAREQ, staffId, staffName, staffCode);
		updateReqResponsibleStakeholder("ReqResTestCfmVerifyBA", objId, ConstDefine.OBJ_TYPE_BAREQ, staffId, staffName, staffCode);
		updateReqResponsibleStakeholder("supSatisftCheckBA", objId, ConstDefine.OBJ_TYPE_BAREQ, staffId, staffName, staffCode);
	}
	
	private void updateReqResponsibleStakeholder( String linkNo, Long objId, String objType, Long staffId, String staffName, String staffCode) throws Exception{
		log.info("为需求修改默认干系人需求ID为：" + objId + "!");
		WorkflowBO wf = workflowSV.getWorkflowByLinkNo(linkNo);
		if(wf == null){
			log.error("查询流程环节配置信息出错，配置不唯一！linkNo:" + linkNo + "!");
			throw new Exception("查询流程环节配置信息出错，配置不唯一！linkNo:" + linkNo + "!");
		}
		
		List<StakeholderBO> staList = almStakeholderSV.queryStakeholder(objId, objType, linkNo);
		if(null==staList||staList.size()<=0){
			newReqResponsibleStakeholder(linkNo, objId, objType, staffId, staffName, staffCode);
		}else{
			staList.get(0).setStdholderStaffId(staffId);
			staList.get(0).setStdholderStaffName(staffName);
			staList.get(0).setStdholderStaffNo(staffCode);
			almStakeholderSV.saveStakeholder(staList.get(0));
		}
	}

}
