package com.asiainfo.rms.workflow;

import com.asiainfo.rms.workflow.util.ApplicationContextUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by liuchao on 2017/7/12.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableTransactionManagement(mode= AdviceMode.PROXY,proxyTargetClass=true)
public class WorkflowApplication {

    public static void main(String args[]){
        ApplicationContext app =  new SpringApplicationBuilder(WorkflowApplication.class).web(true).run(args);
        ApplicationContextUtil.setAc(app);
    }
}
