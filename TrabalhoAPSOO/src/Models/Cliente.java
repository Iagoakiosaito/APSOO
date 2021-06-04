package Models;

public class Cliente extends Pessoa {

	private int idCliente;
	private int qtdVenda;

	public Cliente(String nome, String cpf, String endereco, String telefone, int idCliente) {
		super(nome, cpf, endereco, telefone);
		this.idCliente = idCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public int getQtdVenda() {
		return qtdVenda;
	}

	public void setQtdVenda(int qtdVenda) {
		this.qtdVenda = qtdVenda;
	}


}
