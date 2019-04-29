package com.asiainfo.rms.alm.demand.dto;

import lombok.Data;

@Data
public class AlmReqtmpComprehensiveDTO {
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
}
