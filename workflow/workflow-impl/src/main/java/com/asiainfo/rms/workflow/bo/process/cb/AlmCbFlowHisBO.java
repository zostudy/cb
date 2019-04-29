package com.asiainfo.rms.workflow.bo.process.cb;

/**
 * 详情表
 * 
 * @author joker
 */
public class AlmCbFlowHisBO {
	
	/**
	 * 历史流水主键
	 */
	private Long hisFlowId;
	
	/**
	 * 流水主键
	 */
	private Long flowId;
	
	/**
	 * 员工主键
	 */
	private Long staffId;
	
	/**
	 * 雇员名称
	 */
	private java.lang.String staffName;
	
	/**
	 * 组织主键
	 */
	private Long organizeId;
	
	/**
	 * 组织名称
	 */
	private java.lang.String organizeName;
	
	/**
	 * 组织权限
	 */
	private Integer organizeType;
	
	/**
	 * 岗位主键
	 */
	private Long stationId;
	
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
	 * 岗位类型
	 */
	private Integer stationType;
	
	/**
	 * 岗位权限
	 */
	private Integer stationPrivateType;
	
	/**
	 * 关系主键
	 */
	private Long authorId;
	
	/**
	 * 岗位关系备注干湿
	 */
	private java.lang.String authorNotes;
	
	/**
	 * 流程主键
	 */
	private Long objId;
	
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
	 * 创建时间
	 */
	private java.util.Date createTime;
	
	/**
	 * 申请人主键
	 */
	private Long appalyStaffId;
	
	/**
	 * 申请人名称
	 */
	private java.lang.String appalyStaffName;
	
	/**
	 * 申请人帐号
	 */
	private java.lang.String appalyStaffCode;
	
	public void setHisFlowId(Long value) {
		this.hisFlowId = value;
	}
	
	public Long getHisFlowId() {
		return this.hisFlowId;
	}
	
	public Long getFlowId() {
		return this.flowId;
	}
	
	public void setFlowId(Long value) {
		this.flowId = value;
	}
	
	public Long getStaffId() {
		return this.staffId;
	}
	
	public void setStaffId(Long value) {
		this.staffId = value;
	}
	
	public java.lang.String getStaffName() {
		return this.staffName;
	}
	
	public void setStaffName(java.lang.String value) {
		this.staffName = value;
	}
	
	public Long getOrganizeId() {
		return this.organizeId;
	}
	
	public void setOrganizeId(Long value) {
		this.organizeId = value;
	}
	
	public java.lang.String getOrganizeName() {
		return this.organizeName;
	}
	
	public void setOrganizeName(java.lang.String value) {
		this.organizeName = value;
	}
	
	public Integer getOrganizeType() {
		return this.organizeType;
	}
	
	public void setOrganizeType(Integer value) {
		this.organizeType = value;
	}
	
	public Long getStationId() {
		return this.stationId;
	}
	
	public void setStationId(Long value) {
		this.stationId = value;
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
	
	public Integer getStationType() {
		return this.stationType;
	}
	
	public void setStationType(Integer value) {
		this.stationType = value;
	}
	
	public Integer getStationPrivateType() {
		return this.stationPrivateType;
	}
	
	public void setStationPrivateType(Integer value) {
		this.stationPrivateType = value;
	}
	
	public Long getAuthorId() {
		return this.authorId;
	}
	
	public void setAuthorId(Long value) {
		this.authorId = value;
	}
	
	public java.lang.String getAuthorNotes() {
		return this.authorNotes;
	}
	
	public void setAuthorNotes(java.lang.String value) {
		this.authorNotes = value;
	}
	
	public Long getObjId() {
		return this.objId;
	}
	
	public void setObjId(Long value) {
		this.objId = value;
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
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public Long getAppalyStaffId() {
		return this.appalyStaffId;
	}
	
	public void setAppalyStaffId(Long value) {
		this.appalyStaffId = value;
	}
	
	public java.lang.String getAppalyStaffName() {
		return this.appalyStaffName;
	}
	
	public void setAppalyStaffName(java.lang.String value) {
		this.appalyStaffName = value;
	}
	
	public java.lang.String getAppalyStaffCode() {
		return this.appalyStaffCode;
	}
	
	public void setAppalyStaffCode(java.lang.String value) {
		this.appalyStaffCode = value;
	}
}

