package gui.example;

import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Dimension;
import gui.*;

public class LoginForm extends Form {

    public ActionListener controller;

    public JButton loginButton;
    public JButton recoverButton;
    public JButton signupButton;

    public LoginForm(Dimension size, ActionListener controller) {
        super(size);
        this.controller = controller;
    }

    public void draw() {
        this.form.setLayout(null);
        this.form.setTitle("Login");

        this.loginButton = new JButton("Login");
        this.loginButton.setBounds(275,600,100, 40);  
        this.loginButton.setActionCommand("login");
        this.loginButton.addActionListener(this.controller);
        this.form.add(loginButton);

        this.recoverButton = new JButton("Recover");
        this.recoverButton.setBounds(175,600,100, 40);  
        this.form.add(recoverButton);

        this.signupButton = new JButton("Sign Up");
        this.signupButton.setBounds(75,600,100, 40);
        this.signupButton.addActionListener(this.controller);
        this.signupButton.setActionCommand("signup");
        this.form.add(signupButton);
    }
}
