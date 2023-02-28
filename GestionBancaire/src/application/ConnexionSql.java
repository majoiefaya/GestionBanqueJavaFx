package application;

import java.sql.*;

public class ConnexionSql {
	
	public Connection cn=null;
	public static Connection ConnexionDB() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
			System.out.println("connexion reussi");
			return cn;
		} catch (ClassNotFoundException |SQLException e) {
			System.out.println("connexion no dey");
			e.printStackTrace();
			return null;
		}
	}
	

}
