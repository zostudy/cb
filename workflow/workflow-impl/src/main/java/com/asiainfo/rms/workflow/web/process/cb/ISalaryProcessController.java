package com.asiainfo.rms.workflow.web.process.cb;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.LaunchSalaryProcessDTO;
import com.asiainfo.rms.workflow.dto.process.cb.ExecuteSalaryProcessDTO;
import com.asiainfo.rms.workflow.dto.process.common.WorkOrderStakeholderDTO;

/**
 * 薪酬流程
 * 
 * @author joker
 */
@RequestMapping("/process/cb/salaryprocess")
public interface ISalaryProcessController {

	@PostMapping(value = "/sfo")
	public ExecuteResultDTO saveFirstOrder(@RequestBody LaunchSalaryProcessDTO launchSalaryProcessDTO) throws Exception;
	
	@PostMapping(value = "/create")
	public ExecuteResultDTO launchProcess(@RequestBody LaunchSalaryProcessDTO launchSalaryProcessDTO) throws Exception;

	@PostMapping(value = "/ws/create")
	public ExecuteResultDTO wsLaunchProcess(@RequestBody WorkOrderStakeholderDTO workOrderStakeholder) throws Exception;
	
	@PostMapping(value = "/spsalary")
	public ExecuteResultDTO sPSalary(@RequestBody ExecuteSalaryProcessDTO executeSalaryProcessDTO) throws Exception;

	@PostMapping(value = "/ws/spsalary")
	public ExecuteResultDTO wsSPSalary(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception;	
}