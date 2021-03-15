public class App {
    public static void main(String[] args) throws Exception {

        Container services = new Container(new Accounts());
    
        Screen.registerForm("login", new LoginForm(Screen.getDefaultSize(), new LoginFormController()));
        Screen.registerForm("signup", new SignupForm(Screen.getDefaultSize()));
        
        Screen.showForm("login");
    }
}
