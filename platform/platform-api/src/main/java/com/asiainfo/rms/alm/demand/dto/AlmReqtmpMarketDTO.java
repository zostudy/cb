package com.asiainfo.rms.alm.demand.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AlmReqtmpMarketDTO {

    private Integer armId;//营销模板主键

    private Integer artType;//模板类型，营销类

    private String marketName;//营销活动名称

    private String effectPlan;//预计成效

    private String purpost;//活动目的

    private String activateTimeStart;//活动时间开始

    private String activateTimeEnd;//活动时间结束

    private String acrivateType;//活动类型

    private String activateChannel;//参与渠道

    private String activateLimit;//活动限制

    private String effectWay;//生效方式

    private String invalidWay;//失效方式

    private String priorContent;//优先级

    private Integer artId;//需求模板主题表主键

    private String channelMark;//参与渠道说明

    private Integer marketResource;//营销资源

    private Integer feedbackResource;//回馈资源

    private String marketOrderno;//营销关联工单号

    private String feedbackOrderno;//回馈关联工单号

    private String marketBatchno;//营销关联批次号

    private String feedbackBatchno;//回馈关联批次号

    private String targetCustomer;//目标客户

    private String purpostCont;//需求目标内容

    private String acrivateTypeCont;//活动类型内容

    private String activateChannelCont;//参与渠道内容

    private String marketResourceCont;//营销资源内容

    private String feedbackResourceCont;//回馈资源内容

    private String marketContent;//活动内容

    private String billingShare;//结算分摊说明

    private String mutex;//互斥

    private String superposition;//叠加

    private String message;//短信提醒

    private String bills;//单据

    private String reportForm;//报表说明

    private String otherContent;//其他说明

    private String monitorDemond;//监控要求

    private String staffPerm;//渠道工号权限

    private String marketCont;//活动内容无格式

    private String packageAllo;//套餐分摊规则

    private String artTag;

    private String artName;
}
