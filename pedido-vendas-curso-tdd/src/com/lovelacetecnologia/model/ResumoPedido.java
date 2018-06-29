package com.lovelacetecnologia.model;

public class ResumoPedido {

	private Double valorTotal;
	private Double valorDesconto;

	public ResumoPedido(Double valorTotal, Double valorDesconto) {
		this.valorTotal = valorTotal;
		this.valorDesconto = valorDesconto;
	}

	
	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	
	public Double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

}
