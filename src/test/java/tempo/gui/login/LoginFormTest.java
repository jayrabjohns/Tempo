package tempo.gui.login;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.gui.login.*;
import tempo.mocks.MockAuthenticator;
import main.backend.Session;
import main.backend.DBHandler;

public class LoginFormTest {

    /**
     * Make sure the form can be initialized and shown without error
     */
    @Test
    public void testInitialized() {
        Session.init(new DBHandler());
        Session session = Session.get();
        session.logout();
        LoginForm form = new LoginForm(new LoginFormController(new MockAuthenticator()));

        form.setVisible(true);

        assertTrue(form.isVisible());
    }
}
