package Models;

import java.util.ArrayList;

public class Carrinho {

	private int idCarrinho;
	private int quantidadeProdutos;
	private double valorVenda;
	private int formaPagamento;
	private ArrayList<Produto> produtos;
	
	public Carrinho() {
		produtos = new ArrayList<Produto>();
	}
	
	public void calcularValorTotal() {
		produtos.forEach((produto) ->  this.setValorVenda(this.getValorVenda() + produto.getPreco()));
	}
	
	
	public void addProduto(Produto produto) {
		produtos.add(produto);
		System.out.println("\n" + produto.getNomeProduto() + " adicionado ao carrinho");
	}
	
	public void addFormaPagamento(int formaPagamento) {
		this.setFormaPagamento(formaPagamento);
	}
	
	public double troco(double valorEmDinheiro) {
		return Math.round(valorEmDinheiro - this.getValorVenda());
	}

	public int getQuantidadeProdutos() {
		return this.getProdutos().size();
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
	

	public int getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(int idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	@Override
	public String toString() {
		return "Carrinho [quantidadeProdutos=" + quantidadeProdutos + ", valorVenda=" + valorVenda + ", formaPagamento="
				+ formaPagamento + "]";
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
}
