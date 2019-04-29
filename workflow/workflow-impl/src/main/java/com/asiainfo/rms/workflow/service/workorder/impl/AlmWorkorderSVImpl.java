package com.asiainfo.rms.workflow.service.workorder.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.asiainfo.rms.workflow.bo.workflow.WorkorderBO;
import com.asiainfo.rms.workflow.common.workflow.WorkflowStaticDef;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.domain.workflow.BOAlmWorkorder;
import com.asiainfo.rms.workflow.mapper.workflow.WorkorderMapper;
import com.asiainfo.rms.workflow.service.workorder.IAlmWorkorderSV;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 刘超
 * @version 1.4
 *
 */
@Service("almWorkorderSV")
@Transactional(rollbackOn = Exception.class)
public class AlmWorkorderSVImpl implements IAlmWorkorderSV {

	private final static transient Log log = LogFactory.getLog(AlmWorkorderSVImpl.class);
	
	@Resource(name="commonDao")
	private CommonDAO commonDAO;
	
	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public WorkorderBO getWorkorderByObjIdAndObjType(long objId, String objType)
			throws Exception {
		if(log.isDebugEnabled()){
			StringBuffer buffer = new StringBuffer();
			buffer.append("类:com.asiainfo.platform.service.workorder.impl.AlmWorkorderSVImpl,方法:getWorkorderByObjIdAndObjType(long objId, String objType),正在查询工单信息,查询条件:"+"\n");
			buffer.append("[objId]="+objId+"\n");
			buffer.append("[objType]="+objType+"\n");
			buffer.append("[sql]=select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType"+"\n");
			log.debug(buffer);
		}
		BOAlmWorkorder almWorkorder = null;
		try{
			String sql = new String();
			Map<String, Object> param = new HashMap<String, Object>();
			sql = "select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType";
			param.put("objId", objId);
			param.put("objType", objType);
			List<BOAlmWorkorder> almWorkorders = commonDAO.findByJPAQL(sql, param);
			if(almWorkorders.size()==1)
				almWorkorder = almWorkorders.get(0);
		}catch(Exception e){
			if(log.isErrorEnabled()){
				StringBuffer buffer = new StringBuffer();
				buffer.append("类:com.asiainfo.platform.service.workorder.impl.AlmWorkorderSVImpl,方法:getWorkorderByObjIdAndObjType(long objId, String objType),查询工单信息出错,查询条件:"+"\n");
				buffer.append("[objId]="+objId+"\n");
				buffer.append("[objType]="+objType+"\n");
				buffer.append("[sql]=select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType"+"\n");
				log.error(buffer);
			}
			throw new Exception(e);
		}finally{
			WorkorderBO workorderBO = WorkorderMapper.INSTANCE.domainToBo(almWorkorder);
			return workorderBO;
		}
	}

	
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public WorkorderBO getLastWorkorderByObjIdAndObjType(long objId,
			String objType) throws Exception {
		if(log.isDebugEnabled()){
			StringBuffer buffer = new StringBuffer();
			buffer.append("类:com.asiainfo.platform.service.workorder.impl.AlmWorkorderSVImpl,方法:getLastWorkorderByObjIdAndObjType(long objId,String objType),正在查询最后一条工单信息,查询条件:"+"\n");
			buffer.append("[objId]="+objId+"\n");
			buffer.append("[objType]="+objType+"\n");
			buffer.append("[parentOrderId]="+WorkflowStaticDef.WO_NO_PARENT+"\n");
			buffer.append("[sql]=select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.parentOrderId=:parentOrderId"+"\n");
			log.debug(buffer);
		}
		BOAlmWorkorder almWorkorder = null;
		try{
			String sql = new String();
			Map<String, Object> param = new HashMap<String, Object>();
			sql = "select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.parentOrderId=:parentOrderId ";
			param.put("objId", objId);
			param.put("objType",objType);
			param.put("parentOrderId", WorkflowStaticDef.WO_NO_PARENT);
			
			List<BOAlmWorkorder> almWorkorders = commonDAO.findByJPAQL(sql, param);
			if(almWorkorders.size()==1)
				almWorkorder = almWorkorders.get(0);
		}catch(Exception e){
			if(log.isErrorEnabled()){
				StringBuffer buffer = new StringBuffer();
				buffer.append("类:com.asiainfo.platform.service.workorder.impl.AlmWorkorderSVImpl,方法:getLastWorkorderByObjIdAndObjType(long objId,String objType),查询最后一条工单信息出错,查询条件:"+"\n");
				buffer.append("[objId]="+objId+"\n");
				buffer.append("[objType]="+objType+"\n");
				buffer.append("[parentOrderId]="+WorkflowStaticDef.WO_NO_PARENT+"\n");
				buffer.append("[sql]=select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.parentOrderId=:parentOrderId"+"\n");
				log.error(buffer);
			}
			throw new Exception(e);
		}finally{
			WorkorderBO workorderBO = WorkorderMapper.INSTANCE.domainToBo(almWorkorder);
			return workorderBO;
		}
	}

	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public WorkorderBO getFristWorkorderByObjIdAndObjTypeAndLinkNo(
			long objId, String objType, String linkNo) throws Exception {
		if(log.isDebugEnabled()){
			StringBuffer buffer = new StringBuffer();
			buffer.append("类:com.asiainfo.platform.service.workorder.impl.AlmWorkorderSVImpl,方法:getFristWorkorderByObjIdAndObjTypeAndLinkNo(long objId, String objType, String linkNo),正在查询第一条工单信息,查询条件:"+"\n");
			buffer.append("[objId]="+objId+"\n");
			buffer.append("[objType]="+objType+"\n");
			buffer.append("[linkNo]="+linkNo+"\n");
			buffer.append("[parentOrderId]="+WorkflowStaticDef.WO_NO_PARENT+"\n");
			buffer.append("[sql]=select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.linkNo=:linkNo and o.parentOrderId=:parentOrderId"+"\n");
			log.debug(buffer);
		}
		
		BOAlmWorkorder almWorkorder = null;
		try{
			String sql = new String();
			Map<String, Object> param = new HashMap<String, Object>();
			sql = "select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.linkNo=:linkNo and o.parentOrderId=:parentOrderId";
			param.put("objId", objId);
			param.put("objType", objType);
			param.put("linkNo", linkNo);
			param.put("parentOrderId", WorkflowStaticDef.WO_NO_PARENT);
			
			List<BOAlmWorkorder> almWorkorders = commonDAO.findByJPAQL(sql, param);
			if(almWorkorders.size()==1)
				almWorkorder = almWorkorders.get(0);
		}catch(Exception e){
			if(log.isErrorEnabled()){
				StringBuffer buffer = new StringBuffer();
				buffer.append("类:com.asiainfo.platform.service.workorder.impl.AlmWorkorderSVImpl,方法:getFristWorkorderByObjIdAndObjTypeAndLinkNo(long objId, String objType, String linkNo),查询第一条工单信息出错,查询条件:"+"\n");
				buffer.append("[objId]="+objId+"\n");
				buffer.append("[objType]="+objType+"\n");
				buffer.append("[linkNo]="+linkNo+"\n");
				buffer.append("[parentOrderId]="+WorkflowStaticDef.WO_NO_PARENT+"\n");
				buffer.append("[sql]=select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.linkNo=:linkNo and o.parentOrderId=:parentOrderId"+"\n");
				log.error(buffer);
			}
			throw new Exception(e);
		}finally{
			WorkorderBO workorderBO = WorkorderMapper.INSTANCE.domainToBo(almWorkorder);
			return workorderBO;
		}
	}

	@Override
	public WorkorderBO capyWorkorderByWorkorder(
			WorkorderBO almWorkorderValue) throws Exception {
		if(log.isDebugEnabled()){
			StringBuffer buffer = new StringBuffer();
			buffer.append("类:com.asiainfo.platform.service.workorder.impl.AlmWorkorderSVImpl,方法:capyWorkorderByWorkorder(BOAlmWorkorder almWorkorderValue),正在复制工单信息,并保存:"+"\n");
			buffer.append("[copy orderId]="+almWorkorderValue.getOrderId()+"\n");
			log.debug(buffer);
		}
		BOAlmWorkorder almWorkorder = new BOAlmWorkorder();
		almWorkorder.setDeployId(almWorkorderValue.getDeployId());
		almWorkorder.setParentOrderId(almWorkorderValue.getParentOrderId());
		almWorkorder.setLastOrderId(almWorkorderValue.getLastOrderId());	
		almWorkorder.setActTaskId(almWorkorderValue.getActTaskId());
		almWorkorder.setParentActTaskId(almWorkorderValue.getParentActTaskId());
		almWorkorder.setLastActTaskId(almWorkorderValue.getLastActTaskId());
		almWorkorder.setLinkId(almWorkorderValue.getLinkId());
		almWorkorder.setIsCurrentTask(almWorkorderValue.getIsCurrentTask());
		almWorkorder.setOrderType(almWorkorderValue.getOrderType());
		almWorkorder.setObjId(almWorkorderValue.getObjId());
		almWorkorder.setObjType(almWorkorderValue.getObjType());
		almWorkorder.setDealType(almWorkorderValue.getDealType());
		almWorkorder.setIsLock(almWorkorderValue.getIsLock());
		almWorkorder.setFinishPrint(almWorkorderValue.getFinishPrint());
		almWorkorder.setExecRoleId(almWorkorderValue.getExecRoleId());
		almWorkorder.setExecStaffId(almWorkorderValue.getExecStaffId());
		almWorkorder.setLockRoleId(almWorkorderValue.getLockRoleId());
		almWorkorder.setLockStaffId(almWorkorderValue.getLockStaffId());
		almWorkorder.setResult(almWorkorderValue.getResult());
		almWorkorder.setCond(almWorkorderValue.getCond());
		almWorkorder.setStatus(almWorkorderValue.getStatus());
		almWorkorder.setOpinion(almWorkorderValue.getOpinion());
		almWorkorder.setLockOpinion(almWorkorderValue.getLockOpinion());
		almWorkorder.setCreatTime(almWorkorderValue.getCreatTime());
		almWorkorder.setRecvTime(almWorkorderValue.getRecvTime());
		almWorkorder.setLockTime(almWorkorderValue.getLockTime());
		almWorkorder.setRealseLockTime(almWorkorderValue.getRealseLockTime());
		almWorkorder.setExecTime(almWorkorderValue.getExecTime());
		almWorkorder.setFinishTime(almWorkorderValue.getFinishTime());
		try{
			commonDAO.save(almWorkorder);
		}catch(Exception e){
			if(log.isErrorEnabled()){
				StringBuffer buffer = new StringBuffer();
				buffer.append("类:com.asiainfo.platform.service.workorder.impl.AlmWorkorderSVImpl,方法:capyWorkorderByWorkorder(BOAlmWorkorder almWorkorderValue),复制工单信息保存出错:"+"\n");
				buffer.append("[copy orderId]="+almWorkorderValue.getOrderId()+"\n");
				log.error(buffer);
			}
			throw new Exception(e);
		}
		WorkorderBO workorderBO = WorkorderMapper.INSTANCE.domainToBo(almWorkorder);
		return workorderBO;
	}

	@Override
	public WorkorderBO capyWorkorderByWorkorderNoSave(
			WorkorderBO almWorkorderValue) throws Exception {
		if(log.isDebugEnabled()){
			StringBuffer buffer = new StringBuffer();
			buffer.append("类:com.asiainfo.platform.service.workorder.impl.AlmWorkorderSVImpl,方法:capyWorkorderByWorkorder(BOAlmWorkorder almWorkorderValue),正在复制工单信息:"+"\n");
			buffer.append("[copy orderId]="+almWorkorderValue.getOrderId()+"\n");
			log.debug(buffer);
		}
		BOAlmWorkorder almWorkorder = new BOAlmWorkorder();
		almWorkorder.setDeployId(almWorkorderValue.getDeployId());
		almWorkorder.setParentOrderId(almWorkorderValue.getParentOrderId());
		almWorkorder.setLastOrderId(almWorkorderValue.getLastOrderId());	
		almWorkorder.setActTaskId(almWorkorderValue.getActTaskId());
		almWorkorder.setParentActTaskId(almWorkorderValue.getParentActTaskId());
		almWorkorder.setLastActTaskId(almWorkorderValue.getLastActTaskId());
		almWorkorder.setLinkId(almWorkorderValue.getLinkId());
		almWorkorder.setIsCurrentTask(almWorkorderValue.getIsCurrentTask());
		almWorkorder.setOrderType(almWorkorderValue.getOrderType());
		almWorkorder.setObjId(almWorkorderValue.getObjId());
		almWorkorder.setObjType(almWorkorderValue.getObjType());
		almWorkorder.setDealType(almWorkorderValue.getDealType());
		almWorkorder.setIsLock(almWorkorderValue.getIsLock());
		almWorkorder.setFinishPrint(almWorkorderValue.getFinishPrint());
		almWorkorder.setExecRoleId(almWorkorderValue.getExecRoleId());
		almWorkorder.setExecStaffId(almWorkorderValue.getExecStaffId());
		almWorkorder.setLockRoleId(almWorkorderValue.getLockRoleId());
		almWorkorder.setLockStaffId(almWorkorderValue.getLockStaffId());
		almWorkorder.setResult(almWorkorderValue.getResult());
		almWorkorder.setCond(almWorkorderValue.getCond());
		almWorkorder.setStatus(almWorkorderValue.getStatus());
		almWorkorder.setOpinion(almWorkorderValue.getOpinion());
		almWorkorder.setLockOpinion(almWorkorderValue.getLockOpinion());
		almWorkorder.setCreatTime(almWorkorderValue.getCreatTime());
		almWorkorder.setRecvTime(almWorkorderValue.getRecvTime());
		almWorkorder.setLockTime(almWorkorderValue.getLockTime());
		almWorkorder.setRealseLockTime(almWorkorderValue.getRealseLockTime());
		almWorkorder.setExecTime(almWorkorderValue.getExecTime());
		almWorkorder.setFinishTime(almWorkorderValue.getFinishTime());
		WorkorderBO workorderBO = WorkorderMapper.INSTANCE.domainToBo(almWorkorder);
		return workorderBO;
	}
	
	@Override
	@SuppressWarnings("finally")
	public WorkorderBO queryWorkOrderById(long workOrderID) throws Exception {
		if(log.isDebugEnabled()){
			StringBuffer buffer = new StringBuffer();
			buffer.append("类:com.asiainfo.platform.service.workorder.impl.AlmWorkorderSVImpl,方法:queryWorkOrderById(long workOrderID),正在查询工单信息,查询条件:"+"\n");
			buffer.append("[orderId]="+workOrderID+"\n");
			buffer.append("[sql]=select o from BOAlmWorkorder o where o.orderId=:orderId"+"\n");
			log.debug(buffer);
		}
		
		BOAlmWorkorder almWorkorder = null;
		try{
			Object workorder = commonDAO.findById(BOAlmWorkorder.class, workOrderID);
			if(workorder!=null)
				almWorkorder = (BOAlmWorkorder)workorder;
		}catch(Exception e){
			if(log.isErrorEnabled()){
				StringBuffer buffer = new StringBuffer();
				buffer.append("类:com.asiainfo.platform.service.workorder.impl.AlmWorkorderSVImpl,方法:queryWorkOrderById(long workOrderID),查询工单信息出错,查询条件:"+"\n");
				buffer.append("[orderId]="+workOrderID+"\n");
				buffer.append("[sql]=select o from BOAlmWorkorder o where o.orderId=:orderId"+"\n");
				log.error(buffer);
			}
			throw new Exception(e);
		}finally{
			WorkorderBO workorderBO = WorkorderMapper.INSTANCE.domainToBo(almWorkorder);
			return workorderBO;
		}
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<WorkorderBO> queryWorkorderBy(Long objId, String objType, Long linkId) throws Exception {
		String jql = "select o from BOAlmWorkorder o where o.linkId=:linkId and o.objId=:objId and o.objType=:objType";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("objId", objId);
		param.put("objType",objType);
		param.put("linkId", linkId);
		List<BOAlmWorkorder> almWorkorders = commonDAO.findByJPAQL(jql, param);
		List<WorkorderBO> result = new LinkedList<WorkorderBO>();
		for (int i = 0; almWorkorders != null && almWorkorders.size() > i; i++) {
			result.add(WorkorderMapper.INSTANCE.domainToBo(almWorkorders.get(i)));
		}
		return result;
	}

	@Override
	public void saveWorkorder(WorkorderBO order) throws Exception {
		commonDAO.saveOrUpdate(WorkorderMapper.INSTANCE.boToDomain(order),BOAlmWorkorder.class);
	}

	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<WorkorderBO> queryWorkorderByJql(String jql, Map param) throws Exception {
		List<BOAlmWorkorder> almWorkorders = commonDAO.findByJPAQL(jql, param);
		List<WorkorderBO> result = new LinkedList<WorkorderBO>();
		for (int i =0; almWorkorders != null && almWorkorders.size() >= 1 && i<almWorkorders.size(); i++) {
			result.add(WorkorderMapper.INSTANCE.domainToBo(almWorkorders.get(i)));
		}
		return result;
	}
	
	@Override
	@SuppressWarnings({ "finally", "unchecked" })
	public WorkorderBO getLastWorkorderByObjIdAndObjTypeNew(long objId,
			String objType) throws Exception {
		if(log.isDebugEnabled()){
			StringBuffer buffer = new StringBuffer();
			buffer.append("类:com.asiainfo.platform.service.workorder.impl.AlmWorkorderSVImpl,方法:getLastWorkorderByObjIdAndObjType(long objId,String objType),正在查询最后一条工单信息,查询条件:"+"\n");
			buffer.append("[objId]="+objId+"\n");
			buffer.append("[objType]="+objType+"\n");
			buffer.append("[parentOrderId]="+WorkflowStaticDef.WO_NO_PARENT+"\n");
			buffer.append("[sql]=select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.parentOrderId=:parentOrderId"+"\n");
			log.debug(buffer);
		}
		BOAlmWorkorder almWorkorder = null;
		try{
			String sql = new String();
			Map<String, Object> param = new HashMap<String, Object>();
			sql = "select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.parentOrderId=:parentOrderId order by orderId desc";
			param.put("objId", objId);
			param.put("objType",objType);
			param.put("parentOrderId", WorkflowStaticDef.WO_NO_PARENT);
			
			List<BOAlmWorkorder> almWorkorders = commonDAO.findByJPAQL(sql, param);
			if(almWorkorders.size()>=1)
				almWorkorder = almWorkorders.get(0);
		}catch(Exception e){
			if(log.isErrorEnabled()){
				StringBuffer buffer = new StringBuffer();
				buffer.append("类:com.asiainfo.platform.service.workorder.impl.AlmWorkorderSVImpl,方法:getLastWorkorderByObjIdAndObjType(long objId,String objType),查询最后一条工单信息出错,查询条件:"+"\n");
				buffer.append("[objId]="+objId+"\n");
				buffer.append("[objType]="+objType+"\n");
				buffer.append("[parentOrderId]="+WorkflowStaticDef.WO_NO_PARENT+"\n");
				buffer.append("[sql]=select o from BOAlmWorkorder o where o.objId=:objId and o.objType=:objType and o.parentOrderId=:parentOrderId"+"\n");
				log.error(buffer);
			}
			throw new Exception(e);
		}finally{
			WorkorderBO workorderBO = WorkorderMapper.INSTANCE.domainToBo(almWorkorder);
			return workorderBO;
		}
	}
}
