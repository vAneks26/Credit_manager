package com.loanapp.repository;

import com.loanapp.model.LoanAgreement;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoanAgreementRepository {

    private final SessionFactory sessionFactory;

    public LoanAgreementRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void save(LoanAgreement loanAgreement) {
        sessionFactory.getCurrentSession().persist(loanAgreement);
    }

    @Transactional
    public List<LoanAgreement> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from LoanAgreement", LoanAgreement.class).list();
    }
}