package com.asiainfo.rms.alm.arsenal.dto;

import lombok.Data;

@Data
public class AlmReqtmpConfigDTO {
    private Integer id;//模板地址配置表主键

    private Integer artType;//模板类型

    private String artName;//模板名称

    private String artUrl;//模板地址

    private String resultWay;//single /all
}
