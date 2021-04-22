package main.backend.analysis;

import main.backend.DBHandler;

import java.sql.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.LinkedHashMap;

public class HistoryAnalysis {

    public HistoryAnalysis(/* Put session here */) {

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

    public ArrayList<String> getOverallSummary(int user_id) {

        ArrayList<String> output = new ArrayList<>();

        System.out.println("Getting data for overall summary");

        LinkedHashMap<Date, Double> studyData = DBHandler.getStudyTimes(1);
        LinkedHashMap<Date, Double> exerciseData = DBHandler.getExerciseTimes(1);

        output.add(Double.toString(getDailyAverageTime(studyData, getNoDays(studyData))));
        output.add(Double.toString(getDailyAverageTime(exerciseData, getNoDays(exerciseData))));

        return output;

    }

    private double getDailyAverageTime(LinkedHashMap<Date, Double> data, long numberOfDays) {

        double output = 10;

        /*
        for (HashMap.Entry<Date, Double> entry: data.entrySet()) {
            entry.getValue();
        }
         */

        // Finding the average and returning it
        return (output /= numberOfDays);

    }

    private long getNoDays(LinkedHashMap<Date, Double> data) {

        // Need to check the map is not empty

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String firstDate = data.keySet().toArray()[0].toString();

        LocalDate localFirstDate = LocalDate.parse(firstDate, dtf);
        LocalDate today = LocalDate.now();

        long daysBetween = ChronoUnit.DAYS.between(localFirstDate, today);

        // Line for debugging
        System.out.println("Days: " + daysBetween);

        return daysBetween;

    }

    public static void main(String args[]) {

        HistoryAnalysis ha = new HistoryAnalysis();

        ArrayList<String> output = ha.getOverallSummary(1);
        System.out.println(output.get(0));
        System.out.println(output.get(1));

    }

}
