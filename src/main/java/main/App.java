package main;

import java.awt.Dimension;

import main.gui.Screen;
import main.gui.goals.GoalCreationForm;
import main.gui.goals.GoalCreationFormController;
import main.gui.goals.GoalsViewForm;
import main.gui.goals.GoalsViewFormController;
import main.gui.home.*;
import main.gui.settings.*;
import main.gui.SplashForm;
import main.gui.login.*;
import main.gui.studyTimer.*;
import main.backend.Session;

import main.backend.messages.MotivationalMessages;

public class App {
    public static void main(String[] args) throws Exception {

        MotivationalMessages messages = new MotivationalMessages();

        Session session = Session.get();
    
        Screen.setDefaultSize(new Dimension(400, 700));

        Screen.showForm(new SplashForm());

        Screen.registerForm("login", new LoginForm(new LoginFormController(session)));
        Screen.registerForm("register", new RegisterForm(new RegisterFormController()));
    
        Screen.registerForm("home", new HomeForm(new HomeFormController(messages)));
        Screen.registerForm("settings", new SettingsForm(new SettingsFormController()));
        
        Screen.registerForm("timerList", new TimerListForm(new TimerListFormController()));
        Screen.registerForm("timerCreate", new TimerCreationForm(new TimerCreationFormController()));
        Screen.registerForm("timerRun", new TimerRunningForm(new TimerRunningFormController()));
        
        Screen.registerForm("goalsView", new GoalsViewForm(new GoalsViewFormController()));
        Screen.registerForm("goalsCreate", new GoalCreationForm(new GoalCreationFormController()));
        
        Screen.showForm("login");

    }
}
