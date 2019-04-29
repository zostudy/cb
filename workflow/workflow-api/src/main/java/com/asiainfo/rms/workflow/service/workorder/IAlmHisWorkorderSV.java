package com.asiainfo.rms.workflow.service.workorder;

import com.asiainfo.rms.workflow.bo.workflow.WorkorderBO;

/**
 * 
 * @author 刘超 
 *
 */
public interface IAlmHisWorkorderSV {

	/**
	 * 拷贝工单到历史表中
	 * @param workorder 工单对象
	 * @throws Exception
	 */
	public void capyHisWorkorderByWorkorder(WorkorderBO workorder) throws Exception;
}
