package com.asiainfo.rms.alm.util.domain;

import java.math.BigDecimal;

public class AlmAttachCheckConfigRepository {
    private BigDecimal attChkId;

    private BigDecimal codingType;

    private String attType;

    private String linkNo;

    private String sysTag;

    private String subsysTag;

    private String objType;

    private String mark;

    private BigDecimal status;

    public BigDecimal getAttChkId() {
        return attChkId;
    }

    public void setAttChkId(BigDecimal attChkId) {
        this.attChkId = attChkId;
    }

    public BigDecimal getCodingType() {
        return codingType;
    }

    public void setCodingType(BigDecimal codingType) {
        this.codingType = codingType;
    }

    public String getAttType() {
        return attType;
    }

    public void setAttType(String attType) {
        this.attType = attType == null ? null : attType.trim();
    }

    public String getLinkNo() {
        return linkNo;
    }

    public void setLinkNo(String linkNo) {
        this.linkNo = linkNo == null ? null : linkNo.trim();
    }

    public String getSysTag() {
        return sysTag;
    }

    public void setSysTag(String sysTag) {
        this.sysTag = sysTag == null ? null : sysTag.trim();
    }

    public String getSubsysTag() {
        return subsysTag;
    }

    public void setSubsysTag(String subsysTag) {
        this.subsysTag = subsysTag == null ? null : subsysTag.trim();
    }

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType == null ? null : objType.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
    }
}