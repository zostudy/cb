package com.asiainfo.rms.workflow.dto.process.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author joker
 */
@ApiModel(description = "")
public class SysStationPrivateQueryPageDTO {
	
	@ApiModelProperty(value = "(开始)")
	private java.lang.Long staff_id_begin;
	
	@ApiModelProperty(value = "(结束)")
	private java.lang.Long staff_id_end;
	
	@ApiModelProperty(value = "")
	private java.lang.String staff_code;
	
	@ApiModelProperty(value = "")
	private java.lang.String employee_name;
	
	@ApiModelProperty(value = "")
	private java.lang.String bill_id;
	
	@ApiModelProperty(value = "")
	private java.lang.Boolean lock_flag;
	
	@ApiModelProperty(value = "(开始)")
	private java.lang.Long author_id_begin;
	
	@ApiModelProperty(value = "(结束)")
	private java.lang.Long author_id_end;
	
	@ApiModelProperty(value = "")
	private java.lang.String notes;
	
	@ApiModelProperty(value = "")
	private java.lang.String notes_type;
	
	@ApiModelProperty(value = "(开始)")
	private java.lang.Long station_id_begin;
	
	@ApiModelProperty(value = "(结束)")
	private java.lang.Long station_id_end;
	
	@ApiModelProperty(value = "")
	private java.lang.String station_code;
	
	@ApiModelProperty(value = "")
	private java.lang.String name;
	
	@ApiModelProperty(value = "(开始)")
	private Integer type_begin;
	
	@ApiModelProperty(value = "(结束)")
	private Integer type_end;
	
	@ApiModelProperty(value = "(开始)")
	private Integer station_type_begin;
	
	@ApiModelProperty(value = "(结束)")
	private Integer station_type_end;
	
	@ApiModelProperty(value = "")
	private java.lang.String sta_private_name;
	
	@ApiModelProperty(value = "")
	private java.lang.String sta_private_type;
	
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
	private java.lang.String org_private_name;
	
	@ApiModelProperty(value = "")
	private java.lang.String org_private_type;
	
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
	public java.lang.String getStaff_code() {
		return this.staff_code;
	}

	public void setStaff_code(java.lang.String value) {
		this.staff_code = value;
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
	public java.lang.Long getAuthor_id_begin() {
		return this.author_id_begin;
	}
	
	public void setAuthor_id_begin(java.lang.Long value) {
		this.author_id_begin = value;
	}
	
	public java.lang.Long getAuthor_id_end() {
		return this.author_id_end;
	}
	
	public void setAuthor_id_end(java.lang.Long value) {
		this.author_id_end = value;
	}
	public java.lang.String getNotes() {
		return this.notes;
	}

	public void setNotes(java.lang.String value) {
		this.notes = value;
	}	    	
	public java.lang.String getNotes_type() {
		return this.notes_type;
	}

	public void setNotes_type(java.lang.String value) {
		this.notes_type = value;
	}	    	
	public java.lang.Long getStation_id_begin() {
		return this.station_id_begin;
	}
	
	public void setStation_id_begin(java.lang.Long value) {
		this.station_id_begin = value;
	}
	
	public java.lang.Long getStation_id_end() {
		return this.station_id_end;
	}
	
	public void setStation_id_end(java.lang.Long value) {
		this.station_id_end = value;
	}
	public java.lang.String getStation_code() {
		return this.station_code;
	}

	public void setStation_code(java.lang.String value) {
		this.station_code = value;
	}	    	
	public java.lang.String getName() {
		return this.name;
	}

	public void setName(java.lang.String value) {
		this.name = value;
	}	    	
	public Integer getType_begin() {
		return this.type_begin;
	}
	
	public void setType_begin(Integer value) {
		this.type_begin = value;
	}
	
	public Integer getType_end() {
		return this.type_end;
	}
	
	public void setType_end(Integer value) {
		this.type_end = value;
	}
	public Integer getStation_type_begin() {
		return this.station_type_begin;
	}
	
	public void setStation_type_begin(Integer value) {
		this.station_type_begin = value;
	}
	
	public Integer getStation_type_end() {
		return this.station_type_end;
	}
	
	public void setStation_type_end(Integer value) {
		this.station_type_end = value;
	}
	public java.lang.String getSta_private_name() {
		return this.sta_private_name;
	}

	public void setSta_private_name(java.lang.String value) {
		this.sta_private_name = value;
	}	    	
	public java.lang.String getSta_private_type() {
		return this.sta_private_type;
	}

	public void setSta_private_type(java.lang.String value) {
		this.sta_private_type = value;
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
	public java.lang.String getOrg_private_name() {
		return this.org_private_name;
	}

	public void setOrg_private_name(java.lang.String value) {
		this.org_private_name = value;
	}	    	
	public java.lang.String getOrg_private_type() {
		return this.org_private_type;
	}

	public void setOrg_private_type(java.lang.String value) {
		this.org_private_type = value;
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

