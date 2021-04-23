package main.backend;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Calendar;
import java.util.LinkedHashMap;

import main.backend.accounts.User;

import java.util.Date;

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
			
			String sql = "SELECT user_id, username FROM User_Accounts WHERE username = '" + activeUserName + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
			        activeUser = new User(rs.getInt("id"), rs.getString("forename"), rs.getString("surname"), rs.getString("username"), rs.getString("email"), rs.getString("password"));
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
        LinkedHashMap<Date, Double> data = new LinkedHashMap<Date, Double>();
        try {
			String url = "jdbc:mySQL://database-1.ciy34ilesyld.eu-west-2.rds.amazonaws.com/group3?user=admin&password=russellhateswindows";

            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();

            String sql = "SELECT study_session_id, user_id, study_time, time_of_session FROM Study_Sessions WHERE user_id = " + user_id;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                data.put(rs.getDate("time_of_session"), rs.getDouble("study_time"));
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
        return data;
    }

    public static LinkedHashMap<Date, Double> getExerciseTimes(int user_id) {
        Connection conn = null;
        Statement stmt = null;
        LinkedHashMap<Date, Double> data = new LinkedHashMap<Date, Double>();
        try {
			String url = "jdbc:mySQL://database-1.ciy34ilesyld.eu-west-2.rds.amazonaws.com/group3?user=admin&password=russellhateswindows";
            conn = DriverManager.getConnection(url);

            stmt = conn.createStatement();

            String sql = "SELECT exercise_session_id, user_id, exercise_time, time_of_session FROM Study_Sessions WHERE user_id = " + user_id;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                data.put(rs.getDate("time_of_session"), rs.getDouble("exercise_time"));
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
        return data;
    }
	
			String url = "jdbc:mySQL://database-1.ciy34ilesyld.eu-west-2.rds.amazonaws.com/group3?user=admin&password=russellhateswindows";
}
