package lesson27.src.test.java;

import org.example.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilTest {


    @Test
    void testFactorialPositiveNumbers() {
        Assertions.assertEquals(120, Util.factorial(5));
        Assertions.assertEquals(3628800, Util.factorial(10));
    }

    @Test
    void testFactorialNegativeNumberThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Util.factorial(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Util.factorial(-10));
    }

    @Test
    void testSquareRootPositiveNumbers() {
        Assertions.assertEquals(3.0, Util.squareRoot(9.0), 1e-9);
        Assertions.assertEquals(5.0, Util.squareRoot(25.0), 1e-9);
        Assertions.assertEquals(1.41, Util.squareRoot(2.0), 1e-2);
    }

    @Test
    void testSquareRootNegativeNumbers() {
        Assertions.assertTrue(Double.isNaN(Util.squareRoot(-4.0)));
    }

    @Test
    void testReversePositiveNumbers() {
        Assertions.assertEquals(1024,Util.reverse(4201));
        Assertions.assertEquals(4356,Util.reverse(6534));
    }

    @Test
    void testReverseZero() {
        Assertions.assertEquals(0, Util.reverse(0));
    }

    @Test
    void testValuePowerPositiveNumbers(){
        Assertions.assertEquals(125.0, Util.valuePower(5.0, 3.0));
        Assertions.assertEquals(729.0, Util.valuePower(3.0, 6.0));
    }

    @Test
    void testValuePowerForZero(){
        Assertions.assertEquals(0.0, Util.valuePower(0.0, 5.0));
    }

    @Test
    void testSquarePositiveNumbers() {
        Assertions.assertEquals(4, Util.square(2));
        Assertions.assertEquals(16, Util.square(4));
        Assertions.assertEquals(25, Util.square(5));
    }

    @Test
    void testSquareZero() {
        Assertions.assertEquals(0, Util.square(0));
    }

}
