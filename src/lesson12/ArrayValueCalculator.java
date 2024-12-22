package lesson12;

import lesson12.exceptions.ArrayDataException;
import lesson12.exceptions.ArraySizeException;

/**
 * Class does different calculations with arrays.
 */
public class ArrayValueCalculator {

    /**
     * The method takes a two-dimensional array of string representation of integers,
     * converts the strings to integers, and returns the sum of all the numbers.
     *
     * @param values - two-dimensional array of string representation of integers
     * @return sum of all integers from arrays
     * @throws ArraySizeException    if size of two-dimensional array doesn't match 4x4
     * @throws NumberFormatException if array contains any value that can be parsed to integer
     */
    public int doCalc(String[][] values) throws ArraySizeException, NumberFormatException {
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                if (values.length != 4 || values[i].length != 4) {
                    throw new ArraySizeException();
                }
                try {
                    result += Integer.parseInt(values[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException(String.format("Incorrect format data in the cell [%d][%d].", i, j));
                }
            }
        }
        return result;
    }
}


