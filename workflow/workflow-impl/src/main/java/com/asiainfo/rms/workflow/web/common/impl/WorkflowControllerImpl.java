package com.asiainfo.rms.workflow.web.common.impl;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.workflow.WorkorderUpdateDTO;
import com.asiainfo.rms.workflow.mapper.workflow.WorkorderMapper;
import com.asiainfo.rms.workflow.service.api.WorkflowControllerApi;
import com.asiainfo.rms.workflow.service.process.common.IAlmProcessRoamSV;
import com.asiainfo.rms.workflow.web.common.WorkflowController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liuchao on 2017/7/19.
 */
@Log4j
@RestController
@Api(tags = {"公共服务调用接口"})
public class WorkflowControllerImpl implements WorkflowController{

    @Autowired
    private WorkflowControllerApi api;
	@Autowired
	IAlmProcessRoamSV almProcessRoamSV;
    
	@Override
	@ApiOperation(value = "更新工单信息接口")
	public ExecuteResultDTO updateOrder(@RequestBody WorkorderUpdateDTO data) {
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		try {
			api.updateWorkorder(WorkorderMapper.INSTANCE.dtoToBo(data));
			executeResult.setCode(1);
			executeResult.setMsg("success");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return executeResult;
	}

	@Override
	@ApiOperation(value = "流程业务编码接口")
	public Map<String, Object> getBizNo(@PathVariable(value = "prefix", required = true)@ApiParam(value = "编码前缀", required = true) String prefix) {
		Map<String, Object> result = new HashMap<String, Object>();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		// str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
		result.put("bizNo", prefix.toUpperCase() + df.format(new Date()) + UUID.randomUUID().toString().substring(9, 13).toUpperCase());
		log.info("流程业务编码: " + result.get("bizNo"));
		return result;
	}

	@Override
	@ApiOperation(value = "重新部署流程图接口")
	public ExecuteResultDTO deploy(@PathVariable(value = "sourcePath", required = true)@ApiParam(value = "流程图位置", required = true) String sourcePath) {
		ExecuteResultDTO executeResult = new ExecuteResultDTO();
		try {
			sourcePath = java.net.URLDecoder.decode(sourcePath, "UTF-8");
			almProcessRoamSV.deploymentProcessBySourcePath(sourcePath);
			executeResult.setCode(1);
			executeResult.setMsg("success");
		} catch (Exception e) {
			executeResult.setCode(0);
			executeResult.setMsg(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
		}
		return executeResult;
	}

	@Override
	public Map<String, Object> getDate(@PathVariable(value = "date", required = false) String date) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Long.valueOf(date);
		} catch(Exception e) {
			Calendar c = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dateDate = null;
			try {
				dateDate = sdf.parse(date);// 初始日期
			} catch (Exception e1) {

			}
			c.setTime(dateDate);// 设置日历时间
			c.add(Calendar.MONTH, 0);
			c.set(Calendar.DAY_OF_MONTH, 1);
			result.put("specFirstDay", sdf.format(c.getTime()) + " 00:00:00");
			c = Calendar.getInstance();
			c.setTime(dateDate);// 设置日历时间
			c.add(Calendar.MONTH, 1);
			c.set(Calendar.DAY_OF_MONTH, 0);
			result.put("specLastDay", sdf.format(c.getTime()) + " 23:59:59");
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		result.put("date", df.format(new Date()));
		Calendar cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 0);
		cale.set(Calendar.DAY_OF_MONTH, 1);
		result.put("firstDay", df.format(cale.getTime()) + " 00:00:00");
		cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 1);
		cale.set(Calendar.DAY_OF_MONTH, 0);
		result.put("lastDay", df.format(cale.getTime()) + " 23:59:59");
		SimpleDateFormat dfYear = new SimpleDateFormat("yyyy");
		SimpleDateFormat dfMonth = new SimpleDateFormat("MM");
		result.put("year", dfYear.format(new Date()));
		result.put("month", dfMonth.format(new Date()));
		log.info("当前日期: " + result.get("date"));
		log.info("当月第一天: " + result.get("firstDay"));
		log.info("当月最后一天: " + result.get("lastDay"));
		log.info("当月月份: " + result.get("current"));
		return result;
	}
}
