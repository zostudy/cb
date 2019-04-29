package com.asiainfo.rms.system.dto;

import lombok.Data;

@Data
public class SysLoginInfoDTO {
    public static final String OA_LOGIN = "oaLogin";
    public static final String SSO_LOGIN = "ssoLogin";

    private String code;
    private String passWord;
    private String ip;
    private String mac;
    private String sessionId;
    private String verificationCode;
    private String state;
    private String validKey;
    private String loginType;   // OA：OA系统登录，SSO：单点登录
    private Integer orderId;
}
