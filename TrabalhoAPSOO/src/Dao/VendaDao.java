package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Venda;
import database.ConnectionFactory;

public class VendaDao {
	
	
	public static void store(Venda venda) {
		
		Connection conn = new ConnectionFactory().getConnection();
		
		try {
			String sql             = "INSERT INTO Venda (idCarrinho, dataVenda, horaVenda) VALUES (?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, Integer.toString(venda.getCarrinho().getIdCarrinho()));
			stmt.setString(2, venda.getDataVenda());
			stmt.setString(3, venda.getHoraVendaString());
			
		    stmt.executeQuery();
		    conn.close();
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	
}
