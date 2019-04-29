package com.asiainfo.rms.workflow.bo.process.common;

/**
 * 
 * 
 * @author joker
 */
public class SysOrganizeQueryPageBO {
	
	/**
	 * 组织ID(开始)
	 */
	private java.lang.Long organizeIdBegin;
	
	/**
	 * 组织ID(结束)
	 */
	private java.lang.Long organizeIdEnd;
	
	/**
	 * 父组织ID(开始)
	 */
	private java.lang.Long parentOrganizeIdBegin;
	
	/**
	 * 父组织ID(结束)
	 */
	private java.lang.Long parentOrganizeIdEnd;
	
	/**
	 * 组织名称
	 */
	private java.lang.String organizeName;
	
	/**
	 * 组织编码
	 */
	private java.lang.String code;
	
	/**
	 * 组织类型(开始)
	 */
	private Integer orgTypeBegin;
	
	/**
	 * 组织类型(结束)
	 */
	private Integer orgTypeEnd;
	
	/**
	 * 备注
	 */
	private java.lang.String notes;
	
	/**
	 * 状态(开始)
	 */
	private Integer stateBegin;
	
	/**
	 * 状态(结束)
	 */
	private Integer stateEnd;
	
	/**
	 * 创建时间(开始)
	 */
	private java.util.Date createDateBegin;
	
	/**
	 * 创建时间(结束)
	 */
	private java.util.Date createDateEnd;
	
	/**
	 * 附录一
	 */
	private java.lang.String ext1;
	
	/**
	 * 附录二
	 */
	private java.lang.String ext2;
	
	/**
	 * 附录三
	 */
	private java.lang.String ext3;
	
	/**
	 * 组织类型(开始)
	 */
	private Long organizeTypeIdBegin;
	
	/**
	 * 组织类型(结束)
	 */
	private Long organizeTypeIdEnd;
	
	/**
	 * 父组织编码
	 */
	private java.lang.String parentCode;
	
	/**
	 * 分页页码
	 */
	private Integer pageNo;
	
	/**
	 * 分页步长
	 */
	private Integer pageSize;
			
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
	public java.lang.Long getParentOrganizeIdBegin() {
		return this.parentOrganizeIdBegin;
	}
	
	public void setParentOrganizeIdBegin(java.lang.Long value) {
		this.parentOrganizeIdBegin = value;
	}
	
	public java.lang.Long getParentOrganizeIdEnd() {
		return this.parentOrganizeIdEnd;
	}
	
	public void setParentOrganizeIdEnd(java.lang.Long value) {
		this.parentOrganizeIdEnd = value;
	}
	public java.lang.String getOrganizeName() {
		return this.organizeName;
	}
	
	public void setOrganizeName(java.lang.String value) {
		this.organizeName = value;
	}	    	
	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setCode(java.lang.String value) {
		this.code = value;
	}	    	
	public Integer getOrgTypeBegin() {
		return this.orgTypeBegin;
	}
	
	public void setOrgTypeBegin(Integer value) {
		this.orgTypeBegin = value;
	}
	
	public Integer getOrgTypeEnd() {
		return this.orgTypeEnd;
	}
	
	public void setOrgTypeEnd(Integer value) {
		this.orgTypeEnd = value;
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
	public java.util.Date getCreateDateBegin() {
		return this.createDateBegin;
	}
	
	public void setCreateDateBegin(java.util.Date value) {
		this.createDateBegin = value;
	}
	
	public java.util.Date getCreateDateEnd() {
		return this.createDateEnd;
	}
	
	public void setCreateDateEnd(java.util.Date value) {
		this.createDateEnd = value;
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
	public Long getOrganizeTypeIdBegin() {
		return this.organizeTypeIdBegin;
	}
	
	public void setOrganizeTypeIdBegin(Long value) {
		this.organizeTypeIdBegin = value;
	}
	
	public Long getOrganizeTypeIdEnd() {
		return this.organizeTypeIdEnd;
	}
	
	public void setOrganizeTypeIdEnd(Long value) {
		this.organizeTypeIdEnd = value;
	}
	public java.lang.String getParentCode() {
		return this.parentCode;
	}
	
	public void setParentCode(java.lang.String value) {
		this.parentCode = value;
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

