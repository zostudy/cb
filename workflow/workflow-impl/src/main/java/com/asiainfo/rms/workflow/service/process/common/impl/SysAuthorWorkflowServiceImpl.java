package com.asiainfo.rms.workflow.service.process.common.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.SysAuthorWorkflowBO;
import com.asiainfo.rms.workflow.bo.process.common.SysAuthorWorkflowQueryPageBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.common.BOSysAuthorWorkflow;
import com.asiainfo.rms.workflow.mapper.process.common.SysAuthorWorkflowMapper;
import com.asiainfo.rms.workflow.service.process.common.ISysAuthorWorkflowService;

/**
 * 岗位与工作流关联表
 * 
 * @author joker
 */
@Service("sysAuthorWorkflowService")
@Transactional(rollbackOn = Exception.class)
public class SysAuthorWorkflowServiceImpl implements ISysAuthorWorkflowService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void deleteByPrimaryKey(Long sawId) throws Exception {
		commonDAO.delete(sawId, BOSysAuthorWorkflow.class);
	}
	
	@Override
	public SysAuthorWorkflowBO save(SysAuthorWorkflowBO sysAuthorWorkflowBO) throws Exception {
		BOSysAuthorWorkflow boSysAuthorWorkflow = SysAuthorWorkflowMapper.INSTANCE.boToDomain(sysAuthorWorkflowBO);
		boSysAuthorWorkflow = commonDAO.saveOrUpdate(boSysAuthorWorkflow, BOSysAuthorWorkflow.class);
		return SysAuthorWorkflowMapper.INSTANCE.domainToBo(boSysAuthorWorkflow);
	}
	
	@Override
	public SysAuthorWorkflowBO findByPrimaryKey(Long sawId) throws Exception {
		BOSysAuthorWorkflow boSysAuthorWorkflow = commonDAO.findById(BOSysAuthorWorkflow.class, sawId);
		return SysAuthorWorkflowMapper.INSTANCE.domainToBo(boSysAuthorWorkflow);
	}
	
	@Override
	public SysAuthorWorkflowBO update(SysAuthorWorkflowBO sysAuthorWorkflowBO) throws Exception {
		BOSysAuthorWorkflow boSysAuthorWorkflow = SysAuthorWorkflowMapper.INSTANCE.boToDomain(sysAuthorWorkflowBO);
		boSysAuthorWorkflow = commonDAO.saveOrUpdate(boSysAuthorWorkflow, BOSysAuthorWorkflow.class);
		return SysAuthorWorkflowMapper.INSTANCE.domainToBo(boSysAuthorWorkflow);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Page<SysAuthorWorkflowBO> findByConds(SysAuthorWorkflowQueryPageBO sysAuthorWorkflowQueryPageBO) throws Exception {
		StringBuffer hql = new StringBuffer("SELECT o FROM BOSysAuthorWorkflow o WHERE 1 = 1");
		StringBuffer hqlCount = new StringBuffer("SELECT COUNT(o) FROM BOSysAuthorWorkflow o WHERE 1 = 1");
		StringBuffer hqlCondition = new StringBuffer();
		Map<String, Object> param = new HashMap<String, Object>();
	    if (sysAuthorWorkflowQueryPageBO.getSawIdBegin() != null) {
			hqlCondition.append(" AND o.sawId >= :sawIdBegin");
			param.put("sawIdBegin", sysAuthorWorkflowQueryPageBO.getSawIdBegin());
		}
	    if (sysAuthorWorkflowQueryPageBO.getSawIdEnd() != null) {
			hqlCondition.append(" AND o.sawId <= :sawIdEnd");
			param.put("sawIdEnd", sysAuthorWorkflowQueryPageBO.getSawIdEnd());
		}
	    if (sysAuthorWorkflowQueryPageBO.getStaffIdBegin() != null) {
			hqlCondition.append(" AND o.staffId >= :staffIdBegin");
			param.put("staffIdBegin", sysAuthorWorkflowQueryPageBO.getStaffIdBegin());
		}
	    if (sysAuthorWorkflowQueryPageBO.getStaffIdEnd() != null) {
			hqlCondition.append(" AND o.staffId <= :staffIdEnd");
			param.put("staffIdEnd", sysAuthorWorkflowQueryPageBO.getStaffIdEnd());
		}
	    if (!StringUtils.isBlank(sysAuthorWorkflowQueryPageBO.getCode())) {
			hqlCondition.append(" AND o.code LIKE :code");
			param.put("code", "%"+sysAuthorWorkflowQueryPageBO.getCode()+"%");
		}
	    if (!StringUtils.isBlank(sysAuthorWorkflowQueryPageBO.getEmployeeName())) {
			hqlCondition.append(" AND o.employeeName LIKE :employeeName");
			param.put("employeeName", "%"+sysAuthorWorkflowQueryPageBO.getEmployeeName()+"%");
		}
	    if (!StringUtils.isBlank(sysAuthorWorkflowQueryPageBO.getBillId())) {
			hqlCondition.append(" AND o.billId LIKE :billId");
			param.put("billId", "%"+sysAuthorWorkflowQueryPageBO.getBillId()+"%");
		}
	    if (sysAuthorWorkflowQueryPageBO.getOrganizeIdBegin() != null) {
			hqlCondition.append(" AND o.organizeId >= :organizeIdBegin");
			param.put("organizeIdBegin", sysAuthorWorkflowQueryPageBO.getOrganizeIdBegin());
		}
	    if (sysAuthorWorkflowQueryPageBO.getOrganizeIdEnd() != null) {
			hqlCondition.append(" AND o.organizeId <= :organizeIdEnd");
			param.put("organizeIdEnd", sysAuthorWorkflowQueryPageBO.getOrganizeIdEnd());
		}
	    if (!StringUtils.isBlank(sysAuthorWorkflowQueryPageBO.getOrganizeName())) {
			hqlCondition.append(" AND o.organizeName LIKE :organizeName");
			param.put("organizeName", "%"+sysAuthorWorkflowQueryPageBO.getOrganizeName()+"%");
		}
	    if (sysAuthorWorkflowQueryPageBO.getOrgTypeBegin() != null) {
			hqlCondition.append(" AND o.orgType >= :orgTypeBegin");
			param.put("orgTypeBegin", sysAuthorWorkflowQueryPageBO.getOrgTypeBegin());
		}
	    if (sysAuthorWorkflowQueryPageBO.getOrgTypeEnd() != null) {
			hqlCondition.append(" AND o.orgType <= :orgTypeEnd");
			param.put("orgTypeEnd", sysAuthorWorkflowQueryPageBO.getOrgTypeEnd());
		}
    	java.text.SimpleDateFormat sfCreateDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    if (sysAuthorWorkflowQueryPageBO.getCreateDateBegin() != null) {
			hqlCondition.append(" AND o.createDate >= to_date('");
			hqlCondition.append(sfCreateDate.format(sysAuthorWorkflowQueryPageBO.getCreateDateBegin()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (sysAuthorWorkflowQueryPageBO.getCreateDateEnd() != null) {
			hqlCondition.append(" AND o.createDate <= to_date('");
			hqlCondition.append(sfCreateDate.format(sysAuthorWorkflowQueryPageBO.getCreateDateEnd()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
    	java.text.SimpleDateFormat sfEndDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    if (sysAuthorWorkflowQueryPageBO.getEndDateBegin() != null) {
			hqlCondition.append(" AND o.endDate >= to_date('");
			hqlCondition.append(sfEndDate.format(sysAuthorWorkflowQueryPageBO.getEndDateBegin()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (sysAuthorWorkflowQueryPageBO.getEndDateEnd() != null) {
			hqlCondition.append(" AND o.endDate <= to_date('");
			hqlCondition.append(sfEndDate.format(sysAuthorWorkflowQueryPageBO.getEndDateEnd()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (sysAuthorWorkflowQueryPageBO.getStationIdBegin() != null) {
			hqlCondition.append(" AND o.stationId >= :stationIdBegin");
			param.put("stationIdBegin", sysAuthorWorkflowQueryPageBO.getStationIdBegin());
		}
	    if (sysAuthorWorkflowQueryPageBO.getStationIdEnd() != null) {
			hqlCondition.append(" AND o.stationId <= :stationIdEnd");
			param.put("stationIdEnd", sysAuthorWorkflowQueryPageBO.getStationIdEnd());
		}
	    if (!StringUtils.isBlank(sysAuthorWorkflowQueryPageBO.getName())) {
			hqlCondition.append(" AND o.name LIKE :name");
			param.put("name", "%"+sysAuthorWorkflowQueryPageBO.getName()+"%");
		}
	    if (!StringUtils.isBlank(sysAuthorWorkflowQueryPageBO.getNotes())) {
			hqlCondition.append(" AND o.notes LIKE :notes");
			param.put("notes", "%"+sysAuthorWorkflowQueryPageBO.getNotes()+"%");
		}
	    if (!StringUtils.isBlank(sysAuthorWorkflowQueryPageBO.getObjType())) {
			hqlCondition.append(" AND o.objType LIKE :objType");
			param.put("objType", "%"+sysAuthorWorkflowQueryPageBO.getObjType()+"%");
		}
	    if (sysAuthorWorkflowQueryPageBO.getObjIdBegin() != null) {
			hqlCondition.append(" AND o.objId >= :objIdBegin");
			param.put("objIdBegin", sysAuthorWorkflowQueryPageBO.getObjIdBegin());
		}
	    if (sysAuthorWorkflowQueryPageBO.getObjIdEnd() != null) {
			hqlCondition.append(" AND o.objId <= :objIdEnd");
			param.put("objIdEnd", sysAuthorWorkflowQueryPageBO.getObjIdEnd());
		}
	    if (sysAuthorWorkflowQueryPageBO.getLinkIdBegin() != null) {
			hqlCondition.append(" AND o.linkId >= :linkIdBegin");
			param.put("linkIdBegin", sysAuthorWorkflowQueryPageBO.getLinkIdBegin());
		}
	    if (sysAuthorWorkflowQueryPageBO.getLinkIdEnd() != null) {
			hqlCondition.append(" AND o.linkId <= :linkIdEnd");
			param.put("linkIdEnd", sysAuthorWorkflowQueryPageBO.getLinkIdEnd());
		}
	    if (!StringUtils.isBlank(sysAuthorWorkflowQueryPageBO.getLinkNo())) {
			hqlCondition.append(" AND o.linkNo LIKE :linkNo");
			param.put("linkNo", "%"+sysAuthorWorkflowQueryPageBO.getLinkNo()+"%");
		}
	    if (!StringUtils.isBlank(sysAuthorWorkflowQueryPageBO.getPhaseId())) {
			hqlCondition.append(" AND o.phaseId LIKE :phaseId");
			param.put("phaseId", "%"+sysAuthorWorkflowQueryPageBO.getPhaseId()+"%");
		}
	    if (!StringUtils.isBlank(sysAuthorWorkflowQueryPageBO.getPhaseName())) {
			hqlCondition.append(" AND o.phaseName LIKE :phaseName");
			param.put("phaseName", "%"+sysAuthorWorkflowQueryPageBO.getPhaseName()+"%");
		}
	    if (!StringUtils.isBlank(sysAuthorWorkflowQueryPageBO.getObjTag())) {
			hqlCondition.append(" AND o.objTag LIKE :objTag");
			param.put("objTag", "%"+sysAuthorWorkflowQueryPageBO.getObjTag()+"%");
		}
	    if (!StringUtils.isBlank(sysAuthorWorkflowQueryPageBO.getStationMoney())) {
			hqlCondition.append(" AND o.stationMoney LIKE :stationMoney");
			param.put("stationMoney", "%"+sysAuthorWorkflowQueryPageBO.getStationMoney()+"%");
		}
	    if (!StringUtils.isBlank(sysAuthorWorkflowQueryPageBO.getStationAmount())) {
			hqlCondition.append(" AND o.stationAmount LIKE :stationAmount");
			param.put("stationAmount", "%"+sysAuthorWorkflowQueryPageBO.getStationAmount()+"%");
		}
	    if (!StringUtils.isBlank(sysAuthorWorkflowQueryPageBO.getStationAggregate())) {
			hqlCondition.append(" AND o.stationAggregate LIKE :stationAggregate");
			param.put("stationAggregate", "%"+sysAuthorWorkflowQueryPageBO.getStationAggregate()+"%");
		}
	    if (sysAuthorWorkflowQueryPageBO.getTypeBegin() != null) {
			hqlCondition.append(" AND o.type >= :typeBegin");
			param.put("typeBegin", sysAuthorWorkflowQueryPageBO.getTypeBegin());
		}
	    if (sysAuthorWorkflowQueryPageBO.getTypeEnd() != null) {
			hqlCondition.append(" AND o.type <= :typeEnd");
			param.put("typeEnd", sysAuthorWorkflowQueryPageBO.getTypeEnd());
		}
	    if (!StringUtils.isBlank(sysAuthorWorkflowQueryPageBO.getStationPeople())) {
			hqlCondition.append(" AND o.stationPeople LIKE :stationPeople");
			param.put("stationPeople", "%"+sysAuthorWorkflowQueryPageBO.getStationPeople()+"%");
		}
		hql.append(hqlCondition);
		hqlCount.append(hqlCondition);
		hql.append(" ORDER BY o.sawId DESC");
		List<BOSysAuthorWorkflow> boSysAuthorWorkflows = null;
		Page<SysAuthorWorkflowBO> page = new Page<SysAuthorWorkflowBO>();
		if ((sysAuthorWorkflowQueryPageBO.getPageNo() != null && sysAuthorWorkflowQueryPageBO.getPageNo().compareTo(0) > 0) && (sysAuthorWorkflowQueryPageBO.getPageSize() != null && sysAuthorWorkflowQueryPageBO.getPageSize().compareTo(0) > 0)) {
			Long count = (Long) commonDAO.findSingleResultByJPAQL(hqlCount.toString(), param);
			if (count == null || count.compareTo(0L) <= 0) {
				return page;
			}
			page.setRowCount(count.intValue());
			boSysAuthorWorkflows = commonDAO.findByJPAQL(hql.toString(), param, sysAuthorWorkflowQueryPageBO.getPageNo(), sysAuthorWorkflowQueryPageBO.getPageSize());
			page.generatePageCount(sysAuthorWorkflowQueryPageBO.getPageSize());
		} else {
			boSysAuthorWorkflows = commonDAO.findByJPAQL(hql.toString(), param);
		}
		page.setPageData(SysAuthorWorkflowMapper.INSTANCE.domainToBo(boSysAuthorWorkflows));
		return page;
	}
	
}