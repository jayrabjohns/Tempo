package main.gui.example;

import main.gui.*;

public class App {
    public static void main(String[] args) throws Exception {
    
        Screen.registerForm("login", new LoginForm(Screen.getDefaultSize(), new LoginFormController()));
        Screen.registerForm("signup", new SignupForm(Screen.getDefaultSize()));
        
        Screen.showForm("login");
    }
}
