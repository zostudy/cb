package com.asiainfo.rms.system.domain;

public class SysStaffWorkingGroupRepository {
    private Integer relId;
    private Integer workGroupId;
    private Integer staffId;

    private String WorkGroupCode;
    private String WorkGroupName;

    private String employeeCode;//雇员名称
    private String employeeName;//雇员名称
    private String billId;//手机号码
    private String email;//邮箱

    private String organizeCode;
    private String organizeName;

    public Integer getRelId() {
        return relId;
    }

    public void setRelId(Integer relId) {
        this.relId = relId;
    }

    public Integer getWorkGroupId() {
        return workGroupId;
    }

    public void setWorkGroupId(Integer workGroupId) {
        this.workGroupId = workGroupId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getWorkGroupCode() {
        return WorkGroupCode;
    }

    public void setWorkGroupCode(String workGroupCode) {
        WorkGroupCode = workGroupCode;
    }

    public String getWorkGroupName() {
        return WorkGroupName;
    }

    public void setWorkGroupName(String workGroupName) {
        WorkGroupName = workGroupName;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
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

    public String getOrganizeCode() {
        return organizeCode;
    }

    public void setOrganizeCode(String organizeCode) {
        this.organizeCode = organizeCode;
    }

    public String getOrganizeName() {
        return organizeName;
    }

    public void setOrganizeName(String organizeName) {
        this.organizeName = organizeName;
    }
}
