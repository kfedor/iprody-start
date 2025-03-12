package lesson27.src.main.java.org.example;

public final class Util {

    private Util() {
    }

    public static int factorial(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value can't be negative.");
        }
        int result = 1;
        for (int i = 2; i <= value; i++) {
            result *= i;
        }
        return result;
    }

    public static double squareRoot(double value) {
        return Math.sqrt(value);
    }

    public static int reverse(int value) {
        int result = 0;
        while (value != 0) {
            int temp = value % 10;
            result = result * 10 + temp;
            value = value / 10;
        }
        return result;
    }

    public static double valuePower(double value1, double value2) {
        return Math.pow(value1, value2);
    }

    public static int square(int value) {
        return value * value;
    }

}
