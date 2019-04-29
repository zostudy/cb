package com.asiainfo.rms.workflow.service.driving;

/**
 * 
 * @author 刘超
 * @version 1.4
 *
 */
public interface IAlmProcessDrivingSV {

	/**
	 * 针对workorder查找关联带动关系进行带动回单
	 * @param workorder
	 * @throws Exception
	 */
	public void drivFun(Long objId, String objType, Long linkId, String cond) throws Exception;
}
