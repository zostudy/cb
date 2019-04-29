package com.asiainfo.rms.workflow.dto.process.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author joker
 */
@ApiModel(description = "")
public class SysStaffQueryPageDTO {
	
	@ApiModelProperty(value = "工号ID(开始)")
	private java.lang.Long staff_id_begin;
	
	@ApiModelProperty(value = "工号ID(结束)")
	private java.lang.Long staff_id_end;
	
	@ApiModelProperty(value = "工号")
	private java.lang.String code;
	
	@ApiModelProperty(value = "密码")
	private java.lang.String password;
	
	@ApiModelProperty(value = "修改密码,记录上一次")
	private java.lang.String recent_password;
	
	@ApiModelProperty(value = "修改密码时间(开始)")
	private String recent_time_begin;
	
	@ApiModelProperty(value = "修改密码时间(结束)")
	private String recent_time_end;
	
	@ApiModelProperty(value = "雇员名称")
	private java.lang.String employee_name;
	
	@ApiModelProperty(value = "手机号码")
	private java.lang.String bill_id;
	
	@ApiModelProperty(value = "邮箱")
	private java.lang.String email;
	
	@ApiModelProperty(value = "职责")
	private java.lang.String religion;
	
	@ApiModelProperty(value = "状态(开始)")
	private Integer state_begin;
	
	@ApiModelProperty(value = "状态(结束)")
	private Integer state_end;
	
	@ApiModelProperty(value = "是否有锁")
	private java.lang.Boolean lock_flag;
	
	@ApiModelProperty(value = "备注")
	private java.lang.String notes;
	
	@ApiModelProperty(value = "扩展字段1")
	private java.lang.String ext1;
	
	@ApiModelProperty(value = "扩展字段2")
	private java.lang.String ext2;
	
	@ApiModelProperty(value = "扩展字段3")
	private java.lang.String ext3;
	
	@ApiModelProperty(value = "4A主账号")
	private java.lang.String account_4a;
	
	@ApiModelProperty(value = "CRM从账号")
	private java.lang.String account_crm;
	
	@ApiModelProperty(value = "BOSS从账号")
	private java.lang.String account_boss;
	
	@ApiModelProperty(value = "分页页码")
	private Integer page_no;
	
	@ApiModelProperty(value = "分页步长")
	private Integer page_size;
	
	public java.lang.Long getStaff_id_begin() {
		return this.staff_id_begin;
	}
	
	public void setStaff_id_begin(java.lang.Long value) {
		this.staff_id_begin = value;
	}
	
	public java.lang.Long getStaff_id_end() {
		return this.staff_id_end;
	}
	
	public void setStaff_id_end(java.lang.Long value) {
		this.staff_id_end = value;
	}
	public java.lang.String getCode() {
		return this.code;
	}

	public void setCode(java.lang.String value) {
		this.code = value;
	}	    	
	public java.lang.String getPassword() {
		return this.password;
	}

	public void setPassword(java.lang.String value) {
		this.password = value;
	}	    	
	public java.lang.String getRecent_password() {
		return this.recent_password;
	}

	public void setRecent_password(java.lang.String value) {
		this.recent_password = value;
	}	    	

	public String getRecent_time_begin() {
		return this.recent_time_begin;
	}
	
	public void setRecent_time_begin(String value) {
		this.recent_time_begin = value;
	}
	
	public String getRecent_time_end() {
		return this.recent_time_end;
	}
	
	public void setRecent_time_end(String value) {
		this.recent_time_end = value;
	}
	public java.lang.String getEmployee_name() {
		return this.employee_name;
	}

	public void setEmployee_name(java.lang.String value) {
		this.employee_name = value;
	}	    	
	public java.lang.String getBill_id() {
		return this.bill_id;
	}

	public void setBill_id(java.lang.String value) {
		this.bill_id = value;
	}	    	
	public java.lang.String getEmail() {
		return this.email;
	}

	public void setEmail(java.lang.String value) {
		this.email = value;
	}	    	
	public java.lang.String getReligion() {
		return this.religion;
	}

	public void setReligion(java.lang.String value) {
		this.religion = value;
	}	    	
	public Integer getState_begin() {
		return this.state_begin;
	}
	
	public void setState_begin(Integer value) {
		this.state_begin = value;
	}
	
	public Integer getState_end() {
		return this.state_end;
	}
	
	public void setState_end(Integer value) {
		this.state_end = value;
	}
	public java.lang.Boolean getLock_flag() {
		return this.lock_flag;
	}

	public void setLock_flag(java.lang.Boolean value) {
		this.lock_flag = value;
	}	    	
	public java.lang.String getNotes() {
		return this.notes;
	}

	public void setNotes(java.lang.String value) {
		this.notes = value;
	}	    	
	public java.lang.String getExt1() {
		return this.ext1;
	}

	public void setExt1(java.lang.String value) {
		this.ext1 = value;
	}	    	
	public java.lang.String getExt2() {
		return this.ext2;
	}

	public void setExt2(java.lang.String value) {
		this.ext2 = value;
	}	    	
	public java.lang.String getExt3() {
		return this.ext3;
	}

	public void setExt3(java.lang.String value) {
		this.ext3 = value;
	}	    	
	public java.lang.String getAccount_4a() {
		return this.account_4a;
	}

	public void setAccount_4a(java.lang.String value) {
		this.account_4a = value;
	}	    	
	public java.lang.String getAccount_crm() {
		return this.account_crm;
	}

	public void setAccount_crm(java.lang.String value) {
		this.account_crm = value;
	}	    	
	public java.lang.String getAccount_boss() {
		return this.account_boss;
	}

	public void setAccount_boss(java.lang.String value) {
		this.account_boss = value;
	}	    	
	
	public Integer getPage_no() {
		return this.page_no;
	}
	
	public Integer getPage_size() {
		return this.page_size;
	}
	
	public void setPage_no(Integer page_no) {
		this.page_no = page_no;
	}
	
	public void setPage_size(Integer page_size) {
		this.page_size = page_size;
	}
}

