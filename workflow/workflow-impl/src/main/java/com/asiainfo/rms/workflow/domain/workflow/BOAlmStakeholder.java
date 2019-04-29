package com.asiainfo.rms.workflow.domain.workflow;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 
 * @author 刘超
 *
 */
@Entity
@Table(name="ALM_STAKEHOLDER")
@ApiModel(description = "工单处理人信息")
public class BOAlmStakeholder {

	@ApiModelProperty(value = "环节处理人主键")
	@Id@Column(name="STDHOLDER_ID",length=12)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="stakeholderSeq")
	@SequenceGenerator(initialValue = 1, name = "stakeholderSeq", sequenceName = "ALM_STAKEHOLDER$SEQ",allocationSize=1)
	private Long stdholderId;

	@ApiModelProperty(value = "流程主键")
	@Column(name="PROCESS_KEY",length=200)
	private String processKey;
	
	@ApiModelProperty(value = "环节主键")
	@Column(name="LINK_ID",length=12)
	private Long linkId;

	@ApiModelProperty(value = "环节编码")
	@Column(name="LINK_NO",length=32)
	private String linkNo;

	@ApiModelProperty(value = "业务主键")
	@Column(name="OBJ_ID",length=12)
	private Long objId;

	@ApiModelProperty(value = "流程类型")
	@Column(name="OBJ_TYPE",length=2)
	private String objType;

	@ApiModelProperty(value = "角色主键")
	@Column(name="ROLE_ID",length=12)
	private Long roleId;

	@ApiModelProperty(value = "角色编码")
	@Column(name="ROLE_CODE",length=100)
	private String roleCode;

	@ApiModelProperty(value = "处理人归属组织主键")
	@Column(name="STDHOLDER_STAFF_ORG_ID",length=12)
	private Long stdholderStaffOrgId;

	@ApiModelProperty(value = "处理人员工主键")
	@Column(name="STDHOLDER_STAFF_ID",length=12)
	private Long stdholderStaffId;

	@ApiModelProperty(value = "处理人员工编码")
	@Column(name="STDHOLDER_STAFF_NO",length=32)
	private String stdholderStaffNo;

	@ApiModelProperty(value = "处理人员工名字")
	@Column(name="STDHOLDER_STAFF_NAME",length=32)
	private String stdholderStaffName;

	@ApiModelProperty(value = "环节处理人类型")
	@Column(name="STDHOLDE_TYPE",length=2)
	private String stdholdeType;

	@ApiModelProperty(value = "创建日期")
	@Temporal(TemporalType.TIME)@Column(name="CREATE_TIME")
	private Date createTime;

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
