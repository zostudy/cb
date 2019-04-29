package com.asiainfo.rms.workflow.web.process.cb.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbThermoCompressorBO;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbThermoCompressorDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbThermoCompressorQueryPageDTO;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbThermoCompressorMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbThermoCompressorService;
import com.asiainfo.rms.workflow.web.process.cb.IAlmCbThermoCompressorController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * 
 * 
 * @author joker
 */
@Data
@Log4j
@Transactional
@RestController
@AllArgsConstructor
@RequiredArgsConstructor
@Api(value = "增删改查操作接口(流程无关)")
public class AlmCbThermoCompressorControllerImpl implements IAlmCbThermoCompressorController {
	
	@Autowired
	private IAlmCbThermoCompressorService almCbThermoCompressorService;

	@Override
	@ApiOperation(value = "依据主键删除(流程无关)")
	public void deleteByPrimaryKey(@PathVariable Long tcId) throws Exception {
		almCbThermoCompressorService.deleteByPrimaryKey(tcId);
	}
	
	@Override
	@ApiOperation(value = "新增(流程无关)")
	public ExecuteResultDTO save(@RequestBody AlmCbThermoCompressorDTO almCbThermoCompressorDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			almCbThermoCompressorDTO = AlmCbThermoCompressorMapper.INSTANCE.boToDto(almCbThermoCompressorService.save(AlmCbThermoCompressorMapper.INSTANCE.dtoToBo(almCbThermoCompressorDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("tc_id", almCbThermoCompressorDTO.getTcId());
			result.setObj(primaryKey);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "依据主键查询(流程无关)")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable Long tcId) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			AlmCbThermoCompressorDTO almCbThermoCompressorDTO = AlmCbThermoCompressorMapper.INSTANCE.boToDto(almCbThermoCompressorService.findByPrimaryKey(tcId));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(almCbThermoCompressorDTO);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "更新(流程无关)")
	public ExecuteResultDTO update(@RequestBody AlmCbThermoCompressorDTO almCbThermoCompressorDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			almCbThermoCompressorDTO = AlmCbThermoCompressorMapper.INSTANCE.boToDto(almCbThermoCompressorService.update(AlmCbThermoCompressorMapper.INSTANCE.dtoToBo(almCbThermoCompressorDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("tc_id", almCbThermoCompressorDTO.getTcId());
			result.setObj(primaryKey);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "分页查询(流程无关)")
	public ExecuteResultDTO findByConds(AlmCbThermoCompressorQueryPageDTO almCbThermoCompressorQueryPageDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			Page<AlmCbThermoCompressorBO> almCbThermoCompressorBOs = almCbThermoCompressorService.findByConds(AlmCbThermoCompressorMapper.INSTANCE.dtoToBo(almCbThermoCompressorQueryPageDTO));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(AlmCbThermoCompressorMapper.INSTANCE.boToDto(almCbThermoCompressorBOs));
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
}