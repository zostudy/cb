package com.asiainfo.rms.workflow.dto.process.cb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author joker
 */
@ApiModel(description = "")
public class AlmCbSalaryDTO {
	
	@ApiModelProperty(value = "主键")
	private Long sid;
	
	@ApiModelProperty(value = "编码")
	private java.lang.String stag;
	
	@ApiModelProperty(value = "申请人主键")
	private Long applyStaffId;
	
	@ApiModelProperty(value = "所处环节(link_ID)")
	private Long curStatus;
	
	@ApiModelProperty(value = "需求阶段(PHASE_ID)")
	private Long curPhase;
	
	public void setSid(Long value) {
		this.sid = value;
	}
	
	public Long getSid() {
		return this.sid;
	}	    
	
	public java.lang.String getStag() {
		return this.stag;
	}
	
	public void setStag(java.lang.String value) {
		this.stag = value;
	}
	
	public Long getApplyStaffId() {
		return this.applyStaffId;
	}
	
	public void setApplyStaffId(Long value) {
		this.applyStaffId = value;
	}
	
	public Long getCurStatus() {
		return this.curStatus;
	}
	
	public void setCurStatus(Long value) {
		this.curStatus = value;
	}
	
	public Long getCurPhase() {
		return this.curPhase;
	}
	
	public void setCurPhase(Long value) {
		this.curPhase = value;
	}
}

