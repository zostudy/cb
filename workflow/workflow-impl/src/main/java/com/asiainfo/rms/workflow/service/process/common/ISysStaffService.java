package com.asiainfo.rms.workflow.service.process.common;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysStaffBO;
import com.asiainfo.rms.workflow.bo.process.common.SysStaffQueryPageBO;

/**
 * 
 * 
 * @author joker
 */
public interface ISysStaffService {

	public void deleteByPrimaryKey(java.lang.Long staffId) throws Exception;
	
	public SysStaffBO save(SysStaffBO sysStaffBO) throws Exception;
	
	public SysStaffBO findByPrimaryKey(java.lang.Long staffId) throws Exception;
	
	public SysStaffBO update(SysStaffBO sysStaffBO) throws Exception;
	
	public Page<SysStaffBO> findByConds(SysStaffQueryPageBO sysStaffQueryPageBO) throws Exception;
	
}