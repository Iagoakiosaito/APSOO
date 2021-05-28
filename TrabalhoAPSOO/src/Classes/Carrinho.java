package Classes;

public class Carrinho {

	private int qualidadeProdutos;
	private double valorVenda;
	private String formaPagamento;
	
	
	public Carrinho(int qualidadeProdutos, double valorVenda, String formaPagamento) {
		super();
		this.qualidadeProdutos = qualidadeProdutos;
		this.valorVenda = valorVenda;
		this.formaPagamento = formaPagamento;
	}


	public int getQualidadeProdutos() {
		return qualidadeProdutos;
	}


	public void setQualidadeProdutos(int qualidadeProdutos) {
		this.qualidadeProdutos = qualidadeProdutos;
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
