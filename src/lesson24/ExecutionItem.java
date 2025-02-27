package lesson24;

import java.lang.reflect.Method;

/**
 * @param <T> - described type of actual and expected result.
 */
public record ExecutionItem<T>(
        Class<?> testingClass,
        Method testingMethod,
        boolean result,
        T expectedResult,
        T actualResult
) {

}
