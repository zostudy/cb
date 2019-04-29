package com.asiainfo.rms.workflow.domain.workflow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SYS_STAFF_MANAGER_RELAT 实体类
 * Thu Aug 31 20:36:28 CST 2017 yangyh
 */ 
@Entity
@Table(name="SYS_STAFF_MANAGER_RELAT")
public class BOSysStaffManagerRelat{
	@Id
	@Column(name="STAFF_MANAGER_RELAT_ID")
		private Long staffManagerRelatId;
	@Column(name="STAFF_ID")
		private Long staffId;
	@Column(name="STAFF_NAME")
		private String staffName;
	@Column(name="SYS_TAG")
		private Long sysTag;
	@Column(name="REQ_TYPE")
		private String reqType;
	@Column(name="CONFIG_DSCR")
	private String configDscr;
	public void setStaffManagerRelatId(Long staffManagerRelatId){
	this.staffManagerRelatId=staffManagerRelatId;
	}
	public Long getStaffManagerRelatId(){
		return staffManagerRelatId;
	}
	public void setStaffId(Long staffId){
	this.staffId=staffId;
	}
	public Long getStaffId(){
		return staffId;
	}
	public void setStaffName(String staffName){
	this.staffName=staffName;
	}
	public String getStaffName(){
		return staffName;
	}
	public void setSysTag(Long sysTag){
	this.sysTag=sysTag;
	}
	public Long getSysTag(){
		return sysTag;
	}
	public void setReqType(String reqType){
	this.reqType=reqType;
	}
	public String getReqType(){
		return reqType;
	}
	public void setConfigDscr(String configDscr){
	this.configDscr=configDscr;
	}
	public String getConfigDscr(){
		return configDscr;
	}
}

