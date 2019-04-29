//package com.asiainfo.rms.workflow.activiti;
//
//
//import org.activiti.engine.RepositoryService;
//import org.activiti.engine.RuntimeService;
//import org.activiti.engine.TaskService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by liuchao on 2017/7/13.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//public class TestProcess {
//
//    @Autowired
//    private RepositoryService repositoryService;
//
//    @Autowired
//    private RuntimeService runtimeService;
//
//    @Autowired
//    private TaskService taskService;
//
//    @Test
//    public void createWorkflow(){
//        runtimeService.startProcessInstanceByKey("TestProcess");
//    }
//
//    @Test
//    public void finishTask(){
//        taskService.complete("10002");
//    }
//}
