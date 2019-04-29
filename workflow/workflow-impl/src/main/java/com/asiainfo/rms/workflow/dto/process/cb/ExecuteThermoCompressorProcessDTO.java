package com.asiainfo.rms.workflow.dto.process.cb;

import com.asiainfo.rms.workflow.dto.process.common.ExecuteProcessDTO;
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
public class ExecuteThermoCompressorProcessDTO {
	
	@ApiModelProperty(value = "")
	private AlmCbThermoCompressorDTO almCbThermoCompressorDTO;

	@ApiModelProperty(value = "金额")
	private AlmCbFlowDTO[] almCbFlowDTOs;
	
	@ApiModelProperty(value = "流程启动信息")
	private ExecuteProcessDTO executeProcessDTO;
}