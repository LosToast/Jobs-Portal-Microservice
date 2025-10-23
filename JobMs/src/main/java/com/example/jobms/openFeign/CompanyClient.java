package com.example.jobms.openFeign;

import com.example.jobms.job.response.CompanyResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
* What is Feign Client
*
* Feign is a declarative HTTP client for Java — mainly used in Spring Boot (especially with Spring Cloud).
* In plain English:
* Instead of writing a lot of boilerplate code to call REST APIs (like with RestTemplate),
* you just create an interface, and Feign automatically makes the HTTP call for you.
* */
@FeignClient(value = "COMPANYMS")
public interface CompanyClient {
    @GetMapping("/companies/{id}")
    CompanyResponseDTO getCompanies(@PathVariable("id") Long id);
}
