package com.asiainfo.rms.workflow.dto.process.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author joker
 */
@ApiModel(description = "")
public class SysOrgPrivateDTO {
	
	@ApiModelProperty(value = "")
	private java.lang.Long staffId;
	
	@ApiModelProperty(value = "")
	private java.lang.String code;
	
	@ApiModelProperty(value = "")
	private java.lang.String employeeName;
	
	@ApiModelProperty(value = "")
	private java.lang.String billId;
	
	@ApiModelProperty(value = "")
	private java.lang.Boolean lockFlag;
	
	@ApiModelProperty(value = "")
	private java.lang.Long staffOrgRelatId;
	
	@ApiModelProperty(value = "")
	private java.lang.Long organizeId;
	
	@ApiModelProperty(value = "")
	private java.lang.String organizeName;
	
	@ApiModelProperty(value = "")
	private Integer orgType;
	
	@ApiModelProperty(value = "")
	private java.lang.String paramName;
	
	@ApiModelProperty(value = "")
	private java.lang.String paramType;
	
	public void setStaffId(java.lang.Long value) {
		this.staffId = value;
	}
	
	public java.lang.Long getStaffId() {
		return this.staffId;
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
	
	public java.lang.Boolean getLockFlag() {
		return this.lockFlag;
	}
	
	public void setLockFlag(java.lang.Boolean value) {
		this.lockFlag = value;
	}
	
	public java.lang.Long getStaffOrgRelatId() {
		return this.staffOrgRelatId;
	}
	
	public void setStaffOrgRelatId(java.lang.Long value) {
		this.staffOrgRelatId = value;
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
	
	public java.lang.String getParamName() {
		return this.paramName;
	}
	
	public void setParamName(java.lang.String value) {
		this.paramName = value;
	}
	
	public java.lang.String getParamType() {
		return this.paramType;
	}
	
	public void setParamType(java.lang.String value) {
		this.paramType = value;
	}
}

