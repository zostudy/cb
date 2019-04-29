package com.asiainfo.rms.auth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;



@SpringBootApplication(scanBasePackages = {"com.asiainfo"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.asiainfo"})
public class AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }
}
