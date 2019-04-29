package com.asiainfo.rms.workflow.command;

import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ExecutionEntityManager;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by liuchao on 2017/7/28.
 */
public class JDJumpTaskCmd implements Command<Void> {

    protected String executionId;
    protected ActivityImpl desActivity;
    protected Map<String, Object> paramvar;
    protected ActivityImpl currentActivity;
    @Override
    public Void execute(CommandContext commandContext) {
        ExecutionEntityManager executionEntityManager = Context.getCommandContext().getExecutionEntityManager();
        ExecutionEntity executionEntity = executionEntityManager.findExecutionById(executionId);
        executionEntity.setVariables(paramvar);
        executionEntity.setEventSource(this.currentActivity);
        executionEntity.setActivity(this.currentActivity);
        Iterator<TaskEntity> localIterator = Context.getCommandContext()
                .getTaskEntityManager()
                .findTasksByExecutionId(this.executionId).iterator();
        while (localIterator.hasNext()) {
            TaskEntity taskEntity = (TaskEntity) localIterator.next();
            taskEntity.fireEvent("complete");
            Context.getCommandContext().getTaskEntityManager()
                    .deleteTask(taskEntity, "completed", false);
        }
        executionEntity.executeActivity(this.desActivity);
        return null;
    }

    public JDJumpTaskCmd(String executionId, ActivityImpl desActivity,
                         Map<String, Object> paramvar, ActivityImpl currentActivity) {
        this.executionId = executionId;
        this.desActivity = desActivity;
        this.paramvar = paramvar;
        this.currentActivity = currentActivity;
    }
}
