package com.asiainfo.rms.workflow.web.process.common;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysAuthorWorkflowDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysAuthorWorkflowQueryPageDTO;

/**
 * 岗位与工作流关联表
 * 
 * @author joker
 */
@RequestMapping("/process/common/sysauthorworkflow")
public interface ISysAuthorWorkflowController {

	@DeleteMapping(value = "/{sawId:\\d+}")
	public void deleteByPrimaryKey(@PathVariable Long sawId) throws Exception;
	
	@PostMapping
	public ExecuteResultDTO save(@RequestBody SysAuthorWorkflowDTO sysAuthorWorkflowDTO) throws Exception;
	
	@GetMapping(value = "/{sawId:\\d+}")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable Long sawId) throws Exception;
	
	@PutMapping
	public ExecuteResultDTO update(@RequestBody SysAuthorWorkflowDTO sysAuthorWorkflowDTO) throws Exception;
	
	@GetMapping
	public ExecuteResultDTO findByConds(SysAuthorWorkflowQueryPageDTO sysAuthorWorkflowQueryPageDTO) throws Exception;
	
}