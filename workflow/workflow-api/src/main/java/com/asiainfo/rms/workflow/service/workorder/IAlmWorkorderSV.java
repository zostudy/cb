package com.asiainfo.rms.workflow.service.workorder;

import java.util.List;
import java.util.Map;

import com.asiainfo.rms.workflow.bo.workflow.WorkorderBO;

/**
 * 
 * @author 刘超
 *
 */
public interface IAlmWorkorderSV {

	/**
	 * 获取工单通过业务ID与业务类型
	 * @param objId 业务ID
	 * @param objType 业务类型
	 * @return 工单
	 * @throws Exception
	 */
	public WorkorderBO getWorkorderByObjIdAndObjType(long objId, String objType)throws Exception;
	
	/**
	 * 获取最后一条工单通过业务ID与业务类型
	 * @param objId 业务ID
	 * @param objType 业务类型
	 * @return 工单
	 * @throws Exception
	 */
	public WorkorderBO getLastWorkorderByObjIdAndObjType(long objId,
                                                            String objType) throws Exception;

	/**
	 * 获取第一条工单通过业务ID与业务类型
	 * @param objId 业务ID
	 * @param objType 业务类型
	 * @param linkNo 环节编号
	 * @return 工单
	 * @throws Exception
	 */
	public WorkorderBO getFristWorkorderByObjIdAndObjTypeAndLinkNo(
            long objId, String objType, String linkNo) throws Exception;

	/**
	 * 拷贝工单并保存
	 * @param almWorkorderValue 要拷贝工单对象
	 * @return 工单
	 * @throws Exception
	 */
	public WorkorderBO capyWorkorderByWorkorder(
			WorkorderBO almWorkorderValue) throws Exception;

	/**
	 * 拷贝工单不保存
	 * @param almWorkorderValue 要拷贝工单对象
	 * @return 工单
	 * @throws Exception
	 */
	public WorkorderBO capyWorkorderByWorkorderNoSave(
			WorkorderBO almWorkorderValue) throws Exception;
	
	/**
	 * 通过orderId查询工单
	 * @param workOrderID 工单ID
	 * @return 工单
	 * @throws Exception
	 */
	public WorkorderBO queryWorkOrderById(long workOrderID)
			throws Exception;
	
	/**
	 * 自动流程处理查询方法
	 * @param objId
	 * @param objType
	 * @param linkId
	 * @return
	 * @throws Exception
	 */
	public List<WorkorderBO> queryWorkorderBy(Long objId, String objType, Long linkId)throws Exception;
	
	/**
	 * 保存工单
	 * @param order
	 * @throws Exception
	 */
	public void saveWorkorder(WorkorderBO order)throws Exception;
	
	/**
	 * 通过jql获取工单
	 * @param jql
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<WorkorderBO> queryWorkorderByJql(String jql, Map<?, ?> param)throws Exception;
	
	/**
	 * 获取最后一条工单通过业务ID与业务类型
	 * @param objId 业务ID
	 * @param objType 业务类型
	 * @return 工单
	 * @throws Exception
	 */
	public WorkorderBO getLastWorkorderByObjIdAndObjTypeNew(long objId,
                                                            String objType) throws Exception;

}
