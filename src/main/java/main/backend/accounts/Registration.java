package main.backend.accounts;

import main.backend.validation.Validator;
import main.backend.validation.InvalidUserInputException;
import main.backend.DBHandler;
import main.backend.PasswordEncryption;

public class Registration { 

    private DBHandler db;
    private PasswordEncryption hasher;

    public Registration(DBHandler db, PasswordEncryption hasher) {
        this.db = db;
        this.hasher = hasher;
    }


    public void register(String username, String password, String retypePassword, String forename, String surname, String email) throws InvalidUserInputException {

        Validator.require(forename, "Please enter in your forename");
        Validator.require(surname, "Please enter in your surname");

        Validator.require(email, "Please enter in your email");
        Validator.requireEmail(email, "Please enter in a valid email address");

        Validator.require(username, "Please enter in a username");
        Validator.require(password, "Please enter in a password");
        Validator.require(retypePassword, "Please retype your password");
        

        Validator.requireEquality(password, retypePassword, "Your passwords do not match");
        
        // Check a user with that username doesn't exist
        String[][] users = db.retrieveUserInfo(0);

        for(String[] user: users) {
            if (user[0] == null) {
                break;
            }

            if(user[0].equals(username)) {
                throw new InvalidUserInputException("A user with that username already exists");
            }

            if(user[2].equals(email)) {
                throw new InvalidUserInputException("A user with that email already exists");
            }
        }

        // Encrypt password
        password = hasher.encryptPassword(password);

        // Otherwise insert it
        db.insertNewUser(username, password, forename, surname, email);
    }
}