package com.asiainfo.rms.workflow.web.process.cb.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFlowBO;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFlowDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFlowQueryPageDTO;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbFlowMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbFlowService;
import com.asiainfo.rms.workflow.web.process.cb.IAlmCbFlowController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * 流水表
 * 
 * @author joker
 */
@Data
@Log4j
@Transactional
@RestController
@AllArgsConstructor
@RequiredArgsConstructor
@Api(value = "流水表增删改查操作接口(流程无关)")
public class AlmCbFlowControllerImpl implements IAlmCbFlowController {
	
	@Autowired
	private IAlmCbFlowService almCbFlowService;

	@Override
	@ApiOperation(value = "依据主键删除流水表(流程无关)")
	public void deleteByPrimaryKey(@PathVariable Long flowId) throws Exception {
		almCbFlowService.deleteByPrimaryKey(flowId);
	}
	
	@Override
	@ApiOperation(value = "新增流水表(流程无关)")
	public ExecuteResultDTO save(@RequestBody AlmCbFlowDTO almCbFlowDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			almCbFlowDTO = AlmCbFlowMapper.INSTANCE.boToDto(almCbFlowService.save(AlmCbFlowMapper.INSTANCE.dtoToBo(almCbFlowDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("flow_id", almCbFlowDTO.getFlowId());
			result.setObj(primaryKey);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "依据主键查询流水表(流程无关)")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable Long flowId) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			AlmCbFlowDTO almCbFlowDTO = AlmCbFlowMapper.INSTANCE.boToDto(almCbFlowService.findByPrimaryKey(flowId));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(almCbFlowDTO);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "更新流水表(流程无关)")
	public ExecuteResultDTO update(@RequestBody AlmCbFlowDTO almCbFlowDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			almCbFlowDTO = AlmCbFlowMapper.INSTANCE.boToDto(almCbFlowService.update(AlmCbFlowMapper.INSTANCE.dtoToBo(almCbFlowDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("flow_id", almCbFlowDTO.getFlowId());
			result.setObj(primaryKey);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "分页查询流水表(流程无关)")
	public ExecuteResultDTO findByConds(AlmCbFlowQueryPageDTO almCbFlowQueryPageDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			Page<AlmCbFlowBO> almCbFlowBOs = almCbFlowService.findByConds(AlmCbFlowMapper.INSTANCE.dtoToBo(almCbFlowQueryPageDTO));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(AlmCbFlowMapper.INSTANCE.boToDto(almCbFlowBOs));
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
}