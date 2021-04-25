package main.backend;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Calendar;
import java.util.LinkedHashMap;

import main.backend.accounts.User;

import java.util.Date;
import java.util.List;

public class DBHandler {

	public static void connect() {
		//just a connection to the database, for contingencies sake
		Connection conn = null;
		try {
			
			String url = "jdbc:mySQL://database-1.ciy34ilesyld.eu-west-2.rds.amazonaws.com/group3?user=admin&password=russellhateswindows";
			
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
			String url = "jdbc:mySQL://database-1.ciy34ilesyld.eu-west-2.rds.amazonaws.com/group3?user=admin&password=russellhateswindows";
			
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
	
	public static String[][] retrieveUserInfo(int user_id) {
		Connection conn = null;
		Statement stmt = null;
		String[][] userInfo = new String[999][3];
		int Counter = 0;
		try {
			String url = "jdbc:mySQL://database-1.ciy34ilesyld.eu-west-2.rds.amazonaws.com/group3?user=admin&password=russellhateswindows";
			
			conn = DriverManager.getConnection(url);
			
			stmt = conn.createStatement();
			
			String sql = "SELECT username, password, email FROM User_Accounts";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				userInfo[Counter][0] = rs.getString("username");
				userInfo[Counter][1] = rs.getString("password");
				userInfo[Counter][2] = rs.getString("email");
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
	
	public static User getActiveUserID(String activeUserName) {
		Connection conn = null;
		Statement stmt = null;
		int id = 0;
		int Counter = 0;
		User activeUser = null;
		try {
			String url = "jdbc:mySQL://database-1.ciy34ilesyld.eu-west-2.rds.amazonaws.com/group3?user=admin&password=russellhateswindows";
			
			conn = DriverManager.getConnection(url);
			
			stmt = conn.createStatement();
			
			String sql = "SELECT user_id, username, forename, surname, email, password FROM User_Accounts WHERE username = '" + activeUserName + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
			        activeUser = new User(rs.getInt("user_id"), rs.getString("forename"), rs.getString("surname"), rs.getString("username"), rs.getString("email"), rs.getString("password"));
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

		return activeUser;
	}
	
	public static LinkedHashMap<Date, Double> getStudyTimes(int user_id) {
        Connection conn = null;
        Statement stmt = null;
        LinkedHashMap<String, Double> data = new LinkedHashMap<String, Double>();
        try {
            String url = "jdbc:mySQL://database-1.ciy34ilesyld.eu-west-2.rds.amazonaws.com/group3?user=admin&password=russellhateswindows";

            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();

            String sql = "SELECT study_session_id, user_id, study_time, time_of_session FROM Study_Sessions WHERE user_id = " + user_id;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                data.put(rs.getString("time_of_session"), rs.getDouble("study_time"));
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
        return data;
    }

    public static LinkedHashMap<String, Double> getExerciseTimes(int user_id) {
        Connection conn = null;
        Statement stmt = null;
        LinkedHashMap<String, Double> data = new LinkedHashMap<String, Double>();
        try {
            String url = "jdbc:mySQL://database-1.ciy34ilesyld.eu-west-2.rds.amazonaws.com/group3?user=admin&password=russellhateswindows";

            conn = DriverManager.getConnection(url);

            stmt = conn.createStatement();

            String sql = "SELECT exercise_session_id, user_id, exercise_time, time_of_session FROM Exercise_Sessions WHERE user_id = " + user_id;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                data.put(rs.getString("time_of_session"), rs.getDouble("exercise_time"));
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
        return data;
    }
	
<<<<<<< HEAD
=======
	public static void insertNewGoal(int user_id, String goal_title, String goal_description, Date goal_expiration_date) {
		Connection conn = null;
		java.sql.Date sqlDate = new java.sql.Date(goal_expiration_date.getTime());
		try {
			//connecting to the database
			String url = "jdbc:mySQL://database-1.ciy34ilesyld.eu-west-2.rds.amazonaws.com/group3?user=admin&password=russellhateswindows";
			
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
			String url = "jdbc:mySQL://database-1.ciy34ilesyld.eu-west-2.rds.amazonaws.com/group3?user=admin&password=russellhateswindows";
			
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
			String url = "jdbc:mySQL://database-1.ciy34ilesyld.eu-west-2.rds.amazonaws.com/group3?user=admin&password=russellhateswindows";
			
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
	
	public static void updateGoalProgress(int user_id, int goal_id, int newProgress) {
		Connection conn = null;
		try {
			//connecting to the database
			String url = "jdbc:mySQL://database-1.ciy34ilesyld.eu-west-2.rds.amazonaws.com/group3?user=admin&password=russellhateswindows";
			
			conn = DriverManager.getConnection(url);
			
			String query = "update Personal_Goals set goal_progress = ? where user_id = ? AND goal_id = ?";
			
			//using prepared statements for inserting
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, newProgress);
			preparedStmt.setInt(2, user_id);
			preparedStmt.setInt(3, goal_id);
			
			
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
	
	public static void updateGoalProgress(int user_id, int goal_id) {
		Connection conn = null;
		try {
			//connecting to the database
			String url = "jdbc:mySQL://database-1.ciy34ilesyld.eu-west-2.rds.amazonaws.com/group3?user=admin&password=russellhateswindows";
			
			conn = DriverManager.getConnection(url);
			
			String query = "delete from Personal_Goals where user_id = ? AND goal_id = ?";
			
			//using prepared statements for inserting
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, user_id);
			preparedStmt.setInt(2, goal_id);
			
			
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
	
	
>>>>>>> gui-login-2
}
