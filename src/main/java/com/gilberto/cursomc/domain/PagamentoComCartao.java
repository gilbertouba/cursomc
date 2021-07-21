package com.gilberto.cursomc.domain;

import javax.persistence.Entity;

import com.gilberto.cursomc.domain.enums.EstadoPagamento;
@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;

	
	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido,Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
		// TODO Auto-generated constructor stub
	}

	public PagamentoComCartao() {}
	
	public PagamentoComCartao(Integer numeroDeParcelas) {
		super();
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	

		
}
