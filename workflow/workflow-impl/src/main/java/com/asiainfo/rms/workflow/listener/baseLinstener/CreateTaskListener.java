package com.asiainfo.rms.workflow.listener.baseLinstener;

import java.util.List;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 测试流程代码
 * @author 刘超
 * @version 1.4
 *
 */
public abstract class CreateTaskListener extends WorkflowBaseListener implements TaskListener {

	private final static transient Log log = LogFactory.getLog(CreateTaskListener.class);
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@Override
	public void notify(DelegateTask task) {
		String objId =task.getVariable("objId").toString();
		String objType = task.getVariable("objType").toString();
		
		String defId = task.getProcessDefinitionId();
		List<ProcessDefinition> definitions = repositoryService.createProcessDefinitionQuery().processDefinitionId(defId).list();
		String deployId = definitions.get(0).getDeploymentId();
		String processKey = definitions.get(0).getKey();
		String proDefId = task.getProcessInstanceId();
		try {
			@SuppressWarnings("rawtypes")
			List rtnList = this.userPreTask(Long.valueOf(deployId),processKey,Long.valueOf(proDefId),Long.valueOf(task.getId()), task.getTaskDefinitionKey(), objId, objType);
			if(rtnList!=null&&rtnList.size()==2){
				//更业务对象的阶段和状态
				this.updateObjCurPhaseAndCurStatus(objId,objType,rtnList.get(1).toString());
				
				this.extraMethod(Long.valueOf(rtnList.get(0).toString()), objId, objType, "userPreTask");
			}
		} catch (Exception e) {
			if(log.isErrorEnabled()){
				log.error("流程运转错误", e);
			}
			throw new ActivitiException("流程运转错误："+e.getMessage());
		}
	}

	//抽象函数 用于实现业务对象当前阶段和当前环节状态更新
	public abstract void updateObjCurPhaseAndCurStatus(String objId,String objType,String linkId) throws Exception;
			
	public abstract void extraMethod(long orderId,String objId,String objType,String methodType) throws Exception;

}
