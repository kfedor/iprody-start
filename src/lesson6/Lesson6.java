package lesson6;

import java.util.Arrays;

public class Lesson6 {
    public static void main(String[] args) {
        int[] source = {11, 92, 73, 46};
        int[] target = {566666, 1066, 777};

        int[] resultArray = arrayCopy(source, target);
        int[] sortedResult = shakerSort(resultArray);
        System.out.println(Arrays.toString(sortedResult));

    }

    /**
     * Необходимо реализовать метод “arrayCopy”. Метод “arrayCopy” должен копировать значения исходного массива (source)
     * в массив назначения (target). При реализации данного метода следует учесть,
     * что копирование в target может производиться с последнего индекса хранящего непустое знание,
     * поскольку данный массив уже может быть заполнен значениями.
     * Пример 1:
     * Source: [1, 2, 3, 4]
     * Target: []
     * Result: [1, 2, 3, 4]
     * <p>
     * Пример 2:
     * Source: [1, 2, 3, 4]
     * Target: [5, 6, 7]
     * Result: [5, 6, 7, 1, 2, 3, 4]
     *
     * @param source array to get values for coping
     * @param target array to put values
     * @return target array with copied values from source
     */
    public static int[] arrayCopy(int[] source, int[] target) {
        int[] result = new int[source.length + target.length];
        int count = 0;
        for (int i = 0; i < target.length; i++) {
            result[i] = target[i];
            count++;
        }
        for (int i = 0; i < source.length; i++) {
            result[count] = source[i];
            count++;
        }
        return result;
    }

    /**
     * Реализовать Шейкерную сортировку.
     * @param resultArray to sort
     * @return array sorted in ordinary way
     */
    public static int[] shakerSort(int[] resultArray) {
        boolean swapped;
        for (int j = 0; j < resultArray.length - 1 - j; j++) {
            swapped = false;
            for (int i = 0; i < resultArray.length - 1 - i; i++) {
                if (resultArray[i] > resultArray[i + 1]) {
                    int temp = resultArray[i + 1];
                    resultArray[i + 1] = resultArray[i];
                    resultArray[i] = temp;
                    swapped = true;
                }
            }
            for (int i = resultArray.length - 1; i > j; i--) {
                if (resultArray[i] < resultArray[i - 1]) {
                    int temp = resultArray[i - 1];
                    resultArray[i - 1] = resultArray[i];
                    resultArray[i] = temp;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return resultArray;
    }
}