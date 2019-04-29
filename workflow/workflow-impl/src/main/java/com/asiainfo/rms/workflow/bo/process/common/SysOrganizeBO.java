package com.asiainfo.rms.workflow.bo.process.common;

/**
 * 
 * 
 * @author joker
 */
public class SysOrganizeBO {
	
	/**
	 * 组织ID
	 */
	private java.lang.Long organizeId;
	
	/**
	 * 父组织ID
	 */
	private java.lang.Long parentOrganizeId;
	
	/**
	 * 组织名称
	 */
	private java.lang.String organizeName;
	
	/**
	 * 组织编码
	 */
	private java.lang.String code;
	
	/**
	 * 组织类型
	 */
	private Integer orgType;
	
	/**
	 * 备注
	 */
	private java.lang.String notes;
	
	/**
	 * 状态
	 */
	private Integer state;
	
	/**
	 * 创建时间
	 */
	private java.util.Date createDate;
	
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
	 * 组织类型
	 */
	private Long organizeTypeId;
	
	/**
	 * 父组织编码
	 */
	private java.lang.String parentCode;
	
	public void setOrganizeId(java.lang.Long value) {
		this.organizeId = value;
	}
	
	public java.lang.Long getOrganizeId() {
		return this.organizeId;
	}
	
	public java.lang.Long getParentOrganizeId() {
		return this.parentOrganizeId;
	}
	
	public void setParentOrganizeId(java.lang.Long value) {
		this.parentOrganizeId = value;
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
	
	public Integer getOrgType() {
		return this.orgType;
	}
	
	public void setOrgType(Integer value) {
		this.orgType = value;
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
	
	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(java.util.Date value) {
		this.createDate = value;
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
	
	public Long getOrganizeTypeId() {
		return this.organizeTypeId;
	}
	
	public void setOrganizeTypeId(Long value) {
		this.organizeTypeId = value;
	}
	
	public java.lang.String getParentCode() {
		return this.parentCode;
	}
	
	public void setParentCode(java.lang.String value) {
		this.parentCode = value;
	}
}

