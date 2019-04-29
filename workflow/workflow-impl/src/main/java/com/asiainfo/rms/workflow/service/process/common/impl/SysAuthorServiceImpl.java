package com.asiainfo.rms.workflow.service.process.common.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysAuthorBO;
import com.asiainfo.rms.workflow.bo.process.common.SysAuthorQueryPageBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.common.BOSysAuthor;
import com.asiainfo.rms.workflow.mapper.process.common.SysAuthorMapper;
import com.asiainfo.rms.workflow.service.process.common.ISysAuthorService;

/**
 * 
 * 
 * @author joker
 */
@Service("sysAuthorService")
@Transactional(rollbackOn = Exception.class)
public class SysAuthorServiceImpl implements ISysAuthorService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void deleteByPrimaryKey(java.lang.Long authorId) throws Exception {
		commonDAO.delete(authorId, BOSysAuthor.class);
	}
	
	@Override
	public SysAuthorBO save(SysAuthorBO sysAuthorBO) throws Exception {
		BOSysAuthor boSysAuthor = SysAuthorMapper.INSTANCE.boToDomain(sysAuthorBO);
		boSysAuthor = commonDAO.saveOrUpdate(boSysAuthor, BOSysAuthor.class);
		return SysAuthorMapper.INSTANCE.domainToBo(boSysAuthor);
	}
	
	@Override
	public SysAuthorBO findByPrimaryKey(java.lang.Long authorId) throws Exception {
		BOSysAuthor boSysAuthor = commonDAO.findById(BOSysAuthor.class, authorId);
		return SysAuthorMapper.INSTANCE.domainToBo(boSysAuthor);
	}
	
	@Override
	public SysAuthorBO update(SysAuthorBO sysAuthorBO) throws Exception {
		BOSysAuthor boSysAuthor = SysAuthorMapper.INSTANCE.boToDomain(sysAuthorBO);
		boSysAuthor = commonDAO.saveOrUpdate(boSysAuthor, BOSysAuthor.class);
		return SysAuthorMapper.INSTANCE.domainToBo(boSysAuthor);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Page<SysAuthorBO> findByConds(SysAuthorQueryPageBO sysAuthorQueryPageBO) throws Exception {
		StringBuffer hql = new StringBuffer("SELECT o FROM BOSysAuthor o WHERE 1 = 1");
		StringBuffer hqlCount = new StringBuffer("SELECT COUNT(o) FROM BOSysAuthor o WHERE 1 = 1");
		StringBuffer hqlCondition = new StringBuffer();
		Map<String, Object> param = new HashMap<String, Object>();
	    if (sysAuthorQueryPageBO.getAuthorIdBegin() != null) {
			hqlCondition.append(" AND o.authorId >= :authorIdBegin");
			param.put("authorIdBegin", sysAuthorQueryPageBO.getAuthorIdBegin());
		}
	    if (sysAuthorQueryPageBO.getAuthorIdEnd() != null) {
			hqlCondition.append(" AND o.authorId <= :authorIdEnd");
			param.put("authorIdEnd", sysAuthorQueryPageBO.getAuthorIdEnd());
		}
	    if (sysAuthorQueryPageBO.getStationIdBegin() != null) {
			hqlCondition.append(" AND o.stationId >= :stationIdBegin");
			param.put("stationIdBegin", sysAuthorQueryPageBO.getStationIdBegin());
		}
	    if (sysAuthorQueryPageBO.getStationIdEnd() != null) {
			hqlCondition.append(" AND o.stationId <= :stationIdEnd");
			param.put("stationIdEnd", sysAuthorQueryPageBO.getStationIdEnd());
		}
	    if (sysAuthorQueryPageBO.getStaffIdBegin() != null) {
			hqlCondition.append(" AND o.staffId >= :staffIdBegin");
			param.put("staffIdBegin", sysAuthorQueryPageBO.getStaffIdBegin());
		}
	    if (sysAuthorQueryPageBO.getStaffIdEnd() != null) {
			hqlCondition.append(" AND o.staffId <= :staffIdEnd");
			param.put("staffIdEnd", sysAuthorQueryPageBO.getStaffIdEnd());
		}
	    if (!StringUtils.isBlank(sysAuthorQueryPageBO.getNotes())) {
			hqlCondition.append(" AND o.notes LIKE :notes");
			param.put("notes", "%"+sysAuthorQueryPageBO.getNotes()+"%");
		}
	    if (sysAuthorQueryPageBO.getStateBegin() != null) {
			hqlCondition.append(" AND o.state >= :stateBegin");
			param.put("stateBegin", sysAuthorQueryPageBO.getStateBegin());
		}
	    if (sysAuthorQueryPageBO.getStateEnd() != null) {
			hqlCondition.append(" AND o.state <= :stateEnd");
			param.put("stateEnd", sysAuthorQueryPageBO.getStateEnd());
		}
    	java.text.SimpleDateFormat sfCreateTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    if (sysAuthorQueryPageBO.getCreateTimeBegin() != null) {
			hqlCondition.append(" AND o.createTime >= to_date('");
			hqlCondition.append(sfCreateTime.format(sysAuthorQueryPageBO.getCreateTimeBegin()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (sysAuthorQueryPageBO.getCreateTimeEnd() != null) {
			hqlCondition.append(" AND o.createTime <= to_date('");
			hqlCondition.append(sfCreateTime.format(sysAuthorQueryPageBO.getCreateTimeEnd()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (!StringUtils.isBlank(sysAuthorQueryPageBO.getExt1())) {
			hqlCondition.append(" AND o.ext1 LIKE :ext1");
			param.put("ext1", "%"+sysAuthorQueryPageBO.getExt1()+"%");
		}
	    if (!StringUtils.isBlank(sysAuthorQueryPageBO.getExt2())) {
			hqlCondition.append(" AND o.ext2 LIKE :ext2");
			param.put("ext2", "%"+sysAuthorQueryPageBO.getExt2()+"%");
		}
	    if (!StringUtils.isBlank(sysAuthorQueryPageBO.getExt3())) {
			hqlCondition.append(" AND o.ext3 LIKE :ext3");
			param.put("ext3", "%"+sysAuthorQueryPageBO.getExt3()+"%");
		}
		hql.append(hqlCondition);
		hqlCount.append(hqlCondition);
		hql.append(" ORDER BY o.authorId DESC");
		List<BOSysAuthor> boSysAuthors = null;
		Page<SysAuthorBO> page = new Page<SysAuthorBO>();
		if ((sysAuthorQueryPageBO.getPageNo() != null && sysAuthorQueryPageBO.getPageNo().compareTo(0) > 0) && (sysAuthorQueryPageBO.getPageSize() != null && sysAuthorQueryPageBO.getPageSize().compareTo(0) > 0)) {
			Long count = (Long) commonDAO.findSingleResultByJPAQL(hqlCount.toString(), param);
			if (count == null || count.compareTo(0L) <= 0) {
				return page;
			}
			page.setRowCount(count.intValue());
			boSysAuthors = commonDAO.findByJPAQL(hql.toString(), param, sysAuthorQueryPageBO.getPageNo(), sysAuthorQueryPageBO.getPageSize());
			page.generatePageCount(sysAuthorQueryPageBO.getPageSize());
		} else {
			boSysAuthors = commonDAO.findByJPAQL(hql.toString(), param);
		}
		page.setPageData(SysAuthorMapper.INSTANCE.domainToBo(boSysAuthors));
		return page;
	}
	
}