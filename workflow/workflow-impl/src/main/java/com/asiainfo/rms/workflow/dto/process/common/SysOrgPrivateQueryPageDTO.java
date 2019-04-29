package com.asiainfo.rms.workflow.dto.process.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author joker
 */
@ApiModel(description = "")
public class SysOrgPrivateQueryPageDTO {
	
	@ApiModelProperty(value = "(开始)")
	private java.lang.Long staff_id_begin;
	
	@ApiModelProperty(value = "(结束)")
	private java.lang.Long staff_id_end;
	
	@ApiModelProperty(value = "")
	private java.lang.String code;
	
	@ApiModelProperty(value = "")
	private java.lang.String employee_name;
	
	@ApiModelProperty(value = "")
	private java.lang.String bill_id;
	
	@ApiModelProperty(value = "")
	private java.lang.Boolean lock_flag;
	
	@ApiModelProperty(value = "(开始)")
	private java.lang.Long staff_org_relat_id_begin;
	
	@ApiModelProperty(value = "(结束)")
	private java.lang.Long staff_org_relat_id_end;
	
	@ApiModelProperty(value = "(开始)")
	private java.lang.Long organize_id_begin;
	
	@ApiModelProperty(value = "(结束)")
	private java.lang.Long organize_id_end;
	
	@ApiModelProperty(value = "")
	private java.lang.String organize_name;
	
	@ApiModelProperty(value = "(开始)")
	private Integer org_type_begin;
	
	@ApiModelProperty(value = "(结束)")
	private Integer org_type_end;
	
	@ApiModelProperty(value = "")
	private java.lang.String param_name;
	
	@ApiModelProperty(value = "")
	private java.lang.String param_type;
	
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
	public java.lang.Boolean getLock_flag() {
		return this.lock_flag;
	}

	public void setLock_flag(java.lang.Boolean value) {
		this.lock_flag = value;
	}	    	
	public java.lang.Long getStaff_org_relat_id_begin() {
		return this.staff_org_relat_id_begin;
	}
	
	public void setStaff_org_relat_id_begin(java.lang.Long value) {
		this.staff_org_relat_id_begin = value;
	}
	
	public java.lang.Long getStaff_org_relat_id_end() {
		return this.staff_org_relat_id_end;
	}
	
	public void setStaff_org_relat_id_end(java.lang.Long value) {
		this.staff_org_relat_id_end = value;
	}
	public java.lang.Long getOrganize_id_begin() {
		return this.organize_id_begin;
	}
	
	public void setOrganize_id_begin(java.lang.Long value) {
		this.organize_id_begin = value;
	}
	
	public java.lang.Long getOrganize_id_end() {
		return this.organize_id_end;
	}
	
	public void setOrganize_id_end(java.lang.Long value) {
		this.organize_id_end = value;
	}
	public java.lang.String getOrganize_name() {
		return this.organize_name;
	}

	public void setOrganize_name(java.lang.String value) {
		this.organize_name = value;
	}	    	
	public Integer getOrg_type_begin() {
		return this.org_type_begin;
	}
	
	public void setOrg_type_begin(Integer value) {
		this.org_type_begin = value;
	}
	
	public Integer getOrg_type_end() {
		return this.org_type_end;
	}
	
	public void setOrg_type_end(Integer value) {
		this.org_type_end = value;
	}
	public java.lang.String getParam_name() {
		return this.param_name;
	}

	public void setParam_name(java.lang.String value) {
		this.param_name = value;
	}	    	
	public java.lang.String getParam_type() {
		return this.param_type;
	}

	public void setParam_type(java.lang.String value) {
		this.param_type = value;
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

