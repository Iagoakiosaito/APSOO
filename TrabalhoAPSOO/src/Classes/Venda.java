package Classes;

public class Venda {

	private String dataVenda;
	private String horaVendaString;
	private int idCarrinho;
	
	public Venda(String dataVenda, String horaVendaString, int idCarrinho) {
		super();
		this.dataVenda = dataVenda;
		this.horaVendaString = horaVendaString;
		this.idCarrinho = idCarrinho;
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

	public int getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(int idCarrinho) {
		this.idCarrinho = idCarrinho;
	}
	
	
}
