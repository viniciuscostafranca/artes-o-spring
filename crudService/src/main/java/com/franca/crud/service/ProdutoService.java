package com.franca.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.franca.crud.dataVO.ProdutoVO;
import com.franca.crud.entity.Produto;
import com.franca.crud.exeception.ResourceNotFoundException;
import com.franca.crud.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;

	public ProdutoVO create(ProdutoVO prod) {

		ProdutoVO result = ProdutoVO.create(repository.save(Produto.create(prod)));
		return result;
	}

	public Page<ProdutoVO> findAll(Pageable pageable) {
		var page = repository.findAll(pageable);
		return page.map(this::convertToProdutoVO);
	}

	private ProdutoVO convertToProdutoVO(Produto produto) {
		return ProdutoVO.create(produto);
	}

	public ProdutoVO findById(Long id) {
		var obj = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return ProdutoVO.create(obj);
	}

	public ProdutoVO update(ProdutoVO produtoVO) {
		Long id = produtoVO.getId();
		final Optional<Produto> optionalProduto = repository.findById(id);
		if (!optionalProduto.isPresent()) {
			new ResourceNotFoundException("No records found for this id");
		}
		
		return ProdutoVO.create(repository.save(Produto.create(produtoVO)));
	}
	public void delete(Long id) {
		var obj = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(obj);
		
	}

}
