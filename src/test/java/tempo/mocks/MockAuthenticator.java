package tempo.mocks;

import main.backend.accounts.Authenticator;
import main.backend.accounts.ServerConnectionFailedException;
import main.backend.validation.InvalidUserInputException;
import main.backend.Session;

/**
 * Used for mocking an authenticator
 */
public class MockAuthenticator extends Authenticator {

    /** attemptLogin */
    public int attemptLoginOutput;
    public boolean attemptLoginFlag;
    public String attemptLoginUsername;
    public String attemptLoginPassword;

    /** login */
    public boolean loginFlag;
    public String loginUsername;
    

    public MockAuthenticator() {
        // uneeded
        super(Session.get());
    }

    public boolean checkAttemptLogin() {
        if(attemptLoginFlag) {
            attemptLoginFlag = false;
            return true;
        }
        return false;
    }

    public boolean attemptLogin(String username, String password) throws ServerConnectionFailedException, InvalidUserInputException {
        this.attemptLoginFlag = true;

        this.attemptLoginUsername = username;
        this.attemptLoginPassword = password;

        switch (attemptLoginOutput) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                throw new ServerConnectionFailedException();
            case 3:
                throw new InvalidUserInputException("error");
            default:
                break;
        }

        throw new InvalidOutputMode();
    }

    public boolean checkLoginFlag() {
        if(this.loginFlag) {
            this.loginFlag = false;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Assume a user's identity
     */
    public void login(String username) {
        this.loginFlag = true;
        this.loginUsername = username;
    }

    /**
     * Parses and checks a password
     * 
     * @param hash
     * @param password
     */
    public static boolean verifyPassword(String hash, String password) {
        return false;
    }

    /**
     * Encrypts a password
     * 
     * @param password
     */
    public static String encryptPassword(String password) {
        return "";
    }

    
}
