package gui;

import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Dimension;

public class LoginForm extends Form {

    public ActionListener controller;

    public LoginForm(Dimension size, ActionListener controller) {
        super(size);
        this.controller = controller;
    }

    public void draw() {
        this.form.setLayout(null);
        this.form.setTitle("Login");

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(275,600,100, 40);  
        this.form.add(loginButton);
        loginButton.setActionCommand("login");
        loginButton.addActionListener(this.controller);

        JButton recoverButton = new JButton("Recover");
        recoverButton.setBounds(175,600,100, 40);  
        this.form.add(recoverButton);

        JButton signupButton = new JButton("Sign Up");
        signupButton.setBounds(75,600,100, 40);
        signupButton.addActionListener(this.controller);
        signupButton.setActionCommand("signup");
        this.form.add(signupButton);
    }
}
