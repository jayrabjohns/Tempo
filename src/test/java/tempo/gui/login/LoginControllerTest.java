package tempo.gui.login;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;
import org.junit.jupiter.api.Test;
import main.gui.*;
import main.gui.login.LoginFormController;
import main.backend.Session;

public class LoginControllerTest {

    /**
     * Test the controller shows the register form
     */
    @Test
    public void testRegisterAction() {
        Form registerForm = new MockForm();

        Screen.registerForm("register", registerForm);

        Session session = Session.get();
        session.logout();

        LoginFormController controller = new LoginFormController(session);

        JButton button = new JButton();

        controller.bindRegisterButton(button);

        button.doClick();

        assertTrue(registerForm.isVisible());
    }

    class MockForm extends Form {

    }
}
