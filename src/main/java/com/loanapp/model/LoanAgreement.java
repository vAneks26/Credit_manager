package com.loanapp.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "loan_agreements")
public class LoanAgreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "credit_application_id")
    private CreditApplication creditApplication;

    private String signingStatus;
    private Date signingDate;

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CreditApplication getCreditApplication() {
        return creditApplication;
    }

    public void setCreditApplication(CreditApplication creditApplication) {
        this.creditApplication = creditApplication;
    }

    public String getSigningStatus() {
        return signingStatus;
    }

    public void setSigningStatus(String signingStatus) {
        this.signingStatus = signingStatus;
    }

    public Date getSigningDate() {
        return signingDate;
    }

    public void setSigningDate(Date signingDate) {
        this.signingDate = signingDate;
    }
}