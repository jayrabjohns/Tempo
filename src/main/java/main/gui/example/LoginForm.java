package main.gui.example;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import main.gui.*;

public class LoginForm extends Form {

    public LoginForm(Dimension size, LoginFormController controller) {
        super(size);
        
        this.setLayout(null);
        this.setTitle("Login");

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(275,600,100, 40);  
        this.add(loginButton);
        controller.bindLoginButton(loginButton);

        JButton recoverButton = new JButton("Recover");
        recoverButton.setBounds(175,600,100, 40);  
        this.add(recoverButton);
        controller.bindRecoverButton(recoverButton);

        JButton signupButton = new JButton("Sign Up");
        signupButton.setBounds(75,600,100, 40);
        this.add(signupButton);
        controller.bindSignupButton(signupButton);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(75,300,100, 40);
        this.add(usernameField); 
        controller.bindUsernameField(usernameField);


        JLabel status = new JLabel();
        status.setBounds(75,400,100, 40);
        this.add(status); 
        controller.bindStatus(status);
    }
}
