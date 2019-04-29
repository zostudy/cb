package com.asiainfo.rms.alm.arsenal.domain;

import java.math.BigDecimal;

public class AlmAsnltmpSgExtendRepository {
    private Integer aasId;//存送类模板附表主键

    private Integer artType;//模板类型

    private Integer givePoint;//赠送积分

    private Integer giveTimeType1;//赠送时长类别1

    private String giveTimetypeCont1;//赠送时长类别1内容

    private BigDecimal giveTimeAmount1;//赠送时长类别1额度（分钟）

    private Integer giveTimeContract1;//赠送时长类别1合约期

    private BigDecimal monthTimeBack1;//赠送时长类别1分月到账（分钟）

    private Integer giveTimeType2;//赠送时长类别2

    private String giveTimetypeCont2;//赠送时长类别2内容

    private BigDecimal giveTimeAmount2;//赠送时长类别2额度（分钟）

    private Integer giveTimeContract2;//赠送时长类别2合约期

    private BigDecimal monthTimeBack2;//赠送时长类别2分月到账（分钟）

    private Integer giveTrafficType1;//赠送流量类别1

    private String giveTrafctypeCont1;//赠送流量类别1内容

    private BigDecimal giveTrafficAmount1;//赠送流量类别1额度（M）

    private Integer giveTrafficContract1;//赠送流量类别1合约期

    private BigDecimal monthTrafficBack1;//赠送流量类别1分月到账（M）

    private Integer giveTrafficType2;//赠送流量类别2

    private String giveTrafctypeCont2;//赠送流量类别2内容

    private BigDecimal giveTrafficAmount2;//赠送流量类别2额度（M）

    private Integer giveTrafficContract2;//赠送流量类别2合约期

    private BigDecimal monthTrafficBack2;//赠送流量类别2分月到账（M）

    private Integer giveTrafficType3;//赠送流量类别3

    private String giveTrafctypeCont3;//赠送流量类别3内容

    private BigDecimal giveTrafficAmount3;//赠送流量类别3额度（M）

    private Integer giveTrafficContract3;//赠送流量类别3合约期

    private BigDecimal monthTrafficBack3;//赠送流量类别3分月到账（M）

    private BigDecimal giveBill;//赠送话费

    private Integer giveBillContract;//赠送话费合约期

    private BigDecimal giveBillAmount;//赠送话费分月到账

    private Integer giveBillPassbook;//赠送话费存折

    private String giveBillpbCont;//赠送话费存折内容

    private String giveElecoupNum;//电子券批次号

    private BigDecimal giveElecoup;//赠送电子券

    private BigDecimal givePointPrice;//赠送积分价值

    private Integer aatId;//武器库模板主键

    private Integer onlineState;//上线状态0为默认，1为成功，-1为失败

    public Integer getAasId() {
        return aasId;
    }

    public void setAasId(Integer aasId) {
        this.aasId = aasId;
    }

    public Integer getArtType() {
        return artType;
    }

    public void setArtType(Integer artType) {
        this.artType = artType;
    }

    public Integer getGivePoint() {
        return givePoint;
    }

    public void setGivePoint(Integer givePoint) {
        this.givePoint = givePoint;
    }

    public Integer getGiveTimeType1() {
        return giveTimeType1;
    }

    public void setGiveTimeType1(Integer giveTimeType1) {
        this.giveTimeType1 = giveTimeType1;
    }

    public String getGiveTimetypeCont1() {
        return giveTimetypeCont1;
    }

    public void setGiveTimetypeCont1(String giveTimetypeCont1) {
        this.giveTimetypeCont1 = giveTimetypeCont1;
    }

    public BigDecimal getGiveTimeAmount1() {
        return giveTimeAmount1;
    }

    public void setGiveTimeAmount1(BigDecimal giveTimeAmount1) {
        this.giveTimeAmount1 = giveTimeAmount1;
    }

    public Integer getGiveTimeContract1() {
        return giveTimeContract1;
    }

    public void setGiveTimeContract1(Integer giveTimeContract1) {
        this.giveTimeContract1 = giveTimeContract1;
    }

    public BigDecimal getMonthTimeBack1() {
        return monthTimeBack1;
    }

    public void setMonthTimeBack1(BigDecimal monthTimeBack1) {
        this.monthTimeBack1 = monthTimeBack1;
    }

    public Integer getGiveTimeType2() {
        return giveTimeType2;
    }

    public void setGiveTimeType2(Integer giveTimeType2) {
        this.giveTimeType2 = giveTimeType2;
    }

    public String getGiveTimetypeCont2() {
        return giveTimetypeCont2;
    }

    public void setGiveTimetypeCont2(String giveTimetypeCont2) {
        this.giveTimetypeCont2 = giveTimetypeCont2;
    }

    public BigDecimal getGiveTimeAmount2() {
        return giveTimeAmount2;
    }

    public void setGiveTimeAmount2(BigDecimal giveTimeAmount2) {
        this.giveTimeAmount2 = giveTimeAmount2;
    }

    public Integer getGiveTimeContract2() {
        return giveTimeContract2;
    }

    public void setGiveTimeContract2(Integer giveTimeContract2) {
        this.giveTimeContract2 = giveTimeContract2;
    }

    public BigDecimal getMonthTimeBack2() {
        return monthTimeBack2;
    }

    public void setMonthTimeBack2(BigDecimal monthTimeBack2) {
        this.monthTimeBack2 = monthTimeBack2;
    }

    public Integer getGiveTrafficType1() {
        return giveTrafficType1;
    }

    public void setGiveTrafficType1(Integer giveTrafficType1) {
        this.giveTrafficType1 = giveTrafficType1;
    }

    public String getGiveTrafctypeCont1() {
        return giveTrafctypeCont1;
    }

    public void setGiveTrafctypeCont1(String giveTrafctypeCont1) {
        this.giveTrafctypeCont1 = giveTrafctypeCont1;
    }

    public BigDecimal getGiveTrafficAmount1() {
        return giveTrafficAmount1;
    }

    public void setGiveTrafficAmount1(BigDecimal giveTrafficAmount1) {
        this.giveTrafficAmount1 = giveTrafficAmount1;
    }

    public Integer getGiveTrafficContract1() {
        return giveTrafficContract1;
    }

    public void setGiveTrafficContract1(Integer giveTrafficContract1) {
        this.giveTrafficContract1 = giveTrafficContract1;
    }

    public BigDecimal getMonthTrafficBack1() {
        return monthTrafficBack1;
    }

    public void setMonthTrafficBack1(BigDecimal monthTrafficBack1) {
        this.monthTrafficBack1 = monthTrafficBack1;
    }

    public Integer getGiveTrafficType2() {
        return giveTrafficType2;
    }

    public void setGiveTrafficType2(Integer giveTrafficType2) {
        this.giveTrafficType2 = giveTrafficType2;
    }

    public String getGiveTrafctypeCont2() {
        return giveTrafctypeCont2;
    }

    public void setGiveTrafctypeCont2(String giveTrafctypeCont2) {
        this.giveTrafctypeCont2 = giveTrafctypeCont2;
    }

    public BigDecimal getGiveTrafficAmount2() {
        return giveTrafficAmount2;
    }

    public void setGiveTrafficAmount2(BigDecimal giveTrafficAmount2) {
        this.giveTrafficAmount2 = giveTrafficAmount2;
    }

    public Integer getGiveTrafficContract2() {
        return giveTrafficContract2;
    }

    public void setGiveTrafficContract2(Integer giveTrafficContract2) {
        this.giveTrafficContract2 = giveTrafficContract2;
    }

    public BigDecimal getMonthTrafficBack2() {
        return monthTrafficBack2;
    }

    public void setMonthTrafficBack2(BigDecimal monthTrafficBack2) {
        this.monthTrafficBack2 = monthTrafficBack2;
    }

    public Integer getGiveTrafficType3() {
        return giveTrafficType3;
    }

    public void setGiveTrafficType3(Integer giveTrafficType3) {
        this.giveTrafficType3 = giveTrafficType3;
    }

    public String getGiveTrafctypeCont3() {
        return giveTrafctypeCont3;
    }

    public void setGiveTrafctypeCont3(String giveTrafctypeCont3) {
        this.giveTrafctypeCont3 = giveTrafctypeCont3;
    }

    public BigDecimal getGiveTrafficAmount3() {
        return giveTrafficAmount3;
    }

    public void setGiveTrafficAmount3(BigDecimal giveTrafficAmount3) {
        this.giveTrafficAmount3 = giveTrafficAmount3;
    }

    public Integer getGiveTrafficContract3() {
        return giveTrafficContract3;
    }

    public void setGiveTrafficContract3(Integer giveTrafficContract3) {
        this.giveTrafficContract3 = giveTrafficContract3;
    }

    public BigDecimal getMonthTrafficBack3() {
        return monthTrafficBack3;
    }

    public void setMonthTrafficBack3(BigDecimal monthTrafficBack3) {
        this.monthTrafficBack3 = monthTrafficBack3;
    }

    public BigDecimal getGiveBill() {
        return giveBill;
    }

    public void setGiveBill(BigDecimal giveBill) {
        this.giveBill = giveBill;
    }

    public Integer getGiveBillContract() {
        return giveBillContract;
    }

    public void setGiveBillContract(Integer giveBillContract) {
        this.giveBillContract = giveBillContract;
    }

    public BigDecimal getGiveBillAmount() {
        return giveBillAmount;
    }

    public void setGiveBillAmount(BigDecimal giveBillAmount) {
        this.giveBillAmount = giveBillAmount;
    }

    public Integer getGiveBillPassbook() {
        return giveBillPassbook;
    }

    public void setGiveBillPassbook(Integer giveBillPassbook) {
        this.giveBillPassbook = giveBillPassbook;
    }

    public String getGiveBillpbCont() {
        return giveBillpbCont;
    }

    public void setGiveBillpbCont(String giveBillpbCont) {
        this.giveBillpbCont = giveBillpbCont;
    }

    public String getGiveElecoupNum() {
        return giveElecoupNum;
    }

    public void setGiveElecoupNum(String giveElecoupNum) {
        this.giveElecoupNum = giveElecoupNum;
    }

    public BigDecimal getGiveElecoup() {
        return giveElecoup;
    }

    public void setGiveElecoup(BigDecimal giveElecoup) {
        this.giveElecoup = giveElecoup;
    }

    public BigDecimal getGivePointPrice() {
        return givePointPrice;
    }

    public void setGivePointPrice(BigDecimal givePointPrice) {
        this.givePointPrice = givePointPrice;
    }

    public Integer getAatId() {
        return aatId;
    }

    public void setAatId(Integer aatId) {
        this.aatId = aatId;
    }

    public Integer getOnlineState() {
        return onlineState;
    }

    public void setOnlineState(Integer onlineState) {
        this.onlineState = onlineState;
    }

}
