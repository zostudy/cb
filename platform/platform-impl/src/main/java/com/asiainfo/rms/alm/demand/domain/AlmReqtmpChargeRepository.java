package com.asiainfo.rms.alm.demand.domain;

import java.util.Date;

public class AlmReqtmpChargeRepository {
    private Integer archId;//资费类模板主键

    private Date activateTimeStart;//活动开始时间

    private Date activateTimeEnd;//活动结束时间

    private String purpost;//需求主要目的

    private String effectPlan;//预计成效

    private String chargeLimit;//资费办理限制

    private String chargeOpen;//资费开放区域

    private String chargeValid;//资费有效期

    private String chargeCollect;//月费收取方式

    private String effectWay;//资费生效方式

    private String invalidWay;//资费失效方式

    private Integer artType;//模板类型，资费类

    private Integer artId;//需求模板主题表主键

    private String chargeName;//资费名称

    private String purpostCont;//需求主要目标内容

    private String chargeContent;//资费内容说明

    private String chargeOver;//超出本资费说明

    private String chargeChannel;//资费办理渠道

    private String channelWay;//各渠道办理方式

    private String mutex;//互斥说明

    private String accounts;//账务说明

    private String monitorDemond;//监控要求

    private String message;//下行短信

    private String bills;//单据

    private String reportForm;//报表需求

    private String otherContent;//其他说明

    private String chargeCont;//资费内容说明文字

    private String packageAllo;//套餐分摊规则

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

    public Integer getArchId() {
        return archId;
    }

    public void setArchId(Integer archId) {
        this.archId = archId;
    }

    public Date getActivateTimeStart() {
        return activateTimeStart;
    }

    public void setActivateTimeStart(Date activateTimeStart) {
        this.activateTimeStart = activateTimeStart;
    }

    public Date getActivateTimeEnd() {
        return activateTimeEnd;
    }

    public void setActivateTimeEnd(Date activateTimeEnd) {
        this.activateTimeEnd = activateTimeEnd;
    }

    public String getPurpost() {
        return purpost;
    }

    public void setPurpost(String purpost) {
        this.purpost = purpost;
    }

    public String getEffectPlan() {
        return effectPlan;
    }

    public void setEffectPlan(String effectPlan) {
        this.effectPlan = effectPlan;
    }

    public String getChargeLimit() {
        return chargeLimit;
    }

    public void setChargeLimit(String chargeLimit) {
        this.chargeLimit = chargeLimit;
    }

    public String getChargeOpen() {
        return chargeOpen;
    }

    public void setChargeOpen(String chargeOpen) {
        this.chargeOpen = chargeOpen;
    }

    public String getChargeValid() {
        return chargeValid;
    }

    public void setChargeValid(String chargeValid) {
        this.chargeValid = chargeValid;
    }

    public String getChargeCollect() {
        return chargeCollect;
    }

    public void setChargeCollect(String chargeCollect) {
        this.chargeCollect = chargeCollect;
    }

    public String getEffectWay() {
        return effectWay;
    }

    public void setEffectWay(String effectWay) {
        this.effectWay = effectWay;
    }

    public String getInvalidWay() {
        return invalidWay;
    }

    public void setInvalidWay(String invalidWay) {
        this.invalidWay = invalidWay;
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

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public String getPurpostCont() {
        return purpostCont;
    }

    public void setPurpostCont(String purpostCont) {
        this.purpostCont = purpostCont;
    }

    public String getChargeContent() {
        return chargeContent;
    }

    public void setChargeContent(String chargeContent) {
        this.chargeContent = chargeContent;
    }

    public String getChargeOver() {
        return chargeOver;
    }

    public void setChargeOver(String chargeOver) {
        this.chargeOver = chargeOver;
    }

    public String getChargeChannel() {
        return chargeChannel;
    }

    public void setChargeChannel(String chargeChannel) {
        this.chargeChannel = chargeChannel;
    }

    public String getChannelWay() {
        return channelWay;
    }

    public void setChannelWay(String channelWay) {
        this.channelWay = channelWay;
    }

    public String getMutex() {
        return mutex;
    }

    public void setMutex(String mutex) {
        this.mutex = mutex;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public String getMonitorDemond() {
        return monitorDemond;
    }

    public void setMonitorDemond(String monitorDemond) {
        this.monitorDemond = monitorDemond;
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

    public String getReportForm() {
        return reportForm;
    }

    public void setReportForm(String reportForm) {
        this.reportForm = reportForm;
    }

    public String getOtherContent() {
        return otherContent;
    }

    public void setOtherContent(String otherContent) {
        this.otherContent = otherContent;
    }

    public String getChargeCont() {
        return chargeCont;
    }

    public void setChargeCont(String chargeCont) {
        this.chargeCont = chargeCont;
    }

    public String getPackageAllo() {
        return packageAllo;
    }

    public void setPackageAllo(String packageAllo) {
        this.packageAllo = packageAllo;
    }
}
