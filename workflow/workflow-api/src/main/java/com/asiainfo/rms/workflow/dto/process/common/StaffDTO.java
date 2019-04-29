package com.asiainfo.rms.workflow.dto.process.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author joker
 */
@ApiModel(description = "")
public class StaffDTO {
	
	@ApiModelProperty(value = "")
	private Long authorId;
	
	@ApiModelProperty(value = "")
	private Long stationId;
	
	@ApiModelProperty(value = "")
	private Integer state;
	
	@ApiModelProperty(value = "")
	private String notes;
	
	@ApiModelProperty(value = "")
	private java.util.Date createTime;
	
	@ApiModelProperty(value = "")
	private java.util.Date endTime;
	
	@ApiModelProperty(value = "")
	private Long staffId;
	
	@ApiModelProperty(value = "")
	private String employeeName;
	
	@ApiModelProperty(value = "")
	private String stationName;
	
	public void setAuthorId(Long value) {
		this.authorId = value;
	}
	
	public Long getAuthorId() {
		return this.authorId;
	}	    
	
	public Long getStationId() {
		return this.stationId;
	}
	
	public void setStationId(Long value) {
		this.stationId = value;
	}
	
	public Integer getState() {
		return this.state;
	}
	
	public void setState(Integer value) {
		this.state = value;
	}
	
	public String getNotes() {
		return this.notes;
	}
	
	public void setNotes(String value) {
		this.notes = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getEndTime() {
		return this.endTime;
	}
	
	public void setEndTime(java.util.Date value) {
		this.endTime = value;
	}
	
	public Long getStaffId() {
		return this.staffId;
	}
	
	public void setStaffId(Long value) {
		this.staffId = value;
	}
	
	public String getEmployeeName() {
		return this.employeeName;
	}
	
	public void setEmployeeName(String value) {
		this.employeeName = value;
	}
	
	public String getStationName() {
		return this.stationName;
	}
	
	public void setStationName(String value) {
		this.stationName = value;
	}
}

