package com.asiainfo.rms.workflow.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

/**
 * 
 * 
 * @author joker
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "SYS_STATION")
public class BOSysStation {
	
	// 岗位主键
	private java.lang.Long stationId;
	// 岗位编码
	@Length(max=40)
	private java.lang.String code;
	// 岗位名称
	private java.lang.String name;
	// 岗位备注
	@Length(max=1000)
	private java.lang.String notes;
	// 1正常 0注销
	private Integer state;
	// 岗位类型
	private Integer type;
	// 扩展字段1
	@Length(max=20)
	private java.lang.String ext1;
	// 扩展字段2
	@Length(max=20)
	private java.lang.String ext2;
	// 扩展字段3
	@Length(max=20)
	private java.lang.String ext3;
	// 岗位类型：1-数据岗位，2-流程岗位，3-功能权限
	private Integer stationType;

	public void setStationId(java.lang.Long value) {
		this.stationId = value;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="ALM_XJ_EXPENSES_AUTHOR_SEQ")
	@SequenceGenerator(sequenceName="ALM_XJ_EXPENSES$SEQ",allocationSize=1,name="ALM_XJ_EXPENSES_AUTHOR_SEQ")
	@Column(name = "STATION_ID", unique = false, nullable = false, insertable = true, updatable = true, length = 12)
	public java.lang.Long getStationId() {
		return this.stationId;
	}	    
	
	@Column(name = "CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	@Column(name = "NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 60)
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	@Column(name = "NOTES", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
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
	
	@Column(name = "TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public Integer getType() {
		return this.type;
	}
	
	public void setType(Integer value) {
		this.type = value;
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
	
	@Column(name = "STATION_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public Integer getStationType() {
		return this.stationType;
	}
	
	public void setStationType(Integer value) {
		this.stationType = value;
	}
}

