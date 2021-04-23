package main.gui.login;

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
import main.gui.*;

public class RegisterForm extends AbstractStartForm  {

    private RegisterFormController controller;

    private JPanel alertPane;

    public RegisterForm(RegisterFormController controller) {
        controller.bindAlertable(this);

        this.controller = controller;

        getContentPane().add(this.genMain());
    }

    public void showAlert(JAlert alert) {
        alertPane.removeAll();
        alertPane.add(alert);
        alertPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, alert.getPreferredSize().height));
        alertPane.revalidate();
    }

    public JPanel genBody() {
        JPanel panel = new JPanel();
        LayoutManager layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        Stylesheet.formatMainBackground(panel);

        panel.setAutoscrolls(true);

        panel.add(Box.createVerticalStrut(50));

        JLabel forenameLabel = new JLabel("Forename");
        forenameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        forenameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(forenameLabel);

        panel.add(Box.createVerticalStrut(5));

        JTextField forenameField = new JTextField();
        forenameField.setAlignmentX(Component.LEFT_ALIGNMENT);  
        Stylesheet.formatInput(forenameField);
        panel.add(forenameField);
        controller.bindForenameField(forenameField);

        panel.add(Box.createVerticalStrut(20));

        JLabel surnameLabel = new JLabel("Surname");
        surnameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        surnameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(surnameLabel);

        panel.add(Box.createVerticalStrut(5));

        JTextField surnameField = new JTextField();
        surnameField.setAlignmentX(Component.LEFT_ALIGNMENT);  
        Stylesheet.formatInput(surnameField);
        panel.add(surnameField);
        controller.bindSurnameField(surnameField);

        panel.add(Box.createVerticalStrut(20));

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(emailLabel);

        panel.add(Box.createVerticalStrut(5));

        JTextField emailField = new JTextField();
        emailField.setAlignmentX(Component.LEFT_ALIGNMENT);  
        Stylesheet.formatInput(emailField);
        panel.add(emailField);
        controller.bindEmailField(emailField);


        panel.add(Box.createVerticalStrut(20));

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(usernameLabel);

        panel.add(Box.createVerticalStrut(5));

        JTextField usernameField = new JTextField();
        usernameField.setAlignmentX(Component.LEFT_ALIGNMENT);  
        Stylesheet.formatInput(usernameField);
        panel.add(usernameField);
        controller.bindUsernameField(usernameField);


        panel.add(Box.createVerticalStrut(20));

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(passwordLabel);

        panel.add(Box.createVerticalStrut(5));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setAlignmentX(Component.LEFT_ALIGNMENT);
        Stylesheet.formatInput(passwordField);
        panel.add(passwordField);
        controller.bindPasswordField(passwordField);

        panel.add(Box.createVerticalStrut(20));

        JLabel retypePasswordLabel = new JLabel("Retype Password");
        retypePasswordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        retypePasswordLabel.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(retypePasswordLabel);

        panel.add(Box.createVerticalStrut(5));

        JPasswordField retypePasswordField = new JPasswordField();
        retypePasswordField.setAlignmentX(Component.LEFT_ALIGNMENT);
        Stylesheet.formatInput(retypePasswordField);
        panel.add(retypePasswordField);
        controller.bindRetypePasswordield(retypePasswordField);

        
        panel.add(Box.createVerticalStrut(20));

        alertPane = new JPanel();
        alertPane.setLayout(new GridLayout());
        alertPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        alertPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, 0));
        panel.add(alertPane);

        panel.add(Box.createVerticalStrut(20));

        JPanel buttons = new JPanel();
        Stylesheet.formatMainBackground(buttons);
        buttons.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
        buttons.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttons.setLayout(new GridLayout(3, 1, 10, 10));

        JButton registerButton = new JButton("Register");
        registerButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        Stylesheet.formatButton(registerButton, "primary");
        buttons.add(registerButton);
        this.controller.bindRegisterButton(registerButton);

        JButton loginButton = new JButton("Back to Login");
        loginButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        Stylesheet.formatButton(loginButton, "secondary");
        buttons.add(loginButton);
        this.controller.bindLoginButton(loginButton);
        
        panel.add(buttons);

        return panel;
    }
}
