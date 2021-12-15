package com.thiago.spring.Spring.Vendas.rest.Controller;

import com.thiago.spring.Spring.Vendas.domain.entity.Cliente;
import com.thiago.spring.Spring.Vendas.domain.repository.ClientesRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClientesRepository clientesRepository;

    public ClienteController(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @GetMapping("{id}")
    public Cliente getClienteById  (@PathVariable Integer id){
         return clientesRepository
                 .findById(id)
                 .orElseThrow(()-> new ResponseStatusException( HttpStatus.NOT_FOUND,
                         "cliente não econtrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save (@RequestBody Cliente cliente) {
        return clientesRepository.save(cliente);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Integer id){
        clientesRepository.findById(id)
                .map( cliente ->{
                        clientesRepository.delete(cliente );
                         return clientesRepository;
    })
                .orElseThrow(()-> new ResponseStatusException( HttpStatus.NOT_FOUND,
                        "cliente não econtrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update (@PathVariable Integer id,
                        @RequestBody Cliente cliente){
         clientesRepository
        .findById(id)
        .map(clienteExistente -> {
            cliente.setId(clienteExistente.getId());
            clientesRepository.save(cliente);
            return clienteExistente;
        }).orElseThrow(()-> new ResponseStatusException( HttpStatus.NOT_FOUND,
                         "cliente não econtrado"));

    }

    @GetMapping
    public List<ClientesRepository> find (Cliente fitro){
        ExampleMatcher matcher= ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(fitro,matcher);
       return clientesRepository.findAll(example);


    }

}
