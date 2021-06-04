/**
 * 
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import database.ConnectionFactory;

public class Main {

	
	public static void main(String[] args) {
		
		
		
		Connection con = new ConnectionFactory().getConnection();
		System.out.println("Conectou chefe, confia");
        
		
		
	}

}
