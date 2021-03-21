package main.login;

import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import java.awt.event.ActionEvent;
import main.gui.Screen;
import main.gui.Alertable;
import main.gui.JAlert;

public class LoginFormController implements ActionListener {

    private Alertable alertPane;

    private JButton registerButton;
    private JButton loginButton;
    
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFormController() {
        // Nothing to do
    }

    public void bindRegisterButton(JButton button) {
        button.addActionListener(this);
        this.registerButton = button;
    }

    public void bindLoginButton(JButton button) {
        button.addActionListener(this);
        this.loginButton = button;
    }

    public void bindUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public void bindPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }


    public void bindAlertable(Alertable alertPane) {
        this.alertPane = alertPane;
    }


    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == this.loginButton) {
            login(e);
        } else if (source == this.registerButton) {
            register(e);
        }

        
    }

    public void login(ActionEvent e) {
        this.loginButton.setEnabled(false);
        this.registerButton.setEnabled(false);

        

        this.alertPane.showAlert(new JAlert(JAlert.TYPE_INFO, "Loading...", ""));
        
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            protected Void doInBackground() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                
                return null;
            }

            protected void done() {
                if(LoginFormController.this.usernameField.getText().equals("user")) {
                    LoginFormController.this.alertPane.showAlert(new JAlert(JAlert.TYPE_SUCCESS, "Success!", "Username correct")); 
                } else {
                    LoginFormController.this.alertPane.showAlert(new JAlert(JAlert.TYPE_ERROR, "FAILED!", "Username incorrect")); 
                }
                
                LoginFormController.this.loginButton.setEnabled(true);
                LoginFormController.this.registerButton.setEnabled(true);
            }
        };

        worker.execute();
    }

    public void register(ActionEvent e) {
        Screen.showForm("register");
    }
}
