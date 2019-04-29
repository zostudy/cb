package com.asiainfo.rms.alm.arsenal.domain;

import java.util.Date;

public class AlmAsnltmpTopicRepository {

    private Integer aatId;//武器库模板主键

    private Integer artType;//武器库模板类型

    private String aatTag;//需求编码

    private String aatName;//需求名称

    private String aatRegion;//申请单位

    private Integer aatDepart;//申请部门

    private Integer submitStaffId;//提出人id

    private String submitStaffName;//提出人名称

    private String submitStaffPhone;//提出人电话

    private Integer urgentLevel;//紧急程度

    private Date askOnlineTime;//要求上线时间

    private Integer relizeMethod;//实现方式

    private Integer targetCust;//目标客户

    private String reqTarget;//需求目标

    private String dealChannel;//办理渠道

    private String joinWay;//参与方式

    private String joinLimit;//参与限制

    private String balanceExp;//结算分摊说明

    private String mutexExp;//互斥说明

    private String overlyExp;//叠加说明

    private String bindExp;//捆绑优惠说明

    private String prioExp;//优先级说明

    private String otherExp;//其他说明

    private String orderMsg;//订购短信

    private String updateMsg;//更新短信

    private String freeFill;//免填单

    private String accountDetail;//帐详单

    private String busiReport;//经分报表

    private String eleShow;//电渠展示

    private String authExp;//权限说明

    private String aatRegionCont;//申请单位内容

    private String aatDepartCont;//申请部门内容

    private String urgentLevelCont;//紧急程度内容

    private String relizeMethodCont;//实现方式内容

    private String targetCustCont;//目标客户内容

    private String reqTargetCont;//需求目标内容

    private String dealChannelCont;//办理渠道内容

    private Date createTime;//创建时间

    private String opinion;//厂商意见

    private Integer onlineState;//上线状态0为默认，1为成功，-1为失败

    private Date sendTime;//发送运营平台时间

    private Date stateBackTime;//运营回参时间

    public Integer getAatId() {
        return aatId;
    }

    public void setAatId(Integer aatId) {
        this.aatId = aatId;
    }

    public Integer getArtType() {
        return artType;
    }

    public void setArtType(Integer artType) {
        this.artType = artType;
    }

    public String getAatTag() {
        return aatTag;
    }

    public void setAatTag(String aatTag) {
        this.aatTag = aatTag;
    }

    public String getAatName() {
        return aatName;
    }

    public void setAatName(String aatName) {
        this.aatName = aatName;
    }

    public String getAatRegion() {
        return aatRegion;
    }

    public void setAatRegion(String aatRegion) {
        this.aatRegion = aatRegion;
    }

    public Integer getAatDepart() {
        return aatDepart;
    }

    public void setAatDepart(Integer aatDepart) {
        this.aatDepart = aatDepart;
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

    public Date getAskOnlineTime() {
        return askOnlineTime;
    }

    public void setAskOnlineTime(Date askOnlineTime) {
        this.askOnlineTime = askOnlineTime;
    }

    public Integer getRelizeMethod() {
        return relizeMethod;
    }

    public void setRelizeMethod(Integer relizeMethod) {
        this.relizeMethod = relizeMethod;
    }

    public Integer getTargetCust() {
        return targetCust;
    }

    public void setTargetCust(Integer targetCust) {
        this.targetCust = targetCust;
    }

    public String getReqTarget() {
        return reqTarget;
    }

    public void setReqTarget(String reqTarget) {
        this.reqTarget = reqTarget;
    }

    public String getDealChannel() {
        return dealChannel;
    }

    public void setDealChannel(String dealChannel) {
        this.dealChannel = dealChannel;
    }

    public String getJoinWay() {
        return joinWay;
    }

    public void setJoinWay(String joinWay) {
        this.joinWay = joinWay;
    }

    public String getJoinLimit() {
        return joinLimit;
    }

    public void setJoinLimit(String joinLimit) {
        this.joinLimit = joinLimit;
    }

    public String getBalanceExp() {
        return balanceExp;
    }

    public void setBalanceExp(String balanceExp) {
        this.balanceExp = balanceExp;
    }

    public String getMutexExp() {
        return mutexExp;
    }

    public void setMutexExp(String mutexExp) {
        this.mutexExp = mutexExp;
    }

    public String getOverlyExp() {
        return overlyExp;
    }

    public void setOverlyExp(String overlyExp) {
        this.overlyExp = overlyExp;
    }

    public String getBindExp() {
        return bindExp;
    }

    public void setBindExp(String bindExp) {
        this.bindExp = bindExp;
    }

    public String getPrioExp() {
        return prioExp;
    }

    public void setPrioExp(String prioExp) {
        this.prioExp = prioExp;
    }

    public String getOtherExp() {
        return otherExp;
    }

    public void setOtherExp(String otherExp) {
        this.otherExp = otherExp;
    }

    public String getOrderMsg() {
        return orderMsg;
    }

    public void setOrderMsg(String orderMsg) {
        this.orderMsg = orderMsg;
    }

    public String getUpdateMsg() {
        return updateMsg;
    }

    public void setUpdateMsg(String updateMsg) {
        this.updateMsg = updateMsg;
    }

    public String getFreeFill() {
        return freeFill;
    }

    public void setFreeFill(String freeFill) {
        this.freeFill = freeFill;
    }

    public String getAccountDetail() {
        return accountDetail;
    }

    public void setAccountDetail(String accountDetail) {
        this.accountDetail = accountDetail;
    }

    public String getBusiReport() {
        return busiReport;
    }

    public void setBusiReport(String busiReport) {
        this.busiReport = busiReport;
    }

    public String getEleShow() {
        return eleShow;
    }

    public void setEleShow(String eleShow) {
        this.eleShow = eleShow;
    }

    public String getAuthExp() {
        return authExp;
    }

    public void setAuthExp(String authExp) {
        this.authExp = authExp;
    }

    public String getAatRegionCont() {
        return aatRegionCont;
    }

    public void setAatRegionCont(String aatRegionCont) {
        this.aatRegionCont = aatRegionCont;
    }

    public String getAatDepartCont() {
        return aatDepartCont;
    }

    public void setAatDepartCont(String aatDepartCont) {
        this.aatDepartCont = aatDepartCont;
    }

    public String getUrgentLevelCont() {
        return urgentLevelCont;
    }

    public void setUrgentLevelCont(String urgentLevelCont) {
        this.urgentLevelCont = urgentLevelCont;
    }

    public String getRelizeMethodCont() {
        return relizeMethodCont;
    }

    public void setRelizeMethodCont(String relizeMethodCont) {
        this.relizeMethodCont = relizeMethodCont;
    }

    public String getTargetCustCont() {
        return targetCustCont;
    }

    public void setTargetCustCont(String targetCustCont) {
        this.targetCustCont = targetCustCont;
    }

    public String getReqTargetCont() {
        return reqTargetCont;
    }

    public void setReqTargetCont(String reqTargetCont) {
        this.reqTargetCont = reqTargetCont;
    }

    public String getDealChannelCont() {
        return dealChannelCont;
    }

    public void setDealChannelCont(String dealChannelCont) {
        this.dealChannelCont = dealChannelCont;
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

    public Integer getOnlineState() {
        return onlineState;
    }

    public void setOnlineState(Integer onlineState) {
        this.onlineState = onlineState;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getStateBackTime() {
        return stateBackTime;
    }

    public void setStateBackTime(Date stateBackTime) {
        this.stateBackTime = stateBackTime;
    }
}
