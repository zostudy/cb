package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
//组织机构表
public class SysOrganizeDTO {
    private Integer organizeId;//组织ID

    private Integer parentOrganizeId;//父组织ID

    private String organizeName;//组织名称

    private String code;//组织编码

    private String parentCode;//父组织编码

    private Integer orgType;//组织类型

    private String notes;//备注

    private Integer state;//状态 1:有效 0：删除

    private String createDate;//创建时间

    private String ext1;//扩展字段1

    private String ext2;//扩展字段2

    private String ext3;//扩展字段3

    private Integer childrenCount;
}
