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
@Table(name = "SYS_STATION_PRIVATE")
public class BOSysStationPrivate {
	
	// 
	private java.lang.Long staffId;
	// 
	@Length(max=20)
	private java.lang.String staffCode;
	// 
	private java.lang.String employeeName;
	// 
	@Length(max=50)
	private java.lang.String billId;
	// 
	
	private java.lang.Boolean lockFlag;
	// 
	
	private java.lang.Long authorId;
	// 
	@Length(max=128)
	private java.lang.String notes;
	// 
	@Length(max=128)
	private java.lang.String notesType;
	// 
	
	private java.lang.Long stationId;
	// 
	@Length(max=40)
	private java.lang.String stationCode;
	// 
	@Length(max=60)
	private java.lang.String name;
	// 
	private Integer type;
	// 
	private Integer stationType;
	// 
	@Length(max=128)
	private java.lang.String staPrivateName;
	// 
	@Length(max=128)
	private java.lang.String staPrivateType;
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
	private java.lang.String orgPrivateName;
	// 
	@Length(max=128)
	private java.lang.String orgPrivateType;

	public void setStaffId(java.lang.Long value) {
		this.staffId = value;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="SYS_STATION_PRIVATE_SEQ")
	@SequenceGenerator(sequenceName="SYS_STATION_PRIVATE$SEQ",allocationSize=1,name="SYS_STATION_PRIVATE_SEQ")
	@Column(name = "STAFF_ID", unique = false, nullable = false, insertable = true, updatable = true, length = 12)
	public java.lang.Long getStaffId() {
		return this.staffId;
	}	    
	
	@Column(name = "STAFF_CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getStaffCode() {
		return this.staffCode;
	}
	
	public void setStaffCode(java.lang.String value) {
		this.staffCode = value;
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
	
	@Column(name = "AUTHOR_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 12)
	public java.lang.Long getAuthorId() {
		return this.authorId;
	}
	
	public void setAuthorId(java.lang.Long value) {
		this.authorId = value;
	}
	
	@Column(name = "NOTES", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getNotes() {
		return this.notes;
	}
	
	public void setNotes(java.lang.String value) {
		this.notes = value;
	}
	
	@Column(name = "NOTES_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getNotesType() {
		return this.notesType;
	}
	
	public void setNotesType(java.lang.String value) {
		this.notesType = value;
	}
	
	@Column(name = "STATION_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 12)
	public java.lang.Long getStationId() {
		return this.stationId;
	}
	
	public void setStationId(java.lang.Long value) {
		this.stationId = value;
	}
	
	@Column(name = "STATION_CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	public java.lang.String getStationCode() {
		return this.stationCode;
	}
	
	public void setStationCode(java.lang.String value) {
		this.stationCode = value;
	}
	
	@Column(name = "NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 60)
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	@Column(name = "TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public Integer getType() {
		return this.type;
	}
	
	public void setType(Integer value) {
		this.type = value;
	}
	
	@Column(name = "STATION_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public Integer getStationType() {
		return this.stationType;
	}
	
	public void setStationType(Integer value) {
		this.stationType = value;
	}
	
	@Column(name = "STA_PRIVATE_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getStaPrivateName() {
		return this.staPrivateName;
	}
	
	public void setStaPrivateName(java.lang.String value) {
		this.staPrivateName = value;
	}
	
	@Column(name = "STA_PRIVATE_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getStaPrivateType() {
		return this.staPrivateType;
	}
	
	public void setStaPrivateType(java.lang.String value) {
		this.staPrivateType = value;
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
	
	@Column(name = "ORG_PRIVATE_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getOrgPrivateName() {
		return this.orgPrivateName;
	}
	
	public void setOrgPrivateName(java.lang.String value) {
		this.orgPrivateName = value;
	}
	
	@Column(name = "ORG_PRIVATE_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getOrgPrivateType() {
		return this.orgPrivateType;
	}
	
	public void setOrgPrivateType(java.lang.String value) {
		this.orgPrivateType = value;
	}
}

