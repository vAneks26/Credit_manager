package com.loanapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "credit_applications")
public class CreditApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private double desiredLoanAmount;
    private String decisionStatus;
    private int loanTermDays;
    private double approvedLoanAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getDesiredLoanAmount() {
        return desiredLoanAmount;
    }

    public void setDesiredLoanAmount(double desiredLoanAmount) {
        this.desiredLoanAmount = desiredLoanAmount;
    }

    public int getLoanTermDays() {
        return loanTermDays;
    }

    public void setLoanTermDays(int loanTermDays) {
        this.loanTermDays = loanTermDays;
    }

    public String getDecisionStatus() {
        return decisionStatus;
    }

    public void setDecisionStatus(String decisionStatus) {
        this.decisionStatus = decisionStatus;
    }

    public double getApprovedLoanAmount() {
        return approvedLoanAmount;
    }

    public void setApprovedLoanAmount(double approvedLoanAmount) {
        this.approvedLoanAmount = approvedLoanAmount;
    }
}
