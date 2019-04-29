package com.asiainfo.rms.workflow.service.process.common;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysStationBO;
import com.asiainfo.rms.workflow.bo.process.common.SysStationQueryPageBO;

/**
 * 
 * 
 * @author joker
 */
public interface ISysStationService {

	public void deleteByPrimaryKey(java.lang.Long stationId) throws Exception;
	
	public SysStationBO save(SysStationBO sysStationBO) throws Exception;
	
	public SysStationBO findByPrimaryKey(java.lang.Long stationId) throws Exception;
	
	public SysStationBO update(SysStationBO sysStationBO) throws Exception;
	
	public Page<SysStationBO> findByConds(SysStationQueryPageBO sysStationQueryPageBO) throws Exception;
	
}