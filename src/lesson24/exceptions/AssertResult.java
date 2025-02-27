package lesson24.exceptions;


/**
 * @param <T> - described type of actual and expected result.
 */
public record AssertResult<T>(
        T expectedResult,
        T actualResult,
        boolean success
) {
}
