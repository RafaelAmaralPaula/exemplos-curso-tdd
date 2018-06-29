package com.lovelacetecnologia.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private Double valorTotal = 0.0;
	private Double valorDesconto = 0.0;

	private List<ItemPedido> itensPedidos = new ArrayList<>();

	public void adicionarItem(ItemPedido itemPedido) {
		itensPedidos.add(itemPedido);
	}

	public ResumoPedido resumo() {

		double valorTotal = itensPedidos.stream().mapToDouble(i -> i.getValorUnitario() * i.getQuantidade()).sum();

		double valorDesconto = 0;

		if (valorTotal > 300.0 && valorTotal <=800.0) {
			valorDesconto = valorTotal * 0.04;
		
		}else if(valorTotal > 800.0 && valorTotal <=1000 ) {
			valorDesconto = valorTotal * 0.06;
		
		}else if(valorTotal > 1000.0 ) {
			valorDesconto = valorTotal * 0.08;
		}
			

		return new ResumoPedido(valorTotal, valorDesconto);

	}

}
