package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
//员工角色权限表
public class SysStaffRoleAuthorDTO {
    private Integer roleAuthorId;//主键
    private Integer roleId;//内部编码
    private Integer staffId;//员工主键
    private String notes;//备注
    private Integer state;//状态 1:正常0:注销
    private String createTime;//创建时间
    private String ext1;//扩展字段1
    private String ext2;//扩展字段2
    private String ext3;//扩展字段3
    private String operateType;//操作符：C-新增，U-修改，D-删除
}
