package com.asiainfo.rms.auth.server.sso;

import com.asiainfo.rms.system.dto.SysLoginInfoDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
public class SSOLoginAspect {
	@Pointcut(value="execution(public * org.springframework.security.oauth2.provider.endpoint.TokenEndpoint.postAccessToken(..))")
	public void ssoLoginAspect(){}

	@Before(value="ssoLoginAspect()")
	public void beforeOauthToken(JoinPoint point) {
		Object[] args = point.getArgs();
		Map<String, String> parameter = (Map<String, String>) args[1];
		if(!SysLoginInfoDTO.SSO_LOGIN.equals(parameter.get("loginType"))) {
			// 如果登录类型不是单点登录，所有参数都必须正确
			return ;
		}
		// 登录类型是单点登录，访问类型为password，账户密码必须设置
		// 否则会影响/oauth/token认证错误
		parameter.put("grant_type", "password");
		//parameter.put("username", "_sso");
		parameter.put("password", "_sso");
		parameter.putIfAbsent("scope", "read");
	}
}