package com.asiainfo.rms.workflow.service.process.cb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFlowBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFlowQueryPageBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.cb.BOAlmCbFlow;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbFlowMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbFlowService;

/**
 * 流水表
 * 
 * @author joker
 */
@Service("almCbFlowService")
@Transactional(rollbackOn = Exception.class)
public class AlmCbFlowServiceImpl implements IAlmCbFlowService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void deleteByPrimaryKey(Long flowId) throws Exception {
		commonDAO.delete(flowId, BOAlmCbFlow.class);
	}
	
	@Override
	public AlmCbFlowBO save(AlmCbFlowBO almCbFlowBO) throws Exception {
		BOAlmCbFlow boAlmCbFlow = AlmCbFlowMapper.INSTANCE.boToDomain(almCbFlowBO);
		boAlmCbFlow = commonDAO.saveOrUpdate(boAlmCbFlow, BOAlmCbFlow.class);
		return AlmCbFlowMapper.INSTANCE.domainToBo(boAlmCbFlow);
	}
	
	@Override
	public AlmCbFlowBO findByPrimaryKey(Long flowId) throws Exception{
		BOAlmCbFlow boAlmCbFlow = commonDAO.findById(BOAlmCbFlow.class, flowId);
		return AlmCbFlowMapper.INSTANCE.domainToBo(boAlmCbFlow);
	}
	
	@Override
	public AlmCbFlowBO update(AlmCbFlowBO almCbFlowBO) throws Exception {
		BOAlmCbFlow boAlmCbFlow = AlmCbFlowMapper.INSTANCE.boToDomain(almCbFlowBO);
		boAlmCbFlow = commonDAO.saveOrUpdate(boAlmCbFlow, BOAlmCbFlow.class);
		return AlmCbFlowMapper.INSTANCE.domainToBo(boAlmCbFlow);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Page<AlmCbFlowBO> findByConds(AlmCbFlowQueryPageBO almCbFlowQueryPageBO) throws Exception {
		StringBuffer hql = new StringBuffer("SELECT o FROM BOAlmCbFlow o WHERE 1 = 1");
		StringBuffer hqlCount = new StringBuffer("SELECT COUNT(o) FROM BOAlmCbFlow o WHERE 1 = 1");
		StringBuffer hqlCondition = new StringBuffer();
		Map<String, Object> param = new HashMap<String, Object>();
	    if (almCbFlowQueryPageBO.getFlowIdBegin() != null) {
			hqlCondition.append(" AND o.flowId >= :flowIdBegin");
			param.put("flowIdBegin", almCbFlowQueryPageBO.getFlowIdBegin());
		}
	    if (almCbFlowQueryPageBO.getFlowIdEnd() != null) {
			hqlCondition.append(" AND o.flowId <= :flowIdEnd");
			param.put("flowIdEnd", almCbFlowQueryPageBO.getFlowIdEnd());
		}
	    if (almCbFlowQueryPageBO.getStaffIdBegin() != null) {
			hqlCondition.append(" AND o.staffId >= :staffIdBegin");
			param.put("staffIdBegin", almCbFlowQueryPageBO.getStaffIdBegin());
		}
	    if (almCbFlowQueryPageBO.getStaffIdEnd() != null) {
			hqlCondition.append(" AND o.staffId <= :staffIdEnd");
			param.put("staffIdEnd", almCbFlowQueryPageBO.getStaffIdEnd());
		}
	    if (!StringUtils.isBlank(almCbFlowQueryPageBO.getStaffName())) {
			hqlCondition.append(" AND o.staffName LIKE :staffName");
			param.put("staffName", "%"+almCbFlowQueryPageBO.getStaffName()+"%");
		}
	    if (almCbFlowQueryPageBO.getOrganizeIdBegin() != null) {
			hqlCondition.append(" AND o.organizeId >= :organizeIdBegin");
			param.put("organizeIdBegin", almCbFlowQueryPageBO.getOrganizeIdBegin());
		}
	    if (almCbFlowQueryPageBO.getOrganizeIdEnd() != null) {
			hqlCondition.append(" AND o.organizeId <= :organizeIdEnd");
			param.put("organizeIdEnd", almCbFlowQueryPageBO.getOrganizeIdEnd());
		}
	    if (!StringUtils.isBlank(almCbFlowQueryPageBO.getOrganizeName())) {
			hqlCondition.append(" AND o.organizeName LIKE :organizeName");
			param.put("organizeName", "%"+almCbFlowQueryPageBO.getOrganizeName()+"%");
		}
	    if (almCbFlowQueryPageBO.getOrganizeTypeBegin() != null) {
			hqlCondition.append(" AND o.organizeType >= :organizeTypeBegin");
			param.put("organizeTypeBegin", almCbFlowQueryPageBO.getOrganizeTypeBegin());
		}
	    if (almCbFlowQueryPageBO.getOrganizeTypeEnd() != null) {
			hqlCondition.append(" AND o.organizeType <= :organizeTypeEnd");
			param.put("organizeTypeEnd", almCbFlowQueryPageBO.getOrganizeTypeEnd());
		}
	    if (almCbFlowQueryPageBO.getStationIdBegin() != null) {
			hqlCondition.append(" AND o.stationId >= :stationIdBegin");
			param.put("stationIdBegin", almCbFlowQueryPageBO.getStationIdBegin());
		}
	    if (almCbFlowQueryPageBO.getStationIdEnd() != null) {
			hqlCondition.append(" AND o.stationId <= :stationIdEnd");
			param.put("stationIdEnd", almCbFlowQueryPageBO.getStationIdEnd());
		}
	    if (!StringUtils.isBlank(almCbFlowQueryPageBO.getStationCode())) {
			hqlCondition.append(" AND o.stationCode LIKE :stationCode");
			param.put("stationCode", "%"+almCbFlowQueryPageBO.getStationCode()+"%");
		}
	    if (!StringUtils.isBlank(almCbFlowQueryPageBO.getStationName())) {
			hqlCondition.append(" AND o.stationName LIKE :stationName");
			param.put("stationName", "%"+almCbFlowQueryPageBO.getStationName()+"%");
		}
	    if (!StringUtils.isBlank(almCbFlowQueryPageBO.getStationNotes())) {
			hqlCondition.append(" AND o.stationNotes LIKE :stationNotes");
			param.put("stationNotes", "%"+almCbFlowQueryPageBO.getStationNotes()+"%");
		}
	    if (almCbFlowQueryPageBO.getStationTypeBegin() != null) {
			hqlCondition.append(" AND o.stationType >= :stationTypeBegin");
			param.put("stationTypeBegin", almCbFlowQueryPageBO.getStationTypeBegin());
		}
	    if (almCbFlowQueryPageBO.getStationTypeEnd() != null) {
			hqlCondition.append(" AND o.stationType <= :stationTypeEnd");
			param.put("stationTypeEnd", almCbFlowQueryPageBO.getStationTypeEnd());
		}
	    if (almCbFlowQueryPageBO.getStationPrivateTypeBegin() != null) {
			hqlCondition.append(" AND o.stationPrivateType >= :stationPrivateTypeBegin");
			param.put("stationPrivateTypeBegin", almCbFlowQueryPageBO.getStationPrivateTypeBegin());
		}
	    if (almCbFlowQueryPageBO.getStationPrivateTypeEnd() != null) {
			hqlCondition.append(" AND o.stationPrivateType <= :stationPrivateTypeEnd");
			param.put("stationPrivateTypeEnd", almCbFlowQueryPageBO.getStationPrivateTypeEnd());
		}
	    if (almCbFlowQueryPageBO.getAuthorIdBegin() != null) {
			hqlCondition.append(" AND o.authorId >= :authorIdBegin");
			param.put("authorIdBegin", almCbFlowQueryPageBO.getAuthorIdBegin());
		}
	    if (almCbFlowQueryPageBO.getAuthorIdEnd() != null) {
			hqlCondition.append(" AND o.authorId <= :authorIdEnd");
			param.put("authorIdEnd", almCbFlowQueryPageBO.getAuthorIdEnd());
		}
	    if (!StringUtils.isBlank(almCbFlowQueryPageBO.getAuthorNotes())) {
			hqlCondition.append(" AND o.authorNotes LIKE :authorNotes");
			param.put("authorNotes", "%"+almCbFlowQueryPageBO.getAuthorNotes()+"%");
		}
	    if (almCbFlowQueryPageBO.getObjIdBegin() != null) {
			hqlCondition.append(" AND o.objId >= :objIdBegin");
			param.put("objIdBegin", almCbFlowQueryPageBO.getObjIdBegin());
		}
	    if (almCbFlowQueryPageBO.getObjIdEnd() != null) {
			hqlCondition.append(" AND o.objId <= :objIdEnd");
			param.put("objIdEnd", almCbFlowQueryPageBO.getObjIdEnd());
		}
	    if (!StringUtils.isBlank(almCbFlowQueryPageBO.getObjTag())) {
			hqlCondition.append(" AND o.objTag LIKE :objTag");
			param.put("objTag", "%"+almCbFlowQueryPageBO.getObjTag()+"%");
		}
	    if (!StringUtils.isBlank(almCbFlowQueryPageBO.getObjAccount())) {
			hqlCondition.append(" AND o.objAccount LIKE :objAccount");
			param.put("objAccount", "%"+almCbFlowQueryPageBO.getObjAccount()+"%");
		}
	    if (!StringUtils.isBlank(almCbFlowQueryPageBO.getObjFormula())) {
			hqlCondition.append(" AND o.objFormula LIKE :objFormula");
			param.put("objFormula", "%"+almCbFlowQueryPageBO.getObjFormula()+"%");
		}
	    if (!StringUtils.isBlank(almCbFlowQueryPageBO.getObjAmount())) {
			hqlCondition.append(" AND o.objAmount LIKE :objAmount");
			param.put("objAmount", "%"+almCbFlowQueryPageBO.getObjAmount()+"%");
		}
	    if (!StringUtils.isBlank(almCbFlowQueryPageBO.getObjStaff())) {
			hqlCondition.append(" AND o.objStaff LIKE :objStaff");
			param.put("objStaff", "%"+almCbFlowQueryPageBO.getObjStaff()+"%");
		}
	    if (almCbFlowQueryPageBO.getIsValidBegin() != null) {
			hqlCondition.append(" AND o.isValid >= :isValidBegin");
			param.put("isValidBegin", almCbFlowQueryPageBO.getIsValidBegin());
		}
	    if (almCbFlowQueryPageBO.getIsValidEnd() != null) {
			hqlCondition.append(" AND o.isValid <= :isValidEnd");
			param.put("isValidEnd", almCbFlowQueryPageBO.getIsValidEnd());
		}
	    if (!StringUtils.isBlank(almCbFlowQueryPageBO.getUnvalidReason())) {
			hqlCondition.append(" AND o.unvalidReason LIKE :unvalidReason");
			param.put("unvalidReason", "%"+almCbFlowQueryPageBO.getUnvalidReason()+"%");
		}
    	java.text.SimpleDateFormat sfCreateTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    if (almCbFlowQueryPageBO.getCreateTimeBegin() != null) {
			hqlCondition.append(" AND o.createTime >= to_date('");
			hqlCondition.append(sfCreateTime.format(almCbFlowQueryPageBO.getCreateTimeBegin()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (almCbFlowQueryPageBO.getCreateTimeEnd() != null) {
			hqlCondition.append(" AND o.createTime <= to_date('");
			hqlCondition.append(sfCreateTime.format(almCbFlowQueryPageBO.getCreateTimeEnd()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
		hql.append(hqlCondition);
		hqlCount.append(hqlCondition);
		hql.append(" ORDER BY o.flowId DESC");
		List<BOAlmCbFlow> boAlmCbFlows = null;
		Page<AlmCbFlowBO> page = new Page<AlmCbFlowBO>();
		if ((almCbFlowQueryPageBO.getPageNo() != null && almCbFlowQueryPageBO.getPageNo().compareTo(0) > 0) && (almCbFlowQueryPageBO.getPageSize() != null && almCbFlowQueryPageBO.getPageSize().compareTo(0) > 0)) {
			Long count = (Long) commonDAO.findSingleResultByJPAQL(hqlCount.toString(), param);
			if (count == null || count.compareTo(0L) <= 0) {
				return page;
			}
			page.setRowCount(count.intValue());
			boAlmCbFlows = commonDAO.findByJPAQL(hql.toString(), param, almCbFlowQueryPageBO.getPageNo(), almCbFlowQueryPageBO.getPageSize());
			page.generatePageCount(almCbFlowQueryPageBO.getPageSize());
		} else {
			boAlmCbFlows = commonDAO.findByJPAQL(hql.toString(), param);
		}
		page.setPageData(AlmCbFlowMapper.INSTANCE.domainToBo(boAlmCbFlows));
		return page;
	}
	
}