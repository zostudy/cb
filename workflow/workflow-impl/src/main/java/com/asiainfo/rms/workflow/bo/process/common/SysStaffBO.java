package com.asiainfo.rms.workflow.bo.process.common;

/**
 * 
 * 
 * @author joker
 */
public class SysStaffBO {
	
	/**
	 * 工号ID
	 */
	private java.lang.Long staffId;
	
	/**
	 * 工号
	 */
	private java.lang.String code;
	
	/**
	 * 密码
	 */
	private java.lang.String password;
	
	/**
	 * 修改密码,记录上一次
	 */
	private java.lang.String recentPassword;
	
	/**
	 * 修改密码时间
	 */
	private java.util.Date recentTime;
	
	/**
	 * 雇员名称
	 */
	private java.lang.String employeeName;
	
	/**
	 * 手机号码
	 */
	private java.lang.String billId;
	
	/**
	 * 邮箱
	 */
	private java.lang.String email;
	
	/**
	 * 职责
	 */
	private java.lang.String religion;
	
	/**
	 * 状态
	 */
	private Integer state;
	
	/**
	 * 是否有锁
	 */
	private java.lang.Boolean lockFlag;
	
	/**
	 * 备注
	 */
	private java.lang.String notes;
	
	/**
	 * 扩展字段1
	 */
	private java.lang.String ext1;
	
	/**
	 * 扩展字段2
	 */
	private java.lang.String ext2;
	
	/**
	 * 扩展字段3
	 */
	private java.lang.String ext3;
	
	/**
	 * 4A主账号
	 */
	private java.lang.String account4a;
	
	/**
	 * CRM从账号
	 */
	private java.lang.String accountCrm;
	
	/**
	 * BOSS从账号
	 */
	private java.lang.String accountBoss;
	
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
	
	public java.lang.String getPassword() {
		return this.password;
	}
	
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
	public java.lang.String getRecentPassword() {
		return this.recentPassword;
	}
	
	public void setRecentPassword(java.lang.String value) {
		this.recentPassword = value;
	}
	
	public java.util.Date getRecentTime() {
		return this.recentTime;
	}
	
	public void setRecentTime(java.util.Date value) {
		this.recentTime = value;
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
	
	public java.lang.String getEmail() {
		return this.email;
	}
	
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	public java.lang.String getReligion() {
		return this.religion;
	}
	
	public void setReligion(java.lang.String value) {
		this.religion = value;
	}
	
	public Integer getState() {
		return this.state;
	}
	
	public void setState(Integer value) {
		this.state = value;
	}
	
	public java.lang.Boolean getLockFlag() {
		return this.lockFlag;
	}
	
	public void setLockFlag(java.lang.Boolean value) {
		this.lockFlag = value;
	}
	
	public java.lang.String getNotes() {
		return this.notes;
	}
	
	public void setNotes(java.lang.String value) {
		this.notes = value;
	}
	
	public java.lang.String getExt1() {
		return this.ext1;
	}
	
	public void setExt1(java.lang.String value) {
		this.ext1 = value;
	}
	
	public java.lang.String getExt2() {
		return this.ext2;
	}
	
	public void setExt2(java.lang.String value) {
		this.ext2 = value;
	}
	
	public java.lang.String getExt3() {
		return this.ext3;
	}
	
	public void setExt3(java.lang.String value) {
		this.ext3 = value;
	}
	
	public java.lang.String getAccount4a() {
		return this.account4a;
	}
	
	public void setAccount4a(java.lang.String value) {
		this.account4a = value;
	}
	
	public java.lang.String getAccountCrm() {
		return this.accountCrm;
	}
	
	public void setAccountCrm(java.lang.String value) {
		this.accountCrm = value;
	}
	
	public java.lang.String getAccountBoss() {
		return this.accountBoss;
	}
	
	public void setAccountBoss(java.lang.String value) {
		this.accountBoss = value;
	}
}

