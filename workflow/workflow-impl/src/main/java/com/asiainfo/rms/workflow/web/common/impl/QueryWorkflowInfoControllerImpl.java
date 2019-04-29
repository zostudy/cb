package com.asiainfo.rms.workflow.web.common.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asiainfo.rms.workflow.dto.common.*;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.ExclusiveGateway;
import org.activiti.bpmn.model.ParallelGateway;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.impl.util.io.ResourceStreamSource;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.workflow.LinkTimeConfigBO;
import com.asiainfo.rms.workflow.bo.workflow.WorkflowBO;
import com.asiainfo.rms.workflow.bo.workflow.WorkflowTempateBO;
import com.asiainfo.rms.workflow.mapper.workflow.LinkTimeConfigMapper;
import com.asiainfo.rms.workflow.mapper.workflow.WorkflowMapper;
import com.asiainfo.rms.workflow.mapper.workflow.WorkflowTempateMapper;
import com.asiainfo.rms.workflow.service.workflow.IAlmWorkflowSV;
import com.asiainfo.rms.workflow.web.common.QueryWorkflowInfoController;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONArray;

@RestController
public class QueryWorkflowInfoControllerImpl implements QueryWorkflowInfoController {

	@Autowired
	IAlmWorkflowSV almWorkflowSV; 
	
	@Autowired
    ObjectMapper objectMapper;
	
	@Override
	public List<AlmWorkflowDTO> getAlmWorkflowInfo(@RequestParam(value ="link_id", required=false) Long linkId,
			@RequestParam(value ="link_no", required=false) String linkNo,
			@RequestParam(value ="phase_id", required=false) String phaseId,
			@RequestParam(value ="process_key", required=false) String processKey)  throws Exception {
		List<WorkflowBO> workflowBO = almWorkflowSV.getWorkflowByLinkNoAndId(linkId, linkNo,phaseId,processKey);
		return WorkflowMapper.INSTANCE.BOTODTOList(workflowBO);
	}
	@Override
	public LinkTimeConfigDTO getlinkTimeConfigInfo(@RequestParam(value ="coding_type", required=false) String codingType,
			@RequestParam(value ="link_no", required=true) String linkNo)  throws Exception {
		LinkTimeConfigBO linkTimeConfigBO = almWorkflowSV.getLinkTimeConfigLinkNoAndConfigType(codingType, linkNo);
		return LinkTimeConfigMapper.INSTANCE.boToDTO(linkTimeConfigBO);
	}
	
	public Page<WorkorderListDTO> getWorkOrderInfo(@RequestParam(value ="obj_name", required=false) String objName,
			@RequestParam(value ="obj_type", required=false) String objType,
			@RequestParam(value ="link_no", required=false) String linkNo,
			@RequestParam(value ="submit_staff_name", required=false) String submitStaffName,
			@RequestParam(value ="res_staff_name", required=false) String resStaffName,
			@RequestParam(value ="exec_staff_name", required=false) String execStaffName,
			@RequestParam(value ="exec_staff_id", required=false) Integer execStaffId,
			@RequestParam(value ="obj_id", required=false) Integer objId,
			@RequestParam(value ="status", required=false) String status,
			@RequestParam(value ="order_type", required=false) String orderType,
			@RequestParam(value ="order_create_date_start", required=false) String orderCreateDateStart,
			@RequestParam(value ="order_create_dateend", required=false) String orderCreateDateEnd,
			@RequestParam(value ="obj_submit_date_start", required=false) String objSubmitDateStart,
			@RequestParam(value ="obj_submit_date_end", required=false) String objSubmitDateEnd,
			@RequestParam(value ="obj_receive_date_start", required=false) String objReceiveDateStart,
			@RequestParam(value ="obj_receive_date_end", required=false) String objReceiveDateEnd,
			@RequestParam(value ="order_id", required=false) Integer orderId,
			@RequestParam(value ="obj_tag", required=false) String objTag,
            @RequestParam(value = "page_no") Integer pageNo,
            @RequestParam(value = "page_size") Integer pageSize) throws Exception {
		Page<WorkorderListDTO> page = new Page<>();
        int cnt = almWorkflowSV.getWorkOrderCount(objName,objType,linkNo,submitStaffName,resStaffName,execStaffName,execStaffId,objId,status,orderType,orderCreateDateStart,
        		orderCreateDateEnd,objSubmitDateStart,objSubmitDateEnd,objReceiveDateStart,objReceiveDateEnd,orderId,objTag);
        if (cnt == 0) {
            return page;
        }
        List<WorkorderListDTO> items = almWorkflowSV.getWorkOrderInfo(objName,objType,linkNo,submitStaffName,resStaffName,execStaffName,execStaffId,objId,status,orderType,orderCreateDateStart,
        		orderCreateDateEnd,objSubmitDateStart,objSubmitDateEnd,objReceiveDateStart,objReceiveDateEnd, orderId,objTag,pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
	}
	
	@SuppressWarnings("unchecked")
	public ExecuteResultDTO getWorkOrderCount(@RequestParam(value ="obj_type", required=false) String objType,
			@RequestParam(value ="exec_staff_id") Integer execStaffId,
			@RequestParam(value ="status", required=false) String status,
			@RequestParam(value ="order_type", required=false) String orderType)  throws Exception{
		ExecuteResultDTO result = new ExecuteResultDTO();
		@SuppressWarnings("rawtypes")
		Map objMap = new HashMap();
		if(null!=status && !"".equals(status)){
			int cnt = almWorkflowSV.getWorkOrderCount(null,objType,null,null,null,null,execStaffId,null,status,orderType,null,
	        		null,null,null,null,null,null,null);
			result.setObj(cnt);
		}else{
			int completedCnt = almWorkflowSV.getWorkOrderCount(null,objType,null,null,null,null,execStaffId,null,"3",orderType,null,
	        		null,null,null,null,null,null,null);
			int orderCnt = almWorkflowSV.getWorkOrderCount(null,objType,null,null,null,null,execStaffId,null,"2",orderType,null,
	        		null,null,null,null,null,null,null);
			objMap.put("completed_cnt", completedCnt);
			objMap.put("order_cnt", orderCnt);
			result.setObj(objMap);
		}
        result.setCode(1);
		result.setMsg("success");
        return result;
	}
	
	
	@Override
	public List<WorkflowTempateDTO> getWorkflowTemplate() throws Exception {
		List<WorkflowTempateBO> WorkflowTempate = almWorkflowSV.getWorkflowTemplate();
		return WorkflowTempateMapper.INSTANCE.BOTODTOList(WorkflowTempate);
	}
	

	public Page<WorkflowOrderDto> getWoflowOrderInfo(@RequestParam(value ="obj_name", required=false) String objName,
												   @RequestParam(value ="obj_type", required=false) String objType,
												   @RequestParam(value ="link_no", required=false) String linkNo,
												   @RequestParam(value ="submit_staff_name", required=false) String submitStaffName,
												   @RequestParam(value ="res_staff_name", required=false) String resStaffName,
												   @RequestParam(value ="exec_staff_name", required=false) String execStaffName,
												   @RequestParam(value ="exec_staff_id", required=false) Integer execStaffId,
												   @RequestParam(value ="obj_id", required=false) Integer objId,
												   @RequestParam(value ="status", required=false) String status,
												   @RequestParam(value ="order_type", required=false) String orderType,
												   @RequestParam(value ="order_create_date_start", required=false) String orderCreateDateStart,
												   @RequestParam(value ="order_create_dateend", required=false) String orderCreateDateEnd,
												   @RequestParam(value ="obj_submit_date_start", required=false) String objSubmitDateStart,
												   @RequestParam(value ="obj_submit_date_end", required=false) String objSubmitDateEnd,
												   @RequestParam(value ="obj_receive_date_start", required=false) String objReceiveDateStart,
												   @RequestParam(value ="obj_receive_date_end", required=false) String objReceiveDateEnd,
												   @RequestParam(value ="order_id", required=false) Integer orderId,
												   @RequestParam(value ="obj_tag", required=false) String objTag,
												   @RequestParam(value = "page_no") Integer pageNo,
												   @RequestParam(value = "page_size") Integer pageSize) throws Exception {
		Page<WorkflowOrderDto> page = new Page<>();
		int cnt = almWorkflowSV.getWoflowOrderCount(objName,objType,linkNo,submitStaffName,resStaffName,execStaffName,execStaffId,objId,status,orderType,orderCreateDateStart,
				orderCreateDateEnd,objSubmitDateStart,objSubmitDateEnd,objReceiveDateStart,objReceiveDateEnd,orderId,objTag);
		if (cnt == 0) {
			return page;
		}
		List<WorkflowOrderDto> items = almWorkflowSV.getWoflowOrderInfo(objName,objType,linkNo,submitStaffName,resStaffName,execStaffName,execStaffId,objId,status,orderType,orderCreateDateStart,
				orderCreateDateEnd,objSubmitDateStart,objSubmitDateEnd,objReceiveDateStart,objReceiveDateEnd, orderId,objTag,pageNo, pageSize);
		if (CollectionUtils.isEmpty(items)) {
			return page;
		}
		page.setRowCount(cnt);
		page.generatePageCount(pageSize);
		page.setPageData(items);
		return page;
	}
	
	@Override
	public JSONArray getWorkflowProcess(@RequestParam(value ="process_name", required=false) String processName) throws Exception {
		ResourceStreamSource resourceStreamSource = new ResourceStreamSource("processes/"+processName+".bpmn");
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		BpmnXMLConverter bpmnXMLConverter = new BpmnXMLConverter();
		BpmnModel bpmnModel = bpmnXMLConverter.convertToBpmnModel(resourceStreamSource, true, true);
		for (String key : bpmnModel.getLocationMap().keySet()) {
			resultMap = new HashMap<String, Object>();
			if (bpmnModel.getFlowElement(key) instanceof ExclusiveGateway) {
				ExclusiveGateway exclusiveGateway = (ExclusiveGateway) bpmnModel.getFlowElement(key);
				List<SequenceFlow> incomingFlows = exclusiveGateway.getIncomingFlows();
				List<SequenceFlow> outgoingFlows = exclusiveGateway.getOutgoingFlows();
				resultMap.put("id", exclusiveGateway.getId());
				resultMap.put("name", exclusiveGateway.getName());
				resultMap.put("type", "Gateway");
				List<String> incomingFlowsList = new ArrayList<String>();
				for (SequenceFlow sequenceFlow : incomingFlows) {
					incomingFlowsList.add(sequenceFlow.getSourceRef());
				}
				resultMap.put("incomingFlows", incomingFlowsList);
				List<String> outgoingFlowsList = new ArrayList<String>();
				for (SequenceFlow sequenceFlow : outgoingFlows) {
					outgoingFlowsList.add(sequenceFlow.getTargetRef());
				}
				resultMap.put("outgoingFlows", outgoingFlowsList);
			} else if (bpmnModel.getFlowElement(key) instanceof ParallelGateway) {
				ExclusiveGateway parallelGateway = (ExclusiveGateway) bpmnModel.getFlowElement(key);
				List<SequenceFlow> incomingFlows = parallelGateway.getIncomingFlows();
				List<SequenceFlow> outgoingFlows = parallelGateway.getOutgoingFlows();
				resultMap.put("id", parallelGateway.getId());
				resultMap.put("name", parallelGateway.getName());
				resultMap.put("type", "Gateway");
				List<String> incomingFlowsList = new ArrayList<String>();
				for (SequenceFlow sequenceFlow : incomingFlows) {
					incomingFlowsList.add(sequenceFlow.getSourceRef());
				}
				resultMap.put("incomingFlows", incomingFlowsList);
				List<String> outgoingFlowsList = new ArrayList<String>();
				for (SequenceFlow sequenceFlow : outgoingFlows) {
					outgoingFlowsList.add(sequenceFlow.getTargetRef());
				}
				resultMap.put("outgoingFlows", outgoingFlowsList);
			} else if (bpmnModel.getFlowElement(key) instanceof UserTask){
				UserTask userTask = (UserTask) bpmnModel.getFlowElement(key);
				List<SequenceFlow> incomingFlows = userTask.getIncomingFlows();
				List<SequenceFlow> outgoingFlows = userTask.getOutgoingFlows();
				resultMap.put("id", userTask.getId());
				resultMap.put("name", userTask.getName());
				resultMap.put("type", "UserTask");
				List<String> incomingFlowsList = new ArrayList<String>();
				for (SequenceFlow sequenceFlow : incomingFlows) {
					incomingFlowsList.add(sequenceFlow.getSourceRef());
				}
				resultMap.put("incomingFlows", incomingFlowsList);
				List<String> outgoingFlowsList = new ArrayList<String>();
				for (SequenceFlow sequenceFlow : outgoingFlows) {
					outgoingFlowsList.add(sequenceFlow.getTargetRef());
				}
				resultMap.put("outgoingFlows", outgoingFlowsList);
			} else if (bpmnModel.getFlowElement(key) instanceof StartEvent){
				StartEvent startEvent = (StartEvent) bpmnModel.getFlowElement(key);
				List<SequenceFlow> incomingFlows = startEvent.getIncomingFlows();
				List<SequenceFlow> outgoingFlows = startEvent.getOutgoingFlows();
				resultMap.put("id", startEvent.getId());
				resultMap.put("name", startEvent.getName());
				resultMap.put("type", "StartEvent");
				List<String> incomingFlowsList = new ArrayList<String>();
				for (SequenceFlow sequenceFlow : incomingFlows) {
					incomingFlowsList.add(sequenceFlow.getSourceRef());
				}
				resultMap.put("incomingFlows", incomingFlowsList);
				List<String> outgoingFlowsList = new ArrayList<String>();
				for (SequenceFlow sequenceFlow : outgoingFlows) {
					outgoingFlowsList.add(sequenceFlow.getTargetRef());
				}
				resultMap.put("outgoingFlows", outgoingFlowsList);
			} else if (bpmnModel.getFlowElement(key) instanceof EndEvent){
				EndEvent endEvent = (EndEvent) bpmnModel.getFlowElement(key);
				List<SequenceFlow> incomingFlows = endEvent.getIncomingFlows();
				List<SequenceFlow> outgoingFlows = endEvent.getOutgoingFlows();
				resultMap.put("id", endEvent.getId());
				resultMap.put("name", endEvent.getName());
				resultMap.put("type", "EndEvent");
				List<String> incomingFlowsList = new ArrayList<String>();
				for (SequenceFlow sequenceFlow : incomingFlows) {
					incomingFlowsList.add(sequenceFlow.getSourceRef());
				}
				resultMap.put("incomingFlows", incomingFlowsList);
				List<String> outgoingFlowsList = new ArrayList<String>();
				for (SequenceFlow sequenceFlow : outgoingFlows) {
					outgoingFlowsList.add(sequenceFlow.getTargetRef());
				}
				resultMap.put("outgoingFlows", outgoingFlowsList);
			} else {
				System.out.println(objectMapper.writeValueAsString(bpmnModel.getFlowElement(key)));
			}
			resultList.add(resultMap);
		}
		return JSONArray.fromObject(objectMapper.writeValueAsString(resultList));
	}

}
