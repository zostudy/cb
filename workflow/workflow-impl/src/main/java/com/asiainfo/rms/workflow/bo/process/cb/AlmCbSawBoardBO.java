package com.asiainfo.rms.workflow.bo.process.cb;

/**
 * 
 * 
 * @author joker
 */
public class AlmCbSawBoardBO {
	
	/**
	 * 主键
	 */
	private Long sbId;
	
	/**
	 * 编码
	 */
	private java.lang.String sbTag;
	
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

	public void setSbId(Long value) {
		this.sbId = value;
	}
	
	public Long getSbId() {
		return this.sbId;
	}	    
	
	public java.lang.String getSbTag() {
		return this.sbTag;
	}
	
	public void setSbTag(java.lang.String value) {
		this.sbTag = value;
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

