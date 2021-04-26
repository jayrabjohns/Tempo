package tempo.gui.login;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Dimension;
import org.junit.jupiter.api.Test;
import main.gui.*;
import main.gui.login.LoginFormController;
import main.backend.PasswordEncryption;
import main.backend.Session;
import main.backend.DBHandler;
import main.backend.accounts.Authenticator;
import tempo.mocks.*;

import tempo.mocks.MockAuthenticator;

public class LoginControllerTest {

    /**
     * Test the controller shows the register form
     */
    @Test
    public void testRegisterAction() {
        Form registerForm = new MockForm();

        Screen.registerForm("register", registerForm);

        Session.init(new DBHandler());
        Session session = Session.get();
        session.logout();

        LoginFormController controller = new LoginFormController(new MockAuthenticator());

        JButton button = new JButton();

        controller.bindRegisterButton(button);

        button.doClick();

        assertTrue(registerForm.isVisible());
    }

    public void createLoginTestSetup(JButton loginButton, JButton registerButton, JTextField username, JPasswordField password, Alertable alerts, LoginFormController controller) {
        controller.bindLoginButton(loginButton);
        controller.bindRegisterButton(registerButton);
        controller.bindUsernameField(username);
        controller.bindPasswordField(password);
        controller.bindAlertable(alerts);
    }

    @Test
    public void testLogin() {

        for(int i = 0; i < 3; i++) {

            MockForm mainForm = new MockForm();

            Screen.registerForm("home", mainForm);

            JButton loginButton = new JButton();
            JButton registerButton = new JButton();
            JTextField usernameField = new JTextField();
            JPasswordField passwordField = new JPasswordField();
            MockAlertable alerts = new MockAlertable();
            MockAuthenticator mockAuth = new MockAuthenticator();
            mockAuth.attemptLoginOutput = i;
            Authenticator auth = mockAuth;

            LoginFormController controller = new LoginFormController(auth);

            this.createLoginTestSetup(loginButton, registerButton, usernameField, passwordField, alerts, controller);

            usernameField.setText("username");
            passwordField.setText("password");

            loginButton.doClick();

            // Wait as asynchronous
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {

            }       

            // Check attemptLogin was called
            assertTrue(mockAuth.checkAttemptLogin(), "Attempt call never called");

            // Check form mappings
            assertTrue(usernameField.getText().equals(mockAuth.attemptLoginUsername), "Invalid username mapping");
            assertTrue(mockAuth.attemptLoginPassword.equals(new String (passwordField.getPassword())), "Invalid password mapping");


        }

        
    }

    class MockForm extends Form {

    }
}
