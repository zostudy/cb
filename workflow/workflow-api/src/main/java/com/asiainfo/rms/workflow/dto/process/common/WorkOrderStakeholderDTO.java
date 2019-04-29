package com.asiainfo.rms.workflow.dto.process.common;

import com.asiainfo.rms.workflow.dto.workflow.OprStakeholderDTO;
import com.asiainfo.rms.workflow.dto.workflow.WorkorderUpdateDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "工单与干系人更新信息")
public class WorkOrderStakeholderDTO {
	
	@ApiModelProperty(value = "保存环节处理人信息")
	OprStakeholderDTO oprStakeholder;

	@ApiModelProperty(value = "工单更新信息")
	WorkorderUpdateDTO workorderUpdate;
}
