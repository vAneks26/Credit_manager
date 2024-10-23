package com.loanapp;

import com.loanapp.model.CreditApplication;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomDecisionMaker {

    private final Random random = new Random();

    public void makeDecision(CreditApplication creditApplication) {
        boolean isApproved = random.nextBoolean();
        creditApplication.setDecisionStatus(isApproved ? "Approved" : "Rejected");

        if (isApproved) {
            creditApplication.setLoanTermDays(random.nextInt(12) + 1);
            creditApplication.setApprovedLoanAmount(creditApplication.getDesiredLoanAmount() * random.nextDouble());
        }
    }
}