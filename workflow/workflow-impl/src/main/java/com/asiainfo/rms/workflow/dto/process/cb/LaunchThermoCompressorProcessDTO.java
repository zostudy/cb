package com.asiainfo.rms.workflow.dto.process.cb;

import com.asiainfo.rms.workflow.dto.process.common.LaunchProcessDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbThermoCompressorDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 热压机流程
 * 
 * @author joker
 */
@Data
@ApiModel(description = "热压机流程")
public class LaunchThermoCompressorProcessDTO {
	
	@ApiModelProperty(value = "")
	private AlmCbThermoCompressorDTO almCbThermoCompressorDTO;
	
	@ApiModelProperty(value = "流程启动信息")
	private LaunchProcessDTO launchProcessDTO;
}