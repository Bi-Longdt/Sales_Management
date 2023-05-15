package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDB {
	
	Connection conn;
	
	public Connection connectSQL() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getConstructor().newInstance();
			String connectionUrl = "jdbc:sqlserver://DESKTOP-HKFC7CU:1433;" 
									+ "database=QUANLYBANHANG;"
									+ "user=sa;"
									+ "password=!@12345;";
			conn = DriverManager.getConnection(connectionUrl);
			System.out.println("Connected...");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}

}
