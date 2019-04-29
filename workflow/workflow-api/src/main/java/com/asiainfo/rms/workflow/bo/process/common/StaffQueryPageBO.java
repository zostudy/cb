package com.asiainfo.rms.workflow.bo.process.common;

/**
 * 
 * 
 * @author joker
 */
public class StaffQueryPageBO {
	
	/**
	 * (开始)
	 */
	private Long authorIdBegin;
	
	/**
	 * (结束)
	 */
	private Long authorIdEnd;
	
	/**
	 * (开始)
	 */
	private Long stationIdBegin;
	
	/**
	 * (结束)
	 */
	private Long stationIdEnd;
	
	/**
	 * (开始)
	 */
	private Integer stateBegin;
	
	/**
	 * (结束)
	 */
	private Integer stateEnd;
	
	/**
	 * 
	 */
	private String notes;
	
	/**
	 * (开始)
	 */
	private java.util.Date createTimeBegin;
	
	/**
	 * (结束)
	 */
	private java.util.Date createTimeEnd;
	
	/**
	 * (开始)
	 */
	private java.util.Date endTimeBegin;
	
	/**
	 * (结束)
	 */
	private java.util.Date endTimeEnd;
	
	/**
	 * (开始)
	 */
	private Long staffIdBegin;
	
	/**
	 * (结束)
	 */
	private Long staffIdEnd;
	
	/**
	 * 
	 */
	private String employeeName;
	
	/**
	 * 
	 */
	private String stationName;
	
	/**
	 * 分页页码
	 */
	private Integer pageNo;
	
	/**
	 * 分页步长
	 */
	private Integer pageSize;
	public Long getAuthorIdBegin() {
		return this.authorIdBegin;
	}
	
	public void setAuthorIdBegin(Long value) {
		this.authorIdBegin = value;
	}
	
	public Long getAuthorIdEnd() {
		return this.authorIdEnd;
	}
	
	public void setAuthorIdEnd(Long value) {
		this.authorIdEnd = value;
	}
	public Long getStationIdBegin() {
		return this.stationIdBegin;
	}
	
	public void setStationIdBegin(Long value) {
		this.stationIdBegin = value;
	}
	
	public Long getStationIdEnd() {
		return this.stationIdEnd;
	}
	
	public void setStationIdEnd(Long value) {
		this.stationIdEnd = value;
	}
	public Integer getStateBegin() {
		return this.stateBegin;
	}
	
	public void setStateBegin(Integer value) {
		this.stateBegin = value;
	}
	
	public Integer getStateEnd() {
		return this.stateEnd;
	}
	
	public void setStateEnd(Integer value) {
		this.stateEnd = value;
	}
	public String getNotes() {
		return this.notes;
	}
	
	public void setNotes(String value) {
		this.notes = value;
	}	    	
	public java.util.Date getCreateTimeBegin() {
		return this.createTimeBegin;
	}
	
	public void setCreateTimeBegin(java.util.Date value) {
		this.createTimeBegin = value;
	}
	
	public java.util.Date getCreateTimeEnd() {
		return this.createTimeEnd;
	}
	
	public void setCreateTimeEnd(java.util.Date value) {
		this.createTimeEnd = value;
	}
	public java.util.Date getEndTimeBegin() {
		return this.endTimeBegin;
	}
	
	public void setEndTimeBegin(java.util.Date value) {
		this.endTimeBegin = value;
	}
	
	public java.util.Date getEndTimeEnd() {
		return this.endTimeEnd;
	}
	
	public void setEndTimeEnd(java.util.Date value) {
		this.endTimeEnd = value;
	}
	public Long getStaffIdBegin() {
		return this.staffIdBegin;
	}
	
	public void setStaffIdBegin(Long value) {
		this.staffIdBegin = value;
	}
	
	public Long getStaffIdEnd() {
		return this.staffIdEnd;
	}
	
	public void setStaffIdEnd(Long value) {
		this.staffIdEnd = value;
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

