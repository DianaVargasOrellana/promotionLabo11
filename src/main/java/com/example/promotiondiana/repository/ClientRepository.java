package com.example.promotiondiana.repository;

import com.example.promotiondiana.model.Client;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public interface ClientRepository extends GenericRepository<Client>{


}
