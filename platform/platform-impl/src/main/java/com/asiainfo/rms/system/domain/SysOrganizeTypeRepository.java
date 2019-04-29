package com.asiainfo.rms.system.domain;

import java.util.Date;

public class SysOrganizeTypeRepository {
    private Integer organizeTypeId;
    private String organizeTypeName;
    private String code;
    private String notes;
    private Integer opId;
    private Date createDate;
    private Integer state;

    public Integer getOrganizeTypeId() {
        return organizeTypeId;
    }

    public void setOrganizeTypeId(Integer organizeTypeId) {
        this.organizeTypeId = organizeTypeId;
    }

    public String getOrganizeTypeName() {
        return organizeTypeName;
    }

    public void setOrganizeTypeName(String organizeTypeName) {
        this.organizeTypeName = organizeTypeName;
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
