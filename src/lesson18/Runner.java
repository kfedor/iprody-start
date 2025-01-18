package lesson18;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Runner {

    public static void main(String[] args) {

    }

    /**
     * 1. Необходимо реализовать метод генерирующий список из 100 случайных чисел в диапазоне от 1 до 1000.
     * Далее, данный метод должен найти топ-10 минимальных значений,
     * затем исключить повторяющиеся значения,
     * и в конечном итоге отсортировать оставшиеся числа в порядке убывания.
     * Результат выполнения вывести в консоль.
     */
    static void task1() {
        Random random = new Random();
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            values.add(random.nextInt(1, 1000));
        }
        values.stream()
                .sorted()
                .limit(10)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    /**
     * 2. Необходимо реализовать метод принимающий в качестве аргумента обобщенный Collection и обобщенный Predicat.
     * Метод должен выполнить фильтрацию переданной коллекции на основании предиката и в качестве результата выполнения
     * необходимо вернуть новый отфильтрованный экземпляр коллекции.
     */
    static <E> Collection<E> task2(Collection<E> collection, Predicate<E> predicate) {
        return collection.stream()
                .filter(predicate)
                .toList();
    }

    /**
     * 3. Необходимо реализовать метод принимающий в качестве аргумента коллекцию строк
     * и Predicat работающий со строками. Метод должен выполнить фильтрацию переданной коллекции на основании предиката,
     * затем соединить все отфильтрованные строки между собой при помощи разделителя.
     * Разделителем соединяемых строк выступает символ “|”.
     * В качестве результата выполнения необходимо вернуть строку состоящую из отфильтрованных строк соединенных
     * при помощи разделителя. Например: “hello|,|world|!”
     */
    static String task3(Collection<String> collection, Predicate<String> predicate) {
        return collection.stream()
                .filter(predicate)
                .collect(Collectors.joining("|"));
    }

    /**
     * 4. Необходимо реализовать метод принимающий в качестве аргумента коллекцию,
     * содержащую произвольные неуникальные числа и направление сортировки (ASC, DESC).
     * Метод должен проинициализировать новую коллекцию, содержащую только уникальные числа
     * отсортированные в соответствии переданного направления, и вернуть ее в качестве результат выполнения.
     */

    enum Direction {
        ASC, DESC
    }

    static List<Integer> task4(List<Integer> values, Direction direction) {
        return values.stream()
                .sorted((o1, o2) -> switch (direction) {
                            case ASC -> o1 - o2;
                            case DESC -> o2 - o1;
                        })
                .distinct()
                .toList();
    }

    /**
     * 5. Необходимо реализовать метод принимающий в качестве аргумента целое число и вычисляющий факториал данного числа.
     * В качестве результата выполнения необходимо вернуть целое число отображающее вычисленный факториал.
     */
    static long task5(int value) {
        return IntStream.rangeClosed(1, value)
                .asLongStream().
                reduce(1, (a, b) -> a * b);
    }

}