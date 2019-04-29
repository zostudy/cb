package com.asiainfo.rms.auth.server;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {

    private static Logger LOGGER = LogManager.getLogger(CustomTokenEnhancer.class);
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
//        User user = (User) authentication.getPrincipal();
        LoginUser user = (LoginUser) authentication.getPrincipal();
        LOGGER.info("****user***"+user);
        Map<String, Object> additional = new HashMap<>();
        additional.put("staff_id", Integer.parseInt(user.getUsername()));
        additional.put("code",String.valueOf(user.getCode()));
        additional.put("msg",String.valueOf(user.getMsg()));
        // 传到前台塞入orderId
        //additional.put("order_id", user.getOrderId());
        LOGGER.info("****additional***"+additional);

//        additional.put("login_log_id", Integer.parseInt(String.valueOf(user.getLogId())));
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additional);
        return accessToken;
    }
}
