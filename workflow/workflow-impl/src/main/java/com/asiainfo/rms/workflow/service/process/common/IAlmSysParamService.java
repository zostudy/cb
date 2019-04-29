package com.asiainfo.rms.workflow.service.process.common;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.AlmSysParamBO;
import com.asiainfo.rms.workflow.bo.process.common.AlmSysParamQueryPageBO;

/**
 * 
 * 
 * @author joker
 */
public interface IAlmSysParamService {

	public void deleteByPrimaryKey(java.lang.Long paramId) throws Exception;
	
	public AlmSysParamBO save(AlmSysParamBO almSysParamBO) throws Exception;
	
	public AlmSysParamBO findByPrimaryKey(java.lang.Long paramId) throws Exception;
	
	public AlmSysParamBO update(AlmSysParamBO almSysParamBO) throws Exception;
	
	public Page<AlmSysParamBO> findByConds(AlmSysParamQueryPageBO almSysParamQueryPageBO) throws Exception;
	
}