package Models;

public class Venda {

	private String dataVenda;
	private String horaVendaString;
	private Carrinho carrinho;
	private Funcionario funcionario;
	private Cliente cliente;
	
	public Venda(String dataVenda, String horaVendaString, Carrinho carrinho) {
		super();
		this.dataVenda = dataVenda;
		this.horaVendaString = horaVendaString;
		this.carrinho = carrinho;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getHoraVendaString() {
		return horaVendaString;
	}

	public void setHoraVendaString(String horaVendaString) {
		this.horaVendaString = horaVendaString;
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
