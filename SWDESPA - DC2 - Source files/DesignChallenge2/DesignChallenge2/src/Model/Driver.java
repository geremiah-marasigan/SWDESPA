/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Kyle
 */

import java.sql.*;

public class Driver {
	private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://127.0.0.1:3306/";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "150250911";
	private final static String DATABASE = "swdespa";
	
	public Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			
			Connection myConn = DriverManager.getConnection(
					URL + 
					DATABASE + "?autoReconnect=true&useSSL=false",
					USERNAME,
					PASSWORD);
			System.out.println("Connection Successful");
			return myConn;
		}
		catch (SQLException e) {
			System.out.println("SQL error, connection unsuccesful");
			e.printStackTrace();
			return null;
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class not found, connection unsuccesful");
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Connecting...");
		Driver db = new Driver();
		db.getConnection();
	}
}

