import java.awt.event.*;

public class LoginFormController implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "login":
                login(e);
                break;
            case "signup":
                signup(e);
                break;
        }
    }

    private void login(ActionEvent e) {
        e.getSource();
    }

    private void signup(ActionEvent e) {
        Screen.showForm("signup");
    }
    
}
