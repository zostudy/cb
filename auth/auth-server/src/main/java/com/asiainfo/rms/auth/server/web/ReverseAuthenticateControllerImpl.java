package com.asiainfo.rms.auth.server.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;


public class ReverseAuthenticateControllerImpl implements ReverseAuthenticateController {

	@Override
	public String ReverseAuthenticate(OAuth2AccessToken accessToken, HttpServletRequest request) {
		
		Map<String, Object> additional = accessToken.getAdditionalInformation();
		String time_stamp = (String)additional.get("time_stamp");
		return time_stamp;
	}

}
