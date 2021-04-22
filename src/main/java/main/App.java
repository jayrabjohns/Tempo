package main;

import java.awt.Dimension;

import main.gui.Screen;
import main.gui.goals.GoalCreationForm;
import main.gui.goals.GoalCreationFormController;
import main.gui.goals.GoalsViewForm;
import main.gui.goals.GoalsViewFormController;
import main.java.main.gui.home.*;
import main.java.main.gui.settings.*;
import main.gui.SplashForm;
import main.java.main.gui.login.*;
import main.java.main.gui.timer.*;
import main.java.main.gui.history.HistoryAnalysisForm;
import main.java.main.gui.history.HistoryAnalysisFormController;

public class App {
    public static void main(String[] args) throws Exception {
    
        Screen.setDefaultSize(new Dimension(400, 700));

        Screen.showForm(new SplashForm());

        Screen.registerForm("login", new LoginForm(new LoginFormController()));
        Screen.registerForm("register", new RegisterForm(new RegisterFormController()));
    
        Screen.registerForm("home", new HomeForm(new HomeFormController()));
        Screen.registerForm("settings", new SettingsForm(new SettingsFormController()));
        
        Screen.registerForm("timerList", new TimerListForm(new TimerListFormController()));
        Screen.registerForm("timerCreate", new TimerCreationForm(new TimerCreationFormController()));
        Screen.registerForm("timerRun", new TimerRunningForm(new TimerRunningFormController()));
        
        Screen.registerForm("goalsView", new GoalsViewForm(new GoalsViewFormController()));
        Screen.registerForm("goalsCreate", new GoalCreationForm(new GoalCreationFormController()));

        Screen.registerForm("historyAnalysis", new HistoryAnalysisForm(new HistoryAnalysisFormController()));
        
        Screen.showForm("login");

    }
}
