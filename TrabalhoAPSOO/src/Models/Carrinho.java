package Models;

import java.util.ArrayList;

public class Carrinho {

	private int quatidadeProdutos;
	private double valorVenda;
	private String formaPagamento;
	private ArrayList<Produto> produtos;
	
	public double calcularValorTotal() {
		produtos.forEach((produto) ->  this.setValorVenda(this.getValorVenda() + produto.getPreco()));
		return this.getValorVenda();
	}
	
	public void descontarProdutosEstoque() {
		produtos.forEach((produto) -> produto.descontarEstoque());
	}
	
	public void addProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public void addFormaPagamento(int formaPagamento) {
		
		switch(formaPagamento) {
			case 1:
				this.setFormaPagamento("Dinheiro");
				break;
			case 2:
				this.setFormaPagamento("Cartão de crédito/débito");
				break;
			default:
				this.setFormaPagamento("Isso não existe cara");
		}
		
	}
	
	public double troco(double valorEmDinheiro) {
		return valorEmDinheiro - this.getValorVenda();
	}

	public int getQualidadeProdutos() {
		return quatidadeProdutos;
	}


	public void setQualidadeProdutos(int qualidadeProdutos) {
		this.quatidadeProdutos = qualidadeProdutos;
	}


	public double getValorVenda() {
		return valorVenda;
	}


	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}


	public String getFormaPagamento() {
		return formaPagamento;
	}


	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	
	
}
