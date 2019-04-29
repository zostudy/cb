package com.asiainfo.rms.workflow.dto.process.cb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 详情表
 * 
 * @author joker
 */
@ApiModel(description = "详情表")
public class AlmCbFlowHisQueryPageDTO {
	
	@ApiModelProperty(value = "历史流水主键(开始)")
	private Long his_flow_id_begin;
	
	@ApiModelProperty(value = "历史流水主键(结束)")
	private Long his_flow_id_end;
	
	@ApiModelProperty(value = "流水主键(开始)")
	private Long flow_id_begin;
	
	@ApiModelProperty(value = "流水主键(结束)")
	private Long flow_id_end;
	
	@ApiModelProperty(value = "员工主键(开始)")
	private Long staff_id_begin;
	
	@ApiModelProperty(value = "员工主键(结束)")
	private Long staff_id_end;
	
	@ApiModelProperty(value = "雇员名称")
	private java.lang.String staff_name;
	
	@ApiModelProperty(value = "组织主键(开始)")
	private Long organize_id_begin;
	
	@ApiModelProperty(value = "组织主键(结束)")
	private Long organize_id_end;
	
	@ApiModelProperty(value = "组织名称")
	private java.lang.String organize_name;
	
	@ApiModelProperty(value = "组织权限(开始)")
	private Integer organize_type_begin;
	
	@ApiModelProperty(value = "组织权限(结束)")
	private Integer organize_type_end;
	
	@ApiModelProperty(value = "岗位主键(开始)")
	private Long station_id_begin;
	
	@ApiModelProperty(value = "岗位主键(结束)")
	private Long station_id_end;
	
	@ApiModelProperty(value = "岗位金额")
	private java.lang.String station_code;
	
	@ApiModelProperty(value = "岗位名称")
	private java.lang.String station_name;
	
	@ApiModelProperty(value = "岗位备注")
	private java.lang.String station_notes;
	
	@ApiModelProperty(value = "岗位类型(开始)")
	private Integer station_type_begin;
	
	@ApiModelProperty(value = "岗位类型(结束)")
	private Integer station_type_end;
	
	@ApiModelProperty(value = "岗位权限(开始)")
	private Integer station_private_type_begin;
	
	@ApiModelProperty(value = "岗位权限(结束)")
	private Integer station_private_type_end;
	
	@ApiModelProperty(value = "关系主键(开始)")
	private Long author_id_begin;
	
	@ApiModelProperty(value = "关系主键(结束)")
	private Long author_id_end;
	
	@ApiModelProperty(value = "岗位关系备注干湿")
	private java.lang.String author_notes;
	
	@ApiModelProperty(value = "流程主键(开始)")
	private Long obj_id_begin;
	
	@ApiModelProperty(value = "流程主键(结束)")
	private Long obj_id_end;
	
	@ApiModelProperty(value = "流程编码")
	private java.lang.String obj_tag;
	
	@ApiModelProperty(value = "流程金额")
	private java.lang.String obj_account;
	
	@ApiModelProperty(value = "流程公式")
	private java.lang.String obj_formula;
	
	@ApiModelProperty(value = "流程数量")
	private java.lang.String obj_amount;
	
	@ApiModelProperty(value = "流程人数")
	private java.lang.String obj_staff;
	
	@ApiModelProperty(value = "创建时间(开始)")
	private String create_time_begin;
	
	@ApiModelProperty(value = "创建时间(结束)")
	private String create_time_end;
	
	@ApiModelProperty(value = "申请人主键(开始)")
	private Long appaly_staff_id_begin;
	
	@ApiModelProperty(value = "申请人主键(结束)")
	private Long appaly_staff_id_end;
	
	@ApiModelProperty(value = "申请人名称")
	private java.lang.String appaly_staff_name;
	
	@ApiModelProperty(value = "申请人帐号")
	private java.lang.String appaly_staff_code;
	
	@ApiModelProperty(value = "分页页码")
	private Integer page_no;
	
	@ApiModelProperty(value = "分页步长")
	private Integer page_size;
	
	public Long getHis_flow_id_begin() {
		return this.his_flow_id_begin;
	}
	
	public void setHis_flow_id_begin(Long value) {
		this.his_flow_id_begin = value;
	}
	
	public Long getHis_flow_id_end() {
		return this.his_flow_id_end;
	}
	
	public void setHis_flow_id_end(Long value) {
		this.his_flow_id_end = value;
	}
	public Long getFlow_id_begin() {
		return this.flow_id_begin;
	}
	
	public void setFlow_id_begin(Long value) {
		this.flow_id_begin = value;
	}
	
	public Long getFlow_id_end() {
		return this.flow_id_end;
	}
	
	public void setFlow_id_end(Long value) {
		this.flow_id_end = value;
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
	public java.lang.String getStaff_name() {
		return this.staff_name;
	}

	public void setStaff_name(java.lang.String value) {
		this.staff_name = value;
	}	    	
	public Long getOrganize_id_begin() {
		return this.organize_id_begin;
	}
	
	public void setOrganize_id_begin(Long value) {
		this.organize_id_begin = value;
	}
	
	public Long getOrganize_id_end() {
		return this.organize_id_end;
	}
	
	public void setOrganize_id_end(Long value) {
		this.organize_id_end = value;
	}
	public java.lang.String getOrganize_name() {
		return this.organize_name;
	}

	public void setOrganize_name(java.lang.String value) {
		this.organize_name = value;
	}	    	
	public Integer getOrganize_type_begin() {
		return this.organize_type_begin;
	}
	
	public void setOrganize_type_begin(Integer value) {
		this.organize_type_begin = value;
	}
	
	public Integer getOrganize_type_end() {
		return this.organize_type_end;
	}
	
	public void setOrganize_type_end(Integer value) {
		this.organize_type_end = value;
	}
	public Long getStation_id_begin() {
		return this.station_id_begin;
	}
	
	public void setStation_id_begin(Long value) {
		this.station_id_begin = value;
	}
	
	public Long getStation_id_end() {
		return this.station_id_end;
	}
	
	public void setStation_id_end(Long value) {
		this.station_id_end = value;
	}
	public java.lang.String getStation_code() {
		return this.station_code;
	}

	public void setStation_code(java.lang.String value) {
		this.station_code = value;
	}	    	
	public java.lang.String getStation_name() {
		return this.station_name;
	}

	public void setStation_name(java.lang.String value) {
		this.station_name = value;
	}	    	
	public java.lang.String getStation_notes() {
		return this.station_notes;
	}

	public void setStation_notes(java.lang.String value) {
		this.station_notes = value;
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
	public Integer getStation_private_type_begin() {
		return this.station_private_type_begin;
	}
	
	public void setStation_private_type_begin(Integer value) {
		this.station_private_type_begin = value;
	}
	
	public Integer getStation_private_type_end() {
		return this.station_private_type_end;
	}
	
	public void setStation_private_type_end(Integer value) {
		this.station_private_type_end = value;
	}
	public Long getAuthor_id_begin() {
		return this.author_id_begin;
	}
	
	public void setAuthor_id_begin(Long value) {
		this.author_id_begin = value;
	}
	
	public Long getAuthor_id_end() {
		return this.author_id_end;
	}
	
	public void setAuthor_id_end(Long value) {
		this.author_id_end = value;
	}
	public java.lang.String getAuthor_notes() {
		return this.author_notes;
	}

	public void setAuthor_notes(java.lang.String value) {
		this.author_notes = value;
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
	public java.lang.String getObj_tag() {
		return this.obj_tag;
	}

	public void setObj_tag(java.lang.String value) {
		this.obj_tag = value;
	}	    	
	public java.lang.String getObj_account() {
		return this.obj_account;
	}

	public void setObj_account(java.lang.String value) {
		this.obj_account = value;
	}	    	
	public java.lang.String getObj_formula() {
		return this.obj_formula;
	}

	public void setObj_formula(java.lang.String value) {
		this.obj_formula = value;
	}	    	
	public java.lang.String getObj_amount() {
		return this.obj_amount;
	}

	public void setObj_amount(java.lang.String value) {
		this.obj_amount = value;
	}	    	
	public java.lang.String getObj_staff() {
		return this.obj_staff;
	}

	public void setObj_staff(java.lang.String value) {
		this.obj_staff = value;
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
	public Long getAppaly_staff_id_begin() {
		return this.appaly_staff_id_begin;
	}
	
	public void setAppaly_staff_id_begin(Long value) {
		this.appaly_staff_id_begin = value;
	}
	
	public Long getAppaly_staff_id_end() {
		return this.appaly_staff_id_end;
	}
	
	public void setAppaly_staff_id_end(Long value) {
		this.appaly_staff_id_end = value;
	}
	public java.lang.String getAppaly_staff_name() {
		return this.appaly_staff_name;
	}

	public void setAppaly_staff_name(java.lang.String value) {
		this.appaly_staff_name = value;
	}	    	
	public java.lang.String getAppaly_staff_code() {
		return this.appaly_staff_code;
	}

	public void setAppaly_staff_code(java.lang.String value) {
		this.appaly_staff_code = value;
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

