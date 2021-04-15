package main.gui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import main.gui.Stylesheet;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class JAlert extends JPanel {

    public static final int TYPE_SUCCESS = 0;
    public static final int TYPE_ERROR = 1;
    public static final int TYPE_INFO = 2;

    private int type;

    public JLabel titleLabel;
    public JLabel textLabel;

    public JAlert(int type, String title, String text) {
        super();

        this.type = type;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        titleLabel = new JLabel(title);
        this.add(titleLabel);

        textLabel = new JLabel(text);
        this.add(textLabel);

        Stylesheet.formatAlert(this);

        
    }

    public int getType() {
        return this.type;
    }
}