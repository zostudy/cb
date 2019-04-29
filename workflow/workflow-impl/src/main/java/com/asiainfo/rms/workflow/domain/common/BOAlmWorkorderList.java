package com.asiainfo.rms.workflow.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;

/**
 * 
 * 
 * @author joker
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "ALM_WORKORDER_LIST")
public class BOAlmWorkorderList {
	
	// 
	
	private java.lang.Long orderId;
	// 
	@Length(max=4)
	private java.lang.String objType;
	// 
	@Length(max=128)
	private java.lang.String vmTaskName;
	// 
	@Length(max=32)
	private java.lang.String linkNo;
	// 
	
	private java.lang.Long linkId;
	// 
	
	private java.lang.Long execStaffId;
	// 
	@Length(max=20)
	private java.lang.String execStaffCode;
	// 
	@Length(max=200)
	private java.lang.String execEmployeeName;
	// 
	@Length(max=4000)
	private java.lang.String lockOpinion;
	// 
	
	private java.util.Date createTime;
	// 
	
	private java.util.Date finishTime;
	// 
	@Length(max=4)
	private java.lang.String orderType;
	// 
	@Length(max=4000)
	private java.lang.String cond;
	// 
	@Length(max=15)
	private java.lang.String result;
	// 
	@Length(max=2)
	private java.lang.String status;
	// 
	@Length(max=4000)
	private java.lang.String opinion;
	// 
	@Length(max=10)
	private java.lang.String nextLinkPlantime;
	// 
	
	private java.lang.Long procInstId;
	// 
	
	private java.lang.Long lastOrderId;
	// 
	
	private Long remineTime;
	// 
	@Length(max=32)
	private java.lang.String phaseId;
	// 
	
	private Long timeConsum;
	// 
	
	private Long objId;
	// 
	@Length(max=225)
	private java.lang.String objTag;
	// 
	
	private Long applyStaffId;
	// 
	@Length(max=200)
	private java.lang.String applyStaffName;
	// 
	@Length(max=20)
	private java.lang.String applyStaffCode;

	public void setOrderId(java.lang.Long value) {
		this.orderId = value;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="ALM_WORKORDER_LIST_SEQ")
	@SequenceGenerator(sequenceName="ALM_WORKORDER_LIST$SEQ",allocationSize=1,name="ALM_WORKORDER_LIST_SEQ")
	@Column(name = "ORDER_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 12)
	public java.lang.Long getOrderId() {
		return this.orderId;
	}	    
	
	@Column(name = "OBJ_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 4)
	public java.lang.String getObjType() {
		return this.objType;
	}
	
	public void setObjType(java.lang.String value) {
		this.objType = value;
	}
	
	@Column(name = "VM_TASK_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getVmTaskName() {
		return this.vmTaskName;
	}
	
	public void setVmTaskName(java.lang.String value) {
		this.vmTaskName = value;
	}
	
	@Column(name = "LINK_NO", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getLinkNo() {
		return this.linkNo;
	}
	
	public void setLinkNo(java.lang.String value) {
		this.linkNo = value;
	}
	
	@Column(name = "LINK_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 12)
	public java.lang.Long getLinkId() {
		return this.linkId;
	}
	
	public void setLinkId(java.lang.Long value) {
		this.linkId = value;
	}
	
	@Column(name = "EXEC_STAFF_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 12)
	public java.lang.Long getExecStaffId() {
		return this.execStaffId;
	}
	
	public void setExecStaffId(java.lang.Long value) {
		this.execStaffId = value;
	}
	
	@Column(name = "EXEC_STAFF_CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getExecStaffCode() {
		return this.execStaffCode;
	}
	
	public void setExecStaffCode(java.lang.String value) {
		this.execStaffCode = value;
	}
	
	@Column(name = "EXEC_EMPLOYEE_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getExecEmployeeName() {
		return this.execEmployeeName;
	}
	
	public void setExecEmployeeName(java.lang.String value) {
		this.execEmployeeName = value;
	}
	
	@Column(name = "LOCK_OPINION", unique = false, nullable = true, insertable = true, updatable = true, length = 4000)
	public java.lang.String getLockOpinion() {
		return this.lockOpinion;
	}
	
	public void setLockOpinion(java.lang.String value) {
		this.lockOpinion = value;
	}
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", unique = false, nullable = true, insertable = true, updatable = true)
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FINISH_TIME", unique = false, nullable = true, insertable = true, updatable = true)
	public java.util.Date getFinishTime() {
		return this.finishTime;
	}
	
	public void setFinishTime(java.util.Date value) {
		this.finishTime = value;
	}
	
	@Column(name = "ORDER_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 4)
	public java.lang.String getOrderType() {
		return this.orderType;
	}
	
	public void setOrderType(java.lang.String value) {
		this.orderType = value;
	}
	
	@Column(name = "COND", unique = false, nullable = true, insertable = true, updatable = true, length = 4000)
	public java.lang.String getCond() {
		return this.cond;
	}
	
	public void setCond(java.lang.String value) {
		this.cond = value;
	}
	
	@Column(name = "RESULT", unique = false, nullable = true, insertable = true, updatable = true, length = 15)
	public java.lang.String getResult() {
		return this.result;
	}
	
	public void setResult(java.lang.String value) {
		this.result = value;
	}
	
	@Column(name = "STATUS", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public java.lang.String getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	@Column(name = "OPINION", unique = false, nullable = true, insertable = true, updatable = true, length = 4000)
	public java.lang.String getOpinion() {
		return this.opinion;
	}
	
	public void setOpinion(java.lang.String value) {
		this.opinion = value;
	}
	
	@Column(name = "NEXT_LINK_PLANTIME", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.String getNextLinkPlantime() {
		return this.nextLinkPlantime;
	}
	
	public void setNextLinkPlantime(java.lang.String value) {
		this.nextLinkPlantime = value;
	}
	
	@Column(name = "PROC_INST_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 12)
	public java.lang.Long getProcInstId() {
		return this.procInstId;
	}
	
	public void setProcInstId(java.lang.Long value) {
		this.procInstId = value;
	}
	
	@Column(name = "LAST_ORDER_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 12)
	public java.lang.Long getLastOrderId() {
		return this.lastOrderId;
	}
	
	public void setLastOrderId(java.lang.Long value) {
		this.lastOrderId = value;
	}
	
	@Column(name = "REMINE_TIME", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public Long getRemineTime() {
		return this.remineTime;
	}
	
	public void setRemineTime(Long value) {
		this.remineTime = value;
	}
	
	@Column(name = "PHASE_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getPhaseId() {
		return this.phaseId;
	}
	
	public void setPhaseId(java.lang.String value) {
		this.phaseId = value;
	}
	
	@Column(name = "TIME_CONSUM", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public Long getTimeConsum() {
		return this.timeConsum;
	}
	
	public void setTimeConsum(Long value) {
		this.timeConsum = value;
	}
	
	@Column(name = "OBJ_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public Long getObjId() {
		return this.objId;
	}
	
	public void setObjId(Long value) {
		this.objId = value;
	}
	
	@Column(name = "OBJ_TAG", unique = false, nullable = true, insertable = true, updatable = true, length = 225)
	public java.lang.String getObjTag() {
		return this.objTag;
	}
	
	public void setObjTag(java.lang.String value) {
		this.objTag = value;
	}
	
	@Column(name = "APPLY_STAFF_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public Long getApplyStaffId() {
		return this.applyStaffId;
	}
	
	public void setApplyStaffId(Long value) {
		this.applyStaffId = value;
	}
	
	@Column(name = "APPLY_STAFF_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getApplyStaffName() {
		return this.applyStaffName;
	}
	
	public void setApplyStaffName(java.lang.String value) {
		this.applyStaffName = value;
	}
	
	@Column(name = "APPLY_STAFF_CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getApplyStaffCode() {
		return this.applyStaffCode;
	}
	
	public void setApplyStaffCode(java.lang.String value) {
		this.applyStaffCode = value;
	}
}

