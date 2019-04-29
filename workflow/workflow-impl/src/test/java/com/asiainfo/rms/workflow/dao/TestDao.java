//package com.asiainfo.rms.workflow.dao;
//
//import com.asiainfo.rms.workflow.dto.req.BOAlmRequisition;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//
//import javax.transaction.Transactional;
//import java.util.Date;
//
///**
// * Created by liuchao on 2017/7/14.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
////@TransactionConfiguration(defaultRollback=false)
//public class TestDao {
//
//    @Autowired
//    private CommonDAO dao;
//
//    @Test
//    @Transactional(value = Transactional.TxType.REQUIRED,rollbackOn = Exception.class)
//    public void testSave() throws Exception{
//        BOAlmRequisition req = new BOAlmRequisition();
//        req.setCreateTime(new Date());
//        req.setCurPhase(1);
//        req.setCurStatus(1);
//        req.setPlanTime(new Date());
//        req.setReqName("测试");
//        req.setReqTag("REQ20170714XXXX");
//
//        dao.save(req);
//    }
//
//    @Test
//    public void testQueryData(){
//       BOAlmRequisition req = dao.findById(BOAlmRequisition.class,3);
//       Assert.assertEquals("测试",req.getReqName());
//    }
//
//}
