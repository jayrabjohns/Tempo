package main.backend.accounts;

import main.backend.DBHandler;
import main.backend.PasswordEncryption;
import main.backend.validation.Validator;
import main.backend.validation.InvalidUserInputException;
import main.backend.Session;

public class Authenticator {

    Session session;

    public Authenticator(Session session) {
        this.session = session;
    }

    public boolean attemptLogin(String username, String password) throws ServerConnectionFailedException, InvalidUserInputException {

        Validator.require(username, "Please enter in your username");
        Validator.require(password, "Please enter in your password");

        String[][] users = DBHandler.retrieveUserInfo(0);


        for(int i = 0; i < users.length; i++) {
            // Reached end of users
            if (users[i][0] == null) {
                // If first one is null, then likely connection issue
                if(i == 0) {
                    throw new ServerConnectionFailedException();
                }
            
                break;
            }

            // Check username correct
            if(!users[i][0].equals(username)) {
                continue;
            }

            // Check password
            if(!Authenticator.verifyPassword(users[i][1], password)) {
                break;
            }

            return true;
        }

        return false;
    }

    /**
     * Assume a user's identity
     */
    public void login(String username) {
        this.session.login(username);
    }

    /**
     * Parses and checks a password
     * 
     * @param hash
     * @param password
     */
    public static boolean verifyPassword(String hash, String password) {
        if(hash.substring(0, 3).equals("$1$")) {
            // Type 1 password
            String salt = hash.substring(3, 3 + 25);

            String justHash = hash.substring(3+25);

            String enteredPassword = PasswordEncryption.generateSecurePassword(password, salt);

            return enteredPassword.equals(justHash);
        }


        return false;
    }

    /**
     * Encrypts a password
     * 
     * @param password
     */
    public static String encryptPassword(String password) {

        StringBuilder encrypted = new StringBuilder();

        // Set type of password encryption
        encrypted.append("$1$");

        // Type 1 has salt length of 25
        String salt = PasswordEncryption.getSalt(25);

        encrypted.append(salt);

        String hash = PasswordEncryption.generateSecurePassword(password, salt);

        encrypted.append(hash);

        return encrypted.toString();
    }
}
