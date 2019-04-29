package com.asiainfo.rms.workflow.dto.process.common;

import java.util.List;

import com.asiainfo.rms.workflow.dto.workflow.StakeholderDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "执行流程信息")
public class ExecuteProcessDTO {
	
	@ApiModelProperty(value = "工单主键", required = true)
    private Long orderId;
	
	@ApiModelProperty(value = "环节处理人列表", required = true)
    private List<StakeholderDTO> stds;
	
	@ApiModelProperty(value = "处理意见", required = true)
    private String opinion;
	
	@ApiModelProperty(value = "计划完成时间", required = true)
    private String plantime;

	@ApiModelProperty(value = "处理结果", example="通过: P, 不通过: R, 保留意见: D", required = true)
    private String result;

	@ApiModelProperty(value = "流程流转方向", example="通过: P, 结束: E", required = true)
	private String direction;
}
