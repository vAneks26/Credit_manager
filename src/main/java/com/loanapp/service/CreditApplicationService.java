package com.loanapp.service;

import com.loanapp.RandomDecisionMaker;
import com.loanapp.model.CreditApplication;
import com.loanapp.repository.CreditApplicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CreditApplicationService {

    @Autowired
    private CreditApplicationRepository creditApplicationRepository;

    @Autowired
    private RandomDecisionMaker randomDecisionMaker;

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