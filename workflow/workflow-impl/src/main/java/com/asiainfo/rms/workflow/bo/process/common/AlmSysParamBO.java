package com.asiainfo.rms.workflow.bo.process.common;

/**
 * 
 * 
 * @author joker
 */
public class AlmSysParamBO {
	
	/**
	 * 参数类型
	 */
	private java.lang.String paramType;
	
	/**
	 * 参数ID
	 */
	private java.lang.Long paramId;
	
	/**
	 * 参数编号
	 */
	private java.lang.String paramNo;
	
	/**
	 * 参数名称
	 */
	private java.lang.String paramName;
	
	/**
	 * 参数描述
	 */
	private java.lang.String paramDisc;
	
	/**
	 * 默认为 父关系 PARAM_ID
	 */
	private java.lang.Long paramRelaId;
	
	/**
	 * 参数值
	 */
	private Integer paramValue;
	
	/**
	 * 参数排序，以sort_id的值的大小作为排次序。缺省值为0
	 */
	private Integer sortId;

	public void setParamType(java.lang.String value) {
		this.paramType = value;
	}
	
	public java.lang.String getParamType() {
		return this.paramType;
	}	    
	
	public java.lang.Long getParamId() {
		return this.paramId;
	}
	
	public void setParamId(java.lang.Long value) {
		this.paramId = value;
	}
	
	public java.lang.String getParamNo() {
		return this.paramNo;
	}
	
	public void setParamNo(java.lang.String value) {
		this.paramNo = value;
	}
	
	public java.lang.String getParamName() {
		return this.paramName;
	}
	
	public void setParamName(java.lang.String value) {
		this.paramName = value;
	}
	
	public java.lang.String getParamDisc() {
		return this.paramDisc;
	}
	
	public void setParamDisc(java.lang.String value) {
		this.paramDisc = value;
	}
	
	public java.lang.Long getParamRelaId() {
		return this.paramRelaId;
	}
	
	public void setParamRelaId(java.lang.Long value) {
		this.paramRelaId = value;
	}
	
	public Integer getParamValue() {
		return this.paramValue;
	}
	
	public void setParamValue(Integer value) {
		this.paramValue = value;
	}
	
	public Integer getSortId() {
		return this.sortId;
	}
	
	public void setSortId(Integer value) {
		this.sortId = value;
	}
}

