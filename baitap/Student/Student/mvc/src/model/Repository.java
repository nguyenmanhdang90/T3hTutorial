package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public abstract class Repository {
	protected Connection connection;
	protected Statement stmt; 
	protected ResultSet rs;
	protected PreparedStatement pstmt;
	private static final Properties props = new Properties();
	static {
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
			Class.forName(props.getProperty("driver"));
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	protected void open() throws SQLException {
		connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("password"));
	}
	protected void close() throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
}
