package com.thiago.spring.Spring.Vendas.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItensPedidosDTO {
    private Integer produto;
    private Integer quantidade;

}
