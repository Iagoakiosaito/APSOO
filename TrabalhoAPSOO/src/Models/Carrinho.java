package Models;

import java.util.ArrayList;

public class Carrinho {

	private int quantidadeProdutos;
	private double valorVenda;
	private int formaPagamento;
	private ArrayList<Produto> produtos;
	
	public Carrinho() {
		this.setQuantidadeProdutos(0);
		produtos = new ArrayList<Produto>();
	}
	
	public void calcularValorTotal() {
		produtos.forEach((produto) ->  this.setValorVenda(this.getValorVenda() + produto.getPreco()));
	}
	
	public void descontarProdutosEstoque() {
		produtos.forEach((produto) -> produto.descontarEstoque());
	}
	
	public void addProduto(Produto produto) {
		produtos.add(produto);
		this.setQuantidadeProdutos(this.getQuantidadeProdutos() + 1);
		System.out.println(produto.getNomeProduto() + " adicionado ao carrinho");
	}
	
	public void addFormaPagamento(int formaPagamento) {
		this.setFormaPagamento(formaPagamento);
	}
	
	public double troco(double valorEmDinheiro) {
		return valorEmDinheiro - this.getValorVenda();
	}

	public int getQuantidadeProdutos() {
		return quantidadeProdutos;
	}


	public void setQuantidadeProdutos(int quantidadeProdutos) {
		this.quantidadeProdutos = quantidadeProdutos;
	}


	public double getValorVenda() {
		return valorVenda;
	}


	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}


	public int getFormaPagamento() {
		return formaPagamento;
	}


	public void setFormaPagamento(int formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@Override
	public String toString() {
		return "Carrinho [quantidadeProdutos=" + quantidadeProdutos + ", valorVenda=" + valorVenda + ", formaPagamento="
				+ formaPagamento + "]";
	}
	
	
	
}
