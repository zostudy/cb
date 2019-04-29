package com.asiainfo.rms.system.domain;

import java.util.Date;

public class SysStaffRepository
{
    private Integer staffId;//员工ID
    private String code;//员工工号
    private String password;//密码
    private String recentPassword;//修改密码,记录上一次
    private Date recentTime;//修改密码时间
    private String employeeName;//雇员名称
    private String billId;//手机号码
    private String email;//邮箱
    private String religion;//职责
    private Integer state;//状态 1:上锁，0:解锁
    private Integer lockFlag;//是否有锁 1:是 0:否
    private String notes;//备注
    private String ext1;//扩展字段1
    private String ext2;//扩展字段2
    private String ext3;//扩展字段3

    private Integer organizeId;
    private String organizeName;
    
    private String account4A; //4A主账号
    private	String accountCrm; 	//CRM从账号
    private String accountBoss; //BOSS从账号

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRecentPassword() {
        return recentPassword;
    }

    public void setRecentPassword(String recentPassword) {
        this.recentPassword = recentPassword;
    }

    public Date getRecentTime() {
        return recentTime;
    }

    public void setRecentTime(Date recentTime) {
        this.recentTime = recentTime;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(Integer lockFlag) {
        this.lockFlag = lockFlag;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    public Integer getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(Integer organizeId) {
        this.organizeId = organizeId;
    }

    public String getOrganizeName() {
        return organizeName;
    }

    public void setOrganizeName(String organizeName) {
        this.organizeName = organizeName;
    }

	public String getAccount4A() {
		return account4A;
	}

	public void setAccount4A(String account4a) {
		account4A = account4a;
	}

	public String getAccountCrm() {
		return accountCrm;
	}

	public void setAccountCrm(String accountCrm) {
		this.accountCrm = accountCrm;
	}

	public String getAccountBoss() {
		return accountBoss;
	}

	public void setAccountBoss(String accountBoss) {
		this.accountBoss = accountBoss;
	}
    
    
}
