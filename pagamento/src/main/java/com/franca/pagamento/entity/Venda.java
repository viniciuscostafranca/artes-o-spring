package com.franca.pagamento.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "venda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Venda  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2582643956579410280L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "data")
	private Date data;
	
	@Column(name = "valorTotal",length = 10)
	private Double valorTotal;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "venda", cascade = CascadeType.REFRESH)
	private List<ProdutoVenda> produtos;
	
	
	
	

}
