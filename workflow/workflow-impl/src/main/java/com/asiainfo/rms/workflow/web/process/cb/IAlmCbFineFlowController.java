package com.asiainfo.rms.workflow.web.process.cb;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFineFlowDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFineFlowQueryPageDTO;

/**
 * 罚款流水
 * 
 * @author joker
 */
@RequestMapping("/process/cb/almcbfineflow")
public interface IAlmCbFineFlowController {

	@DeleteMapping(value = "/{fineId:\\d+}")
	public void deleteByPrimaryKey(@PathVariable Long fineId) throws Exception;
	
	@PostMapping
	public ExecuteResultDTO save(@RequestBody AlmCbFineFlowDTO almCbFineFlowDTO) throws Exception;
	
	@GetMapping(value = "/{fineId:\\d+}")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable Long fineId) throws Exception;
	
	@PutMapping
	public ExecuteResultDTO update(@RequestBody AlmCbFineFlowDTO almCbFineFlowDTO) throws Exception;
	
	@GetMapping
	public ExecuteResultDTO findByConds(AlmCbFineFlowQueryPageDTO almCbFineFlowQueryPageDTO) throws Exception;
	
}