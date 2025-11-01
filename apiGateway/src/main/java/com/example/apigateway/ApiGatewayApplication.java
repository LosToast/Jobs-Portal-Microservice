package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
*
* What an API Gateway is
* An API Gateway is like a front door for your microservices.
* Imagine you have many services:
* Company Service → handles company data
* Job Service → handles job postings
* Review Service → handles reviews
* Instead of the client (Postman, web app, mobile app) calling each service directly,
* the client calls one place — the API Gateway.

So the API Gateway acts as:
* A single entry point to all your services.
* A traffic manager that routes requests to the correct service.
* A filter for security, logging, or modifying requests/responses.
* */
@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

}
