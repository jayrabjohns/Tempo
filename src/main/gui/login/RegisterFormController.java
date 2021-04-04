package main.gui.login;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import main.gui.Screen;
import main.gui.Alertable;
import main.gui.JAlert;

public class RegisterFormController implements ActionListener {

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
        button.addActionListener(this);
        this.loginButton = button;
    }

    public void bindRegisterButton(JButton button) {
        button.addActionListener(this);
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

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == this.loginButton) {
            login();
        } else if (source == this.registerButton) {
            register();
        }
        
    }

    public void login() {
        Screen.showForm("login");
    }

    public void register() {
        Screen.getForm("login").showAlert(new JAlert(JAlert.TYPE_SUCCESS, "Registration Success!", "Please now login"));
        Screen.showForm("login");
    }
}
