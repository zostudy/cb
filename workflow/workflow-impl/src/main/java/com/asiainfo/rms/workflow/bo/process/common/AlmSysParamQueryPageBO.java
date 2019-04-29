package com.asiainfo.rms.workflow.bo.process.common;

/**
 * 
 * 
 * @author joker
 */
public class AlmSysParamQueryPageBO {
	
	/**
	 * 参数类型
	 */
	private java.lang.String paramType;
	
	/**
	 * 参数ID(开始)
	 */
	private java.lang.Long paramIdBegin;
	
	/**
	 * 参数ID(结束)
	 */
	private java.lang.Long paramIdEnd;
	
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
	 * 默认为 父关系 PARAM_ID(开始)
	 */
	private java.lang.Long paramRelaIdBegin;
	
	/**
	 * 默认为 父关系 PARAM_ID(结束)
	 */
	private java.lang.Long paramRelaIdEnd;
	
	/**
	 * 参数值(开始)
	 */
	private Integer paramValueBegin;
	
	/**
	 * 参数值(结束)
	 */
	private Integer paramValueEnd;
	
	/**
	 * 参数排序，以sort_id的值的大小作为排次序。缺省值为0(开始)
	 */
	private Integer sortIdBegin;
	
	/**
	 * 参数排序，以sort_id的值的大小作为排次序。缺省值为0(结束)
	 */
	private Integer sortIdEnd;
	
	/**
	 * 分页页码
	 */
	private Integer pageNo;
	
	/**
	 * 分页步长
	 */
	private Integer pageSize;
	public java.lang.String getParamType() {
		return this.paramType;
	}
	
	public void setParamType(java.lang.String value) {
		this.paramType = value;
	}	    	
	public java.lang.Long getParamIdBegin() {
		return this.paramIdBegin;
	}
	
	public void setParamIdBegin(java.lang.Long value) {
		this.paramIdBegin = value;
	}
	
	public java.lang.Long getParamIdEnd() {
		return this.paramIdEnd;
	}
	
	public void setParamIdEnd(java.lang.Long value) {
		this.paramIdEnd = value;
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
	public java.lang.Long getParamRelaIdBegin() {
		return this.paramRelaIdBegin;
	}
	
	public void setParamRelaIdBegin(java.lang.Long value) {
		this.paramRelaIdBegin = value;
	}
	
	public java.lang.Long getParamRelaIdEnd() {
		return this.paramRelaIdEnd;
	}
	
	public void setParamRelaIdEnd(java.lang.Long value) {
		this.paramRelaIdEnd = value;
	}
	public Integer getParamValueBegin() {
		return this.paramValueBegin;
	}
	
	public void setParamValueBegin(Integer value) {
		this.paramValueBegin = value;
	}
	
	public Integer getParamValueEnd() {
		return this.paramValueEnd;
	}
	
	public void setParamValueEnd(Integer value) {
		this.paramValueEnd = value;
	}
	public Integer getSortIdBegin() {
		return this.sortIdBegin;
	}
	
	public void setSortIdBegin(Integer value) {
		this.sortIdBegin = value;
	}
	
	public Integer getSortIdEnd() {
		return this.sortIdEnd;
	}
	
	public void setSortIdEnd(Integer value) {
		this.sortIdEnd = value;
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

