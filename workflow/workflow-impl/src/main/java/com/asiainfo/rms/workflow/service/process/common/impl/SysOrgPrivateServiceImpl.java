package com.asiainfo.rms.workflow.service.process.common.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysOrgPrivateBO;
import com.asiainfo.rms.workflow.bo.process.common.SysOrgPrivateQueryPageBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.common.BOSysOrgPrivate;
import com.asiainfo.rms.workflow.mapper.process.common.SysOrgPrivateMapper;
import com.asiainfo.rms.workflow.service.process.common.ISysOrgPrivateService;

/**
 * 
 * 
 * @author joker
 */
@Service("sysOrgPrivateService")
@Transactional(rollbackOn = Exception.class)
public class SysOrgPrivateServiceImpl implements ISysOrgPrivateService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void deleteByPrimaryKey(java.lang.Long staffId) throws Exception {
		commonDAO.delete(staffId, BOSysOrgPrivate.class);
	}
	
	@Override
	public SysOrgPrivateBO save(SysOrgPrivateBO sysOrgPrivateBO) throws Exception {
		BOSysOrgPrivate boSysOrgPrivate = SysOrgPrivateMapper.INSTANCE.boToDomain(sysOrgPrivateBO);
		boSysOrgPrivate = commonDAO.saveOrUpdate(boSysOrgPrivate, BOSysOrgPrivate.class);
		return SysOrgPrivateMapper.INSTANCE.domainToBo(boSysOrgPrivate);
	}
	
	@Override
	public SysOrgPrivateBO findByPrimaryKey(java.lang.Long staffId) throws Exception {
		BOSysOrgPrivate boSysOrgPrivate = commonDAO.findById(BOSysOrgPrivate.class, staffId);
		return SysOrgPrivateMapper.INSTANCE.domainToBo(boSysOrgPrivate);
	}
	
	@Override
	public SysOrgPrivateBO update(SysOrgPrivateBO sysOrgPrivateBO) throws Exception {
		BOSysOrgPrivate boSysOrgPrivate = SysOrgPrivateMapper.INSTANCE.boToDomain(sysOrgPrivateBO);
		boSysOrgPrivate = commonDAO.saveOrUpdate(boSysOrgPrivate, BOSysOrgPrivate.class);
		return SysOrgPrivateMapper.INSTANCE.domainToBo(boSysOrgPrivate);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Page<SysOrgPrivateBO> findByConds(SysOrgPrivateQueryPageBO sysOrgPrivateQueryPageBO) throws Exception {
		StringBuffer hql = new StringBuffer("SELECT o FROM BOSysOrgPrivate o WHERE 1 = 1");
		StringBuffer hqlCount = new StringBuffer("SELECT COUNT(o) FROM BOSysOrgPrivate o WHERE 1 = 1");
		StringBuffer hqlCondition = new StringBuffer();
		Map<String, Object> param = new HashMap<String, Object>();
	    if (sysOrgPrivateQueryPageBO.getStaffIdBegin() != null) {
			hqlCondition.append(" AND o.staffId >= :staffIdBegin");
			param.put("staffIdBegin", sysOrgPrivateQueryPageBO.getStaffIdBegin());
		}
	    if (sysOrgPrivateQueryPageBO.getStaffIdEnd() != null) {
			hqlCondition.append(" AND o.staffId <= :staffIdEnd");
			param.put("staffIdEnd", sysOrgPrivateQueryPageBO.getStaffIdEnd());
		}
	    if (!StringUtils.isBlank(sysOrgPrivateQueryPageBO.getCode())) {
			hqlCondition.append(" AND o.code LIKE :code");
			param.put("code", "%"+sysOrgPrivateQueryPageBO.getCode()+"%");
		}
	    if (!StringUtils.isBlank(sysOrgPrivateQueryPageBO.getEmployeeName())) {
			hqlCondition.append(" AND o.employeeName LIKE :employeeName");
			param.put("employeeName", "%"+sysOrgPrivateQueryPageBO.getEmployeeName()+"%");
		}
	    if (!StringUtils.isBlank(sysOrgPrivateQueryPageBO.getBillId())) {
			hqlCondition.append(" AND o.billId LIKE :billId");
			param.put("billId", "%"+sysOrgPrivateQueryPageBO.getBillId()+"%");
		}
	    if (sysOrgPrivateQueryPageBO.getLockFlag() != null) {
			hqlCondition.append(" AND o.lockFlag = :lockFlag");
			param.put("lockFlag", sysOrgPrivateQueryPageBO.getLockFlag());
		}
	    if (sysOrgPrivateQueryPageBO.getStaffOrgRelatIdBegin() != null) {
			hqlCondition.append(" AND o.staffOrgRelatId >= :staffOrgRelatIdBegin");
			param.put("staffOrgRelatIdBegin", sysOrgPrivateQueryPageBO.getStaffOrgRelatIdBegin());
		}
	    if (sysOrgPrivateQueryPageBO.getStaffOrgRelatIdEnd() != null) {
			hqlCondition.append(" AND o.staffOrgRelatId <= :staffOrgRelatIdEnd");
			param.put("staffOrgRelatIdEnd", sysOrgPrivateQueryPageBO.getStaffOrgRelatIdEnd());
		}
	    if (sysOrgPrivateQueryPageBO.getOrganizeIdBegin() != null) {
			hqlCondition.append(" AND o.organizeId >= :organizeIdBegin");
			param.put("organizeIdBegin", sysOrgPrivateQueryPageBO.getOrganizeIdBegin());
		}
	    if (sysOrgPrivateQueryPageBO.getOrganizeIdEnd() != null) {
			hqlCondition.append(" AND o.organizeId <= :organizeIdEnd");
			param.put("organizeIdEnd", sysOrgPrivateQueryPageBO.getOrganizeIdEnd());
		}
	    if (!StringUtils.isBlank(sysOrgPrivateQueryPageBO.getOrganizeName())) {
			hqlCondition.append(" AND o.organizeName LIKE :organizeName");
			param.put("organizeName", "%"+sysOrgPrivateQueryPageBO.getOrganizeName()+"%");
		}
	    if (sysOrgPrivateQueryPageBO.getOrgTypeBegin() != null) {
			hqlCondition.append(" AND o.orgType >= :orgTypeBegin");
			param.put("orgTypeBegin", sysOrgPrivateQueryPageBO.getOrgTypeBegin());
		}
	    if (sysOrgPrivateQueryPageBO.getOrgTypeEnd() != null) {
			hqlCondition.append(" AND o.orgType <= :orgTypeEnd");
			param.put("orgTypeEnd", sysOrgPrivateQueryPageBO.getOrgTypeEnd());
		}
	    if (!StringUtils.isBlank(sysOrgPrivateQueryPageBO.getParamName())) {
			hqlCondition.append(" AND o.paramName LIKE :paramName");
			param.put("paramName", "%"+sysOrgPrivateQueryPageBO.getParamName()+"%");
		}
	    if (!StringUtils.isBlank(sysOrgPrivateQueryPageBO.getParamType())) {
			hqlCondition.append(" AND o.paramType LIKE :paramType");
			param.put("paramType", "%"+sysOrgPrivateQueryPageBO.getParamType()+"%");
		}
		hql.append(hqlCondition);
		hqlCount.append(hqlCondition);
		hql.append(" ORDER BY o.staffId DESC");
		List<BOSysOrgPrivate> boSysOrgPrivates = null;
		Page<SysOrgPrivateBO> page = new Page<SysOrgPrivateBO>();
		if ((sysOrgPrivateQueryPageBO.getPageNo() != null && sysOrgPrivateQueryPageBO.getPageNo().compareTo(0) > 0) && (sysOrgPrivateQueryPageBO.getPageSize() != null && sysOrgPrivateQueryPageBO.getPageSize().compareTo(0) > 0)) {
			Long count = (Long) commonDAO.findSingleResultByJPAQL(hqlCount.toString(), param);
			if (count == null || count.compareTo(0L) <= 0) {
				return page;
			}
			page.setRowCount(count.intValue());
			boSysOrgPrivates = commonDAO.findByJPAQL(hql.toString(), param, sysOrgPrivateQueryPageBO.getPageNo(), sysOrgPrivateQueryPageBO.getPageSize());
			page.generatePageCount(sysOrgPrivateQueryPageBO.getPageSize());
		} else {
			boSysOrgPrivates = commonDAO.findByJPAQL(hql.toString(), param);
		}
		page.setPageData(SysOrgPrivateMapper.INSTANCE.domainToBo(boSysOrgPrivates));
		return page;
	}
	
}