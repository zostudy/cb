package com.asiainfo.rms.workflow.dto.process.cb;

import com.asiainfo.rms.workflow.dto.process.common.ExecuteProcessDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbRepairBoardDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 修板流程
 * 
 * @author joker
 */
@Data
@ApiModel(description = "修板流程")
public class ExecuteRepairBoardProcessDTO {
	
	@ApiModelProperty(value = "")
	private AlmCbRepairBoardDTO almCbRepairBoardDTO;

	@ApiModelProperty(value = "金额")
	private AlmCbFlowDTO[] almCbFlowDTOs;
	
	@ApiModelProperty(value = "流程启动信息")
	private ExecuteProcessDTO executeProcessDTO;
}