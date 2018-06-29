package com.lovelacetecnologia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lovelacetecnologia.model.ItemPedido;
import com.lovelacetecnologia.model.Pedido;
import com.lovelacetecnologia.model.ResumoPedido;

public class PedidoTest {

	private Pedido pedido;

	@Before
	public void inicializacaoObjeto() {

		pedido = new Pedido();
	}

	private void assertResumoDoPedido(double valorTotal, double valorDesconto) {
		
		ResumoPedido resumo = pedido.resumo();
		
		assertEquals(valorTotal, resumo.getValorTotal(), 0.0001);
		assertEquals(valorDesconto, resumo.getValorDesconto(), 0.0001);

	}

	@Test
	public void devePermitirAdicionarUmIntemNoPedido() throws Exception {

		pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 10));

	}

	@Test
	public void deveCalcularValorTotalEDescontoParaPedidoVazio() throws Exception {

		assertResumoDoPedido(0.0, 0.0);

	}
	
	@Test
	public void deveCalcularResumoParaUmItemSemDesconto() throws Exception {
		
		pedido.adicionarItem(new ItemPedido("Sabonete", 5.0, 5));
		assertResumoDoPedido(25.0,0.0);
		
		
	}
	
	@Test
	public void deveCalcularResumoParaDoisOuMaisDeUmItemSemDesconto() throws Exception {
		
		pedido.adicionarItem(new ItemPedido("Sabonete", 5.0, 5));
		pedido.adicionarItem(new ItemPedido("Pasta Dental", 3.0, 4));
		pedido.adicionarItem(new ItemPedido("Fio Dental", 3.0, 2));
		pedido.adicionarItem(new ItemPedido("Escova Dental", 3.0, 7));
		
		assertResumoDoPedido(64.0 , 0.0);
	
	}
	
	@Test
	public void deveAplicarDescontoNa1aFaixa() throws Exception {
		pedido.adicionarItem(new ItemPedido("Creme",20.0, 20));
		
		assertResumoDoPedido(400.0 , 16);
		
	}
	
	@Test
	public void deveAplicarDescontoNa2aFaixa() throws Exception {
		pedido.adicionarItem(new ItemPedido("Shampoo",15.0, 30));
		pedido.adicionarItem(new ItemPedido("Condicionador",15.0, 30));
		
		assertResumoDoPedido(900.0 , 54);
		
	}
	
	@Test
	public void deveAplicarDescontoNa3aFaixa() throws Exception {
		pedido.adicionarItem(new ItemPedido("Shampoo",15.0, 30));
		pedido.adicionarItem(new ItemPedido("Condicionador",15.0, 30));
		pedido.adicionarItem(new ItemPedido("Pasta Dental",10.0, 30));
		
		assertResumoDoPedido(1200.0 , 96);
		
	}


}
