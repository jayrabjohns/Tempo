package main.gui.home;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import main.backend.messages.MotivationalMessage;
import main.backend.messages.MotivationalMessages;
import main.gui.example.Dialog;
import main.gui.Screen;
import main.gui.JAlert;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.awt.event.ComponentAdapter;

import main.backend.analysis.HistoryAnalysis;
import main.backend.Session;

import main.gui.AbstractMainFormController;
import main.gui.Form;

public class HomeFormController extends AbstractMainFormController {

    private MotivationalMessages messages;
    private Session session;
    private HistoryAnalysis historyAnalysis;

    private JPanel alertPane;
    private JLabel headerLabel;

    private JLabel avgDailyStudyText;
    private JLabel avgDailyExerciseText;
    
    public HomeFormController(MotivationalMessages messages, Session session, HistoryAnalysis historyAnalysis) {
        super();

        this.messages = messages;
        this.session = session;
        this.historyAnalysis = historyAnalysis;
    }

    public void bindHeaderLabel(JLabel label) {
        this.headerLabel = label;
    }

    public void bindAvgDailyStudyText(JLabel label) {
        this.avgDailyStudyText = label;
    }

    public void bindAvgDailyExerciseText(JLabel label) {
        this.avgDailyExerciseText = label;
    }

    public void bindSurpriseMe(JButton button) {
        button.addActionListener(new SurpriseMeButtonListener());
    }

    private class SurpriseMeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Screen.showDialog(new Dialog("BOO!", 0));
        }
    }

    public void bindAlertPane(JPanel panel) {
        this.alertPane = panel;
    }

    public void onFormVisibleChange(boolean visible) {
        if(visible) {

            this.headerLabel.setText("Welcome, " + session.getForename());

            SwingWorker<Void, Void> messageWorker = new SwingWorker<Void,Void>() {
                protected MotivationalMessage message;
                
                protected Void doInBackground() {
                    this.message = HomeFormController.this.getMessage();

                    return null;
                }

                
                protected void done() {
                    HomeFormController.this.showMessage(this.message);
                }
            };

            messageWorker.execute();

            SwingWorker<Void, Void> summaryWorker = new SwingWorker<Void, Void>() {                
                protected ArrayList<String> output;

                protected Void doInBackground() {
                    this.output = historyAnalysis.getSummary('W');

                    return null;
                }

                
                protected void done() {
                    HomeFormController.this.showSummary(this.output);
                }
            };

            summaryWorker.execute();
        
            
        }
    }

    public MotivationalMessage getMessage() {
        MotivationalMessage message = new MotivationalMessage("");

        try {
            message = new MotivationalMessage(this.messages.chooseAGeneralQuote());
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return message;
    }

    public void showMessage(MotivationalMessage message) {
        JAlert alert = new JAlert(2, "", "<html>" + message.getQuote() + "<br><br><i>"  + message.getAuthor() + "</i></html>");

        alert.setPreferredSize(new Dimension(alertPane.getPreferredSize().width, alert.getPreferredSize().height+20));

            alertPane.removeAll();
            alertPane.add(alert);
            alertPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, alert.getPreferredSize().height));
            alertPane.revalidate();
    }

    public void showSummary(ArrayList<String> output) {
        if (output == null) {
            this.avgDailyStudyText.setText("Average Daily Study Time: 0");
            this.avgDailyExerciseText.setText("Average Daily Exercise Time: 0");
        }

        if (output.size() < 2) {
            this.avgDailyStudyText.setText("Average Daily Study Time: 0");
            this.avgDailyExerciseText.setText("Average Daily Exercise Time: 0");
        }

        this.avgDailyStudyText.setText("Average Daily Study Time: " + output.get(0));
        this.avgDailyExerciseText.setText("Average Daily Exercise Time: " + output.get(1));
    }
}
