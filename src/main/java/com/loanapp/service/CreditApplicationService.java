package com.loanapp.service;

import com.loanapp.RandomDecisionMaker;
import com.loanapp.model.CreditApplication;
import com.loanapp.repository.CreditApplicationRepository;


import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CreditApplicationService {

    private final CreditApplicationRepository creditApplicationRepository;

    private final RandomDecisionMaker randomDecisionMaker;

    public CreditApplicationService(CreditApplicationRepository creditApplicationRepository, RandomDecisionMaker randomDecisionMaker) {
        this.creditApplicationRepository = creditApplicationRepository;
        this.randomDecisionMaker = randomDecisionMaker;
    }

    public void submitApplication(CreditApplication creditApplication) {
        randomDecisionMaker.makeDecision(creditApplication);
        creditApplicationRepository.save(creditApplication);
    }

    public List<CreditApplication> getAllApplications() {
        return creditApplicationRepository.findAll();
    }

    public List<CreditApplication> getApplicationsByStatus(String status) {
        return creditApplicationRepository.findByStatus(status);
    }
}