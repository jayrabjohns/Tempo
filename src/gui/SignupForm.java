package gui;

import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Dimension;

public class SignupForm extends Form implements ActionListener {
    
    public SignupForm(Dimension size) {
        super(size);
    }

    public void draw() {
        this.form.setTitle("Sign Up");

        JButton backButton = new JButton("Back");
        backButton.setBounds(175,600,100, 40);  
        backButton.addActionListener(this);
        this.form.add(backButton);
    }

    public void actionPerformed(ActionEvent e) {
        Screen.showForm("login");
    }

}
