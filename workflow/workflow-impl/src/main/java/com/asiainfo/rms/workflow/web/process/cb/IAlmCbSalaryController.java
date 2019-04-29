package com.asiainfo.rms.workflow.web.process.cb;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbSalaryDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbSalaryQueryPageDTO;

/**
 * 
 * 
 * @author joker
 */
@RequestMapping("/process/cb/almcbsalary")
public interface IAlmCbSalaryController {

	@DeleteMapping(value = "/{sid:\\d+}")
	public void deleteByPrimaryKey(@PathVariable Long sid) throws Exception;
	
	@PostMapping
	public ExecuteResultDTO save(@RequestBody AlmCbSalaryDTO almCbSalaryDTO) throws Exception;
	
	@GetMapping(value = "/{sid:\\d+}")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable Long sid) throws Exception;
	
	@PutMapping
	public ExecuteResultDTO update(@RequestBody AlmCbSalaryDTO almCbSalaryDTO) throws Exception;
	
	@GetMapping
	public ExecuteResultDTO findByConds(AlmCbSalaryQueryPageDTO almCbSalaryQueryPageDTO) throws Exception;
	
}