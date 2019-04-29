package com.asiainfo.rms.alm.demand.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AlmReqtmpTopicDTO {
    private Integer artId;//需求模板主键

    private String artTag;//需求编号（总编号）

    private String artName;//需求名称

    private Integer artRegion;//申请单位

    private Integer artDepart;//申请部门

    private Integer submitStaffId;//申请人员id

    private String submitStaffName;//申请人员名称

    private String submitStaffPhone;//申请人员电话

    private Integer urgentLevel;//紧急程度

    private Integer uploadBusipag;//是否在快速业务办理界面上载

    private Integer relizeMethod;//需求实现方式

    private String askOnlineTime;//要求上线时间

    private Integer artType;//模板类型

    private Integer templateId;//模板内容主键

    private String createTime;//创建时间

    private String opinion;//需求确定意见

    private String artRegionCont;//申请单位内容

    private String artDepartCont;//申请部门内容

    private String urgentLevelCont;//紧急程度内容

    private String uploadBusipagCont;//在快速业务办理界面上载内容

    private String relizeMethodCont;//需求实现方式内容

    private Integer similarMark;//相似度计算标签，已记算过
}
