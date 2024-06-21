package com.company.recruitment.service;

import com.company.recruitment.model.Application;

import java.util.List;

public interface ApplicationService {
    Application save(Application application);
    List<Application> findByCandidateId(Long candidateId);
    List<Application> findByJobId(Long jobId);
}
