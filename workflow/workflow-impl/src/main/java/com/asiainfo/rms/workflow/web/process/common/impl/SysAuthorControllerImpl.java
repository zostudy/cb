package com.asiainfo.rms.workflow.web.process.common.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysAuthorBO;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysAuthorDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysAuthorQueryPageDTO;
import com.asiainfo.rms.workflow.mapper.process.common.SysAuthorMapper;
import com.asiainfo.rms.workflow.service.process.common.ISysAuthorService;
import com.asiainfo.rms.workflow.web.process.common.ISysAuthorController;

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
public class SysAuthorControllerImpl implements ISysAuthorController {
	
	@Autowired
	private ISysAuthorService sysAuthorService;

	@Override
	@ApiOperation(value = "依据主键删除(流程无关)")
	public void deleteByPrimaryKey(@PathVariable java.lang.Long authorId) throws Exception {
		sysAuthorService.deleteByPrimaryKey(authorId);
	}
	
	@Override
	@ApiOperation(value = "新增(流程无关)")
	public ExecuteResultDTO save(@RequestBody SysAuthorDTO sysAuthorDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			sysAuthorDTO = SysAuthorMapper.INSTANCE.boToDto(sysAuthorService.save(SysAuthorMapper.INSTANCE.dtoToBo(sysAuthorDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("author_id", sysAuthorDTO.getAuthorId());
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
	public ExecuteResultDTO findByPrimaryKey(@PathVariable java.lang.Long authorId) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			SysAuthorDTO sysAuthorDTO = SysAuthorMapper.INSTANCE.boToDto(sysAuthorService.findByPrimaryKey(authorId));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(sysAuthorDTO);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "更新(流程无关)")
	public ExecuteResultDTO update(@RequestBody SysAuthorDTO sysAuthorDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			sysAuthorDTO = SysAuthorMapper.INSTANCE.boToDto(sysAuthorService.update(SysAuthorMapper.INSTANCE.dtoToBo(sysAuthorDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("author_id", sysAuthorDTO.getAuthorId());
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
	public ExecuteResultDTO findByConds(SysAuthorQueryPageDTO sysAuthorQueryPageDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			Page<SysAuthorBO> sysAuthorBOs = sysAuthorService.findByConds(SysAuthorMapper.INSTANCE.dtoToBo(sysAuthorQueryPageDTO));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(SysAuthorMapper.INSTANCE.boToDto(sysAuthorBOs));
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
}