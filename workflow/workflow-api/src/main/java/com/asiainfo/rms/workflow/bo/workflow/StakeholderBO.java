package com.asiainfo.rms.workflow.bo.workflow;

import java.util.Date;

import lombok.Data;

@Data
public class StakeholderBO {

	// 环节处理人主键
	private Long stdholderId;

	// 流程主键
	private String processKey;
	
	// 环节主键
	private Long linkId;

	// 环节编码
	private String linkNo;

	// 业务主键
	private Long objId;

	// 流程类型
	private String objType;

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

	// 环节处理人类型
	private String stdholdeType;

	// 创建日期
	private Date createTime;
	
	
}
