package main.login;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import main.gui.Screen;
import main.gui.Alertable;
import main.gui.JAlert;

public class LoginFormController implements ActionListener {

    private Alertable alertPane;

    private JButton registerButton;
    private JButton loginButton;
    

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
    }

    public void register(ActionEvent e) {
        Screen.showForm("register");
    }
}
