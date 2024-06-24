package com.company.recruitment.controller;


import com.company.recruitment.model.JobApplication;
import com.company.recruitment.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/candidates/{candidateId}/applications")
public class CandidateController {

    private final CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public ResponseEntity<List<JobApplication>> getApplicationsByCandidate(@PathVariable Long candidateId) {
        List<JobApplication> applications = candidateService.getApplicationsByCandidate(candidateId);
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }
}
