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

public class LoginFormController {

    private Alertable alertPane;

    private JButton registerButton;
    private JButton loginButton;
    
    private JTextField usernameField;
    private JPasswordField passwordField;

    private Session session;

    public LoginFormController(Session session) {
        this.session = session;
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
                protected Void doInBackground() {

                    String[][] users = DBHandler.retrieveUserInfo();


                    for(int i = 0; i < users.length; i++) {
                        // Reached end of users
                        if (users[i][0] == null) {
                            break;
                        }

                        // Check username correct
                        if(!users[i][0].equals(c.usernameField.getText())) {
                            continue;
                        }

                        // Check password
                        if(!users[i][1].equals(new String(c.passwordField.getPassword()))) {
                            break;
                        }

                        c.session.login(c.usernameField.getText());
                    }

                    return null;
                }

                protected void showInvalidCredentials() {
                    LoginFormController.this.alertPane.showAlert(new JAlert(JAlert.TYPE_ERROR, "FAILED!", "Username incorrect"));
                }

                protected void done() {
                    c.loginButton.setEnabled(true);
                    c.registerButton.setEnabled(true);

                    // Check logged in
                    if(c.session.getUserId() != -1) {
                        Screen.showForm("home");
                    
                    } else {
                        showInvalidCredentials();
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
