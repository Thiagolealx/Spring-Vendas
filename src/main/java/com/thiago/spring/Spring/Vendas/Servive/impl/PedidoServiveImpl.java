package com.thiago.spring.Spring.Vendas.Servive.impl;


import com.thiago.spring.Spring.Vendas.Servive.PedidoService;
import com.thiago.spring.Spring.Vendas.domain.repository.PedidosRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiveImpl implements PedidoService {

    private PedidosRepository pedidosRepository;

    public PedidoServiveImpl(PedidosRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;

    }
}
