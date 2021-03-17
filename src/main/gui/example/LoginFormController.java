package main.gui.example;

import javax.swing.*;
import java.awt.event.*;
import main.gui.*;

public class LoginFormController implements ActionListener {

    JButton loginButton;
    JButton recoverButton;
    JButton signupButton;
    JTextField usernameField;
    JLabel statusLabel;

    public void bindLoginButton(JButton button) {
        button.addActionListener(this);
        this.loginButton = button;
    }

    public void bindRecoverButton(JButton button) {
        button.addActionListener(this);
        this.recoverButton = button;
    }

    public void bindSignupButton(JButton button) {
        button.addActionListener(this);
        this.signupButton = button;
    }

    public void bindUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public void bindStatus(JLabel label) {
        this.statusLabel = label;
    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == this.loginButton) {
            login(e);
        } else if(source == this.signupButton) {
            signup(e);
        }
    }

    private void login(ActionEvent e) {
        e.getSource();

        // Call to login(username, password) etc

        if(this.usernameField.getText().equals("user")) {
            this.statusLabel.setText("Success!");
        } else {
            this.statusLabel.setText("FAILED :(");
        }
    }

    private void signup(ActionEvent e) {
        Screen.showForm("signup");
    }
    
}
