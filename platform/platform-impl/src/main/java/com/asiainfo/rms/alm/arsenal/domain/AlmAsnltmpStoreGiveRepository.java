package com.asiainfo.rms.alm.arsenal.domain;

import java.math.BigDecimal;
import java.util.Date;

public class AlmAsnltmpStoreGiveRepository {
    private Integer aasId;//存送主表主键

    private String marketPrdctName;//营销产品名称

    private String cityNum;//地市编码

    private String marketPrdctDscr;//营销产品描述

    private Date startTime;//活动开始时间

    private Date endTime;//活动结束时间

    private Date createTime;//创建时间

    private String marketPackName;//营销包名称

    private String marketPackDscr;//营销包描述

    private Integer contractPeriod;//合约期

    private Integer effecWay;//活动生效方式

    private BigDecimal preBill;//预存话费档次

    private BigDecimal monthBill;//分月话费

    private Integer monthPassbook;//分月话费存折

    private BigDecimal freeBill;//自由话费

    private Integer freePassbook;//自由话费存折

    private BigDecimal monthArriv;//预存话费分月到账

    private BigDecimal baseConsump;//保底消费

    private Integer baseConspCount;//保底消费账目编码

    private Integer prioLevel;//优先级设定

    private String benifitEffort;//优惠力度

    private String effecWayCont;//活动生效方式内容

    private String monthPassbookCont;//分月话费存折内容

    private String freePassbookCont;//自由话费存折内容

    private String baseConspCountCont;//保底消费账目编码内容

    private String prioLevelCont;//优先级设定内容

    private Integer artType;//武器库模板类型

    private Integer aatId;//武器库模板主键

    private String cityNumCont;//地市编码内容

    private Integer onlineState;//上线状态0为默认，1为成功，-1为失败

    public Integer getAasId() {
        return aasId;
    }

    public void setAasId(Integer aasId) {
        this.aasId = aasId;
    }

    public String getMarketPrdctName() {
        return marketPrdctName;
    }

    public void setMarketPrdctName(String marketPrdctName) {
        this.marketPrdctName = marketPrdctName;
    }

    public String getCityNum() {
        return cityNum;
    }

    public void setCityNum(String cityNum) {
        this.cityNum = cityNum;
    }

    public String getMarketPrdctDscr() {
        return marketPrdctDscr;
    }

    public void setMarketPrdctDscr(String marketPrdctDscr) {
        this.marketPrdctDscr = marketPrdctDscr;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMarketPackName() {
        return marketPackName;
    }

    public void setMarketPackName(String marketPackName) {
        this.marketPackName = marketPackName;
    }

    public String getMarketPackDscr() {
        return marketPackDscr;
    }

    public void setMarketPackDscr(String marketPackDscr) {
        this.marketPackDscr = marketPackDscr;
    }

    public Integer getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(Integer contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public Integer getEffecWay() {
        return effecWay;
    }

    public void setEffecWay(Integer effecWay) {
        this.effecWay = effecWay;
    }

    public BigDecimal getPreBill() {
        return preBill;
    }

    public void setPreBill(BigDecimal preBill) {
        this.preBill = preBill;
    }

    public BigDecimal getMonthBill() {
        return monthBill;
    }

    public void setMonthBill(BigDecimal monthBill) {
        this.monthBill = monthBill;
    }

    public Integer getMonthPassbook() {
        return monthPassbook;
    }

    public void setMonthPassbook(Integer monthPassbook) {
        this.monthPassbook = monthPassbook;
    }

    public BigDecimal getFreeBill() {
        return freeBill;
    }

    public void setFreeBill(BigDecimal freeBill) {
        this.freeBill = freeBill;
    }

    public Integer getFreePassbook() {
        return freePassbook;
    }

    public void setFreePassbook(Integer freePassbook) {
        this.freePassbook = freePassbook;
    }

    public BigDecimal getMonthArriv() {
        return monthArriv;
    }

    public void setMonthArriv(BigDecimal monthArriv) {
        this.monthArriv = monthArriv;
    }

    public BigDecimal getBaseConsump() {
        return baseConsump;
    }

    public void setBaseConsump(BigDecimal baseConsump) {
        this.baseConsump = baseConsump;
    }

    public Integer getBaseConspCount() {
        return baseConspCount;
    }

    public void setBaseConspCount(Integer baseConspCount) {
        this.baseConspCount = baseConspCount;
    }

    public Integer getPrioLevel() {
        return prioLevel;
    }

    public void setPrioLevel(Integer prioLevel) {
        this.prioLevel = prioLevel;
    }

    public String getBenifitEffort() {
        return benifitEffort;
    }

    public void setBenifitEffort(String benifitEffort) {
        this.benifitEffort = benifitEffort;
    }

    public String getEffecWayCont() {
        return effecWayCont;
    }

    public void setEffecWayCont(String effecWayCont) {
        this.effecWayCont = effecWayCont;
    }

    public String getMonthPassbookCont() {
        return monthPassbookCont;
    }

    public void setMonthPassbookCont(String monthPassbookCont) {
        this.monthPassbookCont = monthPassbookCont;
    }

    public String getFreePassbookCont() {
        return freePassbookCont;
    }

    public void setFreePassbookCont(String freePassbookCont) {
        this.freePassbookCont = freePassbookCont;
    }

    public String getBaseConspCountCont() {
        return baseConspCountCont;
    }

    public void setBaseConspCountCont(String baseConspCountCont) {
        this.baseConspCountCont = baseConspCountCont;
    }

    public String getPrioLevelCont() {
        return prioLevelCont;
    }

    public void setPrioLevelCont(String prioLevelCont) {
        this.prioLevelCont = prioLevelCont;
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

    public String getCityNumCont() {
        return cityNumCont;
    }

    public void setCityNumCont(String cityNumCont) {
        this.cityNumCont = cityNumCont;
    }

    public Integer getOnlineState() {
        return onlineState;
    }

    public void setOnlineState(Integer onlineState) {
        this.onlineState = onlineState;
    }
}
