package com.asiainfo.rms.alm.demand.domain;

public class AlmReqtmpFunctionRepository {
    private Integer arfId;//功能类模板主键

    private String purpost;//需求主要目的

    private Integer artType;//板类型-功能类

    private Integer artId;//需求模板主题表主键

    private String funcName;//功能名称

    private String purpostCont;//需求主要目标内容

    private String autonymIdentify;//是否送在线公司做实名认证

    private String autonymIdentifyCont;//是否送在线公司做实名认证内容

    private String funcWf;//新增/优化业务功能描述

    private String implementReq;//新增/优化界面要求描述

    private String message;//短信要求

    private String bills;//票据要求（账详单/免填单）

    private String accounts;//计费帐务要求

    private String permission;//权限要求

    private String onlineReq;//上线要求

    private String busiRelate;//关联业务

    private String complement;//配合及补充

    private String otherContent;//其他说明

    private String funcwfCont;//新增/优化业务功能描述文字

    private String implementCont;//新增/优化界面要求描述文字

    private String dataUpdate;//存量数据变更规则

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

    public Integer getArfId() {
        return arfId;
    }

    public void setArfId(Integer arfId) {
        this.arfId = arfId;
    }

    public String getPurpost() {
        return purpost;
    }

    public void setPurpost(String purpost) {
        this.purpost = purpost;
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

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getPurpostCont() {
        return purpostCont;
    }

    public void setPurpostCont(String purpostCont) {
        this.purpostCont = purpostCont;
    }

    public String getAutonymIdentify() {
        return autonymIdentify;
    }

    public void setAutonymIdentify(String autonymIdentify) {
        this.autonymIdentify = autonymIdentify;
    }

    public String getAutonymIdentifyCont() {
        return autonymIdentifyCont;
    }

    public void setAutonymIdentifyCont(String autonymIdentifyCont) {
        this.autonymIdentifyCont = autonymIdentifyCont;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBills() {
        return bills;
    }

    public void setBills(String bills) {
        this.bills = bills;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getOnlineReq() {
        return onlineReq;
    }

    public void setOnlineReq(String onlineReq) {
        this.onlineReq = onlineReq;
    }

    public String getBusiRelate() {
        return busiRelate;
    }

    public void setBusiRelate(String busiRelate) {
        this.busiRelate = busiRelate;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getOtherContent() {
        return otherContent;
    }

    public void setOtherContent(String otherContent) {
        this.otherContent = otherContent;
    }

    public String getFuncwfCont() {
        return funcwfCont;
    }

    public void setFuncwfCont(String funcwfCont) {
        this.funcwfCont = funcwfCont;
    }

    public String getImplementCont() {
        return implementCont;
    }

    public void setImplementCont(String implementCont) {
        this.implementCont = implementCont;
    }

    public String getDataUpdate() {
        return dataUpdate;
    }

    public void setDataUpdate(String dataUpdate) {
        this.dataUpdate = dataUpdate;
    }
}
