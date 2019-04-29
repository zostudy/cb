package com.asiainfo.rms.workflow.dto.process.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author joker
 */
@ApiModel(description = "")
public class AlmSysParamQueryPageDTO {
	
	@ApiModelProperty(value = "参数类型")
	private java.lang.String param_type;
	
	@ApiModelProperty(value = "参数ID(开始)")
	private java.lang.Long param_id_begin;
	
	@ApiModelProperty(value = "参数ID(结束)")
	private java.lang.Long param_id_end;
	
	@ApiModelProperty(value = "参数编号")
	private java.lang.String param_no;
	
	@ApiModelProperty(value = "参数名称")
	private java.lang.String param_name;
	
	@ApiModelProperty(value = "参数描述")
	private java.lang.String param_disc;
	
	@ApiModelProperty(value = "默认为 父关系 PARAM_ID(开始)")
	private java.lang.Long param_rela_id_begin;
	
	@ApiModelProperty(value = "默认为 父关系 PARAM_ID(结束)")
	private java.lang.Long param_rela_id_end;
	
	@ApiModelProperty(value = "参数值(开始)")
	private Integer param_value_begin;
	
	@ApiModelProperty(value = "参数值(结束)")
	private Integer param_value_end;
	
	@ApiModelProperty(value = "参数排序，以sort_id的值的大小作为排次序。缺省值为0(开始)")
	private Integer sort_id_begin;
	
	@ApiModelProperty(value = "参数排序，以sort_id的值的大小作为排次序。缺省值为0(结束)")
	private Integer sort_id_end;
	
	@ApiModelProperty(value = "分页页码")
	private Integer page_no;
	
	@ApiModelProperty(value = "分页步长")
	private Integer page_size;
	public java.lang.String getParam_type() {
		return this.param_type;
	}

	public void setParam_type(java.lang.String value) {
		this.param_type = value;
	}	    	
	public java.lang.Long getParam_id_begin() {
		return this.param_id_begin;
	}
	
	public void setParam_id_begin(java.lang.Long value) {
		this.param_id_begin = value;
	}
	
	public java.lang.Long getParam_id_end() {
		return this.param_id_end;
	}
	
	public void setParam_id_end(java.lang.Long value) {
		this.param_id_end = value;
	}
	public java.lang.String getParam_no() {
		return this.param_no;
	}

	public void setParam_no(java.lang.String value) {
		this.param_no = value;
	}	    	
	public java.lang.String getParam_name() {
		return this.param_name;
	}

	public void setParam_name(java.lang.String value) {
		this.param_name = value;
	}	    	
	public java.lang.String getParam_disc() {
		return this.param_disc;
	}

	public void setParam_disc(java.lang.String value) {
		this.param_disc = value;
	}	    	
	public java.lang.Long getParam_rela_id_begin() {
		return this.param_rela_id_begin;
	}
	
	public void setParam_rela_id_begin(java.lang.Long value) {
		this.param_rela_id_begin = value;
	}
	
	public java.lang.Long getParam_rela_id_end() {
		return this.param_rela_id_end;
	}
	
	public void setParam_rela_id_end(java.lang.Long value) {
		this.param_rela_id_end = value;
	}
	public Integer getParam_value_begin() {
		return this.param_value_begin;
	}
	
	public void setParam_value_begin(Integer value) {
		this.param_value_begin = value;
	}
	
	public Integer getParam_value_end() {
		return this.param_value_end;
	}
	
	public void setParam_value_end(Integer value) {
		this.param_value_end = value;
	}
	public Integer getSort_id_begin() {
		return this.sort_id_begin;
	}
	
	public void setSort_id_begin(Integer value) {
		this.sort_id_begin = value;
	}
	
	public Integer getSort_id_end() {
		return this.sort_id_end;
	}
	
	public void setSort_id_end(Integer value) {
		this.sort_id_end = value;
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

