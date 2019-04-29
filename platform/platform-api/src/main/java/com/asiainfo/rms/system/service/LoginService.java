package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.SysLoginInfoDTO;
import com.asiainfo.rms.system.dto.SysLoginUserInfoDTO;

import java.util.Map;

public interface LoginService {
    Map<Object, Object> ssoLogin(SysLoginInfoDTO loginInfoDTO);

    Map<Object, Object> oaLogin(SysLoginInfoDTO loginInfoDTO);

    void loginOut(Integer logId);

    SysLoginUserInfoDTO selectLoginUserInfo(Integer staffId);

    Map<Object, Object> getOrganizeInfo(Integer staffId);
}
