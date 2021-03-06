package com.asiainfo.rms.workflow.dto.process.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author joker
 */
@ApiModel(description = "")
public class SysStaffOrgRelatQueryPageDTO {
	
	@ApiModelProperty(value = "关系ID(开始)")
	private java.lang.Long staff_org_relat_id_begin;
	
	@ApiModelProperty(value = "关系ID(结束)")
	private java.lang.Long staff_org_relat_id_end;
	
	@ApiModelProperty(value = "组织ID(开始)")
	private java.lang.Long organize_id_begin;
	
	@ApiModelProperty(value = "组织ID(结束)")
	private java.lang.Long organize_id_end;
	
	@ApiModelProperty(value = "人员ID(开始)")
	private java.lang.Long staff_id_begin;
	
	@ApiModelProperty(value = "人员ID(结束)")
	private java.lang.Long staff_id_end;
	
	@ApiModelProperty(value = "1 正常 0删除(开始)")
	private Integer state_begin;
	
	@ApiModelProperty(value = "1 正常 0删除(结束)")
	private Integer state_end;
	
	@ApiModelProperty(value = "备注")
	private java.lang.String notes;
	
	@ApiModelProperty(value = "创建时间(开始)")
	private String create_time_begin;
	
	@ApiModelProperty(value = "创建时间(结束)")
	private String create_time_end;
	
	@ApiModelProperty(value = "扩展字段1")
	private java.lang.String ext1;
	
	@ApiModelProperty(value = "扩展字段2")
	private java.lang.String ext2;
	
	@ApiModelProperty(value = "扩展字段3")
	private java.lang.String ext3;
	
	@ApiModelProperty(value = "分页页码")
	private Integer page_no;
	
	@ApiModelProperty(value = "分页步长")
	private Integer page_size;
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
	public java.lang.String getNotes() {
		return this.notes;
	}

	public void setNotes(java.lang.String value) {
		this.notes = value;
	}	    	

	public String getCreate_time_begin() {
		return this.create_time_begin;
	}
	
	public void setCreate_time_begin(String value) {
		this.create_time_begin = value;
	}
	
	public String getCreate_time_end() {
		return this.create_time_end;
	}
	
	public void setCreate_time_end(String value) {
		this.create_time_end = value;
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

