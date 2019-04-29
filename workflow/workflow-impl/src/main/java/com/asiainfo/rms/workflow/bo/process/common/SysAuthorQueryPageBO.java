package com.asiainfo.rms.workflow.bo.process.common;

/**
 * 
 * 
 * @author joker
 */
public class SysAuthorQueryPageBO {
	
	/**
	 * 关系主键(开始)
	 */
	private java.lang.Long authorIdBegin;
	
	/**
	 * 关系主键(结束)
	 */
	private java.lang.Long authorIdEnd;
	
	/**
	 * 岗位主键(开始)
	 */
	private java.lang.Long stationIdBegin;
	
	/**
	 * 岗位主键(结束)
	 */
	private java.lang.Long stationIdEnd;
	
	/**
	 * 员工主键(开始)
	 */
	private java.lang.Long staffIdBegin;
	
	/**
	 * 员工主键(结束)
	 */
	private java.lang.Long staffIdEnd;
	
	/**
	 * 备注
	 */
	private java.lang.String notes;
	
	/**
	 * 1正常 0注销(开始)
	 */
	private Integer stateBegin;
	
	/**
	 * 1正常 0注销(结束)
	 */
	private Integer stateEnd;
	
	/**
	 * 创建时间(开始)
	 */
	private java.util.Date createTimeBegin;
	
	/**
	 * 创建时间(结束)
	 */
	private java.util.Date createTimeEnd;
	
	/**
	 * 扩展字段1
	 */
	private java.lang.String ext1;
	
	/**
	 * 扩展字段2
	 */
	private java.lang.String ext2;
	
	/**
	 * 扩展字段3
	 */
	private java.lang.String ext3;
	
	/**
	 * 分页页码
	 */
	private Integer pageNo;
	
	/**
	 * 分页步长
	 */
	private Integer pageSize;
	public java.lang.Long getAuthorIdBegin() {
		return this.authorIdBegin;
	}
	
	public void setAuthorIdBegin(java.lang.Long value) {
		this.authorIdBegin = value;
	}
	
	public java.lang.Long getAuthorIdEnd() {
		return this.authorIdEnd;
	}
	
	public void setAuthorIdEnd(java.lang.Long value) {
		this.authorIdEnd = value;
	}
	public java.lang.Long getStationIdBegin() {
		return this.stationIdBegin;
	}
	
	public void setStationIdBegin(java.lang.Long value) {
		this.stationIdBegin = value;
	}
	
	public java.lang.Long getStationIdEnd() {
		return this.stationIdEnd;
	}
	
	public void setStationIdEnd(java.lang.Long value) {
		this.stationIdEnd = value;
	}
	public java.lang.Long getStaffIdBegin() {
		return this.staffIdBegin;
	}
	
	public void setStaffIdBegin(java.lang.Long value) {
		this.staffIdBegin = value;
	}
	
	public java.lang.Long getStaffIdEnd() {
		return this.staffIdEnd;
	}
	
	public void setStaffIdEnd(java.lang.Long value) {
		this.staffIdEnd = value;
	}
	public java.lang.String getNotes() {
		return this.notes;
	}
	
	public void setNotes(java.lang.String value) {
		this.notes = value;
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

