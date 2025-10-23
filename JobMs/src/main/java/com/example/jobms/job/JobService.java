package com.example.jobms.job;

import com.example.jobms.job.response.ResponseDTO;

import java.util.List;

public interface JobService {
    List<ResponseDTO> findAll();
    ResponseDTO getJobById(Long id);
    void createJob(Job job);
    boolean deleteJobById(Long id);
    boolean updateJob(Long id, Job updatedJob);
}
