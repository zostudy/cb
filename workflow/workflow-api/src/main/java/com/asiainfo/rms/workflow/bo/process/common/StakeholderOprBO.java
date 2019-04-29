package com.asiainfo.rms.workflow.bo.process.common;

import lombok.Data;

@Data
public class StakeholderOprBO {
	
	// 环节主键
	private Long linkId;

	// 环节编码
	private String linkNo;

	// 角色主键
	private Long roleId;

	// 角色编码
	private String roleCode;

	// 环节处理人归属组织主键
	private Long stdholderStaffOrgId;

	// 环节处理人员工主键
	private Long stdholderStaffId;

	// 环节处理人员工编码
	private String stdholderStaffNo;

	// 环节处理人员工名字
	private String stdholderStaffName;

	// 删除标识 true: 删除, false: 保存
	private Boolean isDelete;

}
