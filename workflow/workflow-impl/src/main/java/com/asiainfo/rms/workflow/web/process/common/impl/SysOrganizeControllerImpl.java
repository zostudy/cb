package com.asiainfo.rms.workflow.web.process.common.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysOrganizeBO;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysOrganizeDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysOrganizeQueryPageDTO;
import com.asiainfo.rms.workflow.mapper.process.common.SysOrganizeMapper;
import com.asiainfo.rms.workflow.service.process.common.ISysOrganizeService;
import com.asiainfo.rms.workflow.web.process.common.ISysOrganizeController;

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
public class SysOrganizeControllerImpl implements ISysOrganizeController {
	
	@Autowired
	private ISysOrganizeService sysOrganizeService;

	@Override
	@ApiOperation(value = "依据主键删除(流程无关)")
	public void deleteByPrimaryKey(@PathVariable java.lang.Long organizeId) throws Exception {
		sysOrganizeService.deleteByPrimaryKey(organizeId);
	}
	
	@Override
	@ApiOperation(value = "新增(流程无关)")
	public ExecuteResultDTO save(@RequestBody SysOrganizeDTO sysOrganizeDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			sysOrganizeDTO = SysOrganizeMapper.INSTANCE.boToDto(sysOrganizeService.save(SysOrganizeMapper.INSTANCE.dtoToBo(sysOrganizeDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("organize_id", sysOrganizeDTO.getOrganizeId());
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
	public ExecuteResultDTO findByPrimaryKey(@PathVariable java.lang.Long organizeId) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			SysOrganizeDTO sysOrganizeDTO = SysOrganizeMapper.INSTANCE.boToDto(sysOrganizeService.findByPrimaryKey(organizeId));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(sysOrganizeDTO);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "更新(流程无关)")
	public ExecuteResultDTO update(@RequestBody SysOrganizeDTO sysOrganizeDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			sysOrganizeDTO = SysOrganizeMapper.INSTANCE.boToDto(sysOrganizeService.update(SysOrganizeMapper.INSTANCE.dtoToBo(sysOrganizeDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("organize_id", sysOrganizeDTO.getOrganizeId());
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
	public ExecuteResultDTO findByConds(SysOrganizeQueryPageDTO sysOrganizeQueryPageDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			Page<SysOrganizeBO> sysOrganizeBOs = sysOrganizeService.findByConds(SysOrganizeMapper.INSTANCE.dtoToBo(sysOrganizeQueryPageDTO));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(SysOrganizeMapper.INSTANCE.boToDto(sysOrganizeBOs));
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
}