package lesson24;

import lesson24.exceptions.AssertException;
import lesson24.exceptions.AssertResult;

import java.lang.reflect.Field;

/**
 * Class for verifying that the expected test result matches the actual one.
 */
public final class Assertions {

    private Assertions() {
    }


    public static <T> void equal(T expected, T actual) {
        boolean result = expected.equals(actual);
        throw new AssertException(new AssertResult<>(expected, actual, result));
    }

    public static void contains(String current, String toContain) {
        boolean result = current.contains(toContain);
        throw new AssertException(new AssertResult<>(current, toContain, result));
    }

    public static <T> void contains(T[] current, T[] toContain) {
        boolean result = false;
        if (current.length == 0 || current.length < toContain.length) {
            throw new AssertException(new AssertResult<>(current, toContain, result));
        }

    }

    public static <T> void equalRecursively(T expected, T actual) {

        boolean result = false;
        Field[] expectedDeclaredFields = expected.getClass().getDeclaredFields();
        Field[] actualDeclaredFields = actual.getClass().getDeclaredFields();
        if (expectedDeclaredFields.length != actualDeclaredFields.length) {
            throw new AssertException(new AssertResult<>(expected, actual, result));
        }
        for (int i = 0; i < expectedDeclaredFields.length; i++) {
            if (expectedDeclaredFields[i].equals(actualDeclaredFields[i])) {
                throw new AssertException(new AssertResult<>(expected, actual, result));
            }
        }
        result = true;
        throw new AssertException(new AssertResult<>(expected, actual, result));
    }

}
