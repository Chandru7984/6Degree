package com.fire.jdbc.simple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RatingsAndReviews {

	public static void main(String[] args) {

		jdbcConnection connection = null;
		
		
		try {
			Connection connectionJdbc = connection.connectionJdbc();
			String insert = "SELECT DISTINCT cust.id AS customerId,ordet.id AS orderDetailsId,pro.name AS productName,"
					+ "ratrev.rating AS rating,ratrev.comment AS review\r\n" + "\r\n" + "FROM ratingsreviews ratrev\r\n"
					+ "LEFT JOIN  customer cust ON (cust.isdeleted = 0 AND ratrev.customerid = cust.id)\r\n"
					+ "JOIN orderdetails ordet ON (ordet.isdeleted = 0 AND ratrev.orderdetailsid = ordet.id)\r\n"
					+ "JOIN variant var ON (var.isdeleted = 0 AND ordet.variantid = var.id)\r\n"
					+ "JOIN product pro ON (pro.isdeleted = 0 AND var.productid = pro.id)\r\n"
					+ "JOIN brand br ON (br.isdeleted = 0 AND pro.brandid = br.id)\r\n"
					+ "JOIN designer desi ON (desi.isdeleted = 0 AND br.designerid = desi.id)\r\n" + "\r\n"
					+ "WHERE cust.id = 4 OR desi.id = 4;\r\n;";
			ResultSet executeQuery = prepare(connectionJdbc, insert);
			
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("3. Write a Query to fetch ratings and reviews based on customer Or Designer");
			System.out.println("----------------------------------------------------------------------------");

			System.out.println(String.format("%-15s %-25s %-20s %-15s %-10s", "customerId", "ordDetailsId", "productName", "rating","review"));
//			System.out.println();

			while (executeQuery.next()) {
				long customerId = executeQuery.getLong(1);
				long ordDetailsId = executeQuery.getLong(2);
				String productName = executeQuery.getString(3);
				int rating = executeQuery.getInt(4);
				String review = executeQuery.getString(5);


				System.out.println();
				System.out.println(String.format("    %-14s %-15s %-30s %-10s %-15s", customerId, ordDetailsId, productName, rating,
						review));
			}
			connectionJdbc.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private static ResultSet prepare(Connection connectionJdbc, String insert) throws SQLException {
		PreparedStatement prepareStatement = connectionJdbc.prepareStatement(insert);
		ResultSet executeQuery = prepareStatement.executeQuery();
		return executeQuery;
	}

}
