package com.asiainfo.rms.workflow.web.process.cb;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFlowHisDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFlowHisQueryPageDTO;

/**
 * 详情表
 * 
 * @author joker
 */
@RequestMapping("/process/cb/almcbflowhis")
public interface IAlmCbFlowHisController {

	@DeleteMapping(value = "/{hisFlowId:\\d+}")
	public void deleteByPrimaryKey(@PathVariable Long hisFlowId) throws Exception;
	
	@PostMapping
	public ExecuteResultDTO save(@RequestBody AlmCbFlowHisDTO almCbFlowHisDTO) throws Exception;
	
	@GetMapping(value = "/{hisFlowId:\\d+}")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable Long hisFlowId) throws Exception;
	
	@PutMapping
	public ExecuteResultDTO update(@RequestBody AlmCbFlowHisDTO almCbFlowHisDTO) throws Exception;
	
	@GetMapping
	public ExecuteResultDTO findByConds(AlmCbFlowHisQueryPageDTO almCbFlowHisQueryPageDTO) throws Exception;
	
}