package com.asiainfo.rms.system.dto;

import lombok.Data;

import java.util.List;

@Data
public class SysLoginUserInfoDTO {
    private Integer staffId;//员工ID
    private String code;//员工工号
    private String employeeName;//雇员名称
    private String billId;//手机号码
    private String email;//邮箱
    private String religion;//职责
    private Integer state;//状态 1:上锁，0:解锁
    private Integer organizeId;//组织ID
    private String organizeName;//组织名称
    private Integer logId;//日志编号
    private String flag;//是否地市分公司
    private String account4A; //4A主账号
    private	String accountCrm; 	//CRM从账号
    private String accountBoss; //BOSS从账号
    private List<SysFunctionDTO> functionDTO;
}
