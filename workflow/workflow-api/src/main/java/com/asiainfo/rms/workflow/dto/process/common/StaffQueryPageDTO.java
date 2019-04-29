package com.asiainfo.rms.workflow.dto.process.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author joker
 */
@ApiModel(description = "")
public class StaffQueryPageDTO {
	
	@ApiModelProperty(value = "(开始)")
	private Long author_id_begin;
	
	@ApiModelProperty(value = "(结束)")
	private Long author_id_end;
	
	@ApiModelProperty(value = "(开始)")
	private Long station_id_begin;
	
	@ApiModelProperty(value = "(结束)")
	private Long station_id_end;
	
	@ApiModelProperty(value = "(开始)")
	private Integer state_begin;
	
	@ApiModelProperty(value = "(结束)")
	private Integer state_end;
	
	@ApiModelProperty(value = "")
	private String notes;
	
	@ApiModelProperty(value = "(开始)")
	private String create_time_begin;
	
	@ApiModelProperty(value = "(结束)")
	private String create_time_end;
	
	@ApiModelProperty(value = "(开始)")
	private String end_time_begin;
	
	@ApiModelProperty(value = "(结束)")
	private String end_time_end;
	
	@ApiModelProperty(value = "(开始)")
	private Long staff_id_begin;
	
	@ApiModelProperty(value = "(结束)")
	private Long staff_id_end;
	
	@ApiModelProperty(value = "")
	private String employee_name;
	
	@ApiModelProperty(value = "")
	private String station_name;
	
	@ApiModelProperty(value = "分页页码")
	private Integer page_no;
	
	@ApiModelProperty(value = "分页步长")
	private Integer page_size;
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
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String value) {
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

	public String getEnd_time_begin() {
		return this.end_time_begin;
	}
	
	public void setEnd_time_begin(String value) {
		this.end_time_begin = value;
	}
	
	public String getEnd_time_end() {
		return this.end_time_end;
	}
	
	public void setEnd_time_end(String value) {
		this.end_time_end = value;
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
	public String getEmployee_name() {
		return this.employee_name;
	}

	public void setEmployee_name(String value) {
		this.employee_name = value;
	}	    	
	public String getStation_name() {
		return this.station_name;
	}

	public void setStation_name(String value) {
		this.station_name = value;
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

