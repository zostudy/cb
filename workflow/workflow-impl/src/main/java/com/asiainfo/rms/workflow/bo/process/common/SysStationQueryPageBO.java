package com.asiainfo.rms.workflow.bo.process.common;

/**
 * 
 * 
 * @author joker
 */
public class SysStationQueryPageBO {
	
	/**
	 * 岗位主键(开始)
	 */
	private java.lang.Long stationIdBegin;
	
	/**
	 * 岗位主键(结束)
	 */
	private java.lang.Long stationIdEnd;
	
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
	 * 1正常 0注销(开始)
	 */
	private Integer stateBegin;
	
	/**
	 * 1正常 0注销(结束)
	 */
	private Integer stateEnd;
	
	/**
	 * 岗位类型(开始)
	 */
	private Integer typeBegin;
	
	/**
	 * 岗位类型(结束)
	 */
	private Integer typeEnd;
	
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
	 * 岗位类型：1-数据岗位，2-流程岗位，3-功能权限(开始)
	 */
	private Integer stationTypeBegin;
	
	/**
	 * 岗位类型：1-数据岗位，2-流程岗位，3-功能权限(结束)
	 */
	private Integer stationTypeEnd;
	
	/**
	 * 分页页码
	 */
	private Integer pageNo;
	
	/**
	 * 分页步长
	 */
	private Integer pageSize;
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
	public Integer getTypeBegin() {
		return this.typeBegin;
	}
	
	public void setTypeBegin(Integer value) {
		this.typeBegin = value;
	}
	
	public Integer getTypeEnd() {
		return this.typeEnd;
	}
	
	public void setTypeEnd(Integer value) {
		this.typeEnd = value;
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
	public Integer getStationTypeBegin() {
		return this.stationTypeBegin;
	}
	
	public void setStationTypeBegin(Integer value) {
		this.stationTypeBegin = value;
	}
	
	public Integer getStationTypeEnd() {
		return this.stationTypeEnd;
	}
	
	public void setStationTypeEnd(Integer value) {
		this.stationTypeEnd = value;
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

