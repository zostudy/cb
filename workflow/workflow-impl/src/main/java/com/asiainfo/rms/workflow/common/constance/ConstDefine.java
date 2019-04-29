package com.asiainfo.rms.workflow.common.constance;

public class ConstDefine {
	public final static String ADMIN_NO = "administrator";
	public final static String ADMIN_NAME = "管理人员";
	public final static Long ADMIN_ID = 1l;
	
	public final static String AUTO = "autoer";
	public final static String AUTO_NAME = "自动机";
	public final static Long AUTO_ID = 2l;
	/**
	 * 处理人类型: 执行</br>
	 * 值: 1</br>
	 */
	public final static String STDHOLDE_TYPE_EXECUTE = "1";
	/**
	 * 处理人类型: 审批</br>
	 * 值: 2</br>
	 */
	public final static String STDHOLDE_TYPE_APPROVAL = "2";

	/**
	 * 处理人类型: 查看</br>
	 * 值: 3</br>
	 */
	public final static String STDHOLDE_TYPE_VIEW = "3";
	/**
	 * 处理人类型: 通知</br>
	 * 值: 4</br>
	 */
	public final static String STDHOLDE_TYPE_NOTICE = "4";
	/**
	 * 处理人类型: 讨论</br>
	 * 值: 5</br>
	 */
	public final static String STDHOLDE_TYPE_DISCUSS = "5";

	//紧急版本流程
	public final static String OBJ_TYPE_URGENTVERSION = "00";
	public final static String TEMPLATE_ID_WORKFLOW_URGENTVERSION = "800";
	public final static String TEMPLATE_PATH_WORKFLOW_URGENTVERSION = "processes/urgentVersionProcess.bpmn";
	public final static String TEMPLATE_NAME_WORKFLOW_URGENTVERSION = "紧急版本流程";
	public final static String TEMPLATE_KEY_WORKFLOW_URGENTVERSION = "urgentVersionProcess";
	
	
	//需求信息流程
	public final static String OBJ_TYPE_REQ = "01";
	public final static String TEMPLATE_ID_WORKFLOW_REQ = "801";
	public final static String TEMPLATE_PATH_WORKFLOW_REQ = "processes/reqProcess.bpmn";
	public final static String TEMPLATE_NAME_WORKFLOW_REQ = "需求信息流程";
	public final static String TEMPLATE_KEY_WORKFLOW_REQ = "reqProcess";
	
	
	//经分需求流程
	public final static String OBJ_TYPE_BAREQ = "02";
	public final static String TEMPLATE_ID_WORKFLOW_BAREQ = "802";
	public final static String TEMPLATE_PATH_WORKFLOW_BAREQ = "processes/BAreqProcess.bpmn";
	public final static String TEMPLATE_NAME_WORKFLOW_BAREQ = "经分需求流程";
	public final static String TEMPLATE_KEY_WORKFLOW_BAREQ = "BAreqProcess";
	
	
	//版本流程
	public final static String OBJ_TYPE_VERSION = "03";
	public final static String TEMPLATE_ID_WORKFLOW_VERSION = "803";
	public final static String TEMPLATE_PATH_WORKFLOW_VERSION = "processes/versionProcess.bpmn";
	public final static String TEMPLATE_NAME_WORKFLOW_VERSION = "版本流程";
	public final static String TEMPLATE_KEY_WORKFLOW_VERSION = "versionProcess";
	
	
	//版本变更流程
	public final static String OBJ_TYPE_VERSIONCHANGE = "04";
	public final static String TEMPLATE_ID_WORKFLOW_VERSIONCHANGE = "804";
	public final static String TEMPLATE_PATH_WORKFLOW_VERSIONCHANGE = "processes/VersionChangeProcess.bpmn";
	public final static String TEMPLATE_NAME_WORKFLOW_VERSIONCHANGE = "版本变更流程";
	public final static String TEMPLATE_KEY_WORKFLOW_VERSIONCHANGE = "VersionChangeProcess";
	
	
	//电渠流程
	public final static String OBJ_TYPE_ELCCHANEL = "05";
	public final static String TEMPLATE_ID_WORKFLOW_ELCCHANEL = "805";
	public final static String TEMPLATE_PATH_WORKFLOW_ELCCHANEL = "processes/ElcChanelProcess.bpmn";
	public final static String TEMPLATE_NAME_WORKFLOW_ELCCHANEL = "电渠流程";
	public final static String TEMPLATE_KEY_WORKFLOW_ELCCHANEL = "ElcChanelProcess";
	
	
	//缺陷流程
	public final static String OBJ_TYPE_DEFECT = "06";
	public final static String TEMPLATE_ID_WORKFLOW_DEFECT = "806";
	public final static String TEMPLATE_PATH_WORKFLOW_DEFECT = "processes/DefectProcess.bpmn";
	public final static String TEMPLATE_NAME_WORKFLOW_DEFECT = "缺陷流程";
	public final static String TEMPLATE_KEY_WORKFLOW_DEFECT = "DefectProcess";
	
	
	//需求工作量复合流程
	public final static String OBJ_TYPE_REQWORKLOADCHECK = "07";
	public final static String TEMPLATE_ID_WORKFLOW_REQWORKLOADCHECK = "807";
	public final static String TEMPLATE_PATH_WORKFLOW_REQWORKLOADCHECK = "processes/ReqWorkloadCheckProcess.bpmn";
	public final static String TEMPLATE_NAME_WORKFLOW_REQWORKLOADCHECK = "需求工作量复合流程";
	public final static String TEMPLATE_KEY_WORKFLOW_REQWORKLOADCHECK = "ReqWorkloadCheckProcess";
	
	
	//需求工作量结算流程
	public final static String OBJ_TYPE_REQWORKLOADBALANCE = "08";
	public final static String TEMPLATE_ID_WORKFLOW_REQWORKLOADBALANCE = "808";
	public final static String TEMPLATE_PATH_WORKFLOW_REQWORKLOADBALANCE = "processes/ReqWorkloadBalanceProcess.bpmn";
	public final static String TEMPLATE_NAME_WORKFLOW_REQWORKLOADBALANCE = "需求工作量结算流程";
	public final static String TEMPLATE_KEY_WORKFLOW_REQWORKLOADBALANCE = "ReqWorkloadBalanceProcess";
	
	
	//员工定级流程
	public final static String OBJ_TYPE_STAFFGRADE = "09";
	public final static String TEMPLATE_ID_WORKFLOW_STAFFGRADE = "809";
	public final static String TEMPLATE_PATH_WORKFLOW_STAFFGRADE = "processes/staffGradeProcess.bpmn";
	public final static String TEMPLATE_NAME_WORKFLOW_STAFFGRADE = "员工定级流程";
	public final static String TEMPLATE_KEY_WORKFLOW_STAFFGRADE = "staffGradeProcess";
	
	
	//需求交维流程
	public final static String OBJ_TYPE_REQDELIVER = "10";
	public final static String TEMPLATE_ID_WORKFLOW_REQDELIVER = "810";
	public final static String TEMPLATE_PATH_WORKFLOW_REQDELIVER = "processes/ReqDeliverProcess.bpmn";
	public final static String TEMPLATE_NAME_WORKFLOW_REQDELIVER = "需求交维流程";
	public final static String TEMPLATE_KEY_WORKFLOW_REQDELIVER = "ReqDeliverProcess";
	
	
	//集团流程
	public final static String OBJ_TYPE_GROUP = "11";
	public final static String TEMPLATE_ID_WORKFLOW_GROUP = "811";
	public final static String TEMPLATE_PATH_WORKFLOW_GROUP = "processes/GroupProcess.bpmn";
	public final static String TEMPLATE_NAME_WORKFLOW_GROUP = "集团流程";
	public final static String TEMPLATE_KEY_WORKFLOW_GROUP = "GroupProcess";


//	//袁斌水果流程
//	public final static String OBJ_TYPE_YB  = "22";
//	public final static String TEMPLATE_ID_WORKFLOW_YB  = "2003";
//	public final static String TEMPLATE_PATH_WORKFLOW_YB  = "processes/AlmFruitAProcess.bpmn";
//	public final static String TEMPLATE_NAME_WORKFLOW_YB  = "袁斌水果流程";
//	public final static String TEMPLATE_KEY_WORKFLOW_YB  = "AlmFruitAProcess";

	//工作量复核流程
	public final static String OBJ_TYPE_WL_CHECK  = "07";
	public final static String TEMPLATE_ID_WL_CHECK  = "807";
	public final static String TEMPLATE_PATH_WL_CHECK  = "processes/ReqWorkloadCheckProcess.bpmn";
	public final static String TEMPLATE_NAME_WL_CHECK  = "工作量复核流程";
	public final static String TEMPLATE_KEY_WL_CHECK  = "ReqWorkloadCheckProcess";

    //需求审批流程
    public final static String OBJ_TYPE_DemandApproval = "14";
    public final static String TEMPLATE_ID_WORKFLOW_DemandApproval = "814";
    public final static String TEMPLATE_PATH_WORKFLOW_DemandApproval = "processes/DemandApprovalProcess.bpmn";
    public final static String TEMPLATE_NAME_WORKFLOW_DemandApproval = "需求审批流程";
    public final static String TEMPLATE_KEY_WORKFLOW_DemandApproval = "DemandApprovalProcess";

}
