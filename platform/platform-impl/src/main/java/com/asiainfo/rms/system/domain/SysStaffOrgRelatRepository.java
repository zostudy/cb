package com.asiainfo.rms.system.domain;

import java.util.Date;

public class SysStaffOrgRelatRepository {
    private Integer staffOrgRelatId;//关系ID
    private Integer organizeId;//组织ID
    private String organizeName;//组织名称
    private String code;//组织编码
    private Integer staffId;//人员ID
    private Integer state;//状态 1:正常 0:删除
    private String notes;//备注
    private Date createTime;//创建时间
    private String ext1;//扩展字段1
    private String ext2;//扩展字段2
    private String ext3;//扩展字段3

    public Integer getStaffOrgRelatId() {
        return staffOrgRelatId;
    }

    public void setStaffOrgRelatId(Integer staffOrgRelatId) {
        this.staffOrgRelatId = staffOrgRelatId;
    }

    public Integer getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(Integer organizeId) {
        this.organizeId = organizeId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public String getOrganizeName() {
        return organizeName;
    }

    public void setOrganizeName(String organizeName) {
        this.organizeName = organizeName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
