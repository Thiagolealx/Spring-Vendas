package com.thiago.spring.Spring.Vendas.domain.repository;

import com.thiago.spring.Spring.Vendas.domain.entity.Cliente;
import com.thiago.spring.Spring.Vendas.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidosRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);

}
