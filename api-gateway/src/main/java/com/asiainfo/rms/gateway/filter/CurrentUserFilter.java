package com.asiainfo.rms.gateway.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.OncePerRequestFilter;

import com.asiainfo.rms.gateway.exception.AtsAuthenticationException;
import com.asiainfo.rms.gateway.properties.AtsSecurityProperties;
import com.asiainfo.rms.gateway.properties.SkipUri;
import com.asiainfo.rms.gateway.security.AtsSecurityConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("currentUserFilter")
public class CurrentUserFilter extends OncePerRequestFilter implements InitializingBean  {
	
	private static final Logger log = LogManager.getLogger(CurrentUserFilter.class);
	
	@Autowired
	private AuthenticationFailureHandler atsAuthenctiationFailureHandler;
	
	@Autowired
	private AtsSecurityProperties atsSecurityProperties;
	
	@Autowired
	private RedisTokenStore tokenStore;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Map<String, String> urlMap = new HashMap<String, String>();
	
	private AntPathMatcher pathMatcher = new AntPathMatcher();

	@Override
	public void afterPropertiesSet() throws ServletException {
		super.afterPropertiesSet();
		urlMap.put("sysInfo", AtsSecurityConstants.sysInfo);
		urlMap.put("login", AtsSecurityConstants.login);
		urlMap.put("logins", AtsSecurityConstants.logins);
		urlMap.put("userInfo", AtsSecurityConstants.userInfo);
		urlMap.put("validateCode", AtsSecurityConstants.validateCode);
		if (atsSecurityProperties.getSkipUris() != null) {
			for (SkipUri skipUri : atsSecurityProperties.getSkipUris()) {
				if (skipUri == null || StringUtils.isBlank(skipUri.getName()) || StringUtils.isBlank(skipUri.getUrl())) {
					continue;
				}
				urlMap.put(skipUri.getName(), skipUri.getUrl());
			}
		}
		try {
			log.info("\n" + objectMapper.writeValueAsString(urlMap));
		} catch (JsonProcessingException e) {
			log.info(urlMap);
		}
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
//		try {
//			if (getOsAndBrowserInfo(request)) {
//				log.info("\n授权信息错误.");
//				throw new AtsAuthenticationException("授权信息错误.");
//			}
//		} catch (AuthenticationException exception) {
//			atsAuthenctiationFailureHandler.onAuthenticationFailure(request, response, exception);
//			return;
//		}
//		try {
//			if (requiredValidateUrI(request)) {
//				String staffId = request.getHeader("staff_id");
//				if (StringUtils.isBlank(staffId)) {
//					log.info("\n授权信息错误");
//					throw new AtsAuthenticationException("授权信息错误");
//				}
//				String authorization = request.getHeader("Authorization");
//				if (StringUtils.isBlank(authorization)) {
//					log.info("\n令牌信息错误");
//					throw new AtsAuthenticationException("令牌信息错误");
//				}
//				
//				OAuth2AccessToken accessToken = tokenStore.readAccessToken(authorization.trim().substring(7));
//				if (accessToken == null) {
//					log.info("\n令牌无效");
//					throw new AtsAuthenticationException("令牌无效");
//				}
//				Map<String, Object> additional = accessToken.getAdditionalInformation();
//				String currentStaffId = String.valueOf(additional.get("staff_id"));
//				if (!staffId.equals(currentStaffId)) {
//					tokenStore.removeAccessToken(authorization.trim().substring(7));
//					tokenStore.removeAccessToken(accessToken);
//					log.info("\n令牌强制失效");
//					throw new AtsAuthenticationException("令牌强制失效");
//				}
//			}
//		} catch (AuthenticationException exception) {
//			atsAuthenctiationFailureHandler.onAuthenticationFailure(request, response, exception);
//			return;
//		}
//		Access-Control-Allow-Methods: GET, POST, PUT
//		Access-Control-Allow-Headers: X-Custom-Header
//		Access-Control-Allow-Credentials: true
//		Access-Control-Max-Age: 1728000
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Max-Age", "1728000");
		chain.doFilter(request, response);
	}
	
	private boolean requiredValidateUrI(HttpServletRequest request) {
		Set<String> urlNames = urlMap.keySet();
		log.info(String.format("%s %s %s %s %s", request.getRemoteHost(), request.getMethod(), request.getRequestURL().toString(), request.getHeader("staff_id"), request.getHeader("Authorization")));
		for (String urlName : urlNames) {
			if (pathMatcher.match(urlMap.get(urlName), request.getRequestURI())) {
				return false;
			}
		}
		return true;
	}
	
	private boolean getOsAndBrowserInfo(HttpServletRequest request){
        String  browserDetails  =   request.getHeader("User-Agent");
        String  userAgent       =   browserDetails;
        String  user            =   userAgent.toLowerCase();
        String os = "";
        String browser = "";
        // ================= OS Info =======================
        if (userAgent.toLowerCase().indexOf("windows") >= 0 )
        {
            os = "Windows";
        } else if(userAgent.toLowerCase().indexOf("mac") >= 0)
        {
            os = "Mac";
        } else if(userAgent.toLowerCase().indexOf("x11") >= 0)
        {
            os = "Unix";
        } else if(userAgent.toLowerCase().indexOf("android") >= 0)
        {
            os = "Android";
        } else if(userAgent.toLowerCase().indexOf("iphone") >= 0)
        {
            os = "IPhone";
        }else{
            os = "UnKnown, More-Info: "+userAgent;
        }
        
        // =============== Browser Info ===========================
        if (user.contains("edge"))
        {
            browser=(userAgent.substring(userAgent.indexOf("Edge")).split(" ")[0]).replace("/", "-");
        } else if (user.contains("msie"))
        {
            String substring=userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
            browser=substring.split(" ")[0].replace("MSIE", "IE")+"-"+substring.split(" ")[1];
        } else if (user.contains("safari") && user.contains("version"))
        {
            browser=(userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0]
                    + "-" +(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
        } else if ( user.contains("opr") || user.contains("opera"))
        {
            if(user.contains("opera")){
                browser=(userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0]
                        +"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
            }else if(user.contains("opr")){
                browser=((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-"))
                        .replace("OPR", "Opera");
            }
 
        } else if (user.contains("chrome"))
        {
            browser = (userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
        } else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1)  ||
                (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) ||
                (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1) )
        {
            browser = "Netscape-?";
 
        } else if (user.contains("firefox"))
        {
            browser = (userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
        } else if(user.contains("rv"))
        {
            String IEVersion = (userAgent.substring(userAgent.indexOf("rv")).split(" ")[0]).replace("rv:", "-");
            browser = "IE" + IEVersion.substring(0,IEVersion.length() - 1);
        } else
        {
            browser = "UnKnown, More-Info: "+userAgent;
        }
        log.info(os);
        log.info(browser);
        if ((os == "Windows" || os == "Mac" || os.indexOf("UnKnown, More-Info: Python-urllib/1.17") >= 0) && (browser.indexOf("IE") >= 0 || browser.indexOf("Chrome") >= 0 || browser.indexOf("Edge") >= 0 || browser.indexOf("UnKnown, More-Info: Python-urllib/1.17") >= 0)) {
        	return false;
        } else {
        	return true;
        }
	}

}
