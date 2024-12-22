package lesson12;

import lesson12.exceptions.ArrayDataException;
import lesson12.exceptions.ArraySizeException;

public class Main {
    public static void main(String[] args) {
        ArrayValueCalculator arrayValueCalculator = new ArrayValueCalculator();
        String[][] values = {
                {"5", "88", "88", "12"},
                {"5", "7", "10", "12"},
                {"5", "7", "10", "12"},
                {"5", "6", "10", "12"},
        };

        try {
            System.out.println(arrayValueCalculator.doCalc(values));
        } catch (ArraySizeException e) {
            System.out.println("The array does not match the required size.");
        } catch (ArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
