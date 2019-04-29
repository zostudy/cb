package com.asiainfo.rms.workflow.service.process.cb;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbRepairBoardBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbRepairBoardQueryPageBO;

/**
 * 
 * 
 * @author joker
 */
public interface IAlmCbRepairBoardService {

	public void deleteByPrimaryKey(Long rbId) throws Exception;
	
	public AlmCbRepairBoardBO save(AlmCbRepairBoardBO almCbRepairBoardBO) throws Exception;
	
	public AlmCbRepairBoardBO findByPrimaryKey(Long rbId) throws Exception;
	
	public AlmCbRepairBoardBO update(AlmCbRepairBoardBO almCbRepairBoardBO) throws Exception;
	
	public Page<AlmCbRepairBoardBO> findByConds(AlmCbRepairBoardQueryPageBO almCbRepairBoardQueryPageBO) throws Exception;
	
}