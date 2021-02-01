package vendingmachine.exceptions;

/**
 * Thrown when vending machine does not have sufficient change to complete the request
 */
public class NotSufficientChangeException extends RuntimeException {
    private final String errorMessage;

    public NotSufficientChangeException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {
        return this.errorMessage;
    }
}
