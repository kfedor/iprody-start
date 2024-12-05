
public class Lesson4 {
    public static void main(String[] args) {
        int[] values = {0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0};
        int[] arrayToChange = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] twoDimensionalArrayExample = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int[] arrayToDivide = {2, 2, 2, 1, 2, 2, 10, 1};
        changeValuesInArray(values);
        initializeArrayAndPrint();
        changeInitializedArray(arrayToChange);
        changeMainDiagonalInTwoDimensionalArray(twoDimensionalArrayExample);
        changeMainAndAdditionalDiagonal(twoDimensionalArrayExample);
        minAndMaxVal(arrayToChange);
        System.out.println(isDivisible(arrayToDivide));
    }

    /**
     * Метод принимает в качестве параметра целочисленный массив, состоящий из элементов 0 и 1.
     * При помощи цикла и условия, данный метод заменяет 0 на 1, 1 на 0 соответственно.
     * Затем, измененный массив необходимо написать в консоль.
     */
    public static void changeValuesInArray(int[] values) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 0) {
                values[i] = 1;
            } else {
                values[i] = 0;
            }
            System.out.print(values[i] + " ");
        }
    }

    /**
     * Метод инициализирует внутри себя пустой целочисленный массив длиной 100.
     * При помощи цикла необходимо заполнить данный массив значениями от 1 до 100.
     * Затем, заполненный значениями массив необходимо написать в консоль.
     */
    public static void initializeArrayAndPrint() {
        int[] values = new int[100];
        for (int i = 0; i < values.length; i++) {
            values[i] = i + 1;
            System.out.println(values[i]);
        }

    }

    /**
     * Метод принимает в качестве параметра заранее проинициализированный массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ].
     * Необходимо в цикле обойти данный массив и каждый элемент значение которого меньше шести должен быть умножен на два.
     * Затем, необходимо вернуть в качестве значения измененный экземпляр массива.
     */
    public static int[] changeInitializedArray(int[] arrayToChange) {
        for (int i = 0; i < arrayToChange.length; i++) {
            if (arrayToChange[i] < 6) {
                arrayToChange[i] *= 2;
            }
        }
        return arrayToChange;
    }

    /**
     * Метод принимает в качестве параметра заранее проинициализированный двумерный (квадратный)
     * целочисленный массив с одинаковым количеством строк и столбцов.
     * При помощи цикла, необходимо заполнить диагональные (главная диагональ) элементы массива единицами.
     * Затем, измененный массив необходимо написать в консоль.
     * Повторить задачу с заполнением главной и дополнительной диагоналей.
     */
    public static void changeMainDiagonalInTwoDimensionalArray(int[][] twoDimensionalArrayExample) {
        for (int i = 0; i < twoDimensionalArrayExample.length; i++) {
            int[] value = twoDimensionalArrayExample[i];
            for (int j = 0; j < value.length; j++) {
                if (i == j) {
                    value[j] = 1;
                }
                System.out.print(value[j] + " ");
            }
            System.out.println();
        }
    }

    public static void changeMainAndAdditionalDiagonal(int[][] twoDimensionalArrayExample) {
        for (int i = 0; i < twoDimensionalArrayExample.length; i++) {
            int[] value = twoDimensionalArrayExample[i];
            for (int j = 0; j < value.length; j++) {
                if (i == j || i == value.length - 1 - j) {
                    value[j] = 1;
                }

                System.out.print(value[j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Метод принимает в качестве параметра два аргумента: len и initialValue.
     * Необходимо проинициализировать массив длины len, и заполнить его элементы значениями initialValue.
     * Затем, необходимо вернуть в качестве значения измененный экземпляр массива.
     */
    public static int[] initializeAndFillArray(int len, int initialValue) {
        int[] values2 = new int[len];
        for (int i = 0; i < values2.length; i++) {
            values2[i] = initialValue;
        }
        return values2;
    }

    /**
     * Метод принимает в качестве параметра одномерный целочисленный массив
     * предварительно заполненный произвольными значениями.
     * Необходимо найти минимальный и максимальный элементы в данном массиве, и напечатать его в консоль.
     */
    public static void minAndMaxVal(int[] arrayToChange) {
        int min = arrayToChange[0];
        int max = arrayToChange[0];
        for (int i = 0; i < arrayToChange.length; i++) {
            min = Math.min(min, arrayToChange[i]);
            max = Math.max(max, arrayToChange[i]);
        }
        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
    }

    /**
     * Метод принимает в качестве параметра одномерный целочисленный массив
     * предварительно заполненный произвольными значениями.
     * В данном массиве необходимо найти положение (индекс), в котором сумма левой и правой части значений массива равны.
     * Затем, необходимо вернуть true в качестве значения если баланс найден, в противном случае - false.
     * Пример 1: Source: [2, 2, 2, 1, 2, 2, ||| 10, 1]Result: true
     * <p>
     * Пример 2: Source: [1, 1, 1, ||| 2, 1]Result: true
     * <p>
     * {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}
     */
    public static boolean isDivisible(int[] arrayToDivide) {
        int sum = 0;
        for (int i = 0; i < arrayToDivide.length; i++) {
            sum += arrayToDivide[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int halfSum = sum / 2;
        int sourceSum = 0;
        for (int i = 0; i < arrayToDivide.length; i++) {
            sourceSum += arrayToDivide[i];
            if (sourceSum == halfSum) {
                return true;
            }
        }
        return false;
    }
}
