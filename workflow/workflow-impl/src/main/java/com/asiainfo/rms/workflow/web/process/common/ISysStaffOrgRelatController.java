package com.asiainfo.rms.workflow.web.process.common;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysStaffOrgRelatDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysStaffOrgRelatQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@RequestMapping("/process/common/sysstafforgrelat")
public interface ISysStaffOrgRelatController {

	@DeleteMapping(value = "/{staffOrgRelatId:\\d+}")
	public void deleteByPrimaryKey(@PathVariable java.lang.Long staffOrgRelatId) throws Exception;
	
	@PostMapping
	public ExecuteResultDTO save(@RequestBody SysStaffOrgRelatDTO sysStaffOrgRelatDTO) throws Exception;
	
	@GetMapping(value = "/{staffOrgRelatId:\\d+}")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable java.lang.Long staffOrgRelatId) throws Exception;
	
	@PutMapping
	public ExecuteResultDTO update(@RequestBody SysStaffOrgRelatDTO sysStaffOrgRelatDTO) throws Exception;
	
	@GetMapping
	public ExecuteResultDTO findByConds(SysStaffOrgRelatQueryPageDTO sysStaffOrgRelatQueryPageDTO) throws Exception;
	
}