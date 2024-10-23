package com.loanapp.repository;




import com.loanapp.model.Client;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ClientRepository {

    private final SessionFactory sessionFactory;

    public ClientRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void save(Client client) {
        sessionFactory.getCurrentSession().persist(client);
    }

    @Transactional
    public List<Client> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Client", Client.class).list();
    }

    @Transactional
    public List<Client> searchByQuery(String query) {
        return sessionFactory.getCurrentSession().createQuery("from Client where phoneNumber like :query or fullName like :query or passportData like :query", Client.class)
                .setParameter("query", "%" + query + "%")
                .list();
    }
}