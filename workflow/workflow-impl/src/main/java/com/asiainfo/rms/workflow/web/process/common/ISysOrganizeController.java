package com.asiainfo.rms.workflow.web.process.common;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysOrganizeDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysOrganizeQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@RequestMapping("/process/common/sysorganize")
public interface ISysOrganizeController {

	@DeleteMapping(value = "/{organizeId:\\d+}")
	public void deleteByPrimaryKey(@PathVariable java.lang.Long organizeId) throws Exception;
	
	@PostMapping
	public ExecuteResultDTO save(@RequestBody SysOrganizeDTO sysOrganizeDTO) throws Exception;
	
	@GetMapping(value = "/{organizeId:\\d+}")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable java.lang.Long organizeId) throws Exception;
	
	@PutMapping
	public ExecuteResultDTO update(@RequestBody SysOrganizeDTO sysOrganizeDTO) throws Exception;
	
	@GetMapping
	public ExecuteResultDTO findByConds(SysOrganizeQueryPageDTO sysOrganizeQueryPageDTO) throws Exception;
	
}