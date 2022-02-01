package com.studentrecord.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentDatabaseConnection {
	private static final String DATABASEURL = "jdbc:mysql://localhost:3306/admin";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Thalai@2000@";

	static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(DATABASEURL, USERNAME, PASSWORD);
		return connection;
	}
}
