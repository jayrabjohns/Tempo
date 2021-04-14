package gui.settings;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import gui.AbstractMainFormController;
import gui.JAlert;
import gui.Screen;

public class SettingsFormController extends AbstractMainFormController {
    
    public void bindLogoutButton(JButton logoutButton) {
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Screen.getForm("login").showAlert(new JAlert(JAlert.TYPE_SUCCESS, "Success!", "You have successfully been logged out."));
                Screen.showForm("login");
            }
        });
    }

}
