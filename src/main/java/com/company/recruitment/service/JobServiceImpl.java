package com.company.recruitment.service;

import com.company.recruitment.model.Job;
import com.company.recruitment.model.JobApplication;
import com.company.recruitment.repository.JobApplicationRepository;
import com.company.recruitment.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final JobApplicationRepository jobApplicationRepository;


    @Autowired
    public JobServiceImpl(JobRepository jobRepository, JobApplicationRepository jobApplicationRepository) {
        this.jobRepository = jobRepository;
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job updateJob(Long id, Job job) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if (optionalJob.isPresent()) {
            Job existingJob = optionalJob.get();
            existingJob.setTitle(job.getTitle());
            existingJob.setDescription(job.getDescription());
            existingJob.setRequirements(job.getRequirements());
            return jobRepository.save(existingJob);
        } else {
            throw new RuntimeException("Job not found with id " + id);
        }
    }

    @Override
    public Job getJobById(Long id) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        return optionalJob.orElse(null);
    }

    @Override
    public JobApplication applyForJob(Long jobId, Long candidateId, JobApplication application) {
    application.setJobId(jobId);
    application.setCandidateId(candidateId);
    application.setStatus("Pendente");
    return jobApplicationRepository.save(application);
}

    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
