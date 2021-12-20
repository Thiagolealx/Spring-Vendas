package com.thiago.spring.Spring.Vendas.rest.Controller;


import com.thiago.spring.Spring.Vendas.domain.entity.ProdutoEntity;
import com.thiago.spring.Spring.Vendas.domain.repository.ProdutosRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private ProdutosRepository produtosRepository;

    public ProdutoController(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;

    }
    @PostMapping
    @ResponseStatus(CREATED)
    public ProdutoEntity save (@RequestBody ProdutoEntity produto) {

        return produtosRepository.save(produto);
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update (@PathVariable Integer id,
                        @RequestBody ProdutoEntity produto){
        produtosRepository
                .findById(id)
                .map(p -> {
                    produto.setId(p.getId());
                    produtosRepository.save(produto);
                    return produto;
                }).orElseThrow(()-> new ResponseStatusException( HttpStatus.NOT_FOUND,
                        "Produto não econtrado"));

    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete (@PathVariable Integer id){
        produtosRepository.findById(id)
                .map( p ->{
                    produtosRepository.delete(p );
                    return Void.TYPE;
                })
                .orElseThrow(()-> new ResponseStatusException( HttpStatus.NOT_FOUND,
                        "Produto não econtrado"));

    }

    @GetMapping("{id}")
    public ProdutoEntity getById  (@PathVariable Integer id) {
        return produtosRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produto não econtrado"));
    }

    @GetMapping
    public List<ProdutosRepository> find (ProdutoEntity fitro){
        ExampleMatcher matcher= ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(fitro,matcher);
        return produtosRepository.findAll(example);


    }
}
