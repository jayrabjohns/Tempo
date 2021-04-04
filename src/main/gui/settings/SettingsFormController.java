package main.gui.settings;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import main.gui.AbstractMainFormController;
import main.gui.Screen;

public class SettingsFormController extends AbstractMainFormController {
    
    public void bindLogoutButton(JButton logoutButton) {
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Screen.showForm("login");
            }
        });
    }

}
