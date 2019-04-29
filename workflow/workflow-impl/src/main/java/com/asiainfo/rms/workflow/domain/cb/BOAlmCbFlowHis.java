package com.asiainfo.rms.workflow.domain.cb;

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
 * 详情表
 * 
 * @author joker
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "ALM_CB_FLOW_HIS")
public class BOAlmCbFlowHis {
	
	// 历史流水主键
	
	private Long hisFlowId;
	// 流水主键
	private Long flowId;
	// 员工主键
	
	private Long staffId;
	// 雇员名称
	@Length(max=200)
	private java.lang.String staffName;
	// 组织主键
	
	private Long organizeId;
	// 组织名称
	@Length(max=200)
	private java.lang.String organizeName;
	// 组织权限
	private Integer organizeType;
	// 岗位主键
	
	private Long stationId;
	// 岗位金额
	@Length(max=40)
	private java.lang.String stationCode;
	// 岗位名称
	@Length(max=60)
	private java.lang.String stationName;
	// 岗位备注
	@Length(max=1000)
	private java.lang.String stationNotes;
	// 岗位类型
	private Integer stationType;
	// 岗位权限
	private Integer stationPrivateType;
	// 关系主键
	
	private Long authorId;
	// 岗位关系备注干湿
	@Length(max=100)
	private java.lang.String authorNotes;
	// 流程主键
	
	private Long objId;
	// 流程编码
	@Length(max=255)
	private java.lang.String objTag;
	// 流程金额
	@Length(max=255)
	private java.lang.String objAccount;
	// 流程公式
	@Length(max=255)
	private java.lang.String objFormula;
	// 流程数量
	@Length(max=255)
	private java.lang.String objAmount;
	// 流程人数
	@Length(max=255)
	private java.lang.String objStaff;
	// 创建时间
	
	private java.util.Date createTime;
	// 申请人主键
	
	private Long appalyStaffId;
	// 申请人名称
	@Length(max=255)
	private java.lang.String appalyStaffName;
	// 申请人帐号
	@Length(max=255)
	private java.lang.String appalyStaffCode;
	
	public void setHisFlowId(Long value) {
		this.hisFlowId = value;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="ALM_CB_FLOW_HIS_SEQ")
	@SequenceGenerator(sequenceName="ALM_CB_FLOW_HIS$SEQ",allocationSize=1,name="ALM_CB_FLOW_HIS_SEQ")
	@Column(name = "HIS_FLOW_ID", unique = true, nullable = false, insertable = true, updatable = true, length = 22)
	public Long getHisFlowId() {
		return this.hisFlowId;
	}
	
	@Column(name = "FLOW_ID", unique = false, nullable = false, insertable = true, updatable = true, length = 22)
	public Long getFlowId() {
		return this.flowId;
	}
	
	public void setFlowId(Long value) {
		this.flowId = value;
	}
	
	@Column(name = "STAFF_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public Long getStaffId() {
		return this.staffId;
	}
	
	public void setStaffId(Long value) {
		this.staffId = value;
	}
	
	@Column(name = "STAFF_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getStaffName() {
		return this.staffName;
	}
	
	public void setStaffName(java.lang.String value) {
		this.staffName = value;
	}
	
	@Column(name = "ORGANIZE_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public Long getOrganizeId() {
		return this.organizeId;
	}
	
	public void setOrganizeId(Long value) {
		this.organizeId = value;
	}
	
	@Column(name = "ORGANIZE_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getOrganizeName() {
		return this.organizeName;
	}
	
	public void setOrganizeName(java.lang.String value) {
		this.organizeName = value;
	}
	
	@Column(name = "ORGANIZE_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public Integer getOrganizeType() {
		return this.organizeType;
	}
	
	public void setOrganizeType(Integer value) {
		this.organizeType = value;
	}
	
	@Column(name = "STATION_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public Long getStationId() {
		return this.stationId;
	}
	
	public void setStationId(Long value) {
		this.stationId = value;
	}
	
	@Column(name = "STATION_CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	public java.lang.String getStationCode() {
		return this.stationCode;
	}
	
	public void setStationCode(java.lang.String value) {
		this.stationCode = value;
	}
	
	@Column(name = "STATION_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 60)
	public java.lang.String getStationName() {
		return this.stationName;
	}
	
	public void setStationName(java.lang.String value) {
		this.stationName = value;
	}
	
	@Column(name = "STATION_NOTES", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public java.lang.String getStationNotes() {
		return this.stationNotes;
	}
	
	public void setStationNotes(java.lang.String value) {
		this.stationNotes = value;
	}
	
	@Column(name = "STATION_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public Integer getStationType() {
		return this.stationType;
	}
	
	public void setStationType(Integer value) {
		this.stationType = value;
	}
	
	@Column(name = "STATION_PRIVATE_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public Integer getStationPrivateType() {
		return this.stationPrivateType;
	}
	
	public void setStationPrivateType(Integer value) {
		this.stationPrivateType = value;
	}
	
	@Column(name = "AUTHOR_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public Long getAuthorId() {
		return this.authorId;
	}
	
	public void setAuthorId(Long value) {
		this.authorId = value;
	}
	
	@Column(name = "AUTHOR_NOTES", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getAuthorNotes() {
		return this.authorNotes;
	}
	
	public void setAuthorNotes(java.lang.String value) {
		this.authorNotes = value;
	}
	
	@Column(name = "OBJ_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public Long getObjId() {
		return this.objId;
	}
	
	public void setObjId(Long value) {
		this.objId = value;
	}
	
	@Column(name = "OBJ_TAG", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	public java.lang.String getObjTag() {
		return this.objTag;
	}
	
	public void setObjTag(java.lang.String value) {
		this.objTag = value;
	}
	
	@Column(name = "OBJ_ACCOUNT", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	public java.lang.String getObjAccount() {
		return this.objAccount;
	}
	
	public void setObjAccount(java.lang.String value) {
		this.objAccount = value;
	}
	
	@Column(name = "OBJ_FORMULA", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	public java.lang.String getObjFormula() {
		return this.objFormula;
	}
	
	public void setObjFormula(java.lang.String value) {
		this.objFormula = value;
	}
	
	@Column(name = "OBJ_AMOUNT", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	public java.lang.String getObjAmount() {
		return this.objAmount;
	}
	
	public void setObjAmount(java.lang.String value) {
		this.objAmount = value;
	}
	
	@Column(name = "OBJ_STAFF", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	public java.lang.String getObjStaff() {
		return this.objStaff;
	}
	
	public void setObjStaff(java.lang.String value) {
		this.objStaff = value;
	}
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", unique = false, nullable = true, insertable = true, updatable = true)
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	@Column(name = "APPALY_STAFF_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public Long getAppalyStaffId() {
		return this.appalyStaffId;
	}
	
	public void setAppalyStaffId(Long value) {
		this.appalyStaffId = value;
	}
	
	@Column(name = "APPALY_STAFF_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	public java.lang.String getAppalyStaffName() {
		return this.appalyStaffName;
	}
	
	public void setAppalyStaffName(java.lang.String value) {
		this.appalyStaffName = value;
	}
	
	@Column(name = "APPALY_STAFF_CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	public java.lang.String getAppalyStaffCode() {
		return this.appalyStaffCode;
	}
	
	public void setAppalyStaffCode(java.lang.String value) {
		this.appalyStaffCode = value;
	}
}

