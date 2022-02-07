package com.studentrecord.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <h1>DatabaseConnection</h1>
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class DatabaseConnection {
	
	/**
	 * Create MySQL Database Connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "Thalai@2000@");
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return connection;
	}
}
