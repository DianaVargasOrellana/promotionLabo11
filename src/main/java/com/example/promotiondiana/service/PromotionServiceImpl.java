package com.example.promotiondiana.service;


import com.example.promotiondiana.model.Client;
import com.example.promotiondiana.model.Promotion;
import com.example.promotiondiana.repository.ClientRepository;
import com.example.promotiondiana.repository.GenericRepository;
import com.example.promotiondiana.repository.PromotionRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class PromotionServiceImpl extends GenericServiceImpl<Promotion>{
    private final PromotionRepository repository;
    private ClientRepository repositoryClient;

    @Value("${promotion.service.discount}")
    private String discount;
    @Value("${promotion.service.discountblckdays}")
    private String discountBlackdays;

    @Autowired
    private ClientServiceImpl clientService;
    @Autowired
    private MailserviceImpl mailservice;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private PromotionRepository promotionRepository;

    public PromotionServiceImpl(PromotionRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<Promotion> getRepository() {
        return repository;
    }

    public List<Client> sendEmailwithDiscount(){
        List<Client> toSendDiscount = clientService.findByBirthday();
        String discountEmail = "0";
        if(discountBlackdays == "true"){
            discountEmail = "50";
        }else{
            discountEmail = discount;
        }

        for (Client c:toSendDiscount) {
            Promotion p = new Promotion();
            p.setDescription(c.getName(), discountEmail);
            mailservice.sendSimpleMessage(p.getDescription());
            this.repository.save(p);
        }
        return toSendDiscount;
    }

}