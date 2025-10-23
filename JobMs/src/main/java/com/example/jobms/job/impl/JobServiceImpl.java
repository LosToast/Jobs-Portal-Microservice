package com.example.jobms.job.impl;


import com.example.jobms.job.Job;
import com.example.jobms.job.JobRepository;
import com.example.jobms.job.JobService;
import com.example.jobms.job.response.CompanyResponseDTO;
import com.example.jobms.job.response.ResponseDTO;
import com.example.jobms.job.response.ReviewDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    //private List<Job> jobs = new ArrayList<Job>();
    JobRepository jobRepository;
    private RestTemplate restTemplate;

    public JobServiceImpl(JobRepository jobRepository , RestTemplate restTemplate) {
        this.jobRepository = jobRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<ResponseDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ResponseDTO convertToDto(Job job){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setDescription(job.getDescription());
        responseDTO.setLocation(job.getLocation());
        responseDTO.setTitle(job.getTitle());
        responseDTO.setMaxSalary(job.getMaxSalary());
        responseDTO.setMinSalary(job.getMinSalary());

        String url = "http://COMPANYMS:8082/companies/" + job.getCompanyId();
        CompanyResponseDTO companyResponseDTO = restTemplate.getForObject(url , CompanyResponseDTO.class);

        ResponseEntity<List<ReviewDTO>> reviewResponse = restTemplate.exchange(
                "http://REVIEWMS:8083/reviews?companyId=" + job.getCompanyId(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ReviewDTO>>() {
                });

        companyResponseDTO.setReviews(reviewResponse.getBody());

        responseDTO.setCompanyResponseDTO(companyResponseDTO);

        return  responseDTO;
    }

    public ResponseDTO getJobById(Long id){
        Job job = jobRepository.findById(id).orElse(null);
        return convertToDto(job);
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {

        Optional<Job> jobOptional = jobRepository.findById(id);

        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job); //si existe, lo actualiza (upsert)
            return true;
        }
        return false;
    }
}
