package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
public class SysStaffWorkingGroupDTO {
    private Integer relId;
    private Integer workGroupId;
    private Integer staffId;

    private String WorkGroupCode;
    private String WorkGroupName;

    private String employeeCode;//雇员名称
    private String employeeName;//雇员名称
    private String billId;//手机号码
    private String email;//邮箱

    private String organizeCode;
    private String organizeName;
}
