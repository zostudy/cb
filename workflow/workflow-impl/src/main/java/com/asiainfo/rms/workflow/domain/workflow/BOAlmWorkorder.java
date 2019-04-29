package com.asiainfo.rms.workflow.domain.workflow;

import javax.persistence.*;
import java.util.Date;

/**
 * 
 * @author 刘超
 *
 */
@Entity
@Table(name="ALM_WORKORDER")
public class BOAlmWorkorder {

	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="workorderSeq")
	@SequenceGenerator(initialValue = 1, name = "workorderSeq", sequenceName = "ALM_WORKORDER$SEQ",allocationSize=1)
	@Column(name="ORDER_ID",length=12)
	private Long orderId;
	
	@Column(name="DEPLOY_ID",length=12)
	private Long deployId;
	
	@Column(name="PROC_INST_ID",length=12)
	private Long procInstId;
	
	@Column(name="PARENT_ORDER_ID",length=12)
	private Long parentOrderId;
	
	@Column(name="LAST_ORDER_ID",length=12)
	private Long lastOrderId;
	
	@Column(name="ACT_TASK_ID",length=12)
	private Long actTaskId;
	
	@Column(name="PARENT_ACT_tASK_ID",length=12)
	private Long parentActTaskId;
	
	@Column(name="LAST_ACT_TASK_ID",length=12)
	private Long lastActTaskId;
	
	@Column(name="LINK_ID",length=12)
	private Long linkId;
	
	@Column(name="IS_CURRENT_TASK",length=1)
	private String isCurrentTask;
	
	@Column(name="ORDER_TYPE",length=4)
	private String orderType;
	
	@Column(name="OBJ_ID",length=12)
	private Long objId;
	
	@Column(name="OBJ_TYPE",length=4)
	private String objType;
	
	@Column(name="DEAL_TYPE",length=2)
	private String dealType;
	
	@Column(name="IS_LOCK",length=2)
	private Long isLock;
	
	@Column(name="FINISH_PRINT",length=2)
	private Long finishPrint;
	
	@Column(name="EXEC_ROLE_ID",length=12)
	private Long execRoleId;
	
	@Column(name="EXEC_STAFF_ID",length=12)
	private Long execStaffId;
	
	@Column(name="LOCK_ROLE_ID",length=12)
	private Long lockRoleId;
	
	@Column(name="LOCK_STAFF_ID",length=12)
	private Long lockStaffId;
	
	@Column(name="RESULT",length=15)
	private String result;
	
	@Column(name="COND",length=4000)
	private String cond;
	
	@Column(name="STATUS",length=2)
	private String status;
	
	@Column(name="OPINION",length=4000)
	private String opinion;
	
	@Column(name="LOCK_OPINION",length=4000)
	private String lockOpinion;
	
	@Temporal(TemporalType.TIMESTAMP)@Column(name="CREATE_TIME")
	private Date creatTime;
	
	@Temporal(TemporalType.TIMESTAMP)@Column(name="RECV_TIME")
	private Date recvTime;
	
	@Temporal(TemporalType.TIMESTAMP)@Column(name="LOCK_TIME")
	private Date lockTime;
	
	@Temporal(TemporalType.TIMESTAMP)@Column(name="REALSE_LOCK_TIME")
	private Date realseLockTime;
	
	@Temporal(TemporalType.TIMESTAMP)@Column(name="EXEC_TIME")
	private Date execTime;
	
	@Temporal(TemporalType.TIMESTAMP)@Column(name="FINISH_TIME")
	private Date finishTime;
	
	@Column(name="LOCK_TIMES",length=30)
	private Long lockTimes;
	
	@Column(name="EXEC_TIMES",length=30)
	private Long execTimes;

	@Column(name="ALARM_FLG",length=2)
	private String alarmFlg;

	@Column(name="ALARM_TIMES",length=2)
	private Long alarmTimes;

	@Temporal(TemporalType.TIMESTAMP)@Column(name="PREALARM_TIME")
	private Date prealarmTime;

	@Temporal(TemporalType.TIMESTAMP)@Column(name="ALARM_TIME")
	private Date alarmTime;

	@Temporal(TemporalType.TIMESTAMP)@Column(name="DELAY_TIME")
	private Date delayTime;

	@Column(name="WARNING_FLAG",length=2)
	private Long warningFlag;

	@Column(name="SMGFLAG",length=2)
	private Long smgflag;

	@Column(name="NEXT_LINK_PLANTIME",length=10)
	private String nextLinkPlantime;

	@Column(name="PLANTIME_TEMP",length=10)
	private String plantimeTemp;

	@Column(name="OPER_TYPE",length=4)
	private String operType;

	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getDeployId() {
		return deployId;
	}
	public void setDeployId(Long deployId) {
		this.deployId = deployId;
	}
	public Long getParentOrderId() {
		return parentOrderId;
	}
	public void setParentOrderId(Long parentOrderId) {
		this.parentOrderId = parentOrderId;
	}
	public Long getLastOrderId() {
		return lastOrderId;
	}
	public void setLastOrderId(Long lastOrderId) {
		this.lastOrderId = lastOrderId;
	}
	public Long getActTaskId() {
		return actTaskId;
	}
	public void setActTaskId(Long actTaskId) {
		this.actTaskId = actTaskId;
	}
	public Long getParentActTaskId() {
		return parentActTaskId;
	}
	public void setParentActTaskId(Long parentActTaskId) {
		this.parentActTaskId = parentActTaskId;
	}
	public Long getLastActTaskId() {
		return lastActTaskId;
	}
	public void setLastActTaskId(Long lastActTaskId) {
		this.lastActTaskId = lastActTaskId;
	}
	public Long getLinkId() {
		return linkId;
	}
	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}
	public String getIsCurrentTask() {
		return isCurrentTask;
	}
	public void setIsCurrentTask(String isCurrentTask) {
		this.isCurrentTask = isCurrentTask;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Long getObjId() {
		return objId;
	}
	public void setObjId(Long objId) {
		this.objId = objId;
	}
	public String getObjType() {
		return objType;
	}
	public void setObjType(String objType) {
		this.objType = objType;
	}
	public String getDealType() {
		return dealType;
	}
	public void setDealType(String dealType) {
		this.dealType = dealType;
	}
	public Long getIsLock() {
		return isLock;
	}
	public void setIsLock(Long isLock) {
		this.isLock = isLock;
	}
	public Long getFinishPrint() {
		return finishPrint;
	}
	public void setFinishPrint(Long finishPrint) {
		this.finishPrint = finishPrint;
	}
	public Long getExecRoleId() {
		return execRoleId;
	}
	public void setExecRoleId(Long execRoleId) {
		this.execRoleId = execRoleId;
	}
	public Long getExecStaffId() {
		return execStaffId;
	}
	public void setExecStaffId(Long execStaffId) {
		this.execStaffId = execStaffId;
	}
	public Long getLockRoleId() {
		return lockRoleId;
	}
	public void setLockRoleId(Long lockRoleId) {
		this.lockRoleId = lockRoleId;
	}
	public Long getLockStaffId() {
		return lockStaffId;
	}
	public void setLockStaffId(Long lockStaffId) {
		this.lockStaffId = lockStaffId;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getCond() {
		return cond;
	}
	public void setCond(String cond) {
		this.cond = cond;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getLockOpinion() {
		return lockOpinion;
	}
	public void setLockOpinion(String lockOpinion) {
		this.lockOpinion = lockOpinion;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public Date getRecvTime() {
		return recvTime;
	}
	public void setRecvTime(Date recvTime) {
		this.recvTime = recvTime;
	}
	public Date getLockTime() {
		return lockTime;
	}
	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}
	public Date getRealseLockTime() {
		return realseLockTime;
	}
	public void setRealseLockTime(Date realseLockTime) {
		this.realseLockTime = realseLockTime;
	}
	public Date getExecTime() {
		return execTime;
	}
	public void setExecTime(Date execTime) {
		this.execTime = execTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public Long getLockTimes() {
		return lockTimes;
	}
	public void setLockTimes(Long lockTimes) {
		this.lockTimes = lockTimes;
	}
	public Long getExecTimes() {
		return execTimes;
	}
	public void setExecTimes(Long execTimes) {
		this.execTimes = execTimes;
	}
	public Long getProcInstId() {
		return procInstId;
	}
	public void setProcInstId(Long procInstId) {
		this.procInstId = procInstId;
	}
	public String getAlarmFlg() {
		return alarmFlg;
	}
	public void setAlarmFlg(String alarmFlg) {
		this.alarmFlg = alarmFlg;
	}
	public Long getAlarmTimes() {
		return alarmTimes;
	}
	public void setAlarmTimes(Long alarmTimes) {
		this.alarmTimes = alarmTimes;
	}
	public Date getPrealarmTime() {
		return prealarmTime;
	}
	public void setPrealarmTime(Date prealarmTime) {
		this.prealarmTime = prealarmTime;
	}
	public Date getAlarmTime() {
		return alarmTime;
	}
	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}
	public Date getDelayTime() {
		return delayTime;
	}
	public void setDelayTime(Date delayTime) {
		this.delayTime = delayTime;
	}
	public Long getWarningFlag() {
		return warningFlag;
	}
	public void setWarningFlag(Long warningFlag) {
		this.warningFlag = warningFlag;
	}
	public Long getSmgflag() {
		return smgflag;
	}
	public void setSmgflag(Long smgflag) {
		this.smgflag = smgflag;
	}
	public String getNextLinkPlantime() {
		return nextLinkPlantime;
	}
	public void setNextLinkPlantime(String nextLinkPlantime) {
		this.nextLinkPlantime = nextLinkPlantime;
	}
	public String getPlantimeTemp() {
		return plantimeTemp;
	}
	public void setPlantimeTemp(String plantimeTemp) {
		this.plantimeTemp = plantimeTemp;
	}
	public String getOperType() {
		return operType;
	}
	public void setOperType(String operType) {
		this.operType = operType;
	}
}
