package com.asiainfo.rms.workflow.service.process.cb;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFlowHisBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFlowHisQueryPageBO;

/**
 * 详情表
 * 
 * @author joker
 */
public interface IAlmCbFlowHisService {

	public void deleteByPrimaryKey(Long hisFlowId) throws Exception;
	
	public AlmCbFlowHisBO save(AlmCbFlowHisBO almCbFlowHisBO) throws Exception;
	
	public AlmCbFlowHisBO findByPrimaryKey(Long hisFlowId) throws Exception;
	
	public AlmCbFlowHisBO update(AlmCbFlowHisBO almCbFlowHisBO) throws Exception;
	
	public Page<AlmCbFlowHisBO> findByConds(AlmCbFlowHisQueryPageBO almCbFlowHisQueryPageBO) throws Exception;
	
}