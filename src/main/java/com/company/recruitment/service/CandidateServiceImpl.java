package com.company.recruitment.service;

import com.company.recruitment.model.JobApplication;
import com.company.recruitment.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final JobApplicationRepository jobApplicationRepository;

    @Autowired
    public CandidateServiceImpl(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @Override
    public List<JobApplication> getApplicationsByCandidate(Long candidateId) {
        return jobApplicationRepository.findByCandidateId(candidateId);
    }
}
