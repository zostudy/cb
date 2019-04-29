package com.asiainfo.rms.workflow.service.process.cb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbSalaryBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbSalaryQueryPageBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.cb.BOAlmCbSalary;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbSalaryMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbSalaryService;

/**
 * 
 * 
 * @author joker
 */
@Service("almCbSalaryService")
@Transactional(rollbackOn = Exception.class)
public class AlmCbSalaryServiceImpl implements IAlmCbSalaryService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void deleteByPrimaryKey(Long sid) throws Exception {
		commonDAO.delete(sid, BOAlmCbSalary.class);
	}
	
	@Override
	public AlmCbSalaryBO save(AlmCbSalaryBO almCbSalaryBO) throws Exception {
		BOAlmCbSalary boAlmCbSalary = AlmCbSalaryMapper.INSTANCE.boToDomain(almCbSalaryBO);
		boAlmCbSalary = commonDAO.saveOrUpdate(boAlmCbSalary, BOAlmCbSalary.class);
		return AlmCbSalaryMapper.INSTANCE.domainToBo(boAlmCbSalary);
	}
	
	@Override
	public AlmCbSalaryBO findByPrimaryKey(Long sid) throws Exception {
		BOAlmCbSalary boAlmCbSalary = commonDAO.findById(BOAlmCbSalary.class, sid);
		return AlmCbSalaryMapper.INSTANCE.domainToBo(boAlmCbSalary);
	}
	
	@Override
	public AlmCbSalaryBO update(AlmCbSalaryBO almCbSalaryBO) throws Exception {
		BOAlmCbSalary boAlmCbSalary = AlmCbSalaryMapper.INSTANCE.boToDomain(almCbSalaryBO);
		boAlmCbSalary = commonDAO.saveOrUpdate(boAlmCbSalary, BOAlmCbSalary.class);
		return AlmCbSalaryMapper.INSTANCE.domainToBo(boAlmCbSalary);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Page<AlmCbSalaryBO> findByConds(AlmCbSalaryQueryPageBO almCbSalaryQueryPageBO) throws Exception {
		StringBuffer hql = new StringBuffer("SELECT o FROM BOAlmCbSalary o WHERE 1 = 1");
		StringBuffer hqlCount = new StringBuffer("SELECT COUNT(o) FROM BOAlmCbSalary o WHERE 1 = 1");
		StringBuffer hqlCondition = new StringBuffer();
		Map<String, Object> param = new HashMap<String, Object>();
	    if (almCbSalaryQueryPageBO.getSidBegin() != null) {
			hqlCondition.append(" AND o.sid >= :sidBegin");
			param.put("sidBegin", almCbSalaryQueryPageBO.getSidBegin());
		}
	    if (almCbSalaryQueryPageBO.getSidEnd() != null) {
			hqlCondition.append(" AND o.sid <= :sidEnd");
			param.put("sidEnd", almCbSalaryQueryPageBO.getSidEnd());
		}
	    if (!StringUtils.isBlank(almCbSalaryQueryPageBO.getStag())) {
			hqlCondition.append(" AND o.stag LIKE :stag");
			param.put("stag", "%"+almCbSalaryQueryPageBO.getStag()+"%");
		}
	    if (almCbSalaryQueryPageBO.getApplyStaffIdBegin() != null) {
			hqlCondition.append(" AND o.applyStaffId >= :applyStaffIdBegin");
			param.put("applyStaffIdBegin", almCbSalaryQueryPageBO.getApplyStaffIdBegin());
		}
	    if (almCbSalaryQueryPageBO.getApplyStaffIdEnd() != null) {
			hqlCondition.append(" AND o.applyStaffId <= :applyStaffIdEnd");
			param.put("applyStaffIdEnd", almCbSalaryQueryPageBO.getApplyStaffIdEnd());
		}
	    if (almCbSalaryQueryPageBO.getCurStatusBegin() != null) {
			hqlCondition.append(" AND o.curStatus >= :curStatusBegin");
			param.put("curStatusBegin", almCbSalaryQueryPageBO.getCurStatusBegin());
		}
	    if (almCbSalaryQueryPageBO.getCurStatusEnd() != null) {
			hqlCondition.append(" AND o.curStatus <= :curStatusEnd");
			param.put("curStatusEnd", almCbSalaryQueryPageBO.getCurStatusEnd());
		}
	    if (almCbSalaryQueryPageBO.getCurPhaseBegin() != null) {
			hqlCondition.append(" AND o.curPhase >= :curPhaseBegin");
			param.put("curPhaseBegin", almCbSalaryQueryPageBO.getCurPhaseBegin());
		}
	    if (almCbSalaryQueryPageBO.getCurPhaseEnd() != null) {
			hqlCondition.append(" AND o.curPhase <= :curPhaseEnd");
			param.put("curPhaseEnd", almCbSalaryQueryPageBO.getCurPhaseEnd());
		}
		hql.append(hqlCondition);
		hqlCount.append(hqlCondition);
		hql.append(" ORDER BY o.sid DESC");
		List<BOAlmCbSalary> boAlmCbSalarys = null;
		Page<AlmCbSalaryBO> page = new Page<AlmCbSalaryBO>();
		if ((almCbSalaryQueryPageBO.getPageNo() != null && almCbSalaryQueryPageBO.getPageNo().compareTo(0) > 0) && (almCbSalaryQueryPageBO.getPageSize() != null && almCbSalaryQueryPageBO.getPageSize().compareTo(0) > 0)) {
			Long count = (Long) commonDAO.findSingleResultByJPAQL(hqlCount.toString(), param);
			if (count == null || count.compareTo(0L) <= 0) {
				return page;
			}
			page.setRowCount(count.intValue());
			boAlmCbSalarys = commonDAO.findByJPAQL(hql.toString(), param, almCbSalaryQueryPageBO.getPageNo(), almCbSalaryQueryPageBO.getPageSize());
			page.generatePageCount(almCbSalaryQueryPageBO.getPageSize());
		} else {
			boAlmCbSalarys = commonDAO.findByJPAQL(hql.toString(), param);
		}
		page.setPageData(AlmCbSalaryMapper.INSTANCE.domainToBo(boAlmCbSalarys));
		return page;
	}
	
}