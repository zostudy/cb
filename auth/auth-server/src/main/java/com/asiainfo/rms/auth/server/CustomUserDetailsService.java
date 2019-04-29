package com.asiainfo.rms.auth.server;


import com.asiainfo.rms.auth.server.sso.SSOLtpaTokenUtils;
import com.asiainfo.rms.auth.server.sso.SSOTokenUtils;
import com.asiainfo.rms.auth.server.util.RequestUtil;
import com.asiainfo.rms.system.dto.SysLoginInfoDTO;
import com.asiainfo.rms.system.web.LoginController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeUnit;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


@Component("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private static Logger LOGGER = LogManager.getLogger(CustomUserDetailsService.class);


    @Value("${sso.xj.timeout}")
    private Long ssoXjTimeout = 1000L;
//    @Value("${sso.xj.oaJumpPath}")
//    private String oaJumpPath;

    @Autowired
    private LoginController loginController;

    private void throwException(String code, String msg) {
        OAuth2Exception oAuth2Exception = new OAuth2Exception("登陆异常信息");
        oAuth2Exception.addAdditionalInformation("code", code);
        oAuth2Exception.addAdditionalInformation("msg", msg);
        throw oAuth2Exception;
    }

    @Override
        public UserDetails loadUserByUsername(String username) {

        LOGGER.error("CustomUserDetailsService********传入的username ： "+username);
        // 路径/oauth/token上有切面编程 SSOLoginAspect，主要处理单点登录账户密码权限等问题
        List<GrantedAuthority> authorities = new ArrayList<>(); // 权限列表
        SysLoginInfoDTO loginInfoDTO = new SysLoginInfoDTO();   // 登录所用的DTO
        LOGGER.error("CustomUserDetailsService********1111");

        HttpServletRequest request = RequestUtil.getCurrentRequest();

        //HttpServletResponse response = RequestUtil.getResponse();
        String ip;
        if (RequestUtil.getCurrentRequest().getHeader("x-forwarded-for") == null)
            ip = RequestUtil.getCurrentRequest().getRemoteAddr();
        else {
            ip = RequestUtil.getCurrentRequest().getHeader("x-forwarded-for");
        }

        loginInfoDTO.setSessionId(request.getSession().getId());
        loginInfoDTO.setIp(ip);

        String password;

        LOGGER.error("CustomUserDetailsService********ip:"+ip);

        // 登录类型，oaLogin:OA自身的登录，ssoLogin:单点登录
        String loginType = request.getParameter("loginType");
        LOGGER.error("CustomUserDetailsService********loginType: "+loginType);
//        Integer orderId = Integer.parseInt(request.getParameter("order_id"));
//        LOGGER.error("orderId: "+orderId);
        String name = request.getParameter("username");
        LOGGER.error("CustomUserDetailsService********request获取的name: "+name);
        //String orderId = "";
        if(SysLoginInfoDTO.SSO_LOGIN.equalsIgnoreCase(loginType)) {
            loginInfoDTO.setLoginType(loginType);


            if(username == null) {
                // 在一段时间内无法校验出ssoToken有效并取出username，则表示单点登录失败
                throwException("-1", "单点登录失败！");
            }
            loginInfoDTO.setCode(username);

            // 单点登录密码可以为为何字符值，但是不能为null，否则在设置LoginUser的时候会抛出异常
            // 设置的密码必须与切面SSLoginAspect中设置的密码一致，否则会报坏的凭证
            password = "_sso";
        } else {
            loginInfoDTO.setLoginType(SysLoginInfoDTO.OA_LOGIN);
            loginInfoDTO.setCode(username);
            loginInfoDTO.setValidKey(request.getParameter("valid_code"));
            loginInfoDTO.setVerificationCode(request.getParameter("verification_code"));

            password = request.getParameter("password");
        }
        loginInfoDTO.setPassWord(password);

        // 登录校验操作
        Map<Object, Object> reqMap = loginController.login(loginInfoDTO);
        LOGGER.error("CustomUserDetailsService********reqMap:"+reqMap.toString());
        if("0".equals(reqMap.get("code"))) {
            throwException((String) reqMap.get("code"), (String) reqMap.get("msg"));
        }

        Integer userId = (Integer) reqMap.get("staff_id");
        LOGGER.error("CustomUserDetailsService********userId:"+userId);
        // 此密码应该和/oauth/token获取的密码一致，这个会在CustomPasswordEncoder中再次对密码进行校验
        LoginUser user = new LoginUser(userId == null ? username : userId.toString(), password, authorities);

        user.setUserId(userId);

        user.setCode((String) reqMap.get("code"));
        user.setMsg((String) reqMap.get("msg"));

        LOGGER.error("CustomUserDetailsService********:"+user);

        return user;
    }
}
