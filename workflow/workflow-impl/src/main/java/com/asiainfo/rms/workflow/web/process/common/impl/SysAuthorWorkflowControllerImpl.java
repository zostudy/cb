package com.asiainfo.rms.workflow.web.process.common.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysAuthorWorkflowBO;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysAuthorWorkflowDTO;
import com.asiainfo.rms.workflow.dto.process.common.SysAuthorWorkflowQueryPageDTO;
import com.asiainfo.rms.workflow.mapper.process.common.SysAuthorWorkflowMapper;
import com.asiainfo.rms.workflow.service.process.common.ISysAuthorWorkflowService;
import com.asiainfo.rms.workflow.web.process.common.ISysAuthorWorkflowController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * 岗位与工作流关联表
 * 
 * @author joker
 */
@Data
@Log4j
@Transactional
@RestController
@AllArgsConstructor
@RequiredArgsConstructor
@Api(value = "岗位与工作流关联表增删改查操作接口(流程无关)")
public class SysAuthorWorkflowControllerImpl implements ISysAuthorWorkflowController {
	
	@Autowired
	private ISysAuthorWorkflowService sysAuthorWorkflowService;

	@Override
	@ApiOperation(value = "依据主键删除岗位与工作流关联表(流程无关)")
	public void deleteByPrimaryKey(@PathVariable Long sawId) throws Exception {
		sysAuthorWorkflowService.deleteByPrimaryKey(sawId);
	}
	
	@Override
	@ApiOperation(value = "新增岗位与工作流关联表(流程无关)")
	public ExecuteResultDTO save(@RequestBody SysAuthorWorkflowDTO sysAuthorWorkflowDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			sysAuthorWorkflowDTO = SysAuthorWorkflowMapper.INSTANCE.boToDto(sysAuthorWorkflowService.save(SysAuthorWorkflowMapper.INSTANCE.dtoToBo(sysAuthorWorkflowDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("saw_id", sysAuthorWorkflowDTO.getSawId());
			result.setObj(primaryKey);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "依据主键查询岗位与工作流关联表(流程无关)")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable Long sawId) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			SysAuthorWorkflowDTO sysAuthorWorkflowDTO = SysAuthorWorkflowMapper.INSTANCE.boToDto(sysAuthorWorkflowService.findByPrimaryKey(sawId));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(sysAuthorWorkflowDTO);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "更新岗位与工作流关联表(流程无关)")
	public ExecuteResultDTO update(@RequestBody SysAuthorWorkflowDTO sysAuthorWorkflowDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			sysAuthorWorkflowDTO = SysAuthorWorkflowMapper.INSTANCE.boToDto(sysAuthorWorkflowService.update(SysAuthorWorkflowMapper.INSTANCE.dtoToBo(sysAuthorWorkflowDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("saw_id", sysAuthorWorkflowDTO.getSawId());
			result.setObj(primaryKey);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "分页查询岗位与工作流关联表(流程无关)")
	public ExecuteResultDTO findByConds(SysAuthorWorkflowQueryPageDTO sysAuthorWorkflowQueryPageDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			Page<SysAuthorWorkflowBO> sysAuthorWorkflowBOs = sysAuthorWorkflowService.findByConds(SysAuthorWorkflowMapper.INSTANCE.dtoToBo(sysAuthorWorkflowQueryPageDTO));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(SysAuthorWorkflowMapper.INSTANCE.boToDto(sysAuthorWorkflowBOs));
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
}