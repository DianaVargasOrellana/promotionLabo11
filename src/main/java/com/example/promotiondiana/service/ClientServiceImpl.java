package com.example.promotiondiana.service;

import com.example.promotiondiana.model.Client;
import com.example.promotiondiana.repository.ClientRepository;
import com.example.promotiondiana.repository.GenericRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ClientServiceImpl extends GenericServiceImpl<Client> implements ClientService{
    private final ClientRepository repository;

    @Autowired
    private EntityManager entityManager;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }



    @Override
    protected GenericRepository<Client> getRepository() {
        return repository;
    }


    public List<Client> findByBirthday() {
        Session currentSession = entityManager.unwrap(Session.class);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        dtf.format(LocalDateTime.now());

        Query<Client> theQuery = currentSession.createQuery("from Client where birthday=:birthdateClient");

        theQuery.setParameter("birthdateClient", "08/18");
        theQuery.executeUpdate();
        List<Client> clients = theQuery.getResultList();
        return clients;

    }
}
