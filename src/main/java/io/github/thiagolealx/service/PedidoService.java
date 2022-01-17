package io.github.thiagolealx.service;

import io.github.thiagolealx.domain.entity.Pedido;
import io.github.thiagolealx.domain.enums.StatusPedido;
import io.github.thiagolealx.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar( PedidoDTO dto );
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
