package main.backend.analysis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HistoryAnalysis {

    private Connection conn;

    public HistoryAnalysis() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            this.conn = DriverManager.getConnection("jdbc:mysql://pyp.wwlrc.co.uk/group3?user=group3&password=bathuni");

            PreparedStatement s = conn.prepareStatement("SELECT * FROM User_Accounts");

            ResultSet result = s.executeQuery();
            result.next();
            System.out.println(result.getString("username"));


        } catch(Exception er) {

            System.err.println(er.getMessage());

        }

    }

    public ArrayList<String> getWeekSummary() {

        ArrayList<String> output = new ArrayList<>();

        return output;

    }

    public ArrayList<String> getMonthSummary() {

        ArrayList<String> output = new ArrayList<>();

        return output;

    }

    public ArrayList<String> getYearSummary() {

        ArrayList<String> output = new ArrayList<>();

        return output;

    }

    public ArrayList<String> getOverallSummary() {

        ArrayList<String> output = new ArrayList<>();

        return output;

    }

}
