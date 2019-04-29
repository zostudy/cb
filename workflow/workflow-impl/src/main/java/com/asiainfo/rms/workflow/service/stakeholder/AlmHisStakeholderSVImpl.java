package com.asiainfo.rms.workflow.service.stakeholder;

import java.util.Date;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.asiainfo.rms.workflow.bo.workflow.StakeholderBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmHisStakeholder;
import com.asiainfo.rms.workflow.mapper.workflow.StakeholderMapper;

import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Service;

/**
 * 
 * @author 刘超
 * @version 1.4
 *
 */
@Log4j
@Service("hisStakeholderSV")
@Transactional(rollbackOn = Exception.class)
public class AlmHisStakeholderSVImpl implements IAlmHisStakeholderSV {
	
	@Resource(name="commonDao")
	private CommonDAO commonDAO;
	@Override
	public void copyHisStakeholderByStakeholder(StakeholderBO stakeholder)
			throws Exception {
		if(log.isDebugEnabled()){
			log.debug("正在保存历史处理人信息,处理人为"+stakeholder.getStdholderStaffName());
		}
		BOAlmHisStakeholder hisAlmStakeholder = StakeholderMapper.INSTANCE.boToHisDomain(stakeholder);
		hisAlmStakeholder.setCreateTime(new Date());
		commonDAO.save(hisAlmStakeholder);
	}

}
