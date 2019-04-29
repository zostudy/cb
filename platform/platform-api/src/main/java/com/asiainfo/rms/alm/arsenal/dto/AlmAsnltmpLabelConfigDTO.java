package com.asiainfo.rms.alm.arsenal.dto;

import lombok.Data;

@Data
public class AlmAsnltmpLabelConfigDTO {
    private Integer lmId;//标签信息id

    private String labelName;//标签名称

    private Integer artType;//所属模板类型

    private String createTime;//创建时间

    private Integer createPersonId;//创建人id

    private String createPersonName;//创建人名称

    private Integer useTimes;//使用次数

    private Integer queryType;//查询类型

    private Integer exportTag;//导出标签
}
