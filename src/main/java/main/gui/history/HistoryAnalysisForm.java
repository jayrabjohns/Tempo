package main.gui.history;

import javax.swing.*;

import java.awt.LayoutManager;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import java.awt.font.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.nio.file.DirectoryNotEmptyException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import main.gui.AbstractMainForm;
import main.gui.Stylesheet;
import main.gui.*;

public class HistoryAnalysisForm extends AbstractMainForm {

    private HistoryAnalysisFormController controller;

    private JPanel alertPane;

    public HistoryAnalysisForm(HistoryAnalysisFormController controller) {

        super(controller);

        controller.bindAlertable(this);

        this.controller = controller;

        getContentPane().add(this.genMain());

    }

    public void showAlert(JAlert alert) {

        if (alert.titleLabel.getText().equals("Close")) {

            alertPane.setVisible(false);

        } else {

            alertPane.setVisible(true);
            alertPane.removeAll();
            alertPane.add(alert);
            alertPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, alert.getPreferredSize().height));
            alertPane.revalidate();

        }

    }

    @Override
    public JPanel genBody() {

        JPanel bodyPanel = new JPanel();
        bodyPanel.setAutoscrolls(true);

        LayoutManager bodyLayout = new BoxLayout(bodyPanel, BoxLayout.Y_AXIS);
        bodyPanel.setLayout(bodyLayout);

        TitledBorder border = new TitledBorder("History and Analysis of Your Data");
        border.setTitleFont(new Font("Arial", Font.BOLD, 22));
        bodyPanel.setBorder(border);

        bodyPanel.add(Box.createVerticalStrut(20));
        bodyPanel.add(this.genSummary());

        return bodyPanel;

    }

    private JPanel genSummary() {

        JPanel panel = new JPanel();

        LayoutManager layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        TitledBorder border = new TitledBorder("Summary");
        border.setTitleFont(new Font("Arial", Font.BOLD, 18));
        panel.setBorder(border);

        panel.add(this.genDataSummary());

        panel.add(Box.createVerticalStrut(10));

        panel.add(this.genButtons());

        return panel;

    }

    private JPanel genDataSummary() {

        JPanel panel = new JPanel();

        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));

        LayoutManager layout = new GridLayout(3, 2);
        panel.setLayout(layout);

        JLabel avgDailyStudyText = new JLabel("Average Daily Study Time: ");
        JLabel avgDailyExerciseText = new JLabel("Average Daily Exercise Time: ");
        // JLabel avgNoGoalsCompletedText = new JLabel("Average Daily Goals Completed: ");

        panel.add(avgDailyStudyText);
        panel.add(avgDailyExerciseText);
        // panel.add(avgNoGoalsCompletedText);

        this.controller.bindAvgDailyStudyText(avgDailyStudyText);
        this.controller.bindAvgDailyExerciseText(avgDailyExerciseText);
        // this.controller.bindAvgNoGoalsCompletedText(avgNoGoalsCompletedText);

        panel.add(this.genAlertPane());

        return panel;

    }

    private JPanel genAlertPane() {

        alertPane = new JPanel();
        alertPane.setLayout(new GridLayout());
        alertPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        alertPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, 0));

        return alertPane;

    }

    private JPanel genButtons() {

        JPanel panel = new JPanel();
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        LayoutManager layout = new GridLayout();
        panel.setLayout(layout);

        JButton pastWeekButton = new JButton("Past Week");
        pastWeekButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        Stylesheet.formatButton(pastWeekButton, "primary");
        pastWeekButton.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(pastWeekButton);
        this.controller.bindPastWeekButton(pastWeekButton);

        JButton pastMonthButton = new JButton("Past Month");
        pastMonthButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        Stylesheet.formatButton(pastMonthButton, "primary");
        pastMonthButton.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(pastMonthButton);
        this.controller.bindPastMonthButton(pastMonthButton);

        JButton pastYearButton = new JButton("Past Year");
        pastYearButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        Stylesheet.formatButton(pastYearButton, "primary");
        pastYearButton.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(pastYearButton);
        this.controller.bindPastYearButton(pastYearButton);

        JButton overallButton = new JButton("Overall");
        overallButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        Stylesheet.formatButton(overallButton, "primary");
        overallButton.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(overallButton);
        this.controller.bindOverallButton(overallButton);

        return panel;

    }

}
