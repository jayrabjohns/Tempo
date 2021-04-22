package tempo.gui.login;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.gui.login.*;
import main.backend.Session;

public class LoginFormTest {

    /**
     * Make sure the form can be initialized and shown without error
     */
    @Test
    public void testInitialized() {
        Session session = Session.get();
        session.logout();
        LoginForm form = new LoginForm(new LoginFormController(session));

        form.setVisible(true);

        assertTrue(form.isVisible());
    }
}
