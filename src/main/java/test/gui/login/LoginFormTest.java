package test.gui.login;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import main.gui.login.*;

public class LoginFormTest {

    /**
     * Make sure the form can be initialized and shown without error
     */
    @Test
    public void testInitialized() {
        LoginForm form = new LoginForm(new LoginFormController());

        form.setVisible(true);

        assertTrue(form.isVisible());
    }
}
