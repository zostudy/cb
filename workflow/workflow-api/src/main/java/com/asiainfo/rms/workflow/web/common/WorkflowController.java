package com.asiainfo.rms.workflow.web.common;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.workflow.WorkorderUpdateDTO;

@RequestMapping("/process/common")
public interface WorkflowController {
	
	@RequestMapping(value="/ud/workorder",method = RequestMethod.POST)
    public @ResponseBody ExecuteResultDTO updateOrder(@RequestBody WorkorderUpdateDTO data);

	@RequestMapping(value="/qbn/{prefix}",method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getBizNo(@PathVariable(value = "prefix", required = true) String prefix);
	
	@RequestMapping(value="/date/{date}",method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getDate(@PathVariable(value = "date", required = false) String date);

	@RequestMapping(value="/deploy/{sourcePath}",method = RequestMethod.GET)
	public @ResponseBody ExecuteResultDTO deploy(@PathVariable(value = "sourcePath", required = true) String sourcePath);
}
