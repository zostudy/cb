package com.asiainfo.rms.alm.arsenal.domain;

public class AlmReqtmpConfigRepository {
    private Integer id;//模板地址配置表主键

    private Integer artType;//模板类型

    private String artName;//模板名称

    private String artUrl;//模板地址

    private String resultWay;//single /all

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArtType() {
        return artType;
    }

    public void setArtType(Integer artType) {
        this.artType = artType;
    }

    public String getArtName() {
        return artName;
    }

    public void setArtName(String artName) {
        this.artName = artName;
    }

    public String getArtUrl() {
        return artUrl;
    }

    public void setArtUrl(String artUrl) {
        this.artUrl = artUrl;
    }

    public String getResultWay() {
        return resultWay;
    }

    public void setResultWay(String resultWay) {
        this.resultWay = resultWay;
    }
}

