package com.asiainfo.rms.alm.demand.domain;

public class AlmReqtmpEleChanlRepository {
    private Integer areId;//电渠模板主键

    private String purpost;//需求目标

    private String funcWf;//功能流程描述

    private String implementReq;//实现要求

    private String interfaces;//接口说明

    private String reportForm;//报表说明

    private String monitorDemond;//监控要求

    private String otherContent;//其他说明

    private Integer artType;//模板类型，电渠类

    private Integer artId;//需求模板主题表主键

    private String funcwfCont;//功能流程描述内容

    private String implreqCont;//实现要求内容

    private String eleChannel;//电渠承载渠道

    private String eleChannelCont;//电渠承载渠道内容

    private String monitorReq;//监控要求

    private String purpostCont;//需求目标内容

    private String insertCode;//插码要求

    private String artTag;

    private String artName;

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

    public Integer getAreId() {
        return areId;
    }

    public void setAreId(Integer areId) {
        this.areId = areId;
    }

    public String getPurpost() {
        return purpost;
    }

    public void setPurpost(String purpost) {
        this.purpost = purpost;
    }

    public String getFuncWf() {
        return funcWf;
    }

    public void setFuncWf(String funcWf) {
        this.funcWf = funcWf;
    }

    public String getImplementReq() {
        return implementReq;
    }

    public void setImplementReq(String implementReq) {
        this.implementReq = implementReq;
    }

    public String getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(String interfaces) {
        this.interfaces = interfaces;
    }

    public String getReportForm() {
        return reportForm;
    }

    public void setReportForm(String reportForm) {
        this.reportForm = reportForm;
    }

    public String getMonitorDemond() {
        return monitorDemond;
    }

    public void setMonitorDemond(String monitorDemond) {
        this.monitorDemond = monitorDemond;
    }

    public String getOtherContent() {
        return otherContent;
    }

    public void setOtherContent(String otherContent) {
        this.otherContent = otherContent;
    }

    public Integer getArtType() {
        return artType;
    }

    public void setArtType(Integer artType) {
        this.artType = artType;
    }

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public String getFuncwfCont() {
        return funcwfCont;
    }

    public void setFuncwfCont(String funcwfCont) {
        this.funcwfCont = funcwfCont;
    }

    public String getImplreqCont() {
        return implreqCont;
    }

    public void setImplreqCont(String implreqCont) {
        this.implreqCont = implreqCont;
    }

    public String getEleChannel() {
        return eleChannel;
    }

    public void setEleChannel(String eleChannel) {
        this.eleChannel = eleChannel;
    }

    public String getMonitorReq() {
        return monitorReq;
    }

    public void setMonitorReq(String monitorReq) {
        this.monitorReq = monitorReq;
    }

    public String getPurpostCont() {
        return purpostCont;
    }

    public void setPurpostCont(String purpostCont) {
        this.purpostCont = purpostCont;
    }

    public String getInsertCode() {
        return insertCode;
    }

    public void setInsertCode(String insertCode) {
        this.insertCode = insertCode;
    }

    public String getEleChannelCont() {
        return eleChannelCont;
    }

    public void setEleChannelCont(String eleChannelCont) {
        this.eleChannelCont = eleChannelCont;
    }
}
