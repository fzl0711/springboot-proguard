package com.shark.example.configuration.swagger;

import com.shark.example.configuration.security.SecurityConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean("docket")
    public Docket docket() {
        List<Parameter> parameterList = new ArrayList<>();
        parameterList.add(new ParameterBuilder().name(SecurityConfiguration.ACCESS_HEADER).description("請輸入JWT")
                .modelRef(new ModelRef("string")).parameterType("header").required(false).build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.apiInfo())
                .globalOperationParameters(parameterList)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shark.example.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Public API")
                .contact(new Contact("Shark", "", ""))
                .version("1")
                .build();
    }
}