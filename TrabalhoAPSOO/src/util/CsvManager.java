package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import Models.PedidoInsumos;

public class CsvManager {

	private final String path        = "/home/volpe";
	private final String fileHeader = "Nome do produto,Quantidade\n"; 
	private File planilhaPedido;
	
	
	public CsvManager() {
		this.setPlanilhaPedido(new File(this.getPath() + "/Erva_da_boa/teste_table1.csv"));
	
	}
	
	public void gerarPedido(PedidoInsumos pedido) {
		try {
			PrintWriter pw        = new PrintWriter(this.getPlanilhaPedido());
			StringBuilder builder = new StringBuilder();
			
			builder.append(this.getFileHeader());
			
			pedido.getProdutosPedido().forEach((produto) -> {
				builder.append(produto.getNomeProduto() + ",");
				builder.append(produto.getQuantidadeProduto() + "\n");
			});
			
			
			pw.write(builder.toString());
		    pw.close();
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public String getPath() {
		return path;
	}

	public String getFileHeader() {
		return fileHeader;
	}

	public File getPlanilhaPedido() {
		return planilhaPedido;
	}

	public void setPlanilhaPedido(File planilhaPedido) {
		this.planilhaPedido = planilhaPedido;
	}
	
}
