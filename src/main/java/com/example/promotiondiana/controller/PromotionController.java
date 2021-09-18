package com.example.promotiondiana.controller;

import com.example.promotiondiana.dto.ClientDto;
import com.example.promotiondiana.dto.PromotionDto;
import com.example.promotiondiana.model.Client;
import com.example.promotiondiana.model.Promotion;
import com.example.promotiondiana.service.ClientService;
import com.example.promotiondiana.service.GenericService;
import com.example.promotiondiana.service.PromotionService;
import com.example.promotiondiana.service.PromotionServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/promotion")
public class PromotionController extends GenericController<Promotion, PromotionDto> {

    private PromotionService service;
    private PromotionServiceImpl serviceimpl;

    @Override
    protected GenericService getService() {
        return service;
    }

    @GetMapping("/$birthdate")
    public List<String> sendPromotionToBirthdate() {
        List<Client> clients = this.serviceimpl.sendEmailwithDiscount();
        return clients.stream().map(Client::getName).collect(Collectors.toList());
    }
}
