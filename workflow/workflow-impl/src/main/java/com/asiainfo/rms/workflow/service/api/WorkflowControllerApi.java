package com.asiainfo.rms.workflow.service.api;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFlowBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFlowHisBO;
import com.asiainfo.rms.workflow.bo.process.common.ExecuteProcessBO;
import com.asiainfo.rms.workflow.bo.process.common.LaunchProcessBO;
import com.asiainfo.rms.workflow.bo.process.common.StakeholderOprBO;
import com.asiainfo.rms.workflow.bo.process.common.SysOrgPrivateBO;
import com.asiainfo.rms.workflow.bo.process.common.SysOrgPrivateQueryPageBO;
import com.asiainfo.rms.workflow.bo.process.common.SysStaffBO;
import com.asiainfo.rms.workflow.bo.process.common.TerminateProcessBO;
import com.asiainfo.rms.workflow.bo.workflow.StakeholderBO;
import com.asiainfo.rms.workflow.bo.workflow.WorkorderBO;
import com.asiainfo.rms.workflow.common.constance.ConstDefine;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFlowDTO;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbFlowHisMapper;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbFlowMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbFlowHisService;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbFlowService;
import com.asiainfo.rms.workflow.service.process.common.IAlmProcessRoamSV;
import com.asiainfo.rms.workflow.service.process.common.ISysOrgPrivateService;
import com.asiainfo.rms.workflow.service.process.common.ISysStaffService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * Created by liuchao on 2017/7/19.
 */
@Component("wca")
@Transactional(rollbackFor = Exception.class)
public class WorkflowControllerApi {

    @Autowired
    private IAlmProcessRoamSV roamSV;
	
	@Autowired
	IAlmCbFlowService almCbFlowService;
	
	@Autowired
	IAlmCbFlowHisService almCbFlowHisService;
	
	@Autowired
	ISysStaffService sysStaffService;
	
	@Autowired
	ISysOrgPrivateService sysOrgPrivateService;

    public void createWorkflow(LaunchProcessBO data) throws Exception{
        if(StringUtils.isBlank(data.getSourcePath()))
            throw new Exception("缺少参数sourcePath");

        if(StringUtils.isBlank(data.getProcessKey()))
            throw new Exception("缺少参数processKey");

        if(StringUtils.isBlank(data.getStaffId()))
            throw new Exception("缺少参数staffId");

        if(StringUtils.isBlank(data.getObjectTypeId()))
            throw new Exception("缺少参数objectTypeId");

        if(StringUtils.isBlank(data.getObjectId()))
            throw new Exception("缺少参数objectId");

        if(StringUtils.isBlank(data.getCond()))
            throw new Exception("缺少参数cond");

        if(StringUtils.isBlank(data.getOpinion()))
            throw new Exception("缺少参数opinion");

        if(data.getStds()!=null)
            roamSV.saveStakeholder(data.getObjectId(),data.getObjectTypeId(),data.getStds());

        roamSV.createStartSaveOrder(data.getSourcePath(),data.getObjectId(),data.getObjectTypeId(),data.getProcessKey(),data.getCond(),data.getOpinion());
        roamSV.createWorkflow(data.getProcessKey(),data.getStaffId(),data.getObjectTypeId(),data.getObjectId(),data.getCond());
    }

    public void saveFirstOrder(LaunchProcessBO data) throws Exception{
        if(StringUtils.isBlank(data.getProcessKey()))
            throw new Exception("缺少参数processKey");

        if(StringUtils.isBlank(data.getSourcePath()))
            throw new Exception("缺少参数sourcePath");

        if(StringUtils.isBlank(data.getObjectTypeId()))
            throw new Exception("缺少参数objectTypeId");

        if(StringUtils.isBlank(data.getObjectId()))
            throw new Exception("缺少参数objectId");

        if(StringUtils.isBlank(data.getCond()))
            throw new Exception("缺少参数cond");

        if(StringUtils.isBlank(data.getOpinion()))
            throw new Exception("缺少参数opinion");

        if(data.getStds()!=null)
            roamSV.saveStakeholder(data.getObjectId(),data.getObjectTypeId(),data.getStds());

        roamSV.createStartSaveOrder(data.getSourcePath(),data.getObjectId(),data.getObjectTypeId(),data.getProcessKey(),data.getCond(),data.getOpinion());
    }

    public void finishUserTask(ExecuteProcessBO data) throws Exception{
        if(data.getOrderId()==null||data.getOrderId()==0)
            throw new Exception("缺少参数orderId");

        if(StringUtils.isBlank(data.getResult()))
            throw new Exception("缺少参数result");

        if(StringUtils.isBlank(data.getOpinion()))
            throw new Exception("缺少参数opinion");

        if(StringUtils.isBlank(data.getCond()))
            throw new Exception("缺少参数cond");


        if(data.getStds()!=null) {
            if(StringUtils.isBlank(data.getObjectTypeId()))
                throw new Exception("缺少参数objectTypeId");

            if(StringUtils.isBlank(data.getObjectId()))
                throw new Exception("缺少参数objectId");

            roamSV.saveStakeholder(data.getObjectId(), data.getObjectTypeId(), data.getStds());
        }

        roamSV.finishUserTask(data.getOrderId(),data.getResult(),data.getOpinion(),data.getCond());
    }

    public void finishUserTask(Long appalyStaffId, ExecuteProcessBO data, AlmCbFlowDTO[] almCbFlowDTOs, Long linkId, String linkNo) throws Exception{
        if(data.getOrderId()==null||data.getOrderId()==0)
            throw new Exception("缺少参数orderId");
        
        if(appalyStaffId==null)
            throw new Exception("缺少参数appalyStaffId");

        if(StringUtils.isBlank(data.getResult()))
            throw new Exception("缺少参数result");

        if(StringUtils.isBlank(data.getOpinion()))
            throw new Exception("缺少参数opinion");

        if(StringUtils.isBlank(data.getCond()))
            throw new Exception("缺少参数cond");


        if(data.getStds()!=null) {
            if(StringUtils.isBlank(data.getObjectTypeId()))
                throw new Exception("缺少参数objectTypeId");

            if(StringUtils.isBlank(data.getObjectId()))
                throw new Exception("缺少参数objectId");

            roamSV.saveStakeholder(data.getObjectId(), data.getObjectTypeId(), data.getStds());
        }
        
        if (almCbFlowDTOs != null && almCbFlowDTOs.length >= 1) {
			for (AlmCbFlowDTO almCbFlowDTO : almCbFlowDTOs) {
				AlmCbFlowBO almCbFlowBO = null;
				if (almCbFlowDTO.getFlowId() == null) {
					almCbFlowDTO.setCreateTime(new Date());
					almCbFlowDTO.setIsValid(1);
					almCbFlowBO = almCbFlowService.save(AlmCbFlowMapper.INSTANCE.dtoToBo(almCbFlowDTO));
				} else {
					almCbFlowBO = almCbFlowService.findByPrimaryKey(almCbFlowDTO.getFlowId());
					almCbFlowDTO.setCreateTime(almCbFlowBO.getCreateTime());
					almCbFlowDTO.setIsValid(almCbFlowBO.getIsValid());
					almCbFlowDTO.setUnvalidReason(almCbFlowBO.getUnvalidReason());
					almCbFlowBO = almCbFlowService.save(AlmCbFlowMapper.INSTANCE.dtoToBo(almCbFlowDTO));
				}
				AlmCbFlowHisBO almCbFlowHisBO = AlmCbFlowHisMapper.INSTANCE.boToBo(almCbFlowBO);
				almCbFlowHisBO.setAppalyStaffId(appalyStaffId);
				almCbFlowHisBO.setCreateTime(new Date());
				SysStaffBO sysStaffBO = sysStaffService.findByPrimaryKey(appalyStaffId);
				almCbFlowHisBO.setAppalyStaffCode(sysStaffBO.getCode());
				almCbFlowHisBO.setAppalyStaffName(sysStaffBO.getEmployeeName());
				almCbFlowHisService.save(almCbFlowHisBO);
				StakeholderBO stakeholderBO = new StakeholderBO();
				stakeholderBO.setLinkId(linkId);
				stakeholderBO.setLinkNo(linkNo);
				stakeholderBO.setRoleCode(almCbFlowDTO.getAuthorNotes());
				stakeholderBO.setRoleId(Long.valueOf(almCbFlowDTO.getAuthorId()));
				stakeholderBO.setStdholderStaffId(almCbFlowDTO.getStaffId());
				stakeholderBO.setStdholderStaffName(almCbFlowDTO.getStaffName());
				stakeholderBO.setStdholderStaffNo(almCbFlowDTO.getObjTag());
				stakeholderBO.setStdholderStaffOrgId(almCbFlowDTO.getOrganizeId());
				stakeholderBO.setStdholdeType(ConstDefine.STDHOLDE_TYPE_NOTICE);
				this.newNoWFWo(data.getOrderId(), ConstDefine.STDHOLDE_TYPE_NOTICE, stakeholderBO, "", Long.valueOf(data.getObjectId()), data.getObjectTypeId());
			}
        }
        roamSV.finishUserTask(data.getOrderId(),data.getResult(),data.getOpinion(),data.getCond());
    }
    
    public void terminateWorkflow(TerminateProcessBO terminateProcess) throws Exception{
    	if(terminateProcess.getDeployId() == null || terminateProcess.getDeployId().compareTo(0L) <= 0)
            throw new Exception("缺少参数deployId");

    	if(terminateProcess.getProcInstId() == null || terminateProcess.getProcInstId().compareTo(0L) <= 0)
            throw new Exception("缺少参数procInstId");
    	
    	if(terminateProcess.getObjId() == null || terminateProcess.getObjId().compareTo(0L) == 0)
            throw new Exception("缺少参数objId");

        if(StringUtils.isBlank(terminateProcess.getObjType()))
            throw new Exception("缺少参数objType");

        if(StringUtils.isBlank(terminateProcess.getStaffId()))
            throw new Exception("缺少参数staffId");

        if(StringUtils.isBlank(terminateProcess.getStaffCode()))
            throw new Exception("缺少参数staffCode");

        if(StringUtils.isBlank(terminateProcess.getStaffName()))
            throw new Exception("缺少参数staffName");

        if(StringUtils.isBlank(terminateProcess.getReason()))
            throw new Exception("缺少参数reason");
    	roamSV.terminateWorkflow(terminateProcess.getDeployId(), terminateProcess.getProcInstId(), terminateProcess.getObjId(), terminateProcess.getObjType(), terminateProcess.getStaffId(), terminateProcess.getStaffCode(), terminateProcess.getStaffName(), terminateProcess.getReason());
    }
    
    public void oprStakeholder(String objId, String objType, List<StakeholderOprBO> stakeholderOprList) throws Exception {
    	if(StringUtils.isBlank(objId))
            throw new Exception("缺少参数objId");

        if(StringUtils.isBlank(objType))
            throw new Exception("缺少参数objType");

        if(stakeholderOprList == null || stakeholderOprList.isEmpty())
            throw new Exception("缺少参数stakeholderOprList");
    	roamSV.saveLinkStakeholder(objId, objType, stakeholderOprList);
    }
    
    public List<StakeholderBO> queryStakeholder(String objId, String objType, Long linkId) throws Exception {
    	if(StringUtils.isBlank(objId))
            throw new Exception("缺少参数objId");

        if(StringUtils.isBlank(objType))
            throw new Exception("缺少参数objType");

        if(linkId == null || linkId.compareTo(0L) <= 0)
            throw new Exception("缺少参数linkId");
    	return roamSV.queryStakeholder(objId, objType, linkId);
    }
    
    public void updateWorkorder(WorkorderBO workorderBO) throws Exception {
        if(workorderBO.getOrderId() == null || workorderBO.getOrderId().compareTo(0L) <= 0)
            throw new Exception("缺少参数orderId");
    	roamSV.updateWorkorder(workorderBO);
    }
    
    public WorkorderBO queryWorkorder(Long orderId) throws Exception {
    	if(orderId == null)
            throw new Exception("缺少参数orderId");
    	return roamSV.queryWorkorder(orderId);
    }
    
    public List<WorkorderBO> queryWorkorders(Long objId, Long linkId) throws Exception {
    	if(objId == null)
            throw new Exception("缺少参数objId");
    	if(linkId == null)
            throw new Exception("缺少参数linkId");
    	return roamSV.queryWorkorder(objId, linkId);
    }
    
    public List<StakeholderBO> queryStakeholder(String linkNo, Long linkId) throws Exception {
		SysOrgPrivateQueryPageBO sysOrgPrivateQueryPageBO = new SysOrgPrivateQueryPageBO();
		sysOrgPrivateQueryPageBO.setLockFlag(false);
		sysOrgPrivateQueryPageBO.setOrgTypeBegin(2);
		sysOrgPrivateQueryPageBO.setOrgTypeEnd(3);
		List<StakeholderBO> result = new ArrayList<StakeholderBO>();
		Page<SysOrgPrivateBO> sysOrgPrivateBOs = sysOrgPrivateService.findByConds(sysOrgPrivateQueryPageBO);
		if (CollectionUtils.isEmpty(sysOrgPrivateBOs.getPageData())) {
			throw new Exception("请添加管理人员");
		} else {
			for (SysOrgPrivateBO sysOrgPrivateBO : sysOrgPrivateBOs.getPageData()) {
				StakeholderBO stakeholderBO = new StakeholderBO();
				stakeholderBO.setLinkId(linkId);
				stakeholderBO.setLinkNo(linkNo);
				stakeholderBO.setRoleCode(sysOrgPrivateBO.getParamType());
				stakeholderBO.setRoleId(Long.valueOf(sysOrgPrivateBO.getOrgType()));
				stakeholderBO.setStdholderStaffId(sysOrgPrivateBO.getStaffId());
				stakeholderBO.setStdholderStaffName(sysOrgPrivateBO.getEmployeeName());
				stakeholderBO.setStdholderStaffNo(sysOrgPrivateBO.getCode());
				stakeholderBO.setStdholderStaffOrgId(sysOrgPrivateBO.getOrganizeId());
				result.add(stakeholderBO);
			}
		}
		return result;
    }
    
    public void newNoWFWo(Long orderId, String orderType, StakeholderBO std, String lockOption, Long objId, String objType) throws Exception {
    	if(orderId == null)
            throw new Exception("缺少参数orderId");
    	if(orderType == null)
            throw new Exception("缺少参数orderType");
    	if(std == null)
            throw new Exception("缺少参数std");
    	if(lockOption == null)
            throw new Exception("缺少参数lockOption");
    	if(objId == null)
            throw new Exception("缺少参数objId");
    	if(objType == null)
            throw new Exception("缺少参数objType");
    	roamSV.newNoWFWo(orderId, orderType, std, lockOption, objId, objType);
    }
    
    public void finishNoWFWo(Long orderId, String orderType,String opinion,String result) throws Exception {
    	if(orderId == null)
            throw new Exception("缺少参数orderId");
    	if(orderType == null)
            throw new Exception("缺少参数orderType");
    	if(opinion == null)
            throw new Exception("缺少参数opinion");
    	if(result == null)
            throw new Exception("缺少参数result");
    	roamSV.finishNoWFWo(orderId, orderType, opinion, result);
    }
}
