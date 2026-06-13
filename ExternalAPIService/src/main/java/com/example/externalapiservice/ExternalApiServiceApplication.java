package com.example.externalapiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages = {"com.example.myuserservice"})
public class ExternalApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExternalApiServiceApplication.class, args);
    }

}
