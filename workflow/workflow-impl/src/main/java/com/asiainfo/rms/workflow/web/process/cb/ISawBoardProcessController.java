package com.asiainfo.rms.workflow.web.process.cb;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.LaunchSawBoardProcessDTO;
import com.asiainfo.rms.workflow.dto.process.cb.ExecuteSawBoardProcessDTO;
import com.asiainfo.rms.workflow.dto.process.common.WorkOrderStakeholderDTO;

/**
 * 锯板流程
 * 
 * @author joker
 */
@RequestMapping("/process/cb/sawboardprocess")
public interface ISawBoardProcessController {

	@PostMapping(value = "/sfo")
	public ExecuteResultDTO saveFirstOrder(@RequestBody LaunchSawBoardProcessDTO launchSawBoardProcessDTO) throws Exception;
	
	@PostMapping(value = "/create")
	public ExecuteResultDTO launchProcess(@RequestBody LaunchSawBoardProcessDTO launchSawBoardProcessDTO) throws Exception;

	@PostMapping(value = "/ws/create")
	public ExecuteResultDTO wsLaunchProcess(@RequestBody WorkOrderStakeholderDTO workOrderStakeholder) throws Exception;
	
	@PostMapping(value = "/sbpsawboard")
	public ExecuteResultDTO sBPSawBoard(@RequestBody ExecuteSawBoardProcessDTO executeSawBoardProcessDTO) throws Exception;

	@PostMapping(value = "/ws/sbpsawboard")
	public ExecuteResultDTO wsSBPSawBoard(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception;	
	
	@PostMapping(value = "/sbpdestiny")
	public ExecuteResultDTO sBPDestiny(@RequestBody ExecuteSawBoardProcessDTO executeSawBoardProcessDTO) throws Exception;

	@PostMapping(value = "/ws/sbpdestiny")
	public ExecuteResultDTO wsSBPDestiny(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception;	
	
	@PostMapping(value = "/sbpreduceboard")
	public ExecuteResultDTO sBPReduceBoard(@RequestBody ExecuteSawBoardProcessDTO executeSawBoardProcessDTO) throws Exception;

	@PostMapping(value = "/ws/sbpreduceboard")
	public ExecuteResultDTO wsSBPReduceBoard(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception;	
}