package Models;

public class ProdutoDoPedido {

	private String nomeProduto;
	private int codigoProduto;
	private int quantidadeProduto;
	
	public ProdutoDoPedido(String nomeProduto, int codigoProduto, int quantidadeProduto) {
		this.setNomeProduto(nomeProduto);
		this.setCodigoProduto(codigoProduto);
		this.setQuantidadeProduto(quantidadeProduto);
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}
	
	
}
