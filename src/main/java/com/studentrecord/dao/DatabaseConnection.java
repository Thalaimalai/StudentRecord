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
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/admin";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "Thalai@2000@";
	
	/**
	 * Create MySQL Database Connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return connection;
	}
}
