package com.asiainfo.rms.workflow.web.process.common;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysStationDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysStationQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@RequestMapping("/process/common/sysstation")
public interface ISysStationController {

	@DeleteMapping(value = "/{stationId:\\d+}")
	public void deleteByPrimaryKey(@PathVariable java.lang.Long stationId) throws Exception;
	
	@PostMapping
	public ExecuteResultDTO save(@RequestBody SysStationDTO sysStationDTO) throws Exception;
	
	@GetMapping(value = "/{stationId:\\d+}")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable java.lang.Long stationId) throws Exception;
	
	@PutMapping
	public ExecuteResultDTO update(@RequestBody SysStationDTO sysStationDTO) throws Exception;
	
	@GetMapping
	public ExecuteResultDTO findByConds(SysStationQueryPageDTO sysStationQueryPageDTO) throws Exception;
	
}