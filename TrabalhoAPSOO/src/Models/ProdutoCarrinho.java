package Models;

public class ProdutoCarrinho {

	private String nomeProduto;
	private int codigoProduto;
	private double preco;
	private int quantidadeProduto = 1;
	
	public ProdutoCarrinho(String nomeProduto, int codigoProduto, double preco) {
		this.setNomeProduto(nomeProduto);
		this.setCodigoProduto(codigoProduto);
		this.setPreco(preco);
	}
	
	public int getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}
	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	
}
