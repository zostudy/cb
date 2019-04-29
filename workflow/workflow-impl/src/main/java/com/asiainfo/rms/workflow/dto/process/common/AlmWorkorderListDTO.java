package com.asiainfo.rms.workflow.dto.process.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author joker
 */
@ApiModel(description = "")
public class AlmWorkorderListDTO {
	
	@ApiModelProperty(value = "")
	private java.lang.Long orderId;
	
	@ApiModelProperty(value = "")
	private java.lang.String objType;
	
	@ApiModelProperty(value = "")
	private java.lang.String vmTaskName;
	
	@ApiModelProperty(value = "")
	private java.lang.String linkNo;
	
	@ApiModelProperty(value = "")
	private java.lang.Long linkId;
	
	@ApiModelProperty(value = "")
	private java.lang.Long execStaffId;
	
	@ApiModelProperty(value = "")
	private java.lang.String execStaffCode;
	
	@ApiModelProperty(value = "")
	private java.lang.String execEmployeeName;
	
	@ApiModelProperty(value = "")
	private java.lang.String lockOpinion;
	
	@ApiModelProperty(value = "")
	private java.util.Date createTime;
	
	@ApiModelProperty(value = "")
	private java.util.Date finishTime;
	
	@ApiModelProperty(value = "")
	private java.lang.String orderType;
	
	@ApiModelProperty(value = "")
	private java.lang.String cond;
	
	@ApiModelProperty(value = "")
	private java.lang.String result;
	
	@ApiModelProperty(value = "")
	private java.lang.String status;
	
	@ApiModelProperty(value = "")
	private java.lang.String opinion;
	
	@ApiModelProperty(value = "")
	private java.lang.String nextLinkPlantime;
	
	@ApiModelProperty(value = "")
	private java.lang.Long procInstId;
	
	@ApiModelProperty(value = "")
	private java.lang.Long lastOrderId;
	
	@ApiModelProperty(value = "")
	private Long remineTime;
	
	@ApiModelProperty(value = "")
	private java.lang.String phaseId;
	
	@ApiModelProperty(value = "")
	private Long timeConsum;
	
	@ApiModelProperty(value = "")
	private Long objId;
	
	@ApiModelProperty(value = "")
	private java.lang.String objTag;
	
	@ApiModelProperty(value = "")
	private Long applyStaffId;
	
	@ApiModelProperty(value = "")
	private java.lang.String applyStaffName;
	
	@ApiModelProperty(value = "")
	private java.lang.String applyStaffCode;
	
	public void setOrderId(java.lang.Long value) {
		this.orderId = value;
	}
	
	public java.lang.Long getOrderId() {
		return this.orderId;
	}	    
	
	public java.lang.String getObjType() {
		return this.objType;
	}
	
	public void setObjType(java.lang.String value) {
		this.objType = value;
	}
	
	public java.lang.String getVmTaskName() {
		return this.vmTaskName;
	}
	
	public void setVmTaskName(java.lang.String value) {
		this.vmTaskName = value;
	}
	
	public java.lang.String getLinkNo() {
		return this.linkNo;
	}
	
	public void setLinkNo(java.lang.String value) {
		this.linkNo = value;
	}
	
	public java.lang.Long getLinkId() {
		return this.linkId;
	}
	
	public void setLinkId(java.lang.Long value) {
		this.linkId = value;
	}
	
	public java.lang.Long getExecStaffId() {
		return this.execStaffId;
	}
	
	public void setExecStaffId(java.lang.Long value) {
		this.execStaffId = value;
	}
	
	public java.lang.String getExecStaffCode() {
		return this.execStaffCode;
	}
	
	public void setExecStaffCode(java.lang.String value) {
		this.execStaffCode = value;
	}
	
	public java.lang.String getExecEmployeeName() {
		return this.execEmployeeName;
	}
	
	public void setExecEmployeeName(java.lang.String value) {
		this.execEmployeeName = value;
	}
	
	public java.lang.String getLockOpinion() {
		return this.lockOpinion;
	}
	
	public void setLockOpinion(java.lang.String value) {
		this.lockOpinion = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getFinishTime() {
		return this.finishTime;
	}
	
	public void setFinishTime(java.util.Date value) {
		this.finishTime = value;
	}
	
	public java.lang.String getOrderType() {
		return this.orderType;
	}
	
	public void setOrderType(java.lang.String value) {
		this.orderType = value;
	}
	
	public java.lang.String getCond() {
		return this.cond;
	}
	
	public void setCond(java.lang.String value) {
		this.cond = value;
	}
	
	public java.lang.String getResult() {
		return this.result;
	}
	
	public void setResult(java.lang.String value) {
		this.result = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.lang.String getOpinion() {
		return this.opinion;
	}
	
	public void setOpinion(java.lang.String value) {
		this.opinion = value;
	}
	
	public java.lang.String getNextLinkPlantime() {
		return this.nextLinkPlantime;
	}
	
	public void setNextLinkPlantime(java.lang.String value) {
		this.nextLinkPlantime = value;
	}
	
	public java.lang.Long getProcInstId() {
		return this.procInstId;
	}
	
	public void setProcInstId(java.lang.Long value) {
		this.procInstId = value;
	}
	
	public java.lang.Long getLastOrderId() {
		return this.lastOrderId;
	}
	
	public void setLastOrderId(java.lang.Long value) {
		this.lastOrderId = value;
	}
	
	public Long getRemineTime() {
		return this.remineTime;
	}
	
	public void setRemineTime(Long value) {
		this.remineTime = value;
	}
	
	public java.lang.String getPhaseId() {
		return this.phaseId;
	}
	
	public void setPhaseId(java.lang.String value) {
		this.phaseId = value;
	}
	
	public Long getTimeConsum() {
		return this.timeConsum;
	}
	
	public void setTimeConsum(Long value) {
		this.timeConsum = value;
	}
	
	public Long getObjId() {
		return this.objId;
	}
	
	public void setObjId(Long value) {
		this.objId = value;
	}
	
	public java.lang.String getObjTag() {
		return this.objTag;
	}
	
	public void setObjTag(java.lang.String value) {
		this.objTag = value;
	}
	
	public Long getApplyStaffId() {
		return this.applyStaffId;
	}
	
	public void setApplyStaffId(Long value) {
		this.applyStaffId = value;
	}
	
	public java.lang.String getApplyStaffName() {
		return this.applyStaffName;
	}
	
	public void setApplyStaffName(java.lang.String value) {
		this.applyStaffName = value;
	}
	
	public java.lang.String getApplyStaffCode() {
		return this.applyStaffCode;
	}
	
	public void setApplyStaffCode(java.lang.String value) {
		this.applyStaffCode = value;
	}
}

