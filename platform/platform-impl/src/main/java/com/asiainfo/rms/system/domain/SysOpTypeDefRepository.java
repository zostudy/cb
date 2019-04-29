package com.asiainfo.rms.system.domain;

public class SysOpTypeDefRepository {
    private Integer OpTypeId;
    private String OpTypeName;
    private String code;
    private String notes;
    private Integer state;

    public Integer getOpTypeId() {
        return OpTypeId;
    }

    public void setOpTypeId(Integer opTypeId) {
        OpTypeId = opTypeId;
    }

    public String getOpTypeName() {
        return OpTypeName;
    }

    public void setOpTypeName(String opTypeName) {
        OpTypeName = opTypeName;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
