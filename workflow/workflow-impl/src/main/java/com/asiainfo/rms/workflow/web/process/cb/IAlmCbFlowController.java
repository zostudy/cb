package com.asiainfo.rms.workflow.web.process.cb;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFlowDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFlowQueryPageDTO;

/**
 * 流水表
 * 
 * @author joker
 */
@RequestMapping("/process/cb/almcbflow")
public interface IAlmCbFlowController {

	@DeleteMapping(value = "/{flowId:\\d+}")
	public void deleteByPrimaryKey(@PathVariable Long flowId) throws Exception;
	
	@PostMapping
	public ExecuteResultDTO save(@RequestBody AlmCbFlowDTO almCbFlowDTO) throws Exception;
	
	@GetMapping(value = "/{flowId:\\d+}")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable Long flowId) throws Exception;
	
	@PutMapping
	public ExecuteResultDTO update(@RequestBody AlmCbFlowDTO almCbFlowDTO) throws Exception;
	
	@GetMapping
	public ExecuteResultDTO findByConds(AlmCbFlowQueryPageDTO almCbFlowQueryPageDTO) throws Exception;
	
}