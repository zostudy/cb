package com.asiainfo.rms.workflow.web.process.common;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFineFlowDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFlowDTO;

@RequestMapping("/process/common/base")
public interface IProcessController {

	@GetMapping(value = "/{processInstanceId:\\d+}")
	public Map getViewByProcessInstanceId(@PathVariable java.lang.Long processInstanceId, HttpServletResponse response) throws Exception;
	
	@PostMapping(value = "/computer/salary")
	public ExecuteResultDTO getComputerSalary(@RequestBody AlmCbFlowDTO[] almCbFlowDTOs);
	
	@PostMapping(value = "/computer/salary/again")
	public ExecuteResultDTO getComputerSalaryAgian(@RequestBody AlmCbFineFlowDTO[] almCbFineFlowDTOs);
}
