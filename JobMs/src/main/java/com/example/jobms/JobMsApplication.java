package com.example.jobms;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.TimeZone;

@EnableFeignClients
@SpringBootApplication
public class JobMsApplication {


    public static void main(String[] args) {
        SpringApplication.run(JobMsApplication.class, args);
    }

}
