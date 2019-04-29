package com.asiainfo.rms.workflow.bo.process.cb;

/**
 * 
 * 
 * @author joker
 */
public class AlmCbThermoCompressorQueryPageBO {
	
	/**
	 * 主键(开始)
	 */
	private Long tcIdBegin;
	
	/**
	 * 主键(结束)
	 */
	private Long tcIdEnd;
	
	/**
	 * 编码
	 */
	private java.lang.String tcTag;
	
	/**
	 * 申请人主键(开始)
	 */
	private Long applyStaffIdBegin;
	
	/**
	 * 申请人主键(结束)
	 */
	private Long applyStaffIdEnd;
	
	/**
	 * 所处环节(link_ID)(开始)
	 */
	private Long curStatusBegin;
	
	/**
	 * 所处环节(link_ID)(结束)
	 */
	private Long curStatusEnd;
	
	/**
	 * 需求阶段(PHASE_ID)(开始)
	 */
	private Long curPhaseBegin;
	
	/**
	 * 需求阶段(PHASE_ID)(结束)
	 */
	private Long curPhaseEnd;
	
	/**
	 * 分页页码
	 */
	private Integer pageNo;
	
	/**
	 * 分页步长
	 */
	private Integer pageSize;
	public Long getTcIdBegin() {
		return this.tcIdBegin;
	}
	
	public void setTcIdBegin(Long value) {
		this.tcIdBegin = value;
	}
	
	public Long getTcIdEnd() {
		return this.tcIdEnd;
	}
	
	public void setTcIdEnd(Long value) {
		this.tcIdEnd = value;
	}
	public java.lang.String getTcTag() {
		return this.tcTag;
	}
	
	public void setTcTag(java.lang.String value) {
		this.tcTag = value;
	}	    	
	public Long getApplyStaffIdBegin() {
		return this.applyStaffIdBegin;
	}
	
	public void setApplyStaffIdBegin(Long value) {
		this.applyStaffIdBegin = value;
	}
	
	public Long getApplyStaffIdEnd() {
		return this.applyStaffIdEnd;
	}
	
	public void setApplyStaffIdEnd(Long value) {
		this.applyStaffIdEnd = value;
	}
	public Long getCurStatusBegin() {
		return this.curStatusBegin;
	}
	
	public void setCurStatusBegin(Long value) {
		this.curStatusBegin = value;
	}
	
	public Long getCurStatusEnd() {
		return this.curStatusEnd;
	}
	
	public void setCurStatusEnd(Long value) {
		this.curStatusEnd = value;
	}
	public Long getCurPhaseBegin() {
		return this.curPhaseBegin;
	}
	
	public void setCurPhaseBegin(Long value) {
		this.curPhaseBegin = value;
	}
	
	public Long getCurPhaseEnd() {
		return this.curPhaseEnd;
	}
	
	public void setCurPhaseEnd(Long value) {
		this.curPhaseEnd = value;
	}
	
	public Integer getPageNo() {
		return this.pageNo;
	}
	
	public Integer getPageSize() {
		return this.pageSize;
	}
	
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}

