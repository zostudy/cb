package com.asiainfo.rms.workflow.dto.workflow;

import java.util.List;

import com.asiainfo.rms.workflow.dto.common.StakeholderOprDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "保存环节处理人信息")
public class OprStakeholderDTO {

	@ApiModelProperty(value = "业务表主键", required = true)
	private String objId;

	@ApiModelProperty(value = "环节处理人信息组", required = true)
	private List<StakeholderOprDTO> stakeholderOprs; 
}
