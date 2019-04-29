package com.asiainfo.rms.workflow.domain.workflow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author 刘超
 *
 */
@Entity @Table(name="ALM_WORKFLOW_TEMPLATE")
public class BOAlmWorkflowTemplate {

	@Id @Column(name="TEMPLATE_ID",length=10)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long templateId;
	
	@Column(name="PROCESS_KEY",length=4000)
	private String processKey;
	
	@Column(name="OBJ_TYPE",length=10)
	private String objType;
	
	@Column(name="PROCESS_NAME",length=200)
	private String processName;

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public String getProcessKey() {
		return processKey;
	}

	public void setProcessKey(String processKey) {
		this.processKey = processKey;
	}

	public String getObjType() {
		return objType;
	}

	public void setObjType(String objType) {
		this.objType = objType;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
}
