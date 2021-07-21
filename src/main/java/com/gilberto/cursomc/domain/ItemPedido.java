package com.gilberto.cursomc.domain;

import java.io.Serializable;

public class ItemPedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private ItemPedidoPK id = new ItemPedidoPK();
	
	
	
	private Double desconto;
	private Integer quantidade;
	private Double preco;
	public ItemPedido() {}
	
	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
		super();
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Pedido getPedido() {
		return this.id.getPedido();
	}
	public Produto getProduto() {
		return this.id.getProduto();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	/*
	 * Copyright 2021 the original author or authors.
	 *
	 * Licensed under the Apache License, Version 2.0 (the "License");
	 * you may not use this file except in compliance with the License.
	 * You may obtain a copy of the License at
	 *
	 *      https://www.apache.org/licenses/LICENSE-2.0
	 *
	 * Unless required by applicable law or agreed to in writing, software
	 * distributed under the License is distributed on an "AS IS" BASIS,
	 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	 * See the License for the specific language governing permissions and
	 * limitations under the License.
	 */
 
}
