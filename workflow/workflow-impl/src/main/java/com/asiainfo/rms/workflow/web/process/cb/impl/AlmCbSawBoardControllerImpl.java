package com.asiainfo.rms.workflow.web.process.cb.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbSawBoardBO;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbSawBoardDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbSawBoardQueryPageDTO;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbSawBoardMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbSawBoardService;
import com.asiainfo.rms.workflow.web.process.cb.IAlmCbSawBoardController;

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
public class AlmCbSawBoardControllerImpl implements IAlmCbSawBoardController {
	
	@Autowired
	private IAlmCbSawBoardService almCbSawBoardService;

	@Override
	@ApiOperation(value = "依据主键删除(流程无关)")
	public void deleteByPrimaryKey(@PathVariable Long sbId) throws Exception {
		almCbSawBoardService.deleteByPrimaryKey(sbId);
	}
	
	@Override
	@ApiOperation(value = "新增(流程无关)")
	public ExecuteResultDTO save(@RequestBody AlmCbSawBoardDTO almCbSawBoardDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			almCbSawBoardDTO = AlmCbSawBoardMapper.INSTANCE.boToDto(almCbSawBoardService.save(AlmCbSawBoardMapper.INSTANCE.dtoToBo(almCbSawBoardDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("sb_id", almCbSawBoardDTO.getSbId());
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
	public ExecuteResultDTO findByPrimaryKey(@PathVariable Long sbId) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			AlmCbSawBoardDTO almCbSawBoardDTO = AlmCbSawBoardMapper.INSTANCE.boToDto(almCbSawBoardService.findByPrimaryKey(sbId));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(almCbSawBoardDTO);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "更新(流程无关)")
	public ExecuteResultDTO update(@RequestBody AlmCbSawBoardDTO almCbSawBoardDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			almCbSawBoardDTO = AlmCbSawBoardMapper.INSTANCE.boToDto(almCbSawBoardService.update(AlmCbSawBoardMapper.INSTANCE.dtoToBo(almCbSawBoardDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("sb_id", almCbSawBoardDTO.getSbId());
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
	public ExecuteResultDTO findByConds(AlmCbSawBoardQueryPageDTO almCbSawBoardQueryPageDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			Page<AlmCbSawBoardBO> almCbSawBoardBOs = almCbSawBoardService.findByConds(AlmCbSawBoardMapper.INSTANCE.dtoToBo(almCbSawBoardQueryPageDTO));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(AlmCbSawBoardMapper.INSTANCE.boToDto(almCbSawBoardBOs));
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
}