package com.asiainfo.rms.alm.util.domain;

import java.util.Date;

public class AlmAttachmentRepository {
    private Long attId;

    private String attName;

    private String attPath;

    private String attType;

    private String attDesc;

    private String submitterTag;

    private Date submitTime;

    private String submitLink;

    public Long getAttId() {
        return attId;
    }

    public void setAttId(Long attId) {
        this.attId = attId;
    }

    public String getAttName() {
        return attName;
    }

    public void setAttName(String attName) {
        this.attName = attName == null ? null : attName.trim();
    }

    public String getAttPath() {
        return attPath;
    }

    public void setAttPath(String attPath) {
        this.attPath = attPath == null ? null : attPath.trim();
    }

    public String getAttType() {
        return attType;
    }

    public void setAttType(String attType) {
        this.attType = attType == null ? null : attType.trim();
    }

    public String getAttDesc() {
        return attDesc;
    }

    public void setAttDesc(String attDesc) {
        this.attDesc = attDesc == null ? null : attDesc.trim();
    }

    public String getSubmitterTag() {
        return submitterTag;
    }

    public void setSubmitterTag(String submitterTag) {
        this.submitterTag = submitterTag == null ? null : submitterTag.trim();
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getSubmitLink() {
        return submitLink;
    }

    public void setSubmitLink(String submitLink) {
        this.submitLink = submitLink == null ? null : submitLink.trim();
    }

}