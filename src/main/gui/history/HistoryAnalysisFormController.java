package main.gui.history;

import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import java.awt.event.ActionEvent;

import main.gui.AbstractMainFormController;
import main.gui.Screen;
import main.gui.Alertable;
import main.gui.JAlert;

public class HistoryAnalysisFormController extends AbstractMainFormController {

    private Alertable alertPane;

    private JButton pastWeek;
    private JButton pastMonth;
    private JButton pastYear;
    private JButton overall;

    public HistoryAnalysisFormController() {
        // Nothing to do
    }

}
