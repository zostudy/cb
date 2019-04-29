package com.asiainfo.rms.workflow.web.process.common;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.AlmWorkorderListDTO;
import com.asiainfo.rms.workflow.dto.process.common.AlmWorkorderListQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@RequestMapping("/process/common/almworkorderlist")
public interface IAlmWorkorderListController {

	@DeleteMapping(value = "/{orderId:\\d+}")
	public void deleteByPrimaryKey(@PathVariable java.lang.Long orderId) throws Exception;
	
	@PostMapping
	public ExecuteResultDTO save(@RequestBody AlmWorkorderListDTO almWorkorderListDTO) throws Exception;
	
	@GetMapping(value = "/{orderId:\\d+}")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable java.lang.Long orderId) throws Exception;
	
	@PutMapping
	public ExecuteResultDTO update(@RequestBody AlmWorkorderListDTO almWorkorderListDTO) throws Exception;
	
	@GetMapping
	public ExecuteResultDTO findByConds(AlmWorkorderListQueryPageDTO almWorkorderListQueryPageDTO) throws Exception;
	
}