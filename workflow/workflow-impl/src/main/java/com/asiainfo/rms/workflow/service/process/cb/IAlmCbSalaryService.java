package com.asiainfo.rms.workflow.service.process.cb;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbSalaryBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbSalaryQueryPageBO;

/**
 * 
 * 
 * @author joker
 */
public interface IAlmCbSalaryService {

	public void deleteByPrimaryKey(Long sid) throws Exception;
	
	public AlmCbSalaryBO save(AlmCbSalaryBO almCbSalaryBO) throws Exception;
	
	public AlmCbSalaryBO findByPrimaryKey(Long sid) throws Exception;
	
	public AlmCbSalaryBO update(AlmCbSalaryBO almCbSalaryBO) throws Exception;
	
	public Page<AlmCbSalaryBO> findByConds(AlmCbSalaryQueryPageBO almCbSalaryQueryPageBO) throws Exception;
	
}