package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.PedidoInsumos;
import database.ConnectionFactory;

public class PedidoInsumosDao {

	public static void store(PedidoInsumos pedido) {
		
		Connection conn = new ConnectionFactory().getConnection();
		
		try {
			String sql             = "INSERT INTO Venda (idCarrinho, dataVenda, horaVenda) VALUES (?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, pedido.getDataPedido());
			stmt.setString(2, pedido.getDataPedido());
			
		    stmt.executeQuery();
		    conn.close();
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
