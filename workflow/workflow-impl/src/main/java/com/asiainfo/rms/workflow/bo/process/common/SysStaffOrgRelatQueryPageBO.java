package com.asiainfo.rms.workflow.bo.process.common;

/**
 * 
 * 
 * @author joker
 */
public class SysStaffOrgRelatQueryPageBO {
	
	/**
	 * 关系ID(开始)
	 */
	private java.lang.Long staffOrgRelatIdBegin;
	
	/**
	 * 关系ID(结束)
	 */
	private java.lang.Long staffOrgRelatIdEnd;
	
	/**
	 * 组织ID(开始)
	 */
	private java.lang.Long organizeIdBegin;
	
	/**
	 * 组织ID(结束)
	 */
	private java.lang.Long organizeIdEnd;
	
	/**
	 * 人员ID(开始)
	 */
	private java.lang.Long staffIdBegin;
	
	/**
	 * 人员ID(结束)
	 */
	private java.lang.Long staffIdEnd;
	
	/**
	 * 1 正常 0删除(开始)
	 */
	private Integer stateBegin;
	
	/**
	 * 1 正常 0删除(结束)
	 */
	private Integer stateEnd;
	
	/**
	 * 备注
	 */
	private java.lang.String notes;
	
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
	public java.lang.Long getStaffOrgRelatIdBegin() {
		return this.staffOrgRelatIdBegin;
	}
	
	public void setStaffOrgRelatIdBegin(java.lang.Long value) {
		this.staffOrgRelatIdBegin = value;
	}
	
	public java.lang.Long getStaffOrgRelatIdEnd() {
		return this.staffOrgRelatIdEnd;
	}
	
	public void setStaffOrgRelatIdEnd(java.lang.Long value) {
		this.staffOrgRelatIdEnd = value;
	}
	public java.lang.Long getOrganizeIdBegin() {
		return this.organizeIdBegin;
	}
	
	public void setOrganizeIdBegin(java.lang.Long value) {
		this.organizeIdBegin = value;
	}
	
	public java.lang.Long getOrganizeIdEnd() {
		return this.organizeIdEnd;
	}
	
	public void setOrganizeIdEnd(java.lang.Long value) {
		this.organizeIdEnd = value;
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
	public java.lang.String getNotes() {
		return this.notes;
	}
	
	public void setNotes(java.lang.String value) {
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

