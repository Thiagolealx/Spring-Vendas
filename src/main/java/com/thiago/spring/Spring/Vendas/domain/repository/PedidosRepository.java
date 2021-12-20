package com.thiago.spring.Spring.Vendas.domain.repository;

import com.thiago.spring.Spring.Vendas.domain.entity.ClienteEntity;
import com.thiago.spring.Spring.Vendas.domain.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidosRepository extends JpaRepository<PedidoEntity, Integer> {

    List<PedidoEntity> findByCliente(ClienteEntity cliente);

}
