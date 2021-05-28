package Classes;

public class Produto {

	private int codigoProduto;
	private String nomeProduto;
	private double preco;
	private int quantidadeEstoque;
	private String tipoProduto;
	
	public Produto(int codigoProduto, String nomeProduto, double Preco, int quantidadeEstoque, String tipoProduto) {
		this.setCodigoProduto(codigoProduto);
		this.setNomeProduto(nomeProduto);
		this.setPreco(Preco);
		this.setQuantidadeEstoque(quantidadeEstoque);
		this.setTipoProduto(tipoProduto);
	}
	
	public void descontarEstoque() {
		this.setQuantidadeEstoque(this.getQuantidadeEstoque() - 1);
	}

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	
	
	
}