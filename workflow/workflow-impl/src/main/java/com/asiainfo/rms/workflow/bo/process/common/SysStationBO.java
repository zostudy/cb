package com.asiainfo.rms.workflow.bo.process.common;

/**
 * 
 * 
 * @author joker
 */
public class SysStationBO {
	
	/**
	 * 岗位主键
	 */
	private java.lang.Long stationId;
	
	/**
	 * 岗位编码
	 */
	private java.lang.String code;
	
	/**
	 * 岗位名称
	 */
	private java.lang.String name;
	
	/**
	 * 岗位备注
	 */
	private java.lang.String notes;
	
	/**
	 * 1正常 0注销
	 */
	private Integer state;
	
	/**
	 * 岗位类型
	 */
	private Integer type;
	
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
	 * 岗位类型：1-数据岗位，2-流程岗位，3-功能权限
	 */
	private Integer stationType;

	public void setStationId(java.lang.Long value) {
		this.stationId = value;
	}
	
	public java.lang.Long getStationId() {
		return this.stationId;
	}	    
	
	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
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
	
	public Integer getType() {
		return this.type;
	}
	
	public void setType(Integer value) {
		this.type = value;
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
	
	public Integer getStationType() {
		return this.stationType;
	}
	
	public void setStationType(Integer value) {
		this.stationType = value;
	}
}

