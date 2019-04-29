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
@Table(name = "ALM_SYS_PARAM")
public class BOAlmSysParam {
	
	// 参数类型
	@Length(max=128)
	private java.lang.String paramType;
	// 参数ID
	private java.lang.Long paramId;
	// 参数编号
	@Length(max=128)
	private java.lang.String paramNo;
	// 参数名称
	@Length(max=128)
	private java.lang.String paramName;
	// 参数描述
	@Length(max=128)
	private java.lang.String paramDisc;
	// 默认为 父关系 PARAM_ID
	
	private java.lang.Long paramRelaId;
	// 参数值
	private Integer paramValue;
	// 参数排序，以sort_id的值的大小作为排次序。缺省值为0
	private Integer sortId;

	public void setParamType(java.lang.String value) {
		this.paramType = value;
	}
	
	@Column(name = "PARAM_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getParamType() {
		return this.paramType;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="ALM_XJ_EXPENSES_AUTHOR_SEQ")
	@SequenceGenerator(sequenceName="ALM_XJ_EXPENSES$SEQ",allocationSize=1,name="ALM_XJ_EXPENSES_AUTHOR_SEQ")
	@Column(name = "PARAM_ID", unique = false, nullable = false, insertable = true, updatable = true, length = 12)
	public java.lang.Long getParamId() {
		return this.paramId;
	}
	
	public void setParamId(java.lang.Long value) {
		this.paramId = value;
	}
	
	@Column(name = "PARAM_NO", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getParamNo() {
		return this.paramNo;
	}
	
	public void setParamNo(java.lang.String value) {
		this.paramNo = value;
	}
	
	@Column(name = "PARAM_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getParamName() {
		return this.paramName;
	}
	
	public void setParamName(java.lang.String value) {
		this.paramName = value;
	}
	
	@Column(name = "PARAM_DISC", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getParamDisc() {
		return this.paramDisc;
	}
	
	public void setParamDisc(java.lang.String value) {
		this.paramDisc = value;
	}
	
	@Column(name = "PARAM_RELA_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 12)
	public java.lang.Long getParamRelaId() {
		return this.paramRelaId;
	}
	
	public void setParamRelaId(java.lang.Long value) {
		this.paramRelaId = value;
	}
	
	@Column(name = "PARAM_VALUE", unique = false, nullable = true, insertable = true, updatable = true, length = 4)
	public Integer getParamValue() {
		return this.paramValue;
	}
	
	public void setParamValue(Integer value) {
		this.paramValue = value;
	}
	
	@Column(name = "SORT_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 4)
	public Integer getSortId() {
		return this.sortId;
	}
	
	public void setSortId(Integer value) {
		this.sortId = value;
	}
}

