package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
//登陆日志
public class SysLoginLogDTO {
    private Integer logId;//日志编号
    private String sessionId;//SESSION编号
    private String staffCode;//登陆员
    private String ip;//IP地址
    private String mac;//mac地址
    private String loginDate;//登陆时间
    private String logoutDate;//登出时间
    private String state;//状态 1：登陆中 0：登出
}
