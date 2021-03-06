package com.franca.pagamento.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "produto_venda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ProdutoVenda  implements Serializable

{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2664886111344302488L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_produto", nullable = false, length = 10)
	private Long idProduto;
	@Column(name = "quantidade")
	private Integer quantidade;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "id_venda")
	private Venda venda;
}

