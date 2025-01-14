package lesson17.task1;

import java.util.Arrays;
import java.util.List;

/**
 * 2. Необходимо реализовать метод, который принимает в качества параметра массив
 * (массив может быть любого ссылочного типа) и преобразовывает его в List
 * (должен обладать таким же типом данных как и переданный в качестве параметра массив).
 * Результатом выполнения операция является экземпляр List возвращаемый после вызова метода.
 */
public class ApplicationRunner {
    public static void main(String[] args) {
        Integer[] values = {1, 2, 3, 4, 5, 6};
        switchElementsInArray(values);
    }

    /**
     * 1. Необходимо реализовать метод, который принимает в качества параметра массив
     * * (массив может быть любого ссылочного типа) и меняет каждую пару элементов местами между собой.
     * * Метод работает с массивом по ссылке, а значит ничего не возвращает.
     *
     * @param values which should be changed in array
     * @param <T>    could be any object of reference type
     */
    public static <T> void switchElementsInArray(T[] values) {
        T temp;
        for (int i = 0; i < values.length - 1; i++) {
            if (i % 2 == 0) {
                temp = values[i];
                values[i] = values[i + 1];
                values[i + 1] = temp;
            }
        }
        System.out.println(Arrays.toString(values));
    }

    /**
     * 2. Необходимо реализовать метод, который принимает в качества параметра массив
     * (массив может быть любого ссылочного типа) и преобразовывает его в List
     * (должен обладать таким же типом данных как и переданный в качестве параметра массив).
     * Результатом выполнения операция является экземпляр List возвращаемый после вызова метода.
     * @param values
     * @return
     * @param <T>
     */
    public static <T> List<T> arrayToList(T[] values) {
        return List.of(values);
    }
}
