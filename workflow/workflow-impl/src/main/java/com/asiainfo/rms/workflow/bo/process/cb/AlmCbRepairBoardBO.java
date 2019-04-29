package com.asiainfo.rms.workflow.bo.process.cb;

/**
 * 
 * 
 * @author joker
 */
public class AlmCbRepairBoardBO {
	
	/**
	 * 主键
	 */
	private Long rbId;
	
	/**
	 * 编码
	 */
	private java.lang.String rbTag;
	
	/**
	 * 申请人主键
	 */
	private Long applyStaffId;
	
	/**
	 * 所处环节(link_ID)
	 */
	private Long curStatus;
	
	/**
	 * 需求阶段(PHASE_ID)
	 */
	private Long curPhase;

	public void setRbId(Long value) {
		this.rbId = value;
	}
	
	public Long getRbId() {
		return this.rbId;
	}	    
	
	public java.lang.String getRbTag() {
		return this.rbTag;
	}
	
	public void setRbTag(java.lang.String value) {
		this.rbTag = value;
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

