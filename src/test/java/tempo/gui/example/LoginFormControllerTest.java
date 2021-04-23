package tempo.gui.example;

import main.gui.login.LoginFormController;
import main.gui.Alertable;
import main.gui.Form;
import main.gui.Screen;
import main.gui.example.*;
import tempo.mocks.MockAlertable;
import tempo.mocks.MockAuthenticator;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Dimension;
import main.backend.accounts.Authenticator;

import org.junit.jupiter.api.Test;

/**
 * Example of a controller test
 */
public class LoginFormControllerTest {

    public boolean signupOpened = false;

    @Test
    public void testSignup() {
        Screen.registerForm("signup", new MockForm(Screen.getDefaultSize()));

        LoginFormController controller = new LoginFormController(new MockAuthenticator());
        JButton signupButton = new JButton();
        controller.bindRegisterButton(signupButton);

        signupButton.doClick();

        assertTrue(this.signupOpened, "Signup Action Failed");
    }

    public void createLoginTestSetup(JButton loginButton, JTextField username, JPasswordField password, Alertable alerts, LoginFormController controller) {
        controller.bindLoginButton(loginButton);
        controller.bindUsernameField(username);
        controller.bindPasswordField(password);
        controller.bindAlertable(alerts);
    }

    @Test
    public void testLogin() {

        for(int i = 0; i < 3; i++) {
            JButton loginButton = new JButton();
            JTextField usernameField = new JTextField();
            JPasswordField passwordField = new JPasswordField();
            MockAlertable alerts = new MockAlertable();
            MockAuthenticator mockAuth = new MockAuthenticator();
            mockAuth.attemptLoginOutput = i;
            Authenticator auth = mockAuth;

            LoginFormController controller = new LoginFormController(auth);

            this.createLoginTestSetup(loginButton, usernameField, passwordField, alerts, controller);

            usernameField.setText("username");
            passwordField.setText("password");

            loginButton.doClick();

            // Wait as asynchronous
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
            

            // Check attemptLogin was called
            assertTrue(mockAuth.checkAttemptLogin(), "Attempt call never callled");

            // Check form mappings
            assertTrue(usernameField.getText().equals(mockAuth.attemptLoginUsername), "Invalid username mapping");
            assertTrue(mockAuth.attemptLoginPassword.equals(new String (passwordField.getPassword())), "Invalid password mapping");


        }

        
    }





    public class MockForm extends Form {
        public MockForm(Dimension size) {
            super(size);
        }

        public void draw() {
            // Do nothing
        }

        public void setVisible(boolean visible) {
            LoginFormControllerTest.this.signupOpened = visible;
        }
    }
}
