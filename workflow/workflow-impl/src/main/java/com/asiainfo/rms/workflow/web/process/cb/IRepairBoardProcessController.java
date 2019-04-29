package com.asiainfo.rms.workflow.web.process.cb;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.LaunchRepairBoardProcessDTO;
import com.asiainfo.rms.workflow.dto.process.cb.ExecuteRepairBoardProcessDTO;
import com.asiainfo.rms.workflow.dto.process.common.WorkOrderStakeholderDTO;

/**
 * 修板流程
 * 
 * @author joker
 */
@RequestMapping("/process/cb/repairboardprocess")
public interface IRepairBoardProcessController {

	@PostMapping(value = "/sfo")
	public ExecuteResultDTO saveFirstOrder(@RequestBody LaunchRepairBoardProcessDTO launchRepairBoardProcessDTO) throws Exception;
	
	@PostMapping(value = "/create")
	public ExecuteResultDTO launchProcess(@RequestBody LaunchRepairBoardProcessDTO launchRepairBoardProcessDTO) throws Exception;

	@PostMapping(value = "/ws/create")
	public ExecuteResultDTO wsLaunchProcess(@RequestBody WorkOrderStakeholderDTO workOrderStakeholder) throws Exception;
	
	@PostMapping(value = "/rbprepairboard")
	public ExecuteResultDTO rBPRepairBoard(@RequestBody ExecuteRepairBoardProcessDTO executeRepairBoardProcessDTO) throws Exception;

	@PostMapping(value = "/ws/rbprepairboard")
	public ExecuteResultDTO wsRBPRepairBoard(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception;	
	
	@PostMapping(value = "/rbpdestiny")
	public ExecuteResultDTO rBPDestiny(@RequestBody ExecuteRepairBoardProcessDTO executeRepairBoardProcessDTO) throws Exception;

	@PostMapping(value = "/ws/rbpdestiny")
	public ExecuteResultDTO wsRBPDestiny(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception;	
	
	@PostMapping(value = "/rbpreduceboard")
	public ExecuteResultDTO rBPReduceBoard(@RequestBody ExecuteRepairBoardProcessDTO executeRepairBoardProcessDTO) throws Exception;

	@PostMapping(value = "/ws/rbpreduceboard")
	public ExecuteResultDTO wsRBPReduceBoard(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception;	
}