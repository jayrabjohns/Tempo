import java.awt.Dimension;

import gui.Screen;
import gui.goals.GoalCreationForm;
import gui.goals.GoalCreationFormController;
import gui.goals.GoalsViewForm;
import gui.goals.GoalsViewFormController;
import gui.home.*;
import gui.settings.*;
import gui.SplashForm;
import gui.login.*;
import gui.studyTimer.*;

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
        
        Screen.showForm("login");

    }
}
