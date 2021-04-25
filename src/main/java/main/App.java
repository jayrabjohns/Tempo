package main;

import java.awt.Dimension;

import main.gui.Screen;
import main.gui.goals.*;
import main.gui.home.*;
import main.gui.settings.*;
import main.gui.SplashForm;
import main.gui.login.*;
import main.gui.timer.*;
import main.backend.Session;
import main.backend.accounts.Registration;
import main.backend.accounts.Authenticator;
import main.gui.history.*;
import main.backend.analysis.*;

import main.backend.messages.MotivationalMessages;

public class App {
    public static void main(String[] args) throws Exception {

        MotivationalMessages messages = new MotivationalMessages();

        Session session = Session.get();
    
        Screen.setDefaultSize(new Dimension(400, 700));

        Screen.showForm(new SplashForm());

        Screen.registerForm("login", new LoginForm(new LoginFormController(new Authenticator(session))));
        Screen.registerForm("register", new RegisterForm(new RegisterFormController(new Registration())));
    
        Screen.registerForm("home", new HomeForm(new HomeFormController(messages, session, new HistoryAnalysis(session))));
        Screen.registerForm("settings", new SettingsForm(new SettingsFormController()));
        
        Screen.registerForm("timerList", new TimerListForm(new TimerListFormController()));
        Screen.registerForm("timerCreate", new TimerEditorForm(new TimerEditorFormController()));
        Screen.registerForm("timerRun", new TimerRunningForm(new TimerRunningFormController()));
        
        Screen.registerForm("goalsView", new GoalsViewForm(new GoalsViewFormController()));
        Screen.registerForm("goalsCreate", new GoalEditingForm(new GoalCreationFormController()));
        Screen.registerForm("goalsChoose", new GoalChoosingForm(new GoalChoosingFormController()));

        Screen.registerForm("historyAnalysis", new HistoryAnalysisForm(new HistoryAnalysisFormController(session)));
        
        Screen.showForm("login");

    }
}
