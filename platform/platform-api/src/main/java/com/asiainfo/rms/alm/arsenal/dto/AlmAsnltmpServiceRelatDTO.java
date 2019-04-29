package com.asiainfo.rms.alm.arsenal.dto;

import lombok.Data;

@Data
public class AlmAsnltmpServiceRelatDTO {
    private Integer asrId;//武器模板和服务关系主键

    private Integer artType;//武器库模板类型

    private Integer asId;//服务主键

    private Integer serviceId;//服务id

    private String serviceName;//服务名称

    private String artName;//类型名称

    private Integer aatId;//模板主题主键

    private String aatTag;//需求编码

    private Integer objId;//对象主键

    private String serviceValue;//服务值

    private Integer asvId;

    private Integer selectOption;

    private Integer defauleOption;
}
