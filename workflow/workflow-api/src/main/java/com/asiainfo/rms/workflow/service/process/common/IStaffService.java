package com.asiainfo.rms.workflow.service.process.common;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.StaffBO;
import com.asiainfo.rms.workflow.bo.process.common.StaffQueryPageBO;

/**
 * 
 * 
 * @author joker
 */
public interface IStaffService {

	public void deleteByPrimaryKey(Long authorId) throws Exception;
	
	public StaffBO save(StaffBO staffBO) throws Exception;
	
	public StaffBO findByPrimaryKey(Long authorId) throws Exception;
	
	public StaffBO update(StaffBO staffBO) throws Exception;
	
	public Page<StaffBO> findByConds(StaffQueryPageBO staffQueryPageBO) throws Exception;
	
}