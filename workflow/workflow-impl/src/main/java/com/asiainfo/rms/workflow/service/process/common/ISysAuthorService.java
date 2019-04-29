package com.asiainfo.rms.workflow.service.process.common;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysAuthorBO;
import com.asiainfo.rms.workflow.bo.process.common.SysAuthorQueryPageBO;

/**
 * 
 * 
 * @author joker
 */
public interface ISysAuthorService {

	public void deleteByPrimaryKey(java.lang.Long authorId) throws Exception;
	
	public SysAuthorBO save(SysAuthorBO sysAuthorBO) throws Exception;
	
	public SysAuthorBO findByPrimaryKey(java.lang.Long authorId) throws Exception;
	
	public SysAuthorBO update(SysAuthorBO sysAuthorBO) throws Exception;
	
	public Page<SysAuthorBO> findByConds(SysAuthorQueryPageBO sysAuthorQueryPageBO) throws Exception;
	
}