package com.asiainfo.rms.workflow.service.process.common;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysOrganizeBO;
import com.asiainfo.rms.workflow.bo.process.common.SysOrganizeQueryPageBO;

/**
 * 
 * 
 * @author joker
 */
public interface ISysOrganizeService {

	public void deleteByPrimaryKey(java.lang.Long organizeId) throws Exception;
	
	public SysOrganizeBO save(SysOrganizeBO sysOrganizeBO) throws Exception;
	
	public SysOrganizeBO findByPrimaryKey(java.lang.Long organizeId) throws Exception;
	
	public SysOrganizeBO update(SysOrganizeBO sysOrganizeBO) throws Exception;
	
	public Page<SysOrganizeBO> findByConds(SysOrganizeQueryPageBO sysOrganizeQueryPageBO) throws Exception;
	
}