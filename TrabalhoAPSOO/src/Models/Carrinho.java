package Models;

import java.util.ArrayList;

public class Carrinho {

	private int idCarrinho;
	private int quantidadeProdutos;
	private double valorVenda;
	private int formaPagamento;
	private ArrayList<ProdutoCarrinho> produtosCarrinho;
	
	public Carrinho() {
		produtosCarrinho = new ArrayList<ProdutoCarrinho>();
	}
	
	public void calcularValorTotal() {
		produtosCarrinho.forEach((produto) ->  this.setValorVenda(this.getValorVenda() + produto.getPreco()));
	}
	
	public void addProduto(Produto produto) {
		if(this.getProdutos().size() != 0) {
			for(int i = 0; i <= this.getProdutos().size(); i++) {
				if(produto.getCodigoProduto() == produtosCarrinho.get(i).getCodigoProduto()) {
					produtosCarrinho.get(i).setQuantidadeProduto(produtosCarrinho.get(i).getQuantidadeProduto() + 1);
					produtosCarrinho.get(i).setPreco(produtosCarrinho.get(i).getPreco() + produto.getPreco());
				}else {
					ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho(produto.getCodigoProduto(), produto.getPreco());
					produtosCarrinho.add(produtoCarrinho);
					break;
				}
			}
		}else {
			ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho(produto.getCodigoProduto(), produto.getPreco());
			produtosCarrinho.add(produtoCarrinho);
		}
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

	public ArrayList<ProdutoCarrinho> getProdutos() {
		return produtosCarrinho;
	}
	
	
}
