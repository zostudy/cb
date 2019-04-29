package com.asiainfo.rms.alm.arsenal.domain;

import java.math.BigDecimal;
import java.util.Date;

public class AlmAsnltmpChargeRepository {
    private Integer acId;//主键ID

    private String prdctName;//产品名称

    private String prdctDscr;//产品描述

    private Integer prdctBrand;//产品品牌

    private BigDecimal cardCost;//卡费（单位为分）

    private BigDecimal firstBill;//首次预存话费金额（单位为分）

    private Integer firstPassbook;//首次预存话费存折

    private String firstPbCont;//首次预存话费存折内容

    private String consultPrdct;//继承可选优惠包参照产品（6位）

    private Integer artType;//武器库模板类型

    private Integer aatId;//武器库模板主键

    private Integer onlineState;//上线状态0为默认，1为成功，-1为失败

    private Date createTime;//创建时间

    private String prdctBrandCont;//产品品牌内容

    public Integer getAcId() {
        return acId;
    }

    public void setAcId(Integer acId) {
        this.acId = acId;
    }

    public String getPrdctName() {
        return prdctName;
    }

    public void setPrdctName(String prdctName) {
        this.prdctName = prdctName;
    }

    public String getPrdctDscr() {
        return prdctDscr;
    }

    public void setPrdctDscr(String prdctDscr) {
        this.prdctDscr = prdctDscr;
    }

    public Integer getPrdctBrand() {
        return prdctBrand;
    }

    public void setPrdctBrand(Integer prdctBrand) {
        this.prdctBrand = prdctBrand;
    }

    public BigDecimal getCardCost() {
        return cardCost;
    }

    public void setCardCost(BigDecimal cardCost) {
        this.cardCost = cardCost;
    }

    public BigDecimal getFirstBill() {
        return firstBill;
    }

    public void setFirstBill(BigDecimal firstBill) {
        this.firstBill = firstBill;
    }

    public Integer getFirstPassbook() {
        return firstPassbook;
    }

    public void setFirstPassbook(Integer firstPassbook) {
        this.firstPassbook = firstPassbook;
    }

    public String getFirstPbCont() {
        return firstPbCont;
    }

    public void setFirstPbCont(String firstPbCont) {
        this.firstPbCont = firstPbCont;
    }

    public String getConsultPrdct() {
        return consultPrdct;
    }

    public void setConsultPrdct(String consultPrdct) {
        this.consultPrdct = consultPrdct;
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

    public Integer getOnlineState() {
        return onlineState;
    }

    public void setOnlineState(Integer onlineState) {
        this.onlineState = onlineState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPrdctBrandCont() {
        return prdctBrandCont;
    }

    public void setPrdctBrandCont(String prdctBrandCont) {
        this.prdctBrandCont = prdctBrandCont;
    }
}
