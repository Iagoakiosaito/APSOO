package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Produto;
import database.ConnectionFactory;

public class ProdutoController {
	
	
	
	public static ResultSet index() {
		Connection conn = new ConnectionFactory().getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Produto");
		    ResultSet resultQuerry = stmt.executeQuery();
		    return resultQuerry;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Produto findProdByCod(int codProduto) {
		
		Connection conn = new ConnectionFactory().getConnection();
		
		try {
			String sql = "SELECT * FROM Produto WHERE codigoProduto=?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, Integer.toString(codProduto));
			
		    ResultSet resultQuerry = stmt.executeQuery();
		    resultQuerry.first();
		    
		    int codigoProduto     = resultQuerry.getInt("codigoProduto");
		    String nomeProduto    = resultQuerry.getString("nomeProduto");
			double preco          = resultQuerry.getDouble("preco");
			int quantidadeEstoque = resultQuerry.getInt("quantidadeEstoque");
			String tipoProduto    = resultQuerry.getString("tipoProduto");
			
		    return new Produto(codigoProduto, nomeProduto, preco, quantidadeEstoque, tipoProduto);
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
}
