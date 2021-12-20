package com.thiago.spring.Spring.Vendas.rest.Controller;

import com.thiago.spring.Spring.Vendas.domain.entity.ClienteEntity;
import com.thiago.spring.Spring.Vendas.domain.repository.ClientesRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClientesRepository clientesRepository;

    public ClienteController(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @GetMapping("{id}")
    public ClienteEntity getClienteById  (@PathVariable Integer id){
         return clientesRepository
                 .findById(id)
                 .orElseThrow(()-> new ResponseStatusException( HttpStatus.NOT_FOUND,
                         "cliente não econtrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteEntity save (@RequestBody ClienteEntity cliente) {
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
                        @RequestBody ClienteEntity cliente){
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
    public List<ClientesRepository> find (ClienteEntity fitro){
        ExampleMatcher matcher= ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(fitro,matcher);
       return clientesRepository.findAll(example);


    }

}
