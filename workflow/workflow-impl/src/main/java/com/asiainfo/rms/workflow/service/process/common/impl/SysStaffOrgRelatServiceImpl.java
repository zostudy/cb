package com.asiainfo.rms.workflow.service.process.common.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysStaffOrgRelatBO;
import com.asiainfo.rms.workflow.bo.process.common.SysStaffOrgRelatQueryPageBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.common.BOSysStaffOrgRelat;
import com.asiainfo.rms.workflow.mapper.process.common.SysStaffOrgRelatMapper;
import com.asiainfo.rms.workflow.service.process.common.ISysStaffOrgRelatService;

/**
 * 
 * 
 * @author joker
 */
@Service("sysStaffOrgRelatService")
@Transactional(rollbackOn = Exception.class)
public class SysStaffOrgRelatServiceImpl implements ISysStaffOrgRelatService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void deleteByPrimaryKey(java.lang.Long staffOrgRelatId) throws Exception {
		commonDAO.delete(staffOrgRelatId, BOSysStaffOrgRelat.class);
	}
	
	@Override
	public SysStaffOrgRelatBO save(SysStaffOrgRelatBO sysStaffOrgRelatBO) throws Exception {
		BOSysStaffOrgRelat boSysStaffOrgRelat = SysStaffOrgRelatMapper.INSTANCE.boToDomain(sysStaffOrgRelatBO);
		boSysStaffOrgRelat = commonDAO.saveOrUpdate(boSysStaffOrgRelat, BOSysStaffOrgRelat.class);
		return SysStaffOrgRelatMapper.INSTANCE.domainToBo(boSysStaffOrgRelat);
	}
	
	@Override
	public SysStaffOrgRelatBO findByPrimaryKey(java.lang.Long staffOrgRelatId) throws Exception {
		BOSysStaffOrgRelat boSysStaffOrgRelat = commonDAO.findById(BOSysStaffOrgRelat.class, staffOrgRelatId);
		return SysStaffOrgRelatMapper.INSTANCE.domainToBo(boSysStaffOrgRelat);
	}
	
	@Override
	public SysStaffOrgRelatBO update(SysStaffOrgRelatBO sysStaffOrgRelatBO) throws Exception {
		BOSysStaffOrgRelat boSysStaffOrgRelat = SysStaffOrgRelatMapper.INSTANCE.boToDomain(sysStaffOrgRelatBO);
		boSysStaffOrgRelat = commonDAO.saveOrUpdate(boSysStaffOrgRelat, BOSysStaffOrgRelat.class);
		return SysStaffOrgRelatMapper.INSTANCE.domainToBo(boSysStaffOrgRelat);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Page<SysStaffOrgRelatBO> findByConds(SysStaffOrgRelatQueryPageBO sysStaffOrgRelatQueryPageBO) throws Exception {
		StringBuffer hql = new StringBuffer("SELECT o FROM BOSysStaffOrgRelat o WHERE 1 = 1");
		StringBuffer hqlCount = new StringBuffer("SELECT COUNT(o) FROM BOSysStaffOrgRelat o WHERE 1 = 1");
		StringBuffer hqlCondition = new StringBuffer();
		Map<String, Object> param = new HashMap<String, Object>();
	    if (sysStaffOrgRelatQueryPageBO.getStaffOrgRelatIdBegin() != null) {
			hqlCondition.append(" AND o.staffOrgRelatId >= :staffOrgRelatIdBegin");
			param.put("staffOrgRelatIdBegin", sysStaffOrgRelatQueryPageBO.getStaffOrgRelatIdBegin());
		}
	    if (sysStaffOrgRelatQueryPageBO.getStaffOrgRelatIdEnd() != null) {
			hqlCondition.append(" AND o.staffOrgRelatId <= :staffOrgRelatIdEnd");
			param.put("staffOrgRelatIdEnd", sysStaffOrgRelatQueryPageBO.getStaffOrgRelatIdEnd());
		}
	    if (sysStaffOrgRelatQueryPageBO.getOrganizeIdBegin() != null) {
			hqlCondition.append(" AND o.organizeId >= :organizeIdBegin");
			param.put("organizeIdBegin", sysStaffOrgRelatQueryPageBO.getOrganizeIdBegin());
		}
	    if (sysStaffOrgRelatQueryPageBO.getOrganizeIdEnd() != null) {
			hqlCondition.append(" AND o.organizeId <= :organizeIdEnd");
			param.put("organizeIdEnd", sysStaffOrgRelatQueryPageBO.getOrganizeIdEnd());
		}
	    if (sysStaffOrgRelatQueryPageBO.getStaffIdBegin() != null) {
			hqlCondition.append(" AND o.staffId >= :staffIdBegin");
			param.put("staffIdBegin", sysStaffOrgRelatQueryPageBO.getStaffIdBegin());
		}
	    if (sysStaffOrgRelatQueryPageBO.getStaffIdEnd() != null) {
			hqlCondition.append(" AND o.staffId <= :staffIdEnd");
			param.put("staffIdEnd", sysStaffOrgRelatQueryPageBO.getStaffIdEnd());
		}
	    if (sysStaffOrgRelatQueryPageBO.getStateBegin() != null) {
			hqlCondition.append(" AND o.state >= :stateBegin");
			param.put("stateBegin", sysStaffOrgRelatQueryPageBO.getStateBegin());
		}
	    if (sysStaffOrgRelatQueryPageBO.getStateEnd() != null) {
			hqlCondition.append(" AND o.state <= :stateEnd");
			param.put("stateEnd", sysStaffOrgRelatQueryPageBO.getStateEnd());
		}
	    if (!StringUtils.isBlank(sysStaffOrgRelatQueryPageBO.getNotes())) {
			hqlCondition.append(" AND o.notes LIKE :notes");
			param.put("notes", "%"+sysStaffOrgRelatQueryPageBO.getNotes()+"%");
		}
    	java.text.SimpleDateFormat sfCreateTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    if (sysStaffOrgRelatQueryPageBO.getCreateTimeBegin() != null) {
			hqlCondition.append(" AND o.createTime >= to_date('");
			hqlCondition.append(sfCreateTime.format(sysStaffOrgRelatQueryPageBO.getCreateTimeBegin()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (sysStaffOrgRelatQueryPageBO.getCreateTimeEnd() != null) {
			hqlCondition.append(" AND o.createTime <= to_date('");
			hqlCondition.append(sfCreateTime.format(sysStaffOrgRelatQueryPageBO.getCreateTimeEnd()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (!StringUtils.isBlank(sysStaffOrgRelatQueryPageBO.getExt1())) {
			hqlCondition.append(" AND o.ext1 LIKE :ext1");
			param.put("ext1", "%"+sysStaffOrgRelatQueryPageBO.getExt1()+"%");
		}
	    if (!StringUtils.isBlank(sysStaffOrgRelatQueryPageBO.getExt2())) {
			hqlCondition.append(" AND o.ext2 LIKE :ext2");
			param.put("ext2", "%"+sysStaffOrgRelatQueryPageBO.getExt2()+"%");
		}
	    if (!StringUtils.isBlank(sysStaffOrgRelatQueryPageBO.getExt3())) {
			hqlCondition.append(" AND o.ext3 LIKE :ext3");
			param.put("ext3", "%"+sysStaffOrgRelatQueryPageBO.getExt3()+"%");
		}
		hql.append(hqlCondition);
		hqlCount.append(hqlCondition);
		hql.append(" ORDER BY o.staffOrgRelatId DESC");
		List<BOSysStaffOrgRelat> boSysStaffOrgRelats = null;
		Page<SysStaffOrgRelatBO> page = new Page<SysStaffOrgRelatBO>();
		if ((sysStaffOrgRelatQueryPageBO.getPageNo() != null && sysStaffOrgRelatQueryPageBO.getPageNo().compareTo(0) > 0) && (sysStaffOrgRelatQueryPageBO.getPageSize() != null && sysStaffOrgRelatQueryPageBO.getPageSize().compareTo(0) > 0)) {
			Long count = (Long) commonDAO.findSingleResultByJPAQL(hqlCount.toString(), param);
			if (count == null || count.compareTo(0L) <= 0) {
				return page;
			}
			page.setRowCount(count.intValue());
			boSysStaffOrgRelats = commonDAO.findByJPAQL(hql.toString(), param, sysStaffOrgRelatQueryPageBO.getPageNo(), sysStaffOrgRelatQueryPageBO.getPageSize());
			page.generatePageCount(sysStaffOrgRelatQueryPageBO.getPageSize());
		} else {
			boSysStaffOrgRelats = commonDAO.findByJPAQL(hql.toString(), param);
		}
		page.setPageData(SysStaffOrgRelatMapper.INSTANCE.domainToBo(boSysStaffOrgRelats));
		return page;
	}
	
}