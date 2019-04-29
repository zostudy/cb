package com.asiainfo.rms.alm.arsenal.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AlmAsnltmpChgeExtendDTO {
    private Integer aceId;//资费类模板附表主键（幸福卡）

    private Integer artType;//模板类型

    private Integer aatId;//模板主表主键

    private String benefitName;//优惠名称

    private String benefitDscr;//优惠描述

    private Integer inTrafficType1;//套餐内流量类别1

    private String inTrafficTypeCont1;//套餐内流量类别1内容

    private BigDecimal inTrafficAmount1;//套餐内流量类别1额度（M）

    private Integer inTrafficTypePrio1;//套餐内流量类别1优先级

    private Integer inTimeType1;//套餐内时长类别1

    private String inTimeTypeCont1;//套餐内时长类别1内容

    private BigDecimal inTimeAmount1;//套餐内时长类别1额度（分钟）

    private Integer inShortMsg;//套餐内短信

    private Integer inMediaMsg;//套餐内彩信

    private String outCalling;//套餐外主叫

    private String outCalled;//套餐外被叫

    private String outTraffic;//套餐外流量

    private Integer outShortMsg;//套餐外短信

    private Integer outMediaMsg;//套餐外彩信

    private Integer subjectCode1;//科目1编码

    private String subjectCodeCont1;//科目1编码内容

    private String shareRatio1;//科目1分摊比例

    private Integer subjectCode2;//科目2编码

    private String subjectCodeCont2;//科目2编码内容

    private String shareRatio2;//科目2分摊比例

    private Integer subjectCode3;//科目3编码

    private String subjectCodeCont3;//科目3编码内容

    private String shareRatio3;//科目3分摊比例

    private Integer onlineState;//上线状态0为默认，1为成功，-1为失败

    private Integer firstChargeWay;//套餐月费首月收费方式

    private String firstChargeWayCont;//套餐月费首月收费方式内容

    private Integer secndChargeWay;//次月月费收费方式

    private String secndChargeWayCont;//次月月费收费方式内容

    private Integer rollinWay;//套餐转入规则

    private String rollinWayCont;//套餐转入规则内容

    private Integer rolloutWay;//套餐转出规则

    private String rolloutWayCont;//套餐转出规则内容

    private Integer packagePriod;//套餐优先级

    private String packagePriodCont;//套餐优先级内容

    private Integer acId;//资费类模板附表主键（幸福卡）
}
