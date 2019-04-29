package com.asiainfo.rms.workflow.client;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;

import com.asiainfo.rms.workflow.web.common.WorkflowController;

@EnableFeignClients(basePackages = "com.asiainfo.rms")
@FeignClient(name = "workflow", path = "/workflow")
public interface WorkflowClient extends WorkflowController{

}
