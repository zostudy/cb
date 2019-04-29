package com.asiainfo.rms.alm.demand.domain;

public class AlmReqtmpComprehensiveRepository {
    private Integer arcId;//综合类模板主键

    private String artName;//需求名称

    private String purpost;//需求主要目的

    private String predictDev;//预计发展

    private Integer artType;//模板类型，综合类

    private Integer artId;//需求模板主题表主键

    private String purpostCont;//需求主要目标内容

    private String autonymIdentify;//是否送在线公司做实名认证

    private String autonymIdentifyCont;//是否送在线公司做实名认证内容

    private String reqDetail;//详细需求说明

    private String otherContent;//其他说明

    private String reqCont;//详细需求说明文字

    private String artTopicTag;

    private String artTopicName;

    public String getArtTopicTag() {
        return artTopicTag;
    }

    public void setArtTopicTag(String artTopicTag) {
        this.artTopicTag = artTopicTag;
    }

    public String getArtTopicName() {
        return artTopicName;
    }

    public void setArtTopicName(String artTopicName) {
        this.artTopicName = artTopicName;
    }

    public Integer getArcId() {
        return arcId;
    }

    public void setArcId(Integer arcId) {
        this.arcId = arcId;
    }

    public String getArtName() {
        return artName;
    }

    public void setArtName(String artName) {
        this.artName = artName;
    }

    public String getPurpost() {
        return purpost;
    }

    public void setPurpost(String purpost) {
        this.purpost = purpost;
    }

    public String getPredictDev() {
        return predictDev;
    }

    public void setPredictDev(String predictDev) {
        this.predictDev = predictDev;
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

    public String getReqDetail() {
        return reqDetail;
    }

    public void setReqDetail(String reqDetail) {
        this.reqDetail = reqDetail;
    }

    public String getOtherContent() {
        return otherContent;
    }

    public void setOtherContent(String otherContent) {
        this.otherContent = otherContent;
    }

    public String getReqCont() {
        return reqCont;
    }

    public void setReqCont(String reqCont) {
        this.reqCont = reqCont;
    }
}
