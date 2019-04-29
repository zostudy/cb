package com.asiainfo.rms.auth.server.sso;

import com.mdcl.xjmc.sso.SSOToken;
import com.mdcl.xjmc.sso.SSOTokenManager;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class SSOTokenUtils {
	/**
	 * 校验单点登录token是否有效并获取登录账户
	 * @param request HttpServletRequest
	 * @return 登录账户
	 */
	private static String getUserNameFromToken(HttpServletRequest request) {
		SSOTokenManager manager = SSOTokenManager.getInstance();
		SSOToken token = manager.createSSOToken(request);
		if(manager.isValidToken(token)) {
			Principal p = token.getPrincipal();
			if(p == null) {
				return null;
			}
			return p.getName();
		}
		return null;
	}

	/**
	 * 在time内校验单点登录token是否有效，并获取登录账户
	 * @param request HttpServletRequest
	 * @param timeout 超时时间
	 * @param unit 超时时间单位
	 * @return 登录账户
	 */
	public static String getUserNameFromTokenInTime(HttpServletRequest request, long timeout, TimeUnit unit) {
		Future<String> future = new FutureTask<>(() -> getUserNameFromToken(request));
		try {
			return future.get(timeout, unit);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
