package com.asiainfo.rms.workflow.web.process.cb.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFlowHisBO;
import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFlowHisDTO;
import com.asiainfo.rms.workflow.dto.process.cb.AlmCbFlowHisQueryPageDTO;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbFlowHisMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbFlowHisService;
import com.asiainfo.rms.workflow.web.process.cb.IAlmCbFlowHisController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * 详情表
 * 
 * @author joker
 */
@Data
@Log4j
@Transactional
@RestController
@AllArgsConstructor
@RequiredArgsConstructor
@Api(value = "详情表增删改查操作接口(流程无关)")
public class AlmCbFlowHisControllerImpl implements IAlmCbFlowHisController {
	
	@Autowired
	private IAlmCbFlowHisService almCbFlowHisService;

	@Override
	@ApiOperation(value = "依据主键删除详情表(流程无关)")
	public void deleteByPrimaryKey(@PathVariable Long hisFlowId) throws Exception {
		almCbFlowHisService.deleteByPrimaryKey(hisFlowId);
	}
	
	@Override
	@ApiOperation(value = "新增详情表(流程无关)")
	public ExecuteResultDTO save(@RequestBody AlmCbFlowHisDTO almCbFlowHisDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			almCbFlowHisDTO = AlmCbFlowHisMapper.INSTANCE.boToDto(almCbFlowHisService.save(AlmCbFlowHisMapper.INSTANCE.dtoToBo(almCbFlowHisDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("his_flow_id", almCbFlowHisDTO.getHisFlowId());
			result.setObj(primaryKey);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "依据主键查询详情表(流程无关)")
	public ExecuteResultDTO findByPrimaryKey(@PathVariable Long hisFlowId) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			AlmCbFlowHisDTO almCbFlowHisDTO = AlmCbFlowHisMapper.INSTANCE.boToDto(almCbFlowHisService.findByPrimaryKey(hisFlowId));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(almCbFlowHisDTO);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "更新详情表(流程无关)")
	public ExecuteResultDTO update(@RequestBody AlmCbFlowHisDTO almCbFlowHisDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			almCbFlowHisDTO = AlmCbFlowHisMapper.INSTANCE.boToDto(almCbFlowHisService.update(AlmCbFlowHisMapper.INSTANCE.dtoToBo(almCbFlowHisDTO)));
			result.setCode(1);
			result.setMsg("success");
			Map<String, Long> primaryKey = new HashMap<String, Long>();
			primaryKey.put("his_flow_id", almCbFlowHisDTO.getHisFlowId());
			result.setObj(primaryKey);
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
	@Override
	@ApiOperation(value = "分页查询详情表(流程无关)")
	public ExecuteResultDTO findByConds(AlmCbFlowHisQueryPageDTO almCbFlowHisQueryPageDTO) throws Exception {
		ExecuteResultDTO result = new ExecuteResultDTO();
		try {
			Page<AlmCbFlowHisBO> almCbFlowHisBOs = almCbFlowHisService.findByConds(AlmCbFlowHisMapper.INSTANCE.dtoToBo(almCbFlowHisQueryPageDTO));
			result.setCode(1);
			result.setMsg("success");
			result.setObj(AlmCbFlowHisMapper.INSTANCE.boToDto(almCbFlowHisBOs));
		} catch (Exception e) {
			result.setCode(0);
			result.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
			log.error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return result;
	}
	
}