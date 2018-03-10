/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Kyle
 */
public class ItemsServices {
	private Driver connection;
	
	public ItemsServices(Driver driver) {
		this.connection = driver;
	}
	
	private Item toItem(ResultSet rs) throws SQLException {
		Item item = new Item();
		
		item.setStartTime(rs.getString(Item.COL_ST));
		item.setInterval(rs.getInt(Item.COL_IN));
		item.setMonth(rs.getInt(Item.COL_MN));
		item.setDay(rs.getInt(Item.COL_DY));
		item.setYear(rs.getInt(Item.COL_YR));
		item.setToDo(rs.getString(Item.COL_TD));
		item.setDone(rs.getInt(Item.COL_DN));
		
		return item;
	}
	
	public void deleteItem(String td) {
		Connection connect = connection.getConnection();
		
		String query = "DELETE FROM " + Item.TABLE + " WHERE " + Item.COL_TD + " = ?";
		
		try {
			PreparedStatement statement = connect.prepareStatement(query);
			
			statement.setString(1, td);
			statement.executeUpdate();
			
			statement.close();
			connect.close();
			System.out.println("[ITEMS] DELETE SUCCESS!");
		} catch (SQLException ev) {
			System.out.println("[ITEMS] DELETE FAILED!");
			ev.printStackTrace();
		}	
	}
	
	public List<Item> getAll() {
		int b = 0;
		List<Item> item = new ArrayList <Item>();
		Connection connect = connection.getConnection();
		String query = 	"SELECT * " + " FROM " + Item.TABLE;

		
		try {
			PreparedStatement statement = connect.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				item.add(toItem(rs));
			}
			
			rs.close();
			statement.close();
			connect.close();
			
			System.out.println("[ITEMS] SELECT SUCCESS!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[ITEMS] SELECT FAILED!");
			return null;
		}	
		
		return item;
	}
	
	public void addItem(Item item) {
		Connection connect = connection.getConnection();
		String query = 	"INSERT INTO " + Item.TABLE + " VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement statement = connect.prepareStatement(query);
			
			statement.setString(1, item.getStartTime());
			statement.setInt(2, item.getInterval());
			statement.setInt(3, item.getMonth());
			statement.setInt(4, item.getDay());
			statement.setInt(5, item.getYear());
			statement.setString(6, item.getToDo());
			statement.setInt(7, item.getDone());
			
			statement.executeUpdate();
			System.out.println("[ITEMS] INSERT SUCCESS!");
		} catch (SQLException ev) {
			ev.printStackTrace();
			System.out.println("[ITEMS] INSERT FAILED!");
		}	
	}
	
	public void updateItem(Item item) {
		try {
			Connection connect = connection.getConnection();
			
			String query = 	"UPDATE " +  Item.TABLE + 
					" SET " + Item.COL_ST + " = ?, " +
					Item.COL_IN + " = ?, " + 
					Item.COL_MN + " = ?, " +
					Item.COL_DY + " = ?, " +
					Item.COL_YR + " = ?, " +
					Item.COL_DN + " = ? " +
					" WHERE " + Item.COL_TD + " = ?; ";
			
			PreparedStatement statement = connect.prepareStatement(query);

			statement.setString(1, item.getStartTime());
			statement.setInt(2, item.getInterval());
			statement.setInt(3, item.getMonth());
			statement.setInt(4, item.getDay());
			statement.setInt(5, item.getYear());
			statement.setInt(6, item.getDone());
			statement.setString(7, item.getToDo());
			
			statement.executeUpdate();
			System.out.println("[ITEMS] UPDATE SUCCESS! ");
		} catch (SQLException ev) {
			ev.printStackTrace();
			System.out.println("[ITEMS] UPDATE FAILED! ");
		}
	}
	
	public List<Item> getAllByDay(int month, int day, int year){
		List<Item> item = new ArrayList<Item>();
		Connection connect = connection.getConnection();
		String query = 	"SELECT * " +
				" FROM " + Item.TABLE +
				" WHERE " + Item.COL_MN + " = ? AND "+
                                Item.COL_DY + " = ? AND " + Item.COL_YR + " = ?"
                                + " ORDER BY " + Item.COL_ST;

		try {
			PreparedStatement statement = connect.prepareStatement(query);
			statement.setInt(1, month);
                        statement.setInt(2, day);
                        statement.setInt(3, year);
                        
			ResultSet rs = statement.executeQuery();
			
			
			while(rs.next()) {
				item.add(toItem(rs));
			}
			
			rs.close();
			statement.close();
			connect.close();
			
			System.out.println("[ITEMS] SELECT SUCCESS!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[ITEMS] SELECT FAILED!");
			return null;
		}	
		
		return item;
		
	}
    }