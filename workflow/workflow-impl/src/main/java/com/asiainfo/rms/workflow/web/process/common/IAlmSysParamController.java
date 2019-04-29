package com.asiainfo.rms.workflow.web.process.common;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.AlmSysParamDTO;
import com.asiainfo.rms.workflow.dto.process.common.AlmSysParamQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@RequestMapping("/process/common/almsysparam")
public interface IAlmSysParamController {

	@DeleteMapping(value = "/{paramId:\\d+}")
	public void deleteByPrimaryKey(@PathVariable java.lang.Long paramId) throws Exception;
	
	@PostMapping
	public ExecuteResultDTO save(@RequestBody AlmSysParamDTO almSysParamDTO) throws Exception;
	
	@GetMapping(value = "/{paramId:\\d+}")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable java.lang.Long paramId) throws Exception;
	
	@PutMapping
	public ExecuteResultDTO update(@RequestBody AlmSysParamDTO almSysParamDTO) throws Exception;
	
	@GetMapping
	public ExecuteResultDTO findByConds(AlmSysParamQueryPageDTO almSysParamQueryPageDTO) throws Exception;
	
}