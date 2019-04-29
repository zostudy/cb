package com.asiainfo.rms.workflow.dto.process.cb;

import com.asiainfo.rms.workflow.dto.process.common.LaunchProcessDTO;
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
public class LaunchSalaryProcessDTO {
	
	@ApiModelProperty(value = "")
	private AlmCbSalaryDTO almCbSalaryDTO;
	
	@ApiModelProperty(value = "流程启动信息")
	private LaunchProcessDTO launchProcessDTO;
}