package com.asiainfo.rms.workflow.web.process.common.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.AlmWorkorderListBO;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.AlmWorkorderListDTO;
import com.asiainfo.rms.workflow.dto.process.common.AlmWorkorderListQueryPageDTO;
import com.asiainfo.rms.workflow.mapper.process.common.AlmWorkorderListMapper;
import com.asiainfo.rms.workflow.service.process.common.IAlmWorkorderListService;
import com.asiainfo.rms.workflow.web.process.common.IAlmWorkorderListController;

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
public class AlmWorkorderListControllerImpl implements IAlmWorkorderListController {
	
	@Autowired
	private IAlmWorkorderListService almWorkorderListService;

	@Override
	@ApiOperation(value = "依据主键删除(流程无关)")
	public void deleteByPrimaryKey(@PathVariable java.lang.Long orderId) throws Exception {
		almWorkorderListService.deleteByPrimaryKey(orderId);
	}
	
	@Override
	@ApiOperation(value = "新增(流程无关)")
	public ExecuteResultDTO save(@RequestBody AlmWorkorderListDTO almWorkorderListDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			almWorkorderListDTO = AlmWorkorderListMapper.INSTANCE.boToDto(almWorkorderListService.save(AlmWorkorderListMapper.INSTANCE.dtoToBo(almWorkorderListDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("order_id", almWorkorderListDTO.getOrderId());
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
	public ExecuteResultDTO findByPrimaryKey(@PathVariable java.lang.Long orderId) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			AlmWorkorderListDTO almWorkorderListDTO = AlmWorkorderListMapper.INSTANCE.boToDto(almWorkorderListService.findByPrimaryKey(orderId));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(almWorkorderListDTO);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "更新(流程无关)")
	public ExecuteResultDTO update(@RequestBody AlmWorkorderListDTO almWorkorderListDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			almWorkorderListDTO = AlmWorkorderListMapper.INSTANCE.boToDto(almWorkorderListService.update(AlmWorkorderListMapper.INSTANCE.dtoToBo(almWorkorderListDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("order_id", almWorkorderListDTO.getOrderId());
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
	public ExecuteResultDTO findByConds(AlmWorkorderListQueryPageDTO almWorkorderListQueryPageDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			if (almWorkorderListQueryPageDTO.getExec_staff_id_begin() != null && almWorkorderListQueryPageDTO.getExec_staff_id_begin().compareTo(0L) == 0 && almWorkorderListQueryPageDTO.getExec_staff_id_end() != null && almWorkorderListQueryPageDTO.getExec_staff_id_end().compareTo(0L) == 0) {
				almWorkorderListQueryPageDTO.setExec_staff_id_begin(null);
				almWorkorderListQueryPageDTO.setExec_staff_id_end(null);
				Page<AlmWorkorderListBO> almWorkorderListBOs = almWorkorderListService.findByConds(AlmWorkorderListMapper.INSTANCE.dtoToBo(almWorkorderListQueryPageDTO));
				result.setObj(AlmWorkorderListMapper.INSTANCE.boToDto(almWorkorderListBOs));
			} else {
				Page<AlmWorkorderListBO> almWorkorderListBOs = almWorkorderListService.findByConds(AlmWorkorderListMapper.INSTANCE.dtoToBo(almWorkorderListQueryPageDTO));
				result.setObj(AlmWorkorderListMapper.INSTANCE.boToDto(almWorkorderListBOs));
			}
			result.setCode(1);
			result.setMsg("success");
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
}