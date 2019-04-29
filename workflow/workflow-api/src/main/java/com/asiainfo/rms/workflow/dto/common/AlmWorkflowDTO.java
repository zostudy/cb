package com.asiainfo.rms.workflow.dto.common;

import lombok.Data;

@Data
public class AlmWorkflowDTO {
	private Long wfItemId;
	private String processKey;
	private String phaseId;
	private String phaseName;
	private String vmTaskName;
	private String vmTaskNo;
	private Long linkId;
	private String linkNo;
	private String linkNoType;
	private String roleCode;
	private String linkUrl;
	private Long isPrint;
}
