package main.backend.analysis;

import java.sql.*;
import java.util.ArrayList;

public class HistoryAnalysis {

    private Connection conn;

    public HistoryAnalysis() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            this.conn = DriverManager.getConnection("jdbc:mysql://pyp.wwlrc.co.uk/group3?user=group3&password=bathuni");

            // PreparedStatement s = conn.prepareStatement("SELECT * FROM Study_Sessions WHERE user_id = 1");

            // ResultSet result = s.executeQuery();

            // while (result.next()) {

                // System.out.println(result.getDouble("study_time"));

            // }


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

            PreparedStatement studyStatement = conn.prepareStatement("SELECT study_time FROM Study_Sessions WHERE user_id = (SELECT user_id FROM User_Accounts WHERE username = " + username + ")");
            ResultSet studyResults = studyStatement.executeQuery();
            averageStudyTime = this.getAverageTime(studyResults,"study_time");

            PreparedStatement exerciseStatement = conn.prepareStatement("SELECT exercise_time FROM Exercise_Sessions WHERE user_id = (SELECT user_id FROM User_Accounts WHERE username = " + username + ")");
            ResultSet exerciseResults = exerciseStatement.executeQuery();
            averageExerciseTime = this.getAverageTime(exerciseResults,"exercise_time");

        } catch (Exception er) {

            System.err.println(er.getMessage());

        }

        output.add(Double.toString(averageStudyTime));
        output.add(Double.toString(averageExerciseTime));

        return output;

    }

    private double getAverageTime(ResultSet results, String sessionType) {

        double output = 0;
        double lenResults = 0;

        try {

            while (results.next()) {

                lenResults += 1;
                output += results.getDouble(sessionType);

            }

        } catch (Exception er) {

            System.err.println(er.getMessage());

        }

        // Finding the average
        output /= lenResults;

        return output;

    }

    public static void main(String args[]) {

        HistoryAnalysis ha = new HistoryAnalysis();

        ArrayList<String> output = ha.getOverallSummary("'archey.barrell'");
        System.out.println(output.get(0));
        System.out.println(output.get(1));


    }

}
