package com.asiainfo.rms.system.web;

import com.asiainfo.rms.system.dto.SysLoginInfoDTO;
import com.asiainfo.rms.system.dto.SysLoginUserInfoDTO;
import com.asiainfo.rms.system.dto.SysOrganizeDTO;
import com.asiainfo.rms.system.service.LoginService;
import com.asiainfo.rms.system.service.OrganizeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Transactional
public class LoginControllerImpl implements LoginController {
	@Autowired
    private OrganizeService organizeService;
    private final LoginService loginService;

    public LoginControllerImpl(@RequestBody LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public Map login(@RequestBody SysLoginInfoDTO loginInfoDTO) {
        if(SysLoginInfoDTO.SSO_LOGIN.equalsIgnoreCase(loginInfoDTO.getLoginType())) {  // 单点登录认证
            return loginService.ssoLogin(loginInfoDTO);
        } else {
            return loginService.oaLogin(loginInfoDTO);
        }
    }

    @Override
    public void loginOut(@RequestParam("log_id") Integer logId) {
        loginService.loginOut(logId);
    }

    @Override
    public SysLoginUserInfoDTO selectLoginUserInfo(@RequestParam("staff_id") Integer staffId) {
        return loginService.selectLoginUserInfo(staffId);
    }

    @Override
    public Map getOrganizeInfo(@RequestParam("staff_id") Integer staffId) {
    	Map map = loginService.getOrganizeInfo(staffId);
    	SysOrganizeDTO sysOrganizeDTO = organizeService.selectOrganizeInfo(2, Integer.valueOf(map.get("organizeId").toString()),  null, null, null);
    	if (Integer.valueOf(5718).compareTo(sysOrganizeDTO.getOrganizeId()) != 0) {
    		map.put("organizeType", 1);
    		map.put("organizeOtherId", sysOrganizeDTO.getOrganizeId());
    		map.put("organizeOtherName", sysOrganizeDTO.getOrganizeName());
    	}
    	if (Integer.valueOf(5718).compareTo(sysOrganizeDTO.getOrganizeId()) == 0){
    		sysOrganizeDTO = organizeService.selectOrganizeInfo(3, Integer.valueOf(map.get("organizeId").toString()),  null, null, null);
    		if (Integer.valueOf(5759).compareTo(sysOrganizeDTO.getOrganizeId()) == 0) {
    			map.put("organizeType", 3);
    			map.put("organizeOtherId", sysOrganizeDTO.getOrganizeId());
    			map.put("organizeOtherName", sysOrganizeDTO.getOrganizeName());
    		} else {
    			map.put("organizeType", 2);
    			map.put("organizeOtherId", sysOrganizeDTO.getOrganizeId());
    			map.put("organizeOtherName", sysOrganizeDTO.getOrganizeName());
    		}
    	}
    	return map;
    }
}
