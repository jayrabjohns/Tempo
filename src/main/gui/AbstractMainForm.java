package main.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import icons.IconFetcher;

import javax.swing.JComponent;

import java.awt.LayoutManager;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.font.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import main.gui.*;

public abstract class AbstractMainForm extends Form {

    private JPanel footer = new JPanel();

    private AbstractMainFormController controller;

    protected AbstractMainForm(AbstractMainFormController controller) {
        this.controller = controller; 
    }

    public JComponent genMain() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        Stylesheet.formatMainBackground(panel);

        panel.add(this.genTitle(), BorderLayout.NORTH);

        // Login form
        panel.add(this.genBody(), BorderLayout.CENTER);

        // Left/right margins
        panel.add(Box.createHorizontalStrut(10), BorderLayout.EAST);
        panel.add(Box.createHorizontalStrut(10), BorderLayout.WEST);

        // Footer
        panel.add(genFooter(), BorderLayout.SOUTH);

        JScrollPane scroll = new JScrollPane(panel);



        return scroll;
    }

    public JComponent genTitle() {
        JPanel panel = new JPanel();
        LayoutManager layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        Stylesheet.formatTitleBackgorund(panel);

        panel.add(Box.createVerticalStrut(5));

        JLabel title = new JLabel("Group 3 App");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        Stylesheet.formatHeader(title, 1);
        panel.add(title);

        panel.add(Box.createVerticalStrut(5));
        return panel;
    }

    public JComponent genFooter() {
        
        footer.setLayout(new GridLayout(1, 5));
        Stylesheet.formatFooterBackgorund(footer);

        JButton homeButton = new MenuButton("Home", IconFetcher.getIcon("house.png"));
        footer.add(homeButton);

        JButton timerButton = new MenuButton("Timer", IconFetcher.getIcon("hourglass.png"));
        footer.add(timerButton);

        JButton goalsButton = new MenuButton("Goals", IconFetcher.getIcon("project.png"));
        footer.add(goalsButton);

        JButton historyButton = new MenuButton("History", IconFetcher.getIcon("clock.png"));
        footer.add(historyButton);

        JButton settingsButton = new MenuButton("Settings", IconFetcher.getIcon("cog.png"));
        footer.add(settingsButton);
        
        return footer;
    }

    class MenuButton extends JButton {
        public MenuButton(String message) {
            super(message);

            Stylesheet.formatButton(this, "menu");
        }

        public MenuButton(String message, ImageIcon icon) {
            super(new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_FAST)));

            this.setText(message);
            this.setVerticalTextPosition(SwingConstants.BOTTOM);
            this.setHorizontalTextPosition(SwingConstants.CENTER);

            Stylesheet.formatButton(this, "menu");
        }



    }

    public abstract JComponent genBody();
}
