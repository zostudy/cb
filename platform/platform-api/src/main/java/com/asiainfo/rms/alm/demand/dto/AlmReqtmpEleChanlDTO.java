package com.asiainfo.rms.alm.demand.dto;

import lombok.Data;

@Data
public class AlmReqtmpEleChanlDTO {

    private Integer areId;//电渠模板主键

    private String purpost;//需求目标

    private String funcWf;//功能流程描述

    private String implementReq;//实现要求

    private String interfaces;//接口说明

    private String reportForm;//报表说明

    private String monitorDemond;//监控要求

    private String otherContent;//其他说明

    private Integer artType;//模板类型，电渠类

    private Integer artId;//需求模板主题表主键

    private String funcwfCont;//功能流程描述内容

    private String implreqCont;//实现要求内容

    private String eleChannel;//电渠承载渠道

    private String eleChannelCont;//电渠承载渠道内容

    private String monitorReq;//监控要求

    private String purpostCont;//需求目标内容

    private String insertCode;//插码要求

    private String artTag;

    private String artName;
}
