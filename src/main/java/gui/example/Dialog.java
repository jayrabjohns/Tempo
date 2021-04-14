package gui.example;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import gui.Form;
import gui.Screen;
import java.awt.Color;

public class Dialog extends Form {

    private int inc = 0;

    public Dialog(String message, int inc) {
        super();

        //this.setLayout(null);
        this.setTitle("Login");

        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.setBorder(BorderFactory.createRaisedBevelBorder());

        JLabel label = new JLabel(message + " " + String.valueOf(inc));
        panel.add(label);

        JButton button = new JButton("Close");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Screen.returnDialog();
            }
        });
        panel.add(button);

        JButton incbutton = new JButton("Add");
        incbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Screen.showDialog(new Dialog(message, inc + 1));
            }
        });
        panel.add(incbutton);
        
        panel.setBackground(Color.GRAY);

        getContentPane().add(panel);
    }
}
