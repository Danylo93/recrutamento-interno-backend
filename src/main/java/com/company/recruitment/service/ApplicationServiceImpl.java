package com.company.recruitment.service;

import com.company.recruitment.model.Application;
import com.company.recruitment.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public List<Application> findByCandidateId(Long candidateId) {
        return applicationRepository.findByCandidateId(candidateId);
    }

    @Override
    public List<Application> findByJobId(Long jobId) {
        return applicationRepository.findByJobId(jobId);
    }
}
