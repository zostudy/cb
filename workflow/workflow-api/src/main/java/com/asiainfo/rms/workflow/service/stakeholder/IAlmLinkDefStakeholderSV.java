package com.asiainfo.rms.workflow.service.stakeholder;

public interface IAlmLinkDefStakeholderSV {

	void saveDefStakeholders(String processKey, Long sysTag, Long objId)  throws Exception;
	
	void saveReqResponsibleStakeholders(String processKey, Long objId, Long staffId, String staffName, String staffCode) throws Exception;

	void saveReqSubmitStakeholders(String processKey, Long objId, Long staffId, String staffName, String staffCode) throws Exception;
	
	void updateReqResponsibleStakeholders(String processKey, Long objId, Long staffId, String staffName, String staffCode) throws Exception;
}
