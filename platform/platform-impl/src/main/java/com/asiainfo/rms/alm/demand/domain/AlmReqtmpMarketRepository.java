package com.asiainfo.rms.alm.demand.domain;

import java.util.Date;

public class AlmReqtmpMarketRepository {
    private Integer armId;//营销模板主键

    private Integer artType;//模板类型，营销类

    private String marketName;//营销活动名称

    private String effectPlan;//预计成效

    private String purpost;//活动目的

    private Date activateTimeStart;//活动时间开始

    private Date activateTimeEnd;//活动时间结束

    private String acrivateType;//活动类型

    private String activateChannel;//参与渠道

    private String activateLimit;//活动限制

    private String effectWay;//生效方式

    private String invalidWay;//失效方式

    private String priorContent;//优先级

    private Integer artId;//需求模板主题表主键

    private String channelMark;//参与渠道说明

    private Integer marketResource;//营销资源

    private Integer feedbackResource;//回馈资源

    private String marketOrderno;//营销关联工单号

    private String feedbackOrderno;//回馈关联工单号

    private String marketBatchno;//营销关联批次号

    private String feedbackBatchno;//回馈关联批次号

    private String targetCustomer;//目标客户

    private String purpostCont;//需求目标内容

    private String acrivateTypeCont;//活动类型内容

    private String activateChannelCont;//参与渠道内容

    private String marketResourceCont;//营销资源内容

    private String feedbackResourceCont;//回馈资源内容

    private String marketContent;//活动内容

    private String billingShare;//结算分摊说明

    private String mutex;//互斥

    private String superposition;//叠加

    private String message;//短信提醒

    private String bills;//单据

    private String reportForm;//报表说明

    private String otherContent;//其他说明

    private String monitorDemond;//监控要求

    private String staffPerm;//渠道工号权限

    private String marketCont;//活动内容无格式

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

    public Integer getArmId() {
        return armId;
    }

    public void setArmId(Integer armId) {
        this.armId = armId;
    }

    public Integer getArtType() {
        return artType;
    }

    public void setArtType(Integer artType) {
        this.artType = artType;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getEffectPlan() {
        return effectPlan;
    }

    public void setEffectPlan(String effectPlan) {
        this.effectPlan = effectPlan;
    }

    public String getPurpost() {
        return purpost;
    }

    public void setPurpost(String purpost) {
        this.purpost = purpost;
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

    public String getAcrivateType() {
        return acrivateType;
    }

    public void setAcrivateType(String acrivateType) {
        this.acrivateType = acrivateType;
    }

    public String getActivateChannel() {
        return activateChannel;
    }

    public void setActivateChannel(String activateChannel) {
        this.activateChannel = activateChannel;
    }

    public String getActivateLimit() {
        return activateLimit;
    }

    public void setActivateLimit(String activateLimit) {
        this.activateLimit = activateLimit;
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

    public String getPriorContent() {
        return priorContent;
    }

    public void setPriorContent(String priorContent) {
        this.priorContent = priorContent;
    }

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public String getChannelMark() {
        return channelMark;
    }

    public void setChannelMark(String channelMark) {
        this.channelMark = channelMark;
    }

    public Integer getMarketResource() {
        return marketResource;
    }

    public void setMarketResource(Integer marketResource) {
        this.marketResource = marketResource;
    }

    public Integer getFeedbackResource() {
        return feedbackResource;
    }

    public void setFeedbackResource(Integer feedbackResource) {
        this.feedbackResource = feedbackResource;
    }

    public String getMarketOrderno() {
        return marketOrderno;
    }

    public void setMarketOrderno(String marketOrderno) {
        this.marketOrderno = marketOrderno;
    }

    public String getFeedbackOrderno() {
        return feedbackOrderno;
    }

    public void setFeedbackOrderno(String feedbackOrderno) {
        this.feedbackOrderno = feedbackOrderno;
    }

    public String getMarketBatchno() {
        return marketBatchno;
    }

    public void setMarketBatchno(String marketBatchno) {
        this.marketBatchno = marketBatchno;
    }

    public String getFeedbackBatchno() {
        return feedbackBatchno;
    }

    public void setFeedbackBatchno(String feedbackBatchno) {
        this.feedbackBatchno = feedbackBatchno;
    }

    public String getTargetCustomer() {
        return targetCustomer;
    }

    public void setTargetCustomer(String targetCustomer) {
        this.targetCustomer = targetCustomer;
    }

    public String getPurpostCont() {
        return purpostCont;
    }

    public void setPurpostCont(String purpostCont) {
        this.purpostCont = purpostCont;
    }

    public String getAcrivateTypeCont() {
        return acrivateTypeCont;
    }

    public void setAcrivateTypeCont(String acrivateTypeCont) {
        this.acrivateTypeCont = acrivateTypeCont;
    }

    public String getActivateChannelCont() {
        return activateChannelCont;
    }

    public void setActivateChannelCont(String activateChannelCont) {
        this.activateChannelCont = activateChannelCont;
    }

    public String getMarketResourceCont() {
        return marketResourceCont;
    }

    public void setMarketResourceCont(String marketResourceCont) {
        this.marketResourceCont = marketResourceCont;
    }

    public String getFeedbackResourceCont() {
        return feedbackResourceCont;
    }

    public void setFeedbackResourceCont(String feedbackResourceCont) {
        this.feedbackResourceCont = feedbackResourceCont;
    }

    public String getMarketContent() {
        return marketContent;
    }

    public void setMarketContent(String marketContent) {
        this.marketContent = marketContent;
    }

    public String getBillingShare() {
        return billingShare;
    }

    public void setBillingShare(String billingShare) {
        this.billingShare = billingShare;
    }

    public String getMutex() {
        return mutex;
    }

    public void setMutex(String mutex) {
        this.mutex = mutex;
    }

    public String getSuperposition() {
        return superposition;
    }

    public void setSuperposition(String superposition) {
        this.superposition = superposition;
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

    public String getMonitorDemond() {
        return monitorDemond;
    }

    public void setMonitorDemond(String monitorDemond) {
        this.monitorDemond = monitorDemond;
    }

    public String getStaffPerm() {
        return staffPerm;
    }

    public void setStaffPerm(String staffPerm) {
        this.staffPerm = staffPerm;
    }

    public String getMarketCont() {
        return marketCont;
    }

    public void setMarketCont(String marketCont) {
        this.marketCont = marketCont;
    }

    public String getPackageAllo() {
        return packageAllo;
    }

    public void setPackageAllo(String packageAllo) {
        this.packageAllo = packageAllo;
    }
}
