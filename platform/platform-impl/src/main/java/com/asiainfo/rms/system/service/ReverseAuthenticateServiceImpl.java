package com.asiainfo.rms.system.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.asiainfo.rms.system.convert.ReverseAuthenticateConvert;
import com.asiainfo.rms.system.dao.ReverseAuthenticateRedisDAO;
import com.asiainfo.rms.system.domain.ReverseAuthenticateRepostitory;
import com.asiainfo.rms.system.dto.ReverseAuthenticateDTO;
import com.asiainfo.rms.system.redis.operations.ZosValueOperations;
import com.asiainfo.rms.system.util.EscapeUtil;
import com.asiainfo.rms.system.util.SSOTicketDESUtil;


@Component
@Transactional
public class ReverseAuthenticateServiceImpl implements ReverseAuthenticateService{
	
	@Value("${reverseAuthenticate.menuUrl}")
	private String crmEntryUrlPrefix;
	
	@Value("${reverseAuthenticate.ssoTicketDesKey}")
	private String desKey;
	
	@Autowired
	private ReverseAuthenticateRedisDAO reverseAuthenticateRedisDAO;
	
	private static Logger logger = LoggerFactory.getLogger(ReverseAuthenticateServiceImpl.class);
	
	/**
	 * 调用CRM页面时，存储反向认证信息接口
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ReverseAuthenticateDTO  reverseAuthenticateTokenSave(ReverseAuthenticateDTO reverseAuthenticateDTO){
		
		ReverseAuthenticateRepostitory user = ReverseAuthenticateConvert.INSTANCE.toSYS(reverseAuthenticateDTO);
		ZosValueOperations valOpr = reverseAuthenticateRedisDAO.opsForValue();
		String tokenId = UUID.randomUUID().toString();
		user.setTicketId(tokenId);//以明文存储到redis
		if(user.getAccount() == null || "".equals(user.getAccount().trim())){
			logger.error("发起第三方页面访问请求时，第三方系统工号提供有误！");
			return reverseAuthenticateDTO;
		}
		StringBuffer val = new StringBuffer("");
		val.append(user.getStaffId() + "|");
		val.append(user.getTicketId() + "|");
		val.append(user.getAccount() + "|");
		val.append(System.currentTimeMillis() + "|");
		val.append(user.getAccount4aMain() + "|");
		val.append("3");
		String ciphertextSsoinfo = SSOTicketDESUtil.encrypt(val.toString(),desKey);
		user.setSsoinfo(ciphertextSsoinfo);//以密文返回给前台
		
		try {
			
			String menuUrl = crmEntryUrlPrefix+"&menu_url="+URLEncoder.encode(EscapeUtil.escape(user.getMenuUrl()), "UTF-8")+"&ssoinfo="+user.getSsoinfo();
			user.setCrmEntryUrl(menuUrl);
		} catch (UnsupportedEncodingException e) {
			logger.error("发起第三方页面访问请求时，URL地址编码转换有误！");
			e.printStackTrace();
			return reverseAuthenticateDTO;
		}
//		if("CRM".equals(user.getSystemType().toUpperCase())){
		    
			valOpr.set(reverseAuthenticateRedisDAO.valueKey("CRM", user), user.getTicketId(), 600l, TimeUnit.SECONDS);
			
			
			//		}
//		if("BOSS".equals(user.getSystemType().toUpperCase())){
//			valOpr.set(reverseAuthenticateRedisDAO.valueKey("BOSS", user), val.toString(), 30l, TimeUnit.SECONDS);
//		}
		user.setTestUrl("http://10.238.99.198:8080/cscrmsso?&menu_url=%252fngboss%253fservice%253dpage%252fngboss%252eframe%252epc%252ecommon%252eMain%2526listener%253dinit&ssoinfo="+user.getSsoinfo());

		return ReverseAuthenticateConvert.INSTANCE.toDTO(user);
	}
	
	/**
	 * 调用CRM页面时，反向认证验证token有效性接口
	 * @param ssoinfo
	 * @return
	 */
	public String reverseAuthenticateTokenCheck(String staffId,String ticketLoginId){
		ZosValueOperations valOpr = reverseAuthenticateRedisDAO.opsForValue();
		ReverseAuthenticateRepostitory user = new ReverseAuthenticateRepostitory();
		user.setStaffId(new Long(staffId));
		user.setSystemType("CRM");
		user.setSsoinfo(ticketLoginId);//以明文用于校验
		if("CRM".equals(user.getSystemType().toUpperCase())){
			String value = valOpr.get(reverseAuthenticateRedisDAO.valueKey("CRM", user));
			if(value != null && ticketLoginId.equals(value)){
				return "OK";
			}else{
				return "REFUSE";
			}
		}
//		if("BOSS".equals(user.getSystemType().toUpperCase())){
//			String value = valOpr.get(reverseAuthenticateRedisDAO.valueKey("BOSS", user));
//			if(value != null && plaintextSsoinfo.equals(value)){
//				return "OK";
//			}else{
//				return "REFUSE";
//			}
//		}
		return "REFUSE";
	}
		
}
