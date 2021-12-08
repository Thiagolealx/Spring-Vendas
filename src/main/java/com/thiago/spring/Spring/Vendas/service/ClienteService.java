package com.thiago.spring.Spring.Vendas.service;

import com.thiago.spring.Spring.Vendas.model.Cliente;
import com.thiago.spring.Spring.Vendas.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClientesRepository repository;

    @Autowired
    public ClienteService(ClientesRepository repository){
        this.repository = repository;
    }

    public void salvarCliente (Cliente cliente){
        validarCliente(cliente);
        this.repository.pesistir(cliente);
    }

    public void validarCliente(Cliente cliente){
        //aplica validações
    }
}
