package com.project.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * A utility class to handle and bridge database connections
 */

public class DBCon {


	public static void closeConnection(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException sqle) {
			System.out.println("Error while closing connection.");
		}
	}

	public static Connection getConnection() throws Exception {
		Connection conn = null;
		InputStream input = null;
		Properties prop = new Properties();
		try {
			input =  DBCon.class.getClassLoader().getResourceAsStream("db.properties");
			prop.load(input);
			String url = "jdbc:mysql://localhost/" + prop.getProperty("dbName") + "?user=" + prop.getProperty("dbUser")
					+ "&password=" + prop.getProperty("dbPassword");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
		} catch (SQLException sqle) {
			System.out.println("SQLException: Unable to open connection to db: " + sqle.getMessage());
			throw sqle;
		} catch (Exception e) {
			System.out.println("Exception: Unable to open connection to db: " + e.getMessage());
			throw e;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return conn;
	}
}
