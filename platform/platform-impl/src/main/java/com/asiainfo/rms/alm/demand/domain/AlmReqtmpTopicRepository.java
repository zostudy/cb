package com.asiainfo.rms.alm.demand.domain;

import java.util.Date;

public class AlmReqtmpTopicRepository {
    private Integer artId;//需求模板主键

    private String artTag;//需求编号（总编号）

    private String artName;//需求名称

    private Integer artRegion;//申请单位

    private Integer artDepart;//申请部门

    private Integer submitStaffId;//申请人员id

    private String submitStaffName;//申请人员名称

    private String submitStaffPhone;//申请人员电话

    private Integer urgentLevel;//紧急程度

    private Integer uploadBusipag;//是否在快速业务办理界面上载

    private Integer relizeMethod;//需求实现方式

    private Date askOnlineTime;//要求上线时间

    private Integer artType;//模板类型

    private Integer templateId;//模板内容主键

    private Date createTime;//创建时间

    private String opinion;//需求确定意见

    private String artRegionCont;//申请单位内容

    private String artDepartCont;//申请部门内容

    private String urgentLevelCont;//紧急程度内容

    private String uploadBusipagCont;//在快速业务办理界面上载内容

    private String relizeMethodCont;//需求实现方式内容

    private Integer similarMark;//相似度计算标签，已记算过


    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public String getArtTag() {
        return artTag;
    }

    public void setArtTag(String artTag) {
        this.artTag = artTag;
    }

    public String getArtName() {
        return artName;
    }

    public void setArtName(String artName) {
        this.artName = artName;
    }

    public Integer getArtRegion() {
        return artRegion;
    }

    public void setArtRegion(Integer artRegion) {
        this.artRegion = artRegion;
    }

    public Integer getArtDepart() {
        return artDepart;
    }

    public void setArtDepart(Integer artDepart) {
        this.artDepart = artDepart;
    }

    public Integer getSubmitStaffId() {
        return submitStaffId;
    }

    public void setSubmitStaffId(Integer submitStaffId) {
        this.submitStaffId = submitStaffId;
    }

    public String getSubmitStaffName() {
        return submitStaffName;
    }

    public void setSubmitStaffName(String submitStaffName) {
        this.submitStaffName = submitStaffName;
    }

    public String getSubmitStaffPhone() {
        return submitStaffPhone;
    }

    public void setSubmitStaffPhone(String submitStaffPhone) {
        this.submitStaffPhone = submitStaffPhone;
    }

    public Integer getUrgentLevel() {
        return urgentLevel;
    }

    public void setUrgentLevel(Integer urgentLevel) {
        this.urgentLevel = urgentLevel;
    }

    public Integer getUploadBusipag() {
        return uploadBusipag;
    }

    public void setUploadBusipag(Integer uploadBusipag) {
        this.uploadBusipag = uploadBusipag;
    }

    public Integer getRelizeMethod() {
        return relizeMethod;
    }

    public void setRelizeMethod(Integer relizeMethod) {
        this.relizeMethod = relizeMethod;
    }

    public Date getAskOnlineTime() {
        return askOnlineTime;
    }

    public void setAskOnlineTime(Date askOnlineTime) {
        this.askOnlineTime = askOnlineTime;
    }

    public Integer getArtType() {
        return artType;
    }

    public void setArtType(Integer artType) {
        this.artType = artType;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getArtRegionCont() {
        return artRegionCont;
    }

    public void setArtRegionCont(String artRegionCont) {
        this.artRegionCont = artRegionCont;
    }

    public String getArtDepartCont() {
        return artDepartCont;
    }

    public void setArtDepartCont(String artDepartCont) {
        this.artDepartCont = artDepartCont;
    }

    public String getUrgentLevelCont() {
        return urgentLevelCont;
    }

    public void setUrgentLevelCont(String urgentLevelCont) {
        this.urgentLevelCont = urgentLevelCont;
    }

    public String getUploadBusipagCont() {
        return uploadBusipagCont;
    }

    public void setUploadBusipagCont(String uploadBusipagCont) {
        this.uploadBusipagCont = uploadBusipagCont;
    }

    public String getRelizeMethodCont() {
        return relizeMethodCont;
    }

    public void setRelizeMethodCont(String relizeMethodCont) {
        this.relizeMethodCont = relizeMethodCont;
    }

    public Integer getSimilarMark() {
        return similarMark;
    }

    public void setSimilarMark(Integer similarMark) {
        this.similarMark = similarMark;
    }
}
