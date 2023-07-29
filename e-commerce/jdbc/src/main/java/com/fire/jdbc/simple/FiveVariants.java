package com.fire.jdbc.simple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FiveVariants {

	public static void main(String[] args) {
		
		jdbcConnection connection;
		
		try {
			
			Connection connectionJdbc = jdbcConnection.connectionJdbc();
			String insert = "SELECT pro.id AS productId,pro.name AS productName,COUNT(*) AS totalvariants\r\n"
					+ "\r\n"
					+ "FROM variant var\r\n"
					+ "JOIN product pro ON (pro.isdeleted = 0 AND var.productid = pro.id)\r\n"
					+ "GROUP BY pro.name\r\n"
					+ "HAVING COUNT(*) > 1;\r\n;";
			PreparedStatement prepareStatement = connectionJdbc.prepareStatement(insert);
			ResultSet executeQuery = prepareStatement.executeQuery();
			
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("2. Write a query to fetch the the products which are in more than 5 variants");
			System.out.println("----------------------------------------------------------------------------");

			System.out.println(String.format("%-20s %-22s %-20s", "productId", "productName", "totalVariants"));
			
			while (executeQuery.next()) {
				long productId = executeQuery.getLong(1);
				String productName = executeQuery.getString(2);
				int totalVariants = executeQuery.getInt(3);

				System.out.println();
				System.out.println(String.format("   %-10s %-32s %-20s", productId, productName,totalVariants));
			}
			connectionJdbc.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
