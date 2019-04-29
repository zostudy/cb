package com.asiainfo.rms.alm.arsenal.domain;

public class AlmArsenalServiceRepository {
    private Integer asId; //武器库服务表组件

    private Integer serviceId;//服务id

    private String serviceName;//服务名称

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
}
