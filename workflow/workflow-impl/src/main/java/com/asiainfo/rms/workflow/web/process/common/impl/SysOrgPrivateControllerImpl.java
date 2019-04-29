package com.asiainfo.rms.workflow.web.process.common.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysOrgPrivateBO;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysOrgPrivateDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysOrgPrivateQueryPageDTO;
import com.asiainfo.rms.workflow.mapper.process.common.SysOrgPrivateMapper;
import com.asiainfo.rms.workflow.service.process.common.ISysOrgPrivateService;
import com.asiainfo.rms.workflow.web.process.common.ISysOrgPrivateController;

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
public class SysOrgPrivateControllerImpl implements ISysOrgPrivateController {
	
	@Autowired
	private ISysOrgPrivateService sysOrgPrivateService;

	@Override
	@ApiOperation(value = "依据主键删除(流程无关)")
	public void deleteByPrimaryKey(@PathVariable java.lang.Long staffId) throws Exception {
		sysOrgPrivateService.deleteByPrimaryKey(staffId);
	}
	
	@Override
	@ApiOperation(value = "新增(流程无关)")
	public ExecuteResultDTO save(@RequestBody SysOrgPrivateDTO sysOrgPrivateDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			sysOrgPrivateDTO = SysOrgPrivateMapper.INSTANCE.boToDto(sysOrgPrivateService.save(SysOrgPrivateMapper.INSTANCE.dtoToBo(sysOrgPrivateDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("staff_id", sysOrgPrivateDTO.getStaffId());
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
			SysOrgPrivateDTO sysOrgPrivateDTO = SysOrgPrivateMapper.INSTANCE.boToDto(sysOrgPrivateService.findByPrimaryKey(staffId));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(sysOrgPrivateDTO);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "更新(流程无关)")
	public ExecuteResultDTO update(@RequestBody SysOrgPrivateDTO sysOrgPrivateDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			sysOrgPrivateDTO = SysOrgPrivateMapper.INSTANCE.boToDto(sysOrgPrivateService.update(SysOrgPrivateMapper.INSTANCE.dtoToBo(sysOrgPrivateDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("staff_id", sysOrgPrivateDTO.getStaffId());
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
	public ExecuteResultDTO findByConds(SysOrgPrivateQueryPageDTO sysOrgPrivateQueryPageDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			Page<SysOrgPrivateBO> sysOrgPrivateBOs = sysOrgPrivateService.findByConds(SysOrgPrivateMapper.INSTANCE.dtoToBo(sysOrgPrivateQueryPageDTO));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(SysOrgPrivateMapper.INSTANCE.boToDto(sysOrgPrivateBOs));
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
}