package com.fire.jdbc.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcConnection {

	String insert = null;

	public static Connection connectionJdbc() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce", "root",
				"Chandru@7984");
		return connection;
	}
	 
	public PreparedStatement prepare(String insert) {
		try {
			PreparedStatement prepareStatement = connectionJdbc().prepareStatement(insert);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
}

