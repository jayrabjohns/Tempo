package main.backend.validation;

public class InvalidUserInputException extends Exception {
    public InvalidUserInputException(String message) {
        super(message);
    }
}
