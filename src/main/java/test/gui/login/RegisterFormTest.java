package test.gui.login;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import main.gui.login.*;

public class RegisterFormTest {

    /**
     * Make sure the form can be initialized and shown without error
     */
    @Test
    public void testInitialized() {
        RegisterForm form = new RegisterForm(new RegisterFormController());

        form.setVisible(true);

        assertTrue(form.isVisible());
    }
}
