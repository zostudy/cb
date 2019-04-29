package com.asiainfo.rms.workflow.web.process.common.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysStaffOrgRelatBO;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysStaffOrgRelatDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysStaffOrgRelatQueryPageDTO;
import com.asiainfo.rms.workflow.mapper.process.common.SysStaffOrgRelatMapper;
import com.asiainfo.rms.workflow.service.process.common.ISysStaffOrgRelatService;
import com.asiainfo.rms.workflow.web.process.common.ISysStaffOrgRelatController;

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
public class SysStaffOrgRelatControllerImpl implements ISysStaffOrgRelatController {
	
	@Autowired
	private ISysStaffOrgRelatService sysStaffOrgRelatService;

	@Override
	@ApiOperation(value = "依据主键删除(流程无关)")
	public void deleteByPrimaryKey(@PathVariable java.lang.Long staffOrgRelatId) throws Exception {
		sysStaffOrgRelatService.deleteByPrimaryKey(staffOrgRelatId);
	}
	
	@Override
	@ApiOperation(value = "新增(流程无关)")
	public ExecuteResultDTO save(@RequestBody SysStaffOrgRelatDTO sysStaffOrgRelatDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			sysStaffOrgRelatDTO = SysStaffOrgRelatMapper.INSTANCE.boToDto(sysStaffOrgRelatService.save(SysStaffOrgRelatMapper.INSTANCE.dtoToBo(sysStaffOrgRelatDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("staff_org_relat_id", sysStaffOrgRelatDTO.getStaffOrgRelatId());
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
	public ExecuteResultDTO findByPrimaryKey(@PathVariable java.lang.Long staffOrgRelatId) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			SysStaffOrgRelatDTO sysStaffOrgRelatDTO = SysStaffOrgRelatMapper.INSTANCE.boToDto(sysStaffOrgRelatService.findByPrimaryKey(staffOrgRelatId));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(sysStaffOrgRelatDTO);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "更新(流程无关)")
	public ExecuteResultDTO update(@RequestBody SysStaffOrgRelatDTO sysStaffOrgRelatDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			sysStaffOrgRelatDTO = SysStaffOrgRelatMapper.INSTANCE.boToDto(sysStaffOrgRelatService.update(SysStaffOrgRelatMapper.INSTANCE.dtoToBo(sysStaffOrgRelatDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("staff_org_relat_id", sysStaffOrgRelatDTO.getStaffOrgRelatId());
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
	public ExecuteResultDTO findByConds(SysStaffOrgRelatQueryPageDTO sysStaffOrgRelatQueryPageDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			Page<SysStaffOrgRelatBO> sysStaffOrgRelatBOs = sysStaffOrgRelatService.findByConds(SysStaffOrgRelatMapper.INSTANCE.dtoToBo(sysStaffOrgRelatQueryPageDTO));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(SysStaffOrgRelatMapper.INSTANCE.boToDto(sysStaffOrgRelatBOs));
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
}