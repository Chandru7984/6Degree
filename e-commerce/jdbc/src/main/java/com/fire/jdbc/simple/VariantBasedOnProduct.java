package com.fire.jdbc.simple;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VariantBasedOnProduct {

	public static void main(String[] args) {

		jdbcConnection connection = null;

		try {

			Connection connection1 = connection.connectionJdbc();
			String insert = "SELECT pro.id AS productId,br.name AS brandname,cat.name AS gender,pro.name AS productName,si.size AS size,co.name AS color,"
					+ "var.mrp AS mrp,var.sellingprice AS sellingPrice\r\n" + " FROM variant var\r\n"
					+ " JOIN size si ON (si.isdeleted = 0 AND var.sizeid = si.id)\r\n"
					+ " JOIN color co ON (co.isdeleted = 0 AND var.colorid = co.id)\r\n"
					+ " JOIN product pro ON (pro.isdeleted = 0 AND var.productid = pro.id)\r\n"
					+ " JOIN category cat ON (cat.isdeleted = 0 AND pro.categoryid = cat.id)\r\n"
					+ " JOIN brand br ON (br.isdeleted = 0 AND pro.brandid = br.id)\r\n"
					+ " WHERE pro.id = 1;\r\n;";
			PreparedStatement prepareStatement = connection1.prepareStatement(insert);
			ResultSet executeQuery = prepareStatement.executeQuery();
			
			System.out.println("---------------------------------------------------");
			System.out.println("1. Write a Query to fetch variants based on product");
			System.out.println("---------------------------------------------------");

			System.out.printf("%5s %15s %10s %20s %20s %10s %10s %15s", "Id", "brandName", "gender", "productName",
					"size", "color", "mrp", "sellingPrice");

			while (executeQuery.next()) {
				long id = executeQuery.getLong(1);
				String brandName = executeQuery.getString(2);
				String gender = executeQuery.getString(3);
				String productName = executeQuery.getString(4);
				String size = executeQuery.getString(5);
				String color = executeQuery.getString(6);
				BigDecimal mrp = executeQuery.getBigDecimal(7);
				BigDecimal sellingPrice = executeQuery.getBigDecimal(8);
				
				
				System.out.println();

				System.out.format("%5s %10s %15s    %15s %8s %11s %10s %10s", id, brandName, gender, productName, size,
						color, mrp, sellingPrice);
			}
			connection1.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
