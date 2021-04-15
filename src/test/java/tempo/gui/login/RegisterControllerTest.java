package tempo.gui.login;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;
import org.junit.jupiter.api.Test;
import main.gui.*;
import main.gui.login.RegisterFormController;
public class RegisterControllerTest {

    /**
     * Test the controller shows the login form.
     */
    @Test
    public void testRegisterAction() {
        Form loginForm = new MockForm();

        Screen.registerForm("login", loginForm);

        RegisterFormController controller = new RegisterFormController();

        JButton button = new JButton();

        controller.bindRegisterButton(button);

        button.doClick();

        assertTrue(loginForm.isVisible());
    }

    class MockForm extends Form {

    }
}
