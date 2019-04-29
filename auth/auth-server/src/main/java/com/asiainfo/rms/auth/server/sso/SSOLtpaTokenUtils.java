package com.asiainfo.rms.auth.server.sso;



import com.powerunion.xjcmccsso.LtpaSSOManager;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 新的oa单点登录获取数据方式
 */
public class SSOLtpaTokenUtils {

    /**
     * 校验单点登录token是否有效并获取登录账户
     * @param request HttpServletRequest
     * @return 登录账户
     */
    private static String getUserNameFromToken(HttpServletRequest request) {
        LtpaSSOManager manager = new LtpaSSOManager();
        if(manager.authenticate(request)) {
            // /认证成功，获得服务端获取的用户登录id
            String name = manager.getUserName();
            return name;
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
