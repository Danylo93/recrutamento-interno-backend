package com.company.recruitment.controller;

import com.company.recruitment.model.Application;
import com.company.recruitment.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public Application applyForJob(@RequestBody Application application) {
        return applicationService.save(application);
    }

    @GetMapping("/candidate/{candidateId}")
    public List<Application> getApplicationsByCandidate(@PathVariable Long candidateId) {
        return applicationService.findByCandidateId(candidateId);
    }

    @GetMapping("/job/{jobId}")
    public List<Application> getApplicationsByJob(@PathVariable Long jobId) {
        return applicationService.findByJobId(jobId);
    }
}
