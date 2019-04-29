package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
public class SysParamDTO {
    private String paramType;//参数类型
    private Integer paramId;//参数ID
    private String paramNo;//参数编号
    private String paramName;//参数名称
    private String paramDesc;//参数描述
    private Integer paramRelaId;//默认为 父关系 PARAM_ID
    private String paramValue;//参数值
    private Integer sortId;//参数排序，以sort_id的值的大小作为排次序。缺省值为0

}
