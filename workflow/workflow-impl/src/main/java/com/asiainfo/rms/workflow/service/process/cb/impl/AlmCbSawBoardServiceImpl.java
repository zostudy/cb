package com.asiainfo.rms.workflow.service.process.cb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbSawBoardBO;
import com.asiainfo.rms.workflow.bo.process.cb.AlmCbSawBoardQueryPageBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.cb.BOAlmCbSawBoard;
import com.asiainfo.rms.workflow.mapper.process.cb.AlmCbSawBoardMapper;
import com.asiainfo.rms.workflow.service.process.cb.IAlmCbSawBoardService;

/**
 * 
 * 
 * @author joker
 */
@Service("almCbSawBoardService")
@Transactional(rollbackOn = Exception.class)
public class AlmCbSawBoardServiceImpl implements IAlmCbSawBoardService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void deleteByPrimaryKey(Long sbId) throws Exception {
		commonDAO.delete(sbId, BOAlmCbSawBoard.class);
	}
	
	@Override
	public AlmCbSawBoardBO save(AlmCbSawBoardBO almCbSawBoardBO) throws Exception {
		BOAlmCbSawBoard boAlmCbSawBoard = AlmCbSawBoardMapper.INSTANCE.boToDomain(almCbSawBoardBO);
		boAlmCbSawBoard = commonDAO.saveOrUpdate(boAlmCbSawBoard, BOAlmCbSawBoard.class);
		return AlmCbSawBoardMapper.INSTANCE.domainToBo(boAlmCbSawBoard);
	}
	
	@Override
	public AlmCbSawBoardBO findByPrimaryKey(Long sbId) throws Exception {
		BOAlmCbSawBoard boAlmCbSawBoard = commonDAO.findById(BOAlmCbSawBoard.class, sbId);
		return AlmCbSawBoardMapper.INSTANCE.domainToBo(boAlmCbSawBoard);
	}
	
	@Override
	public AlmCbSawBoardBO update(AlmCbSawBoardBO almCbSawBoardBO) throws Exception {
		BOAlmCbSawBoard boAlmCbSawBoard = AlmCbSawBoardMapper.INSTANCE.boToDomain(almCbSawBoardBO);
		boAlmCbSawBoard = commonDAO.saveOrUpdate(boAlmCbSawBoard, BOAlmCbSawBoard.class);
		return AlmCbSawBoardMapper.INSTANCE.domainToBo(boAlmCbSawBoard);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Page<AlmCbSawBoardBO> findByConds(AlmCbSawBoardQueryPageBO almCbSawBoardQueryPageBO) throws Exception {
		StringBuffer hql = new StringBuffer("SELECT o FROM BOAlmCbSawBoard o WHERE 1 = 1");
		StringBuffer hqlCount = new StringBuffer("SELECT COUNT(o) FROM BOAlmCbSawBoard o WHERE 1 = 1");
		StringBuffer hqlCondition = new StringBuffer();
		Map<String, Object> param = new HashMap<String, Object>();
	    if (almCbSawBoardQueryPageBO.getSbIdBegin() != null) {
			hqlCondition.append(" AND o.sbId >= :sbIdBegin");
			param.put("sbIdBegin", almCbSawBoardQueryPageBO.getSbIdBegin());
		}
	    if (almCbSawBoardQueryPageBO.getSbIdEnd() != null) {
			hqlCondition.append(" AND o.sbId <= :sbIdEnd");
			param.put("sbIdEnd", almCbSawBoardQueryPageBO.getSbIdEnd());
		}
	    if (!StringUtils.isBlank(almCbSawBoardQueryPageBO.getSbTag())) {
			hqlCondition.append(" AND o.sbTag LIKE :sbTag");
			param.put("sbTag", "%"+almCbSawBoardQueryPageBO.getSbTag()+"%");
		}
	    if (almCbSawBoardQueryPageBO.getApplyStaffIdBegin() != null) {
			hqlCondition.append(" AND o.applyStaffId >= :applyStaffIdBegin");
			param.put("applyStaffIdBegin", almCbSawBoardQueryPageBO.getApplyStaffIdBegin());
		}
	    if (almCbSawBoardQueryPageBO.getApplyStaffIdEnd() != null) {
			hqlCondition.append(" AND o.applyStaffId <= :applyStaffIdEnd");
			param.put("applyStaffIdEnd", almCbSawBoardQueryPageBO.getApplyStaffIdEnd());
		}
	    if (almCbSawBoardQueryPageBO.getCurStatusBegin() != null) {
			hqlCondition.append(" AND o.curStatus >= :curStatusBegin");
			param.put("curStatusBegin", almCbSawBoardQueryPageBO.getCurStatusBegin());
		}
	    if (almCbSawBoardQueryPageBO.getCurStatusEnd() != null) {
			hqlCondition.append(" AND o.curStatus <= :curStatusEnd");
			param.put("curStatusEnd", almCbSawBoardQueryPageBO.getCurStatusEnd());
		}
	    if (almCbSawBoardQueryPageBO.getCurPhaseBegin() != null) {
			hqlCondition.append(" AND o.curPhase >= :curPhaseBegin");
			param.put("curPhaseBegin", almCbSawBoardQueryPageBO.getCurPhaseBegin());
		}
	    if (almCbSawBoardQueryPageBO.getCurPhaseEnd() != null) {
			hqlCondition.append(" AND o.curPhase <= :curPhaseEnd");
			param.put("curPhaseEnd", almCbSawBoardQueryPageBO.getCurPhaseEnd());
		}
		hql.append(hqlCondition);
		hqlCount.append(hqlCondition);
		hql.append(" ORDER BY o.sbId DESC");
		List<BOAlmCbSawBoard> boAlmCbSawBoards = null;
		Page<AlmCbSawBoardBO> page = new Page<AlmCbSawBoardBO>();
		if ((almCbSawBoardQueryPageBO.getPageNo() != null && almCbSawBoardQueryPageBO.getPageNo().compareTo(0) > 0) && (almCbSawBoardQueryPageBO.getPageSize() != null && almCbSawBoardQueryPageBO.getPageSize().compareTo(0) > 0)) {
			Long count = (Long) commonDAO.findSingleResultByJPAQL(hqlCount.toString(), param);
			if (count == null || count.compareTo(0L) <= 0) {
				return page;
			}
			page.setRowCount(count.intValue());
			boAlmCbSawBoards = commonDAO.findByJPAQL(hql.toString(), param, almCbSawBoardQueryPageBO.getPageNo(), almCbSawBoardQueryPageBO.getPageSize());
			page.generatePageCount(almCbSawBoardQueryPageBO.getPageSize());
		} else {
			boAlmCbSawBoards = commonDAO.findByJPAQL(hql.toString(), param);
		}
		page.setPageData(AlmCbSawBoardMapper.INSTANCE.domainToBo(boAlmCbSawBoards));
		return page;
	}
	
}