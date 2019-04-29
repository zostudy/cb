package com.asiainfo.rms.alm.demand.dto;

import lombok.Data;

@Data
public class AlmReqtmpFunctionDTO {

    private Integer arfId;//功能类模板主键

    private String purpost;//需求主要目的

    private Integer artType;//板类型-功能类

    private Integer artId;//需求模板主题表主键

    private String funcName;//功能名称

    private String purpostCont;//需求主要目标内容

    private String autonymIdentify;//是否送在线公司做实名认证

    private String autonymIdentifyCont;//是否送在线公司做实名认证内容

    private String funcWf;//新增/优化业务功能描述

    private String implementReq;//新增/优化界面要求描述

    private String message;//短信要求

    private String bills;//票据要求（账详单/免填单）

    private String accounts;//计费帐务要求

    private String permission;//权限要求

    private String onlineReq;//上线要求

    private String busiRelate;//关联业务

    private String complement;//配合及补充

    private String otherContent;//其他说明

    private String funcwfCont;//新增/优化业务功能描述文字

    private String implementCont;//新增/优化界面要求描述文字

    private String dataUpdate;//存量数据变更规则

    private String artTag;

    private String artName;

}
