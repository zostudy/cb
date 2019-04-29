package com.asiainfo.rms.alm.arsenal.dto;

import lombok.Data;

@Data
public class AlmFreeFlowActivityDTO {
    private Long activityId;//主键ID

    private Long aatId;//模板ID

    private Long activityNo;//活动编码

    private String activityName;//活动名称

    private String startTime;//活动开始时间

    private String endTime;//活动结束时间

    private String flowTypeNo;//活动类型编码

    private String flowTypeName;//活动类型名称

    private String flowPriorityNo;

    private String flowPriorityName;

    private String validityTypeNo;

    private String validityTypeName;

    private String levelNo;

    private String levelName;

    private String ruleContent;

    private Short isWarn;

    private String noteContent;

    private String notes;

    private String ext1;

    private String ext2;

    private String ext3;
}
