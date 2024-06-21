package com.company.recruitment.service;

import com.company.recruitment.model.Job;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();
    Job createJob(Job job);
    Job updateJob(Long id, Job job);
    void deleteJob(Long id);
}
