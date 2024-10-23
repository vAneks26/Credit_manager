package com.loanapp.service;

import com.loanapp.model.LoanAgreement;
import com.loanapp.repository.LoanAgreementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanAgreementService {

    private final LoanAgreementRepository loanAgreementRepository;

    public LoanAgreementService(LoanAgreementRepository loanAgreementRepository) {
        this.loanAgreementRepository = loanAgreementRepository;
    }

    public void signAgreement(LoanAgreement loanAgreement) {
        loanAgreementRepository.save(loanAgreement);
    }

    public List<LoanAgreement> getAllLoanAgreements() {
        return loanAgreementRepository.findAll();
    }
}