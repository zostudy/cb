package com.asiainfo.rms.workflow.web.process.cb;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.LaunchThermoCompressorProcessDTO;
import com.asiainfo.rms.workflow.dto.process.cb.ExecuteThermoCompressorProcessDTO;
import com.asiainfo.rms.workflow.dto.process.common.WorkOrderStakeholderDTO;

/**
 * 热压机流程
 * 
 * @author joker
 */
@RequestMapping("/process/cb/thermocompressorprocess")
public interface IThermoCompressorProcessController {

	@PostMapping(value = "/sfo")
	public ExecuteResultDTO saveFirstOrder(@RequestBody LaunchThermoCompressorProcessDTO launchThermoCompressorProcessDTO) throws Exception;
	
	@PostMapping(value = "/create")
	public ExecuteResultDTO launchProcess(@RequestBody LaunchThermoCompressorProcessDTO launchThermoCompressorProcessDTO) throws Exception;

	@PostMapping(value = "/ws/create")
	public ExecuteResultDTO wsLaunchProcess(@RequestBody WorkOrderStakeholderDTO workOrderStakeholder) throws Exception;
	
	@PostMapping(value = "/tcpthermocompressor")
	public ExecuteResultDTO tCPThermoCompressor(@RequestBody ExecuteThermoCompressorProcessDTO executeThermoCompressorProcessDTO) throws Exception;

	@PostMapping(value = "/ws/tcpthermocompressor")
	public ExecuteResultDTO wsTCPThermoCompressor(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception;	
	
	@PostMapping(value = "/tcpdestiny")
	public ExecuteResultDTO tCPDestiny(@RequestBody ExecuteThermoCompressorProcessDTO executeThermoCompressorProcessDTO) throws Exception;

	@PostMapping(value = "/ws/tcpdestiny")
	public ExecuteResultDTO wsTCPDestiny(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception;	
	
	@PostMapping(value = "/tcpreduceboard")
	public ExecuteResultDTO tCPReduceBoard(@RequestBody ExecuteThermoCompressorProcessDTO executeThermoCompressorProcessDTO) throws Exception;

	@PostMapping(value = "/ws/tcpreduceboard")
	public ExecuteResultDTO wsTCPReduceBoard(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception;	
	
	@PostMapping(value = "/tcpaddboard")
	public ExecuteResultDTO tCPAddBoard(@RequestBody ExecuteThermoCompressorProcessDTO executeThermoCompressorProcessDTO) throws Exception;

	@PostMapping(value = "/ws/tcpaddboard")
	public ExecuteResultDTO wsTCPAddBoard(@RequestBody WorkOrderStakeholderDTO workOrderStakeholderDTO) throws Exception;	
}