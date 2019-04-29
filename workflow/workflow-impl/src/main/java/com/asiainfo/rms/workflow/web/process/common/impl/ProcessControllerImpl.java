package com.asiainfo.rms.workflow.web.process.common.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFineFlowDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFlowDTO;
import com.asiainfo.rms.workflow.service.process.common.IAlmWorkorderListService;
import com.asiainfo.rms.workflow.util.ComputerSalaryUtils;
import com.asiainfo.rms.workflow.web.process.common.IProcessController;

import ch.qos.logback.core.recovery.ResilientFileOutputStream;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import sun.misc.BASE64Encoder;

@Data
@Transactional
@RestController
@AllArgsConstructor
@RequiredArgsConstructor
@Api(value = "增删改查操作接口(流程无关)")
public class ProcessControllerImpl implements IProcessController {
	
	@Autowired
    RepositoryService repositoryService;
    @Autowired
    ManagementService managementService;
    @Autowired
    protected RuntimeService runtimeService;
    @Autowired
    ProcessEngineConfiguration processEngineConfiguration;
    @Autowired
    ProcessEngineFactoryBean processEngine;
    @Autowired
    HistoryService historyService;
    @Autowired
    TaskService taskService;
    @Autowired
    ComputerSalaryUtils computerSalaryUtils;

    /**
     * 读取带跟踪的图片
     */
    @Override
    @ResponseBody
 	@ApiOperation(value = "依据主键查询流程图")
    public Map getViewByProcessInstanceId(@PathVariable java.lang.Long processInstanceId, HttpServletResponse response) throws Exception {
        //获取历史流程实例
        HistoricProcessInstance processInstance =  historyService.createHistoricProcessInstanceQuery().processInstanceId(String.valueOf(processInstanceId)).singleResult();
        //获取流程图
        BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
        processEngineConfiguration = processEngine.getProcessEngineConfiguration();
        Context.setProcessEngineConfiguration((ProcessEngineConfigurationImpl) processEngineConfiguration);

        ProcessDiagramGenerator diagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
        ProcessDefinitionEntity definitionEntity = (ProcessDefinitionEntity)repositoryService.getProcessDefinition(processInstance.getProcessDefinitionId());

        List<HistoricActivityInstance> highLightedActivitList =  historyService.createHistoricActivityInstanceQuery().processInstanceId(String.valueOf(processInstanceId)).list();
        //高亮环节id集合
        List<String> highLightedActivitis = new ArrayList<String>();
        //高亮线路id集合
        List<String> highLightedFlows = getHighLightedFlows(definitionEntity,highLightedActivitList);

        for(HistoricActivityInstance tempActivity : highLightedActivitList){
            String activityId = tempActivity.getActivityId();
            highLightedActivitis.add(activityId);
        }

        //中文显示的是口口口，设置字体就好了
        InputStream imageStream = diagramGenerator.generateDiagram(bpmnModel, "jpeg", highLightedActivitis,highLightedFlows,"宋体","宋体",null,1.0);
        //单独返回流程图，不高亮显示
//        InputStream imageStream = diagramGenerator.generatePngDiagram(bpmnModel);
        // 输出资源内容到相应对象
        byte[] data = null;
        try {
            data = new byte[imageStream.available()];
            imageStream.read(data);
            imageStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BASE64Encoder encoder = new BASE64Encoder();

        Map<String, Serializable> imgMap = new HashMap<>();

        imgMap.put("code", 1);
        imgMap.put("img", encoder.encode(data));

        return imgMap;
    }
    

    /**
     * 获取需要高亮的线
     * @param processDefinitionEntity
     * @param historicActivityInstances
     * @return
     */
    private List<String> getHighLightedFlows(
            ProcessDefinitionEntity processDefinitionEntity,
            List<HistoricActivityInstance> historicActivityInstances) {
        List<String> highFlows = new ArrayList<String>();// 用以保存高亮的线flowId
        for (int i = 0; i < historicActivityInstances.size() - 1; i++) {// 对历史流程节点进行遍历
            ActivityImpl activityImpl = processDefinitionEntity
                    .findActivity(historicActivityInstances.get(i)
                            .getActivityId());// 得到节点定义的详细信息
            List<ActivityImpl> sameStartTimeNodes = new ArrayList<ActivityImpl>();// 用以保存后需开始时间相同的节点
            ActivityImpl sameActivityImpl1 = processDefinitionEntity
                    .findActivity(historicActivityInstances.get(i + 1)
                            .getActivityId());
            // 将后面第一个节点放在时间相同节点的集合里
            sameStartTimeNodes.add(sameActivityImpl1);
            for (int j = i + 1; j < historicActivityInstances.size() - 1; j++) {
                HistoricActivityInstance activityImpl1 = historicActivityInstances
                        .get(j);// 后续第一个节点
                HistoricActivityInstance activityImpl2 = historicActivityInstances
                        .get(j + 1);// 后续第二个节点
                if (activityImpl1.getStartTime().equals(
                        activityImpl2.getStartTime())) {
                    // 如果第一个节点和第二个节点开始时间相同保存
                    ActivityImpl sameActivityImpl2 = processDefinitionEntity
                            .findActivity(activityImpl2.getActivityId());
                    sameStartTimeNodes.add(sameActivityImpl2);
                } else {
                    // 有不相同跳出循环
                    break;
                }
            }
            List<PvmTransition> pvmTransitions = activityImpl
                    .getOutgoingTransitions();// 取出节点的所有出去的线
            for (PvmTransition pvmTransition : pvmTransitions) {
                // 对所有的线进行遍历
                ActivityImpl pvmActivityImpl = (ActivityImpl) pvmTransition
                        .getDestination();
                // 如果取出的线的目标节点存在时间相同的节点里，保存该线的id，进行高亮显示
                if (sameStartTimeNodes.contains(pvmActivityImpl)) {
                    highFlows.add(pvmTransition.getId());
                }
            }
        }
        return highFlows;
    }


	@Override
	@ApiOperation(value = "计算薪资")
	public ExecuteResultDTO getComputerSalary(@RequestBody AlmCbFlowDTO[] almCbFlowDTOs) {
		ExecuteResultDTO reslut = new ExecuteResultDTO();
		Page<AlmCbFlowDTO> page= new Page<AlmCbFlowDTO>();
		List<AlmCbFlowDTO> list = null;
		try {
			list = computerSalaryUtils.computer(almCbFlowDTOs);
			page.setPageCount(list.size());
			page.setPageData(list);
			reslut.setObj(page);
			reslut.setCode(1);
		} catch(Exception e) {
			page.setPageCount(0);
			reslut.setObj(page);
			reslut.setCode(0);
			reslut.setMsg(e.getMessage());;
		}
		return reslut;
	}


	@Override
	@ApiOperation(value = "计算罚单")
	public ExecuteResultDTO getComputerSalaryAgian(@RequestBody AlmCbFineFlowDTO[] almCbFineFlowDTOs) {
		ExecuteResultDTO reslut = new ExecuteResultDTO();
		Page<AlmCbFineFlowDTO> page= new Page<AlmCbFineFlowDTO>();
		List<AlmCbFineFlowDTO> list = null;
		try {
			list = computerSalaryUtils.computerFine(almCbFineFlowDTOs);
			page.setPageCount(list.size());
			page.setPageData(list);
			reslut.setObj(page);
			reslut.setCode(1);
		} catch(Exception e) {
			page.setPageCount(0);
			reslut.setObj(page);
			reslut.setCode(0);
			reslut.setMsg(e.getMessage());;
		}
		return reslut;
	}

}
