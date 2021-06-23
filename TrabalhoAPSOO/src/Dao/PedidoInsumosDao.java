package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Models.PedidoInsumos;
import database.ConnectionFactory;

public class PedidoInsumosDao {

	public static void store(PedidoInsumos pedido) {
		
		Connection conn = new ConnectionFactory().getConnection();
		
		try {
			String sql             = "INSERT INTO Pedido_insumo (dataPedido) VALUES (?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, pedido.getDataPedido());
			
		    stmt.executeQuery();
		    
		    
		    sql  = "SELECT MAX(idPedido) as idPedido FROM Pedido_insumo";
			stmt = conn.prepareStatement(sql);
			ResultSet resultQuerry = stmt.executeQuery();
		    resultQuerry.first();
		    
		    int idPedido = resultQuerry.getInt("idPedido");

		    //sql = "INSERT INTO Produtos_pedido (idPedido, codigoProduto, quantidade) VALUES ";
		    
		    for(int i = 0; i < pedido.getProdutosPedido().size(); i++) {
		    	sql = "INSERT INTO Produtos_pedido (idPedido, codigoProduto, quantidade) VALUES (?,?,?)";
		    	
		    	stmt = conn.prepareStatement(sql);
		    	
		    	stmt.setString(1, Integer.toString(idPedido));
		    	stmt.setString(2, Integer.toString(pedido.getProdutosPedido().get(i).getCodigoProduto()));
		    	stmt.setString(3, Integer.toString(pedido.getProdutosPedido().get(i).getQuantidadeProduto()));		    	
		    	stmt.executeQuery();
		    }
		    
		    
		    stmt.close();
		    conn.close();
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
