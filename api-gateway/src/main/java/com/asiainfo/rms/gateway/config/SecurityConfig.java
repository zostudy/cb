package com.asiainfo.rms.gateway.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.asiainfo.rms.gateway.properties.AtsSecurityProperties;

@Configuration
@EnableConfigurationProperties(AtsSecurityProperties.class)
public class SecurityConfig {

}
