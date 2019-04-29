package com.asiainfo.rms.workflow.service.process.common.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.common.AlmWorkorderListBO;
import com.asiainfo.rms.workflow.bo.process.common.AlmWorkorderListQueryPageBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.common.BOAlmWorkorderList;
import com.asiainfo.rms.workflow.mapper.process.common.AlmWorkorderListMapper;
import com.asiainfo.rms.workflow.service.process.common.IAlmWorkorderListService;

/**
 * 
 * 
 * @author joker
 */
@Service("almWorkorderListService")
@Transactional(rollbackOn = Exception.class)
public class AlmWorkorderListServiceImpl implements IAlmWorkorderListService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void deleteByPrimaryKey(java.lang.Long orderId) throws Exception {
		commonDAO.delete(orderId, BOAlmWorkorderList.class);
	}
	
	@Override
	public AlmWorkorderListBO save(AlmWorkorderListBO almWorkorderListBO) throws Exception {
		BOAlmWorkorderList boAlmWorkorderList = AlmWorkorderListMapper.INSTANCE.boToDomain(almWorkorderListBO);
		boAlmWorkorderList = commonDAO.saveOrUpdate(boAlmWorkorderList, BOAlmWorkorderList.class);
		return AlmWorkorderListMapper.INSTANCE.domainToBo(boAlmWorkorderList);
	}
	
	@Override
	public AlmWorkorderListBO findByPrimaryKey(java.lang.Long orderId) throws Exception {
		BOAlmWorkorderList boAlmWorkorderList = commonDAO.findById(BOAlmWorkorderList.class, orderId);
		return AlmWorkorderListMapper.INSTANCE.domainToBo(boAlmWorkorderList);
	}
	
	@Override
	public AlmWorkorderListBO update(AlmWorkorderListBO almWorkorderListBO) throws Exception {
		BOAlmWorkorderList boAlmWorkorderList = AlmWorkorderListMapper.INSTANCE.boToDomain(almWorkorderListBO);
		boAlmWorkorderList = commonDAO.saveOrUpdate(boAlmWorkorderList, BOAlmWorkorderList.class);
		return AlmWorkorderListMapper.INSTANCE.domainToBo(boAlmWorkorderList);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Page<AlmWorkorderListBO> findByConds(AlmWorkorderListQueryPageBO almWorkorderListQueryPageBO) throws Exception {
		StringBuffer hql = new StringBuffer("SELECT o FROM BOAlmWorkorderList o WHERE 1 = 1");
		StringBuffer hqlCount = new StringBuffer("SELECT COUNT(o) FROM BOAlmWorkorderList o WHERE 1 = 1");
		StringBuffer hqlCondition = new StringBuffer();
		Map<String, Object> param = new HashMap<String, Object>();
	    if (almWorkorderListQueryPageBO.getOrderIdBegin() != null) {
			hqlCondition.append(" AND o.orderId >= :orderIdBegin");
			param.put("orderIdBegin", almWorkorderListQueryPageBO.getOrderIdBegin());
		}
	    if (almWorkorderListQueryPageBO.getOrderIdEnd() != null) {
			hqlCondition.append(" AND o.orderId <= :orderIdEnd");
			param.put("orderIdEnd", almWorkorderListQueryPageBO.getOrderIdEnd());
		}
	    if (!StringUtils.isBlank(almWorkorderListQueryPageBO.getObjType())) {
			hqlCondition.append(" AND o.objType LIKE :objType");
			param.put("objType", "%"+almWorkorderListQueryPageBO.getObjType()+"%");
		}
	    if (!StringUtils.isBlank(almWorkorderListQueryPageBO.getVmTaskName())) {
			hqlCondition.append(" AND o.vmTaskName LIKE :vmTaskName");
			param.put("vmTaskName", "%"+almWorkorderListQueryPageBO.getVmTaskName()+"%");
		}
	    if (!StringUtils.isBlank(almWorkorderListQueryPageBO.getLinkNo())) {
			hqlCondition.append(" AND o.linkNo LIKE :linkNo");
			param.put("linkNo", "%"+almWorkorderListQueryPageBO.getLinkNo()+"%");
		}
	    if (almWorkorderListQueryPageBO.getLinkIdBegin() != null) {
			hqlCondition.append(" AND o.linkId >= :linkIdBegin");
			param.put("linkIdBegin", almWorkorderListQueryPageBO.getLinkIdBegin());
		}
	    if (almWorkorderListQueryPageBO.getLinkIdEnd() != null) {
			hqlCondition.append(" AND o.linkId <= :linkIdEnd");
			param.put("linkIdEnd", almWorkorderListQueryPageBO.getLinkIdEnd());
		}
	    if (almWorkorderListQueryPageBO.getLinkIds() != null) {
	    	hqlCondition.append(" AND o.linkId in (");
			hqlCondition.append(almWorkorderListQueryPageBO.getLinkIds());
			hqlCondition.append(")");
		}
	    if (almWorkorderListQueryPageBO.getExecStaffIdBegin() != null) {
			hqlCondition.append(" AND o.execStaffId >= :execStaffIdBegin");
			param.put("execStaffIdBegin", almWorkorderListQueryPageBO.getExecStaffIdBegin());
		}
	    if (almWorkorderListQueryPageBO.getExecStaffIdEnd() != null) {
			hqlCondition.append(" AND o.execStaffId <= :execStaffIdEnd");
			param.put("execStaffIdEnd", almWorkorderListQueryPageBO.getExecStaffIdEnd());
		}
	    if (!StringUtils.isBlank(almWorkorderListQueryPageBO.getExecStaffCode())) {
			hqlCondition.append(" AND o.execStaffCode LIKE :execStaffCode");
			param.put("execStaffCode", "%"+almWorkorderListQueryPageBO.getExecStaffCode()+"%");
		}
	    if (!StringUtils.isBlank(almWorkorderListQueryPageBO.getExecEmployeeName())) {
			hqlCondition.append(" AND o.execEmployeeName LIKE :execEmployeeName");
			param.put("execEmployeeName", "%"+almWorkorderListQueryPageBO.getExecEmployeeName()+"%");
		}
	    if (!StringUtils.isBlank(almWorkorderListQueryPageBO.getLockOpinion())) {
			hqlCondition.append(" AND o.lockOpinion LIKE :lockOpinion");
			param.put("lockOpinion", "%"+almWorkorderListQueryPageBO.getLockOpinion()+"%");
		}
    	java.text.SimpleDateFormat sfCreateTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    if (almWorkorderListQueryPageBO.getCreateTimeBegin() != null) {
			hqlCondition.append(" AND o.createTime >= to_date('");
			hqlCondition.append(sfCreateTime.format(almWorkorderListQueryPageBO.getCreateTimeBegin()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (almWorkorderListQueryPageBO.getCreateTimeEnd() != null) {
			hqlCondition.append(" AND o.createTime <= to_date('");
			hqlCondition.append(sfCreateTime.format(almWorkorderListQueryPageBO.getCreateTimeEnd()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
    	java.text.SimpleDateFormat sfFinishTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    if (almWorkorderListQueryPageBO.getFinishTimeBegin() != null) {
			hqlCondition.append(" AND o.finishTime >= to_date('");
			hqlCondition.append(sfFinishTime.format(almWorkorderListQueryPageBO.getFinishTimeBegin()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (almWorkorderListQueryPageBO.getFinishTimeEnd() != null) {
			hqlCondition.append(" AND o.finishTime <= to_date('");
			hqlCondition.append(sfFinishTime.format(almWorkorderListQueryPageBO.getFinishTimeEnd()));
			hqlCondition.append("', 'yyyy-MM-dd HH24:mi:ss')");
		}
	    if (!StringUtils.isBlank(almWorkorderListQueryPageBO.getOrderType())) {
			hqlCondition.append(" AND o.orderType LIKE :orderType");
			param.put("orderType", "%"+almWorkorderListQueryPageBO.getOrderType()+"%");
		}
	    if (!StringUtils.isBlank(almWorkorderListQueryPageBO.getCond())) {
			hqlCondition.append(" AND o.cond LIKE :cond");
			param.put("cond", "%"+almWorkorderListQueryPageBO.getCond()+"%");
		}
	    if (!StringUtils.isBlank(almWorkorderListQueryPageBO.getResult())) {
			hqlCondition.append(" AND o.result LIKE :result");
			param.put("result", "%"+almWorkorderListQueryPageBO.getResult()+"%");
		}
	    if (!StringUtils.isBlank(almWorkorderListQueryPageBO.getStatus())) {
			hqlCondition.append(" AND o.status LIKE :status");
			param.put("status", "%"+almWorkorderListQueryPageBO.getStatus()+"%");
		}
	    if (!StringUtils.isBlank(almWorkorderListQueryPageBO.getOpinion())) {
			hqlCondition.append(" AND o.opinion LIKE :opinion");
			param.put("opinion", "%"+almWorkorderListQueryPageBO.getOpinion()+"%");
		}
	    if (!StringUtils.isBlank(almWorkorderListQueryPageBO.getNextLinkPlantime())) {
			hqlCondition.append(" AND o.nextLinkPlantime LIKE :nextLinkPlantime");
			param.put("nextLinkPlantime", "%"+almWorkorderListQueryPageBO.getNextLinkPlantime()+"%");
		}
	    if (almWorkorderListQueryPageBO.getProcInstIdBegin() != null) {
			hqlCondition.append(" AND o.procInstId >= :procInstIdBegin");
			param.put("procInstIdBegin", almWorkorderListQueryPageBO.getProcInstIdBegin());
		}
	    if (almWorkorderListQueryPageBO.getProcInstIdEnd() != null) {
			hqlCondition.append(" AND o.procInstId <= :procInstIdEnd");
			param.put("procInstIdEnd", almWorkorderListQueryPageBO.getProcInstIdEnd());
		}
	    if (almWorkorderListQueryPageBO.getLastOrderIdBegin() != null) {
			hqlCondition.append(" AND o.lastOrderId >= :lastOrderIdBegin");
			param.put("lastOrderIdBegin", almWorkorderListQueryPageBO.getLastOrderIdBegin());
		}
	    if (almWorkorderListQueryPageBO.getLastOrderIdEnd() != null) {
			hqlCondition.append(" AND o.lastOrderId <= :lastOrderIdEnd");
			param.put("lastOrderIdEnd", almWorkorderListQueryPageBO.getLastOrderIdEnd());
		}
	    if (almWorkorderListQueryPageBO.getRemineTimeBegin() != null) {
			hqlCondition.append(" AND o.remineTime >= :remineTimeBegin");
			param.put("remineTimeBegin", almWorkorderListQueryPageBO.getRemineTimeBegin());
		}
	    if (almWorkorderListQueryPageBO.getRemineTimeEnd() != null) {
			hqlCondition.append(" AND o.remineTime <= :remineTimeEnd");
			param.put("remineTimeEnd", almWorkorderListQueryPageBO.getRemineTimeEnd());
		}
	    if (!StringUtils.isBlank(almWorkorderListQueryPageBO.getPhaseId())) {
			hqlCondition.append(" AND o.phaseId LIKE :phaseId");
			param.put("phaseId", "%"+almWorkorderListQueryPageBO.getPhaseId()+"%");
		}
	    if (almWorkorderListQueryPageBO.getTimeConsumBegin() != null) {
			hqlCondition.append(" AND o.timeConsum >= :timeConsumBegin");
			param.put("timeConsumBegin", almWorkorderListQueryPageBO.getTimeConsumBegin());
		}
	    if (almWorkorderListQueryPageBO.getTimeConsumEnd() != null) {
			hqlCondition.append(" AND o.timeConsum <= :timeConsumEnd");
			param.put("timeConsumEnd", almWorkorderListQueryPageBO.getTimeConsumEnd());
		}
	    if (almWorkorderListQueryPageBO.getObjIdBegin() != null) {
			hqlCondition.append(" AND o.objId >= :objIdBegin");
			param.put("objIdBegin", almWorkorderListQueryPageBO.getObjIdBegin());
		}
	    if (almWorkorderListQueryPageBO.getObjIdEnd() != null) {
			hqlCondition.append(" AND o.objId <= :objIdEnd");
			param.put("objIdEnd", almWorkorderListQueryPageBO.getObjIdEnd());
		}
	    if (!StringUtils.isBlank(almWorkorderListQueryPageBO.getObjTag())) {
			hqlCondition.append(" AND o.objTag LIKE :objTag");
			param.put("objTag", "%"+almWorkorderListQueryPageBO.getObjTag()+"%");
		}
	    if (almWorkorderListQueryPageBO.getApplyStaffIdBegin() != null) {
			hqlCondition.append(" AND o.applyStaffId >= :applyStaffIdBegin");
			param.put("applyStaffIdBegin", almWorkorderListQueryPageBO.getApplyStaffIdBegin());
		}
	    if (almWorkorderListQueryPageBO.getApplyStaffIdEnd() != null) {
			hqlCondition.append(" AND o.applyStaffId <= :applyStaffIdEnd");
			param.put("applyStaffIdEnd", almWorkorderListQueryPageBO.getApplyStaffIdEnd());
		}
	    if (!StringUtils.isBlank(almWorkorderListQueryPageBO.getApplyStaffName())) {
			hqlCondition.append(" AND o.applyStaffName LIKE :applyStaffName");
			param.put("applyStaffName", "%"+almWorkorderListQueryPageBO.getApplyStaffName()+"%");
		}
	    if (!StringUtils.isBlank(almWorkorderListQueryPageBO.getApplyStaffCode())) {
			hqlCondition.append(" AND o.applyStaffCode LIKE :applyStaffCode");
			param.put("applyStaffCode", "%"+almWorkorderListQueryPageBO.getApplyStaffCode()+"%");
		}
		hql.append(hqlCondition);
		hqlCount.append(hqlCondition);
		hql.append(" ORDER BY o.orderId DESC");
		List<BOAlmWorkorderList> boAlmWorkorderLists = null;
		Page<AlmWorkorderListBO> page = new Page<AlmWorkorderListBO>();
		if ((almWorkorderListQueryPageBO.getPageNo() != null && almWorkorderListQueryPageBO.getPageNo().compareTo(0) > 0) && (almWorkorderListQueryPageBO.getPageSize() != null && almWorkorderListQueryPageBO.getPageSize().compareTo(0) > 0)) {
			Long count = (Long) commonDAO.findSingleResultByJPAQL(hqlCount.toString(), param);
			if (count == null || count.compareTo(0L) <= 0) {
				return page;
			}
			page.setRowCount(count.intValue());
			boAlmWorkorderLists = commonDAO.findByJPAQL(hql.toString(), param, almWorkorderListQueryPageBO.getPageNo(), almWorkorderListQueryPageBO.getPageSize());
			page.generatePageCount(almWorkorderListQueryPageBO.getPageSize());
		} else {
			boAlmWorkorderLists = commonDAO.findByJPAQL(hql.toString(), param);
		}
		page.setPageData(AlmWorkorderListMapper.INSTANCE.domainToBo(boAlmWorkorderLists));
		return page;
	}
	
}