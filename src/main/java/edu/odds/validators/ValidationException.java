package edu.odds.validators;

/**
 * Odds validation exception used to distinguish validation errors from all other errors
 */
public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}
