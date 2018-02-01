import java.sql.*;

public class Connector {
	private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://127.0.0.1:3306/";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "150250911";
	private final static String DATABASE = "mco2";
	
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
		Connector db = new Connector();
		db.getConnection();
	}
}
