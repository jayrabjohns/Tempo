package main.gui;

import javax.swing.JPanel;

import icons.IconFetcher;

import java.awt.LayoutManager;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;

public class FormHeader extends JPanel {
    public FormHeader(int topMargin, int bottomMargin) {
        super();

        LayoutManager layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);

        Stylesheet.formatTitleBackgorund(this);

        if (topMargin > 0) {
            this.add(Box.createVerticalStrut(topMargin));
        }
        
        Icon logo = new ImageIcon(IconFetcher.getIcon("tempo_w.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        JLabel title = new JLabel("Tempo ", logo, JLabel.RIGHT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        Stylesheet.formatHeader(title, 1);
        this.add(title);

        if (bottomMargin > 0) {
            this.add(Box.createVerticalStrut(bottomMargin));
        }
    }
}
