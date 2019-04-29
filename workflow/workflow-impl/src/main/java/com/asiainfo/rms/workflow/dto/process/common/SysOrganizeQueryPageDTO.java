package com.asiainfo.rms.workflow.dto.process.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author joker
 */
@ApiModel(description = "")
public class SysOrganizeQueryPageDTO {
	
	@ApiModelProperty(value = "组织ID(开始)")
	private java.lang.Long organize_id_begin;
	
	@ApiModelProperty(value = "组织ID(结束)")
	private java.lang.Long organize_id_end;
	
	@ApiModelProperty(value = "父组织ID(开始)")
	private java.lang.Long parent_organize_id_begin;
	
	@ApiModelProperty(value = "父组织ID(结束)")
	private java.lang.Long parent_organize_id_end;
	
	@ApiModelProperty(value = "组织名称")
	private java.lang.String organize_name;
	
	@ApiModelProperty(value = "组织编码")
	private java.lang.String code;
	
	@ApiModelProperty(value = "组织类型(开始)")
	private Integer org_type_begin;
	
	@ApiModelProperty(value = "组织类型(结束)")
	private Integer org_type_end;
	
	@ApiModelProperty(value = "备注")
	private java.lang.String notes;
	
	@ApiModelProperty(value = "状态(开始)")
	private Integer state_begin;
	
	@ApiModelProperty(value = "状态(结束)")
	private Integer state_end;
	
	@ApiModelProperty(value = "创建时间(开始)")
	private String create_date_begin;
	
	@ApiModelProperty(value = "创建时间(结束)")
	private String create_date_end;
	
	@ApiModelProperty(value = "附录一")
	private java.lang.String ext1;
	
	@ApiModelProperty(value = "附录二")
	private java.lang.String ext2;
	
	@ApiModelProperty(value = "附录三")
	private java.lang.String ext3;
	
	@ApiModelProperty(value = "组织类型(开始)")
	private Long organize_type_id_begin;
	
	@ApiModelProperty(value = "组织类型(结束)")
	private Long organize_type_id_end;
	
	@ApiModelProperty(value = "父组织编码")
	private java.lang.String parent_code;
	
	@ApiModelProperty(value = "分页页码")
	private Integer page_no;
	
	@ApiModelProperty(value = "分页步长")
	private Integer page_size;
	
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
	public java.lang.Long getParent_organize_id_begin() {
		return this.parent_organize_id_begin;
	}
	
	public void setParent_organize_id_begin(java.lang.Long value) {
		this.parent_organize_id_begin = value;
	}
	
	public java.lang.Long getParent_organize_id_end() {
		return this.parent_organize_id_end;
	}
	
	public void setParent_organize_id_end(java.lang.Long value) {
		this.parent_organize_id_end = value;
	}
	public java.lang.String getOrganize_name() {
		return this.organize_name;
	}

	public void setOrganize_name(java.lang.String value) {
		this.organize_name = value;
	}	    	
	public java.lang.String getCode() {
		return this.code;
	}

	public void setCode(java.lang.String value) {
		this.code = value;
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
	public java.lang.String getNotes() {
		return this.notes;
	}

	public void setNotes(java.lang.String value) {
		this.notes = value;
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

	public String getCreate_date_begin() {
		return this.create_date_begin;
	}
	
	public void setCreate_date_begin(String value) {
		this.create_date_begin = value;
	}
	
	public String getCreate_date_end() {
		return this.create_date_end;
	}
	
	public void setCreate_date_end(String value) {
		this.create_date_end = value;
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
	public Long getOrganize_type_id_begin() {
		return this.organize_type_id_begin;
	}
	
	public void setOrganize_type_id_begin(Long value) {
		this.organize_type_id_begin = value;
	}
	
	public Long getOrganize_type_id_end() {
		return this.organize_type_id_end;
	}
	
	public void setOrganize_type_id_end(Long value) {
		this.organize_type_id_end = value;
	}
	public java.lang.String getParent_code() {
		return this.parent_code;
	}

	public void setParent_code(java.lang.String value) {
		this.parent_code = value;
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

