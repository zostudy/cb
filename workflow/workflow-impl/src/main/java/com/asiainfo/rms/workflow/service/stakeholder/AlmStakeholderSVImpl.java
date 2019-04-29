package com.asiainfo.rms.workflow.service.stakeholder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.asiainfo.rms.workflow.bo.workflow.StakeholderBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmStakeholder;
import com.asiainfo.rms.workflow.mapper.workflow.StakeholderMapper;

import org.springframework.stereotype.Service;

@Service("almStakeholderSV")
@Transactional(rollbackOn = Exception.class)
public class AlmStakeholderSVImpl implements IAlmStakeholderSV {

	@Resource(name="commonDao")
	private CommonDAO commonDAO;
	
	@Override
	@SuppressWarnings("rawtypes")
	public List<StakeholderBO> getStakeholder(long objId, String objType,
												 List linkIds)throws Exception {
		String sql = "select o from BOAlmStakeholder o where o.objId=:objId and o.objType=:objType and o.linkId in (:linkIds)";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("objId", objId);
		param.put("objType", objType);
		param.put("linkIds", linkIds);
		@SuppressWarnings("unchecked")
		List<BOAlmStakeholder> almStakeholders = commonDAO.findByJPAQL(sql, param);
		List<StakeholderBO> stakeholderBOs = new LinkedList<StakeholderBO>();
		for (int i = 0; almStakeholders != null && almStakeholders.size() >= 1  &&i<almStakeholders.size(); i++) {
			stakeholderBOs.add(StakeholderMapper.INSTANCE.domainToBo(almStakeholders.get(i)));
		}
		return stakeholderBOs;
	}

	@Override
	public List<StakeholderBO> queryStakeholder(long objId, String objType, String linkNo) throws Exception {
		String sql = "select o from BOAlmStakeholder o where o.objId=:objId and o.objType=:objType and o.linkNo=:linkNo";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("objId", objId);
		param.put("objType", objType);
		param.put("linkNo", linkNo);
		@SuppressWarnings("unchecked")
		List<BOAlmStakeholder> almStakeholders = commonDAO.findByJPAQL(sql, param);
		List<StakeholderBO> stakeholderBOs = new LinkedList<StakeholderBO>();
		for (int i = 0; almStakeholders != null && almStakeholders.size() >= 1 &&i<almStakeholders.size(); i++) {
			stakeholderBOs.add(StakeholderMapper.INSTANCE.domainToBo(almStakeholders.get(i)));
		}
		return stakeholderBOs;
	}

	@Override
	public void saveStakeholder(StakeholderBO holderBO) throws Exception {
		BOAlmStakeholder holder = StakeholderMapper.INSTANCE.boToDomain(holderBO);
		commonDAO.saveOrUpdate(holder, BOAlmStakeholder.class);
	}

}
