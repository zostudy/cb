package com.asiainfo.rms.workflow.dto.common;

import lombok.Data;

@Data
public class WorkflowTempateDTO {

	private int templateId;
	private String processKey;
	private String objType;
	private String processName;
}
