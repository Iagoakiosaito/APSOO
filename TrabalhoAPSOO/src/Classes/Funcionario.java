package Classes;


public class Funcionario extends Pessoa {

	private int codigoFuncionario;
	private double salario;
	private String cargo;
	private String dataAdmissao;

	public Funcionario(String nome, String cpf, String endereco, String telefone, int codigoFuncionario, double salario,
			String cargo, String dataAdmissao) {
		super(nome, cpf, endereco, telefone);
		this.codigoFuncionario = codigoFuncionario;
		this.salario = salario;
		this.cargo = cargo;
		this.dataAdmissao = dataAdmissao;
	}

	public int getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(int codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}


}
