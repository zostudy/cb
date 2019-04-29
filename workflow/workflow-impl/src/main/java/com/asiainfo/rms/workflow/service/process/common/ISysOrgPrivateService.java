package com.asiainfo.rms.workflow.service.process.common;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysOrgPrivateBO;
import com.asiainfo.rms.workflow.bo.process.common.SysOrgPrivateQueryPageBO;

/**
 * 
 * 
 * @author joker
 */
public interface ISysOrgPrivateService {

	public void deleteByPrimaryKey(java.lang.Long staffId) throws Exception;
	
	public SysOrgPrivateBO save(SysOrgPrivateBO sysOrgPrivateBO) throws Exception;
	
	public SysOrgPrivateBO findByPrimaryKey(java.lang.Long staffId) throws Exception;
	
	public SysOrgPrivateBO update(SysOrgPrivateBO sysOrgPrivateBO) throws Exception;
	
	public Page<SysOrgPrivateBO> findByConds(SysOrgPrivateQueryPageBO sysOrgPrivateQueryPageBO) throws Exception;
	
}