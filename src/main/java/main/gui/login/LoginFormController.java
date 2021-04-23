package main.gui.login;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import java.awt.event.ActionEvent;
import main.gui.Screen;
import main.backend.DBHandler;
import main.gui.Alertable;
import main.gui.JAlert;
import main.backend.Session;
import main.backend.accounts.Authenticator;
import main.backend.accounts.ServerConnectionFailedException;
import main.backend.validation.InvalidUserInputException;

public class LoginFormController {

    private Alertable alertPane;

    private JButton registerButton;
    private JButton loginButton;
    
    private JTextField usernameField;
    private JPasswordField passwordField;

    private Authenticator authenticator;

    public LoginFormController(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    public void bindRegisterButton(JButton button) {
        button.addActionListener(new RegisterButtonListener());
        this.registerButton = button;
    }

    public void bindLoginButton(JButton button) {
        button.addActionListener(new LoginButtonListener());
        this.loginButton = button;
    }

    public void bindUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
        this.usernameField.addActionListener(new FormInputListener());
    }

    public void bindPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
        this.passwordField.addActionListener(new FormInputListener());
    }


    public void bindAlertable(Alertable alertPane) {
        this.alertPane = alertPane;
    }

    private class FormInputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Simulate a login click
            LoginFormController.this.loginButton.doClick();
        }
    }

    private class LoginButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            LoginFormController c = LoginFormController.this;

            c.loginButton.setEnabled(false);
            c.registerButton.setEnabled(false);

            String testUsername = "user";
            String testPass = "";

            if(c.usernameField.getText().equals(testUsername) && testPass.equals(new String(c.passwordField.getPassword()))) {
                Session.get().login(1);
                Screen.showForm("home");
                return;
            }
            

            c.alertPane.showAlert(new JAlert(JAlert.TYPE_INFO, "Loading...", ""));
            
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

                private boolean success = false;
                private String message;

                protected Void doInBackground() {

                    try {
                        // Try to login
                        if(!c.authenticator.attemptLogin(c.usernameField.getText(), new String(c.passwordField.getPassword()))) {
                            return null;
                        }

                        // Assume user's identity
                        c.authenticator.login(c.usernameField.getText());

                    } catch (InvalidUserInputException e) {
                        message = e.getMessage();
                        success = false;
                        return null;
                    } catch (ServerConnectionFailedException e) {
                        message = "Server Connection Failed";
                        success = false;
                        return null;
                    }

                    success = true;
                    
                    return null;
                }

                protected void done() {
                    c.loginButton.setEnabled(true);
                    c.registerButton.setEnabled(true);

                    if(success) {
                        Screen.showForm("home");
                    } else {
                        c.alertPane.showAlert(new JAlert(JAlert.TYPE_ERROR, "Login Failed", this.message));
                    }
                }
            };

            worker.execute();
        }
    }

    private class RegisterButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Screen.showForm("register");
        }
    }
}
