package com.asiainfo.rms.workflow.service.process.common.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysOrganizeBO;
import com.asiainfo.rms.workflow.bo.process.common.SysOrganizeQueryPageBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.common.BOSysOrganize;
import com.asiainfo.rms.workflow.mapper.process.common.SysOrganizeMapper;
import com.asiainfo.rms.workflow.service.process.common.ISysOrganizeService;

/**
 * 
 * 
 * @author joker
 */
@Service("sysOrganizeService")
@Transactional(rollbackOn = Exception.class)
public class SysOrganizeServiceImpl implements ISysOrganizeService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void deleteByPrimaryKey(java.lang.Long organizeId) throws Exception {
		commonDAO.delete(organizeId, BOSysOrganize.class);
	}
	
	@Override
	public SysOrganizeBO save(SysOrganizeBO sysOrganizeBO) throws Exception {
		BOSysOrganize boSysOrganize = SysOrganizeMapper.INSTANCE.boToDomain(sysOrganizeBO);
		boSysOrganize = commonDAO.saveOrUpdate(boSysOrganize, BOSysOrganize.class);
		return SysOrganizeMapper.INSTANCE.domainToBo(boSysOrganize);
	}
	
	@Override
	public SysOrganizeBO findByPrimaryKey(java.lang.Long organizeId) throws Exception{
		BOSysOrganize boSysOrganize = commonDAO.findById(BOSysOrganize.class, organizeId);
		return SysOrganizeMapper.INSTANCE.domainToBo(boSysOrganize);
	}
	
	@Override
	public SysOrganizeBO update(SysOrganizeBO sysOrganizeBO) throws Exception {
		BOSysOrganize boSysOrganize = SysOrganizeMapper.INSTANCE.boToDomain(sysOrganizeBO);
		boSysOrganize = commonDAO.saveOrUpdate(boSysOrganize, BOSysOrganize.class);
		return SysOrganizeMapper.INSTANCE.domainToBo(boSysOrganize);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Page<SysOrganizeBO> findByConds(SysOrganizeQueryPageBO sysOrganizeQueryPageBO) throws Exception {
		StringBuffer hql = new StringBuffer("SELECT o FROM BOSysOrganize o WHERE 1 = 1");
		StringBuffer hqlCount = new StringBuffer("SELECT COUNT(o) FROM BOSysOrganize o WHERE 1 = 1");
		StringBuffer hqlCondition = new StringBuffer();
		Map<String, Object> param = new HashMap<String, Object>();
	    if (sysOrganizeQueryPageBO.getOrganizeIdBegin() != null) {
			hqlCondition.append(" AND o.organizeId >= :organizeIdBegin");
			param.put("organizeIdBegin", sysOrganizeQueryPageBO.getOrganizeIdBegin());
		}
	    if (sysOrganizeQueryPageBO.getOrganizeIdEnd() != null) {
			hqlCondition.append(" AND o.organizeId <= :organizeIdEnd");
			param.put("organizeIdEnd", sysOrganizeQueryPageBO.getOrganizeIdEnd());
		}
	    if (sysOrganizeQueryPageBO.getParentOrganizeIdBegin() != null) {
			hqlCondition.append(" AND o.parentOrganizeId >= :parentOrganizeIdBegin");
			param.put("parentOrganizeIdBegin", sysOrganizeQueryPageBO.getParentOrganizeIdBegin());
		}
	    if (sysOrganizeQueryPageBO.getParentOrganizeIdEnd() != null) {
			hqlCondition.append(" AND o.parentOrganizeId <= :parentOrganizeIdEnd");
			param.put("parentOrganizeIdEnd", sysOrganizeQueryPageBO.getParentOrganizeIdEnd());
		}
	    if (!StringUtils.isBlank(sysOrganizeQueryPageBO.getOrganizeName())) {
			hqlCondition.append(" AND o.organizeName LIKE :organizeName");
			param.put("organizeName", "%"+sysOrganizeQueryPageBO.getOrganizeName()+"%");
		}
	    if (!StringUtils.isBlank(sysOrganizeQueryPageBO.getCode())) {
			hqlCondition.append(" AND o.code LIKE :code");
			param.put("code", "%"+sysOrganizeQueryPageBO.getCode()+"%");
		}
	    if (sysOrganizeQueryPageBO.getOrgTypeBegin() != null) {
			hqlCondition.append(" AND o.orgType >= :orgTypeBegin");
			param.put("orgTypeBegin", sysOrganizeQueryPageBO.getOrgTypeBegin());
		}
	    if (sysOrganizeQueryPageBO.getOrgTypeEnd() != null) {
			hqlCondition.append(" AND o.orgType <= :orgTypeEnd");
			param.put("orgTypeEnd", sysOrganizeQueryPageBO.getOrgTypeEnd());
		}
	    if (!StringUtils.isBlank(sysOrganizeQueryPageBO.getNotes())) {
			hqlCondition.append(" AND o.notes LIKE :notes");
			param.put("notes", "%"+sysOrganizeQueryPageBO.getNotes()+"%");
		}
	    if (sysOrganizeQueryPageBO.getStateBegin() != null) {
			hqlCondition.append(" AND o.state >= :stateBegin");
			param.put("stateBegin", sysOrganizeQueryPageBO.getStateBegin());
		}
	    if (sysOrganizeQueryPageBO.getStateEnd() != null) {
			hqlCondition.append(" AND o.state <= :stateEnd");
			param.put("stateEnd", sysOrganizeQueryPageBO.getStateEnd());
		}
    	java.text.SimpleDateFormat sfCreateDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    if (sysOrganizeQueryPageBO.getCreateDateBegin() != null) {
			hqlCondition.append(" AND o.createDate >= to_date('");
			hqlCondition.append(sfCreateDate.format(sysOrganizeQueryPageBO.getCreateDateBegin()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (sysOrganizeQueryPageBO.getCreateDateEnd() != null) {
			hqlCondition.append(" AND o.createDate <= to_date('");
			hqlCondition.append(sfCreateDate.format(sysOrganizeQueryPageBO.getCreateDateEnd()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (!StringUtils.isBlank(sysOrganizeQueryPageBO.getExt1())) {
			hqlCondition.append(" AND o.ext1 LIKE :ext1");
			param.put("ext1", "%"+sysOrganizeQueryPageBO.getExt1()+"%");
		}
	    if (!StringUtils.isBlank(sysOrganizeQueryPageBO.getExt2())) {
			hqlCondition.append(" AND o.ext2 LIKE :ext2");
			param.put("ext2", "%"+sysOrganizeQueryPageBO.getExt2()+"%");
		}
	    if (!StringUtils.isBlank(sysOrganizeQueryPageBO.getExt3())) {
			hqlCondition.append(" AND o.ext3 LIKE :ext3");
			param.put("ext3", "%"+sysOrganizeQueryPageBO.getExt3()+"%");
		}
	    if (sysOrganizeQueryPageBO.getOrganizeTypeIdBegin() != null) {
			hqlCondition.append(" AND o.organizeTypeId >= :organizeTypeIdBegin");
			param.put("organizeTypeIdBegin", sysOrganizeQueryPageBO.getOrganizeTypeIdBegin());
		}
	    if (sysOrganizeQueryPageBO.getOrganizeTypeIdEnd() != null) {
			hqlCondition.append(" AND o.organizeTypeId <= :organizeTypeIdEnd");
			param.put("organizeTypeIdEnd", sysOrganizeQueryPageBO.getOrganizeTypeIdEnd());
		}
	    if (!StringUtils.isBlank(sysOrganizeQueryPageBO.getParentCode())) {
			hqlCondition.append(" AND o.parentCode LIKE :parentCode");
			param.put("parentCode", "%"+sysOrganizeQueryPageBO.getParentCode()+"%");
		}
		hql.append(hqlCondition);
		hqlCount.append(hqlCondition);
		hql.append(" ORDER BY o.organizeId DESC");
		List<BOSysOrganize> boSysOrganizes = null;
		Page<SysOrganizeBO> page = new Page<SysOrganizeBO>();
		if ((sysOrganizeQueryPageBO.getPageNo() != null && sysOrganizeQueryPageBO.getPageNo().compareTo(0) > 0) && (sysOrganizeQueryPageBO.getPageSize() != null && sysOrganizeQueryPageBO.getPageSize().compareTo(0) > 0)) {
			Long count = (Long) commonDAO.findSingleResultByJPAQL(hqlCount.toString(), param);
			if (count == null || count.compareTo(0L) <= 0) {
				return page;
			}
			page.setRowCount(count.intValue());
			boSysOrganizes = commonDAO.findByJPAQL(hql.toString(), param, sysOrganizeQueryPageBO.getPageNo(), sysOrganizeQueryPageBO.getPageSize());
			page.generatePageCount(sysOrganizeQueryPageBO.getPageSize());
		} else {
			boSysOrganizes = commonDAO.findByJPAQL(hql.toString(), param);
		}
		page.setPageData(SysOrganizeMapper.INSTANCE.domainToBo(boSysOrganizes));
		return page;
	}
	
}