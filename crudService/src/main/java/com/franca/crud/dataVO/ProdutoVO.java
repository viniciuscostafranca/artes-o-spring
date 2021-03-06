package com.franca.crud.dataVO;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.franca.crud.entity.Produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class ProdutoVO extends RepresentationModel<ProdutoVO> implements Serializable{

	private Long id;
	private String nome;
	private Integer estoque;
	private Double preco;
	
	public static ProdutoVO create(Produto produto) {
		ProdutoVO dto = new ModelMapper().map(produto, ProdutoVO.class);
		return dto;
	}
}
