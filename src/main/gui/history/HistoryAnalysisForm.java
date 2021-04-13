package main.gui.history;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.LayoutManager;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.font.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.gui.AbstractMainForm;
import main.gui.Stylesheet;
import main.gui.*;

public class HistoryAnalysisForm extends AbstractMainForm {

    private HistoryAnalysisFormController controller;

    public HistoryAnalysisForm(HistoryAnalysisFormController controller) {
        super(controller);

        this.controller = controller;

        getContentPane().add(this.genMain());

    }

    public JPanel genBody() {
        JPanel panel = new JPanel();

        panel.add(new JLabel("History - Analysis of your data"));

        return panel;
    }

}
