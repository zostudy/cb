package com.asiainfo.rms.system.domain;

import java.util.Date;

public class SysStaffRoleAuthorRepository {
    private Integer roleAuthorId;//主键
    private Integer roleId;//内部编码
    private Integer staffId;//员工主键
    private String notes;//备注
    private Integer state;//状态 1:正常0:注销
    private Date createTime;//创建时间
    private String ext1;//扩展字段1
    private String ext2;//扩展字段2
    private String ext3;//扩展字段3
    private String operateType;//操作符：C-新增，U-修改，D-删除

    public Integer getRoleAuthorId() {
        return roleAuthorId;
    }

    public void setRoleAuthorId(Integer roleAuthorId) {
        this.roleAuthorId = roleAuthorId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }
}
