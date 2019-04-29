package com.asiainfo.rms.system.dto;

import lombok.Data;
@Data
public class ReverseAuthenticateDTO {
		private Long staffId;
		private String account4aMain;
		private String account;
		private String systemType;
		private String ssoinfo;
		private String menuUrl;
		private String ticketId;
		private String testUrl;
		private String crmEntryUrl;
}
