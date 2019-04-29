package com.asiainfo.rms.workflow.service.common.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.workflow.bo.process.common.AssessBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.common.BOAssess;
import com.asiainfo.rms.workflow.mapper.common.AssessMapper;
import com.asiainfo.rms.workflow.service.common.IOrderAssessService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
@Data
@Log4j
@Service("orderAssessService")
@Transactional
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderAssessServiceImpl implements IOrderAssessService {
	@Autowired
	private CommonDAO commonDAO;
	@Override
	public long saveAssess(AssessBO assessValue) throws Exception {
		BOAssess value=commonDAO.saveOrUpdate(AssessMapper.INSTANCE.boToEntity(assessValue),BOAssess.class);
		return value.getAssessId();
	}

	@Override
	public void updateAssess(AssessBO assessValue) throws Exception {
		commonDAO.saveOrUpdate(AssessMapper.INSTANCE.boToEntity(assessValue),BOAssess.class);		
	}

	@Override
	public void delAssess(Integer assessId) throws Exception {
		commonDAO.delete(Long.parseLong(""+assessId), BOAssess.class);
	}

	@Override
	public List<AssessBO> queryAssess(int assessId, int orderId,int reqId) throws Exception {
		String  hql =  "SELECT o FROM BOAssess o WHERE 1=1" ;
		Map<String, Object> param = new HashMap<String, Object>();
		if(assessId>0){
			hql+=" and assessId=:assessId ";
			param.put("assessId", Long.parseLong(""+assessId));
		}
		if(orderId>0){
			hql+=" and orderId=:orderId ";
			param.put("orderId", Long.parseLong(""+orderId));
		}
		if(reqId>0){
			hql+=" and reqId=:reqId ";
			param.put("reqId", Long.parseLong(""+reqId));
		}
		log.error("queryAssess param :"+param.toString());
		@SuppressWarnings("unchecked")
		List<BOAssess> list = commonDAO.findByJPAQL(hql, param);
		if(null!=list && list.size()>0)
			return AssessMapper.INSTANCE.entityListToBOList(list);
		return null;
	}

}
