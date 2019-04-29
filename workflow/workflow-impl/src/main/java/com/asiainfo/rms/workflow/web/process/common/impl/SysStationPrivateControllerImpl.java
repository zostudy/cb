package com.asiainfo.rms.workflow.web.process.common.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysStationPrivateBO;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysStationPrivateDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysStationPrivateQueryPageDTO;
import com.asiainfo.rms.workflow.mapper.process.common.SysStationPrivateMapper;
import com.asiainfo.rms.workflow.service.process.common.ISysStationPrivateService;
import com.asiainfo.rms.workflow.web.process.common.ISysStationPrivateController;

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
public class SysStationPrivateControllerImpl implements ISysStationPrivateController {
	
	@Autowired
	private ISysStationPrivateService sysStationPrivateService;

	@Override
	@ApiOperation(value = "依据主键删除(流程无关)")
	public void deleteByPrimaryKey(@PathVariable java.lang.Long staffId) throws Exception {
		sysStationPrivateService.deleteByPrimaryKey(staffId);
	}
	
	@Override
	@ApiOperation(value = "新增(流程无关)")
	public ExecuteResultDTO save(@RequestBody SysStationPrivateDTO sysStationPrivateDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			sysStationPrivateDTO = SysStationPrivateMapper.INSTANCE.boToDto(sysStationPrivateService.save(SysStationPrivateMapper.INSTANCE.dtoToBo(sysStationPrivateDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("staff_id", sysStationPrivateDTO.getStaffId());
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
	public ExecuteResultDTO findByPrimaryKey(@PathVariable java.lang.Long staffId) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			SysStationPrivateDTO sysStationPrivateDTO = SysStationPrivateMapper.INSTANCE.boToDto(sysStationPrivateService.findByPrimaryKey(staffId));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(sysStationPrivateDTO);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "更新(流程无关)")
	public ExecuteResultDTO update(@RequestBody SysStationPrivateDTO sysStationPrivateDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			sysStationPrivateDTO = SysStationPrivateMapper.INSTANCE.boToDto(sysStationPrivateService.update(SysStationPrivateMapper.INSTANCE.dtoToBo(sysStationPrivateDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("staff_id", sysStationPrivateDTO.getStaffId());
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
	public ExecuteResultDTO findByConds(SysStationPrivateQueryPageDTO sysStationPrivateQueryPageDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			Page<SysStationPrivateBO> sysStationPrivateBOs = sysStationPrivateService.findByConds(SysStationPrivateMapper.INSTANCE.dtoToBo(sysStationPrivateQueryPageDTO));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(SysStationPrivateMapper.INSTANCE.boToDto(sysStationPrivateBOs));
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
}