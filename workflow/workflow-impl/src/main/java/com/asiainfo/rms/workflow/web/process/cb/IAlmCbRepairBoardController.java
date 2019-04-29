package com.asiainfo.rms.workflow.web.process.cb;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbRepairBoardDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbRepairBoardQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@RequestMapping("/process/cb/almcbrepairboard")
public interface IAlmCbRepairBoardController {

	@DeleteMapping(value = "/{rbId:\\d+}")
	public void deleteByPrimaryKey(@PathVariable Long rbId) throws Exception;
	
	@PostMapping
	public ExecuteResultDTO save(@RequestBody AlmCbRepairBoardDTO almCbRepairBoardDTO) throws Exception;
	
	@GetMapping(value = "/{rbId:\\d+}")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable Long rbId) throws Exception;
	
	@PutMapping
	public ExecuteResultDTO update(@RequestBody AlmCbRepairBoardDTO almCbRepairBoardDTO) throws Exception;
	
	@GetMapping
	public ExecuteResultDTO findByConds(AlmCbRepairBoardQueryPageDTO almCbRepairBoardQueryPageDTO) throws Exception;
	
}