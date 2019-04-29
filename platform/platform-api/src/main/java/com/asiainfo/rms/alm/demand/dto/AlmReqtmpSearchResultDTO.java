package com.asiainfo.rms.alm.demand.dto;

import lombok.Data;

@Data
public class AlmReqtmpSearchResultDTO{
    private Integer art_id;//需求模板主键

    private String art_tag;//需求编号（总编号）

    private String art_name;//需求名称

    private Integer art_region;//申请单位

    private Integer art_depart;//申请部门

    private Integer submit_staff_d;//申请人员id

    private String submit_staff_name;//申请人员名称

    private String submit_staff_phone;//申请人员电话

    private Integer urgent_level;//紧急程度

    private Integer upload_busipag;//是否在快速业务办理界面上载

    private Integer relize_method;//需求实现方式

    private String ask_online_time;//要求上线时间

    private Integer art_type;//模板类型

    private Integer template_id;//模板内容主键

    private String create_time;//创建时间

    private String opinion;//需求确定意见

    private String artRegion_cont;//申请单位内容

    private String artDepart_cont;//申请部门内容

    private String urgent_level_cont;//紧急程度内容

    private String upload_busipag_cont;//在快速业务办理界面上载内容

    private String relize_method_cont;//需求实现方式内容

    private Integer similar_mark;//相似度计算标签，已记算过

    private String content;//模板内容
}
