package com.franca.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.franca.crud.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
