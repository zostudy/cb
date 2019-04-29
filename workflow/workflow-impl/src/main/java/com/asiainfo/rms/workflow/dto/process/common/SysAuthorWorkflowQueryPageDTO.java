package com.asiainfo.rms.workflow.dto.process.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 岗位与工作流关联表
 * 
 * @author joker
 */
@ApiModel(description = "岗位与工作流关联表")
public class SysAuthorWorkflowQueryPageDTO {
	
	@ApiModelProperty(value = "主键(开始)")
	private Long saw_id_begin;
	
	@ApiModelProperty(value = "主键(结束)")
	private Long saw_id_end;
	
	@ApiModelProperty(value = "员工主键(开始)")
	private Long staff_id_begin;
	
	@ApiModelProperty(value = "员工主键(结束)")
	private Long staff_id_end;
	
	@ApiModelProperty(value = "工号")
	private java.lang.String code;
	
	@ApiModelProperty(value = "雇员名称")
	private java.lang.String employee_name;
	
	@ApiModelProperty(value = "手机号码")
	private java.lang.String bill_id;
	
	@ApiModelProperty(value = "组织ID(开始)")
	private java.lang.Long organize_id_begin;
	
	@ApiModelProperty(value = "组织ID(结束)")
	private java.lang.Long organize_id_end;
	
	@ApiModelProperty(value = "组织名称")
	private java.lang.String organize_name;
	
	@ApiModelProperty(value = "组织类型(开始)")
	private Integer org_type_begin;
	
	@ApiModelProperty(value = "组织类型(结束)")
	private Integer org_type_end;
	
	@ApiModelProperty(value = "创建时间(开始)")
	private String create_date_begin;
	
	@ApiModelProperty(value = "创建时间(结束)")
	private String create_date_end;
	
	@ApiModelProperty(value = "结束时间(开始)")
	private String end_date_begin;
	
	@ApiModelProperty(value = "结束时间(结束)")
	private String end_date_end;
	
	@ApiModelProperty(value = "岗位主键(开始)")
	private java.lang.Long station_id_begin;
	
	@ApiModelProperty(value = "岗位主键(结束)")
	private java.lang.Long station_id_end;
	
	@ApiModelProperty(value = "岗位名称")
	private java.lang.String name;
	
	@ApiModelProperty(value = "岗位备注")
	private java.lang.String notes;
	
	@ApiModelProperty(value = "流程类型")
	private java.lang.String obj_type;
	
	@ApiModelProperty(value = "流程实例主键(开始)")
	private Long obj_id_begin;
	
	@ApiModelProperty(value = "流程实例主键(结束)")
	private Long obj_id_end;
	
	@ApiModelProperty(value = "环节编码(开始)")
	private java.lang.Long link_id_begin;
	
	@ApiModelProperty(value = "环节编码(结束)")
	private java.lang.Long link_id_end;
	
	@ApiModelProperty(value = "环节编号")
	private java.lang.String link_no;
	
	@ApiModelProperty(value = "阶段编号")
	private java.lang.String phase_id;
	
	@ApiModelProperty(value = "阶段名称")
	private java.lang.String phase_name;
	
	@ApiModelProperty(value = "流程实例编码")
	private java.lang.String obj_tag;
	
	@ApiModelProperty(value = "岗位薪资")
	private java.lang.String station_money;
	
	@ApiModelProperty(value = "总数量")
	private java.lang.String station_amount;
	
	@ApiModelProperty(value = "总金额")
	private java.lang.String station_aggregate;
	
	@ApiModelProperty(value = "岗位类型(平分,独享)(开始)")
	private Integer type_begin;
	
	@ApiModelProperty(value = "岗位类型(平分,独享)(结束)")
	private Integer type_end;
	
	@ApiModelProperty(value = "岗位人数")
	private java.lang.String station_people;
	
	@ApiModelProperty(value = "分页页码")
	private Integer page_no;
	
	@ApiModelProperty(value = "分页步长")
	private Integer page_size;
	public Long getSaw_id_begin() {
		return this.saw_id_begin;
	}
	
	public void setSaw_id_begin(Long value) {
		this.saw_id_begin = value;
	}
	
	public Long getSaw_id_end() {
		return this.saw_id_end;
	}
	
	public void setSaw_id_end(Long value) {
		this.saw_id_end = value;
	}
	public Long getStaff_id_begin() {
		return this.staff_id_begin;
	}
	
	public void setStaff_id_begin(Long value) {
		this.staff_id_begin = value;
	}
	
	public Long getStaff_id_end() {
		return this.staff_id_end;
	}
	
	public void setStaff_id_end(Long value) {
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

	public String getEnd_date_begin() {
		return this.end_date_begin;
	}
	
	public void setEnd_date_begin(String value) {
		this.end_date_begin = value;
	}
	
	public String getEnd_date_end() {
		return this.end_date_end;
	}
	
	public void setEnd_date_end(String value) {
		this.end_date_end = value;
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
	public java.lang.String getName() {
		return this.name;
	}

	public void setName(java.lang.String value) {
		this.name = value;
	}	    	
	public java.lang.String getNotes() {
		return this.notes;
	}

	public void setNotes(java.lang.String value) {
		this.notes = value;
	}	    	
	public java.lang.String getObj_type() {
		return this.obj_type;
	}

	public void setObj_type(java.lang.String value) {
		this.obj_type = value;
	}	    	
	public Long getObj_id_begin() {
		return this.obj_id_begin;
	}
	
	public void setObj_id_begin(Long value) {
		this.obj_id_begin = value;
	}
	
	public Long getObj_id_end() {
		return this.obj_id_end;
	}
	
	public void setObj_id_end(Long value) {
		this.obj_id_end = value;
	}
	public java.lang.Long getLink_id_begin() {
		return this.link_id_begin;
	}
	
	public void setLink_id_begin(java.lang.Long value) {
		this.link_id_begin = value;
	}
	
	public java.lang.Long getLink_id_end() {
		return this.link_id_end;
	}
	
	public void setLink_id_end(java.lang.Long value) {
		this.link_id_end = value;
	}
	public java.lang.String getLink_no() {
		return this.link_no;
	}

	public void setLink_no(java.lang.String value) {
		this.link_no = value;
	}	    	
	public java.lang.String getPhase_id() {
		return this.phase_id;
	}

	public void setPhase_id(java.lang.String value) {
		this.phase_id = value;
	}	    	
	public java.lang.String getPhase_name() {
		return this.phase_name;
	}

	public void setPhase_name(java.lang.String value) {
		this.phase_name = value;
	}	    	
	public java.lang.String getObj_tag() {
		return this.obj_tag;
	}

	public void setObj_tag(java.lang.String value) {
		this.obj_tag = value;
	}	    	
	public java.lang.String getStation_money() {
		return this.station_money;
	}

	public void setStation_money(java.lang.String value) {
		this.station_money = value;
	}	    	
	public java.lang.String getStation_amount() {
		return this.station_amount;
	}

	public void setStation_amount(java.lang.String value) {
		this.station_amount = value;
	}	    	
	public java.lang.String getStation_aggregate() {
		return this.station_aggregate;
	}

	public void setStation_aggregate(java.lang.String value) {
		this.station_aggregate = value;
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
	public java.lang.String getStation_people() {
		return this.station_people;
	}

	public void setStation_people(java.lang.String value) {
		this.station_people = value;
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

