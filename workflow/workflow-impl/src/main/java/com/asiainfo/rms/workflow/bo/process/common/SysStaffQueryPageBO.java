package com.asiainfo.rms.workflow.bo.process.common;

/**
 * 
 * 
 * @author joker
 */
public class SysStaffQueryPageBO {
	
	/**
	 * 工号ID(开始)
	 */
	private java.lang.Long staffIdBegin;
	
	/**
	 * 工号ID(结束)
	 */
	private java.lang.Long staffIdEnd;
	
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
	 * 修改密码时间(开始)
	 */
	private java.util.Date recentTimeBegin;
	
	/**
	 * 修改密码时间(结束)
	 */
	private java.util.Date recentTimeEnd;
	
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
	 * 状态(开始)
	 */
	private Integer stateBegin;
	
	/**
	 * 状态(结束)
	 */
	private Integer stateEnd;
	
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
	
	/**
	 * 分页页码
	 */
	private Integer pageNo;
	
	/**
	 * 分页步长
	 */
	private Integer pageSize;
			
	public java.lang.Long getStaffIdBegin() {
		return this.staffIdBegin;
	}
	
	public void setStaffIdBegin(java.lang.Long value) {
		this.staffIdBegin = value;
	}
	
	public java.lang.Long getStaffIdEnd() {
		return this.staffIdEnd;
	}
	
	public void setStaffIdEnd(java.lang.Long value) {
		this.staffIdEnd = value;
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
	public java.util.Date getRecentTimeBegin() {
		return this.recentTimeBegin;
	}
	
	public void setRecentTimeBegin(java.util.Date value) {
		this.recentTimeBegin = value;
	}
	
	public java.util.Date getRecentTimeEnd() {
		return this.recentTimeEnd;
	}
	
	public void setRecentTimeEnd(java.util.Date value) {
		this.recentTimeEnd = value;
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
	public Integer getStateBegin() {
		return this.stateBegin;
	}
	
	public void setStateBegin(Integer value) {
		this.stateBegin = value;
	}
	
	public Integer getStateEnd() {
		return this.stateEnd;
	}
	
	public void setStateEnd(Integer value) {
		this.stateEnd = value;
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
	
	public Integer getPageNo() {
		return this.pageNo;
	}
	
	public Integer getPageSize() {
		return this.pageSize;
	}
	
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}

