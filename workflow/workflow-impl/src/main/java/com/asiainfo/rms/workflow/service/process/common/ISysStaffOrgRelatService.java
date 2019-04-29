package com.asiainfo.rms.workflow.service.process.common;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysStaffOrgRelatBO;
import com.asiainfo.rms.workflow.bo.process.common.SysStaffOrgRelatQueryPageBO;

/**
 * 
 * 
 * @author joker
 */
public interface ISysStaffOrgRelatService {

	public void deleteByPrimaryKey(java.lang.Long staffOrgRelatId) throws Exception;
	
	public SysStaffOrgRelatBO save(SysStaffOrgRelatBO sysStaffOrgRelatBO) throws Exception;
	
	public SysStaffOrgRelatBO findByPrimaryKey(java.lang.Long staffOrgRelatId) throws Exception;
	
	public SysStaffOrgRelatBO update(SysStaffOrgRelatBO sysStaffOrgRelatBO) throws Exception;
	
	public Page<SysStaffOrgRelatBO> findByConds(SysStaffOrgRelatQueryPageBO sysStaffOrgRelatQueryPageBO) throws Exception;
	
}