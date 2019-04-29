package com.asiainfo.rms.workflow.service.process.cb;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFlowBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFlowQueryPageBO;

/**
 * 流水表
 * 
 * @author joker
 */
public interface IAlmCbFlowService {

	public void deleteByPrimaryKey(Long flowId) throws Exception;
	
	public AlmCbFlowBO save(AlmCbFlowBO almCbFlowBO) throws Exception;
	
	public AlmCbFlowBO findByPrimaryKey(Long flowId) throws Exception;
	
	public AlmCbFlowBO update(AlmCbFlowBO almCbFlowBO) throws Exception;
	
	public Page<AlmCbFlowBO> findByConds(AlmCbFlowQueryPageBO almCbFlowQueryPageBO) throws Exception;
	
}