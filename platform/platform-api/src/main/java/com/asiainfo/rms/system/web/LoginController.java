package com.asiainfo.rms.system.web;

import com.asiainfo.rms.system.dto.SysLoginInfoDTO;
import com.asiainfo.rms.system.dto.SysLoginUserInfoDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequestMapping("/system")
public interface LoginController {

    /**
     * 登陆
     *
     * @param loginInfoDTO
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Map login(@RequestBody SysLoginInfoDTO loginInfoDTO);

    /**
     * 登出
     *
     * @param logId
     */
    @RequestMapping(value = "/loginout", method = RequestMethod.POST)
    void loginOut(@RequestParam("log_id") Integer logId);

    /**
     * 登陆后查询用户信息
     * @param staffId
     * @return
     */
    @RequestMapping(value = "/login/info",method = RequestMethod.GET)
    SysLoginUserInfoDTO selectLoginUserInfo(@RequestParam("staff_id") Integer staffId);


    /**
     *
     * 获取级联组织机构
     * @param staffId
     * @return
     */
    @RequestMapping(value = "/login/getOrganizeInfo", method = RequestMethod.GET)
    Map getOrganizeInfo(@RequestParam("staff_id") Integer staffId);
}
