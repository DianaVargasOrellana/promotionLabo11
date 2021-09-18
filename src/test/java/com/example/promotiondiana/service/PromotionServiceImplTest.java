package com.example.promotiondiana.service;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import com.example.promotiondiana.controller.PromotionController;
import com.example.promotiondiana.dto.ClientDto;
import com.example.promotiondiana.model.Client;
import com.example.promotiondiana.model.Promotion;
import com.example.promotiondiana.repository.ClientRepository;
import com.example.promotiondiana.repository.PromotionRepository;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest
class PromotionServiceImplTest {
    @Mock
    ClientRepository clientRepository;
    @Mock
    PromotionRepository promotionRepository;

    @Mock
    PromotionController controller;
    @Mock
    ModelMapper modelMapper;
    @Mock
    Logger logger;
    @InjectMocks
    PromotionServiceImpl promotionServiceImpl;
    @InjectMocks
    ClientServiceImpl clientServiceImpl;

    private ClientDto client;
    private Promotion promotion;


    @BeforeTestMethod
    public void before(){
        initMocks(this);
        String date = "08/10";
        client = new ClientDto();
        client.setName("Diana");
        client.setEmail("dianav715@gmail.com");
        client.setBirthday(date);
       // System.out.println(client.getBirthday().toString());

    }

    @Test
    public void testFindByBirthday() {
        List<Client> c = promotionServiceImpl.sendEmailwithDiscount();
        assertTrue(c.size() >= 1);
    }

}