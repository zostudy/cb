package com.asiainfo.rms.workflow.web.process.cb.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbSalaryBO;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbSalaryDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbSalaryQueryPageDTO;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbSalaryMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbSalaryService;
import com.asiainfo.rms.workflow.web.process.cb.IAlmCbSalaryController;

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
public class AlmCbSalaryControllerImpl implements IAlmCbSalaryController {
	
	@Autowired
	private IAlmCbSalaryService almCbSalaryService;

	@Override
	@ApiOperation(value = "依据主键删除(流程无关)")
	public void deleteByPrimaryKey(@PathVariable Long sid) throws Exception {
		almCbSalaryService.deleteByPrimaryKey(sid);
	}
	
	@Override
	@ApiOperation(value = "新增(流程无关)")
	public ExecuteResultDTO save(@RequestBody AlmCbSalaryDTO almCbSalaryDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			almCbSalaryDTO = AlmCbSalaryMapper.INSTANCE.boToDto(almCbSalaryService.save(AlmCbSalaryMapper.INSTANCE.dtoToBo(almCbSalaryDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("s_id", almCbSalaryDTO.getSid());
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
	public ExecuteResultDTO findByPrimaryKey(@PathVariable Long sid) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			AlmCbSalaryDTO almCbSalaryDTO = AlmCbSalaryMapper.INSTANCE.boToDto(almCbSalaryService.findByPrimaryKey(sid));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(almCbSalaryDTO);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "更新(流程无关)")
	public ExecuteResultDTO update(@RequestBody AlmCbSalaryDTO almCbSalaryDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			almCbSalaryDTO = AlmCbSalaryMapper.INSTANCE.boToDto(almCbSalaryService.update(AlmCbSalaryMapper.INSTANCE.dtoToBo(almCbSalaryDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("s_id", almCbSalaryDTO.getSid());
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
	public ExecuteResultDTO findByConds(AlmCbSalaryQueryPageDTO almCbSalaryQueryPageDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			Page<AlmCbSalaryBO> almCbSalaryBOs = almCbSalaryService.findByConds(AlmCbSalaryMapper.INSTANCE.dtoToBo(almCbSalaryQueryPageDTO));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(AlmCbSalaryMapper.INSTANCE.boToDto(almCbSalaryBOs));
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
}