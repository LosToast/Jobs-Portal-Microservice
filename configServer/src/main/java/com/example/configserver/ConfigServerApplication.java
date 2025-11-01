package com.example.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
/*
* What It Is

A Config Server is a central place to store all your application configuration
* (like database URLs, credentials, feature flags, etc.),
* so that multiple Spring Boot apps can share and update configuration easily —
* without rebuilding or redeploying them.
*
* 1. Centralized Configuration Management
* All your app settings live in one central place (usually a Git repo).
* You don’t need to update every microservice manually — just change one config file, and all clients can pick it up.
*
* 2. Dynamic / Runtime Updates
* With Spring Cloud Bus or /actuator/refresh, apps can reload new configuration without restarting.
* Perfect for changing things like feature flags or limits while the system is running.
*
* 3.Environment-Specific Configurations
* You can have different configs for dev, test, staging, and production.
* Example in Git:
* application-dev.yml
* application-prod.yml
* The client app automatically loads the right one based on its spring.profiles.active.
*
* */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
