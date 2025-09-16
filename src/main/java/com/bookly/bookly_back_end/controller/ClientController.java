package com.bookly.bookly_back_end.controller;


import com.bookly.bookly_back_end.model.Client;
import com.bookly.bookly_back_end.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {

    public ClientService clientService;

    @PostMapping
    public Client create(@RequestBody Client client){
        return clientService.create(client);
    }

    @GetMapping("{id}")
    public Client getClientById(@PathVariable UUID id){
        return clientService.getClientById(id);
    }

    public void deleteById(@PathVariable UUID id){
        clientService.deleteClientById(id);
    }


}
