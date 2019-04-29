package com.asiainfo.rms.workflow.domain.workflow;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author 刘超
 *
 */
@Entity
@Table(name="ALM_HIS_STAKEHOLDER")
public class BOAlmHisStakeholder {

	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="hisStakeholderSeq")
	@SequenceGenerator(initialValue = 1, name = "hisStakeholderSeq", sequenceName = "ALM_HIS_STAKEHOLDER$SEQ",allocationSize=1)
	@Column(name="HIS_STDHOLDER_ID",length=12)
	private Long hisStdholderId;
	
	@Column(name="STDHOLDER_ID",length=12)
	private Long stdholderId;
	
	@Column(name="PROCESS_KEY",length=200)
	private String processKey;
	
	@Column(name="LINK_ID",length=12)
	private Long linkId;
	
	@Column(name="LINK_NO",length=32)
	private String linkNo;
	
	@Column(name="OBJ_ID",length=12)
	private Long objId;
	
	@Column(name="OBJ_TYPE",length=2)
	private String objType;
	
	@Column(name="ROLE_ID",length=12)
	private Long roleId;
	
	@Column(name="ROLE_CODE",length=100)
	private String roleCode;
	
	@Column(name="STDHOLDER_STAFF_ORG_ID",length=12)
	private Long stdholderStaffOrgId;
	
	@Column(name="STDHOLDER_STAFF_ID",length=12)
	private Long stdholderStaffId;
	
	@Column(name="STDHOLDER_STAFF_NO",length=32)
	private String stdholderStaffNo;
	
	@Column(name="STDHOLDER_STAFF_NAME",length=32)
	private String stdholderStaffName;
	
	@Column(name="STDHOLDE_TYPE",length=2)
	private String stdholdeType;
	
	@Temporal(TemporalType.TIME)@Column(name="CREATE_TIME")
	private Date createTime;

	public Long getHisStdholderId() {
		return hisStdholderId;
	}

	public void setHisStdholderId(Long hisStdholderId) {
		this.hisStdholderId = hisStdholderId;
	}

	public Long getStdholderId() {
		return stdholderId;
	}

	public void setStdholderId(Long stdholderId) {
		this.stdholderId = stdholderId;
	}

	public String getProcessKey() {
		return processKey;
	}

	public void setProcessKey(String processKey) {
		this.processKey = processKey;
	}

	public Long getLinkId() {
		return linkId;
	}

	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}

	public String getLinkNo() {
		return linkNo;
	}

	public void setLinkNo(String linkNo) {
		this.linkNo = linkNo;
	}

	public Long getObjId() {
		return objId;
	}

	public void setObjId(Long objId) {
		this.objId = objId;
	}

	public String getObjType() {
		return objType;
	}

	public void setObjType(String objType) {
		this.objType = objType;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public Long getStdholderStaffOrgId() {
		return stdholderStaffOrgId;
	}

	public void setStdholderStaffOrgId(Long stdholderStaffOrgId) {
		this.stdholderStaffOrgId = stdholderStaffOrgId;
	}

	public Long getStdholderStaffId() {
		return stdholderStaffId;
	}

	public void setStdholderStaffId(Long stdholderStaffId) {
		this.stdholderStaffId = stdholderStaffId;
	}

	public String getStdholderStaffNo() {
		return stdholderStaffNo;
	}

	public void setStdholderStaffNo(String stdholderStaffNo) {
		this.stdholderStaffNo = stdholderStaffNo;
	}

	public String getStdholderStaffName() {
		return stdholderStaffName;
	}

	public void setStdholderStaffName(String stdholderStaffName) {
		this.stdholderStaffName = stdholderStaffName;
	}

	public String getStdholdeType() {
		return stdholdeType;
	}

	public void setStdholdeType(String stdholdeType) {
		this.stdholdeType = stdholdeType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
