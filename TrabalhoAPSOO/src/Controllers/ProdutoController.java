package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Produto;
import database.ConnectionFactory;

public class ProdutoController {
	
	
	
	public static ArrayList<Produto> index() {
		Connection conn = new ConnectionFactory().getConnection();
		
      try {
    	  ArrayList<Produto> produtos = new ArrayList<Produto>();
    	  
          PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Produto");
          ResultSet resultQuerry = stmt.executeQuery();

          while (resultQuerry.next()) {
              
	    	  int codigoProduto     = resultQuerry.getInt("codigoProduto");
		      String nomeProduto    = resultQuerry.getString("nomeProduto");
			  double preco          = resultQuerry.getDouble("preco");
			  int quantidadeEstoque = resultQuerry.getInt("quantidadeEstoque");
			  String tipoProduto    = resultQuerry.getString("tipoProduto");
        	  
              Produto produto = new Produto(codigoProduto, nomeProduto, preco, quantidadeEstoque, tipoProduto);

              produtos.add(produto);
          }
          resultQuerry.close();
          stmt.close();
          return produtos;
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
      
	}
	
	public static Produto findProdByCod(int codProduto) {
		
		Connection conn = new ConnectionFactory().getConnection();
		
		try {
			String sql             = "SELECT * FROM Produto WHERE codigoProduto=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, Integer.toString(codProduto));
			
		    ResultSet resultQuerry = stmt.executeQuery();
		    resultQuerry.first();
		    
		    int codigoProduto     = resultQuerry.getInt("codigoProduto");
		    String nomeProduto    = resultQuerry.getString("nomeProduto");
			double preco          = resultQuerry.getDouble("preco");
			int quantidadeEstoque = resultQuerry.getInt("quantidadeEstoque");
			String tipoProduto    = resultQuerry.getString("tipoProduto");
			
			resultQuerry.close();
	        stmt.close();
			
		    return new Produto(codigoProduto, nomeProduto, preco, quantidadeEstoque, tipoProduto);
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static void delete(Produto produto) {
		
		Connection conn = new ConnectionFactory().getConnection();
		
		try {
			String sql             = "UPDATE TABLE produto SET WHERE codigoProduto=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, Integer.toString(produto.getCodigoProduto()));
			
		    ResultSet resultQuerry = stmt.executeQuery();
		    resultQuerry.first();
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
