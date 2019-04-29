package com.asiainfo.rms.workflow.web.common.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.AssessDTO;
import com.asiainfo.rms.workflow.mapper.common.AssessMapper;
import com.asiainfo.rms.workflow.service.common.IOrderAssessService;
import com.asiainfo.rms.workflow.web.common.OrderAssessContraller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
@Data
@Log4j
@Transactional
@RestController
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderAssessContrallerImpl implements OrderAssessContraller {

	@Autowired
	IOrderAssessService orderAssessService;
	
	public ExecuteResultDTO saveAssess(@RequestBody AssessDTO assessValue)throws Exception{
		ExecuteResultDTO result = new ExecuteResultDTO();
		long assessId = orderAssessService.saveAssess(AssessMapper.INSTANCE.dtoToBo(assessValue));
		result.setObj(assessId);
		result.setCode(1);
		result.setMsg("success");
		return result;
	}
	
	public ExecuteResultDTO updateAssess(@RequestBody AssessDTO assessValue)throws Exception{
		ExecuteResultDTO result = new ExecuteResultDTO();
		orderAssessService.updateAssess(AssessMapper.INSTANCE.dtoToBo(assessValue));
		result.setCode(1);
		result.setMsg("success");
		return result;
	}
	
	public ExecuteResultDTO delAssess(@RequestParam(value="assess_id") Integer assessId)throws Exception{
		ExecuteResultDTO result = new ExecuteResultDTO();
		orderAssessService.delAssess(assessId);
		result.setCode(1);
		result.setMsg("success");
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public ExecuteResultDTO queryAssess(@RequestParam(value="assess_id",required=false) Integer assessId,
			@RequestParam(value="order_id",required=false) Integer orderId,
			@RequestParam(value="req_id",required=false) Integer reqId)throws Exception{
		ExecuteResultDTO result = new ExecuteResultDTO();
		List<AssessDTO> list =AssessMapper.INSTANCE.BOListToDTOList(orderAssessService.queryAssess(null==assessId?0:assessId, null==orderId?0:orderId, null==reqId?0:reqId));
		@SuppressWarnings("rawtypes")
		Map listMap = new HashMap();
		listMap.put("assess_list", list);
		result.setObj(listMap);
		result.setCode(1);
		result.setMsg("success");
		return result;
	}

}
