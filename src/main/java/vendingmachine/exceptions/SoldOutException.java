package vendingmachine.exceptions;

/**
 * Thrown when user attempts to purchase a sold out item
 */
public class SoldOutException extends RuntimeException {
    private final String errorMessage;

    public SoldOutException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {
        return this.errorMessage;
    }
}
