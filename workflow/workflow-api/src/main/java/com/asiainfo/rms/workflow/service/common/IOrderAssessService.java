package com.asiainfo.rms.workflow.service.common;

import java.util.List;

import com.asiainfo.rms.workflow.bo.process.common.AssessBO;

public interface IOrderAssessService {
	
	public long saveAssess( AssessBO assessValue)throws Exception;
	
	public void updateAssess( AssessBO assessValue)throws Exception;
	
	public void delAssess(Integer versId)throws Exception;
	
	public List<AssessBO> queryAssess(int versId,int orderId,int reqId)throws Exception;
}
