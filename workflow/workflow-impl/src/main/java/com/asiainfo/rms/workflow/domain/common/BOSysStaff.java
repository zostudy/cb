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
@Table(name = "SYS_STAFF")
public class BOSysStaff {
	
	// 工号ID
	
	private java.lang.Long staffId;
	// 工号
	@Length(max=20)
	private java.lang.String code;
	// 密码
	@Length(max=48)
	private java.lang.String password;
	// 修改密码,记录上一次
	@Length(max=300)
	private java.lang.String recentPassword;
	// 修改密码时间
	
	private java.util.Date recentTime;
	// 雇员名称
	private java.lang.String employeeName;
	// 手机号码
	@Length(max=50)
	private java.lang.String billId;
	// 邮箱
	@Length(max=50)
	private java.lang.String email;
	// 职责
	@Length(max=1000)
	private java.lang.String religion;
	// 状态
	private Integer state;
	// 是否有锁
	
	private java.lang.Boolean lockFlag;
	// 备注
	@Length(max=255)
	private java.lang.String notes;
	// 扩展字段1
	@Length(max=20)
	private java.lang.String ext1;
	// 扩展字段2
	@Length(max=20)
	private java.lang.String ext2;
	// 扩展字段3
	@Length(max=20)
	private java.lang.String ext3;
	// 4A主账号
	@Length(max=4000)
	private java.lang.String account4a;
	// CRM从账号
	@Length(max=4000)
	private java.lang.String accountCrm;
	// BOSS从账号
	@Length(max=4000)
	private java.lang.String accountBoss;
	
	public void setStaffId(java.lang.Long value) {
		this.staffId = value;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="ALM_PRIMARY_TABLE_SEQ")
	@SequenceGenerator(sequenceName="ALM_PRIMARY_TABLE$SEQ",allocationSize=1,name="ALM_PRIMARY_TABLE_SEQ")
	@Column(name = "STAFF_ID", unique = true, nullable = false, insertable = true, updatable = true, length = 12)
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
	
	@Column(name = "PASSWORD", unique = false, nullable = true, insertable = true, updatable = true, length = 48)
	public java.lang.String getPassword() {
		return this.password;
	}
	
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
	@Column(name = "RECENT_PASSWORD", unique = false, nullable = true, insertable = true, updatable = true, length = 300)
	public java.lang.String getRecentPassword() {
		return this.recentPassword;
	}
	
	public void setRecentPassword(java.lang.String value) {
		this.recentPassword = value;
	}
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RECENT_TIME", unique = false, nullable = true, insertable = true, updatable = true)
	public java.util.Date getRecentTime() {
		return this.recentTime;
	}
	
	public void setRecentTime(java.util.Date value) {
		this.recentTime = value;
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
	
	@Column(name = "EMAIL", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getEmail() {
		return this.email;
	}
	
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	@Column(name = "RELIGION", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public java.lang.String getReligion() {
		return this.religion;
	}
	
	public void setReligion(java.lang.String value) {
		this.religion = value;
	}
	
	@Column(name = "STATE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public Integer getState() {
		return this.state;
	}
	
	public void setState(Integer value) {
		this.state = value;
	}
	
	@Column(name = "LOCK_FLAG", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getLockFlag() {
		return this.lockFlag;
	}
	
	public void setLockFlag(java.lang.Boolean value) {
		this.lockFlag = value;
	}
	
	@Column(name = "NOTES", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	public java.lang.String getNotes() {
		return this.notes;
	}
	
	public void setNotes(java.lang.String value) {
		this.notes = value;
	}
	
	@Column(name = "EXT1", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getExt1() {
		return this.ext1;
	}
	
	public void setExt1(java.lang.String value) {
		this.ext1 = value;
	}
	
	@Column(name = "EXT2", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getExt2() {
		return this.ext2;
	}
	
	public void setExt2(java.lang.String value) {
		this.ext2 = value;
	}
	
	@Column(name = "EXT3", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getExt3() {
		return this.ext3;
	}
	
	public void setExt3(java.lang.String value) {
		this.ext3 = value;
	}
	
	@Column(name = "ACCOUNT_4A", unique = false, nullable = true, insertable = true, updatable = true, length = 4000)
	public java.lang.String getAccount4a() {
		return this.account4a;
	}
	
	public void setAccount4a(java.lang.String value) {
		this.account4a = value;
	}
	
	@Column(name = "ACCOUNT_CRM", unique = false, nullable = true, insertable = true, updatable = true, length = 4000)
	public java.lang.String getAccountCrm() {
		return this.accountCrm;
	}
	
	public void setAccountCrm(java.lang.String value) {
		this.accountCrm = value;
	}
	
	@Column(name = "ACCOUNT_BOSS", unique = false, nullable = true, insertable = true, updatable = true, length = 4000)
	public java.lang.String getAccountBoss() {
		return this.accountBoss;
	}
	
	public void setAccountBoss(java.lang.String value) {
		this.accountBoss = value;
	}
}

