package com.asiainfo.rms.alm.arsenal.dto;

import lombok.Data;

@Data
public class AlmAsnltmpServiceValueDTO {
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
}
