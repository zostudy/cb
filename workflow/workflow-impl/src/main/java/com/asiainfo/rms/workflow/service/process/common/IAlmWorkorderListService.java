package com.asiainfo.rms.workflow.service.process.common;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.AlmWorkorderListBO;
import com.asiainfo.rms.workflow.bo.process.common.AlmWorkorderListQueryPageBO;

/**
 * 
 * 
 * @author joker
 */
public interface IAlmWorkorderListService {

	public void deleteByPrimaryKey(java.lang.Long orderId) throws Exception;
	
	public AlmWorkorderListBO save(AlmWorkorderListBO almWorkorderListBO) throws Exception;
	
	public AlmWorkorderListBO findByPrimaryKey(java.lang.Long orderId) throws Exception;
	
	public AlmWorkorderListBO update(AlmWorkorderListBO almWorkorderListBO) throws Exception;
	
	public Page<AlmWorkorderListBO> findByConds(AlmWorkorderListQueryPageBO almWorkorderListQueryPageBO) throws Exception;
	
}