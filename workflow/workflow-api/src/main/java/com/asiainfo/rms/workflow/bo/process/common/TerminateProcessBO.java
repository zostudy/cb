package com.asiainfo.rms.workflow.bo.process.common;

import lombok.Data;

@Data
public class TerminateProcessBO {
	
	private Long deployId;

	private Long procInstId;
	
	private Long objId;
	
	private String objType;
	
	private String staffId;
	
	private String staffCode;
	
	private String staffName;
	
	private String reason;
}
