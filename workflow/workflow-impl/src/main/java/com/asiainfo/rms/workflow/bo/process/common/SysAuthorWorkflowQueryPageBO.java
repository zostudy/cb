package com.asiainfo.rms.workflow.bo.process.common;

/**
 * 岗位与工作流关联表
 * 
 * @author joker
 */
public class SysAuthorWorkflowQueryPageBO {
	
	/**
	 * 主键(开始)
	 */
	private Long sawIdBegin;
	
	/**
	 * 主键(结束)
	 */
	private Long sawIdEnd;
	
	/**
	 * 员工主键(开始)
	 */
	private Long staffIdBegin;
	
	/**
	 * 员工主键(结束)
	 */
	private Long staffIdEnd;
	
	/**
	 * 工号
	 */
	private java.lang.String code;
	
	/**
	 * 雇员名称
	 */
	private java.lang.String employeeName;
	
	/**
	 * 手机号码
	 */
	private java.lang.String billId;
	
	/**
	 * 组织ID(开始)
	 */
	private java.lang.Long organizeIdBegin;
	
	/**
	 * 组织ID(结束)
	 */
	private java.lang.Long organizeIdEnd;
	
	/**
	 * 组织名称
	 */
	private java.lang.String organizeName;
	
	/**
	 * 组织类型(开始)
	 */
	private Integer orgTypeBegin;
	
	/**
	 * 组织类型(结束)
	 */
	private Integer orgTypeEnd;
	
	/**
	 * 创建时间(开始)
	 */
	private java.util.Date createDateBegin;
	
	/**
	 * 创建时间(结束)
	 */
	private java.util.Date createDateEnd;
	
	/**
	 * 结束时间(开始)
	 */
	private java.util.Date endDateBegin;
	
	/**
	 * 结束时间(结束)
	 */
	private java.util.Date endDateEnd;
	
	/**
	 * 岗位主键(开始)
	 */
	private java.lang.Long stationIdBegin;
	
	/**
	 * 岗位主键(结束)
	 */
	private java.lang.Long stationIdEnd;
	
	/**
	 * 岗位名称
	 */
	private java.lang.String name;
	
	/**
	 * 岗位备注
	 */
	private java.lang.String notes;
	
	/**
	 * 流程类型
	 */
	private java.lang.String objType;
	
	/**
	 * 流程实例主键(开始)
	 */
	private Long objIdBegin;
	
	/**
	 * 流程实例主键(结束)
	 */
	private Long objIdEnd;
	
	/**
	 * 环节编码(开始)
	 */
	private java.lang.Long linkIdBegin;
	
	/**
	 * 环节编码(结束)
	 */
	private java.lang.Long linkIdEnd;
	
	/**
	 * 环节编号
	 */
	private java.lang.String linkNo;
	
	/**
	 * 阶段编号
	 */
	private java.lang.String phaseId;
	
	/**
	 * 阶段名称
	 */
	private java.lang.String phaseName;
	
	/**
	 * 流程实例编码
	 */
	private java.lang.String objTag;
	
	/**
	 * 岗位薪资
	 */
	private java.lang.String stationMoney;
	
	/**
	 * 总数量
	 */
	private java.lang.String stationAmount;
	
	/**
	 * 总金额
	 */
	private java.lang.String stationAggregate;
	
	/**
	 * 岗位类型(平分,独享)(开始)
	 */
	private Integer typeBegin;
	
	/**
	 * 岗位类型(平分,独享)(结束)
	 */
	private Integer typeEnd;
	
	/**
	 * 岗位人数
	 */
	private java.lang.String stationPeople;
	
	/**
	 * 分页页码
	 */
	private Integer pageNo;
	
	/**
	 * 分页步长
	 */
	private Integer pageSize;
	public Long getSawIdBegin() {
		return this.sawIdBegin;
	}
	
	public void setSawIdBegin(Long value) {
		this.sawIdBegin = value;
	}
	
	public Long getSawIdEnd() {
		return this.sawIdEnd;
	}
	
	public void setSawIdEnd(Long value) {
		this.sawIdEnd = value;
	}
	public Long getStaffIdBegin() {
		return this.staffIdBegin;
	}
	
	public void setStaffIdBegin(Long value) {
		this.staffIdBegin = value;
	}
	
	public Long getStaffIdEnd() {
		return this.staffIdEnd;
	}
	
	public void setStaffIdEnd(Long value) {
		this.staffIdEnd = value;
	}
	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setCode(java.lang.String value) {
		this.code = value;
	}	    	
	public java.lang.String getEmployeeName() {
		return this.employeeName;
	}
	
	public void setEmployeeName(java.lang.String value) {
		this.employeeName = value;
	}	    	
	public java.lang.String getBillId() {
		return this.billId;
	}
	
	public void setBillId(java.lang.String value) {
		this.billId = value;
	}	    	
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
	public java.lang.String getOrganizeName() {
		return this.organizeName;
	}
	
	public void setOrganizeName(java.lang.String value) {
		this.organizeName = value;
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
	public java.util.Date getEndDateBegin() {
		return this.endDateBegin;
	}
	
	public void setEndDateBegin(java.util.Date value) {
		this.endDateBegin = value;
	}
	
	public java.util.Date getEndDateEnd() {
		return this.endDateEnd;
	}
	
	public void setEndDateEnd(java.util.Date value) {
		this.endDateEnd = value;
	}
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
	public java.lang.String getObjType() {
		return this.objType;
	}
	
	public void setObjType(java.lang.String value) {
		this.objType = value;
	}	    	
	public Long getObjIdBegin() {
		return this.objIdBegin;
	}
	
	public void setObjIdBegin(Long value) {
		this.objIdBegin = value;
	}
	
	public Long getObjIdEnd() {
		return this.objIdEnd;
	}
	
	public void setObjIdEnd(Long value) {
		this.objIdEnd = value;
	}
	public java.lang.Long getLinkIdBegin() {
		return this.linkIdBegin;
	}
	
	public void setLinkIdBegin(java.lang.Long value) {
		this.linkIdBegin = value;
	}
	
	public java.lang.Long getLinkIdEnd() {
		return this.linkIdEnd;
	}
	
	public void setLinkIdEnd(java.lang.Long value) {
		this.linkIdEnd = value;
	}
	public java.lang.String getLinkNo() {
		return this.linkNo;
	}
	
	public void setLinkNo(java.lang.String value) {
		this.linkNo = value;
	}	    	
	public java.lang.String getPhaseId() {
		return this.phaseId;
	}
	
	public void setPhaseId(java.lang.String value) {
		this.phaseId = value;
	}	    	
	public java.lang.String getPhaseName() {
		return this.phaseName;
	}
	
	public void setPhaseName(java.lang.String value) {
		this.phaseName = value;
	}	    	
	public java.lang.String getObjTag() {
		return this.objTag;
	}
	
	public void setObjTag(java.lang.String value) {
		this.objTag = value;
	}	    	
	public java.lang.String getStationMoney() {
		return this.stationMoney;
	}
	
	public void setStationMoney(java.lang.String value) {
		this.stationMoney = value;
	}	    	
	public java.lang.String getStationAmount() {
		return this.stationAmount;
	}
	
	public void setStationAmount(java.lang.String value) {
		this.stationAmount = value;
	}	    	
	public java.lang.String getStationAggregate() {
		return this.stationAggregate;
	}
	
	public void setStationAggregate(java.lang.String value) {
		this.stationAggregate = value;
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
	public java.lang.String getStationPeople() {
		return this.stationPeople;
	}
	
	public void setStationPeople(java.lang.String value) {
		this.stationPeople = value;
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

