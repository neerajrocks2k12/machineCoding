package vendingmachine.exceptions;

/**
 * Exception thrown when user does not have enough amount but still attempts purchase of item
 */
public class NotFullPaidException extends RuntimeException {
    private final String errorMessage;
    private final long remaining;

    public NotFullPaidException(String errorMessage, long remaining) {
        this.errorMessage = errorMessage;
        this.remaining = remaining;
    }

    public long getRemaining() {
        return this.remaining;
    }

    @Override
    public String getMessage() {
        return this.getFullErrorMsg();
    }

    private String getFullErrorMsg() {
        return this.errorMessage + this.remaining;
    }
}
