package com.asiainfo.rms.workflow.domain.workflow;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author 刘超
 *
 */
@Entity
@Table(name="ALM_WORKFLOW")
public class BOAlmWorkflow implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7855606558250809476L;

	@Id@Column(name="WF_ITEM_ID",length=12)
	@GeneratedValue(generator="workflowSeq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName="ALM_WORKFLOW$SEQ",name="workflowSeq",initialValue=1,allocationSize=1)
	private Long wfItemId;
	
	@Column(name="PROCESS_KEY",length=200)
	private String processKey;
	
	@Column(name="PHASE_ID",length=32)
	private String phaseId;
	
	@Column(name="PHASE_NAME",length=128)
	private String phaseName;
	
	@Column(name="VM_TASK_NAME",length=128)
	private String vmTaskName;
	
	@Column(name="VM_TASK_NO",length=32)
	private String vmTaskNo;
	
	@Column(name="LINK_ID",length=12)
	private Long linkId;
	
	@Column(name="LINK_NO",length=32)
	private String linkNo;
	
	@Column(name="LINK_NO_TYPE",length=20)
	private String linkNoType;
	
	@Column(name="ROLE_CODE",length=40)
	private String roleCode;
	
	@Column(name="LINK_URL",length=1000)
	private String linkUrl;
	
	@Column(name="IS_PRINT",length=1)
	private Long isPrint;

	public Long getWfItemId() {
		return wfItemId;
	}

	public void setWfItemId(Long wfItemId) {
		this.wfItemId = wfItemId;
	}

	public String getProcessKey() {
		return processKey;
	}

	public void setProcessKey(String processKey) {
		this.processKey = processKey;
	}

	public String getPhaseId() {
		return phaseId;
	}

	public void setPhaseId(String phaseId) {
		this.phaseId = phaseId;
	}

	public String getPhaseName() {
		return phaseName;
	}

	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	public String getVmTaskName() {
		return vmTaskName;
	}

	public void setVmTaskName(String vmTaskName) {
		this.vmTaskName = vmTaskName;
	}

	public String getVmTaskNo() {
		return vmTaskNo;
	}

	public void setVmTaskNo(String vmTaskNo) {
		this.vmTaskNo = vmTaskNo;
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

	public String getLinkNoType() {
		return linkNoType;
	}

	public void setLinkNoType(String linkNoType) {
		this.linkNoType = linkNoType;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	
	public Long getIsPrint() {
		return isPrint;
	}

	public void setIsPrint(Long isPrint) {
		this.isPrint = isPrint;
	}
	
}
