package com.asiainfo.rms.system.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.asiainfo.rms.system.dto.ReverseAuthenticateDTO;

@RequestMapping("/system")
public interface ReverseAuthenticateController {
	/**
     * 调用CRM页面时，存储反向认证信息接口
     *
     * @param ReverseAuthenticateDTO
     * @return
     */
    @RequestMapping(value = "/reverse_authenticate_token_save", method = RequestMethod.POST)
    ReverseAuthenticateDTO reverseAuthenticateTokenSave(@RequestBody ReverseAuthenticateDTO reverseAuthenticateDTO);
    
    /**
     * 调用CRM页面时，反向认证验证token有效性接口
     *
     * @param String
     * @return
     */
    @RequestMapping(value = "/reverse_authenticate_token_check", method = RequestMethod.POST)
    public void reverseAuthenticateTokenCheck(HttpServletRequest request,HttpServletResponse response);
}
