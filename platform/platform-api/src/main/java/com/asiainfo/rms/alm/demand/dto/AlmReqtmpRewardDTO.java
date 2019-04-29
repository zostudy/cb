package com.asiainfo.rms.alm.demand.dto;

import lombok.Data;

@Data
public class AlmReqtmpRewardDTO {

    private Integer arrId;//酬金模板主键

    private String reqRewardType;//需求类型

    private String reqTypeDscr;//需求类型描述

    private Integer artType;//模板类型，酬金类

    private Integer artId;//需求模板主题表主键

    private String reqRewardTypeCont;//需求类型内容

    private String reissue;//补发

    private String garnishment;//扣发

    private String adjust;//调整

    private String imports;//导入

    private String export;//导出

    private String otherContent;//其他说明

    private String artTag;

    private String artName;
}
