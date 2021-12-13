package com.thiago.spring.Spring.Vendas.domain.repository;

import com.thiago.spring.Spring.Vendas.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface Clientes extends JpaRepository<Cliente, Integer > {

   List<Cliente> findByNomeLike(String nome);
}
