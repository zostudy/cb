package com.asiainfo.rms.workflow.service.process.common.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysStationPrivateBO;
import com.asiainfo.rms.workflow.bo.process.common.SysStationPrivateQueryPageBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.common.BOSysStationPrivate;
import com.asiainfo.rms.workflow.mapper.process.common.SysStationPrivateMapper;
import com.asiainfo.rms.workflow.service.process.common.ISysStationPrivateService;

/**
 * 
 * 
 * @author joker
 */
@Service("sysStationPrivateService")
@Transactional(rollbackOn = Exception.class)
public class SysStationPrivateServiceImpl implements ISysStationPrivateService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void deleteByPrimaryKey(java.lang.Long staffId) throws Exception {
		commonDAO.delete(staffId, BOSysStationPrivate.class);
	}
	
	@Override
	public SysStationPrivateBO save(SysStationPrivateBO sysStationPrivateBO) throws Exception {
		BOSysStationPrivate boSysStationPrivate = SysStationPrivateMapper.INSTANCE.boToDomain(sysStationPrivateBO);
		boSysStationPrivate = commonDAO.saveOrUpdate(boSysStationPrivate, BOSysStationPrivate.class);
		return SysStationPrivateMapper.INSTANCE.domainToBo(boSysStationPrivate);
	}
	
	@Override
	public SysStationPrivateBO findByPrimaryKey(java.lang.Long staffId) throws Exception {
		BOSysStationPrivate boSysStationPrivate = commonDAO.findById(BOSysStationPrivate.class, staffId);
		return SysStationPrivateMapper.INSTANCE.domainToBo(boSysStationPrivate);
	}
	
	@Override
	public SysStationPrivateBO update(SysStationPrivateBO sysStationPrivateBO) throws Exception {
		BOSysStationPrivate boSysStationPrivate = SysStationPrivateMapper.INSTANCE.boToDomain(sysStationPrivateBO);
		boSysStationPrivate = commonDAO.saveOrUpdate(boSysStationPrivate, BOSysStationPrivate.class);
		return SysStationPrivateMapper.INSTANCE.domainToBo(boSysStationPrivate);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Page<SysStationPrivateBO> findByConds(SysStationPrivateQueryPageBO sysStationPrivateQueryPageBO) throws Exception {
		StringBuffer hql = new StringBuffer("SELECT o FROM BOSysStationPrivate o WHERE 1 = 1");
		StringBuffer hqlCount = new StringBuffer("SELECT COUNT(o) FROM BOSysStationPrivate o WHERE 1 = 1");
		StringBuffer hqlCondition = new StringBuffer();
		Map<String, Object> param = new HashMap<String, Object>();
	    if (sysStationPrivateQueryPageBO.getStaffIdBegin() != null) {
			hqlCondition.append(" AND o.staffId >= :staffIdBegin");
			param.put("staffIdBegin", sysStationPrivateQueryPageBO.getStaffIdBegin());
		}
	    if (sysStationPrivateQueryPageBO.getStaffIdEnd() != null) {
			hqlCondition.append(" AND o.staffId <= :staffIdEnd");
			param.put("staffIdEnd", sysStationPrivateQueryPageBO.getStaffIdEnd());
		}
	    if (!StringUtils.isBlank(sysStationPrivateQueryPageBO.getStaffCode())) {
			hqlCondition.append(" AND o.staffCode LIKE :staffCode");
			param.put("staffCode", "%"+sysStationPrivateQueryPageBO.getStaffCode()+"%");
		}
	    if (!StringUtils.isBlank(sysStationPrivateQueryPageBO.getEmployeeName())) {
			hqlCondition.append(" AND o.employeeName LIKE :employeeName");
			param.put("employeeName", "%"+sysStationPrivateQueryPageBO.getEmployeeName()+"%");
		}
	    if (!StringUtils.isBlank(sysStationPrivateQueryPageBO.getBillId())) {
			hqlCondition.append(" AND o.billId LIKE :billId");
			param.put("billId", "%"+sysStationPrivateQueryPageBO.getBillId()+"%");
		}
	    if (sysStationPrivateQueryPageBO.getLockFlag() != null) {
			hqlCondition.append(" AND o.lockFlag = :lockFlag");
			param.put("lockFlag", sysStationPrivateQueryPageBO.getLockFlag());
		}
	    if (sysStationPrivateQueryPageBO.getAuthorIdBegin() != null) {
			hqlCondition.append(" AND o.authorId >= :authorIdBegin");
			param.put("authorIdBegin", sysStationPrivateQueryPageBO.getAuthorIdBegin());
		}
	    if (sysStationPrivateQueryPageBO.getAuthorIdEnd() != null) {
			hqlCondition.append(" AND o.authorId <= :authorIdEnd");
			param.put("authorIdEnd", sysStationPrivateQueryPageBO.getAuthorIdEnd());
		}
	    if (!StringUtils.isBlank(sysStationPrivateQueryPageBO.getNotes())) {
			hqlCondition.append(" AND o.notes LIKE :notes");
			param.put("notes", "%"+sysStationPrivateQueryPageBO.getNotes()+"%");
		}
	    if (!StringUtils.isBlank(sysStationPrivateQueryPageBO.getNotesType())) {
			hqlCondition.append(" AND o.notesType LIKE :notesType");
			param.put("notesType", "%"+sysStationPrivateQueryPageBO.getNotesType()+"%");
		}
	    if (sysStationPrivateQueryPageBO.getStationIdBegin() != null) {
			hqlCondition.append(" AND o.stationId >= :stationIdBegin");
			param.put("stationIdBegin", sysStationPrivateQueryPageBO.getStationIdBegin());
		}
	    if (sysStationPrivateQueryPageBO.getStationIdEnd() != null) {
			hqlCondition.append(" AND o.stationId <= :stationIdEnd");
			param.put("stationIdEnd", sysStationPrivateQueryPageBO.getStationIdEnd());
		}
	    if (!StringUtils.isBlank(sysStationPrivateQueryPageBO.getStationCode())) {
			hqlCondition.append(" AND o.stationCode LIKE :stationCode");
			param.put("stationCode", "%"+sysStationPrivateQueryPageBO.getStationCode()+"%");
		}
	    if (!StringUtils.isBlank(sysStationPrivateQueryPageBO.getName())) {
			hqlCondition.append(" AND o.name LIKE :name");
			param.put("name", "%"+sysStationPrivateQueryPageBO.getName()+"%");
		}
	    if (sysStationPrivateQueryPageBO.getTypeBegin() != null) {
			hqlCondition.append(" AND o.type >= :typeBegin");
			param.put("typeBegin", sysStationPrivateQueryPageBO.getTypeBegin());
		}
	    if (sysStationPrivateQueryPageBO.getTypeEnd() != null) {
			hqlCondition.append(" AND o.type <= :typeEnd");
			param.put("typeEnd", sysStationPrivateQueryPageBO.getTypeEnd());
		}
	    if (sysStationPrivateQueryPageBO.getStationTypeBegin() != null) {
			hqlCondition.append(" AND o.stationType >= :stationTypeBegin");
			param.put("stationTypeBegin", sysStationPrivateQueryPageBO.getStationTypeBegin());
		}
	    if (sysStationPrivateQueryPageBO.getStationTypeEnd() != null) {
			hqlCondition.append(" AND o.stationType <= :stationTypeEnd");
			param.put("stationTypeEnd", sysStationPrivateQueryPageBO.getStationTypeEnd());
		}
	    if (!StringUtils.isBlank(sysStationPrivateQueryPageBO.getStaPrivateName())) {
			hqlCondition.append(" AND o.staPrivateName LIKE :staPrivateName");
			param.put("staPrivateName", "%"+sysStationPrivateQueryPageBO.getStaPrivateName()+"%");
		}
	    if (!StringUtils.isBlank(sysStationPrivateQueryPageBO.getStaPrivateType())) {
			hqlCondition.append(" AND o.staPrivateType LIKE :staPrivateType");
			param.put("staPrivateType", "%"+sysStationPrivateQueryPageBO.getStaPrivateType()+"%");
		}
	    if (sysStationPrivateQueryPageBO.getStaffOrgRelatIdBegin() != null) {
			hqlCondition.append(" AND o.staffOrgRelatId >= :staffOrgRelatIdBegin");
			param.put("staffOrgRelatIdBegin", sysStationPrivateQueryPageBO.getStaffOrgRelatIdBegin());
		}
	    if (sysStationPrivateQueryPageBO.getStaffOrgRelatIdEnd() != null) {
			hqlCondition.append(" AND o.staffOrgRelatId <= :staffOrgRelatIdEnd");
			param.put("staffOrgRelatIdEnd", sysStationPrivateQueryPageBO.getStaffOrgRelatIdEnd());
		}
	    if (sysStationPrivateQueryPageBO.getOrganizeIdBegin() != null) {
			hqlCondition.append(" AND o.organizeId >= :organizeIdBegin");
			param.put("organizeIdBegin", sysStationPrivateQueryPageBO.getOrganizeIdBegin());
		}
	    if (sysStationPrivateQueryPageBO.getOrganizeIdEnd() != null) {
			hqlCondition.append(" AND o.organizeId <= :organizeIdEnd");
			param.put("organizeIdEnd", sysStationPrivateQueryPageBO.getOrganizeIdEnd());
		}
	    if (!StringUtils.isBlank(sysStationPrivateQueryPageBO.getOrganizeName())) {
			hqlCondition.append(" AND o.organizeName LIKE :organizeName");
			param.put("organizeName", "%"+sysStationPrivateQueryPageBO.getOrganizeName()+"%");
		}
	    if (sysStationPrivateQueryPageBO.getOrgTypeBegin() != null) {
			hqlCondition.append(" AND o.orgType >= :orgTypeBegin");
			param.put("orgTypeBegin", sysStationPrivateQueryPageBO.getOrgTypeBegin());
		}
	    if (sysStationPrivateQueryPageBO.getOrgTypeEnd() != null) {
			hqlCondition.append(" AND o.orgType <= :orgTypeEnd");
			param.put("orgTypeEnd", sysStationPrivateQueryPageBO.getOrgTypeEnd());
		}
	    if (!StringUtils.isBlank(sysStationPrivateQueryPageBO.getOrgPrivateName())) {
			hqlCondition.append(" AND o.orgPrivateName LIKE :orgPrivateName");
			param.put("orgPrivateName", "%"+sysStationPrivateQueryPageBO.getOrgPrivateName()+"%");
		}
	    if (!StringUtils.isBlank(sysStationPrivateQueryPageBO.getOrgPrivateType())) {
			hqlCondition.append(" AND o.orgPrivateType LIKE :orgPrivateType");
			param.put("orgPrivateType", "%"+sysStationPrivateQueryPageBO.getOrgPrivateType()+"%");
		}
		hql.append(hqlCondition);
		hqlCount.append(hqlCondition);
		hql.append(" ORDER BY o.staffId DESC");
		List<BOSysStationPrivate> boSysStationPrivates = null;
		Page<SysStationPrivateBO> page = new Page<SysStationPrivateBO>();
		if ((sysStationPrivateQueryPageBO.getPageNo() != null && sysStationPrivateQueryPageBO.getPageNo().compareTo(0) > 0) && (sysStationPrivateQueryPageBO.getPageSize() != null && sysStationPrivateQueryPageBO.getPageSize().compareTo(0) > 0)) {
			Long count = (Long) commonDAO.findSingleResultByJPAQL(hqlCount.toString(), param);
			if (count == null || count.compareTo(0L) <= 0) {
				return page;
			}
			page.setRowCount(count.intValue());
			boSysStationPrivates = commonDAO.findByJPAQL(hql.toString(), param, sysStationPrivateQueryPageBO.getPageNo(), sysStationPrivateQueryPageBO.getPageSize());
			page.generatePageCount(sysStationPrivateQueryPageBO.getPageSize());
		} else {
			boSysStationPrivates = commonDAO.findByJPAQL(hql.toString(), param);
		}
		page.setPageData(SysStationPrivateMapper.INSTANCE.domainToBo(boSysStationPrivates));
		return page;
	}
	
}