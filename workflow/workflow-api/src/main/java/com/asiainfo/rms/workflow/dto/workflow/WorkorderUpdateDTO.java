package com.asiainfo.rms.workflow.dto.workflow;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "工单更新信息")
public class WorkorderUpdateDTO {

	@ApiModelProperty(value = "工单主键", required = true)
	private Long orderId;

	@ApiModelProperty(value = "审批结果", required = true)
	private String result;

	@ApiModelProperty(value = "审批意见", required = true)
	private String opinion;

	@ApiModelProperty(value = "计划完成时间", required = true)
	private String plantime;

}
