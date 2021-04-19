package main.gui;

import main.backend.LocalStorage.ResourceManager;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Image;

public class SplashForm extends Form {
    public SplashForm() {
        super();

        JLabel logo = new JLabel(new ImageIcon(ResourceManager.getInstance().getIcon("tempo_w.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalStrut(130));

        panel.add(logo);
        panel.add(Box.createVerticalStrut(20));

        JLabel loading = new JLabel("Loading...");
        Stylesheet.formatHeader(loading, 1);
        loading.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(loading);

        this.setUndecorated(true);
        this.setBackground(Stylesheet.APP_HEADER_BACKGROUND);
        panel.setBackground(Stylesheet.APP_HEADER_BACKGROUND);

        getContentPane().add(panel);
    }
}
