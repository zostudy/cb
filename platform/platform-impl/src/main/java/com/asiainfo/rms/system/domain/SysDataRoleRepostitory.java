package com.asiainfo.rms.system.domain;

import java.util.Date;

public class SysDataRoleRepostitory {
    private Integer dataRoleId;//主键
    private String name;//数据权限名称
    private Integer organizeId;//组织ID
    private String code;//数据权限编码
    private String notes;//备注
    private Integer opId;//创建人员
    private Date createDate;//创建时间
    private Integer state;//状态：1-正常，0-注销

    public Integer getDataRoleId() {
        return dataRoleId;
    }

    public void setDataRoleId(Integer dataRoleId) {
        this.dataRoleId = dataRoleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(Integer organizeId) {
        this.organizeId = organizeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getOpId() {
        return opId;
    }

    public void setOpId(Integer opId) {
        this.opId = opId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
