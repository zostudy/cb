//package com.asiainfo.rms.workflow.processRoam;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
//import javax.transaction.Transactional;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//
//import com.asiainfo.rms.workflow.common.constance.ConstDefine;
//import com.asiainfo.rms.workflow.dao.CommonDAO;
//import com.asiainfo.rms.workflow.dto.req.BOAlmRequisition;
//import com.asiainfo.rms.workflow.dto.version.BOAlmVer;
//import com.asiainfo.rms.workflow.dto.workflow.BOAlmStakeholder;
//import com.asiainfo.rms.workflow.service.process.IAlmProcessRoamSV;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@Transactional(rollbackOn = Exception.class)
//@TransactionConfiguration(defaultRollback = false)
//public class TestUrgentVersionProcess {
//
//	@Autowired
//	private IAlmProcessRoamSV roamSV;
//
//	@Autowired
//	private CommonDAO dao;
//
//	/**
//	 * 保存开始工单
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	public void createWorkflow() throws Exception {
//		String version = UUID.randomUUID().toString();
//
//		BOAlmRequisition req = new BOAlmRequisition();
//		req.setCreateTime(new Date());
//		req.setCurPhase(1);
//		req.setCurStatus(1);
//		req.setPlanTime(new Date());
//		req.setReqName("紧急版本需求_" + version);
//		req.setReqTag("UV_20170804_" + version);
//		dao.save(req);
//
//		List<BOAlmStakeholder> stds = new ArrayList<>();
//
//		BOAlmStakeholder std = new BOAlmStakeholder();
//		std.setCreateTime(new Date());
//		std.setLinkId(30001l);
//		std.setLinkNo("CreateUrgentVersion_uv");
//		std.setProcessKey(ConstDefine.TEMPLATE_KEY_WORKFLOW_URGENTVERSION);
//		std.setStdholderStaffId(1l);
//		std.setStdholderStaffName("创建紧急版本_人员");
//		std.setStdholdeType("2");
//
//		stds.add(std);
//
//		BOAlmStakeholder std2 = new BOAlmStakeholder();
//		std2.setCreateTime(new Date());
//		std2.setLinkId(30002l);
//		std2.setLinkNo("BusiReqMgrPro_uv");
//		std2.setProcessKey(ConstDefine.TEMPLATE_KEY_WORKFLOW_URGENTVERSION);
//		std2.setStdholderStaffId(2l);
//		std2.setStdholderStaffName("业务部门需求管理员处理_人员");
//		std2.setStdholdeType("2");
//
//		stds.add(std2);
//
//		roamSV.saveStakeholder(req.getReqId().toString(), ConstDefine.OBJ_TYPE_URGENTVERSION, stds);
//
//		roamSV.createStartSaveOrder(ConstDefine.TEMPLATE_PATH_WORKFLOW_URGENTVERSION, req.getReqId().toString(),
//				ConstDefine.OBJ_TYPE_URGENTVERSION, ConstDefine.TEMPLATE_KEY_WORKFLOW_URGENTVERSION,
//				"<conds><staffId>2</staffId></conds>", ConstDefine.TEMPLATE_NAME_WORKFLOW_URGENTVERSION);
//	}
//
//	/**
//	 * 启动流程
//	 * 
//	 * @throws Exception
//	 */
////	@Test
////	@Transactional(rollbackOn = Exception.class)
////	public void startWorkflow() throws Exception {
////		roamSV.createWorkflow(ConstDefine.TEMPLATE_KEY_WORKFLOW_URGENTVERSION, "1", ConstDefine.OBJ_TYPE_URGENTVERSION,
////				"104", "<conds><staffId>1</staffId></conds>");
////	}
//
//	/**
//	 * 业务部门需求管理员处理
//	 * 
//	 * @throws Exception
//	 */
////	@Test
////	@Transactional(rollbackOn = Exception.class)
////	public void finishUserTaskBusiReqMgrPro() throws Exception {
////		List<BOAlmStakeholder> stds = new ArrayList<>();
////
////		BOAlmStakeholder std = new BOAlmStakeholder();
////		std.setCreateTime(new Date());
////		std.setLinkId(30003l);
////		std.setLinkNo("BusiSupLeadVerify_uv");
////		std.setProcessKey(ConstDefine.TEMPLATE_KEY_WORKFLOW_URGENTVERSION);
////		std.setStdholderStaffId(3l);
////		std.setStdholderStaffName("业支主任审核_人员");
////		std.setStdholdeType("2");
////
////		stds.add(std);
////
////		roamSV.saveStakeholder("104", ConstDefine.OBJ_TYPE_URGENTVERSION, stds);
////
////		roamSV.finishUserTask(42l, "Y", "回单结束", "<conds><staffId>3</staffId><verify>N</verify></conds>");
////	}
//
//	/**
//	 * 业支主任审核
//	 * 
//	 * @throws Exception
//	 */
////	@Test
////	@Transactional(rollbackOn = Exception.class)
////	public void finishBusiSupLeadVerify() throws Exception {
////		List<BOAlmStakeholder> stds = new ArrayList<>();
////
////		BOAlmStakeholder std = new BOAlmStakeholder();
////		std.setCreateTime(new Date());
////		std.setLinkId(30004l);
////		std.setLinkNo("BusiLeaderSign_uv");
////		std.setProcessKey(ConstDefine.TEMPLATE_KEY_WORKFLOW_URGENTVERSION);
////		std.setStdholderStaffId(4l);
////		std.setStdholderStaffName("业务部门领导会签_人员_00");
////		std.setStdholdeType("2");
////
////		stds.add(std);
////
////		std = new BOAlmStakeholder();
////		std.setCreateTime(new Date());
////		std.setLinkId(30004l);
////		std.setLinkNo("BusiLeaderSign_uv");
////		std.setProcessKey(ConstDefine.TEMPLATE_KEY_WORKFLOW_URGENTVERSION);
////		std.setStdholderStaffId(5l);
////		std.setStdholderStaffName("业务部门领导会签_人员_01");
////		std.setStdholdeType("2");
////
////		stds.add(std);
////
////		roamSV.saveStakeholder("102", ConstDefine.OBJ_TYPE_URGENTVERSION, stds);
////
////		roamSV.finishUserTask(34l, "Y", "回单结束", "<conds><staffList><staffId>4</staffId><staffId>5</staffId></staffList><verify>Y</verify></conds>");
////	}
//
//	/**
//	 * 业务部门领导会签
//	 * 
//	 * @throws Exception
//	 */
////	@Test
////	@Transactional(rollbackOn = Exception.class)
////	public void finishUserTaskBusiLeaderSign() throws Exception {
////		List<BOAlmStakeholder> stds = new ArrayList<>();
////
////		BOAlmStakeholder std = new BOAlmStakeholder();
////		std.setCreateTime(new Date());
////		std.setLinkId(30005l);
////		std.setLinkNo("CompLeadColt_uv");
////		std.setProcessKey(ConstDefine.TEMPLATE_KEY_WORKFLOW_URGENTVERSION);
////		std.setStdholderStaffId(6l);
////		std.setStdholderStaffName("公司领导汇总_人员");
////		std.setStdholdeType("2");
////
////		stds.add(std);
////
////		roamSV.saveStakeholder("102", ConstDefine.OBJ_TYPE_URGENTVERSION, stds);
////
////		roamSV.finishUserTask(35l, "Y", "回单结束", "<conds><staffId>5</staffId><verify>Y</verify></conds>");
////	}
//
//	/**
//	 * 公司领导汇总
//	 * 
//	 * @throws Exception
//	 */
////	@Test
////	@Transactional(rollbackOn = Exception.class)
////	public void finishUserTaskCompLeadColt() throws Exception {
////		List<BOAlmStakeholder> stds = new ArrayList<>();
////
////		BOAlmStakeholder std = new BOAlmStakeholder();
////		std.setCreateTime(new Date());
////		std.setLinkId(30006l);
////		std.setLinkNo("FactVerMgrPro_uv");
////		std.setProcessKey(ConstDefine.TEMPLATE_KEY_WORKFLOW_URGENTVERSION);
////		std.setStdholderStaffId(7l);
////		std.setStdholderStaffName("厂商版本管理员处理_人员");
////		std.setStdholdeType("2");
////
////		stds.add(std);
////
////		roamSV.saveStakeholder("102", ConstDefine.OBJ_TYPE_URGENTVERSION, stds);
////
////		roamSV.finishUserTask(37l, "Y", "回单结束", "<conds><staffId>6</staffId><verify>Y</verify></conds>");
////	}
//
//	/**
//	 * 厂商版本管理员处理
//	 * 
//	 * @throws Exception
//	 */
////	@Test
////	@Transactional(rollbackOn = Exception.class)
////	public void finishUserTaskFactVerMgrPro() throws Exception {
////
////		roamSV.finishUserTask(38l, "Y", "回单结束", "<conds><staffId>7</staffId><verify>Y</verify></conds>");
////	}
//
////	@Test
////	@Transactional(rollbackOn = Exception.class)
////	public void finishUserTaskB() throws Exception {
////		roamSV.finishUserTask(3l, "Y", "回单结束", "<conds></conds>");
////	}
//}
