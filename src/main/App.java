package main;

import java.awt.Dimension;

import main.gui.Screen;
import main.gui.studyTimer.TimerRunningForm;
import main.gui.studyTimer.TimerCreationForm;
import main.gui.studyTimer.TimerCreationFormController;
import main.gui.studyTimer.TimerRunningFormController;
import main.login.*;

public class App {
    public static void main(String[] args) throws Exception {
    
        Screen.setDefaultSize(new Dimension(400, 700));

        Screen.registerForm("login", new LoginForm(new LoginFormController()));
        Screen.registerForm("register", new RegisterForm(new RegisterFormController()));
        Screen.registerForm("createTimer", new TimerCreationForm(new TimerCreationFormController(), 25, 5));
        Screen.registerForm("runTimer", new TimerRunningForm(new TimerRunningFormController()));
        
        Screen.showForm("login");

    }
}
