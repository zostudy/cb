package com.asiainfo.rms.system.domain;

import java.util.Date;

public class SysOpLogRepository {

    private Integer opLogId;
    private Integer opTypeId;
    private String opContent;
    private Integer opId;
    private Date opDate;

    public Integer getOpLogId() {
        return opLogId;
    }

    public void setOpLogId(Integer opLogId) {
        this.opLogId = opLogId;
    }

    public Integer getOpTypeId() {
        return opTypeId;
    }

    public void setOpTypeId(Integer opTypeId) {
        this.opTypeId = opTypeId;
    }

    public String getOpContent() {
        return opContent;
    }

    public void setOpContent(String opContent) {
        this.opContent = opContent;
    }

    public Integer getOpId() {
        return opId;
    }

    public void setOpId(Integer opId) {
        this.opId = opId;
    }

    public Date getOpDate() {
        return opDate;
    }

    public void setOpDate(Date opDate) {
        this.opDate = opDate;
    }
}
