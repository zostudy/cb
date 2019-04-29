package com.asiainfo.rms.workflow.service.process.cb;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbSawBoardBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbSawBoardQueryPageBO;

/**
 * 
 * 
 * @author joker
 */
public interface IAlmCbSawBoardService {

	public void deleteByPrimaryKey(Long sbId) throws Exception;
	
	public AlmCbSawBoardBO save(AlmCbSawBoardBO almCbSawBoardBO) throws Exception;
	
	public AlmCbSawBoardBO findByPrimaryKey(Long sbId) throws Exception;
	
	public AlmCbSawBoardBO update(AlmCbSawBoardBO almCbSawBoardBO) throws Exception;
	
	public Page<AlmCbSawBoardBO> findByConds(AlmCbSawBoardQueryPageBO almCbSawBoardQueryPageBO) throws Exception;
	
}