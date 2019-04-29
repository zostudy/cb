package com.asiainfo.rms.workflow.bo.workflow;

import java.util.Date;

import lombok.Data;

@Data
public class WorkorderBO {
	private Long orderId;
	
	private Long deployId;
	
	private Long procInstId;
	
	private Long parentOrderId;
	
	private Long lastOrderId;
	
	private Long actTaskId;
	
	private Long parentActTaskId;
	
	private Long lastActTaskId;
	
	private Long linkId;
	
	private String isCurrentTask;
	
	private String orderType;
	
	private Long objId;
	
	private String objType;
	
	private String dealType;
	
	private Long isLock;
	
	private Long finishPrint;
	
	private Long execRoleId;
	
	private Long execStaffId;
	
	private Long lockRoleId;
	
	private Long lockStaffId;
	
	private String result;
	
	private String cond;
	
	private String status;
	
	private String opinion;
	
	private String lockOpinion;
	
	private Date creatTime;
	
	private Date recvTime;
	
	private Date lockTime;
	
	private Date realseLockTime;
	
	private Date execTime;
	
	private Date finishTime;
	
	private Long lockTimes;
	
	private Long execTimes;

	private String alarmFlg;

	private Long alarmTimes;

	private Date prealarmTime;

	private Date alarmTime;

	private Date delayTime;

	private Long warningFlag;

	private Long smgflag;

	private String nextLinkPlantime;

	private String plantimeTemp;

	private String operType;
}
