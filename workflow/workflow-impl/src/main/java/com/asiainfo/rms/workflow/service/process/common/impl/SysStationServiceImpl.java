package com.asiainfo.rms.workflow.service.process.common.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysStationBO;
import com.asiainfo.rms.workflow.bo.process.common.SysStationQueryPageBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.common.BOSysStation;
import com.asiainfo.rms.workflow.mapper.process.common.SysStationMapper;
import com.asiainfo.rms.workflow.service.process.common.ISysStationService;

/**
 * 
 * 
 * @author joker
 */
@Service("sysStationService")
@Transactional(rollbackOn = Exception.class)
public class SysStationServiceImpl implements ISysStationService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void deleteByPrimaryKey(java.lang.Long stationId) throws Exception {
		commonDAO.delete(stationId, BOSysStation.class);
	}
	
	@Override
	public SysStationBO save(SysStationBO sysStationBO) throws Exception {
		BOSysStation boSysStation = SysStationMapper.INSTANCE.boToDomain(sysStationBO);
		boSysStation = commonDAO.saveOrUpdate(boSysStation, BOSysStation.class);
		return SysStationMapper.INSTANCE.domainToBo(boSysStation);
	}
	
	@Override
	public SysStationBO findByPrimaryKey(java.lang.Long stationId) throws Exception {
		BOSysStation boSysStation = commonDAO.findById(BOSysStation.class, stationId);
		return SysStationMapper.INSTANCE.domainToBo(boSysStation);
	}
	
	@Override
	public SysStationBO update(SysStationBO sysStationBO) throws Exception {
		BOSysStation boSysStation = SysStationMapper.INSTANCE.boToDomain(sysStationBO);
		boSysStation = commonDAO.saveOrUpdate(boSysStation, BOSysStation.class);
		return SysStationMapper.INSTANCE.domainToBo(boSysStation);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Page<SysStationBO> findByConds(SysStationQueryPageBO sysStationQueryPageBO) throws Exception {
		StringBuffer hql = new StringBuffer("SELECT o FROM BOSysStation o WHERE 1 = 1");
		StringBuffer hqlCount = new StringBuffer("SELECT COUNT(o) FROM BOSysStation o WHERE 1 = 1");
		StringBuffer hqlCondition = new StringBuffer();
		Map<String, Object> param = new HashMap<String, Object>();
	    if (sysStationQueryPageBO.getStationIdBegin() != null) {
			hqlCondition.append(" AND o.stationId >= :stationIdBegin");
			param.put("stationIdBegin", sysStationQueryPageBO.getStationIdBegin());
		}
	    if (sysStationQueryPageBO.getStationIdEnd() != null) {
			hqlCondition.append(" AND o.stationId <= :stationIdEnd");
			param.put("stationIdEnd", sysStationQueryPageBO.getStationIdEnd());
		}
	    if (!StringUtils.isBlank(sysStationQueryPageBO.getCode())) {
			hqlCondition.append(" AND o.code LIKE :code");
			param.put("code", "%"+sysStationQueryPageBO.getCode()+"%");
		}
	    if (!StringUtils.isBlank(sysStationQueryPageBO.getName())) {
			hqlCondition.append(" AND o.name LIKE :name");
			param.put("name", "%"+sysStationQueryPageBO.getName()+"%");
		}
	    if (!StringUtils.isBlank(sysStationQueryPageBO.getNotes())) {
			hqlCondition.append(" AND o.notes LIKE :notes");
			param.put("notes", "%"+sysStationQueryPageBO.getNotes()+"%");
		}
	    if (sysStationQueryPageBO.getStateBegin() != null) {
			hqlCondition.append(" AND o.state >= :stateBegin");
			param.put("stateBegin", sysStationQueryPageBO.getStateBegin());
		}
	    if (sysStationQueryPageBO.getStateEnd() != null) {
			hqlCondition.append(" AND o.state <= :stateEnd");
			param.put("stateEnd", sysStationQueryPageBO.getStateEnd());
		}
	    if (sysStationQueryPageBO.getTypeBegin() != null) {
			hqlCondition.append(" AND o.type >= :typeBegin");
			param.put("typeBegin", sysStationQueryPageBO.getTypeBegin());
		}
	    if (sysStationQueryPageBO.getTypeEnd() != null) {
			hqlCondition.append(" AND o.type <= :typeEnd");
			param.put("typeEnd", sysStationQueryPageBO.getTypeEnd());
		}
	    if (!StringUtils.isBlank(sysStationQueryPageBO.getExt1())) {
			hqlCondition.append(" AND o.ext1 LIKE :ext1");
			param.put("ext1", "%"+sysStationQueryPageBO.getExt1()+"%");
		}
	    if (!StringUtils.isBlank(sysStationQueryPageBO.getExt2())) {
			hqlCondition.append(" AND o.ext2 LIKE :ext2");
			param.put("ext2", "%"+sysStationQueryPageBO.getExt2()+"%");
		}
	    if (!StringUtils.isBlank(sysStationQueryPageBO.getExt3())) {
			hqlCondition.append(" AND o.ext3 LIKE :ext3");
			param.put("ext3", "%"+sysStationQueryPageBO.getExt3()+"%");
		}
	    if (sysStationQueryPageBO.getStationTypeBegin() != null) {
			hqlCondition.append(" AND o.stationType >= :stationTypeBegin");
			param.put("stationTypeBegin", sysStationQueryPageBO.getStationTypeBegin());
		}
	    if (sysStationQueryPageBO.getStationTypeEnd() != null) {
			hqlCondition.append(" AND o.stationType <= :stationTypeEnd");
			param.put("stationTypeEnd", sysStationQueryPageBO.getStationTypeEnd());
		}
		hql.append(hqlCondition);
		hqlCount.append(hqlCondition);
		hql.append(" ORDER BY o.stationId DESC");
		List<BOSysStation> boSysStations = null;
		Page<SysStationBO> page = new Page<SysStationBO>();
		if ((sysStationQueryPageBO.getPageNo() != null && sysStationQueryPageBO.getPageNo().compareTo(0) > 0) && (sysStationQueryPageBO.getPageSize() != null && sysStationQueryPageBO.getPageSize().compareTo(0) > 0)) {
			Long count = (Long) commonDAO.findSingleResultByJPAQL(hqlCount.toString(), param);
			if (count == null || count.compareTo(0L) <= 0) {
				return page;
			}
			page.setRowCount(count.intValue());
			boSysStations = commonDAO.findByJPAQL(hql.toString(), param, sysStationQueryPageBO.getPageNo(), sysStationQueryPageBO.getPageSize());
			page.generatePageCount(sysStationQueryPageBO.getPageSize());
		} else {
			boSysStations = commonDAO.findByJPAQL(hql.toString(), param);
		}
		page.setPageData(SysStationMapper.INSTANCE.domainToBo(boSysStations));
		return page;
	}
	
}