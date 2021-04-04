package main.gui.settings;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.gui.AbstractMainForm;
import main.gui.Stylesheet;

public class SettingsForm extends AbstractMainForm {

    SettingsFormController controller;

    public SettingsForm(SettingsFormController controller) {
        super(controller);

        this.controller = controller;

        getContentPane().add(this.genMain());
    }

    public JPanel genBody() {
        JPanel panel = new JPanel();

        panel.add(new JLabel("Settings"));

        JButton loginButton = new JButton("Logout");
        Stylesheet.formatButton(loginButton, "primary");
        this.controller.bindLogoutButton(loginButton);
        panel.add(loginButton);

        return panel;
    }
}
