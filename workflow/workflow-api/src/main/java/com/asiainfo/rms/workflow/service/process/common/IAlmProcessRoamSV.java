package com.asiainfo.rms.workflow.service.process.common;

import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import com.asiainfo.rms.workflow.bo.process.common.StakeholderOprBO;
import com.asiainfo.rms.workflow.bo.workflow.StakeholderBO;
import com.asiainfo.rms.workflow.bo.workflow.WorkorderBO;

import net.sf.json.JSONObject;

/**
 * 
 * @author 刘超
 *
 */
public interface IAlmProcessRoamSV {

	/**
	 * 启动流程
	 * @param processKey activiti流程key
	 * @param staffId 首个环节处理人ID
	 * @param objectTypeId 业务类型
	 * @param objectId 业务ID
	 * @param cond 流转条件,该条件值进行了改进,如普通条件 
	 * {@code<conds>
	 * 			<staffId>1</staffId>
	 * 		</conds>},该xml解析为staffId=1
	 * ,可以添加list条件{@code
	 * 		<conds>
	 * 			<staffList>
	 * 				<list>1</list>
	 * 				<list>2</list>
	 * 				<list>3</list>
	 * 			</staffList>
	 * 		</conds>},该xml解析为staffList=[1,2,3]
	 * @throws Exception
	 */
	public void createWorkflow(String processKey, String staffId,
                               String objectTypeId, String objectId, String cond) throws  Exception;
	
	/**
	 * 保存环节处理人,调用此方法可不用在意BOAlmStakeholder对象的状态，如（瞬时，持久化，托管）
	 * @param objId 业务ID
	 * @param objType 业务类型
	 * @param almStakeholder 环节处理人list
	 * @throws Exception
	 */
	public void saveStakeholder(String objId, String objType, List<StakeholderBO> almStakeholder)throws Exception;
	
	/**
	 * 保存环节处理人</br>
	 * <h2>人工环节和开始环节</h2>
	 * 处理人只可录入单人(录入多人系统不会有任何错误提示, 以首为准)</br>
	 * 删除(优先): 环节处理人为空或者环节处理的信息不符都会有对应的提示信息</br>
	 * 新增和更新: 处理人录入单人就会直接新增或者更新, 无需其他额外参数</br>
	 * <h2>会签环节</h2>
	 * 删除(优先): 环节处理人为空或者环节处理的信息不符都会有对应的提示信息</br>
	 * 新增和更新: 处理人录入就会直接新增或者更新, 无需其他额外参数</br>
	 * @param objId 业务ID
	 * @param objType 业务类型
	 * @param almStakeholder 环节处理人list
	 * @throws Exception
	 */
	public void saveLinkStakeholder(String objId, String objType, List<StakeholderOprBO> almStakeholder)throws Exception;
	
	/**
	 * 人工任务回单 
	 * @param orderId 工单ID
	 * @param result 回单结果
	 * @param reason 回单备注
	 * @param cond 流转条件,该条件值进行了改进,如普通条件 
	 * {@code<conds>
	 * 			<staffId>1</staffId>
	 * 		</conds>},该xml解析为staffId=1
	 * ,可以添加list条件{@code
	 * 		<conds>
	 * 			<staffList>
	 * 				<list>1</list>
	 * 				<list>2</list>
	 * 				<list>3</list>
	 * 			</staffList>
	 * 		</conds>},该xml解析为staffList=[1,2,3]
	 * @throws Exception
	 */
	public void finishUserTask(long orderId, String result,
                               String reason, String cond) throws Exception;
	
	/**
	 * 创建并保存开始环节工单
	 * @param sourcePath 流程文件路径
	 * @param objId 业务ID
	 * @param objType 业务类型
	 * @param processKey activiti流程key
	 * @param cond 流转条件
	 * @param opinion 备注
	 * @return 工单ID
	 * @throws Exception
	 */
	public long createStartSaveOrder(String sourcePath, String objId, String objType, String processKey, String cond, String opinion) throws Exception;
	
	/**
	 * 对cond XML进行解析
	 * @param aVars
	 * @param cond
	 * @return 解析xml生成Map
	 * @throws Exception
	 */
	public Map<?, ?> analyzeCond(Map<?, ?> aVars, String cond) throws Exception;
	/**
	 * 工单转派
	 * @param orderId 工单ID
	 * @param std    转派处理人
	 */
	public void reAuthorizeTask(long orderId, StakeholderBO std, String opinion) throws Exception;

	/**
	 * 创建与工作流无关的工单 比如 通知、抄送、讨论等
	 * @param orderId
	 * @param orderType
	 * @param std
	 * @throws Exception
	 */
	public void newNoWFWo(long orderId, String orderType, StakeholderBO std, String lockOption, Long objId, String objType) throws Exception;
	
	/**
	 * 单个修改流程图
	 * @param sourcePath
	 * @return
	 * @throws Exception
	 */
	public String updateTemplate(String templateName,String templatepath)throws Exception;

	public List<WorkorderBO> queryWorkorder(Long objId, Long linkId) throws Exception;

	/**
	 * 查询环节处理人
	 * @param objId
	 * @param objType
	 * @param linkId
	 * @return
	 * @throws Exception
	 */
	public List<StakeholderBO> queryStakeholder(String objId, Long linkId) throws Exception;
	
	/**
	 * 关闭与工作流无关的工单 比如 通知、抄送、讨论等
	 * @param orderId
	 * @param orderType
	 * @param opinion
	 * @throws Exception
	 */
	public void finishNoWFWo(long orderId, String orderType,String opinion,String result) throws Exception;
	
	/**
	 * 终止流程
	 * @param deployId
	 * @param procInstId
	 * @param objId
	 * @param objType
	 * @param staffId
	 * @param staffCode
	 * @param staffName
	 * @param reason
	 * @throws Exception
	 */
	public void terminateWorkflow(long deployId, long procInstId, long objId, String objType, String staffId,String staffCode,String staffName, String reason) throws Exception;
	
	/**
	 * 部署流程通过SourcePath
	 * @param sourcePath 流程文件路径
	 * @return deployId
	 * @throws Exception
	 */
	public String deploymentProcessBySourcePath(String sourcePath) throws Exception;
	
	/**
	 * 通过zip文件流部署流程文件
	 * @param stream
	 * @return
	 * @throws Exception
	 */
	public String deploymentProcessByZipFile(ZipInputStream stream) throws Exception;
	
	/**
	 * 获取图片信息，以base64编码
	 * @param deployId
	 * @return base64 String
	 * @throws Exception
	 */
	public String getProcessImageToBase64(long deployId) throws Exception;
	
	/**
	 * 获取图片环节位置
	 * @param deployId
	 * @return Map name为环节名称 value为位置
	 * @throws Exception
	 */
	public Map<String,JSONObject> getShapePosition(long deployId) throws Exception;
	
	/**
	 * 删除部署
	 * @param deployId
	 * @throws Exception
	 */
	public void deleteProcessDeploy(long deployId)throws Exception;

//	/**
//	 * 工单转派
//	 * @param orderId 工单ID
//	 * @param std    转派处理人
//	 */
//	public void reAuthorizeTask(long orderId, StakeholderBO std) throws Exception;

//	/**
//	 * 创建与工作流无关的工单 比如 通知、抄送、讨论等
//	 * @param orderId
//	 * @param orderType
//	 * @param std
//	 * @throws Exception
//	 */
//	public void newNoWFWo(long orderId, String orderType, StakeholderBO std) throws Exception;
//
//	/**
//	 * 关闭与工作流无关的工单 比如 通知、抄送、讨论等
//	 * @param orderId
//	 * @param orderType
//	 * @param opinion
//	 * @throws Exception
//	 */
//	public void finishNoWFWo(long orderId, String orderType,String opinion) throws Exception;

	/**
	 * 将流程跳转到指定节点
	 * @param orderId
	 * @param processKey
	 * @param toLinkId
	 * @param vars
	 * @throws Exception
	 */
	public void jumpSpecifyNode(long orderId,String processKey,long toLinkId,String conds,String result,String reason) throws Exception;
	
	/**
	 * 查询环节处理人
	 * @param objId
	 * @param objType
	 * @param linkId
	 * @return
	 * @throws Exception
	 */
	public List<StakeholderBO> queryStakeholder(String objId, String objType, Long linkId) throws Exception;
	
	/**
	 * 更新工单信息
	 * @param workorderBO
	 * @throws Exception
	 */
	public void updateWorkorder(WorkorderBO workorderBO) throws Exception;
	
	/**
	 * 查询工单信息
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public WorkorderBO queryWorkorder(Long orderId) throws Exception;
	
//	/**
//	 * 查询工单信息
//	 * @param orderId
//	 * @return
//	 * @throws Exception
//	 */
//	public List<WorkorderBO> queryWorkorders(Long objId, Long linkId) throws Exception;
}
