package tempo.backend;


import static org.junit.jupiter.api.Assertions.*;
import javax.swing.JButton;
import java.awt.Dimension;
import org.junit.jupiter.api.Test;

import main.backend.accounts.Authenticator;

public class AuthenticatorTest {

    /**
     * Tests if a password can be encrypted and then verified again
     */
    @Test
    public void passwordTest() {

        String passwords[] = {
            "",
            "helloworld",
            "a1b2c3d4",
            "!\"$&$&£*(&($*&))",
            "1$1$1$1$1$1$1$1$1$1$1$1$1$1$1$1$",
            "thisisareallylongpasswordIdoubltanybodywouldbedaftenoughtohaveapasswordthislongbutyouneverknowtherearesomewierdpeopleoutthere",
            "i never use spaces in my password"
        };

        for(String password : passwords) {
            String hash = Authenticator.encryptPassword(password);

            assertTrue(hash.length() < 255, "Password hash is too long for database for password " + password);

            // Check the password can be verified again.
            assertTrue(Authenticator.verifyPassword(hash, password), "Password verification failed for " + password);
        }
    }
}
