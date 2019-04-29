package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
public class SysDataRoleDTO {
    private Integer dataRoleId;//主键
    private String name;//数据权限名称
    private Integer organizeId;//组织ID
    private String code;//数据权限编码
    private String notes;//备注
    private Integer opId;//创建人员
    private String createDate;//创建时间
    private Integer state;//状态：1-正常，0-注销
}
