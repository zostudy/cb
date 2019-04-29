package com.asiainfo.rms.workflow.web.process.common.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.AlmSysParamBO;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.AlmSysParamDTO;
import com.asiainfo.rms.workflow.dto.process.common.AlmSysParamQueryPageDTO;
import com.asiainfo.rms.workflow.mapper.process.common.AlmSysParamMapper;
import com.asiainfo.rms.workflow.service.process.common.IAlmSysParamService;
import com.asiainfo.rms.workflow.web.process.common.IAlmSysParamController;

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
public class AlmSysParamControllerImpl implements IAlmSysParamController {
	
	@Autowired
	private IAlmSysParamService almSysParamService;

	@Override
	@ApiOperation(value = "依据主键删除(流程无关)")
	public void deleteByPrimaryKey(@PathVariable java.lang.Long paramId) throws Exception {
		almSysParamService.deleteByPrimaryKey(paramId);
	}
	
	@Override
	@ApiOperation(value = "新增(流程无关)")
	public ExecuteResultDTO save(@RequestBody AlmSysParamDTO almSysParamDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			almSysParamDTO = AlmSysParamMapper.INSTANCE.boToDto(almSysParamService.save(AlmSysParamMapper.INSTANCE.dtoToBo(almSysParamDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("param_id", almSysParamDTO.getParamId());
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
	public ExecuteResultDTO findByPrimaryKey(@PathVariable java.lang.Long paramId) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			AlmSysParamDTO almSysParamDTO = AlmSysParamMapper.INSTANCE.boToDto(almSysParamService.findByPrimaryKey(paramId));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(almSysParamDTO);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "更新(流程无关)")
	public ExecuteResultDTO update(@RequestBody AlmSysParamDTO almSysParamDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			almSysParamDTO = AlmSysParamMapper.INSTANCE.boToDto(almSysParamService.update(AlmSysParamMapper.INSTANCE.dtoToBo(almSysParamDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("param_id", almSysParamDTO.getParamId());
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
	public ExecuteResultDTO findByConds(AlmSysParamQueryPageDTO almSysParamQueryPageDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			Page<AlmSysParamBO> almSysParamBOs = almSysParamService.findByConds(AlmSysParamMapper.INSTANCE.dtoToBo(almSysParamQueryPageDTO));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(AlmSysParamMapper.INSTANCE.boToDto(almSysParamBOs));
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
}