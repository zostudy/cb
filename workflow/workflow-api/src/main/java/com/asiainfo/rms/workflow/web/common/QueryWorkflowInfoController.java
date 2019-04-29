package com.asiainfo.rms.workflow.web.common;

import java.util.List;

import com.asiainfo.rms.workflow.dto.common.*;

import net.sf.json.JSONArray;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.asiainfo.rms.core.api.Page;

@RequestMapping(value="/queryInfo")
public interface QueryWorkflowInfoController {
	@RequestMapping(value="/getAlmWorkflowInfo" ,method=RequestMethod.GET)
	public List<AlmWorkflowDTO> getAlmWorkflowInfo(@RequestParam(value ="link_id", required=false) Long linkId,
										@RequestParam(value ="link_no", required=false) String linkNo,
										@RequestParam(value ="phase_id", required=false) String phaseId,
										@RequestParam(value ="process_key", required=false) String processKey)  throws Exception;
	
	@RequestMapping(value="/getlinkTimeConfigDTOInfo" ,method=RequestMethod.GET)
	public LinkTimeConfigDTO getlinkTimeConfigInfo(@RequestParam(value ="coding_type", required=false) String codingType,
										@RequestParam(value ="link_no", required=true) String linkNo)  throws Exception;
	
	@RequestMapping(value="/getWorkOrderInfo" ,method=RequestMethod.GET)
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
                                        @RequestParam(value = "page_size") Integer pageSize)  throws Exception;
	
	@RequestMapping(value="/getWorkOrderCount" ,method=RequestMethod.GET)
	public ExecuteResultDTO getWorkOrderCount(@RequestParam(value ="obj_type", required=false) String objType,
										@RequestParam(value ="exec_staff_id") Integer execStaffId,
										@RequestParam(value ="status", required=false) String status,
										@RequestParam(value ="order_type", required=false) String orderType)  throws Exception;
	
	@RequestMapping(value="/getWorkflowTemplate" ,method=RequestMethod.GET)
	public List<WorkflowTempateDTO> getWorkflowTemplate()  throws Exception;

	@RequestMapping(value="/getWoflowOrderInfo" ,method=RequestMethod.GET)
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
													 @RequestParam(value = "page_size") Integer pageSize)  throws Exception;

	@RequestMapping(value="/getWorkflowProcess" ,method=RequestMethod.GET)
	public JSONArray getWorkflowProcess(@RequestParam(value ="process_name", required=false) String processName)  throws Exception;
	
}
