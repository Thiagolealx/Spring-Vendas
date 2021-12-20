package com.thiago.spring.Spring.Vendas.domain.repository;

import com.thiago.spring.Spring.Vendas.domain.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<ProdutoEntity, Integer> {
}
