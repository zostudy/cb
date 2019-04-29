package com.asiainfo.rms.workflow.web.process.common;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysOrgPrivateDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysOrgPrivateQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@RequestMapping("/process/common/sysorgprivate")
public interface ISysOrgPrivateController {

	@DeleteMapping(value = "/{staffId:\\d+}")
	public void deleteByPrimaryKey(@PathVariable java.lang.Long staffId) throws Exception;
	
	@PostMapping
	public ExecuteResultDTO save(@RequestBody SysOrgPrivateDTO sysOrgPrivateDTO) throws Exception;
	
	@GetMapping(value = "/{staffId:\\d+}")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable java.lang.Long staffId) throws Exception;
	
	@PutMapping
	public ExecuteResultDTO update(@RequestBody SysOrgPrivateDTO sysOrgPrivateDTO) throws Exception;
	
	@GetMapping
	public ExecuteResultDTO findByConds(SysOrgPrivateQueryPageDTO sysOrgPrivateQueryPageDTO) throws Exception;
	
}