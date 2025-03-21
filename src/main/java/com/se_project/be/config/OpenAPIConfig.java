package com.se_project.be.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class OpenAPIConfig {
    @Value("${openapi.api.url}")
    private String apiUrl;
    @Bean
    public RestClient restClient(){
        return RestClient.builder().baseUrl(apiUrl).build();
    }
}
