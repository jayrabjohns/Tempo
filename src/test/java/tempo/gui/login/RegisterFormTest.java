package tempo.gui.login;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.gui.login.*;
import tempo.mocks.MockRegistration;

public class RegisterFormTest {

    /**
     * Make sure the form can be initialized and shown without error
     */
    @Test
    public void testInitialized() {
        RegisterForm form = new RegisterForm(new RegisterFormController(new MockRegistration()));

        form.setVisible(true);

        assertTrue(form.isVisible());
    }
}
