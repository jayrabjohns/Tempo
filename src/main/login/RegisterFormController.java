package main.login;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import main.gui.Screen;
import main.gui.Alertable;
import main.gui.JAlert;

public class RegisterFormController implements ActionListener {

    private Alertable alertPane;
    private JButton loginButton;
    private JButton registerButton;
    

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
