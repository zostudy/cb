package com.asiainfo.rms.workflow.dto.process.cb;

import com.asiainfo.rms.workflow.dto.process.common.LaunchProcessDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbSawBoardDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 锯板流程
 * 
 * @author joker
 */
@Data
@ApiModel(description = "锯板流程")
public class LaunchSawBoardProcessDTO {
	
	@ApiModelProperty(value = "")
	private AlmCbSawBoardDTO almCbSawBoardDTO;
	
	@ApiModelProperty(value = "流程启动信息")
	private LaunchProcessDTO launchProcessDTO;
}