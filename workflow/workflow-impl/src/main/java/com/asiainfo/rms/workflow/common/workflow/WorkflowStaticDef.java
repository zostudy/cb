package com.asiainfo.rms.workflow.common.workflow;

/**
 * 
 * @author 刘超
 *
 */
public class WorkflowStaticDef {

	public final static long ADMIN_ID = 1;
	public final static String ADMIN_NO = "ADMINISTRATOR";
	// 工单状态
	// 等待打单
	public final static String WO_STATUS_CREATE = "1";
	// 等待处理
	public final static String WO_STATUS_RECEIVE = "2";
	// 完成处理
	public final static String WO_STATUS_COMPLETE = "3";
	// 工单加锁
	public final static String WO_STATUS_LOCK = "4";
	// 抄送工单
	public final static String WO_STATUS_COPY = "10";
	// 等待处理之前的工单
	public final static String WO_STATUS_PRE_RECEIVE = "5";
		
	public final static String WO_SCHEDULE_STATUS_END = "F";
	public final static String WO_SCHEDULE_STATUS_WAIT = "W";

	public final static int WF_CASE_STATUS_ALLOW = 2;
	public final static int WF_CASE_STATUS_EX = 99;

	public final static String LINK_NO_TYPE_MGR = "mgr";
	public final static String LINK_NO_TYPE_START = "start";
	public final static String LINK_NO_TYPE_END = "end";
	public final static String LINK_NO_TYPE_TERMINATION = "termination";
	public final static String LINK_NO_TYPE_USER = "user";
	public final static String LINK_NO_TYPE_SIGN = "sign";

	public final static String LINK_NO_MEETING = "meeting";

	public final static String IS_CURRENT_TASK = "Y";
	public final static String IS_NOT_CURRENT_TASK = "N";
	// 工单没有父工单
	public final static Long WO_NO_PARENT = -1l;

	public final static Long WO_NO_WORKFLOW_ID = -1l;

	public final static Long WO_NO_LASTORDER_ID = -1l;

	public final static Long WO_NO_VM_TASK_ID = -1l;

	public final static Long WO_NO_LAST_VM_TASK_ID = -1l;

	public final static Long WO_NO_PARENT_VM_TASK_ID = -1l;
	
	public final static String WO_DEAL_TYPE_APPROVE = "2";
	public final static String WO_DEAL_TYPE_REAUTHORIZE = "5";
	public final static String WO_DEAL_TYPE_COPY = "6";
	public final static String WO_DEAL_TYPE_ANSWER = "7";
	public final static String WO_DEAL_TYPE_REQEXM = "8";

	// 流程审批
	public final static String STAKEHOLDERTYPE_WF = "2";
	public final static String STAKEHOLDERTYPE_DISCUSS = "1";
	public final static String STAKEHOLDERTYPE_NOTICE = "3";
	public final static String STAKEHOLDERTYPE_LOCK = "4";
	public final static String STAKEHOLDERTYPE_ANSWER = "7";
	public final static String STAKEHOLDERTYPE_COPY = "6";
	public final static String STAKEHOLDERTYPE_REQEXM = "8";

	// 工单是否上锁
	public final static Long LOCK = 1l;
	public final static Long NO_LOCK = 0l;

	// 是否需要打单
	public final static Long PRINT = 1l;
	public final static Long NO_PRINT = 0l;

	// 打单状态
	public final static Long FINISH_PRINT = 1l;
	public final static Long NO_FINISH_PRINT = 0l;
	public final static Long NOT_NEED_PRINT = 2l;

	// 工单审批结果
	// 同意
	public final static String WO_APPROVAL_RESULT_PASS = "Y";
	// 不同意
	public final static String WO_APPROVAL_RESULT_NO_PASS = "N";
	// 没意见
	public final static String WO_APPROVAL_RESULT_NO_OPTION = "O";
}
