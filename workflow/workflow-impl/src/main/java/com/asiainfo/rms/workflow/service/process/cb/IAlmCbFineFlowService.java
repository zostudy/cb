package com.asiainfo.rms.workflow.service.process.cb;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFineFlowBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFineFlowQueryPageBO;

/**
 * 罚款流水
 * 
 * @author joker
 */
public interface IAlmCbFineFlowService {

	public void deleteByPrimaryKey(Long fineId) throws Exception;
	
	public AlmCbFineFlowBO save(AlmCbFineFlowBO almCbFineFlowBO) throws Exception;
	
	public AlmCbFineFlowBO findByPrimaryKey(Long fineId) throws Exception;
	
	public AlmCbFineFlowBO update(AlmCbFineFlowBO almCbFineFlowBO) throws Exception;
	
	public Page<AlmCbFineFlowBO> findByConds(AlmCbFineFlowQueryPageBO almCbFineFlowQueryPageBO) throws Exception;
	
}