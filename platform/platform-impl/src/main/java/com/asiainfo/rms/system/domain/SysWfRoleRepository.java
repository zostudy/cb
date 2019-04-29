package com.asiainfo.rms.system.domain;

import java.util.Date;

public class SysWfRoleRepository {
    private Integer wfRoleId;
    private Integer wfId;
    private String name;
    private String code;
    private String notes;
    private Integer linkId;
    private Integer opId;
    private Date createDate;
    private Integer state;
    private String processKey;

    public Integer getWfRoleId() {
        return wfRoleId;
    }

    public void setWfRoleId(Integer wfRoleId) {
        this.wfRoleId = wfRoleId;
    }

    public Integer getWfId() {
        return wfId;
    }

    public void setWfId(Integer wfId) {
        this.wfId = wfId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
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

    public String getProcessKey() {
        return processKey;
    }

    public void setProcessKey(String processKey) {
        this.processKey = processKey;
    }
}
