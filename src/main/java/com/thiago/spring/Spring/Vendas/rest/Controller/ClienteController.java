package com.thiago.spring.Spring.Vendas.rest.Controller;

import com.thiago.spring.Spring.Vendas.domain.entity.Cliente;
import com.thiago.spring.Spring.Vendas.domain.repository.ClientesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ClienteController {

    private ClientesRepository clientesRepository;

    public ClienteController(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @GetMapping("/api/cliente/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> getClienteById  (@PathVariable Integer id){
       Optional<Cliente> cliente = clientesRepository.findById(id);

       if (cliente.isPresent()) {
           return ResponseEntity.ok(cliente.get());
       }

       return ResponseEntity.notFound().build();

    }

    @PostMapping("/api/cliente")
    @ResponseBody
    public ResponseEntity save (@RequestBody Cliente cliente){
         Cliente clienteSalvo = clientesRepository.save(cliente);
         return ResponseEntity.ok(clienteSalvo);
    }

    @DeleteMapping("api/cliente/{id}")
    @ResponseBody
    public ResponseEntity delete (@PathVariable Integer id){
        Optional<Cliente>cliente = clientesRepository.findById(id);

        if (cliente.isPresent()) {
            clientesRepository.delete(cliente.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
