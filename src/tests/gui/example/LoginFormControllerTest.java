package tests.gui.example;


import gui.*;
import gui.example.*;

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
        Screen.registerForm("signup", new FormTester(Screen.getDefaultSize()));

        LoginFormController controller = new LoginFormController();
        JButton signupButton = new JButton();
        controller.bindSignupButton(signupButton);

        signupButton.doClick();

        assertTrue(this.signupOpened, "Signup Action Failed");
    }

    public class FormTester extends Form {
        public FormTester(Dimension size) {
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
