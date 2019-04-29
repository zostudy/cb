package com.asiainfo.rms.system.domain;

import java.util.Date;

public class SysStationWfRoleRepository {
    private Integer relId;
    private Integer stationId;
    private Integer wfRoleId;
    private Integer opId;
    private Date createDate;

    private String name;
    private String code;

    public Integer getRelId() {
        return relId;
    }

    public void setRelId(Integer relId) {
        this.relId = relId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Integer getWfRoleId() {
        return wfRoleId;
    }

    public void setWfRoleId(Integer wfRoleId) {
        this.wfRoleId = wfRoleId;
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
}
