package com.asiainfo.rms.workflow.service.process.cb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFlowHisBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbFlowHisQueryPageBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.cb.BOAlmCbFlowHis;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbFlowHisMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbFlowHisService;

/**
 * 详情表
 * 
 * @author joker
 */
@Service("almCbFlowHisService")
@Transactional(rollbackOn = Exception.class)
public class AlmCbFlowHisServiceImpl implements IAlmCbFlowHisService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void deleteByPrimaryKey(Long hisFlowId) throws Exception {
		commonDAO.delete(hisFlowId, BOAlmCbFlowHis.class);
	}
	
	@Override
	public AlmCbFlowHisBO save(AlmCbFlowHisBO almCbFlowHisBO) throws Exception {
		BOAlmCbFlowHis boAlmCbFlowHis = AlmCbFlowHisMapper.INSTANCE.boToDomain(almCbFlowHisBO);
		boAlmCbFlowHis = commonDAO.saveOrUpdate(boAlmCbFlowHis, BOAlmCbFlowHis.class);
		return AlmCbFlowHisMapper.INSTANCE.domainToBo(boAlmCbFlowHis);
	}
	
	@Override
	public AlmCbFlowHisBO findByPrimaryKey(Long hisFlowId) throws Exception{
		BOAlmCbFlowHis boAlmCbFlowHis = commonDAO.findById(BOAlmCbFlowHis.class, hisFlowId);
		return AlmCbFlowHisMapper.INSTANCE.domainToBo(boAlmCbFlowHis);
	}
	
	@Override
	public AlmCbFlowHisBO update(AlmCbFlowHisBO almCbFlowHisBO) throws Exception {
		BOAlmCbFlowHis boAlmCbFlowHis = AlmCbFlowHisMapper.INSTANCE.boToDomain(almCbFlowHisBO);
		boAlmCbFlowHis = commonDAO.saveOrUpdate(boAlmCbFlowHis, BOAlmCbFlowHis.class);
		return AlmCbFlowHisMapper.INSTANCE.domainToBo(boAlmCbFlowHis);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Page<AlmCbFlowHisBO> findByConds(AlmCbFlowHisQueryPageBO almCbFlowHisQueryPageBO) throws Exception {
		StringBuffer hql = new StringBuffer("SELECT o FROM BOAlmCbFlowHis o WHERE 1 = 1");
		StringBuffer hqlCount = new StringBuffer("SELECT COUNT(o) FROM BOAlmCbFlowHis o WHERE 1 = 1");
		StringBuffer hqlCondition = new StringBuffer();
		Map<String, Object> param = new HashMap<String, Object>();
	    if (almCbFlowHisQueryPageBO.getHisFlowIdBegin() != null) {
			hqlCondition.append(" AND o.hisFlowId >= :hisFlowIdBegin");
			param.put("hisFlowIdBegin", almCbFlowHisQueryPageBO.getHisFlowIdBegin());
		}
	    if (almCbFlowHisQueryPageBO.getHisFlowIdEnd() != null) {
			hqlCondition.append(" AND o.hisFlowId <= :hisFlowIdEnd");
			param.put("hisFlowIdEnd", almCbFlowHisQueryPageBO.getHisFlowIdEnd());
		}
	    if (almCbFlowHisQueryPageBO.getFlowIdBegin() != null) {
			hqlCondition.append(" AND o.flowId >= :flowIdBegin");
			param.put("flowIdBegin", almCbFlowHisQueryPageBO.getFlowIdBegin());
		}
	    if (almCbFlowHisQueryPageBO.getFlowIdEnd() != null) {
			hqlCondition.append(" AND o.flowId <= :flowIdEnd");
			param.put("flowIdEnd", almCbFlowHisQueryPageBO.getFlowIdEnd());
		}
	    if (almCbFlowHisQueryPageBO.getStaffIdBegin() != null) {
			hqlCondition.append(" AND o.staffId >= :staffIdBegin");
			param.put("staffIdBegin", almCbFlowHisQueryPageBO.getStaffIdBegin());
		}
	    if (almCbFlowHisQueryPageBO.getStaffIdEnd() != null) {
			hqlCondition.append(" AND o.staffId <= :staffIdEnd");
			param.put("staffIdEnd", almCbFlowHisQueryPageBO.getStaffIdEnd());
		}
	    if (!StringUtils.isBlank(almCbFlowHisQueryPageBO.getStaffName())) {
			hqlCondition.append(" AND o.staffName LIKE :staffName");
			param.put("staffName", "%"+almCbFlowHisQueryPageBO.getStaffName()+"%");
		}
	    if (almCbFlowHisQueryPageBO.getOrganizeIdBegin() != null) {
			hqlCondition.append(" AND o.organizeId >= :organizeIdBegin");
			param.put("organizeIdBegin", almCbFlowHisQueryPageBO.getOrganizeIdBegin());
		}
	    if (almCbFlowHisQueryPageBO.getOrganizeIdEnd() != null) {
			hqlCondition.append(" AND o.organizeId <= :organizeIdEnd");
			param.put("organizeIdEnd", almCbFlowHisQueryPageBO.getOrganizeIdEnd());
		}
	    if (!StringUtils.isBlank(almCbFlowHisQueryPageBO.getOrganizeName())) {
			hqlCondition.append(" AND o.organizeName LIKE :organizeName");
			param.put("organizeName", "%"+almCbFlowHisQueryPageBO.getOrganizeName()+"%");
		}
	    if (almCbFlowHisQueryPageBO.getOrganizeTypeBegin() != null) {
			hqlCondition.append(" AND o.organizeType >= :organizeTypeBegin");
			param.put("organizeTypeBegin", almCbFlowHisQueryPageBO.getOrganizeTypeBegin());
		}
	    if (almCbFlowHisQueryPageBO.getOrganizeTypeEnd() != null) {
			hqlCondition.append(" AND o.organizeType <= :organizeTypeEnd");
			param.put("organizeTypeEnd", almCbFlowHisQueryPageBO.getOrganizeTypeEnd());
		}
	    if (almCbFlowHisQueryPageBO.getStationIdBegin() != null) {
			hqlCondition.append(" AND o.stationId >= :stationIdBegin");
			param.put("stationIdBegin", almCbFlowHisQueryPageBO.getStationIdBegin());
		}
	    if (almCbFlowHisQueryPageBO.getStationIdEnd() != null) {
			hqlCondition.append(" AND o.stationId <= :stationIdEnd");
			param.put("stationIdEnd", almCbFlowHisQueryPageBO.getStationIdEnd());
		}
	    if (!StringUtils.isBlank(almCbFlowHisQueryPageBO.getStationCode())) {
			hqlCondition.append(" AND o.stationCode LIKE :stationCode");
			param.put("stationCode", "%"+almCbFlowHisQueryPageBO.getStationCode()+"%");
		}
	    if (!StringUtils.isBlank(almCbFlowHisQueryPageBO.getStationName())) {
			hqlCondition.append(" AND o.stationName LIKE :stationName");
			param.put("stationName", "%"+almCbFlowHisQueryPageBO.getStationName()+"%");
		}
	    if (!StringUtils.isBlank(almCbFlowHisQueryPageBO.getStationNotes())) {
			hqlCondition.append(" AND o.stationNotes LIKE :stationNotes");
			param.put("stationNotes", "%"+almCbFlowHisQueryPageBO.getStationNotes()+"%");
		}
	    if (almCbFlowHisQueryPageBO.getStationTypeBegin() != null) {
			hqlCondition.append(" AND o.stationType >= :stationTypeBegin");
			param.put("stationTypeBegin", almCbFlowHisQueryPageBO.getStationTypeBegin());
		}
	    if (almCbFlowHisQueryPageBO.getStationTypeEnd() != null) {
			hqlCondition.append(" AND o.stationType <= :stationTypeEnd");
			param.put("stationTypeEnd", almCbFlowHisQueryPageBO.getStationTypeEnd());
		}
	    if (almCbFlowHisQueryPageBO.getStationPrivateTypeBegin() != null) {
			hqlCondition.append(" AND o.stationPrivateType >= :stationPrivateTypeBegin");
			param.put("stationPrivateTypeBegin", almCbFlowHisQueryPageBO.getStationPrivateTypeBegin());
		}
	    if (almCbFlowHisQueryPageBO.getStationPrivateTypeEnd() != null) {
			hqlCondition.append(" AND o.stationPrivateType <= :stationPrivateTypeEnd");
			param.put("stationPrivateTypeEnd", almCbFlowHisQueryPageBO.getStationPrivateTypeEnd());
		}
	    if (almCbFlowHisQueryPageBO.getAuthorIdBegin() != null) {
			hqlCondition.append(" AND o.authorId >= :authorIdBegin");
			param.put("authorIdBegin", almCbFlowHisQueryPageBO.getAuthorIdBegin());
		}
	    if (almCbFlowHisQueryPageBO.getAuthorIdEnd() != null) {
			hqlCondition.append(" AND o.authorId <= :authorIdEnd");
			param.put("authorIdEnd", almCbFlowHisQueryPageBO.getAuthorIdEnd());
		}
	    if (!StringUtils.isBlank(almCbFlowHisQueryPageBO.getAuthorNotes())) {
			hqlCondition.append(" AND o.authorNotes LIKE :authorNotes");
			param.put("authorNotes", "%"+almCbFlowHisQueryPageBO.getAuthorNotes()+"%");
		}
	    if (almCbFlowHisQueryPageBO.getObjIdBegin() != null) {
			hqlCondition.append(" AND o.objId >= :objIdBegin");
			param.put("objIdBegin", almCbFlowHisQueryPageBO.getObjIdBegin());
		}
	    if (almCbFlowHisQueryPageBO.getObjIdEnd() != null) {
			hqlCondition.append(" AND o.objId <= :objIdEnd");
			param.put("objIdEnd", almCbFlowHisQueryPageBO.getObjIdEnd());
		}
	    if (!StringUtils.isBlank(almCbFlowHisQueryPageBO.getObjTag())) {
			hqlCondition.append(" AND o.objTag LIKE :objTag");
			param.put("objTag", "%"+almCbFlowHisQueryPageBO.getObjTag()+"%");
		}
	    if (!StringUtils.isBlank(almCbFlowHisQueryPageBO.getObjAccount())) {
			hqlCondition.append(" AND o.objAccount LIKE :objAccount");
			param.put("objAccount", "%"+almCbFlowHisQueryPageBO.getObjAccount()+"%");
		}
	    if (!StringUtils.isBlank(almCbFlowHisQueryPageBO.getObjFormula())) {
			hqlCondition.append(" AND o.objFormula LIKE :objFormula");
			param.put("objFormula", "%"+almCbFlowHisQueryPageBO.getObjFormula()+"%");
		}
	    if (!StringUtils.isBlank(almCbFlowHisQueryPageBO.getObjAmount())) {
			hqlCondition.append(" AND o.objAmount LIKE :objAmount");
			param.put("objAmount", "%"+almCbFlowHisQueryPageBO.getObjAmount()+"%");
		}
	    if (!StringUtils.isBlank(almCbFlowHisQueryPageBO.getObjStaff())) {
			hqlCondition.append(" AND o.objStaff LIKE :objStaff");
			param.put("objStaff", "%"+almCbFlowHisQueryPageBO.getObjStaff()+"%");
		}
    	java.text.SimpleDateFormat sfCreateTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    if (almCbFlowHisQueryPageBO.getCreateTimeBegin() != null) {
			hqlCondition.append(" AND o.createTime >= to_date('");
			hqlCondition.append(sfCreateTime.format(almCbFlowHisQueryPageBO.getCreateTimeBegin()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (almCbFlowHisQueryPageBO.getCreateTimeEnd() != null) {
			hqlCondition.append(" AND o.createTime <= to_date('");
			hqlCondition.append(sfCreateTime.format(almCbFlowHisQueryPageBO.getCreateTimeEnd()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (almCbFlowHisQueryPageBO.getAppalyStaffIdBegin() != null) {
			hqlCondition.append(" AND o.appalyStaffId >= :appalyStaffIdBegin");
			param.put("appalyStaffIdBegin", almCbFlowHisQueryPageBO.getAppalyStaffIdBegin());
		}
	    if (almCbFlowHisQueryPageBO.getAppalyStaffIdEnd() != null) {
			hqlCondition.append(" AND o.appalyStaffId <= :appalyStaffIdEnd");
			param.put("appalyStaffIdEnd", almCbFlowHisQueryPageBO.getAppalyStaffIdEnd());
		}
	    if (!StringUtils.isBlank(almCbFlowHisQueryPageBO.getAppalyStaffName())) {
			hqlCondition.append(" AND o.appalyStaffName LIKE :appalyStaffName");
			param.put("appalyStaffName", "%"+almCbFlowHisQueryPageBO.getAppalyStaffName()+"%");
		}
	    if (!StringUtils.isBlank(almCbFlowHisQueryPageBO.getAppalyStaffCode())) {
			hqlCondition.append(" AND o.appalyStaffCode LIKE :appalyStaffCode");
			param.put("appalyStaffCode", "%"+almCbFlowHisQueryPageBO.getAppalyStaffCode()+"%");
		}
		hql.append(hqlCondition);
		hqlCount.append(hqlCondition);
		hql.append(" ORDER BY o.hisFlowId DESC");
		List<BOAlmCbFlowHis> boAlmCbFlowHiss = null;
		Page<AlmCbFlowHisBO> page = new Page<AlmCbFlowHisBO>();
		if ((almCbFlowHisQueryPageBO.getPageNo() != null && almCbFlowHisQueryPageBO.getPageNo().compareTo(0) > 0) && (almCbFlowHisQueryPageBO.getPageSize() != null && almCbFlowHisQueryPageBO.getPageSize().compareTo(0) > 0)) {
			Long count = (Long) commonDAO.findSingleResultByJPAQL(hqlCount.toString(), param);
			if (count == null || count.compareTo(0L) <= 0) {
				return page;
			}
			page.setRowCount(count.intValue());
			boAlmCbFlowHiss = commonDAO.findByJPAQL(hql.toString(), param, almCbFlowHisQueryPageBO.getPageNo(), almCbFlowHisQueryPageBO.getPageSize());
			page.generatePageCount(almCbFlowHisQueryPageBO.getPageSize());
		} else {
			boAlmCbFlowHiss = commonDAO.findByJPAQL(hql.toString(), param);
		}
		page.setPageData(AlmCbFlowHisMapper.INSTANCE.domainToBo(boAlmCbFlowHiss));
		return page;
	}
	
}