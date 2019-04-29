package com.asiainfo.rms.workflow.web.process.cb;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbSawBoardDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbSawBoardQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@RequestMapping("/process/cb/almcbsawboard")
public interface IAlmCbSawBoardController {

	@DeleteMapping(value = "/{sbId:\\d+}")
	public void deleteByPrimaryKey(@PathVariable Long sbId) throws Exception;
	
	@PostMapping
	public ExecuteResultDTO save(@RequestBody AlmCbSawBoardDTO almCbSawBoardDTO) throws Exception;
	
	@GetMapping(value = "/{sbId:\\d+}")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable Long sbId) throws Exception;
	
	@PutMapping
	public ExecuteResultDTO update(@RequestBody AlmCbSawBoardDTO almCbSawBoardDTO) throws Exception;
	
	@GetMapping
	public ExecuteResultDTO findByConds(AlmCbSawBoardQueryPageDTO almCbSawBoardQueryPageDTO) throws Exception;
	
}