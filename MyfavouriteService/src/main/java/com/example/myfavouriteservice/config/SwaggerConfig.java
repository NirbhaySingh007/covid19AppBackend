package com.example.myfavouriteservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.example.serviceability")).build().apiInfo(apiInfo()).useDefaultResponseMessages(false);

    }


    private ApiInfo apiInfo() {

        ApiInfoBuilder apiInfoBuilder=new ApiInfoBuilder();

        return apiInfoBuilder.title("Covid-19 API")
                .description("Swagger for covid-19 Capstone")
                .termsOfServiceUrl("https://Covid-19.example.in/terms_and_conditions.html")
                .contact("nirbhaysingh5139@gmail.com").license("nirbhaysingh5139@gmail.com")
                .licenseUrl("nirbhaysingh5139@gmail.com").version("v1.0.1").build();


    }



}

