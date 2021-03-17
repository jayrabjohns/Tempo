package test.gui.example;

import main.gui.*;
import main.gui.example.*;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;
import org.junit.jupiter.api.Test;

/**
 * Example of a controller test
 */
public class LoginFormControllerTest {

    public boolean signupOpened = false;

    @Test
    public void testSignup() {
        Screen.registerForm("signup", new MockForm(Screen.getDefaultSize()));

        LoginFormController controller = new LoginFormController();
        JButton signupButton = new JButton();
        controller.bindSignupButton(signupButton);

        signupButton.doClick();

        assertTrue(this.signupOpened, "Signup Action Failed");
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
