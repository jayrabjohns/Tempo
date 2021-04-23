package main.gui.history;

import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import main.backend.Session;
import main.backend.analysis.HistoryAnalysis;
import main.gui.AbstractMainFormController;
import main.gui.Alertable;
import main.gui.JAlert;

public class HistoryAnalysisFormController extends AbstractMainFormController {

    private Alertable alertPane;

    private JButton pastWeekButton;
    private JButton pastMonthButton;
    private JButton pastYearButton;
    private JButton overallButton;

    private JLabel avgDailyStudyText;
    private JLabel avgDailyExerciseText;
    // private JLabel avgNoGoalsCompletedText;

    private Session session;

    public HistoryAnalysisFormController(Session session) {
        this.session = session;
    }

    public void bindPastWeekButton(JButton button) {
        button.addActionListener(new PastWeekButtonListener());
        this.pastWeekButton = button;
    }

    public void bindPastMonthButton(JButton button) {
        button.addActionListener(new PastMonthButtonListener());
        this.pastMonthButton = button;
    }

    public void bindPastYearButton(JButton button) {
        button.addActionListener(new PastYearButtonListener());
        this.pastYearButton = button;
    }

    public void bindOverallButton(JButton button) {
        button.addActionListener(new OverallButtonListener());
        this.overallButton = button;
    }

    public void bindAlertable(Alertable alertPane) {
        this.alertPane = alertPane;
    }

    public void bindAvgDailyStudyText(JLabel label) { this.avgDailyStudyText = label; }

    public void bindAvgDailyExerciseText(JLabel label) { this.avgDailyExerciseText = label; }

    /*
    public void bindAvgNoGoalsCompletedText(JLabel label) { this.avgNoGoalsCompletedText = label; }
     */

    private class PastWeekButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            HistoryAnalysis ha = new HistoryAnalysis(session);

            HistoryAnalysisFormController c = HistoryAnalysisFormController.this;

            c.pastWeekButton.setEnabled(false);
            c.pastMonthButton.setEnabled(false);
            c.pastYearButton.setEnabled(false);
            c.overallButton.setEnabled(false);

            c.alertPane.showAlert(new JAlert(JAlert.TYPE_INFO, "Loading data from the past week...", ""));

            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                protected Void doInBackground() {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ignored) {

                    }

                    ArrayList<String> output = ha.getSummary('W');

                    c.avgDailyStudyText.setText("Average Daily Study Time: " + output.get(0));
                    c.avgDailyExerciseText.setText("Average Daily Exercise Time: " + output.get(1));

                    return null;
                }

                protected void done() {

                    HistoryAnalysisFormController.this.alertPane.showAlert(new JAlert(JAlert.TYPE_INFO, "Close", ""));

                    c.pastMonthButton.setEnabled(true);
                    c.pastYearButton.setEnabled(true);
                    c.overallButton.setEnabled(true);
                }
            };

            worker.execute();

        }

    }

    private class PastMonthButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            HistoryAnalysis ha = new HistoryAnalysis(session);

            HistoryAnalysisFormController c = HistoryAnalysisFormController.this;

            c.pastWeekButton.setEnabled(false);
            c.pastMonthButton.setEnabled(false);
            c.pastYearButton.setEnabled(false);
            c.overallButton.setEnabled(false);

            c.alertPane.showAlert(new JAlert(JAlert.TYPE_INFO, "Loading data from the past month...", ""));

            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                protected Void doInBackground() {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ignored) {

                    }

                    ArrayList<String> output = ha.getSummary('M');

                    c.avgDailyStudyText.setText("Average Daily Study Time: " + output.get(0));
                    c.avgDailyExerciseText.setText("Average Daily Exercise Time: " + output.get(1));

                    return null;
                }

                protected void done() {

                    HistoryAnalysisFormController.this.alertPane.showAlert(new JAlert(JAlert.TYPE_INFO, "Close", ""));

                    c.pastWeekButton.setEnabled(true);
                    c.pastYearButton.setEnabled(true);
                    c.overallButton.setEnabled(true);
                }
            };

            worker.execute();

        }

    }

    private class PastYearButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            HistoryAnalysis ha = new HistoryAnalysis(session);

            HistoryAnalysisFormController c = HistoryAnalysisFormController.this;

            c.pastWeekButton.setEnabled(false);
            c.pastMonthButton.setEnabled(false);
            c.pastYearButton.setEnabled(false);
            c.overallButton.setEnabled(false);

            c.alertPane.showAlert(new JAlert(JAlert.TYPE_INFO, "Loading data from the past year...", ""));

            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                protected Void doInBackground() {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ignored) {

                    }

                    ArrayList<String> output = ha.getSummary('Y');

                    c.avgDailyStudyText.setText("Average Daily Study Time: " + output.get(0));
                    c.avgDailyExerciseText.setText("Average Daily Exercise Time: " + output.get(1));

                    return null;
                }

                protected void done() {

                    HistoryAnalysisFormController.this.alertPane.showAlert(new JAlert(JAlert.TYPE_INFO, "Close", ""));

                    c.pastWeekButton.setEnabled(true);
                    c.pastMonthButton.setEnabled(true);
                    c.overallButton.setEnabled(true);
                }
            };

            worker.execute();

        }

    }

    private class OverallButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            HistoryAnalysis ha = new HistoryAnalysis(session);

            HistoryAnalysisFormController c = HistoryAnalysisFormController.this;

            c.pastWeekButton.setEnabled(false);
            c.pastMonthButton.setEnabled(false);
            c.pastYearButton.setEnabled(false);
            c.overallButton.setEnabled(false);

            c.alertPane.showAlert(new JAlert(JAlert.TYPE_INFO, "Loading all data...", ""));

            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                protected Void doInBackground() {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ignored) {

                    }

                    ArrayList<String> output = ha.getSummary('O');

                    c.avgDailyStudyText.setText("Average Daily Study Time: " + output.get(0));
                    c.avgDailyExerciseText.setText("Average Daily Exercise Time: " + output.get(1));

                    return null;
                }

                protected void done() {

                    HistoryAnalysisFormController.this.alertPane.showAlert(new JAlert(JAlert.TYPE_INFO, "Close", ""));

                    c.pastWeekButton.setEnabled(true);
                    c.pastMonthButton.setEnabled(true);
                    c.pastYearButton.setEnabled(true);

                }
            };

            worker.execute();

        }

    }

}
