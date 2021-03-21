package main.login;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import main.gui.Screen;

public class RegisterFormController implements ActionListener {

    private JButton backButton;

    public RegisterFormController() {
        // Nothing to do
    }

    public void bindBackButton(JButton button) {
        button.addActionListener(this);
        this.backButton = button;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        Screen.showForm("login");
    }
}
