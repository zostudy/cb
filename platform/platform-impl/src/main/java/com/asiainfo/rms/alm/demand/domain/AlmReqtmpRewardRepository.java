package com.asiainfo.rms.alm.demand.domain;

public class AlmReqtmpRewardRepository {
    private Integer arrId;

    private String reqRewardType;

    private String reqTypeDscr;

    private Integer artType;

    private Integer artId;

    private String reqRewardTypeCont;

    private String reissue;

    private String garnishment;

    private String adjust;

    private String imports;

    private String export;

    private String otherContent;

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

    public Integer getArrId() {
        return arrId;
    }

    public void setArrId(Integer arrId) {
        this.arrId = arrId;
    }

    public String getReqRewardType() {
        return reqRewardType;
    }

    public void setReqRewardType(String reqRewardType) {
        this.reqRewardType = reqRewardType;
    }

    public String getReqTypeDscr() {
        return reqTypeDscr;
    }

    public void setReqTypeDscr(String reqTypeDscr) {
        this.reqTypeDscr = reqTypeDscr;
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

    public String getReqRewardTypeCont() {
        return reqRewardTypeCont;
    }

    public void setReqRewardTypeCont(String reqRewardTypeCont) {
        this.reqRewardTypeCont = reqRewardTypeCont;
    }

    public String getReissue() {
        return reissue;
    }

    public void setReissue(String reissue) {
        this.reissue = reissue;
    }

    public String getGarnishment() {
        return garnishment;
    }

    public void setGarnishment(String garnishment) {
        this.garnishment = garnishment;
    }

    public String getAdjust() {
        return adjust;
    }

    public void setAdjust(String adjust) {
        this.adjust = adjust;
    }

    public String getImports() {
        return imports;
    }

    public void setImports(String imports) {
        this.imports = imports;
    }

    public String getExport() {
        return export;
    }

    public void setExport(String export) {
        this.export = export;
    }

    public String getOtherContent() {
        return otherContent;
    }

    public void setOtherContent(String otherContent) {
        this.otherContent = otherContent;
    }
}
