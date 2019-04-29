package com.asiainfo.rms.workflow.bo.workflow;

import lombok.Data;

@Data
public class WorkflowTempateBO {
	private int templateId;
	private String processKey;
	private String objType;
	private String processName;
}
