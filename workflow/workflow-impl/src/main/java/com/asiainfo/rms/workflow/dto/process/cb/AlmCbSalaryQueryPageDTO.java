package com.asiainfo.rms.workflow.dto.process.cb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author joker
 */
@ApiModel(description = "")
public class AlmCbSalaryQueryPageDTO {
	
	@ApiModelProperty(value = "主键(开始)")
	private Long s_id_begin;
	
	@ApiModelProperty(value = "主键(结束)")
	private Long s_id_end;
	
	@ApiModelProperty(value = "编码")
	private java.lang.String s_tag;
	
	@ApiModelProperty(value = "申请人主键(开始)")
	private Long apply_staff_id_begin;
	
	@ApiModelProperty(value = "申请人主键(结束)")
	private Long apply_staff_id_end;
	
	@ApiModelProperty(value = "所处环节(link_ID)(开始)")
	private Long cur_status_begin;
	
	@ApiModelProperty(value = "所处环节(link_ID)(结束)")
	private Long cur_status_end;
	
	@ApiModelProperty(value = "需求阶段(PHASE_ID)(开始)")
	private Long cur_phase_begin;
	
	@ApiModelProperty(value = "需求阶段(PHASE_ID)(结束)")
	private Long cur_phase_end;
	
	@ApiModelProperty(value = "分页页码")
	private Integer page_no;
	
	@ApiModelProperty(value = "分页步长")
	private Integer page_size;
	public Long getS_id_begin() {
		return this.s_id_begin;
	}
	
	public void setS_id_begin(Long value) {
		this.s_id_begin = value;
	}
	
	public Long getS_id_end() {
		return this.s_id_end;
	}
	
	public void setS_id_end(Long value) {
		this.s_id_end = value;
	}
	public java.lang.String getS_tag() {
		return this.s_tag;
	}

	public void setS_tag(java.lang.String value) {
		this.s_tag = value;
	}	    	
	public Long getApply_staff_id_begin() {
		return this.apply_staff_id_begin;
	}
	
	public void setApply_staff_id_begin(Long value) {
		this.apply_staff_id_begin = value;
	}
	
	public Long getApply_staff_id_end() {
		return this.apply_staff_id_end;
	}
	
	public void setApply_staff_id_end(Long value) {
		this.apply_staff_id_end = value;
	}
	public Long getCur_status_begin() {
		return this.cur_status_begin;
	}
	
	public void setCur_status_begin(Long value) {
		this.cur_status_begin = value;
	}
	
	public Long getCur_status_end() {
		return this.cur_status_end;
	}
	
	public void setCur_status_end(Long value) {
		this.cur_status_end = value;
	}
	public Long getCur_phase_begin() {
		return this.cur_phase_begin;
	}
	
	public void setCur_phase_begin(Long value) {
		this.cur_phase_begin = value;
	}
	
	public Long getCur_phase_end() {
		return this.cur_phase_end;
	}
	
	public void setCur_phase_end(Long value) {
		this.cur_phase_end = value;
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

