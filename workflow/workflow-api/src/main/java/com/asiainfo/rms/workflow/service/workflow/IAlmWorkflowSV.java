package com.asiainfo.rms.workflow.service.workflow;

import java.util.List;

import com.asiainfo.rms.workflow.dto.common.WorkflowOrderDto;
import org.springframework.web.bind.annotation.RequestParam;

import com.asiainfo.rms.workflow.bo.workflow.LinkTimeConfigBO;
import com.asiainfo.rms.workflow.bo.workflow.WorkflowBO;
import com.asiainfo.rms.workflow.bo.workflow.WorkflowTempateBO;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.common.WorkorderListDTO;

public interface IAlmWorkflowSV {

	public WorkflowBO getWorkflowByLinkId(Long linkId)throws Exception;
	
	public WorkflowBO getWorkflowByLinkNo(String linkNo)throws Exception;
	
	public List<WorkflowBO> getWorkflowByLinkNoAndId(Long linkId,String linkNo,String phaseId,String processKey)throws Exception;
	
	public LinkTimeConfigBO getLinkTimeConfigLinkNoAndConfigType(String codingType,String linkNo)throws Exception;
	
	
	public int getWorkOrderCount(String objName, String objType,String linkNo,String submitStaffName,String resStaffName,
			String execStaffName,Integer execStaffId,Integer objId,String status,String orderType,String orderCreateDateStart,String orderCreateDateEnd,
			String objSubmitDateStart,String objSubmitDateEnd,String objReceiveDateStart,String objReceiveDateEnd,Integer orderId,String objTag)throws Exception;
	
	
	public List<WorkorderListDTO> getWorkOrderInfo(String objName, String objType,String linkNo,String submitStaffName,String resStaffName,
			String execStaffName,Integer execStaffId,Integer objId,String status,String orderType,String orderCreateDateStart,String orderCreateDateEnd,
			String objSubmitDateStart,String objSubmitDateEnd,String objReceiveDateStart,String objReceiveDateEnd,Integer orderId,String objTag,
            Integer pageNo,Integer pageSize)throws Exception;
	
	public List<WorkflowTempateBO> getWorkflowTemplate()throws Exception;
	
	public boolean checkVpReqExitOther(int objId,String status,String linkIds)throws Exception;

	public int getWoflowOrderCount(String objName, String objType,String linkNo,String submitStaffName,String resStaffName,
								 String execStaffName,Integer execStaffId,Integer objId,String status,String orderType,String orderCreateDateStart,String orderCreateDateEnd,
								 String objSubmitDateStart,String objSubmitDateEnd,String objReceiveDateStart,String objReceiveDateEnd,Integer orderId,String objTag)throws Exception;

	public List<WorkflowOrderDto> getWoflowOrderInfo(String objName, String objType, String linkNo, String submitStaffName, String resStaffName,
													 String execStaffName, Integer execStaffId, Integer objId, String status, String orderType, String orderCreateDateStart, String orderCreateDateEnd,
													 String objSubmitDateStart, String objSubmitDateEnd, String objReceiveDateStart, String objReceiveDateEnd, Integer orderId, String objTag,
													 Integer pageNo, Integer pageSize)throws Exception;
	
}
