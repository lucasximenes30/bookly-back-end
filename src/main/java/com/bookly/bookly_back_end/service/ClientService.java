package com.bookly.bookly_back_end.service;

import com.bookly.bookly_back_end.model.Client;
import com.bookly.bookly_back_end.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public class ClientService {

    @Autowired
    public ClientRepository clientRepository;

    public Client create(@RequestBody Client cliente){
        return clientRepository.save(cliente);
    }
    public Client getClientById(@PathVariable UUID id){
        return clientRepository.findById(id).orElseThrow();
    }
    public void deleteClientById(@PathVariable UUID id){
        clientRepository.deleteById(id);
    }
}
