package com.asiainfo.rms.workflow.web.process.cb;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbThermoCompressorDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbThermoCompressorQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@RequestMapping("/process/cb/almcbthermocompressor")
public interface IAlmCbThermoCompressorController {

	@DeleteMapping(value = "/{tcId:\\d+}")
	public void deleteByPrimaryKey(@PathVariable Long tcId) throws Exception;
	
	@PostMapping
	public ExecuteResultDTO save(@RequestBody AlmCbThermoCompressorDTO almCbThermoCompressorDTO) throws Exception;
	
	@GetMapping(value = "/{tcId:\\d+}")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable Long tcId) throws Exception;
	
	@PutMapping
	public ExecuteResultDTO update(@RequestBody AlmCbThermoCompressorDTO almCbThermoCompressorDTO) throws Exception;
	
	@GetMapping
	public ExecuteResultDTO findByConds(AlmCbThermoCompressorQueryPageDTO almCbThermoCompressorQueryPageDTO) throws Exception;
	
}