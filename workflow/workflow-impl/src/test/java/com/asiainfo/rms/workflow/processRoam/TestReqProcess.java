//package com.asiainfo.rms.workflow.processRoam;
//
//import com.asiainfo.rms.workflow.dao.CommonDAO;
//import com.asiainfo.rms.workflow.dto.req.BOAlmRequisition;
//import com.asiainfo.rms.workflow.dto.workflow.BOAlmStakeholder;
//import com.asiainfo.rms.workflow.service.process.IAlmProcessRoamSV;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by liuchao on 2017/7/18.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@Transactional(rollbackOn = Exception.class)
//@TransactionConfiguration(defaultRollback=false)
//public class TestReqProcess {
//
//    @Autowired
//    private IAlmProcessRoamSV roamSV;
//
//    @Autowired
//    private CommonDAO dao;
//
//    @Test
//    public void createWorkflow() throws Exception{
//
//        BOAlmRequisition req = new BOAlmRequisition();
//        req.setCreateTime(new Date());
//        req.setCurPhase(1);
//        req.setCurStatus(1);
//        req.setPlanTime(new Date());
//        req.setReqName("测试");
//        req.setReqTag("REQ20170714XXXX");
//        dao.save(req);
//
//        List<BOAlmStakeholder> stds = new ArrayList<>();
//
//        BOAlmStakeholder std = new BOAlmStakeholder();
//        std.setCreateTime(new Date());
//        std.setLinkId(1l);
//        std.setLinkNo("createReq");
//        std.setProcessKey("TestProcess");
//        std.setStdholderStaffId(1l);
//        std.setStdholderStaffName("管理员");
//        std.setStdholdeType("2");
//
//        stds.add(std);
//
//        BOAlmStakeholder std2 = new BOAlmStakeholder();
//        std2.setCreateTime(new Date());
//        std2.setLinkId(2l);
//        std2.setLinkNo("TaskA");
//        std2.setProcessKey("TestProcess");
//        std2.setStdholderStaffId(1l);
//        std2.setStdholderStaffName("管理员");
//        std2.setStdholdeType("2");
//
//        stds.add(std2);
//
//        roamSV.saveStakeholder(req.getReqId().toString(),"1",stds);
//
//        roamSV.createStartSaveOrder("processes/TestProcess.bpmn",req.getReqId().toString(),"1","TestProcess","<conds><staffId>1</staffId></conds>","测试流程");
//    }
//
//    @Test
//    @Transactional(rollbackOn = Exception.class)
//    public void startWorkflow() throws Exception{
//        roamSV.createWorkflow("TestProcess","1","1","21","<conds><staffId>1</staffId></conds>");
//    }
//
//    @Test
//    @Transactional(rollbackOn = Exception.class)
//    public void finishUserTaskA() throws Exception{
//        List<BOAlmStakeholder> stds = new ArrayList<>();
//
//        BOAlmStakeholder std = new BOAlmStakeholder();
//        std.setCreateTime(new Date());
//        std.setLinkId(3l);
//        std.setLinkNo("TaskB");
//        std.setProcessKey("TestProcess");
//        std.setStdholderStaffId(1l);
//        std.setStdholderStaffName("管理员");
//        std.setStdholdeType("2");
//
//        stds.add(std);
//
//        roamSV.saveStakeholder("21","1",stds);
//
//        roamSV.finishUserTask(2l,"Y","回单结束","<conds><staffId>1</staffId></conds>");
//    }
//
//    @Test
//    @Transactional(rollbackOn = Exception.class)
//    public void finishUserTaskB()throws Exception{
//        roamSV.finishUserTask(3l,"Y","回单结束","<conds></conds>");
//    }
//}
