package com.kandemirmert.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

    @Bean
    public RestTemplate getRestTemplateBean() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
