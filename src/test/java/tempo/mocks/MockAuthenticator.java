package tempo.mocks;

import main.backend.accounts.Authenticator;
import main.backend.accounts.ServerConnectionFailedException;
import main.backend.validation.InvalidUserInputException;
import main.backend.DBHandler;
import main.backend.PasswordEncryption;
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
        super(null, null, null);
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
                return false; // Invalid credentials
            case 1:
                return true; // Valid credentials
            case 2:
                throw new ServerConnectionFailedException(); // Server connection issue
            case 3:
                throw new InvalidUserInputException("error"); // Invalid user input
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
