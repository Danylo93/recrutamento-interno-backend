package com.company.recruitment.service;

import com.company.recruitment.model.Job;
import com.company.recruitment.model.JobApplication;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();
    Job createJob(Job job);
    Job updateJob(Long id, Job job);
    JobApplication applyForJob(Long jobId, Long candidateId, JobApplication application);
    void deleteJob(Long id);
    Job getJobById(Long id);
}
