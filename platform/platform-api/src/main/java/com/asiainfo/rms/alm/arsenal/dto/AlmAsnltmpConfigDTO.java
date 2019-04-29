package com.asiainfo.rms.alm.arsenal.dto;

import lombok.Data;

@Data
public class AlmAsnltmpConfigDTO {
    private Integer aacId;//配置表主键

    private String tbName;//对象表名

    private String updateColumn;//需更新的字段名称

    private String tableRemark;//注释说明

    private Integer artType;//模版类型
}
