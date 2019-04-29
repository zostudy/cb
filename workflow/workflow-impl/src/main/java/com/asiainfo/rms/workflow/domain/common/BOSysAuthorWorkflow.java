package com.asiainfo.rms.workflow.domain.common;

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
 * 岗位与工作流关联表
 * 
 * @author joker
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "SYS_AUTHOR_WORKFLOW")
public class BOSysAuthorWorkflow {
	
	// 主键
	private Long sawId;
	// 员工主键
	
	private Long staffId;
	// 工号
	@Length(max=20)
	private java.lang.String code;
	// 雇员名称
	@Length(max=200)
	private java.lang.String employeeName;
	// 手机号码
	@Length(max=50)
	private java.lang.String billId;
	// 组织ID
	
	private java.lang.Long organizeId;
	// 组织名称
	@Length(max=200)
	private java.lang.String organizeName;
	// 组织类型
	private Integer orgType;
	// 创建时间
	
	private java.util.Date createDate;
	// 结束时间
	
	private java.util.Date endDate;
	// 岗位主键
	
	private java.lang.Long stationId;
	// 岗位名称
	@Length(max=60)
	private java.lang.String name;
	// 岗位备注
	@Length(max=1000)
	private java.lang.String notes;
	// 流程类型
	@Length(max=4)
	private java.lang.String objType;
	// 流程实例主键
	
	private Long objId;
	// 环节编码
	
	private java.lang.Long linkId;
	// 环节编号
	@Length(max=32)
	private java.lang.String linkNo;
	// 阶段编号
	@Length(max=32)
	private java.lang.String phaseId;
	// 阶段名称
	@Length(max=128)
	private java.lang.String phaseName;
	// 流程实例编码
	@Length(max=128)
	private java.lang.String objTag;
	// 岗位薪资
	@Length(max=128)
	private java.lang.String stationMoney;
	// 总数量
	@Length(max=128)
	private java.lang.String stationAmount;
	// 总金额
	@Length(max=128)
	private java.lang.String stationAggregate;
	// 岗位类型(平分,独享)
	private Integer type;
	// 岗位人数
	@Length(max=128)
	private java.lang.String stationPeople;

	public void setSawId(Long value) {
		this.sawId = value;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="SYS_AUTHOR_WORKFLOW_SEQ")
	@SequenceGenerator(sequenceName="SYS_AUTHOR_WORKFLOW$SEQ",allocationSize=1,name="SYS_AUTHOR_WORKFLOW_SEQ")
	@Column(name = "SAW_ID", unique = true, nullable = false, insertable = true, updatable = true, length = 22)
	public Long getSawId() {
		return this.sawId;
	}	    
	
	@Column(name = "STAFF_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public Long getStaffId() {
		return this.staffId;
	}
	
	public void setStaffId(Long value) {
		this.staffId = value;
	}
	
	@Column(name = "CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	@Column(name = "EMPLOYEE_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getEmployeeName() {
		return this.employeeName;
	}
	
	public void setEmployeeName(java.lang.String value) {
		this.employeeName = value;
	}
	
	@Column(name = "BILL_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getBillId() {
		return this.billId;
	}
	
	public void setBillId(java.lang.String value) {
		this.billId = value;
	}
	
	@Column(name = "ORGANIZE_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 12)
	public java.lang.Long getOrganizeId() {
		return this.organizeId;
	}
	
	public void setOrganizeId(java.lang.Long value) {
		this.organizeId = value;
	}
	
	@Column(name = "ORGANIZE_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getOrganizeName() {
		return this.organizeName;
	}
	
	public void setOrganizeName(java.lang.String value) {
		this.organizeName = value;
	}
	
	@Column(name = "ORG_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public Integer getOrgType() {
		return this.orgType;
	}
	
	public void setOrgType(Integer value) {
		this.orgType = value;
	}
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", unique = false, nullable = true, insertable = true, updatable = true)
	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(java.util.Date value) {
		this.createDate = value;
	}
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_DATE", unique = false, nullable = true, insertable = true, updatable = true)
	public java.util.Date getEndDate() {
		return this.endDate;
	}
	
	public void setEndDate(java.util.Date value) {
		this.endDate = value;
	}
	
	@Column(name = "STATION_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 12)
	public java.lang.Long getStationId() {
		return this.stationId;
	}
	
	public void setStationId(java.lang.Long value) {
		this.stationId = value;
	}
	
	@Column(name = "NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 60)
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
	
	@Column(name = "OBJ_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 4)
	public java.lang.String getObjType() {
		return this.objType;
	}
	
	public void setObjType(java.lang.String value) {
		this.objType = value;
	}
	
	@Column(name = "OBJ_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public Long getObjId() {
		return this.objId;
	}
	
	public void setObjId(Long value) {
		this.objId = value;
	}
	
	@Column(name = "LINK_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 12)
	public java.lang.Long getLinkId() {
		return this.linkId;
	}
	
	public void setLinkId(java.lang.Long value) {
		this.linkId = value;
	}
	
	@Column(name = "LINK_NO", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getLinkNo() {
		return this.linkNo;
	}
	
	public void setLinkNo(java.lang.String value) {
		this.linkNo = value;
	}
	
	@Column(name = "PHASE_ID", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getPhaseId() {
		return this.phaseId;
	}
	
	public void setPhaseId(java.lang.String value) {
		this.phaseId = value;
	}
	
	@Column(name = "PHASE_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getPhaseName() {
		return this.phaseName;
	}
	
	public void setPhaseName(java.lang.String value) {
		this.phaseName = value;
	}
	
	@Column(name = "OBJ_TAG", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getObjTag() {
		return this.objTag;
	}
	
	public void setObjTag(java.lang.String value) {
		this.objTag = value;
	}
	
	@Column(name = "STATION_MONEY", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getStationMoney() {
		return this.stationMoney;
	}
	
	public void setStationMoney(java.lang.String value) {
		this.stationMoney = value;
	}
	
	@Column(name = "STATION_AMOUNT", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getStationAmount() {
		return this.stationAmount;
	}
	
	public void setStationAmount(java.lang.String value) {
		this.stationAmount = value;
	}
	
	@Column(name = "STATION_AGGREGATE", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getStationAggregate() {
		return this.stationAggregate;
	}
	
	public void setStationAggregate(java.lang.String value) {
		this.stationAggregate = value;
	}
	
	@Column(name = "TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public Integer getType() {
		return this.type;
	}
	
	public void setType(Integer value) {
		this.type = value;
	}
	
	@Column(name = "STATION_PEOPLE", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getStationPeople() {
		return this.stationPeople;
	}
	
	public void setStationPeople(java.lang.String value) {
		this.stationPeople = value;
	}
}

