package com.example.promotiondiana.service;

import com.example.promotiondiana.dto.ClientDto;
import com.example.promotiondiana.model.Client;
import com.example.promotiondiana.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;



//@SpringBootTest
class ClientServiceImplTest {
    @Autowired
    ClientServiceImpl clientServiceimpl;

    @Autowired
    private ClientRepository clientRepository;

   // @Test
   /* public void test1(){
        clientService.findByBirthday();
        assertTrue(clientService.findByBirthday().size() >= 1);
    }*/

    @Test
    public void test2(){
        Client c = new Client();
        c.setName("Diana");
        c.setEmail("@gmail");
        c.setBirthday("08/18");
        c.setId(-1L);
        clientRepository.save(c);
        System.out.println("categoryElements: "+clientRepository.count());
    }
}