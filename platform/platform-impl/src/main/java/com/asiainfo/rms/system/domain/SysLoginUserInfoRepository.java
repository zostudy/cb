package com.asiainfo.rms.system.domain;

import com.asiainfo.rms.system.dto.SysFunctionDTO;

import java.util.List;

public class SysLoginUserInfoRepository {
    private Integer staffId;//员工ID
    private String code;//员工工号
    private String employeeName;//雇员名称
    private String billId;//手机号码
    private String email;//邮箱
    private String religion;//职责
    private Integer state;//状态 1:上锁，0:解锁
    private Integer organizeId;//组织ID
    private String organizeName;//组织名称
    private Integer logId;//日志编号
    private String flag;//是否地市分公司
    private List<SysFunctionDTO> functionDTO;
    
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

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public List<SysFunctionDTO> getFunctionDTO() {
        return functionDTO;
    }

    public void setFunctionDTO(List<SysFunctionDTO> functionDTO) {
        this.functionDTO = functionDTO;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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
