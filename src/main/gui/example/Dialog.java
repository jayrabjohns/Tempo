package main.gui.example;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import main.gui.Form;
import main.gui.Screen;

public class Dialog extends Form {
    public Dialog(String message) {
        super();

        this.setLayout(null);
        this.setTitle("Login");

        JLabel label = new JLabel(message);
        label.setBounds(100,100,100, 40);  
        this.add(label);

        JButton button = new JButton("OK");
        button.setBounds(200, 200, 200, 200);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Screen.returnDialog();
            }
        });
        this.add(button);
        
    }
}
