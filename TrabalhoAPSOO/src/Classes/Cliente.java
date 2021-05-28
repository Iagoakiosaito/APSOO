package Classes;

public class Cliente extends Pessoa {

	private int idCliente;

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

}
