package com.asiainfo.rms.workflow.dto.process.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author joker
 */
@ApiModel(description = "")
public class SysStationQueryPageDTO {
	
	@ApiModelProperty(value = "岗位主键(开始)")
	private java.lang.Long station_id_begin;
	
	@ApiModelProperty(value = "岗位主键(结束)")
	private java.lang.Long station_id_end;
	
	@ApiModelProperty(value = "岗位编码")
	private java.lang.String code;
	
	@ApiModelProperty(value = "岗位名称")
	private java.lang.String name;
	
	@ApiModelProperty(value = "岗位备注")
	private java.lang.String notes;
	
	@ApiModelProperty(value = "1正常 0注销(开始)")
	private Integer state_begin;
	
	@ApiModelProperty(value = "1正常 0注销(结束)")
	private Integer state_end;
	
	@ApiModelProperty(value = "岗位类型(开始)")
	private Integer type_begin;
	
	@ApiModelProperty(value = "岗位类型(结束)")
	private Integer type_end;
	
	@ApiModelProperty(value = "扩展字段1")
	private java.lang.String ext1;
	
	@ApiModelProperty(value = "扩展字段2")
	private java.lang.String ext2;
	
	@ApiModelProperty(value = "扩展字段3")
	private java.lang.String ext3;
	
	@ApiModelProperty(value = "岗位类型：1-数据岗位，2-流程岗位，3-功能权限(开始)")
	private Integer station_type_begin;
	
	@ApiModelProperty(value = "岗位类型：1-数据岗位，2-流程岗位，3-功能权限(结束)")
	private Integer station_type_end;
	
	@ApiModelProperty(value = "分页页码")
	private Integer page_no;
	
	@ApiModelProperty(value = "分页步长")
	private Integer page_size;
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
	public java.lang.String getCode() {
		return this.code;
	}

	public void setCode(java.lang.String value) {
		this.code = value;
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

