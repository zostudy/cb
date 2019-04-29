package com.asiainfo.rms.workflow.service.process.cb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbThermoCompressorBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbThermoCompressorQueryPageBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.cb.BOAlmCbThermoCompressor;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbThermoCompressorMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbThermoCompressorService;

/**
 * 
 * 
 * @author joker
 */
@Service("almCbThermoCompressorService")
@Transactional(rollbackOn = Exception.class)
public class AlmCbThermoCompressorServiceImpl implements IAlmCbThermoCompressorService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void deleteByPrimaryKey(Long tcId) throws Exception {
		commonDAO.delete(tcId, BOAlmCbThermoCompressor.class);
	}
	
	@Override
	public AlmCbThermoCompressorBO save(AlmCbThermoCompressorBO almCbThermoCompressorBO) throws Exception {
		BOAlmCbThermoCompressor boAlmCbThermoCompressor = AlmCbThermoCompressorMapper.INSTANCE.boToDomain(almCbThermoCompressorBO);
		boAlmCbThermoCompressor = commonDAO.saveOrUpdate(boAlmCbThermoCompressor, BOAlmCbThermoCompressor.class);
		return AlmCbThermoCompressorMapper.INSTANCE.domainToBo(boAlmCbThermoCompressor);
	}
	
	@Override
	public AlmCbThermoCompressorBO findByPrimaryKey(Long tcId) throws Exception {
		BOAlmCbThermoCompressor boAlmCbThermoCompressor = commonDAO.findById(BOAlmCbThermoCompressor.class, tcId);
		return AlmCbThermoCompressorMapper.INSTANCE.domainToBo(boAlmCbThermoCompressor);
	}
	
	@Override
	public AlmCbThermoCompressorBO update(AlmCbThermoCompressorBO almCbThermoCompressorBO) throws Exception {
		BOAlmCbThermoCompressor boAlmCbThermoCompressor = AlmCbThermoCompressorMapper.INSTANCE.boToDomain(almCbThermoCompressorBO);
		boAlmCbThermoCompressor = commonDAO.saveOrUpdate(boAlmCbThermoCompressor, BOAlmCbThermoCompressor.class);
		return AlmCbThermoCompressorMapper.INSTANCE.domainToBo(boAlmCbThermoCompressor);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Page<AlmCbThermoCompressorBO> findByConds(AlmCbThermoCompressorQueryPageBO almCbThermoCompressorQueryPageBO) throws Exception {
		StringBuffer hql = new StringBuffer("SELECT o FROM BOAlmCbThermoCompressor o WHERE 1 = 1");
		StringBuffer hqlCount = new StringBuffer("SELECT COUNT(o) FROM BOAlmCbThermoCompressor o WHERE 1 = 1");
		StringBuffer hqlCondition = new StringBuffer();
		Map<String, Object> param = new HashMap<String, Object>();
	    if (almCbThermoCompressorQueryPageBO.getTcIdBegin() != null) {
			hqlCondition.append(" AND o.tcId >= :tcIdBegin");
			param.put("tcIdBegin", almCbThermoCompressorQueryPageBO.getTcIdBegin());
		}
	    if (almCbThermoCompressorQueryPageBO.getTcIdEnd() != null) {
			hqlCondition.append(" AND o.tcId <= :tcIdEnd");
			param.put("tcIdEnd", almCbThermoCompressorQueryPageBO.getTcIdEnd());
		}
	    if (!StringUtils.isBlank(almCbThermoCompressorQueryPageBO.getTcTag())) {
			hqlCondition.append(" AND o.tcTag LIKE :tcTag");
			param.put("tcTag", "%"+almCbThermoCompressorQueryPageBO.getTcTag()+"%");
		}
	    if (almCbThermoCompressorQueryPageBO.getApplyStaffIdBegin() != null) {
			hqlCondition.append(" AND o.applyStaffId >= :applyStaffIdBegin");
			param.put("applyStaffIdBegin", almCbThermoCompressorQueryPageBO.getApplyStaffIdBegin());
		}
	    if (almCbThermoCompressorQueryPageBO.getApplyStaffIdEnd() != null) {
			hqlCondition.append(" AND o.applyStaffId <= :applyStaffIdEnd");
			param.put("applyStaffIdEnd", almCbThermoCompressorQueryPageBO.getApplyStaffIdEnd());
		}
	    if (almCbThermoCompressorQueryPageBO.getCurStatusBegin() != null) {
			hqlCondition.append(" AND o.curStatus >= :curStatusBegin");
			param.put("curStatusBegin", almCbThermoCompressorQueryPageBO.getCurStatusBegin());
		}
	    if (almCbThermoCompressorQueryPageBO.getCurStatusEnd() != null) {
			hqlCondition.append(" AND o.curStatus <= :curStatusEnd");
			param.put("curStatusEnd", almCbThermoCompressorQueryPageBO.getCurStatusEnd());
		}
	    if (almCbThermoCompressorQueryPageBO.getCurPhaseBegin() != null) {
			hqlCondition.append(" AND o.curPhase >= :curPhaseBegin");
			param.put("curPhaseBegin", almCbThermoCompressorQueryPageBO.getCurPhaseBegin());
		}
	    if (almCbThermoCompressorQueryPageBO.getCurPhaseEnd() != null) {
			hqlCondition.append(" AND o.curPhase <= :curPhaseEnd");
			param.put("curPhaseEnd", almCbThermoCompressorQueryPageBO.getCurPhaseEnd());
		}
		hql.append(hqlCondition);
		hqlCount.append(hqlCondition);
		hql.append(" ORDER BY o.tcId DESC");
		List<BOAlmCbThermoCompressor> boAlmCbThermoCompressors = null;
		Page<AlmCbThermoCompressorBO> page = new Page<AlmCbThermoCompressorBO>();
		if ((almCbThermoCompressorQueryPageBO.getPageNo() != null && almCbThermoCompressorQueryPageBO.getPageNo().compareTo(0) > 0) && (almCbThermoCompressorQueryPageBO.getPageSize() != null && almCbThermoCompressorQueryPageBO.getPageSize().compareTo(0) > 0)) {
			Long count = (Long) commonDAO.findSingleResultByJPAQL(hqlCount.toString(), param);
			if (count == null || count.compareTo(0L) <= 0) {
				return page;
			}
			page.setRowCount(count.intValue());
			boAlmCbThermoCompressors = commonDAO.findByJPAQL(hql.toString(), param, almCbThermoCompressorQueryPageBO.getPageNo(), almCbThermoCompressorQueryPageBO.getPageSize());
			page.generatePageCount(almCbThermoCompressorQueryPageBO.getPageSize());
		} else {
			boAlmCbThermoCompressors = commonDAO.findByJPAQL(hql.toString(), param);
		}
		page.setPageData(AlmCbThermoCompressorMapper.INSTANCE.domainToBo(boAlmCbThermoCompressors));
		return page;
	}
	
}