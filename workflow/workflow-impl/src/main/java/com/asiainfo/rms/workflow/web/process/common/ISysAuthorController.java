package com.asiainfo.rms.workflow.web.process.common;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysAuthorDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysAuthorQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@RequestMapping("/process/common/sysauthor")
public interface ISysAuthorController {

	@DeleteMapping(value = "/{authorId:\\d+}")
	public void deleteByPrimaryKey(@PathVariable java.lang.Long authorId) throws Exception;
	
	@PostMapping
	public ExecuteResultDTO save(@RequestBody SysAuthorDTO sysAuthorDTO) throws Exception;
	
	@GetMapping(value = "/{authorId:\\d+}")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable java.lang.Long authorId) throws Exception;
	
	@PutMapping
	public ExecuteResultDTO update(@RequestBody SysAuthorDTO sysAuthorDTO) throws Exception;
	
	@GetMapping
	public ExecuteResultDTO findByConds(SysAuthorQueryPageDTO sysAuthorQueryPageDTO) throws Exception;
	
}