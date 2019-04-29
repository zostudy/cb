package com.asiainfo.rms.workflow.service.process.common;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysStationPrivateBO;
import com.asiainfo.rms.workflow.bo.process.common.SysStationPrivateQueryPageBO;

/**
 * 
 * 
 * @author joker
 */
public interface ISysStationPrivateService {

	public void deleteByPrimaryKey(java.lang.Long staffId) throws Exception;
	
	public SysStationPrivateBO save(SysStationPrivateBO sysStationPrivateBO) throws Exception;
	
	public SysStationPrivateBO findByPrimaryKey(java.lang.Long staffId) throws Exception;
	
	public SysStationPrivateBO update(SysStationPrivateBO sysStationPrivateBO) throws Exception;
	
	public Page<SysStationPrivateBO> findByConds(SysStationPrivateQueryPageBO sysStationPrivateQueryPageBO) throws Exception;
	
}