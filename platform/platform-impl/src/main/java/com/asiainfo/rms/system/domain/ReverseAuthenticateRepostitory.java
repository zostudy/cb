package com.asiainfo.rms.system.domain;

import lombok.Data;

public class ReverseAuthenticateRepostitory {
	private Long staffId;
	private String account4aMain;
	private String account;
	private String systemType;
	private String ssoinfo;
	private String menuUrl;
	private String ticketId;
	private String testUrl;
	private String crmEntryUrl;
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	
	public String getAccount4aMain() {
		return account4aMain;
	}
	public void setAccount4aMain(String account4aMain) {
		this.account4aMain = account4aMain;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getSystemType() {
		return systemType;
	}
	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}
	public String getSsoinfo() {
		return ssoinfo;
	}
	public void setSsoinfo(String ssoinfo) {
		this.ssoinfo = ssoinfo;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getTestUrl() {
		return testUrl;
	}
	public void setTestUrl(String testUrl) {
		this.testUrl = testUrl;
	}
	public String getCrmEntryUrl() {
		return crmEntryUrl;
	}
	public void setCrmEntryUrl(String crmEntryUrl) {
		this.crmEntryUrl = crmEntryUrl;
	}
	
	
}
