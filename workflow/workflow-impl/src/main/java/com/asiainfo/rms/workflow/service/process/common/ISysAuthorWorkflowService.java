package com.asiainfo.rms.workflow.service.process.common;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysAuthorWorkflowBO;
import com.asiainfo.rms.workflow.bo.process.common.SysAuthorWorkflowQueryPageBO;

/**
 * 岗位与工作流关联表
 * 
 * @author joker
 */
public interface ISysAuthorWorkflowService {

	public void deleteByPrimaryKey(Long sawId) throws Exception;
	
	public SysAuthorWorkflowBO save(SysAuthorWorkflowBO sysAuthorWorkflowBO) throws Exception;
	
	public SysAuthorWorkflowBO findByPrimaryKey(Long sawId) throws Exception;
	
	public SysAuthorWorkflowBO update(SysAuthorWorkflowBO sysAuthorWorkflowBO) throws Exception;
	
	public Page<SysAuthorWorkflowBO> findByConds(SysAuthorWorkflowQueryPageBO sysAuthorWorkflowQueryPageBO) throws Exception;
	
}