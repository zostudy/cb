package com.asiainfo.rms.workflow.dto.process.cb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 罚款流水
 * 
 * @author joker
 */
@ApiModel(description = "罚款流水")
public class AlmCbFineFlowDTO {
	
	@ApiModelProperty(value = "流水主键")
	private Long fineId;
	
	@ApiModelProperty(value = "员工主键")
	private Long staffId;
	
	@ApiModelProperty(value = "雇员名称")
	private java.lang.String staffName;
	
	@ApiModelProperty(value = "组织主键")
	private Long organizeId;
	
	@ApiModelProperty(value = "组织名称")
	private java.lang.String organizeName;
	
	@ApiModelProperty(value = "组织权限")
	private Integer organizeType;
	
	@ApiModelProperty(value = "岗位主键")
	private Long stationId;
	
	@ApiModelProperty(value = "岗位金额")
	private java.lang.String stationCode;
	
	@ApiModelProperty(value = "岗位名称")
	private java.lang.String stationName;
	
	@ApiModelProperty(value = "岗位备注")
	private java.lang.String stationNotes;
	
	@ApiModelProperty(value = "岗位类型")
	private Integer stationType;
	
	@ApiModelProperty(value = "岗位权限")
	private Integer stationPrivateType;
	
	@ApiModelProperty(value = "关系主键")
	private Long authorId;
	
	@ApiModelProperty(value = "岗位关系备注干湿")
	private java.lang.String authorNotes;
	
	@ApiModelProperty(value = "流程主键")
	private Long objId;
	
	@ApiModelProperty(value = "流程编码")
	private java.lang.String objTag;
	
	@ApiModelProperty(value = "流程金额")
	private java.lang.String objAccount;
	
	@ApiModelProperty(value = "流程公式")
	private java.lang.String objFormula;
	
	@ApiModelProperty(value = "流程数量")
	private java.lang.String objAmount;
	
	@ApiModelProperty(value = "流程人数")
	private java.lang.String objStaff;
	
	@ApiModelProperty(value = "是否可用")
	private Integer isValid;
	
	@ApiModelProperty(value = "不可用原因")
	private java.lang.String unvalidReason;
	
	@ApiModelProperty(value = "创建时间")
	private java.util.Date createTime;
	
	@ApiModelProperty(value = "罚款类型")
	private java.lang.String fineType;
	
	@ApiModelProperty(value = "罚款金额")
	private java.lang.String fineMoney;
	
	@ApiModelProperty(value = "罚款描述")
	private java.lang.String fineDesc;
	
	@ApiModelProperty(value = "加减标识")
	private java.lang.String reduceAdd;
	
	@ApiModelProperty(value = "罚金数量")
	private java.lang.String fineAmount;
	
	@ApiModelProperty(value = "罚金公式")
	private java.lang.String fineFormula;
	
	@ApiModelProperty(value = "罚金总额")
	private java.lang.String fineAccount;
	
	@ApiModelProperty(value = "流水主键")
	private Long flowId;
	
	public void setFineId(Long value) {
		this.fineId = value;
	}
	
	public Long getFineId() {
		return this.fineId;
	}
	
	public Long getStaffId() {
		return this.staffId;
	}
	
	public void setStaffId(Long value) {
		this.staffId = value;
	}
	
	public java.lang.String getStaffName() {
		return this.staffName;
	}
	
	public void setStaffName(java.lang.String value) {
		this.staffName = value;
	}
	
	public Long getOrganizeId() {
		return this.organizeId;
	}
	
	public void setOrganizeId(Long value) {
		this.organizeId = value;
	}
	
	public java.lang.String getOrganizeName() {
		return this.organizeName;
	}
	
	public void setOrganizeName(java.lang.String value) {
		this.organizeName = value;
	}
	
	public Integer getOrganizeType() {
		return this.organizeType;
	}
	
	public void setOrganizeType(Integer value) {
		this.organizeType = value;
	}
	
	public Long getStationId() {
		return this.stationId;
	}
	
	public void setStationId(Long value) {
		this.stationId = value;
	}
	
	public java.lang.String getStationCode() {
		return this.stationCode;
	}
	
	public void setStationCode(java.lang.String value) {
		this.stationCode = value;
	}
	
	public java.lang.String getStationName() {
		return this.stationName;
	}
	
	public void setStationName(java.lang.String value) {
		this.stationName = value;
	}
	
	public java.lang.String getStationNotes() {
		return this.stationNotes;
	}
	
	public void setStationNotes(java.lang.String value) {
		this.stationNotes = value;
	}
	
	public Integer getStationType() {
		return this.stationType;
	}
	
	public void setStationType(Integer value) {
		this.stationType = value;
	}
	
	public Integer getStationPrivateType() {
		return this.stationPrivateType;
	}
	
	public void setStationPrivateType(Integer value) {
		this.stationPrivateType = value;
	}
	
	public Long getAuthorId() {
		return this.authorId;
	}
	
	public void setAuthorId(Long value) {
		this.authorId = value;
	}
	
	public java.lang.String getAuthorNotes() {
		return this.authorNotes;
	}
	
	public void setAuthorNotes(java.lang.String value) {
		this.authorNotes = value;
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
	
	public java.lang.String getObjAccount() {
		return this.objAccount;
	}
	
	public void setObjAccount(java.lang.String value) {
		this.objAccount = value;
	}
	
	public java.lang.String getObjFormula() {
		return this.objFormula;
	}
	
	public void setObjFormula(java.lang.String value) {
		this.objFormula = value;
	}
	
	public java.lang.String getObjAmount() {
		return this.objAmount;
	}
	
	public void setObjAmount(java.lang.String value) {
		this.objAmount = value;
	}
	
	public java.lang.String getObjStaff() {
		return this.objStaff;
	}
	
	public void setObjStaff(java.lang.String value) {
		this.objStaff = value;
	}
	
	public Integer getIsValid() {
		return this.isValid;
	}
	
	public void setIsValid(Integer value) {
		this.isValid = value;
	}
	
	public java.lang.String getUnvalidReason() {
		return this.unvalidReason;
	}
	
	public void setUnvalidReason(java.lang.String value) {
		this.unvalidReason = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.lang.String getFineType() {
		return this.fineType;
	}
	
	public void setFineType(java.lang.String value) {
		this.fineType = value;
	}
	
	public java.lang.String getFineMoney() {
		return this.fineMoney;
	}
	
	public void setFineMoney(java.lang.String value) {
		this.fineMoney = value;
	}
	
	public java.lang.String getFineDesc() {
		return this.fineDesc;
	}
	
	public void setFineDesc(java.lang.String value) {
		this.fineDesc = value;
	}
	
	public java.lang.String getReduceAdd() {
		return this.reduceAdd;
	}
	
	public void setReduceAdd(java.lang.String value) {
		this.reduceAdd = value;
	}
	
	public java.lang.String getFineAmount() {
		return this.fineAmount;
	}
	
	public void setFineAmount(java.lang.String value) {
		this.fineAmount = value;
	}
	
	public java.lang.String getFineFormula() {
		return this.fineFormula;
	}
	
	public void setFineFormula(java.lang.String value) {
		this.fineFormula = value;
	}
	
	public java.lang.String getFineAccount() {
		return this.fineAccount;
	}
	
	public void setFineAccount(java.lang.String value) {
		this.fineAccount = value;
	}
	
	public Long getFlowId() {
		return this.flowId;
	}
	
	public void setFlowId(Long value) {
		this.flowId = value;
	}
}

