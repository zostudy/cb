package com.asiainfo.rms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication(scanBasePackages = "com.asiainfo.rms")
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@MapperScan(basePackages={"com.asiainfo.rms.system.dao","com.asiainfo.rms.alm.reqtmp.dao","com.asiainfo.rms.alm.arsenal.dao","com.asiainfo.rms.alm.demand.dao","com.asiainfo.rms.alm.util.dao"})
public class PlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
    }
}