package Models;

public class Venda {

	private String dataVenda;
	private String horaVenda;
	private Carrinho carrinho;
	private Funcionario funcionario;
	private Cliente cliente;
	
	public Venda(String dataVenda, String horaVenda, Carrinho carrinho) {
		super();
		this.dataVenda = dataVenda;
		this.horaVenda = horaVenda;
		this.carrinho = carrinho;
	}
	
	public boolean temDesconto(){
		return (this.cliente.getQtdVenda() >= 5) ? true : false;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getHoraVendaString() {
		return horaVenda;
	}

	public void setHoraVendaString(String horaVenda) {
		this.horaVenda = horaVenda;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void addCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void addFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void addCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}
