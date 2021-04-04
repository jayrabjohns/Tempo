package main;

import java.awt.Dimension;

import main.gui.Screen;
import main.gui.home.*;
import main.gui.settings.*;
import main.gui.SplashForm;
import main.gui.login.*;
import main.gui.studyTimer.*;

public class App {
    public static void main(String[] args) throws Exception {
    
        Screen.setDefaultSize(new Dimension(400, 700));

        Screen.showForm(new SplashForm());

        Screen.registerForm("login", new LoginForm(new LoginFormController()));
        Screen.registerForm("register", new RegisterForm(new RegisterFormController()));
        Screen.registerForm("timerList", new TimerListForm(new TimerListFormController()));
        Screen.registerForm("timerCreate", new TimerCreationForm(new TimerCreationFormController()));
        Screen.registerForm("timerRun", new TimerRunningForm(new TimerRunningFormController()));
        Screen.registerForm("home", new HomeForm(new HomeFormController()));
        Screen.registerForm("settings", new SettingsForm(new SettingsFormController()));
        
        Screen.showForm("login");

    }
}
