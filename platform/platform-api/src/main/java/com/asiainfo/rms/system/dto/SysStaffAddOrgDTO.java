package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
public class SysStaffAddOrgDTO {
	private Integer staffId;//员工ID
    private String code;//员工工号
    private String recentTime;//修改密码时间
    private String employeeName;//雇员名称
    private String billId;//手机号码
    private String email;//邮箱
    private String religion;//职责
    private Integer state;//状态 1:上锁，0:解锁
    private Integer lockFlag;//是否有锁 1:是 0:否
    private String notes;//备注
    private String ext1;//扩展字段1
    private String ext2;//扩展字段2
    private String ext3;//扩展字段3
    private Integer organizeId;//组织ID
    private String organizeName;//组织名字
}
