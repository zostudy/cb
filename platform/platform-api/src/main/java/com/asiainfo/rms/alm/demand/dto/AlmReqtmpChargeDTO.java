package com.asiainfo.rms.alm.demand.dto;

import lombok.Data;

@Data
public class AlmReqtmpChargeDTO {

    private Integer archId;//资费类模板主键

    private String activateTimeStart;//活动开始时间

    private String activateTimeEnd;//活动结束时间

    private String purpost;//需求主要目的

    private String effectPlan;//预计成效

    private String chargeLimit;//资费办理限制

    private String chargeOpen;//资费开放区域

    private String chargeValid;//资费有效期

    private String chargeCollect;//月费收取方式

    private String effectWay;//资费生效方式

    private String invalidWay;//资费失效方式

    private Integer artType;//模板类型，资费类

    private Integer artId;//需求模板主题表主键

    private String chargeName;//资费名称

    private String purpostCont;//需求主要目标内容

    private String chargeContent;//资费内容说明

    private String chargeOver;//超出本资费说明

    private String chargeChannel;//资费办理渠道

    private String channelWay;//各渠道办理方式

    private String mutex;//互斥说明

    private String accounts;//账务说明

    private String monitorDemond;//监控要求

    private String message;//下行短信

    private String bills;//单据

    private String reportForm;//报表需求

    private String otherContent;//其他说明

    private String chargeCont;//资费内容说明文字

    private String packageAllo;//套餐分摊规则

    private String artTag;

    private String artName;
}
