package com.asiainfo.rms.alm.arsenal.domain;

import java.math.BigDecimal;

public class AlmAsnltmpChgeExtendRepository {

    private Integer aceId;//资费类模板附表主键（幸福卡）

    private Integer artType;//模板类型

    private Integer aatId;//模板主表主键

    private String benefitName;//优惠名称

    private String benefitDscr;//优惠描述

    private Integer inTrafficType1;//套餐内流量类别1

    private String inTrafficTypeCont1;//套餐内流量类别1内容

    private BigDecimal inTrafficAmount1;//套餐内流量类别1额度（M）

    private Integer inTrafficTypePrio1;//套餐内流量类别1优先级

    private Integer inTimeType1;//套餐内时长类别1

    private String inTimeTypeCont1;//套餐内时长类别1内容

    private BigDecimal inTimeAmount1;//套餐内时长类别1额度（分钟）

    private Integer inShortMsg;//套餐内短信

    private Integer inMediaMsg;//套餐内彩信

    private String outCalling;//套餐外主叫

    private String outCalled;//套餐外被叫

    private String outTraffic;//套餐外流量

    private Integer outShortMsg;//套餐外短信

    private Integer outMediaMsg;//套餐外彩信

    private Integer subjectCode1;//科目1编码

    private String subjectCodeCont1;//科目1编码内容

    private String shareRatio1;//科目1分摊比例

    private Integer subjectCode2;//科目2编码

    private String subjectCodeCont2;//科目2编码内容

    private String shareRatio2;//科目2分摊比例

    private Integer subjectCode3;//科目3编码

    private String subjectCodeCont3;//科目3编码内容

    private String shareRatio3;//科目3分摊比例

    private Integer onlineState;//上线状态0为默认，1为成功，-1为失败

    private Integer firstChargeWay;//套餐月费首月收费方式

    private String firstChargeWayCont;//套餐月费首月收费方式内容

    private Integer secndChargeWay;//次月月费收费方式

    private String secndChargeWayCont;//次月月费收费方式内容

    private Integer rollinWay;//套餐转入规则

    private String rollinWayCont;//套餐转入规则内容

    private Integer rolloutWay;//套餐转出规则

    private String rolloutWayCont;//套餐转出规则内容

    private Integer packagePriod;//套餐优先级

    private String packagePriodCont;//套餐优先级内容

    private Integer acId;//资费类模板附表主键（幸福卡）

    public Integer getAceId() {
        return aceId;
    }

    public void setAceId(Integer aceId) {
        this.aceId = aceId;
    }

    public Integer getArtType() {
        return artType;
    }

    public void setArtType(Integer artType) {
        this.artType = artType;
    }

    public Integer getAatId() {
        return aatId;
    }

    public void setAatId(Integer aatId) {
        this.aatId = aatId;
    }

    public String getBenefitName() {
        return benefitName;
    }

    public void setBenefitName(String benefitName) {
        this.benefitName = benefitName;
    }

    public String getBenefitDscr() {
        return benefitDscr;
    }

    public void setBenefitDscr(String benefitDscr) {
        this.benefitDscr = benefitDscr;
    }

    public Integer getInTrafficType1() {
        return inTrafficType1;
    }

    public void setInTrafficType1(Integer inTrafficType1) {
        this.inTrafficType1 = inTrafficType1;
    }

    public String getInTrafficTypeCont1() {
        return inTrafficTypeCont1;
    }

    public void setInTrafficTypeCont1(String inTrafficTypeCont1) {
        this.inTrafficTypeCont1 = inTrafficTypeCont1;
    }

    public BigDecimal getInTrafficAmount1() {
        return inTrafficAmount1;
    }

    public void setInTrafficAmount1(BigDecimal inTrafficAmount1) {
        this.inTrafficAmount1 = inTrafficAmount1;
    }

    public Integer getInTrafficTypePrio1() {
        return inTrafficTypePrio1;
    }

    public void setInTrafficTypePrio1(Integer inTrafficTypePrio1) {
        this.inTrafficTypePrio1 = inTrafficTypePrio1;
    }

    public Integer getInTimeType1() {
        return inTimeType1;
    }

    public void setInTimeType1(Integer inTimeType1) {
        this.inTimeType1 = inTimeType1;
    }

    public String getInTimeTypeCont1() {
        return inTimeTypeCont1;
    }

    public void setInTimeTypeCont1(String inTimeTypeCont1) {
        this.inTimeTypeCont1 = inTimeTypeCont1;
    }

    public BigDecimal getInTimeAmount1() {
        return inTimeAmount1;
    }

    public void setInTimeAmount1(BigDecimal inTimeAmount1) {
        this.inTimeAmount1 = inTimeAmount1;
    }

    public Integer getInShortMsg() {
        return inShortMsg;
    }

    public void setInShortMsg(Integer inShortMsg) {
        this.inShortMsg = inShortMsg;
    }

    public Integer getInMediaMsg() {
        return inMediaMsg;
    }

    public void setInMediaMsg(Integer inMediaMsg) {
        this.inMediaMsg = inMediaMsg;
    }

    public String getOutCalling() {
        return outCalling;
    }

    public void setOutCalling(String outCalling) {
        this.outCalling = outCalling;
    }

    public String getOutCalled() {
        return outCalled;
    }

    public void setOutCalled(String outCalled) {
        this.outCalled = outCalled;
    }

    public String getOutTraffic() {
        return outTraffic;
    }

    public void setOutTraffic(String outTraffic) {
        this.outTraffic = outTraffic;
    }

    public Integer getOutShortMsg() {
        return outShortMsg;
    }

    public void setOutShortMsg(Integer outShortMsg) {
        this.outShortMsg = outShortMsg;
    }

    public Integer getOutMediaMsg() {
        return outMediaMsg;
    }

    public void setOutMediaMsg(Integer outMediaMsg) {
        this.outMediaMsg = outMediaMsg;
    }

    public Integer getSubjectCode1() {
        return subjectCode1;
    }

    public void setSubjectCode1(Integer subjectCode1) {
        this.subjectCode1 = subjectCode1;
    }

    public String getSubjectCodeCont1() {
        return subjectCodeCont1;
    }

    public void setSubjectCodeCont1(String subjectCodeCont1) {
        this.subjectCodeCont1 = subjectCodeCont1;
    }

    public String getShareRatio1() {
        return shareRatio1;
    }

    public void setShareRatio1(String shareRatio1) {
        this.shareRatio1 = shareRatio1;
    }

    public Integer getSubjectCode2() {
        return subjectCode2;
    }

    public void setSubjectCode2(Integer subjectCode2) {
        this.subjectCode2 = subjectCode2;
    }

    public String getSubjectCodeCont2() {
        return subjectCodeCont2;
    }

    public void setSubjectCodeCont2(String subjectCodeCont2) {
        this.subjectCodeCont2 = subjectCodeCont2;
    }

    public String getShareRatio2() {
        return shareRatio2;
    }

    public void setShareRatio2(String shareRatio2) {
        this.shareRatio2 = shareRatio2;
    }

    public Integer getSubjectCode3() {
        return subjectCode3;
    }

    public void setSubjectCode3(Integer subjectCode3) {
        this.subjectCode3 = subjectCode3;
    }

    public String getSubjectCodeCont3() {
        return subjectCodeCont3;
    }

    public void setSubjectCodeCont3(String subjectCodeCont3) {
        this.subjectCodeCont3 = subjectCodeCont3;
    }

    public String getShareRatio3() {
        return shareRatio3;
    }

    public void setShareRatio3(String shareRatio3) {
        this.shareRatio3 = shareRatio3;
    }

    public Integer getOnlineState() {
        return onlineState;
    }

    public void setOnlineState(Integer onlineState) {
        this.onlineState = onlineState;
    }

    public Integer getFirstChargeWay() {
        return firstChargeWay;
    }

    public void setFirstChargeWay(Integer firstChargeWay) {
        this.firstChargeWay = firstChargeWay;
    }

    public String getFirstChargeWayCont() {
        return firstChargeWayCont;
    }

    public void setFirstChargeWayCont(String firstChargeWayCont) {
        this.firstChargeWayCont = firstChargeWayCont;
    }

    public Integer getSecndChargeWay() {
        return secndChargeWay;
    }

    public void setSecndChargeWay(Integer secndChargeWay) {
        this.secndChargeWay = secndChargeWay;
    }

    public String getSecndChargeWayCont() {
        return secndChargeWayCont;
    }

    public void setSecndChargeWayCont(String secndChargeWayCont) {
        this.secndChargeWayCont = secndChargeWayCont;
    }

    public Integer getRollinWay() {
        return rollinWay;
    }

    public void setRollinWay(Integer rollinWay) {
        this.rollinWay = rollinWay;
    }

    public String getRollinWayCont() {
        return rollinWayCont;
    }

    public void setRollinWayCont(String rollinWayCont) {
        this.rollinWayCont = rollinWayCont;
    }

    public Integer getRolloutWay() {
        return rolloutWay;
    }

    public void setRolloutWay(Integer rolloutWay) {
        this.rolloutWay = rolloutWay;
    }

    public String getRolloutWayCont() {
        return rolloutWayCont;
    }

    public void setRolloutWayCont(String rolloutWayCont) {
        this.rolloutWayCont = rolloutWayCont;
    }

    public Integer getPackagePriod() {
        return packagePriod;
    }

    public void setPackagePriod(Integer packagePriod) {
        this.packagePriod = packagePriod;
    }

    public String getPackagePriodCont() {
        return packagePriodCont;
    }

    public void setPackagePriodCont(String packagePriodCont) {
        this.packagePriodCont = packagePriodCont;
    }

    public Integer getAcId() {
        return acId;
    }

    public void setAcId(Integer acId) {
        this.acId = acId;
    }
}
