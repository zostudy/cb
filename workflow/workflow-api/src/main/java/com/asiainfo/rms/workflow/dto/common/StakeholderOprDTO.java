package com.asiainfo.rms.workflow.dto.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "环节处理人信息")
public class StakeholderOprDTO {
	
	@ApiModelProperty(value = "环节主键", required = true)
	private Long linkId;

	@ApiModelProperty(value = "环节编码", required = true)
	private String linkNo;

	@ApiModelProperty(value = "角色主键", required = true)
	private Long roleId;

	@ApiModelProperty(value = "角色编码", required = true)
	private String roleCode;

	@ApiModelProperty(value = "环节处理人归属组织主键", required = true)
	private Long stdholderStaffOrgId;

	@ApiModelProperty(value = "环节处理人员工主键", required = true)
	private Long stdholderStaffId;

	@ApiModelProperty(value = "环节处理人员工编码", required = true)
	private String stdholderStaffNo;

	@ApiModelProperty(value = "环节处理人员工名字", required = true)
	private String stdholderStaffName;

	@ApiModelProperty(value = "删除标识", required = true, example = "true: 删除, false: 保存")
	private Boolean isDelete;

}
