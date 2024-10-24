package com.loanapp.controller;

import com.loanapp.model.LoanAgreement;
import com.loanapp.service.LoanAgreementService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class LoanAgreementController {

    private final LoanAgreementService loanAgreementService;

    public LoanAgreementController(LoanAgreementService loanAgreementService) {
        this.loanAgreementService = loanAgreementService;
    }

    @GetMapping("/agreements")
    public String listAgreements(Model model) {
        model.addAttribute("agreements", loanAgreementService.getAllLoanAgreements());
        return "loan-agreement-list";
    }

    @PostMapping("/agreements/sign")
    public String signAgreement(@ModelAttribute LoanAgreement loanAgreement, Model model) {
        if ("Approved".equals(loanAgreement.getCreditApplication().getDecisionStatus())) {
            loanAgreement.setSigningStatus("Signed");
            loanAgreement.setSigningDate(new Date());
            loanAgreementService.signAgreement(loanAgreement);
            return "redirect:/agreements";
        }
        model.addAttribute("error", "Loan agreement cannot be signed as the application is not approved.");
        return "loan-agreement-list";
    }
}