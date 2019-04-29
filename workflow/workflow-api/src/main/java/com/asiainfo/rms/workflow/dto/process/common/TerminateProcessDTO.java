package com.asiainfo.rms.workflow.dto.process.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "终止流程信息")
public class TerminateProcessDTO {
	
	@ApiModelProperty(value = "流程部署主键")
	private Long deployId;

	@ApiModelProperty(value = "流程实例主键")
	private Long procInstId;
	
	@ApiModelProperty(value = "业务主键")
	private Long objId;
	
	@ApiModelProperty(value = "处理人主键")
	private String staffId;
	
	@ApiModelProperty(value = "处理人编码")
	private String staffCode;
	
	@ApiModelProperty(value = "处理人姓名")
	private String staffName;
	
	@ApiModelProperty(value = "终止原因")
	private String reason;
}
