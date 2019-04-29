package com.asiainfo.rms.workflow.service.workflow.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.asiainfo.rms.workflow.domain.workflow.*;
import com.asiainfo.rms.workflow.dto.common.WorkflowOrderDto;
import com.asiainfo.rms.workflow.mapper.process.common.WoflowOrderListMapper;
import org.springframework.stereotype.Service;

import com.asiainfo.rms.workflow.bo.workflow.LinkTimeConfigBO;
import com.asiainfo.rms.workflow.bo.workflow.WorkflowBO;
import com.asiainfo.rms.workflow.bo.workflow.WorkflowTempateBO;
import com.asiainfo.rms.workflow.dao.CommonDAO;
import com.asiainfo.rms.workflow.dto.common.WorkorderListDTO;
import com.asiainfo.rms.workflow.mapper.process.common.WorkorderListMapper;
import com.asiainfo.rms.workflow.mapper.workflow.LinkTimeConfigMapper;
import com.asiainfo.rms.workflow.mapper.workflow.WorkflowMapper;
import com.asiainfo.rms.workflow.mapper.workflow.WorkflowTempateMapper;
import com.asiainfo.rms.workflow.service.workflow.IAlmWorkflowSV;

@Service("workflowSV")
@Transactional(rollbackOn = Exception.class)
public class AlmWorkflowSVImpl implements IAlmWorkflowSV {

	@Resource(name="commonDao")
	private CommonDAO commonDao;
	
	@Override
	@SuppressWarnings("unchecked")
	public WorkflowBO getWorkflowByLinkId(Long linkId) throws Exception {
		BOAlmWorkflow workflow = null;
		String jql = "select o from BOAlmWorkflow o where o.linkId=:linkId";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("linkId", linkId);
		List<BOAlmWorkflow> almWorkflows = commonDao.findByJPAQL(jql, param, true);
		if(almWorkflows.size()==1)
			workflow = almWorkflows.get(0);
		return WorkflowMapper.INSTANCE.domainToBo(workflow);
	}

	@Override
	@SuppressWarnings("unchecked")
	public WorkflowBO getWorkflowByLinkNo(String linkNo) throws Exception {
		BOAlmWorkflow workflow = null;
		String jql = "select o from BOAlmWorkflow o where o.linkNo=:linkNo";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("linkNo", linkNo);
		List<BOAlmWorkflow> almWorkflows = commonDao.findByJPAQL(jql, param, true);
		if(almWorkflows.size()==1)
			workflow = almWorkflows.get(0);
		return WorkflowMapper.INSTANCE.domainToBo(workflow);
	}

	@Override
	public List<WorkflowBO> getWorkflowByLinkNoAndId(Long linkId, String linkNo,String phaseId,String processKey) throws Exception {
		String jql = "select o from BOAlmWorkflow o where 1=1 ";
		Map<String, Object> param = new HashMap<String, Object>();
		if(null!=linkNo && !"".equals(linkNo)){
			jql+=" and o.linkNo=:linkNo";
			param.put("linkNo", linkNo);
		}
		if(null!=linkId && linkId>0){
			jql+=" and o.linkId=:linkId";
			param.put("linkId", linkId);
		}
		if(null!=processKey && !"".equals(processKey)){
			jql+=" and o.processKey=:processKey";
			param.put("processKey", processKey);
		}
		if(null!=phaseId && !"".equals(phaseId)){
			jql+=" and o.phaseId=:phaseId";
			param.put("phaseId", phaseId);
		}
		List<BOAlmWorkflow> almWorkflows = commonDao.findByJPAQL(jql, param, true);
		return WorkflowMapper.INSTANCE.boTOBOList(almWorkflows);
	}

	@Override
	public LinkTimeConfigBO getLinkTimeConfigLinkNoAndConfigType(String codingType, String linkNo) throws Exception {
		BOLinkTimeConfig linkTimeConfig = null;
		String jql = "select o from BOLinkTimeConfig o where o.linkNo=:linkNo";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("linkNo", linkNo);
		if(null!=codingType && !"".equals(codingType)){
			jql+=" and o.codingType=:codingType";
			param.put("codingType", codingType);
		}
		List<BOLinkTimeConfig> linkTimeConfigs = commonDao.findByJPAQL(jql, param, true);
		if(linkTimeConfigs.size()>=1)
			linkTimeConfig = linkTimeConfigs.get(0);
		return LinkTimeConfigMapper.INSTANCE.domainToBo(linkTimeConfig);
	}

	@Override
	public int getWorkOrderCount(String objName, String objType, String linkNo, String submitStaffName, String resStaffName,
			String execStaffName,Integer execStaffId,Integer objId,String status, String orderType, String orderCreateDateStart, String orderCreateDateEnd,
			String objSubmitDateStart, String objSubmitDateEnd, String objReceiveDateStart, String objReceiveDateEnd,Integer orderId,
			String objTag)
			throws Exception {
		String jql = "select o from BOWorkorderList o where 1=1 ";
		Map<String, Object> param = new HashMap<String, Object>();
		if(null!=objName && !"".equals(objName)){
			jql+=" and o.objName like :objName";
			param.put("objName", "%"+objName+"%");
		}
		if(null!=objType && !"".equals(objType)){
			jql+=" and o.objType=:objType";
			param.put("objType", objType);
		}
		if(null!=linkNo && !"".equals(linkNo)){
			jql+=" and o.linkNo=:linkNo";
			param.put("linkNo", linkNo);
		}
		if(null!=submitStaffName && !"".equals(submitStaffName)){
			jql+=" and o.submitStaffname like :submitStaffName ";
			param.put("submitStaffName", "%"+submitStaffName+"%");
		}
		if(null!=resStaffName && !"".equals(resStaffName)){
			jql+=" and o.resStaffname like :resStaffName";
			param.put("resStaffName", "%"+resStaffName+"%");
		}
		if(null!=execStaffName && !"".equals(execStaffName)){
			jql+=" and o.employeeName like :execStaffName";
			param.put("execStaffName", "%"+execStaffName+"%");
		}
		if(null!=orderType && !"".equals(orderType)){
			jql+=" and o.orderType=:orderType";
			param.put("orderType", orderType);
		}
		if(null!=execStaffId && execStaffId>0){
			jql+=" and o.execStaffId=:execStaffId";
			param.put("execStaffId", execStaffId);
		}
		
		if(null!=objId && objId>0){
			jql+=" and o.objId=:objId";
			param.put("objId", objId);
		}
		if(null!=status && !"".equals(status)){
			jql+=" and o.status=:status";
			param.put("status", status);
		}
		if(null!=orderCreateDateStart && !"".equals(orderCreateDateStart)){
			jql+=" and o.createTime>to_date(:orderCreateDateStart,'yyyy-MM-dd')";
			param.put("orderCreateDateStart", orderCreateDateStart);
		}
		if(null!=orderCreateDateEnd && !"".equals(orderCreateDateEnd)){
			jql+=" and o.createTime<to_date(:orderCreateDateEnd,'yyyy-MM-dd')";
			param.put("orderCreateDateEnd", orderCreateDateEnd);
		}
		if(null!=objSubmitDateStart && !"".equals(objSubmitDateStart)){
			jql+=" and o.proposeDate>to_date(:objSubmitDateStart,'yyyy-MM-dd HH24:mi:ss')";
			param.put("objSubmitDateStart", objSubmitDateStart);
		}
		if(null!=objSubmitDateEnd && !"".equals(objSubmitDateEnd)){
			jql+=" and o.proposeDate<to_date(:objSubmitDateEnd,'yyyy-MM-dd HH24:mi:ss')";
			param.put("objSubmitDateEnd", objSubmitDateEnd);
		}
		if(null!=objReceiveDateStart && !"".equals(objReceiveDateStart)){
			jql+=" and o.orderDate>to_date(:objReceiveDateStart,'yyyy-MM-dd HH24:mi:ss')";
			param.put("objReceiveDateStart", objReceiveDateStart);
		}
		if(null!=objReceiveDateEnd && !"".equals(objReceiveDateEnd)){
			jql+=" and o.orderDate<to_date(:objReceiveDateEnd,'yyyy-MM-dd HH24:mi:ss')";
			param.put("objReceiveDateEnd", objReceiveDateEnd);
		}

		if(null!=orderId && orderId>0){
			jql+=" and o.orderId=:orderId";
			param.put("orderId", orderId);
		}
		
		if(null!=objTag && !"".equals(objTag)){
			jql+=" and o.objTag like :objTag";
			param.put("objTag", "%"+objTag+"%");
		}
		
		jql+=" ORDER BY o.createTime DESC ";
		List<BOWorkorderList> workorderLists = commonDao.findByJPAQL(jql, param, true);
		if(workorderLists.size()>=1)
			return workorderLists.size();
		return 0;
	}

	@Override
	public List<WorkorderListDTO> getWorkOrderInfo(String objName, String objType, String linkNo, String submitStaffName,
			String resStaffName, String execStaffName,Integer execStaffId,Integer objId,String status, String orderType, String orderCreateDateStart,
			String orderCreateDateEnd, String objSubmitDateStart, String objSubmitDateEnd, String objReceiveDateStart,
			String objReceiveDateEnd, Integer orderId,String objTag,Integer pageNo, Integer pageSize) throws Exception {
		String jql = "select o from BOWorkorderList o where 1=1 ";
		Map<String, Object> param = new HashMap<String, Object>();
		if(null!=objName && !"".equals(objName)){
			jql+=" and o.objName like :objName";
			param.put("objName", "%"+objName+"%");
		}
		if(null!=objType && !"".equals(objType)){
			jql+=" and o.objType=:objType";
			param.put("objType", objType);
		}
		if(null!=linkNo && !"".equals(linkNo)){
			jql+=" and o.linkNo=:linkNo";
			param.put("linkNo", linkNo);
		}
		if(null!=submitStaffName && !"".equals(submitStaffName)){
			jql+=" and o.submitStaffname like :submitStaffName ";
			param.put("submitStaffName", "%"+submitStaffName+"%");
		}
		if(null!=resStaffName && !"".equals(resStaffName)){
			jql+=" and o.resStaffname like :resStaffName";
			param.put("resStaffName", "%"+resStaffName+"%");
		}
		if(null!=execStaffName && !"".equals(execStaffName)){
			jql+=" and o.employeeName like :execStaffName";
			param.put("execStaffName", "%"+execStaffName+"%");
		}
		if(null!=orderType && !"".equals(orderType)){
			jql+=" and o.orderType=:orderType";
			param.put("orderType", orderType);
		}
		if(null!=execStaffId && execStaffId>0){
			jql+=" and o.execStaffId=:execStaffId";
			param.put("execStaffId", execStaffId);
		}
		if(null!=objId && objId>0){
			jql+=" and o.objId=:objId";
			param.put("objId", objId);
		}
		if(null!=status && !"".equals(status)){
			jql+=" and o.status=:status";
			param.put("status", status);
		}
		if(null!=orderCreateDateStart && !"".equals(orderCreateDateStart)){
			jql+=" and o.createTime>to_date(:orderCreateDateStart,'yyyy-MM-dd')";
			param.put("orderCreateDateStart", orderCreateDateStart);
		}
		if(null!=orderCreateDateEnd && !"".equals(orderCreateDateEnd)){
			jql+=" and o.createTime<to_date(:orderCreateDateEnd,'yyyy-MM-dd')";
			param.put("orderCreateDateEnd", orderCreateDateEnd);
		}
		if(null!=objSubmitDateStart && !"".equals(objSubmitDateStart)){
			jql+=" and o.proposeDate>to_date(:objSubmitDateStart,'yyyy-MM-dd HH24:mi:ss')";
			param.put("objSubmitDateStart", objSubmitDateStart);
		}
		if(null!=objSubmitDateEnd && !"".equals(objSubmitDateEnd)){
			jql+=" and o.proposeDate<to_date(:objSubmitDateEnd,'yyyy-MM-dd HH24:mi:ss')";
			param.put("objSubmitDateEnd", objSubmitDateEnd);
		}
		if(null!=objReceiveDateStart && !"".equals(objReceiveDateStart)){
			jql+=" and o.orderDate>to_date(:objReceiveDateStart,'yyyy-MM-dd HH24:mi:ss')";
			param.put("objReceiveDateStart", objReceiveDateStart);
		}
		if(null!=objReceiveDateEnd && !"".equals(objReceiveDateEnd)){
			jql+=" and o.orderDate<to_date(:objReceiveDateEnd,'yyyy-MM-dd HH24:mi:ss')";
			param.put("objReceiveDateEnd", objReceiveDateEnd);
		}

		if(null!=orderId && orderId>0){
			jql+=" and o.orderId=:orderId";
			param.put("orderId", orderId);
		}
		if(null!=objTag && !"".equals(objTag)){
			jql+=" and o.objTag like :objTag";
			param.put("objTag", "%"+objTag+"%");
		}
		jql+=" ORDER BY o.orderId DESC ";
		List<BOWorkorderList> workorderLists = commonDao.findByJPAQL(jql, param, pageNo,pageSize);
		if(workorderLists.size()>=1)
			return WorkorderListMapper.INSTANCE.toDTOs(workorderLists);
		return null;
	}

	@Override
	public List<WorkflowTempateBO> getWorkflowTemplate() throws Exception {
		String jql = "select o from BOWorkflowTempate o ";
		Map<String, Object> param = new HashMap<String, Object>();
		List<BOWorkflowTempate> workflowTempates = commonDao.findByJPAQL(jql, param, true);
		return WorkflowTempateMapper.INSTANCE.boTOBOList(workflowTempates);
	}
	
	public boolean checkVpReqExitOther(int objId,String status,String linkIds)throws Exception{
		
		String sql = "select * from alm_Workorder_List t where obj_id= "+objId;
		sql +=" and status="+status ;
		sql +=" and link_id in ("+linkIds+")" ;
		List<BOWorkorderList> workorderLists = commonDao.findBySql(sql, null);
		if(workorderLists.size()>=1)
			return false;
		else
			return true;
	}

	@Override
	public int getWoflowOrderCount(String objName, String objType, String linkNo, String submitStaffName, String resStaffName,
								 String execStaffName,Integer execStaffId,Integer objId,String status, String orderType, String orderCreateDateStart, String orderCreateDateEnd,
								 String objSubmitDateStart, String objSubmitDateEnd, String objReceiveDateStart, String objReceiveDateEnd,Integer orderId,
								 String objTag)
			throws Exception {
		String jql = "select o from BOWoflowOrderList o where 1=1 ";
		Map<String, Object> param = new HashMap<String, Object>();
		if(null!=objName && !"".equals(objName)){
			jql+=" and o.objName like :objName";
			param.put("objName", "%"+objName+"%");
		}
		if(null!=objType && !"".equals(objType)){
			jql+=" and o.objType=:objType";
			param.put("objType", objType);
		}
		if(null!=linkNo && !"".equals(linkNo)){
			jql+=" and o.linkNo=:linkNo";
			param.put("linkNo", linkNo);
		}
		if(null!=submitStaffName && !"".equals(submitStaffName)){
			jql+=" and o.submitStaffname like :submitStaffName ";
			param.put("submitStaffName", "%"+submitStaffName+"%");
		}
		if(null!=resStaffName && !"".equals(resStaffName)){
			jql+=" and o.resStaffname like :resStaffName";
			param.put("resStaffName", "%"+resStaffName+"%");
		}
		if(null!=execStaffName && !"".equals(execStaffName)){
			jql+=" and o.employeeName like :execStaffName";
			param.put("execStaffName", "%"+execStaffName+"%");
		}
		if(null!=orderType && !"".equals(orderType)){
			jql+=" and o.orderType=:orderType";
			param.put("orderType", orderType);
		}
		if(null!=execStaffId && execStaffId>0){
			jql+=" and o.execStaffId=:execStaffId";
			param.put("execStaffId", execStaffId);
		}

		if(null!=objId && objId>0){
			jql+=" and o.objId=:objId";
			param.put("objId", objId);
		}
		if(null!=status && !"".equals(status)){
			jql+=" and o.status=:status";
			param.put("status", status);
		}
		if(null!=orderCreateDateStart && !"".equals(orderCreateDateStart)){
			jql+=" and o.createTime>to_date(:orderCreateDateStart,'yyyy-MM-dd')";
			param.put("orderCreateDateStart", orderCreateDateStart);
		}
		if(null!=orderCreateDateEnd && !"".equals(orderCreateDateEnd)){
			jql+=" and o.createTime<to_date(:orderCreateDateEnd,'yyyy-MM-dd')";
			param.put("orderCreateDateEnd", orderCreateDateEnd);
		}
		if(null!=objSubmitDateStart && !"".equals(objSubmitDateStart)){
			jql+=" and o.proposeDate>to_date(:objSubmitDateStart,'yyyy-MM-dd HH24:mi:ss')";
			param.put("objSubmitDateStart", objSubmitDateStart);
		}
		if(null!=objSubmitDateEnd && !"".equals(objSubmitDateEnd)){
			jql+=" and o.proposeDate<to_date(:objSubmitDateEnd,'yyyy-MM-dd HH24:mi:ss')";
			param.put("objSubmitDateEnd", objSubmitDateEnd);
		}
		if(null!=objReceiveDateStart && !"".equals(objReceiveDateStart)){
			jql+=" and o.orderDate>to_date(:objReceiveDateStart,'yyyy-MM-dd HH24:mi:ss')";
			param.put("objReceiveDateStart", objReceiveDateStart);
		}
		if(null!=objReceiveDateEnd && !"".equals(objReceiveDateEnd)){
			jql+=" and o.orderDate<to_date(:objReceiveDateEnd,'yyyy-MM-dd HH24:mi:ss')";
			param.put("objReceiveDateEnd", objReceiveDateEnd);
		}

		if(null!=orderId && orderId>0){
			jql+=" and o.orderId=:orderId";
			param.put("orderId", orderId);
		}

		if(null!=objTag && !"".equals(objTag)){
			jql+=" and o.objTag like :objTag";
			param.put("objTag", "%"+objTag+"%");
		}

		jql+=" ORDER BY o.createTime DESC ";
		List<BOWoflowOrderList> workorderLists = commonDao.findByJPAQL(jql, param, true);
		if(workorderLists.size()>=1)
			return workorderLists.size();
		return 0;
	}

	@Override
	public List<WorkflowOrderDto> getWoflowOrderInfo(String objName, String objType, String linkNo, String submitStaffName,
													 String resStaffName, String execStaffName, Integer execStaffId, Integer objId, String status, String orderType, String orderCreateDateStart,
													 String orderCreateDateEnd, String objSubmitDateStart, String objSubmitDateEnd, String objReceiveDateStart,
													 String objReceiveDateEnd, Integer orderId, String objTag, Integer pageNo, Integer pageSize) throws Exception {
		String jql = "select o from BOWoflowOrderList o where 1=1 ";
		Map<String, Object> param = new HashMap<String, Object>();
		if(null!=objName && !"".equals(objName)){
			jql+=" and o.objName like :objName";
			param.put("objName", "%"+objName+"%");
		}
		if(null!=objType && !"".equals(objType)){
			jql+=" and o.objType=:objType";
			param.put("objType", objType);
		}
		if(null!=linkNo && !"".equals(linkNo)){
			jql+=" and o.linkNo=:linkNo";
			param.put("linkNo", linkNo);
		}
		if(null!=submitStaffName && !"".equals(submitStaffName)){
			jql+=" and o.submitStaffname like :submitStaffName ";
			param.put("submitStaffName", "%"+submitStaffName+"%");
		}
		if(null!=resStaffName && !"".equals(resStaffName)){
			jql+=" and o.resStaffname like :resStaffName";
			param.put("resStaffName", "%"+resStaffName+"%");
		}
		if(null!=execStaffName && !"".equals(execStaffName)){
			jql+=" and o.employeeName like :execStaffName";
			param.put("execStaffName", "%"+execStaffName+"%");
		}
		if(null!=orderType && !"".equals(orderType)){
			jql+=" and o.orderType=:orderType";
			param.put("orderType", orderType);
		}
		if(null!=execStaffId && execStaffId>0){
			jql+=" and o.execStaffId=:execStaffId";
			param.put("execStaffId", execStaffId);
		}
		if(null!=objId && objId>0){
			jql+=" and o.objId=:objId";
			param.put("objId", objId);
		}
		if(null!=status && !"".equals(status)){
			jql+=" and o.status=:status";
			param.put("status", status);
		}
		if(null!=orderCreateDateStart && !"".equals(orderCreateDateStart)){
			jql+=" and o.createTime>to_date(:orderCreateDateStart,'yyyy-MM-dd')";
			param.put("orderCreateDateStart", orderCreateDateStart);
		}
		if(null!=orderCreateDateEnd && !"".equals(orderCreateDateEnd)){
			jql+=" and o.createTime<to_date(:orderCreateDateEnd,'yyyy-MM-dd')";
			param.put("orderCreateDateEnd", orderCreateDateEnd);
		}
		if(null!=objSubmitDateStart && !"".equals(objSubmitDateStart)){
			jql+=" and o.proposeDate>to_date(:objSubmitDateStart,'yyyy-MM-dd HH24:mi:ss')";
			param.put("objSubmitDateStart", objSubmitDateStart);
		}
		if(null!=objSubmitDateEnd && !"".equals(objSubmitDateEnd)){
			jql+=" and o.proposeDate<to_date(:objSubmitDateEnd,'yyyy-MM-dd HH24:mi:ss')";
			param.put("objSubmitDateEnd", objSubmitDateEnd);
		}
		if(null!=objReceiveDateStart && !"".equals(objReceiveDateStart)){
			jql+=" and o.orderDate>to_date(:objReceiveDateStart,'yyyy-MM-dd HH24:mi:ss')";
			param.put("objReceiveDateStart", objReceiveDateStart);
		}
		if(null!=objReceiveDateEnd && !"".equals(objReceiveDateEnd)){
			jql+=" and o.orderDate<to_date(:objReceiveDateEnd,'yyyy-MM-dd HH24:mi:ss')";
			param.put("objReceiveDateEnd", objReceiveDateEnd);
		}

		if(null!=orderId && orderId>0){
			jql+=" and o.orderId=:orderId";
			param.put("orderId", orderId);
		}
		if(null!=objTag && !"".equals(objTag)){
			jql+=" and o.objTag like :objTag";
			param.put("objTag", "%"+objTag+"%");
		}
		jql+=" ORDER BY o.orderId DESC ";
		List<BOWoflowOrderList> workorderLists = commonDao.findByJPAQL(jql, param, pageNo,pageSize);
		if(workorderLists.size()>=1)
			return WoflowOrderListMapper.INSTANCE.boToDtos(workorderLists);
		return null;
	}
}
