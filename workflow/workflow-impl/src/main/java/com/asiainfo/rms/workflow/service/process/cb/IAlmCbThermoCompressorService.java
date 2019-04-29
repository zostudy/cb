package com.asiainfo.rms.workflow.service.process.cb;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbThermoCompressorBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbThermoCompressorQueryPageBO;

/**
 * 
 * 
 * @author joker
 */
public interface IAlmCbThermoCompressorService {

	public void deleteByPrimaryKey(Long tcId) throws Exception;
	
	public AlmCbThermoCompressorBO save(AlmCbThermoCompressorBO almCbThermoCompressorBO) throws Exception;
	
	public AlmCbThermoCompressorBO findByPrimaryKey(Long tcId) throws Exception;
	
	public AlmCbThermoCompressorBO update(AlmCbThermoCompressorBO almCbThermoCompressorBO) throws Exception;
	
	public Page<AlmCbThermoCompressorBO> findByConds(AlmCbThermoCompressorQueryPageBO almCbThermoCompressorQueryPageBO) throws Exception;
	
}