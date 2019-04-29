package com.asiainfo.rms.alm.demand.dto;

import lombok.Data;

@Data
public class AlmReqtmpRewardCntDTO {

    private Integer contentId;//酬金规则ID

    private String projectType;//项目类型

    private String rewardName;//酬金/渠道名称

    private String issuePeriod;//核发周期

    private Integer arrId;//酬金类模版ID

    private String ruleValidity;//酬金规则有效期

    private String formula;//计算公式

    private String upperLimit;//上限标准

    private String issueCondition;//核发条件/其他说明

    private String reportColumn;//报表字段说明
}
