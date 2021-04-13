package main.login;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Calendar;


public class DBHandler {
	
	

	public static void connect() {
		//just a connection to the database, for contingencies sake
		Connection conn = null;
		try {
			
			String url = "jdcb:mySQL://pyp.wwlrc.co.uk/group3?user=group3&password=bathuni";
			
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			}catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
	}
	
	public static void insertNewUser(String userName, String password) {
		Connection conn = null;
		try {
			//connecting to the database
			String url = "jdcb:mySQL://pyp.wwlrc.co.uk/group3?user=group3&password=bathuni";
			
			conn = DriverManager.getConnection(url);
			
			String query = " insert into User_Accounts (username, password, forename, surname, email)" + " values (?, ?, ?, ?, ?)";
			
			//using prepared statements for inserting
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, userName);
			preparedStmt.setString(2, password);
			preparedStmt.setString(3, "");
			preparedStmt.setString(4, "");
			preparedStmt.setString(5, "");
			
			//inserts the new user data in to the table
			preparedStmt.execute();
			
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			}catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
	}
	
	public static String[][] retrieveUserInfo() {
		Connection conn = null;
		Statement stmt = null;
		String[][] userInfo = new String[999][2];
		int Counter = 0;
		try {
			String url = "jdcb:mySQL://pyp.wwlrc.co.uk/group3?user=group3&password=bathuni";
			
			conn = DriverManager.getConnection(url);
			
			String sql = "SELECT username, password FROM User_Accounts";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				userInfo[Counter][0] = rs.getString("username");
				userInfo[Counter][1] = rs.getString("password");
				Counter += 1;
				if(rs.getString("username") == null) {
					break;
				}
			}
			rs.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return userInfo;
	}
	
	public static int getActiveUserID(String activeUserName) {
		Connection conn = null;
		Statement stmt = null;
		int id = 0;
		int Counter = 0;
		try {
			String url = "jdcb:mySQL://pyp.wwlrc.co.uk/group3?user=group3&password=bathuni";
			
			conn = DriverManager.getConnection(url);
			
			String sql = "SELECT id, username FROM User_Accounts WHERE username = " + activeUserName;
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
			    id = rs.getInt("id");
				Counter += 1;
				if(rs.getString("username") == null) {
					break;
				}
			}
			rs.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return id;
	}
	
}
