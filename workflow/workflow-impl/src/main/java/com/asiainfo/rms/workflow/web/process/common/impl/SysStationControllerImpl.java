package com.asiainfo.rms.workflow.web.process.common.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysStationBO;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysStationDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysStationQueryPageDTO;
import com.asiainfo.rms.workflow.mapper.process.common.SysStationMapper;
import com.asiainfo.rms.workflow.service.process.common.ISysStationService;
import com.asiainfo.rms.workflow.web.process.common.ISysStationController;

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
public class SysStationControllerImpl implements ISysStationController {
	
	@Autowired
	private ISysStationService sysStationService;

	@Override
	@ApiOperation(value = "依据主键删除(流程无关)")
	public void deleteByPrimaryKey(@PathVariable java.lang.Long stationId) throws Exception {
		sysStationService.deleteByPrimaryKey(stationId);
	}
	
	@Override
	@ApiOperation(value = "新增(流程无关)")
	public ExecuteResultDTO save(@RequestBody SysStationDTO sysStationDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			sysStationDTO = SysStationMapper.INSTANCE.boToDto(sysStationService.save(SysStationMapper.INSTANCE.dtoToBo(sysStationDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("station_id", sysStationDTO.getStationId());
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
	public ExecuteResultDTO findByPrimaryKey(@PathVariable java.lang.Long stationId) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			SysStationDTO sysStationDTO = SysStationMapper.INSTANCE.boToDto(sysStationService.findByPrimaryKey(stationId));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(sysStationDTO);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "更新(流程无关)")
	public ExecuteResultDTO update(@RequestBody SysStationDTO sysStationDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			sysStationDTO = SysStationMapper.INSTANCE.boToDto(sysStationService.update(SysStationMapper.INSTANCE.dtoToBo(sysStationDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("station_id", sysStationDTO.getStationId());
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
	public ExecuteResultDTO findByConds(SysStationQueryPageDTO sysStationQueryPageDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			Page<SysStationBO> sysStationBOs = sysStationService.findByConds(SysStationMapper.INSTANCE.dtoToBo(sysStationQueryPageDTO));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(SysStationMapper.INSTANCE.boToDto(sysStationBOs));
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
}