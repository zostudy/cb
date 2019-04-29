package com.asiainfo.rms.auth.server.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping("/system")
public interface ReverseAuthenticateController {
	/**
     * 反向认证有效性校验接口
     *
     * @param staffDTO
     * @return
     */
    @RequestMapping(value = "/reverseAuthenticate", method = RequestMethod.GET)
    String ReverseAuthenticate(OAuth2AccessToken accessToken, HttpServletRequest request);
}
