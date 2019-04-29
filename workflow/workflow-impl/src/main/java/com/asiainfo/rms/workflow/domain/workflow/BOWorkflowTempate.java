package com.asiainfo.rms.workflow.domain.workflow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ALM_WORKFLOW_TEMPLATE")
public class BOWorkflowTempate {

	@Id@Column(name="TEMPLATE_ID")
	private int templateId;
	@Column(name="PROCESS_KEY")
	private String processKey;
	@Column(name="OBJ_TYPE")
	private String objType;
	@Column(name="PROCESS_NAME")
	private String processName;
	
	
	public int getTemplateId() {
		return templateId;
	}
	public void setTemplateId(int templateId) {
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
