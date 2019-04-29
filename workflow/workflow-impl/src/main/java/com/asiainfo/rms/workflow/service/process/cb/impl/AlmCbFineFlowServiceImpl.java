package com.asiainfo.rms.workflow.service.process.cb.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFineFlowBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFineFlowQueryPageBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.cb.BOAlmCbFineFlow;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbFineFlowMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbFineFlowService;

/**
 * 罚款流水
 * 
 * @author joker
 */
@Service("almCbFineFlowService")
@Transactional(rollbackOn = Exception.class)
public class AlmCbFineFlowServiceImpl implements IAlmCbFineFlowService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void deleteByPrimaryKey(Long fineId) throws Exception {
		commonDAO.delete(fineId, BOAlmCbFineFlow.class);
	}
	
	@Override
	public AlmCbFineFlowBO save(AlmCbFineFlowBO almCbFineFlowBO) throws Exception {
		BOAlmCbFineFlow boAlmCbFineFlow = AlmCbFineFlowMapper.INSTANCE.boToDomain(almCbFineFlowBO);
		boAlmCbFineFlow.setCreateTime(new Date());
		boAlmCbFineFlow = commonDAO.saveOrUpdate(boAlmCbFineFlow, BOAlmCbFineFlow.class);
		return AlmCbFineFlowMapper.INSTANCE.domainToBo(boAlmCbFineFlow);
	}
	
	@Override
	public AlmCbFineFlowBO findByPrimaryKey(Long fineId) throws Exception{
		BOAlmCbFineFlow boAlmCbFineFlow = commonDAO.findById(BOAlmCbFineFlow.class, fineId);
		return AlmCbFineFlowMapper.INSTANCE.domainToBo(boAlmCbFineFlow);
	}
	
	@Override
	public AlmCbFineFlowBO update(AlmCbFineFlowBO almCbFineFlowBO) throws Exception {
		BOAlmCbFineFlow boAlmCbFineFlow = AlmCbFineFlowMapper.INSTANCE.boToDomain(almCbFineFlowBO);
		boAlmCbFineFlow = commonDAO.saveOrUpdate(boAlmCbFineFlow, BOAlmCbFineFlow.class);
		return AlmCbFineFlowMapper.INSTANCE.domainToBo(boAlmCbFineFlow);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Page<AlmCbFineFlowBO> findByConds(AlmCbFineFlowQueryPageBO almCbFineFlowQueryPageBO) throws Exception {
		StringBuffer hql = new StringBuffer("SELECT o FROM BOAlmCbFineFlow o WHERE 1 = 1");
		StringBuffer hqlCount = new StringBuffer("SELECT COUNT(o) FROM BOAlmCbFineFlow o WHERE 1 = 1");
		StringBuffer hqlCondition = new StringBuffer();
		Map<String, Object> param = new HashMap<String, Object>();
	    if (almCbFineFlowQueryPageBO.getFineIdBegin() != null) {
			hqlCondition.append(" AND o.fineId >= :fineIdBegin");
			param.put("fineIdBegin", almCbFineFlowQueryPageBO.getFineIdBegin());
		}
	    if (almCbFineFlowQueryPageBO.getFineIdEnd() != null) {
			hqlCondition.append(" AND o.fineId <= :fineIdEnd");
			param.put("fineIdEnd", almCbFineFlowQueryPageBO.getFineIdEnd());
		}
	    if (almCbFineFlowQueryPageBO.getStaffIdBegin() != null) {
			hqlCondition.append(" AND o.staffId >= :staffIdBegin");
			param.put("staffIdBegin", almCbFineFlowQueryPageBO.getStaffIdBegin());
		}
	    if (almCbFineFlowQueryPageBO.getStaffIdEnd() != null) {
			hqlCondition.append(" AND o.staffId <= :staffIdEnd");
			param.put("staffIdEnd", almCbFineFlowQueryPageBO.getStaffIdEnd());
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getStaffName())) {
			hqlCondition.append(" AND o.staffName LIKE :staffName");
			param.put("staffName", "%"+almCbFineFlowQueryPageBO.getStaffName()+"%");
		}
	    if (almCbFineFlowQueryPageBO.getOrganizeIdBegin() != null) {
			hqlCondition.append(" AND o.organizeId >= :organizeIdBegin");
			param.put("organizeIdBegin", almCbFineFlowQueryPageBO.getOrganizeIdBegin());
		}
	    if (almCbFineFlowQueryPageBO.getOrganizeIdEnd() != null) {
			hqlCondition.append(" AND o.organizeId <= :organizeIdEnd");
			param.put("organizeIdEnd", almCbFineFlowQueryPageBO.getOrganizeIdEnd());
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getOrganizeName())) {
			hqlCondition.append(" AND o.organizeName LIKE :organizeName");
			param.put("organizeName", "%"+almCbFineFlowQueryPageBO.getOrganizeName()+"%");
		}
	    if (almCbFineFlowQueryPageBO.getOrganizeTypeBegin() != null) {
			hqlCondition.append(" AND o.organizeType >= :organizeTypeBegin");
			param.put("organizeTypeBegin", almCbFineFlowQueryPageBO.getOrganizeTypeBegin());
		}
	    if (almCbFineFlowQueryPageBO.getOrganizeTypeEnd() != null) {
			hqlCondition.append(" AND o.organizeType <= :organizeTypeEnd");
			param.put("organizeTypeEnd", almCbFineFlowQueryPageBO.getOrganizeTypeEnd());
		}
	    if (almCbFineFlowQueryPageBO.getStationIdBegin() != null) {
			hqlCondition.append(" AND o.stationId >= :stationIdBegin");
			param.put("stationIdBegin", almCbFineFlowQueryPageBO.getStationIdBegin());
		}
	    if (almCbFineFlowQueryPageBO.getStationIdEnd() != null) {
			hqlCondition.append(" AND o.stationId <= :stationIdEnd");
			param.put("stationIdEnd", almCbFineFlowQueryPageBO.getStationIdEnd());
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getStationCode())) {
			hqlCondition.append(" AND o.stationCode LIKE :stationCode");
			param.put("stationCode", "%"+almCbFineFlowQueryPageBO.getStationCode()+"%");
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getStationName())) {
			hqlCondition.append(" AND o.stationName LIKE :stationName");
			param.put("stationName", "%"+almCbFineFlowQueryPageBO.getStationName()+"%");
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getStationNotes())) {
			hqlCondition.append(" AND o.stationNotes LIKE :stationNotes");
			param.put("stationNotes", "%"+almCbFineFlowQueryPageBO.getStationNotes()+"%");
		}
	    if (almCbFineFlowQueryPageBO.getStationTypeBegin() != null) {
			hqlCondition.append(" AND o.stationType >= :stationTypeBegin");
			param.put("stationTypeBegin", almCbFineFlowQueryPageBO.getStationTypeBegin());
		}
	    if (almCbFineFlowQueryPageBO.getStationTypeEnd() != null) {
			hqlCondition.append(" AND o.stationType <= :stationTypeEnd");
			param.put("stationTypeEnd", almCbFineFlowQueryPageBO.getStationTypeEnd());
		}
	    if (almCbFineFlowQueryPageBO.getStationPrivateTypeBegin() != null) {
			hqlCondition.append(" AND o.stationPrivateType >= :stationPrivateTypeBegin");
			param.put("stationPrivateTypeBegin", almCbFineFlowQueryPageBO.getStationPrivateTypeBegin());
		}
	    if (almCbFineFlowQueryPageBO.getStationPrivateTypeEnd() != null) {
			hqlCondition.append(" AND o.stationPrivateType <= :stationPrivateTypeEnd");
			param.put("stationPrivateTypeEnd", almCbFineFlowQueryPageBO.getStationPrivateTypeEnd());
		}
	    if (almCbFineFlowQueryPageBO.getAuthorIdBegin() != null) {
			hqlCondition.append(" AND o.authorId >= :authorIdBegin");
			param.put("authorIdBegin", almCbFineFlowQueryPageBO.getAuthorIdBegin());
		}
	    if (almCbFineFlowQueryPageBO.getAuthorIdEnd() != null) {
			hqlCondition.append(" AND o.authorId <= :authorIdEnd");
			param.put("authorIdEnd", almCbFineFlowQueryPageBO.getAuthorIdEnd());
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getAuthorNotes())) {
			hqlCondition.append(" AND o.authorNotes LIKE :authorNotes");
			param.put("authorNotes", "%"+almCbFineFlowQueryPageBO.getAuthorNotes()+"%");
		}
	    if (almCbFineFlowQueryPageBO.getObjIdBegin() != null) {
			hqlCondition.append(" AND o.objId >= :objIdBegin");
			param.put("objIdBegin", almCbFineFlowQueryPageBO.getObjIdBegin());
		}
	    if (almCbFineFlowQueryPageBO.getObjIdEnd() != null) {
			hqlCondition.append(" AND o.objId <= :objIdEnd");
			param.put("objIdEnd", almCbFineFlowQueryPageBO.getObjIdEnd());
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getObjTag())) {
			hqlCondition.append(" AND o.objTag LIKE :objTag");
			param.put("objTag", "%"+almCbFineFlowQueryPageBO.getObjTag()+"%");
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getObjAccount())) {
			hqlCondition.append(" AND o.objAccount LIKE :objAccount");
			param.put("objAccount", "%"+almCbFineFlowQueryPageBO.getObjAccount()+"%");
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getObjFormula())) {
			hqlCondition.append(" AND o.objFormula LIKE :objFormula");
			param.put("objFormula", "%"+almCbFineFlowQueryPageBO.getObjFormula()+"%");
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getObjAmount())) {
			hqlCondition.append(" AND o.objAmount LIKE :objAmount");
			param.put("objAmount", "%"+almCbFineFlowQueryPageBO.getObjAmount()+"%");
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getObjStaff())) {
			hqlCondition.append(" AND o.objStaff LIKE :objStaff");
			param.put("objStaff", "%"+almCbFineFlowQueryPageBO.getObjStaff()+"%");
		}
	    if (almCbFineFlowQueryPageBO.getIsValidBegin() != null) {
			hqlCondition.append(" AND o.isValid >= :isValidBegin");
			param.put("isValidBegin", almCbFineFlowQueryPageBO.getIsValidBegin());
		}
	    if (almCbFineFlowQueryPageBO.getIsValidEnd() != null) {
			hqlCondition.append(" AND o.isValid <= :isValidEnd");
			param.put("isValidEnd", almCbFineFlowQueryPageBO.getIsValidEnd());
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getUnvalidReason())) {
			hqlCondition.append(" AND o.unvalidReason LIKE :unvalidReason");
			param.put("unvalidReason", "%"+almCbFineFlowQueryPageBO.getUnvalidReason()+"%");
		}
    	java.text.SimpleDateFormat sfCreateTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    if (almCbFineFlowQueryPageBO.getCreateTimeBegin() != null) {
			hqlCondition.append(" AND o.createTime >= to_date('");
			hqlCondition.append(sfCreateTime.format(almCbFineFlowQueryPageBO.getCreateTimeBegin()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (almCbFineFlowQueryPageBO.getCreateTimeEnd() != null) {
			hqlCondition.append(" AND o.createTime <= to_date('");
			hqlCondition.append(sfCreateTime.format(almCbFineFlowQueryPageBO.getCreateTimeEnd()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getFineType())) {
			hqlCondition.append(" AND o.fineType LIKE :fineType");
			param.put("fineType", "%"+almCbFineFlowQueryPageBO.getFineType()+"%");
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getFineMoney())) {
			hqlCondition.append(" AND o.fineMoney LIKE :fineMoney");
			param.put("fineMoney", "%"+almCbFineFlowQueryPageBO.getFineMoney()+"%");
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getFineDesc())) {
			hqlCondition.append(" AND o.fineDesc LIKE :fineDesc");
			param.put("fineDesc", "%"+almCbFineFlowQueryPageBO.getFineDesc()+"%");
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getReduceAdd())) {
			hqlCondition.append(" AND o.reduceAdd LIKE :reduceAdd");
			param.put("reduceAdd", "%"+almCbFineFlowQueryPageBO.getReduceAdd()+"%");
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getFineAmount())) {
			hqlCondition.append(" AND o.fineAmount LIKE :fineAmount");
			param.put("fineAmount", "%"+almCbFineFlowQueryPageBO.getFineAmount()+"%");
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getFineFormula())) {
			hqlCondition.append(" AND o.fineFormula LIKE :fineFormula");
			param.put("fineFormula", "%"+almCbFineFlowQueryPageBO.getFineFormula()+"%");
		}
	    if (!StringUtils.isBlank(almCbFineFlowQueryPageBO.getFineAccount())) {
			hqlCondition.append(" AND o.fineAccount LIKE :fineAccount");
			param.put("fineAccount", "%"+almCbFineFlowQueryPageBO.getFineAccount()+"%");
		}
	    if (almCbFineFlowQueryPageBO.getFlowIdBegin() != null) {
			hqlCondition.append(" AND o.flowId >= :flowIdBegin");
			param.put("flowIdBegin", almCbFineFlowQueryPageBO.getFlowIdBegin());
		}
	    if (almCbFineFlowQueryPageBO.getFlowIdEnd() != null) {
			hqlCondition.append(" AND o.flowId <= :flowIdEnd");
			param.put("flowIdEnd", almCbFineFlowQueryPageBO.getFlowIdEnd());
		}
		hql.append(hqlCondition);
		hqlCount.append(hqlCondition);
		hql.append(" ORDER BY o.fineId DESC");
		List<BOAlmCbFineFlow> boAlmCbFineFlows = null;
		Page<AlmCbFineFlowBO> page = new Page<AlmCbFineFlowBO>();
		if ((almCbFineFlowQueryPageBO.getPageNo() != null && almCbFineFlowQueryPageBO.getPageNo().compareTo(0) > 0) && (almCbFineFlowQueryPageBO.getPageSize() != null && almCbFineFlowQueryPageBO.getPageSize().compareTo(0) > 0)) {
			Long count = (Long) commonDAO.findSingleResultByJPAQL(hqlCount.toString(), param);
			if (count == null || count.compareTo(0L) <= 0) {
				return page;
			}
			page.setRowCount(count.intValue());
			boAlmCbFineFlows = commonDAO.findByJPAQL(hql.toString(), param, almCbFineFlowQueryPageBO.getPageNo(), almCbFineFlowQueryPageBO.getPageSize());
			page.generatePageCount(almCbFineFlowQueryPageBO.getPageSize());
		} else {
			boAlmCbFineFlows = commonDAO.findByJPAQL(hql.toString(), param);
		}
		page.setPageData(AlmCbFineFlowMapper.INSTANCE.domainToBo(boAlmCbFineFlows));
		return page;
	}
	
}