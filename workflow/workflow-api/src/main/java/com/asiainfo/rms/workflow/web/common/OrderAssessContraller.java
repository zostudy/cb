package com.asiainfo.rms.workflow.web.common;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.asiainfo.rms.workflow.dto.common.ExecuteResultDTO;
import com.asiainfo.rms.workflow.dto.process.common.AssessDTO;
@RequestMapping("/orderAssess")
public interface OrderAssessContraller {
	@RequestMapping(value="/saveAssess",method=RequestMethod.POST)
	public ExecuteResultDTO saveAssess(@RequestBody AssessDTO assessValue)throws Exception;
	
	@RequestMapping(value="/updateAssess",method=RequestMethod.PUT)
	public ExecuteResultDTO updateAssess(@RequestBody AssessDTO assessValue)throws Exception;
	
	@RequestMapping(value="/delAssess",method=RequestMethod.DELETE)
	public ExecuteResultDTO delAssess(@RequestParam(value="assess_id") Integer assessId)throws Exception;
	
	@RequestMapping(value="/queryAssess",method=RequestMethod.GET)
	public ExecuteResultDTO queryAssess(@RequestParam(value="assess_id",required=false) Integer assessId,
			@RequestParam(value="order_id",required=false) Integer orderId,
			@RequestParam(value="req_id",required=false) Integer reqId)throws Exception;
}
