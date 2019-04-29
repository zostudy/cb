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
@Table(name = "SYS_STAFF_ORG_RELAT")
public class BOSysStaffOrgRelat {
	
	// 关系ID
	private java.lang.Long staffOrgRelatId;
	// 组织ID
	
	private java.lang.Long organizeId;
	// 人员ID
	
	private java.lang.Long staffId;
	// 1 正常 0删除
	private Integer state;
	// 备注
	@Length(max=255)
	private java.lang.String notes;
	// 创建时间
	
	private java.util.Date createTime;
	// 扩展字段1
	@Length(max=20)
	private java.lang.String ext1;
	// 扩展字段2
	@Length(max=20)
	private java.lang.String ext2;
	// 扩展字段3
	@Length(max=20)
	private java.lang.String ext3;

	public void setStaffOrgRelatId(java.lang.Long value) {
		this.staffOrgRelatId = value;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="ALM_XJ_EXPENSES_AUTHOR_SEQ")
	@SequenceGenerator(sequenceName="ALM_XJ_EXPENSES$SEQ",allocationSize=1,name="ALM_XJ_EXPENSES_AUTHOR_SEQ")
	@Column(name = "STAFF_ORG_RELAT_ID", unique = false, nullable = false, insertable = true, updatable = true, length = 12)
	public java.lang.Long getStaffOrgRelatId() {
		return this.staffOrgRelatId;
	}	    
	
	@Column(name = "ORGANIZE_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 12)
	public java.lang.Long getOrganizeId() {
		return this.organizeId;
	}
	
	public void setOrganizeId(java.lang.Long value) {
		this.organizeId = value;
	}
	
	@Column(name = "STAFF_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 12)
	public java.lang.Long getStaffId() {
		return this.staffId;
	}
	
	public void setStaffId(java.lang.Long value) {
		this.staffId = value;
	}
	
	@Column(name = "STATE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public Integer getState() {
		return this.state;
	}
	
	public void setState(Integer value) {
		this.state = value;
	}
	
	@Column(name = "NOTES", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	public java.lang.String getNotes() {
		return this.notes;
	}
	
	public void setNotes(java.lang.String value) {
		this.notes = value;
	}
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", unique = false, nullable = true, insertable = true, updatable = true)
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	@Column(name = "EXT1", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getExt1() {
		return this.ext1;
	}
	
	public void setExt1(java.lang.String value) {
		this.ext1 = value;
	}
	
	@Column(name = "EXT2", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getExt2() {
		return this.ext2;
	}
	
	public void setExt2(java.lang.String value) {
		this.ext2 = value;
	}
	
	@Column(name = "EXT3", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getExt3() {
		return this.ext3;
	}
	
	public void setExt3(java.lang.String value) {
		this.ext3 = value;
	}
}

