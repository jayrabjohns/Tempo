package main.gui.example;

import javax.swing.*;
import java.awt.event.*;
import main.gui.*;
import java.sql.*;


public class LoginFormController implements ActionListener {

    JButton loginButton;
    JButton recoverButton;
    JButton signupButton;
    JTextField usernameField;
    JLabel statusLabel;

    public void bindLoginButton(JButton button) {
        button.addActionListener(this);
        this.loginButton = button;
    }

    public void bindRecoverButton(JButton button) {
        button.addActionListener(this);
        this.recoverButton = button;
    }

    public void bindSignupButton(JButton button) {
        button.addActionListener(this);
        this.signupButton = button;
    }

    public void bindUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public void bindStatus(JLabel label) {
        this.statusLabel = label;
    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == this.loginButton) {
            login(e);
        } else if(source == this.signupButton) {
            signup(e);
        } else if(source == this.recoverButton) {
            //Screen.showDialog(new Dialog("You Failed!", 0));     


            try {
                //Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection("jdbc:mysql://pyp.wwlrc.co.uk/group3?user=group3&password=bathuni");


                PreparedStatement s = conn.prepareStatement("SELECT * FROM User_Accounts");

                ResultSet result = s.executeQuery();
                result.next();
                System.out.println(result.getString("username"));

            
            } catch(Exception er) {
                System.err.println(er.getMessage());
            }
            
            
            
        }
    }

    private void login(ActionEvent e) {
        e.getSource();

        // Call to login(username, password) etc

        if(this.usernameField.getText().equals("user")) {
            this.statusLabel.setText("Success!");
        } else {
            this.statusLabel.setText("FAILED :(");
        }
    }

    private void signup(ActionEvent e) {
        Screen.showForm("signup");
    }
    
}
