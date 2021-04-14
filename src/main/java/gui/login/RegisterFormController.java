package gui.login;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import gui.Screen;
import gui.Alertable;
import gui.JAlert;

public class RegisterFormController {

    private Alertable alertPane;
    private JButton loginButton;
    private JButton registerButton;

    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField retypePasswordField;
    

    public RegisterFormController() {
        // Nothing to do
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
            Screen.getForm("login").showAlert(new JAlert(JAlert.TYPE_SUCCESS, "Registration Success!", "Please now login"));
            Screen.showForm("login");
        }
    }
}

