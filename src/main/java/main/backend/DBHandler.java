package main.backend;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Calendar;


public class DBHandler {
	
	

	public static void connect() {
		//just a connection to the database, for contingencies sake
		Connection conn = null;
		try {
			
			String url = "jdbc:mySQL://pyp.wwlrc.co.uk/group3?user=group3&password=bathuni";
			
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
	
	public static void insertNewUser(String userName, String password, String forename, String surname, String email) {
		Connection conn = null;
		try {
			//connecting to the database
			String url = "jdbc:mySQL://pyp.wwlrc.co.uk/group3?user=group3&password=bathuni";
			
			conn = DriverManager.getConnection(url);
			
			String query = " insert into User_Accounts (username, password, forename, surname, email)" + " values (?, ?, ?, ?, ?)";
			
			//using prepared statements for inserting
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, userName);
			preparedStmt.setString(2, password);
			preparedStmt.setString(3, forename);
			preparedStmt.setString(4, surname);
			preparedStmt.setString(5, email);
			
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
			String url = "jdbc:mySQL://pyp.wwlrc.co.uk/group3?user=group3&password=bathuni";
			
			conn = DriverManager.getConnection(url);
			
			stmt = conn.createStatement();
			
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
			String url = "jdbc:mySQL://pyp.wwlrc.co.uk/group3?user=group3&password=bathuni";
			
			conn = DriverManager.getConnection(url);
			
			stmt = conn.createStatement();
			
			String sql = "SELECT id, username FROM User_Accounts WHERE username = '" + activeUserName + "'";
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
	
	public static double getStudyTime(int user_id, int study_session_id) {
		Connection conn = null;
		Statement stmt = null;
		double time = 0.0;
		int Counter = 0;
		try {
			String url = "jdcb:mySQL://pyp.wwlrc.co.uk/group3?user=group3&password=bathuni";
			
			conn = DriverManager.getConnection(url);
			
			stmt = conn.createStatement()
			
			String sql = "SELECT study_session_id, user_id, study_time FROM Study_Sessions WHERE user_id = " + user_id + " AND study_session_id = " + study_session_id;
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
			    time = rs.getInt("study_time");
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
		return time;
	}
	
		public static double getExerciseTime(int user_id, int exercise_session_id) {
		Connection conn = null;
		Statement stmt = null;
		double time = 0.0;
		int Counter = 0;
		try {
			String url = "jdcb:mySQL://pyp.wwlrc.co.uk/group3?user=group3&password=bathuni";
			
			conn = DriverManager.getConnection(url);
			
			stmt = conn.createStatement();
			
			String sql = "SELECT exercise_session_id, user_id, exercise_time FROM Study_Sessions WHERE user_id = " + user_id + " AND exercise_session_id = " + exercise_session_id;
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
			    time = rs.getInt("study_time");
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
		return time;
	}
	
	public static void insertNewGoal(int user_id, String goal_title, String goal_description, Date goal_expiration_date) {
		Connection conn = null;
		java.sql.Date sqlDate = new java.sql.Date(goal_expiration_date.getTime());
		try {
			//connecting to the database
			String url = "jdcb:mySQL://pyp.wwlrc.co.uk/group3?user=group3&password=bathuni";
			
			conn = DriverManager.getConnection(url);
			
			String query = " insert into Personal_Goals (user_id, goal_title, goal_description, goal_expiration_date)" + " values (?, ?, ?, ?)";
			
			//using prepared statements for inserting
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, user_id);
			preparedStmt.setString(2, goal_title);
			preparedStmt.setString(3, goal_description);
			preparedStmt.setDate(4, sqlDate);
			
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
	
	public static void insertNewExerciseSession(int user_id, String exercise_name, Double exercise_time, Date time_of_exercise) {
		Connection conn = null;
		java.sql.Date sqlDate = new java.sql.Date(time_of_exercise.getTime());
		try {
			//connecting to the database
			String url = "jdbc:mySQL://pyp.wwlrc.co.uk/group3?user=group3&password=bathuni";
			
			conn = DriverManager.getConnection(url);
			
			String query = " insert into Exercise_Sessions (user_id, exercise_name, exercise_time, time_of_exercise)" + " values (?, ?, ?, ?)";
			
			//using prepared statements for inserting
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, user_id);
			preparedStmt.setString(2, exercise_name);
			preparedStmt.setDouble(3, exercise_time);
			preparedStmt.setDate(4, sqlDate);
			
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
	
	public static void insertNewStudySession(int user_id, String study_name, Double study_time, Date time_of_study) {
		Connection conn = null;
		java.sql.Date sqlDate = new java.sql.Date(time_of_study.getTime());
		try {
			//connecting to the database
			String url = "jdbc:mySQL://pyp.wwlrc.co.uk/group3?user=group3&password=bathuni";
			
			conn = DriverManager.getConnection(url);
			
			String query = " insert into Study_Sessions (user_id, study_name, study_time, time_of_study)" + " values (?, ?, ?, ?)";
			
			//using prepared statements for inserting
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, user_id);
			preparedStmt.setString(2, study_name);
			preparedStmt.setDouble(3, study_time);
			preparedStmt.setDate(4, sqlDate);
			
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
	
	
	
}
