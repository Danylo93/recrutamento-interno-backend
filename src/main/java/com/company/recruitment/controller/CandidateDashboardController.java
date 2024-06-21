package com.company.recruitment.controller;

import com.company.recruitment.model.CandidateDashboardData;
import com.company.recruitment.service.CandidateDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/candidate/dashboard")
public class CandidateDashboardController {

    private final CandidateDashboardService candidateDashboardService;

    @Autowired
    public CandidateDashboardController(CandidateDashboardService candidateDashboardService) {
        this.candidateDashboardService = candidateDashboardService;
    }

    @GetMapping("/{candidateId}")
    public CandidateDashboardData getCandidateDashboardData(@PathVariable Long candidateId) {
        return candidateDashboardService.getDataForCandidate(candidateId);
    }

    // Outros endpoints relacionados ao painel do candidato, se necessário
}
