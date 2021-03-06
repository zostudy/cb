package com.asiainfo.rms.workflow.dto.process.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 岗位与工作流关联表
 * 
 * @author joker
 */
@ApiModel(description = "岗位与工作流关联表")
public class SysAuthorWorkflowDTO {
	
	@ApiModelProperty(value = "主键")
	private Long sawId;
	
	@ApiModelProperty(value = "员工主键")
	private Long staffId;
	
	@ApiModelProperty(value = "工号")
	private java.lang.String code;
	
	@ApiModelProperty(value = "雇员名称")
	private java.lang.String employeeName;
	
	@ApiModelProperty(value = "手机号码")
	private java.lang.String billId;
	
	@ApiModelProperty(value = "组织ID")
	private java.lang.Long organizeId;
	
	@ApiModelProperty(value = "组织名称")
	private java.lang.String organizeName;
	
	@ApiModelProperty(value = "组织类型")
	private Integer orgType;
	
	@ApiModelProperty(value = "创建时间")
	private java.util.Date createDate;
	
	@ApiModelProperty(value = "结束时间")
	private java.util.Date endDate;
	
	@ApiModelProperty(value = "岗位主键")
	private java.lang.Long stationId;
	
	@ApiModelProperty(value = "岗位名称")
	private java.lang.String name;
	
	@ApiModelProperty(value = "岗位备注")
	private java.lang.String notes;
	
	@ApiModelProperty(value = "流程类型")
	private java.lang.String objType;
	
	@ApiModelProperty(value = "流程实例主键")
	private Long objId;
	
	@ApiModelProperty(value = "环节编码")
	private java.lang.Long linkId;
	
	@ApiModelProperty(value = "环节编号")
	private java.lang.String linkNo;
	
	@ApiModelProperty(value = "阶段编号")
	private java.lang.String phaseId;
	
	@ApiModelProperty(value = "阶段名称")
	private java.lang.String phaseName;
	
	@ApiModelProperty(value = "流程实例编码")
	private java.lang.String objTag;
	
	@ApiModelProperty(value = "岗位薪资")
	private java.lang.String stationMoney;
	
	@ApiModelProperty(value = "总数量")
	private java.lang.String stationAmount;
	
	@ApiModelProperty(value = "总金额")
	private java.lang.String stationAggregate;
	
	@ApiModelProperty(value = "岗位类型(平分,独享)")
	private Integer type;
	
	@ApiModelProperty(value = "岗位人数")
	private java.lang.String stationPeople;
	
	public void setSawId(Long value) {
		this.sawId = value;
	}
	
	public Long getSawId() {
		return this.sawId;
	}	    
	
	public Long getStaffId() {
		return this.staffId;
	}
	
	public void setStaffId(Long value) {
		this.staffId = value;
	}
	
	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	public java.lang.String getEmployeeName() {
		return this.employeeName;
	}
	
	public void setEmployeeName(java.lang.String value) {
		this.employeeName = value;
	}
	
	public java.lang.String getBillId() {
		return this.billId;
	}
	
	public void setBillId(java.lang.String value) {
		this.billId = value;
	}
	
	public java.lang.Long getOrganizeId() {
		return this.organizeId;
	}
	
	public void setOrganizeId(java.lang.Long value) {
		this.organizeId = value;
	}
	
	public java.lang.String getOrganizeName() {
		return this.organizeName;
	}
	
	public void setOrganizeName(java.lang.String value) {
		this.organizeName = value;
	}
	
	public Integer getOrgType() {
		return this.orgType;
	}
	
	public void setOrgType(Integer value) {
		this.orgType = value;
	}
	
	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(java.util.Date value) {
		this.createDate = value;
	}
	
	public java.util.Date getEndDate() {
		return this.endDate;
	}
	
	public void setEndDate(java.util.Date value) {
		this.endDate = value;
	}
	
	public java.lang.Long getStationId() {
		return this.stationId;
	}
	
	public void setStationId(java.lang.Long value) {
		this.stationId = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getNotes() {
		return this.notes;
	}
	
	public void setNotes(java.lang.String value) {
		this.notes = value;
	}
	
	public java.lang.String getObjType() {
		return this.objType;
	}
	
	public void setObjType(java.lang.String value) {
		this.objType = value;
	}
	
	public Long getObjId() {
		return this.objId;
	}
	
	public void setObjId(Long value) {
		this.objId = value;
	}
	
	public java.lang.Long getLinkId() {
		return this.linkId;
	}
	
	public void setLinkId(java.lang.Long value) {
		this.linkId = value;
	}
	
	public java.lang.String getLinkNo() {
		return this.linkNo;
	}
	
	public void setLinkNo(java.lang.String value) {
		this.linkNo = value;
	}
	
	public java.lang.String getPhaseId() {
		return this.phaseId;
	}
	
	public void setPhaseId(java.lang.String value) {
		this.phaseId = value;
	}
	
	public java.lang.String getPhaseName() {
		return this.phaseName;
	}
	
	public void setPhaseName(java.lang.String value) {
		this.phaseName = value;
	}
	
	public java.lang.String getObjTag() {
		return this.objTag;
	}
	
	public void setObjTag(java.lang.String value) {
		this.objTag = value;
	}
	
	public java.lang.String getStationMoney() {
		return this.stationMoney;
	}
	
	public void setStationMoney(java.lang.String value) {
		this.stationMoney = value;
	}
	
	public java.lang.String getStationAmount() {
		return this.stationAmount;
	}
	
	public void setStationAmount(java.lang.String value) {
		this.stationAmount = value;
	}
	
	public java.lang.String getStationAggregate() {
		return this.stationAggregate;
	}
	
	public void setStationAggregate(java.lang.String value) {
		this.stationAggregate = value;
	}
	
	public Integer getType() {
		return this.type;
	}
	
	public void setType(Integer value) {
		this.type = value;
	}
	
	public java.lang.String getStationPeople() {
		return this.stationPeople;
	}
	
	public void setStationPeople(java.lang.String value) {
		this.stationPeople = value;
	}
}

