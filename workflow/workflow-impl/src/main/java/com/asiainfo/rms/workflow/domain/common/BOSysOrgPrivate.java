package com.asiainfo.rms.workflow.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

/**
 * 
 * 
 * @author joker
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "SYS_ORG_PRIVATE")
public class BOSysOrgPrivate {
	
	// 
	private java.lang.Long staffId;
	// 
	@Length(max=20)
	private java.lang.String code;
	// 
	private java.lang.String employeeName;
	// 
	@Length(max=50)
	private java.lang.String billId;
	// 
	
	private java.lang.Boolean lockFlag;
	// 
	
	private java.lang.Long staffOrgRelatId;
	// 
	
	private java.lang.Long organizeId;
	// 
	@Length(max=200)
	private java.lang.String organizeName;
	// 
	private Integer orgType;
	// 
	@Length(max=128)
	private java.lang.String paramName;
	// 
	@Length(max=128)
	private java.lang.String paramType;

	public void setStaffId(java.lang.Long value) {
		this.staffId = value;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="ALM_XJ_EXPENSES_AUTHOR_SEQ")
	@SequenceGenerator(sequenceName="ALM_XJ_EXPENSES$SEQ",allocationSize=1,name="ALM_XJ_EXPENSES_AUTHOR_SEQ")
	@Column(name = "STAFF_ID", unique = false, nullable = false, insertable = true, updatable = true, length = 12)
	public java.lang.Long getStaffId() {
		return this.staffId;
	}	    
	
	@Column(name = "CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	@Column(name = "EMPLOYEE_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	public java.lang.String getEmployeeName() {
		return this.employeeName;
	}
	
	public void setEmployeeName(java.lang.String value) {
		this.employeeName = value;
	}
	
	@Column(name = "BILL_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getBillId() {
		return this.billId;
	}
	
	public void setBillId(java.lang.String value) {
		this.billId = value;
	}
	
	@Column(name = "LOCK_FLAG", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getLockFlag() {
		return this.lockFlag;
	}
	
	public void setLockFlag(java.lang.Boolean value) {
		this.lockFlag = value;
	}
	
	@Column(name = "STAFF_ORG_RELAT_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 12)
	public java.lang.Long getStaffOrgRelatId() {
		return this.staffOrgRelatId;
	}
	
	public void setStaffOrgRelatId(java.lang.Long value) {
		this.staffOrgRelatId = value;
	}
	
	@Column(name = "ORGANIZE_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 12)
	public java.lang.Long getOrganizeId() {
		return this.organizeId;
	}
	
	public void setOrganizeId(java.lang.Long value) {
		this.organizeId = value;
	}
	
	@Column(name = "ORGANIZE_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getOrganizeName() {
		return this.organizeName;
	}
	
	public void setOrganizeName(java.lang.String value) {
		this.organizeName = value;
	}
	
	@Column(name = "ORG_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public Integer getOrgType() {
		return this.orgType;
	}
	
	public void setOrgType(Integer value) {
		this.orgType = value;
	}
	
	@Column(name = "PARAM_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getParamName() {
		return this.paramName;
	}
	
	public void setParamName(java.lang.String value) {
		this.paramName = value;
	}
	
	@Column(name = "PARAM_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getParamType() {
		return this.paramType;
	}
	
	public void setParamType(java.lang.String value) {
		this.paramType = value;
	}
}

