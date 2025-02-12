package lesson24.exceptions;

/**
 * An exception identifying the result of the verification performed by the method of the Assertions class.
 */
public class AssertException extends RuntimeException {

    private final AssertResult<?> result;

    public AssertException(AssertResult<?> result) {
        super("Method Executed");
        this.result = result;
    }

    public AssertResult<?> getResult() {
        return result;
    }
}
