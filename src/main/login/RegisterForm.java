package main.login;

import main.gui.Form;
import javax.swing.JButton;

public class RegisterForm extends Form {

    public RegisterForm(RegisterFormController controller) {
        this.setTitle("Register");

        JButton backButton = new JButton("Go Back");
        this.add(backButton);
        controller.bindBackButton(backButton);
    }
    
}
