package main.backend.analysis;

import main.backend.DBHandler;
import main.backend.Session;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class HistoryAnalysis {

    private Session session;

    public HistoryAnalysis(Session session) {
        this.session = session;
    }

    public ArrayList<String> getSummary(char timeframe) {

        long numberOfDays = 0;

        if (timeframe == 'W') {
            numberOfDays = 7;
        } else if (timeframe == 'M') {
            numberOfDays = 30;
        } else if (timeframe == 'Y') {
            numberOfDays = 365;
        } else if (timeframe == 'O') {
            return this.getOverallSummary(this.session.getUserId());
        }

        return this.getTimeframeSummary(this.session.getUserId(), numberOfDays);

    }

    private ArrayList<String> getTimeframeSummary(int user_id, long timeframe) {

        ArrayList<String> output = new ArrayList<>();

        System.out.println("Getting data for " + timeframe + " day summary");

        // Getting the data from the database
        LinkedHashMap<String, Double> studyData = DBHandler.getStudyTimes(user_id);
        LinkedHashMap<String, Double> exerciseData = DBHandler.getExerciseTimes(user_id);

        // Reducing the data set to the timeframe
        LinkedHashMap<String, Double> reducedStudyData = reduceDataSet(studyData, timeframe);
        LinkedHashMap<String, Double> reducedExerciseData = reduceDataSet(exerciseData, timeframe);

        output.add( Double.toString( getDailyAverageTime( reducedStudyData,
                Math.min(timeframe, getNoDays( studyData.keySet().toArray()[0].toString())))));

        output.add( Double.toString( getDailyAverageTime( reducedExerciseData,
                Math.min(timeframe, getNoDays( exerciseData.keySet().toArray()[0].toString())))));

        return output;

    }

    private ArrayList<String> getOverallSummary(int user_id) {

        ArrayList<String> output = new ArrayList<>();

        System.out.println("Getting data for overall summary");

        LinkedHashMap<String, Double> studyData = DBHandler.getStudyTimes(1);
        LinkedHashMap<String, Double> exerciseData = DBHandler.getExerciseTimes(1);

        output.add( Double.toString( getDailyAverageTime( studyData,
                getNoDays( studyData.keySet().toArray()[0].toString()))));

        output.add( Double.toString( getDailyAverageTime( exerciseData,
                getNoDays( exerciseData.keySet().toArray()[0].toString()))));

        return output;

    }

    private double getDailyAverageTime(LinkedHashMap<String, Double> data, long numberOfDays) {

        double total = 0;

        for (HashMap.Entry<String, Double> entry: data.entrySet()) {
            total += entry.getValue();
        }

        // Returning a truncated version of average (2 d.p.)
        return (Math.floor((total / numberOfDays) * 100) / 100);

    }

    private long getNoDays(String firstDate) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate localFirstDate = LocalDate.parse(firstDate.substring(0, 10), dtf);
        LocalDate today = LocalDate.now();

        // Returning the number of days between firstDate and today
        return ChronoUnit.DAYS.between(localFirstDate, today);

    }

    private LinkedHashMap<String, Double> reduceDataSet(LinkedHashMap<String, Double> data, long numberOfDays) {

        LinkedHashMap<String, Double> output = new LinkedHashMap<>();

        for (HashMap.Entry<String, Double> entry: data.entrySet()) {

            if (getNoDays(entry.getKey()) <= numberOfDays) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                output.put(entry.getKey(), entry.getValue());
            }

        }

        return output;

    }

}
