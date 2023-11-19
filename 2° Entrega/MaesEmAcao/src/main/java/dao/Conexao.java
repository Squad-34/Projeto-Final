package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "yudga75";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/maesemacao";

	public static Connection createConnectionToMySql() throws 
	Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection (DATABASE_URL,USERNAME,PASSWORD);
		return connection;
	}	
}