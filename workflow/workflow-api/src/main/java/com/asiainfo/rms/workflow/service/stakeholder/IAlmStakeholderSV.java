package com.asiainfo.rms.workflow.service.stakeholder;

import java.util.List;

import com.asiainfo.rms.workflow.bo.workflow.StakeholderBO;

public interface IAlmStakeholderSV {

	public List<StakeholderBO> getStakeholder(long objId, String objType, List<?> linkIds) throws Exception;
	
	public List<StakeholderBO> queryStakeholder(long objId, String objType, String linkNo)throws Exception;
	
	public void saveStakeholder(StakeholderBO holder) throws Exception;
}
