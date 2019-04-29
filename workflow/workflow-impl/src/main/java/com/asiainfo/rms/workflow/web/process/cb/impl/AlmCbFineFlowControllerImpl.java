package com.asiainfo.rms.workflow.web.process.cb.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFineFlowBO;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFineFlowDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFineFlowQueryPageDTO;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbFineFlowMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbFineFlowService;
import com.asiainfo.rms.workflow.web.process.cb.IAlmCbFineFlowController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * 罚款流水
 * 
 * @author joker
 */
@Data
@Log4j
@Transactional
@RestController
@AllArgsConstructor
@RequiredArgsConstructor
@Api(value = "罚款流水增删改查操作接口(流程无关)")
public class AlmCbFineFlowControllerImpl implements IAlmCbFineFlowController {
	
	@Autowired
	private IAlmCbFineFlowService almCbFineFlowService;

	@Override
	@ApiOperation(value = "依据主键删除罚款流水(流程无关)")
	public void deleteByPrimaryKey(@PathVariable Long fineId) throws Exception {
		almCbFineFlowService.deleteByPrimaryKey(fineId);
	}
	
	@Override
	@ApiOperation(value = "新增罚款流水(流程无关)")
	public ExecuteResultDTO save(@RequestBody AlmCbFineFlowDTO almCbFineFlowDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			almCbFineFlowDTO = AlmCbFineFlowMapper.INSTANCE.boToDto(almCbFineFlowService.save(AlmCbFineFlowMapper.INSTANCE.dtoToBo(almCbFineFlowDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("fine_id", almCbFineFlowDTO.getFineId());
			result.setObj(primaryKey);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "依据主键查询罚款流水(流程无关)")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable Long fineId) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			AlmCbFineFlowDTO almCbFineFlowDTO = AlmCbFineFlowMapper.INSTANCE.boToDto(almCbFineFlowService.findByPrimaryKey(fineId));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(almCbFineFlowDTO);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "更新罚款流水(流程无关)")
	public ExecuteResultDTO update(@RequestBody AlmCbFineFlowDTO almCbFineFlowDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			almCbFineFlowDTO = AlmCbFineFlowMapper.INSTANCE.boToDto(almCbFineFlowService.update(AlmCbFineFlowMapper.INSTANCE.dtoToBo(almCbFineFlowDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("fine_id", almCbFineFlowDTO.getFineId());
			result.setObj(primaryKey);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "分页查询罚款流水(流程无关)")
	public ExecuteResultDTO findByConds(AlmCbFineFlowQueryPageDTO almCbFineFlowQueryPageDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			Page<AlmCbFineFlowBO> almCbFineFlowBOs = almCbFineFlowService.findByConds(AlmCbFineFlowMapper.INSTANCE.dtoToBo(almCbFineFlowQueryPageDTO));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(AlmCbFineFlowMapper.INSTANCE.boToDto(almCbFineFlowBOs));
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
}