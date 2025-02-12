package lesson24.exceptions;

/**
 * Exception which is thrown if more than one method has defined annotation.
 */
public class InvalidSignatureException extends RuntimeException {

    public InvalidSignatureException(String message) {
        super(message);
    }
}
