package com.revature.pointsapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static ConnectionFactory connectionFactory;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private ConnectionFactory(){
		
	}
	
	public static ConnectionFactory getInstance() {
		// lazy loading - create instance when it's needed
		if(connectionFactory == null) connectionFactory = new ConnectionFactory();
		return connectionFactory;
	}
	
	// factories are characterized by some method that contains logic for object creation
	public Connection getConnection() {
		Connection connie = null;
		try {
			connie = DriverManager.getConnection(SecretClass.url, SecretClass.username, SecretClass.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connie;
	}
	
}
