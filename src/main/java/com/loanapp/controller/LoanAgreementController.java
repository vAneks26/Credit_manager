package com.loanapp.controller;

import com.loanapp.model.LoanAgreement;
import com.loanapp.service.LoanAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoanAgreementController {

    @Autowired
    private LoanAgreementService loanAgreementService;

    @GetMapping("/agreements")
    public String listAgreements(Model model) {
        model.addAttribute("agreements", loanAgreementService.getAllLoanAgreements());
        return "loan-agreement-list";
    }

    @PostMapping("/agreements/sign")
    public String signAgreement(LoanAgreement loanAgreement, Model model) {
        loanAgreementService.signAgreement(loanAgreement);
        return "redirect:/agreements";
    }
}