package com.asiainfo.rms.alm.arsenal.domain;

public class AlmAsnltmpServiceRelatRepository {
    private Integer asrId;//武器模板和服务关系主键

    private Integer artType;//武器库模板类型

    private Integer asId;//服务主键

    private Integer asvId;

    private Integer serviceId;//服务id

    private String serviceName;//服务名称

    private String artName;//类型名称

    private Integer aatId;//模板主题主键

    private String aatTag;//需求编码

    private Integer objId;//对象主键

    private String serviceValue;//服务值

    private Integer selectOption;

    private Integer defauleOption;

    public Integer getAsrId() {
        return asrId;
    }

    public void setAsrId(Integer asrId) {
        this.asrId = asrId;
    }

    public Integer getArtType() {
        return artType;
    }

    public void setArtType(Integer artType) {
        this.artType = artType;
    }

    public Integer getAsId() {
        return asId;
    }

    public void setAsId(Integer asId) {
        this.asId = asId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getArtName() {
        return artName;
    }

    public void setArtName(String artName) {
        this.artName = artName;
    }

    public Integer getAatId() {
        return aatId;
    }

    public void setAatId(Integer aatId) {
        this.aatId = aatId;
    }

    public String getAatTag() {
        return aatTag;
    }

    public void setAatTag(String aatTag) {
        this.aatTag = aatTag;
    }

    public Integer getObjId() {
        return objId;
    }

    public void setObjId(Integer objId) {
        this.objId = objId;
    }

    public String getServiceValue() {
        return serviceValue;
    }

    public void setServiceValue(String serviceValue) {
        this.serviceValue = serviceValue;
    }

    public Integer getAsvId() {
        return asvId;
    }

    public void setAsvId(Integer asvId) {
        this.asvId = asvId;
    }

    public Integer getSelectOption() {
        return selectOption;
    }

    public void setSelectOption(Integer selectOption) {
        this.selectOption = selectOption;
    }

    public Integer getDefauleOption() {
        return defauleOption;
    }

    public void setDefauleOption(Integer defauleOption) {
        this.defauleOption = defauleOption;
    }
}
