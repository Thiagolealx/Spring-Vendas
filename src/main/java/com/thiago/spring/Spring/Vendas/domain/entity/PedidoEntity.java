package com.thiago.spring.Spring.Vendas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @Column(name = "data_pedido")
    private LocalDate dataPedido;

    @Column(name = "total",length = 2, precision = 20)
    private BigDecimal total;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedidoEntity> itens;

}
