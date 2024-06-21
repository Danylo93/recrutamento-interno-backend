package com.company.recruitment.service;

import com.company.recruitment.model.CandidateDashboardData;

public interface CandidateDashboardService {
    CandidateDashboardData getDataForCandidate(Long candidateId);
    // Other methods related to candidate dashboard
}
