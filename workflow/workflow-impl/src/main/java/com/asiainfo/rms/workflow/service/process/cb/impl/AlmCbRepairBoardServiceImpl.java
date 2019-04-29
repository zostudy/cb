package com.asiainfo.rms.workflow.service.process.cb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbRepairBoardBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbRepairBoardQueryPageBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.cb.BOAlmCbRepairBoard;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbRepairBoardMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbRepairBoardService;

/**
 * 
 * 
 * @author joker
 */
@Service("almCbRepairBoardService")
@Transactional(rollbackOn = Exception.class)
public class AlmCbRepairBoardServiceImpl implements IAlmCbRepairBoardService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void deleteByPrimaryKey(Long rbId) throws Exception {
		commonDAO.delete(rbId, BOAlmCbRepairBoard.class);
	}
	
	@Override
	public AlmCbRepairBoardBO save(AlmCbRepairBoardBO almCbRepairBoardBO) throws Exception {
		BOAlmCbRepairBoard boAlmCbRepairBoard = AlmCbRepairBoardMapper.INSTANCE.boToDomain(almCbRepairBoardBO);
		boAlmCbRepairBoard = commonDAO.saveOrUpdate(boAlmCbRepairBoard, BOAlmCbRepairBoard.class);
		return AlmCbRepairBoardMapper.INSTANCE.domainToBo(boAlmCbRepairBoard);
	}
	
	@Override
	public AlmCbRepairBoardBO findByPrimaryKey(Long rbId) throws Exception {
		BOAlmCbRepairBoard boAlmCbRepairBoard = commonDAO.findById(BOAlmCbRepairBoard.class, rbId);
		return AlmCbRepairBoardMapper.INSTANCE.domainToBo(boAlmCbRepairBoard);
	}
	
	@Override
	public AlmCbRepairBoardBO update(AlmCbRepairBoardBO almCbRepairBoardBO) throws Exception {
		BOAlmCbRepairBoard boAlmCbRepairBoard = AlmCbRepairBoardMapper.INSTANCE.boToDomain(almCbRepairBoardBO);
		boAlmCbRepairBoard = commonDAO.saveOrUpdate(boAlmCbRepairBoard, BOAlmCbRepairBoard.class);
		return AlmCbRepairBoardMapper.INSTANCE.domainToBo(boAlmCbRepairBoard);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Page<AlmCbRepairBoardBO> findByConds(AlmCbRepairBoardQueryPageBO almCbRepairBoardQueryPageBO) throws Exception {
		StringBuffer hql = new StringBuffer("SELECT o FROM BOAlmCbRepairBoard o WHERE 1 = 1");
		StringBuffer hqlCount = new StringBuffer("SELECT COUNT(o) FROM BOAlmCbRepairBoard o WHERE 1 = 1");
		StringBuffer hqlCondition = new StringBuffer();
		Map<String, Object> param = new HashMap<String, Object>();
	    if (almCbRepairBoardQueryPageBO.getRbIdBegin() != null) {
			hqlCondition.append(" AND o.rbId >= :rbIdBegin");
			param.put("rbIdBegin", almCbRepairBoardQueryPageBO.getRbIdBegin());
		}
	    if (almCbRepairBoardQueryPageBO.getRbIdEnd() != null) {
			hqlCondition.append(" AND o.rbId <= :rbIdEnd");
			param.put("rbIdEnd", almCbRepairBoardQueryPageBO.getRbIdEnd());
		}
	    if (!StringUtils.isBlank(almCbRepairBoardQueryPageBO.getRbTag())) {
			hqlCondition.append(" AND o.rbTag LIKE :rbTag");
			param.put("rbTag", "%"+almCbRepairBoardQueryPageBO.getRbTag()+"%");
		}
	    if (almCbRepairBoardQueryPageBO.getApplyStaffIdBegin() != null) {
			hqlCondition.append(" AND o.applyStaffId >= :applyStaffIdBegin");
			param.put("applyStaffIdBegin", almCbRepairBoardQueryPageBO.getApplyStaffIdBegin());
		}
	    if (almCbRepairBoardQueryPageBO.getApplyStaffIdEnd() != null) {
			hqlCondition.append(" AND o.applyStaffId <= :applyStaffIdEnd");
			param.put("applyStaffIdEnd", almCbRepairBoardQueryPageBO.getApplyStaffIdEnd());
		}
	    if (almCbRepairBoardQueryPageBO.getCurStatusBegin() != null) {
			hqlCondition.append(" AND o.curStatus >= :curStatusBegin");
			param.put("curStatusBegin", almCbRepairBoardQueryPageBO.getCurStatusBegin());
		}
	    if (almCbRepairBoardQueryPageBO.getCurStatusEnd() != null) {
			hqlCondition.append(" AND o.curStatus <= :curStatusEnd");
			param.put("curStatusEnd", almCbRepairBoardQueryPageBO.getCurStatusEnd());
		}
	    if (almCbRepairBoardQueryPageBO.getCurPhaseBegin() != null) {
			hqlCondition.append(" AND o.curPhase >= :curPhaseBegin");
			param.put("curPhaseBegin", almCbRepairBoardQueryPageBO.getCurPhaseBegin());
		}
	    if (almCbRepairBoardQueryPageBO.getCurPhaseEnd() != null) {
			hqlCondition.append(" AND o.curPhase <= :curPhaseEnd");
			param.put("curPhaseEnd", almCbRepairBoardQueryPageBO.getCurPhaseEnd());
		}
		hql.append(hqlCondition);
		hqlCount.append(hqlCondition);
		hql.append(" ORDER BY o.rbId DESC");
		List<BOAlmCbRepairBoard> boAlmCbRepairBoards = null;
		Page<AlmCbRepairBoardBO> page = new Page<AlmCbRepairBoardBO>();
		if ((almCbRepairBoardQueryPageBO.getPageNo() != null && almCbRepairBoardQueryPageBO.getPageNo().compareTo(0) > 0) && (almCbRepairBoardQueryPageBO.getPageSize() != null && almCbRepairBoardQueryPageBO.getPageSize().compareTo(0) > 0)) {
			Long count = (Long) commonDAO.findSingleResultByJPAQL(hqlCount.toString(), param);
			if (count == null || count.compareTo(0L) <= 0) {
				return page;
			}
			page.setRowCount(count.intValue());
			boAlmCbRepairBoards = commonDAO.findByJPAQL(hql.toString(), param, almCbRepairBoardQueryPageBO.getPageNo(), almCbRepairBoardQueryPageBO.getPageSize());
			page.generatePageCount(almCbRepairBoardQueryPageBO.getPageSize());
		} else {
			boAlmCbRepairBoards = commonDAO.findByJPAQL(hql.toString(), param);
		}
		page.setPageData(AlmCbRepairBoardMapper.INSTANCE.domainToBo(boAlmCbRepairBoards));
		return page;
	}
	
}