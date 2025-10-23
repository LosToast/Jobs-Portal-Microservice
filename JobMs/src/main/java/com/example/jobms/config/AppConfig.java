package com.example.jobms.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    /*
    * When there are multiple instances of the same microservice running,
    * the system will distribute incoming requests across those instances — instead of always hitting just one.
    *
    * RestTemplate is not LoadBalanced
    *
    * What if you forgot @LoadBalanced
    * The plain RestTemplate doesn’t know that 'CompanyMs' is a logical name from Eureka.
    * It tries to resolve user-service using DNS (like a real domain), fails, and throws an error.
    *
    * When @LoadBalanced
    * Understand http://CompanyMs is a logical name (not a real URL).
    * Ask Eureka for the real IP and port of user-service.
    * Pick one instance (load balance).
    * Make the HTTP call.
    *
    * */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /*
    *
    * When we use Feign Client to make calls to services we do not require
    * Bean with load balance just like rest template
    * because feign client has built in load balance feature
    *
    * */
}
