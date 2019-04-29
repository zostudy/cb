package com.asiainfo.rms.workflow.dto.process.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author joker
 */
@ApiModel(description = "")
public class AlmWorkorderListQueryPageDTO {
	
	@ApiModelProperty(value = "(开始)")
	private java.lang.Long order_id_begin;
	
	@ApiModelProperty(value = "(结束)")
	private java.lang.Long order_id_end;
	
	@ApiModelProperty(value = "")
	private java.lang.String obj_type;
	
	@ApiModelProperty(value = "")
	private java.lang.String vm_task_name;
	
	@ApiModelProperty(value = "")
	private java.lang.String link_no;
	
	@ApiModelProperty(value = "(开始)")
	private java.lang.Long link_id_begin;
	
	@ApiModelProperty(value = "(结束)")
	private java.lang.Long link_id_end;
	
	@ApiModelProperty(value = "环节编码")
	private java.lang.String link_ids;
	
	@ApiModelProperty(value = "(开始)")
	private java.lang.Long exec_staff_id_begin;
	
	@ApiModelProperty(value = "(结束)")
	private java.lang.Long exec_staff_id_end;
	
	@ApiModelProperty(value = "")
	private java.lang.String exec_staff_code;
	
	@ApiModelProperty(value = "")
	private java.lang.String exec_employee_name;
	
	@ApiModelProperty(value = "")
	private java.lang.String lock_opinion;
	
	@ApiModelProperty(value = "(开始)")
	private String create_time_begin;
	
	@ApiModelProperty(value = "(结束)")
	private String create_time_end;
	
	@ApiModelProperty(value = "(开始)")
	private String finish_time_begin;
	
	@ApiModelProperty(value = "(结束)")
	private String finish_time_end;
	
	@ApiModelProperty(value = "")
	private java.lang.String order_type;
	
	@ApiModelProperty(value = "")
	private java.lang.String cond;
	
	@ApiModelProperty(value = "")
	private java.lang.String result;
	
	@ApiModelProperty(value = "")
	private java.lang.String status;
	
	@ApiModelProperty(value = "")
	private java.lang.String opinion;
	
	@ApiModelProperty(value = "")
	private java.lang.String next_link_plantime;
	
	@ApiModelProperty(value = "(开始)")
	private java.lang.Long proc_inst_id_begin;
	
	@ApiModelProperty(value = "(结束)")
	private java.lang.Long proc_inst_id_end;
	
	@ApiModelProperty(value = "(开始)")
	private java.lang.Long last_order_id_begin;
	
	@ApiModelProperty(value = "(结束)")
	private java.lang.Long last_order_id_end;
	
	@ApiModelProperty(value = "(开始)")
	private Long remine_time_begin;
	
	@ApiModelProperty(value = "(结束)")
	private Long remine_time_end;
	
	@ApiModelProperty(value = "")
	private java.lang.String phase_id;
	
	@ApiModelProperty(value = "(开始)")
	private Long time_consum_begin;
	
	@ApiModelProperty(value = "(结束)")
	private Long time_consum_end;
	
	@ApiModelProperty(value = "(开始)")
	private Long obj_id_begin;
	
	@ApiModelProperty(value = "(结束)")
	private Long obj_id_end;
	
	@ApiModelProperty(value = "")
	private java.lang.String obj_tag;
	
	@ApiModelProperty(value = "(开始)")
	private Long apply_staff_id_begin;
	
	@ApiModelProperty(value = "(结束)")
	private Long apply_staff_id_end;
	
	@ApiModelProperty(value = "")
	private java.lang.String apply_staff_name;
	
	@ApiModelProperty(value = "")
	private java.lang.String apply_staff_code;
	
	@ApiModelProperty(value = "分页页码")
	private Integer page_no;
	
	@ApiModelProperty(value = "分页步长")
	private Integer page_size;
	public java.lang.String getLink_ids() {
		return link_ids;
	}

	public void setLink_ids(java.lang.String link_ids) {
		this.link_ids = link_ids;
	}

	public java.lang.Long getOrder_id_begin() {
		return this.order_id_begin;
	}
	
	public void setOrder_id_begin(java.lang.Long value) {
		this.order_id_begin = value;
	}
	
	public java.lang.Long getOrder_id_end() {
		return this.order_id_end;
	}
	
	public void setOrder_id_end(java.lang.Long value) {
		this.order_id_end = value;
	}
	public java.lang.String getObj_type() {
		return this.obj_type;
	}

	public void setObj_type(java.lang.String value) {
		this.obj_type = value;
	}	    	
	public java.lang.String getVm_task_name() {
		return this.vm_task_name;
	}

	public void setVm_task_name(java.lang.String value) {
		this.vm_task_name = value;
	}	    	
	public java.lang.String getLink_no() {
		return this.link_no;
	}

	public void setLink_no(java.lang.String value) {
		this.link_no = value;
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
	public java.lang.Long getExec_staff_id_begin() {
		return this.exec_staff_id_begin;
	}
	
	public void setExec_staff_id_begin(java.lang.Long value) {
		this.exec_staff_id_begin = value;
	}
	
	public java.lang.Long getExec_staff_id_end() {
		return this.exec_staff_id_end;
	}
	
	public void setExec_staff_id_end(java.lang.Long value) {
		this.exec_staff_id_end = value;
	}
	public java.lang.String getExec_staff_code() {
		return this.exec_staff_code;
	}

	public void setExec_staff_code(java.lang.String value) {
		this.exec_staff_code = value;
	}	    	
	public java.lang.String getExec_employee_name() {
		return this.exec_employee_name;
	}

	public void setExec_employee_name(java.lang.String value) {
		this.exec_employee_name = value;
	}	    	
	public java.lang.String getLock_opinion() {
		return this.lock_opinion;
	}

	public void setLock_opinion(java.lang.String value) {
		this.lock_opinion = value;
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

	public String getFinish_time_begin() {
		return this.finish_time_begin;
	}
	
	public void setFinish_time_begin(String value) {
		this.finish_time_begin = value;
	}
	
	public String getFinish_time_end() {
		return this.finish_time_end;
	}
	
	public void setFinish_time_end(String value) {
		this.finish_time_end = value;
	}
	public java.lang.String getOrder_type() {
		return this.order_type;
	}

	public void setOrder_type(java.lang.String value) {
		this.order_type = value;
	}	    	
	public java.lang.String getCond() {
		return this.cond;
	}

	public void setCond(java.lang.String value) {
		this.cond = value;
	}	    	
	public java.lang.String getResult() {
		return this.result;
	}

	public void setResult(java.lang.String value) {
		this.result = value;
	}	    	
	public java.lang.String getStatus() {
		return this.status;
	}

	public void setStatus(java.lang.String value) {
		this.status = value;
	}	    	
	public java.lang.String getOpinion() {
		return this.opinion;
	}

	public void setOpinion(java.lang.String value) {
		this.opinion = value;
	}	    	
	public java.lang.String getNext_link_plantime() {
		return this.next_link_plantime;
	}

	public void setNext_link_plantime(java.lang.String value) {
		this.next_link_plantime = value;
	}	    	
	public java.lang.Long getProc_inst_id_begin() {
		return this.proc_inst_id_begin;
	}
	
	public void setProc_inst_id_begin(java.lang.Long value) {
		this.proc_inst_id_begin = value;
	}
	
	public java.lang.Long getProc_inst_id_end() {
		return this.proc_inst_id_end;
	}
	
	public void setProc_inst_id_end(java.lang.Long value) {
		this.proc_inst_id_end = value;
	}
	public java.lang.Long getLast_order_id_begin() {
		return this.last_order_id_begin;
	}
	
	public void setLast_order_id_begin(java.lang.Long value) {
		this.last_order_id_begin = value;
	}
	
	public java.lang.Long getLast_order_id_end() {
		return this.last_order_id_end;
	}
	
	public void setLast_order_id_end(java.lang.Long value) {
		this.last_order_id_end = value;
	}
	public Long getRemine_time_begin() {
		return this.remine_time_begin;
	}
	
	public void setRemine_time_begin(Long value) {
		this.remine_time_begin = value;
	}
	
	public Long getRemine_time_end() {
		return this.remine_time_end;
	}
	
	public void setRemine_time_end(Long value) {
		this.remine_time_end = value;
	}
	public java.lang.String getPhase_id() {
		return this.phase_id;
	}

	public void setPhase_id(java.lang.String value) {
		this.phase_id = value;
	}	    	
	public Long getTime_consum_begin() {
		return this.time_consum_begin;
	}
	
	public void setTime_consum_begin(Long value) {
		this.time_consum_begin = value;
	}
	
	public Long getTime_consum_end() {
		return this.time_consum_end;
	}
	
	public void setTime_consum_end(Long value) {
		this.time_consum_end = value;
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
	public java.lang.String getApply_staff_name() {
		return this.apply_staff_name;
	}

	public void setApply_staff_name(java.lang.String value) {
		this.apply_staff_name = value;
	}	    	
	public java.lang.String getApply_staff_code() {
		return this.apply_staff_code;
	}

	public void setApply_staff_code(java.lang.String value) {
		this.apply_staff_code = value;
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

