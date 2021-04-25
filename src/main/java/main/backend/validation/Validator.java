package main.backend.validation;
import org.apache.commons.validator.routines.EmailValidator;

public class Validator {
    
    public static void require(String value, String message) throws InvalidUserInputException {
        if(value.trim().isEmpty()) {
            throw new InvalidUserInputException(message);
        }
    }

    public static void requireEmail(String address, String message) throws InvalidUserInputException {
        EmailValidator validator = EmailValidator.getInstance();

        // check for valid email addresses using isValid method
        if(!validator.isValid(address)) {
            throw new InvalidUserInputException(message);
        }
    }

    public static void requireEquality(String a, String b, String message) throws InvalidUserInputException {
        if(!a.equals(b)) {
            throw new InvalidUserInputException(message);
        }
    }
}
