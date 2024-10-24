package com.loanapp.controller;

import com.loanapp.model.CreditApplication;
import com.loanapp.service.ClientService;
import com.loanapp.service.CreditApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreditApplicationController {

    @Autowired
    private CreditApplicationService creditApplicationService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/applications")
    public String listApplications(Model model) {
        model.addAttribute("applications", creditApplicationService.getAllApplications());
        return "credit-application-list";
    }

    @PostMapping("/applications/new")
    public String submitApplication(@ModelAttribute("application") CreditApplication creditApplication) {
        creditApplicationService.submitApplication(creditApplication);
        return "redirect:/applications";
    }
}
