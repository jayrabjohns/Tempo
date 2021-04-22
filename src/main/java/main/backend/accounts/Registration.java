package main.backend.accounts;

import main.backend.validation.Validator;
import main.backend.validation.InvalidUserInputException;
import main.backend.DBHandler;

public class Registration {
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

        // Encrypt password
        password = Authenticator.encryptPassword(password);

        // Otherwise insert it
        DBHandler.insertNewUser(username, password, forename, surname, email);
    }
}