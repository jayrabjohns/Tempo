package main.login;

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
import java.awt.font.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import main.gui.Form;
import main.gui.Stylesheet;

public class LoginForm extends Form {

    public LoginForm(LoginFormController controller) {
        getContentPane().add(this.genMain());
    }

    public JPanel genMain() {
        JPanel panel = new JPanel();
        LayoutManager layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        panel.add(this.genTitle());

        panel.add(this.genLogin());

        return panel;
    }

    public JPanel genTitle() {
        JPanel panel = new JPanel();
        LayoutManager layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        panel.setBackground(Color.LIGHT_GRAY);

        panel.add(Box.createVerticalStrut(80));

        JLabel title = new JLabel("App Name");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(title);

        panel.add(Box.createVerticalStrut(20));
        return panel;
    }

    public JPanel genLogin() {
        JPanel margins = new JPanel();
        margins.setLayout(new BorderLayout());

        margins.setBackground(Color.white);

        JPanel panel = new JPanel();
        LayoutManager layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        panel.setBackground(Color.white);


        panel.add(Box.createVerticalStrut(50));


        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(usernameLabel);

        panel.add(Box.createVerticalStrut(5));

        JTextField usernameField = new JTextField();
        usernameField.setAlignmentX(Component.LEFT_ALIGNMENT);  
        Stylesheet.formatTextField(usernameField);
        usernameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, usernameField.getPreferredSize().height));
        panel.add(usernameField);


        panel.add(Box.createVerticalStrut(20));


        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(passwordLabel);

        panel.add(Box.createVerticalStrut(5));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setAlignmentX(Component.LEFT_ALIGNMENT);
        Stylesheet.formatTextField(passwordField);
        passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, passwordField.getPreferredSize().height));
        panel.add(passwordField);

        
        panel.add(Box.createVerticalStrut(50));

        JPanel buttons = new JPanel();
        buttons.setBackground(Color.WHITE);
        buttons.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));
        buttons.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttons.setLayout(new GridLayout(0, 1));

        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        Stylesheet.formatButton(loginButton, "primary");
        buttons.add(loginButton);

        buttons.add(Box.createVerticalStrut(2));

        JButton registerButton = new JButton("Register");
        loginButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        Stylesheet.formatButton(registerButton, "secondary");
        buttons.add(registerButton);

        panel.add(buttons);
        

        margins.add(Box.createHorizontalStrut(10), BorderLayout.EAST);
        margins.add(Box.createHorizontalStrut(10), BorderLayout.WEST);
        panel.add(Box.createVerticalGlue(), BorderLayout.SOUTH);

        
        margins.add(panel, BorderLayout.CENTER);

        return margins;
    }
}
