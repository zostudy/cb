package com.asiainfo.rms.workflow.dto.process.cb;

import com.asiainfo.rms.workflow.dto.process.common.ExecuteProcessDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbSalaryDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 薪酬流程
 * 
 * @author joker
 */
@Data
@ApiModel(description = "薪酬流程")
public class ExecuteSalaryProcessDTO {
	
	@ApiModelProperty(value = "")
	private AlmCbSalaryDTO almCbSalaryDTO;

	@ApiModelProperty(value = "金额")
	private AlmCbFlowDTO[] almCbFlowDTOs;
	
	@ApiModelProperty(value = "流程启动信息")
	private ExecuteProcessDTO executeProcessDTO;
}