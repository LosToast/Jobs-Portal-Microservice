package com.example.jobms;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class JobMsApplication {


    public static void main(String[] args) {
        SpringApplication.run(JobMsApplication.class, args);
    }

}
