package com.asiainfo.rms.system.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.system.dao.ReverseAuthenticateRedisDAO;
import com.asiainfo.rms.system.dto.ReverseAuthenticateDTO;
import com.asiainfo.rms.system.service.ReverseAuthenticateService;

import lombok.extern.log4j.Log4j;
@Log4j
@RestController
@Transactional
public class ReverseAuthenticateControllerImpl  implements ReverseAuthenticateController{

	@Autowired
	private ReverseAuthenticateService reverseAuthenticateService;
	
	@Override
	public ReverseAuthenticateDTO reverseAuthenticateTokenSave(ReverseAuthenticateDTO reverseAuthenticateDTO) {
			return reverseAuthenticateService.reverseAuthenticateTokenSave(reverseAuthenticateDTO);
	}

	@Override
	public void reverseAuthenticateTokenCheck(HttpServletRequest request,HttpServletResponse response) {
		String staffId = request.getParameter("staff_id");
		String ticketLoginId = request.getParameter("ticket_login_id");
		if(StringUtils.isEmpty(staffId) || StringUtils.isEmpty(ticketLoginId)){
			response.setStatus(500);
			try {
				response.getWriter().print("false");
				response.flushBuffer();
			} catch (IOException e) {
				log.error(e.getMessage(),e);
			}
			
			return;
		}	
		String re = reverseAuthenticateService.reverseAuthenticateTokenCheck(staffId, ticketLoginId);
		if(!"OK".equals(re)){
			response.setStatus(500);
			try {
				response.getWriter().print("false");
				response.flushBuffer();
			} catch (IOException e) {
				log.error(e.getMessage(),e);
			}
			
			return;
		}

		response.setStatus(200);
		try {
			response.getWriter().print("true");
			response.flushBuffer();
			// TODO Auto-generated catch block
			// TODO Auto-generated catch block
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}
	}
	
}
