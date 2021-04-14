package gui.example;

import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Dimension;
import gui.*;

public class SignupForm extends Form implements ActionListener {
    
    public SignupForm(Dimension size) {
        super(size);
 
        this.setTitle("Sign Up");

        JButton backButton = new JButton("Back");
        backButton.setBounds(175,600,100, 40);  
        backButton.addActionListener(this);
        this.add(backButton);
    }

    public void actionPerformed(ActionEvent e) {
        Screen.showForm("login");
    }

}
