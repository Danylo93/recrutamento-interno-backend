package com.company.recruitment.service;

import com.company.recruitment.model.CandidateDashboardData;
import org.springframework.stereotype.Service;

@Service
public class CandidateDashboardServiceImpl implements CandidateDashboardService {

    @Override
    public CandidateDashboardData getDataForCandidate(Long candidateId) {
        // Exemplo de implementação fictícia; você deve buscar os dados reais do candidato
        return new CandidateDashboardData(candidateId, "John Doe", "john.doe@example.com");
    }
}
