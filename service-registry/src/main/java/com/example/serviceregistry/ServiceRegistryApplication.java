package com.example.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
* Service Discovery = Dynamic lookup
* Instead of hardcoding service addresses, services register themselves and look up each other by name.
* It works just like a phonebook or DNS for microservices:
* Services register: “Hi, I’m user-service, and I’m running at IP X, port Y.” (e.g., http://192.168.1.10:8081)
* Other services ask: “Where is user-service?”
* The discovery system replies with the current address.
*
*
* Eureka is: A Service Discovery Server developed by Netflix, widely used in the Spring Cloud ecosystem.
*
* 1. Eureka Server:
* A central registry.
* Services register themselves with the Eureka Server.
* It keeps track of what services are available and where.
* 2. Eureka Client:
* A microservice that registers itself with the Eureka server.
* Also uses the Eureka registry to discover other services.
*
* Eureka supports health checks and load balancing
* If a service goes down, Eureka stops sending its address.
* If there are multiple instances, Eureka provides a list → can load balance.
* */
@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryApplication.class, args);
    }

}
