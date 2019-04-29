package com.asiainfo.rms.alm.arsenal.dto;

import lombok.Data;

@Data
public class AlmAsnltmpTopicDTO {

    private Integer aatId;//武器库模板主键

    private Integer artType;//武器库模板类型

    private String aatTag;//需求编码

    private String aatName;//需求名称

    private String aatRegion;//申请单位

    private Integer aatDepart;//申请部门

    private Integer submitStaffId;//提出人id

    private String submitStaffName;//提出人名称

    private String submitStaffPhone;//提出人电话

    private Integer urgentLevel;//紧急程度

    private String askOnlineTime;//要求上线时间

    private Integer relizeMethod;//实现方式

    private Integer targetCust;//目标客户

    private String reqTarget;//需求目标

    private String dealChannel;//办理渠道

    private String joinWay;//参与方式

    private String joinLimit;//参与限制

    private String balanceExp;//结算分摊说明

    private String mutexExp;//互斥说明

    private String overlyExp;//叠加说明

    private String bindExp;//捆绑优惠说明

    private String prioExp;//优先级说明

    private String otherExp;//其他说明

    private String orderMsg;//订购短信

    private String updateMsg;//更新短信

    private String freeFill;//免填单

    private String accountDetail;//帐详单

    private String busiReport;//经分报表

    private String eleShow;//电渠展示

    private String authExp;//权限说明

    private String aatRegionCont;//申请单位内容

    private String aatDepartCont;//申请部门内容

    private String urgentLevelCont;//紧急程度内容

    private String relizeMethodCont;//实现方式内容

    private String targetCustCont;//目标客户内容

    private String reqTargetCont;//需求目标内容

    private String dealChannelCont;//办理渠道内容

    private String createTime;//创建时间

    private String opinion;//厂商意见

    private Integer onlineState;//上线状态0为默认，1为成功，-1为失败

    private String sendTime;//发送运营平台时间

    private String stateBackTime;//运营回参时间
}
