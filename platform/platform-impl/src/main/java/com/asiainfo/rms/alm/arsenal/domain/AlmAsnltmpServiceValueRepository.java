package com.asiainfo.rms.alm.arsenal.domain;

public class AlmAsnltmpServiceValueRepository {
    private Integer asvId;//服务值表主键

    private Integer aatId;//模板主题主键

    private Integer artType;//模板类型

    private String aatTag;//需求编码

    private Integer objId;//对象主键

    private Integer defauleOption;//是否默认

    private Integer selectOption;//是否必选

    private Integer asId;//服务表主键

    private Integer serviceId;//服务ID

    private String serviceName;//服务名称

    private String serviceValue;//服务值

    private String operateType;//操作类型：C-新增，U-修改，D-删除

    public Integer getAsvId() {
        return asvId;
    }

    public void setAsvId(Integer asvId) {
        this.asvId = asvId;
    }

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

    public Integer getObjId() {
        return objId;
    }

    public void setObjId(Integer objId) {
        this.objId = objId;
    }

    public Integer getDefauleOption() {
        return defauleOption;
    }

    public void setDefauleOption(Integer defauleOption) {
        this.defauleOption = defauleOption;
    }

    public Integer getSelectOption() {
        return selectOption;
    }

    public void setSelectOption(Integer selectOption) {
        this.selectOption = selectOption;
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

    public String getServiceValue() {
        return serviceValue;
    }

    public void setServiceValue(String serviceValue) {
        this.serviceValue = serviceValue;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }
}
