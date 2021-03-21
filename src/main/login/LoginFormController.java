package main.login;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import main.gui.Screen;

public class LoginFormController implements ActionListener {

    private JButton registerButton;

    public LoginFormController() {
        // Nothing to do
    }

    public void bindRegisterButton(JButton button) {
        button.addActionListener(this);
        this.registerButton = button;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        Screen.showForm("register");
    }
}
