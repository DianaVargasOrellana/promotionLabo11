package com.example.promotiondiana.controller;

import com.example.promotiondiana.dto.ClientDto;
import com.example.promotiondiana.model.Client;
import com.example.promotiondiana.service.ClientService;
import com.example.promotiondiana.service.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController extends GenericController<Client, ClientDto> {
    private ClientService service;

    @Override
    protected GenericService getService() {
        return service;
    }
}
