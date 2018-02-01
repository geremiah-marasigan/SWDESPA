import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseDataParser extends DataParser{
	private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://127.0.0.1:3306/";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "150250911";
	private final static String DATABASE = "mco2";
	
	public static final String TABLE = "useraccount";
	public static final String COL_ID = "UserID";
	public static final String COL_LN = "LastName";
	public static final String COL_FN = "FirstName";
	public static final String COL_BD = "Birthday";
	public static final String COL_RD = "RegistrationDate";
	public static final String COL_EM = "Email";
	public static final String COL_PW = "Password";
	public static final String COL_SA = "ShippingAddress";
	
	Connection connection;
	
	public DatabaseDataParser() {
		super.records = new ArrayList<List>();
	}
	
	public void readData() {
		System.out.println("Reading data from database");
		try {
			Class.forName(DRIVER_NAME);
			
			connection = DriverManager.getConnection(
					URL + 
					DATABASE + "?autoReconnect=true&useSSL=false",
					USERNAME,
					PASSWORD);
			System.out.println("Connection Successful");
		}
		catch (SQLException e) {
			System.out.println("SQL error, connection unsuccesful");
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class not found, connection unsuccesful");
			e.printStackTrace();
		}
		
		String query = "SELECT * FROM useraccount";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String entry ="";
				
				entry += rs.getInt(COL_ID) + " ";
				entry += rs.getString(COL_LN) + " ";
				entry += rs.getString(COL_FN) + " ";
				entry += rs.getString(COL_BD) + " ";
				entry += rs.getString(COL_RD) + " ";
				entry += rs.getString(COL_EM) + " ";
				entry += rs.getString(COL_PW) + " ";
				entry += rs.getString(COL_SA) + " ";
				
				String[] entries = entry.split(" ");
				super.records.add(Arrays.asList(entries));
			}
			
			rs.close();
			statement.close();
			connection.close(); 
			System.out.println("[USERS] SELECT SUCCESS!");
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[USERS] SELECT FAILED!");
		}
	}
	public void processData() {
		System.out.println("Looping through datasets");
		int lnNum = 1;
		for (List<String> line: records) {
			int colNum = 1;
			for(String value: line) {
				System.out.println("Line " + lnNum + " Column " + colNum + ": " + value);
				colNum++;
			}
			lnNum++;
		}
	}
}
