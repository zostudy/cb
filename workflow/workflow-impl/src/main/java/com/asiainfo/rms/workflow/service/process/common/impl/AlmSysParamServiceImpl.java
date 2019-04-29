package com.asiainfo.rms.workflow.service.process.common.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.AlmSysParamBO;
import com.asiainfo.rms.workflow.bo.process.common.AlmSysParamQueryPageBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.common.BOAlmSysParam;
import com.asiainfo.rms.workflow.mapper.process.common.AlmSysParamMapper;
import com.asiainfo.rms.workflow.service.process.common.IAlmSysParamService;

/**
 * 
 * 
 * @author joker
 */
@Service("almSysParamService")
@Transactional(rollbackOn = Exception.class)
public class AlmSysParamServiceImpl implements IAlmSysParamService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void deleteByPrimaryKey(java.lang.Long paramId) throws Exception {
		commonDAO.delete(paramId, BOAlmSysParam.class);
	}
	
	@Override
	public AlmSysParamBO save(AlmSysParamBO almSysParamBO) throws Exception {
		BOAlmSysParam boAlmSysParam = AlmSysParamMapper.INSTANCE.boToDomain(almSysParamBO);
		boAlmSysParam = commonDAO.saveOrUpdate(boAlmSysParam, BOAlmSysParam.class);
		return AlmSysParamMapper.INSTANCE.domainToBo(boAlmSysParam);
	}
	
	@Override
	public AlmSysParamBO findByPrimaryKey(java.lang.Long paramId) throws Exception {
		BOAlmSysParam boAlmSysParam = commonDAO.findById(BOAlmSysParam.class, paramId);
		return AlmSysParamMapper.INSTANCE.domainToBo(boAlmSysParam);
	}
	
	@Override
	public AlmSysParamBO update(AlmSysParamBO almSysParamBO) throws Exception {
		BOAlmSysParam boAlmSysParam = AlmSysParamMapper.INSTANCE.boToDomain(almSysParamBO);
		boAlmSysParam = commonDAO.saveOrUpdate(boAlmSysParam, BOAlmSysParam.class);
		return AlmSysParamMapper.INSTANCE.domainToBo(boAlmSysParam);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Page<AlmSysParamBO> findByConds(AlmSysParamQueryPageBO almSysParamQueryPageBO) throws Exception {
		StringBuffer hql = new StringBuffer("SELECT o FROM BOAlmSysParam o WHERE 1 = 1");
		StringBuffer hqlCount = new StringBuffer("SELECT COUNT(o) FROM BOAlmSysParam o WHERE 1 = 1");
		StringBuffer hqlCondition = new StringBuffer();
		Map<String, Object> param = new HashMap<String, Object>();
	    if (!StringUtils.isBlank(almSysParamQueryPageBO.getParamType())) {
			hqlCondition.append(" AND o.paramType = :paramType");
			param.put("paramType", almSysParamQueryPageBO.getParamType());
		}
	    if (almSysParamQueryPageBO.getParamIdBegin() != null) {
			hqlCondition.append(" AND o.paramId >= :paramIdBegin");
			param.put("paramIdBegin", almSysParamQueryPageBO.getParamIdBegin());
		}
	    if (almSysParamQueryPageBO.getParamIdEnd() != null) {
			hqlCondition.append(" AND o.paramId <= :paramIdEnd");
			param.put("paramIdEnd", almSysParamQueryPageBO.getParamIdEnd());
		}
	    if (!StringUtils.isBlank(almSysParamQueryPageBO.getParamNo())) {
			hqlCondition.append(" AND o.paramNo LIKE :paramNo");
			param.put("paramNo", "%"+almSysParamQueryPageBO.getParamNo()+"%");
		}
	    if (!StringUtils.isBlank(almSysParamQueryPageBO.getParamName())) {
			hqlCondition.append(" AND o.paramName LIKE :paramName");
			param.put("paramName", "%"+almSysParamQueryPageBO.getParamName()+"%");
		}
	    if (!StringUtils.isBlank(almSysParamQueryPageBO.getParamDisc())) {
			hqlCondition.append(" AND o.paramDisc LIKE :paramDisc");
			param.put("paramDisc", "%"+almSysParamQueryPageBO.getParamDisc()+"%");
		}
	    if (almSysParamQueryPageBO.getParamRelaIdBegin() != null) {
			hqlCondition.append(" AND o.paramRelaId >= :paramRelaIdBegin");
			param.put("paramRelaIdBegin", almSysParamQueryPageBO.getParamRelaIdBegin());
		}
	    if (almSysParamQueryPageBO.getParamRelaIdEnd() != null) {
			hqlCondition.append(" AND o.paramRelaId <= :paramRelaIdEnd");
			param.put("paramRelaIdEnd", almSysParamQueryPageBO.getParamRelaIdEnd());
		}
	    if (almSysParamQueryPageBO.getParamValueBegin() != null) {
			hqlCondition.append(" AND o.paramValue >= :paramValueBegin");
			param.put("paramValueBegin", almSysParamQueryPageBO.getParamValueBegin());
		}
	    if (almSysParamQueryPageBO.getParamValueEnd() != null) {
			hqlCondition.append(" AND o.paramValue <= :paramValueEnd");
			param.put("paramValueEnd", almSysParamQueryPageBO.getParamValueEnd());
		}
	    if (almSysParamQueryPageBO.getSortIdBegin() != null) {
			hqlCondition.append(" AND o.sortId >= :sortIdBegin");
			param.put("sortIdBegin", almSysParamQueryPageBO.getSortIdBegin());
		}
	    if (almSysParamQueryPageBO.getSortIdEnd() != null) {
			hqlCondition.append(" AND o.sortId <= :sortIdEnd");
			param.put("sortIdEnd", almSysParamQueryPageBO.getSortIdEnd());
		}
		hql.append(hqlCondition);
		hqlCount.append(hqlCondition);
		hql.append(" ORDER BY o.sortId DESC");
		List<BOAlmSysParam> boAlmSysParams = null;
		Page<AlmSysParamBO> page = new Page<AlmSysParamBO>();
		if ((almSysParamQueryPageBO.getPageNo() != null && almSysParamQueryPageBO.getPageNo().compareTo(0) > 0) && (almSysParamQueryPageBO.getPageSize() != null && almSysParamQueryPageBO.getPageSize().compareTo(0) > 0)) {
			Long count = (Long) commonDAO.findSingleResultByJPAQL(hqlCount.toString(), param);
			if (count == null || count.compareTo(0L) <= 0) {
				return page;
			}
			page.setRowCount(count.intValue());
			boAlmSysParams = commonDAO.findByJPAQL(hql.toString(), param, almSysParamQueryPageBO.getPageNo(), almSysParamQueryPageBO.getPageSize());
			page.generatePageCount(almSysParamQueryPageBO.getPageSize());
		} else {
			boAlmSysParams = commonDAO.findByJPAQL(hql.toString(), param);
		}
		page.setPageData(AlmSysParamMapper.INSTANCE.domainToBo(boAlmSysParams));
		return page;
	}
	
}