package com.asiainfo.rms.workflow.service.workorder.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.asiainfo.rms.workflow.bo.workflow.WorkorderBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmHisWorkorder;
import com.asiainfo.rms.workflow.service.workorder.IAlmHisWorkorderSV;

import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Service;


/**
 * 
 * @author 刘超
 * @version 1.4
 *
 */
@Log4j
@Service("hisWorkorderSV")
@Transactional(rollbackOn = Exception.class)
public class AlmHisWorkorderSVImpl implements IAlmHisWorkorderSV{
	
	@Resource(name="commonDao")
	private CommonDAO commonDAO;
	
	@Override
	public void capyHisWorkorderByWorkorder(WorkorderBO workorder)
			throws Exception {
		if(log.isDebugEnabled()){
			log.debug("正在保存历史工单信息,工单ID:"+workorder.getOrderId());
		}
		BOAlmHisWorkorder boAlmHisWorkorder = new BOAlmHisWorkorder();
		boAlmHisWorkorder.setOrderId(workorder.getOrderId());
		boAlmHisWorkorder.setDeployId(workorder.getDeployId());
		boAlmHisWorkorder.setParentOrderId(workorder.getParentOrderId());
		boAlmHisWorkorder.setLastOrderId(workorder.getLastOrderId());	
		boAlmHisWorkorder.setActTaskId(workorder.getActTaskId());
		boAlmHisWorkorder.setParentActTaskId(workorder.getParentActTaskId());
		boAlmHisWorkorder.setLastActTaskId(workorder.getLastActTaskId());
		boAlmHisWorkorder.setLinkId(workorder.getLinkId());
		boAlmHisWorkorder.setIsCurrentTask(workorder.getIsCurrentTask());
		boAlmHisWorkorder.setOrderType(workorder.getOrderType());
		boAlmHisWorkorder.setObjId(workorder.getObjId());
		boAlmHisWorkorder.setObjType(workorder.getObjType());
		boAlmHisWorkorder.setIsLock(workorder.getIsLock());
		boAlmHisWorkorder.setFinishPrint(workorder.getFinishPrint());
		boAlmHisWorkorder.setExecRoleId(workorder.getExecRoleId());
		boAlmHisWorkorder.setExecStaffId(workorder.getExecStaffId());
		boAlmHisWorkorder.setLockRoleId(workorder.getLockRoleId());
		boAlmHisWorkorder.setLockStaffId(workorder.getLockStaffId());
		boAlmHisWorkorder.setResult(workorder.getResult());
		boAlmHisWorkorder.setCond(workorder.getCond());
		boAlmHisWorkorder.setStatus(workorder.getStatus());
		boAlmHisWorkorder.setOpinion(workorder.getOpinion());
		boAlmHisWorkorder.setLockOpinion(workorder.getLockOpinion());
		boAlmHisWorkorder.setCreatTime(workorder.getCreatTime());
		boAlmHisWorkorder.setRecvTime(workorder.getRecvTime());
		boAlmHisWorkorder.setLockTime(workorder.getLockTime());
		boAlmHisWorkorder.setRealseLockTime(workorder.getRealseLockTime());
		boAlmHisWorkorder.setExecTime(workorder.getExecTime());
		boAlmHisWorkorder.setFinishTime(workorder.getFinishTime());
		boAlmHisWorkorder.setLockTimes(workorder.getLockTimes());
		boAlmHisWorkorder.setExecTimes(workorder.getExecTimes());
		boAlmHisWorkorder.setProcInstId(workorder.getProcInstId());
		boAlmHisWorkorder.setAlarmFlg(workorder.getAlarmFlg());
		boAlmHisWorkorder.setAlarmTimes(workorder.getAlarmTimes());
		boAlmHisWorkorder.setPrealarmTime(workorder.getPrealarmTime());
		boAlmHisWorkorder.setAlarmTime(workorder.getAlarmTime());
		boAlmHisWorkorder.setDelayTime(workorder.getDelayTime());
		boAlmHisWorkorder.setWarningFlag(workorder.getWarningFlag());
		boAlmHisWorkorder.setSmgflag(workorder.getSmgflag());
		boAlmHisWorkorder.setNextLinkPlantime(workorder.getNextLinkPlantime());
		boAlmHisWorkorder.setPlantimeTemp(workorder.getPlantimeTemp());
		boAlmHisWorkorder.setOperType(workorder.getOperType());
		commonDAO.save(boAlmHisWorkorder);
	}

}
