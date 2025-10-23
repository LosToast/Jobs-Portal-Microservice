package com.example.jobms.openFeign;

import com.example.jobms.job.response.ReviewDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("REVIEWMS")
public interface ReviewClient {
    @GetMapping("/reviews")
    List<ReviewDTO> getReviews(@RequestParam("companyId") Long companyId);
}
