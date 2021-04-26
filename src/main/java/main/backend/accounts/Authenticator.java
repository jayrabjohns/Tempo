package main.backend.accounts;

import main.backend.DBHandler;
import main.backend.PasswordEncryption;
import main.backend.validation.Validator;
import main.backend.validation.InvalidUserInputException;
import main.backend.Session;

public class Authenticator {

    Session session;
    DBHandler db;
    PasswordEncryption hasher;

    public Authenticator(Session session, DBHandler db, PasswordEncryption hasher) {
        this.session = session;
        this.db = db;
        this.hasher = hasher;
    }

    public boolean attemptLogin(String username, String password) throws ServerConnectionFailedException, InvalidUserInputException {

        Validator.require(username, "Please enter in your username");
        Validator.require(password, "Please enter in your password");

        String[][] users = this.db.retrieveUserInfo(0);


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
            if(!hasher.verifyPassword(users[i][1], password)) {
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
}
