package com.asiainfo.rms.workflow.bo.process.common;

/**
 * 
 * 
 * @author joker
 */
public class SysAuthorBO {
	
	/**
	 * 关系主键
	 */
	private java.lang.Long authorId;
	
	/**
	 * 岗位主键
	 */
	private java.lang.Long stationId;
	
	/**
	 * 员工主键
	 */
	private java.lang.Long staffId;
	
	/**
	 * 备注
	 */
	private java.lang.String notes;
	
	/**
	 * 1正常 0注销
	 */
	private Integer state;
	
	/**
	 * 创建时间
	 */
	private java.util.Date createTime;
	
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

	public void setAuthorId(java.lang.Long value) {
		this.authorId = value;
	}
	
	public java.lang.Long getAuthorId() {
		return this.authorId;
	}	    
	
	public java.lang.Long getStationId() {
		return this.stationId;
	}
	
	public void setStationId(java.lang.Long value) {
		this.stationId = value;
	}
	
	public java.lang.Long getStaffId() {
		return this.staffId;
	}
	
	public void setStaffId(java.lang.Long value) {
		this.staffId = value;
	}
	
	public java.lang.String getNotes() {
		return this.notes;
	}
	
	public void setNotes(java.lang.String value) {
		this.notes = value;
	}
	
	public Integer getState() {
		return this.state;
	}
	
	public void setState(Integer value) {
		this.state = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
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
}

