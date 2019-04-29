package com.asiainfo.rms.workflow.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;

/**
 * 
 * 
 * @author joker
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "SYS_ORGANIZE")
public class BOSysOrganize {
	
	// 组织ID
	
	private java.lang.Long organizeId;
	// 父组织ID
	
	private java.lang.Long parentOrganizeId;
	// 组织名称
	private java.lang.String organizeName;
	// 组织编码
	@Length(max=100)
	private java.lang.String code;
	// 组织类型
	private Integer orgType;
	// 备注
	@Length(max=255)
	private java.lang.String notes;
	// 状态
	private Integer state;
	// 创建时间
	
	private java.util.Date createDate;
	// 附录一
	@Length(max=40)
	private java.lang.String ext1;
	// 附录二
	@Length(max=40)
	private java.lang.String ext2;
	// 附录三
	@Length(max=40)
	private java.lang.String ext3;
	// 组织类型
	
	private Long organizeTypeId;
	// 父组织编码
	@Length(max=100)
	private java.lang.String parentCode;
	
	public void setOrganizeId(java.lang.Long value) {
		this.organizeId = value;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="ALM_PRIMARY_TABLE_SEQ")
	@SequenceGenerator(sequenceName="ALM_PRIMARY_TABLE$SEQ",allocationSize=1,name="ALM_PRIMARY_TABLE_SEQ")
	@Column(name = "ORGANIZE_ID", unique = true, nullable = false, insertable = true, updatable = true, length = 12)
	public java.lang.Long getOrganizeId() {
		return this.organizeId;
	}
	
	@Column(name = "PARENT_ORGANIZE_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 12)
	public java.lang.Long getParentOrganizeId() {
		return this.parentOrganizeId;
	}
	
	public void setParentOrganizeId(java.lang.Long value) {
		this.parentOrganizeId = value;
	}
	
	@Column(name = "ORGANIZE_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	public java.lang.String getOrganizeName() {
		return this.organizeName;
	}
	
	public void setOrganizeName(java.lang.String value) {
		this.organizeName = value;
	}
	
	@Column(name = "CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	@Column(name = "ORG_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public Integer getOrgType() {
		return this.orgType;
	}
	
	public void setOrgType(Integer value) {
		this.orgType = value;
	}
	
	@Column(name = "NOTES", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	public java.lang.String getNotes() {
		return this.notes;
	}
	
	public void setNotes(java.lang.String value) {
		this.notes = value;
	}
	
	@Column(name = "STATE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public Integer getState() {
		return this.state;
	}
	
	public void setState(Integer value) {
		this.state = value;
	}
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", unique = false, nullable = true, insertable = true, updatable = true)
	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(java.util.Date value) {
		this.createDate = value;
	}
	
	@Column(name = "EXT1", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	public java.lang.String getExt1() {
		return this.ext1;
	}
	
	public void setExt1(java.lang.String value) {
		this.ext1 = value;
	}
	
	@Column(name = "EXT2", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	public java.lang.String getExt2() {
		return this.ext2;
	}
	
	public void setExt2(java.lang.String value) {
		this.ext2 = value;
	}
	
	@Column(name = "EXT3", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	public java.lang.String getExt3() {
		return this.ext3;
	}
	
	public void setExt3(java.lang.String value) {
		this.ext3 = value;
	}
	
	@Column(name = "ORGANIZE_TYPE_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public Long getOrganizeTypeId() {
		return this.organizeTypeId;
	}
	
	public void setOrganizeTypeId(Long value) {
		this.organizeTypeId = value;
	}
	
	@Column(name = "PARENT_CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getParentCode() {
		return this.parentCode;
	}
	
	public void setParentCode(java.lang.String value) {
		this.parentCode = value;
	}
}

