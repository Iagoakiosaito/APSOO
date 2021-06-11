package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Carrinho;
import Models.Produto;
import database.ConnectionFactory;

public class CarrinhoDao {

	public static Carrinho store(Carrinho carrinho) {
		
		Connection conn = new ConnectionFactory().getConnection();
		
		try {
			String sql             = "INSERT INTO Carrinho (quantidadeProdutos, valorVenda, formaPagamento) VALUES (?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, Integer.toString(carrinho.getQuantidadeProdutos()));
			stmt.setString(2, Double.toString(carrinho.getValorVenda()));
			stmt.setString(3, Integer.toString(carrinho.getFormaPagamento()));
			
		    stmt.executeQuery();
		    
		    sql  = "SELECT MAX(idCarrinho) as idCarrinho FROM Carrinho";
			stmt = conn.prepareStatement(sql);
			ResultSet resultQuerry = stmt.executeQuery();
		    resultQuerry.first();
		    
		    int idCarrinho = resultQuerry.getInt("idCarrinho");
		    carrinho.setIdCarrinho(idCarrinho);
		    return carrinho;
		  	    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}
