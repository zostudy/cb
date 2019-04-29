package com.asiainfo.rms.system.service;

import java.net.URLEncoder;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.asiainfo.rms.system.dto.ReverseAuthenticateDTO;

public interface ReverseAuthenticateService {
	/**
	 * 调用CRM页面时，存储反向认证信息接口
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ReverseAuthenticateDTO  reverseAuthenticateTokenSave(ReverseAuthenticateDTO user);
	
	/**
	 * 调用CRM页面时，反向认证验证token有效性接口
	 * @param ssoinfo
	 * @return
	 */
	public String reverseAuthenticateTokenCheck(String staffId,String ticketLoginId);
}
