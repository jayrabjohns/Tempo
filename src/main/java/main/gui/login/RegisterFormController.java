package main.gui.login;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import java.awt.event.ActionEvent;
import main.gui.Screen;
import main.backend.accounts.Registration;
import main.backend.validation.InvalidUserInputException;
import main.gui.Alertable;
import main.gui.JAlert;

public class RegisterFormController {

    private Alertable alertPane;
    private JButton loginButton;
    private JButton registerButton;

    private JTextField forenameField;
    private JTextField surnameField;
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField retypePasswordField;


    private Registration registration;
    

    public RegisterFormController(Registration registration) {
        this.registration = registration;
    }

    public void bindLoginButton(JButton button) {
        button.addActionListener(new LoginButtonListener());
        this.loginButton = button;
    }

    public void bindRegisterButton(JButton button) {
        button.addActionListener(new RegisterButtonListener());
        this.registerButton = button;
    }

    public void bindEmailField(JTextField field) {
        this.emailField = field;
    }

    public void bindForenameField(JTextField field) {
        this.forenameField = field;
    }

    public void bindSurnameField(JTextField field) {
        this.surnameField = field;
    }

    public void bindUsernameField(JTextField field) {
        this.usernameField = field;
    }

    public void bindPasswordField(JPasswordField field) {
        this.passwordField = field;
    }

    public void bindRetypePasswordield(JPasswordField field) {
        this.retypePasswordField = field;
    }

    public void bindAlertable(Alertable alertPane) {
        this.alertPane = alertPane;
    }

    private class LoginButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Screen.showForm("login");
        }
    }

    private class RegisterButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            RegisterFormController c = RegisterFormController.this;

            c.loginButton.setEnabled(false);
            c.registerButton.setEnabled(false);

            c.alertPane.showAlert(new JAlert(JAlert.TYPE_INFO, "Loading...", ""));
            
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                private boolean success;
                private String message;

                protected Void doInBackground() {

                    try {
                        this.success = false;
                        this.message = "";

                        c.registration.register(
                            c.usernameField.getText(), 
                            new String(c.passwordField.getPassword()), 
                            new String(c.retypePasswordField.getPassword()),
                            c.forenameField.getText(), 
                            c.surnameField.getText(), 
                            c.emailField.getText()
                        );
                    } catch (InvalidUserInputException e) {
                        this.success = false;
                        this.message = e.getMessage();
                        return null;
                    }
                    
                    this.success = true;

                    return null;
                }

                protected void showInvalidCredentials() {
                    RegisterFormController.this.alertPane.showAlert(new JAlert(JAlert.TYPE_ERROR, "FAILED!", "Username incorrect"));
                }

                protected void done() {
                    c.loginButton.setEnabled(true);
                    c.registerButton.setEnabled(true);

                    if(this.success) {
                        c.clearForm();
                        c.alertPane.showAlert(null);

                        Screen.getForm("login").showAlert(new JAlert(JAlert.TYPE_SUCCESS, "Registration Success!", "Please now login"));
                        Screen.showForm("login");
                    } else {
                        c.alertPane.showAlert(new JAlert(JAlert.TYPE_ERROR, "Registration Failed", this.message));
                    }
                }
            };

            worker.execute();
        }
    }

    public void clearForm() {
        this.forenameField.setText("");
        this.emailField.setText("");
        this.passwordField.setText("");
        this.surnameField.setText("");
        this.usernameField.setText("");
        this.retypePasswordField.setText("");
    }
}

