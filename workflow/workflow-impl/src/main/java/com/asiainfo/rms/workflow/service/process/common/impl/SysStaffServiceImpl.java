package com.asiainfo.rms.workflow.service.process.common.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysStaffBO;
import com.asiainfo.rms.workflow.bo.process.common.SysStaffQueryPageBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.common.BOSysStaff;
import com.asiainfo.rms.workflow.mapper.process.common.SysStaffMapper;
import com.asiainfo.rms.workflow.service.process.common.ISysStaffService;

/**
 * 
 * 
 * @author joker
 */
@Service("sysStaffService")
@Transactional(rollbackOn = Exception.class)
public class SysStaffServiceImpl implements ISysStaffService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void deleteByPrimaryKey(java.lang.Long staffId) throws Exception {
		commonDAO.delete(staffId, BOSysStaff.class);
	}
	
	@Override
	public SysStaffBO save(SysStaffBO sysStaffBO) throws Exception {
		BOSysStaff boSysStaff = SysStaffMapper.INSTANCE.boToDomain(sysStaffBO);
		boSysStaff = commonDAO.saveOrUpdate(boSysStaff, BOSysStaff.class);
		return SysStaffMapper.INSTANCE.domainToBo(boSysStaff);
	}
	
	@Override
	public SysStaffBO findByPrimaryKey(java.lang.Long staffId) throws Exception{
		BOSysStaff boSysStaff = commonDAO.findById(BOSysStaff.class, staffId);
		return SysStaffMapper.INSTANCE.domainToBo(boSysStaff);
	}
	
	@Override
	public SysStaffBO update(SysStaffBO sysStaffBO) throws Exception {
		BOSysStaff boSysStaff = SysStaffMapper.INSTANCE.boToDomain(sysStaffBO);
		boSysStaff = commonDAO.saveOrUpdate(boSysStaff, BOSysStaff.class);
		return SysStaffMapper.INSTANCE.domainToBo(boSysStaff);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Page<SysStaffBO> findByConds(SysStaffQueryPageBO sysStaffQueryPageBO) throws Exception {
		StringBuffer hql = new StringBuffer("SELECT o FROM BOSysStaff o WHERE 1 = 1");
		StringBuffer hqlCount = new StringBuffer("SELECT COUNT(o) FROM BOSysStaff o WHERE 1 = 1");
		StringBuffer hqlCondition = new StringBuffer();
		Map<String, Object> param = new HashMap<String, Object>();
	    if (sysStaffQueryPageBO.getStaffIdBegin() != null) {
			hqlCondition.append(" AND o.staffId >= :staffIdBegin");
			param.put("staffIdBegin", sysStaffQueryPageBO.getStaffIdBegin());
		}
	    if (sysStaffQueryPageBO.getStaffIdEnd() != null) {
			hqlCondition.append(" AND o.staffId <= :staffIdEnd");
			param.put("staffIdEnd", sysStaffQueryPageBO.getStaffIdEnd());
		}
	    if (!StringUtils.isBlank(sysStaffQueryPageBO.getCode())) {
			hqlCondition.append(" AND o.code LIKE :code");
			param.put("code", "%"+sysStaffQueryPageBO.getCode()+"%");
		}
	    if (!StringUtils.isBlank(sysStaffQueryPageBO.getPassword())) {
			hqlCondition.append(" AND o.password LIKE :password");
			param.put("password", "%"+sysStaffQueryPageBO.getPassword()+"%");
		}
	    if (!StringUtils.isBlank(sysStaffQueryPageBO.getRecentPassword())) {
			hqlCondition.append(" AND o.recentPassword LIKE :recentPassword");
			param.put("recentPassword", "%"+sysStaffQueryPageBO.getRecentPassword()+"%");
		}
    	java.text.SimpleDateFormat sfRecentTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    if (sysStaffQueryPageBO.getRecentTimeBegin() != null) {
			hqlCondition.append(" AND o.recentTime >= to_date('");
			hqlCondition.append(sfRecentTime.format(sysStaffQueryPageBO.getRecentTimeBegin()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (sysStaffQueryPageBO.getRecentTimeEnd() != null) {
			hqlCondition.append(" AND o.recentTime <= to_date('");
			hqlCondition.append(sfRecentTime.format(sysStaffQueryPageBO.getRecentTimeEnd()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (!StringUtils.isBlank(sysStaffQueryPageBO.getEmployeeName())) {
			hqlCondition.append(" AND o.employeeName LIKE :employeeName");
			param.put("employeeName", "%"+sysStaffQueryPageBO.getEmployeeName()+"%");
		}
	    if (!StringUtils.isBlank(sysStaffQueryPageBO.getBillId())) {
			hqlCondition.append(" AND o.billId LIKE :billId");
			param.put("billId", "%"+sysStaffQueryPageBO.getBillId()+"%");
		}
	    if (!StringUtils.isBlank(sysStaffQueryPageBO.getEmail())) {
			hqlCondition.append(" AND o.email LIKE :email");
			param.put("email", "%"+sysStaffQueryPageBO.getEmail()+"%");
		}
	    if (!StringUtils.isBlank(sysStaffQueryPageBO.getReligion())) {
			hqlCondition.append(" AND o.religion LIKE :religion");
			param.put("religion", "%"+sysStaffQueryPageBO.getReligion()+"%");
		}
	    if (sysStaffQueryPageBO.getStateBegin() != null) {
			hqlCondition.append(" AND o.state >= :stateBegin");
			param.put("stateBegin", sysStaffQueryPageBO.getStateBegin());
		}
	    if (sysStaffQueryPageBO.getStateEnd() != null) {
			hqlCondition.append(" AND o.state <= :stateEnd");
			param.put("stateEnd", sysStaffQueryPageBO.getStateEnd());
		}
	    if (sysStaffQueryPageBO.getLockFlag() != null) {
			hqlCondition.append(" AND o.lockFlag = :lockFlag");
			param.put("lockFlag", sysStaffQueryPageBO.getLockFlag());
		}
	    if (!StringUtils.isBlank(sysStaffQueryPageBO.getNotes())) {
			hqlCondition.append(" AND o.notes LIKE :notes");
			param.put("notes", "%"+sysStaffQueryPageBO.getNotes()+"%");
		}
	    if (!StringUtils.isBlank(sysStaffQueryPageBO.getExt1())) {
			hqlCondition.append(" AND o.ext1 LIKE :ext1");
			param.put("ext1", "%"+sysStaffQueryPageBO.getExt1()+"%");
		}
	    if (!StringUtils.isBlank(sysStaffQueryPageBO.getExt2())) {
			hqlCondition.append(" AND o.ext2 LIKE :ext2");
			param.put("ext2", "%"+sysStaffQueryPageBO.getExt2()+"%");
		}
	    if (!StringUtils.isBlank(sysStaffQueryPageBO.getExt3())) {
			hqlCondition.append(" AND o.ext3 LIKE :ext3");
			param.put("ext3", "%"+sysStaffQueryPageBO.getExt3()+"%");
		}
	    if (!StringUtils.isBlank(sysStaffQueryPageBO.getAccount4a())) {
			hqlCondition.append(" AND o.account4a LIKE :account4a");
			param.put("account4a", "%"+sysStaffQueryPageBO.getAccount4a()+"%");
		}
	    if (!StringUtils.isBlank(sysStaffQueryPageBO.getAccountCrm())) {
			hqlCondition.append(" AND o.accountCrm LIKE :accountCrm");
			param.put("accountCrm", "%"+sysStaffQueryPageBO.getAccountCrm()+"%");
		}
	    if (!StringUtils.isBlank(sysStaffQueryPageBO.getAccountBoss())) {
			hqlCondition.append(" AND o.accountBoss LIKE :accountBoss");
			param.put("accountBoss", "%"+sysStaffQueryPageBO.getAccountBoss()+"%");
		}
		hql.append(hqlCondition);
		hqlCount.append(hqlCondition);
		hql.append(" ORDER BY o.staffId DESC");
		List<BOSysStaff> boSysStaffs = null;
		Page<SysStaffBO> page = new Page<SysStaffBO>();
		if ((sysStaffQueryPageBO.getPageNo() != null && sysStaffQueryPageBO.getPageNo().compareTo(0) > 0) && (sysStaffQueryPageBO.getPageSize() != null && sysStaffQueryPageBO.getPageSize().compareTo(0) > 0)) {
			Long count = (Long) commonDAO.findSingleResultByJPAQL(hqlCount.toString(), param);
			if (count == null || count.compareTo(0L) <= 0) {
				return page;
			}
			page.setRowCount(count.intValue());
			boSysStaffs = commonDAO.findByJPAQL(hql.toString(), param, sysStaffQueryPageBO.getPageNo(), sysStaffQueryPageBO.getPageSize());
			page.generatePageCount(sysStaffQueryPageBO.getPageSize());
		} else {
			boSysStaffs = commonDAO.findByJPAQL(hql.toString(), param);
		}
		page.setPageData(SysStaffMapper.INSTANCE.domainToBo(boSysStaffs));
		return page;
	}
	
}