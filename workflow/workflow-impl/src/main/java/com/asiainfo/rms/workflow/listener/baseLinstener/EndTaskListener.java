package com.asiainfo.rms.workflow.listener.baseLinstener;

import java.util.List;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author 刘超
 * @version 1.4
 *
 */
public abstract class EndTaskListener extends WorkflowBaseListener implements ExecutionListener {

	private final static transient Log log = LogFactory.getLog(EndTaskListener.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private RepositoryService repositoryService;

	@Override
	public void notify(DelegateExecution exec) throws Exception {
		String objId =exec.getVariable("objId").toString();
		String objType = exec.getVariable("objType").toString();
		
		List<ProcessDefinition> definitions = repositoryService.createProcessDefinitionQuery().processDefinitionId(exec.getProcessDefinitionId()).list();
		String deployId = definitions.get(0).getDeploymentId();
		String processKey = definitions.get(0).getKey();
		String procInstId = exec.getProcessInstanceId();
		try {
			Object endLinkNo = exec.getVariable("endLinkNo");
			@SuppressWarnings("rawtypes")
			List rtnList = null;
			if(endLinkNo!=null)
				rtnList = this.finishTask(Long.valueOf(deployId), processKey,Long.valueOf(procInstId), objId, objType, endLinkNo.toString());
			else
				rtnList = this.finishTask(Long.valueOf(deployId), processKey,Long.valueOf(procInstId), objId, objType);
			if(rtnList!=null&&rtnList.size()==1){
				//修改业务对象状态
				this.updateObjCurPhaseAndCurStatus(objId,objType,rtnList.get(0).toString());
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

}
