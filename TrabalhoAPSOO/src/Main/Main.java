package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Dao.CarrinhoDao;
import Dao.ProdutoDao;
import Dao.VendaDao;
import Models.Carrinho;
import Models.Produto;
import Models.Venda;
import Views.Interface;
import database.ConnectionFactory;

public class Main {

	
	public static void main(String[] args) {
		
			Interface interfaceUsuario = new Interface();
			interfaceUsuario.run();

	}

}
