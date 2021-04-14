package gui.login;

import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import java.awt.event.ActionEvent;
import gui.Screen;
import gui.Alertable;
import gui.JAlert;

public class LoginFormController {

    private Alertable alertPane;

    private JButton registerButton;
    private JButton loginButton;
    
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFormController() {
        // Nothing to do
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

            

            c.alertPane.showAlert(new JAlert(JAlert.TYPE_INFO, "Loading...", ""));
            
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                protected Void doInBackground() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                    
                    return null;
                }

                protected void done() {
                    if(c.usernameField.getText().equals("user")) {
                        c.alertPane.showAlert(new JAlert(JAlert.TYPE_SUCCESS, "Success!", "Username correct")); 
                        Screen.showForm("home");
                    } else {
                        LoginFormController.this.alertPane.showAlert(new JAlert(JAlert.TYPE_ERROR, "FAILED!", "Username incorrect")); 
                    }
                    
                    c.loginButton.setEnabled(true);
                    c.registerButton.setEnabled(true);
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
