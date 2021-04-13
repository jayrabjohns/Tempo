package main.gui.history;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingWorker;

import java.awt.event.ActionEvent;

import main.gui.AbstractMainFormController;
import main.gui.Alertable;
import main.gui.JAlert;

public class HistoryAnalysisFormController extends AbstractMainFormController {

    private Alertable alertPane;

    private JButton pastWeekButton;
    private JButton pastMonthButton;
    private JButton pastYearButton;
    private JButton overallButton;

    public HistoryAnalysisFormController() {
        // Nothing to do
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

    private class PastWeekButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            HistoryAnalysisFormController c = HistoryAnalysisFormController.this;

            c.pastWeekButton.setEnabled(false);
            c.pastMonthButton.setEnabled(false);
            c.pastYearButton.setEnabled(false);
            c.overallButton.setEnabled(false);

            c.alertPane.showAlert(new JAlert(JAlert.TYPE_INFO, "Loading data from the past week...", ""));

            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                protected Void doInBackground() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }

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

            HistoryAnalysisFormController c = HistoryAnalysisFormController.this;

            c.pastWeekButton.setEnabled(false);
            c.pastMonthButton.setEnabled(false);
            c.pastYearButton.setEnabled(false);
            c.overallButton.setEnabled(false);

            c.alertPane.showAlert(new JAlert(JAlert.TYPE_INFO, "Loading data from the past month...", ""));

            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                protected Void doInBackground() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }

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

            HistoryAnalysisFormController c = HistoryAnalysisFormController.this;

            c.pastWeekButton.setEnabled(false);
            c.pastMonthButton.setEnabled(false);
            c.pastYearButton.setEnabled(false);
            c.overallButton.setEnabled(false);

            c.alertPane.showAlert(new JAlert(JAlert.TYPE_INFO, "Loading data from the past year...", ""));

            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                protected Void doInBackground() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }

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

            HistoryAnalysisFormController c = HistoryAnalysisFormController.this;

            c.pastWeekButton.setEnabled(false);
            c.pastMonthButton.setEnabled(false);
            c.pastYearButton.setEnabled(false);
            c.overallButton.setEnabled(false);

            c.alertPane.showAlert(new JAlert(JAlert.TYPE_INFO, "Loading all data...", ""));

            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                protected Void doInBackground() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }

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
