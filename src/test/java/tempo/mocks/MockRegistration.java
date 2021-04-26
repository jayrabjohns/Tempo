package tempo.mocks;

import main.backend.accounts.Registration;
import main.backend.validation.InvalidUserInputException;

public class MockRegistration extends Registration {
    public MockRegistration() {
        super(null, null);
    }

    public void register(String username, String password, String retypePassword, String forename, String surname, String email) throws InvalidUserInputException {

    }

}
