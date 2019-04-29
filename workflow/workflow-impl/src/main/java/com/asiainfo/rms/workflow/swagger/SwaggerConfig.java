package com.asiainfo.rms.workflow.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;

import com.google.common.collect.Sets;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
@Profile("swagger")
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket swaggerDocket() {
        Contact contact = new Contact("", "", "");

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("工作流服务")
                .description("提供全平台流程控制服务")
                .contact(contact)
                .version("0.1")
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .produces(Sets.newHashSet("application/json"))
                .consumes(Sets.newHashSet("application/json"))
                .forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.asiainfo.rms"))
                .paths(PathSelectors.any())
                .build();
    }
}
