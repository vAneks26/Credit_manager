package com.loanapp.repository;


import com.loanapp.model.CreditApplication;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class CreditApplicationRepository {

    private final SessionFactory sessionFactory;

    public CreditApplicationRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void save(CreditApplication creditApplication) {
        sessionFactory.getCurrentSession().persist(creditApplication);
    }

    @Transactional
    public List<CreditApplication> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from CreditApplication", CreditApplication.class).list();
    }

    @Transactional
    public List<CreditApplication> findByStatus(String status) {
        return sessionFactory.getCurrentSession().createQuery("from CreditApplication where decisionStatus = :status", CreditApplication.class)
                .setParameter("status", status)
                .list();
    }
}