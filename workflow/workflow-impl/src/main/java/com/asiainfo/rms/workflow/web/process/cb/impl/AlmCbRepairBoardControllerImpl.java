package com.asiainfo.rms.workflow.web.process.cb.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbRepairBoardBO;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbRepairBoardDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbRepairBoardQueryPageDTO;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbRepairBoardMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbRepairBoardService;
import com.asiainfo.rms.workflow.web.process.cb.IAlmCbRepairBoardController;

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
public class AlmCbRepairBoardControllerImpl implements IAlmCbRepairBoardController {
	
	@Autowired
	private IAlmCbRepairBoardService almCbRepairBoardService;

	@Override
	@ApiOperation(value = "依据主键删除(流程无关)")
	public void deleteByPrimaryKey(@PathVariable Long rbId) throws Exception {
		almCbRepairBoardService.deleteByPrimaryKey(rbId);
	}
	
	@Override
	@ApiOperation(value = "新增(流程无关)")
	public ExecuteResultDTO save(@RequestBody AlmCbRepairBoardDTO almCbRepairBoardDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			almCbRepairBoardDTO = AlmCbRepairBoardMapper.INSTANCE.boToDto(almCbRepairBoardService.save(AlmCbRepairBoardMapper.INSTANCE.dtoToBo(almCbRepairBoardDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("rb_id", almCbRepairBoardDTO.getRbId());
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
	public ExecuteResultDTO findByPrimaryKey(@PathVariable Long rbId) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			AlmCbRepairBoardDTO almCbRepairBoardDTO = AlmCbRepairBoardMapper.INSTANCE.boToDto(almCbRepairBoardService.findByPrimaryKey(rbId));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(almCbRepairBoardDTO);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "更新(流程无关)")
	public ExecuteResultDTO update(@RequestBody AlmCbRepairBoardDTO almCbRepairBoardDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			almCbRepairBoardDTO = AlmCbRepairBoardMapper.INSTANCE.boToDto(almCbRepairBoardService.update(AlmCbRepairBoardMapper.INSTANCE.dtoToBo(almCbRepairBoardDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("rb_id", almCbRepairBoardDTO.getRbId());
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
	public ExecuteResultDTO findByConds(AlmCbRepairBoardQueryPageDTO almCbRepairBoardQueryPageDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			Page<AlmCbRepairBoardBO> almCbRepairBoardBOs = almCbRepairBoardService.findByConds(AlmCbRepairBoardMapper.INSTANCE.dtoToBo(almCbRepairBoardQueryPageDTO));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(AlmCbRepairBoardMapper.INSTANCE.boToDto(almCbRepairBoardBOs));
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
}