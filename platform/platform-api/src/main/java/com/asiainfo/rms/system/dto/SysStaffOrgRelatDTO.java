package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
//人员组织关系表
public class SysStaffOrgRelatDTO {
    private Integer staffOrgRelatId;//关系ID
    private Integer organizeId;//组织ID
    private String organizeName;//组织名称
    private String code;//组织编码
    private Integer staffId;//人员ID
    private Integer state;//状态 1:正常 0:删除
    private String notes;//备注
    private String createTime;//创建时间
    private String ext1;//扩展字段1
    private String ext2;//扩展字段2
    private String ext3;//扩展字段3
}
