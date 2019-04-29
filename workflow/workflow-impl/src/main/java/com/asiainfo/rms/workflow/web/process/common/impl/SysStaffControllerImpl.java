package com.asiainfo.rms.workflow.web.process.common.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysStaffBO;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysStaffDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysStaffQueryPageDTO;
import com.asiainfo.rms.workflow.mapper.process.common.SysStaffMapper;
import com.asiainfo.rms.workflow.service.process.common.ISysStaffService;
import com.asiainfo.rms.workflow.web.process.common.ISysStaffController;

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
public class SysStaffControllerImpl implements ISysStaffController {
	
	@Autowired
	private ISysStaffService sysStaffService;

	@Override
	@ApiOperation(value = "依据主键删除(流程无关)")
	public void deleteByPrimaryKey(@PathVariable java.lang.Long staffId) throws Exception {
		sysStaffService.deleteByPrimaryKey(staffId);
	}
	
	@Override
	@ApiOperation(value = "新增(流程无关)")
	public ExecuteResultDTO save(@RequestBody SysStaffDTO sysStaffDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			sysStaffDTO = SysStaffMapper.INSTANCE.boToDto(sysStaffService.save(SysStaffMapper.INSTANCE.dtoToBo(sysStaffDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("staff_id", sysStaffDTO.getStaffId());
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
			SysStaffDTO sysStaffDTO = SysStaffMapper.INSTANCE.boToDto(sysStaffService.findByPrimaryKey(staffId));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(sysStaffDTO);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "更新(流程无关)")
	public ExecuteResultDTO update(@RequestBody SysStaffDTO sysStaffDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			sysStaffDTO = SysStaffMapper.INSTANCE.boToDto(sysStaffService.update(SysStaffMapper.INSTANCE.dtoToBo(sysStaffDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("staff_id", sysStaffDTO.getStaffId());
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
	public ExecuteResultDTO findByConds(SysStaffQueryPageDTO sysStaffQueryPageDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			Page<SysStaffBO> sysStaffBOs = sysStaffService.findByConds(SysStaffMapper.INSTANCE.dtoToBo(sysStaffQueryPageDTO));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(SysStaffMapper.INSTANCE.boToDto(sysStaffBOs));
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
}