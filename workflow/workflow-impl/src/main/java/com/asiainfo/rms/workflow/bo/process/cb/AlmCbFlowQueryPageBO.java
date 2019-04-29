package com.asiainfo.rms.workflow.bo.process.cb;

/**
 * 流水表
 * 
 * @author joker
 */
public class AlmCbFlowQueryPageBO {
	
	/**
	 * 流水主键(开始)
	 */
	private Long flowIdBegin;
	
	/**
	 * 流水主键(结束)
	 */
	private Long flowIdEnd;
	
	/**
	 * 员工主键(开始)
	 */
	private Long staffIdBegin;
	
	/**
	 * 员工主键(结束)
	 */
	private Long staffIdEnd;
	
	/**
	 * 雇员名称
	 */
	private java.lang.String staffName;
	
	/**
	 * 组织主键(开始)
	 */
	private Long organizeIdBegin;
	
	/**
	 * 组织主键(结束)
	 */
	private Long organizeIdEnd;
	
	/**
	 * 组织名称
	 */
	private java.lang.String organizeName;
	
	/**
	 * 组织权限(开始)
	 */
	private Integer organizeTypeBegin;
	
	/**
	 * 组织权限(结束)
	 */
	private Integer organizeTypeEnd;
	
	/**
	 * 岗位主键(开始)
	 */
	private Long stationIdBegin;
	
	/**
	 * 岗位主键(结束)
	 */
	private Long stationIdEnd;
	
	/**
	 * 岗位金额
	 */
	private java.lang.String stationCode;
	
	/**
	 * 岗位名称
	 */
	private java.lang.String stationName;
	
	/**
	 * 岗位备注
	 */
	private java.lang.String stationNotes;
	
	/**
	 * 岗位类型(开始)
	 */
	private Integer stationTypeBegin;
	
	/**
	 * 岗位类型(结束)
	 */
	private Integer stationTypeEnd;
	
	/**
	 * 岗位权限(开始)
	 */
	private Integer stationPrivateTypeBegin;
	
	/**
	 * 岗位权限(结束)
	 */
	private Integer stationPrivateTypeEnd;
	
	/**
	 * 关系主键(开始)
	 */
	private Long authorIdBegin;
	
	/**
	 * 关系主键(结束)
	 */
	private Long authorIdEnd;
	
	/**
	 * 岗位关系备注干湿
	 */
	private java.lang.String authorNotes;
	
	/**
	 * 流程主键(开始)
	 */
	private Long objIdBegin;
	
	/**
	 * 流程主键(结束)
	 */
	private Long objIdEnd;
	
	/**
	 * 流程编码
	 */
	private java.lang.String objTag;
	
	/**
	 * 流程金额
	 */
	private java.lang.String objAccount;
	
	/**
	 * 流程公式
	 */
	private java.lang.String objFormula;
	
	/**
	 * 流程数量
	 */
	private java.lang.String objAmount;
	
	/**
	 * 流程人数
	 */
	private java.lang.String objStaff;
	
	/**
	 * 是否可用(开始)
	 */
	private Integer isValidBegin;
	
	/**
	 * 是否可用(结束)
	 */
	private Integer isValidEnd;
	
	/**
	 * 不可用原因
	 */
	private java.lang.String unvalidReason;
	
	/**
	 * 创建时间(开始)
	 */
	private java.util.Date createTimeBegin;
	
	/**
	 * 创建时间(结束)
	 */
	private java.util.Date createTimeEnd;
	
	/**
	 * 分页页码
	 */
	private Integer pageNo;
	
	/**
	 * 分页步长
	 */
	private Integer pageSize;
			
	public Long getFlowIdBegin() {
		return this.flowIdBegin;
	}
	
	public void setFlowIdBegin(Long value) {
		this.flowIdBegin = value;
	}
	
	public Long getFlowIdEnd() {
		return this.flowIdEnd;
	}
	
	public void setFlowIdEnd(Long value) {
		this.flowIdEnd = value;
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
	public java.lang.String getStaffName() {
		return this.staffName;
	}
	
	public void setStaffName(java.lang.String value) {
		this.staffName = value;
	}	    	
	public Long getOrganizeIdBegin() {
		return this.organizeIdBegin;
	}
	
	public void setOrganizeIdBegin(Long value) {
		this.organizeIdBegin = value;
	}
	
	public Long getOrganizeIdEnd() {
		return this.organizeIdEnd;
	}
	
	public void setOrganizeIdEnd(Long value) {
		this.organizeIdEnd = value;
	}
	public java.lang.String getOrganizeName() {
		return this.organizeName;
	}
	
	public void setOrganizeName(java.lang.String value) {
		this.organizeName = value;
	}	    	
	public Integer getOrganizeTypeBegin() {
		return this.organizeTypeBegin;
	}
	
	public void setOrganizeTypeBegin(Integer value) {
		this.organizeTypeBegin = value;
	}
	
	public Integer getOrganizeTypeEnd() {
		return this.organizeTypeEnd;
	}
	
	public void setOrganizeTypeEnd(Integer value) {
		this.organizeTypeEnd = value;
	}
	public Long getStationIdBegin() {
		return this.stationIdBegin;
	}
	
	public void setStationIdBegin(Long value) {
		this.stationIdBegin = value;
	}
	
	public Long getStationIdEnd() {
		return this.stationIdEnd;
	}
	
	public void setStationIdEnd(Long value) {
		this.stationIdEnd = value;
	}
	public java.lang.String getStationCode() {
		return this.stationCode;
	}
	
	public void setStationCode(java.lang.String value) {
		this.stationCode = value;
	}	    	
	public java.lang.String getStationName() {
		return this.stationName;
	}
	
	public void setStationName(java.lang.String value) {
		this.stationName = value;
	}	    	
	public java.lang.String getStationNotes() {
		return this.stationNotes;
	}
	
	public void setStationNotes(java.lang.String value) {
		this.stationNotes = value;
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
	public Integer getStationPrivateTypeBegin() {
		return this.stationPrivateTypeBegin;
	}
	
	public void setStationPrivateTypeBegin(Integer value) {
		this.stationPrivateTypeBegin = value;
	}
	
	public Integer getStationPrivateTypeEnd() {
		return this.stationPrivateTypeEnd;
	}
	
	public void setStationPrivateTypeEnd(Integer value) {
		this.stationPrivateTypeEnd = value;
	}
	public Long getAuthorIdBegin() {
		return this.authorIdBegin;
	}
	
	public void setAuthorIdBegin(Long value) {
		this.authorIdBegin = value;
	}
	
	public Long getAuthorIdEnd() {
		return this.authorIdEnd;
	}
	
	public void setAuthorIdEnd(Long value) {
		this.authorIdEnd = value;
	}
	public java.lang.String getAuthorNotes() {
		return this.authorNotes;
	}
	
	public void setAuthorNotes(java.lang.String value) {
		this.authorNotes = value;
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
	public java.lang.String getObjTag() {
		return this.objTag;
	}
	
	public void setObjTag(java.lang.String value) {
		this.objTag = value;
	}	    	
	public java.lang.String getObjAccount() {
		return this.objAccount;
	}
	
	public void setObjAccount(java.lang.String value) {
		this.objAccount = value;
	}	    	
	public java.lang.String getObjFormula() {
		return this.objFormula;
	}
	
	public void setObjFormula(java.lang.String value) {
		this.objFormula = value;
	}	    	
	public java.lang.String getObjAmount() {
		return this.objAmount;
	}
	
	public void setObjAmount(java.lang.String value) {
		this.objAmount = value;
	}	    	
	public java.lang.String getObjStaff() {
		return this.objStaff;
	}
	
	public void setObjStaff(java.lang.String value) {
		this.objStaff = value;
	}	    	
	public Integer getIsValidBegin() {
		return this.isValidBegin;
	}
	
	public void setIsValidBegin(Integer value) {
		this.isValidBegin = value;
	}
	
	public Integer getIsValidEnd() {
		return this.isValidEnd;
	}
	
	public void setIsValidEnd(Integer value) {
		this.isValidEnd = value;
	}
	public java.lang.String getUnvalidReason() {
		return this.unvalidReason;
	}
	
	public void setUnvalidReason(java.lang.String value) {
		this.unvalidReason = value;
	}	    	
	public java.util.Date getCreateTimeBegin() {
		return this.createTimeBegin;
	}
	
	public void setCreateTimeBegin(java.util.Date value) {
		this.createTimeBegin = value;
	}
	
	public java.util.Date getCreateTimeEnd() {
		return this.createTimeEnd;
	}
	
	public void setCreateTimeEnd(java.util.Date value) {
		this.createTimeEnd = value;
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

