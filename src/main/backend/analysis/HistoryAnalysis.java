package main.backend.analysis;

import java.sql.*;
import java.util.ArrayList;

public class HistoryAnalysis {

    private Connection conn;

    public HistoryAnalysis() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            this.conn = DriverManager.getConnection("jdbc:mysql://pyp.wwlrc.co.uk/group3?user=group3&password=bathuni");


        } catch(Exception er) {

            System.err.println(er.getMessage());

        }

    }

    public ArrayList<String> getWeekSummary(String username) {

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

    public ArrayList<String> getOverallSummary(String username) {

        ArrayList<String> output = new ArrayList<>();

        double averageStudyTime = 0;
        double averageExerciseTime = 0;

        try {

            PreparedStatement studyStatement = conn.prepareStatement("SELECT study_time, time_of_study FROM Study_Sessions WHERE user_id = (SELECT user_id FROM User_Accounts WHERE username = " + username + ")");
            ResultSet studyResults = studyStatement.executeQuery();
            averageStudyTime = this.getDailyAverageTime(studyResults,"study_time");

            PreparedStatement exerciseStatement = conn.prepareStatement("SELECT exercise_time, time_of_exercise FROM Exercise_Sessions WHERE user_id = (SELECT user_id FROM User_Accounts WHERE username = " + username + ")");
            ResultSet exerciseResults = exerciseStatement.executeQuery();
            averageExerciseTime = this.getDailyAverageTime(exerciseResults,"exercise_time");

        } catch (Exception er) {

            System.err.println(er.getMessage());

        }

        output.add(Double.toString(averageStudyTime));
        output.add(Double.toString(averageExerciseTime));

        return output;

    }

    private double getDailyAverageTime(ResultSet results, String sessionType) {

        double output = 0;
        int numberOfDays = 0;

        try {

            results.next();
            // Getting the number of days since the first session
            numberOfDays = this.getNoDays(results.getDate("time_of_session"));
            output += results.getDouble(sessionType);

            while (results.next()) {

                output += results.getDouble(sessionType);

            }

        } catch (Exception er) {

            System.err.println(er.getMessage());

        }

        // Finding the average and returning it
        return output /= numberOfDays;

    }

    private int getNoDays(Date date) {

        return 0;

    }

    public static void main(String args[]) {

        HistoryAnalysis ha = new HistoryAnalysis();

        ArrayList<String> output = ha.getOverallSummary("'archey.barrell'");
        System.out.println(output.get(0));
        System.out.println(output.get(1));

    }

}
