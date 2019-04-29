package com.asiainfo.rms.workflow.service.stakeholder;

import com.asiainfo.rms.workflow.bo.workflow.StakeholderBO;

/**
 * 
 * @author 刘超
 *
 */
public interface IAlmHisStakeholderSV {

	/**
	 * 保存环节处理人到历史表中
	 * @param stakeholder 环节处理人
	 * @throws Exception
	 */
	public void copyHisStakeholderByStakeholder(StakeholderBO stakeholder) throws Exception;
}
