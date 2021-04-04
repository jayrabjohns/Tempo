package main.gui;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AbstractMainFormController {

    public void bindHomeButton(JButton homeButton) {
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Screen.showForm("home");
            }
        });
    }

    public void bindTimerButton(JButton timerButton) {
        timerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Screen.showForm("createTimer");
            }
        });
    }

    public void bindGoalsButton(JButton goalsButton) {
        goalsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Screen.showForm("home");
            }
        });
    }

    public void bindHistoryButton(JButton historyButton) {
        historyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Screen.showForm("home");
            }
        });
    }

    public void bindSettingsButton(JButton settingsButton) {
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Screen.showForm("settings");
            }
        });
    }
}
