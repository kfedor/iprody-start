package lesson5;

/**
 * Необходимо реализовать репрезентацию структуры данных “Двойная очередь”,
 * в основе которой будет лежать просто одномерный массив.
 * Реализация должно выражать в нескольких методах, позволяющих создать очередь и выполнять операции над ней.
 */
public class List {

    /**
     * Инициализация очереди.
     * В качестве параметров метод принимает размер очереди и инициализирует ее.
     * Возвращающемся значением должен быть одномерный целочисленный массив указанной длины.
     *
     * @param size of the list to initialize
     * @return initialized list
     */
    public int[] initializeList(int size) {
        return new int[size];
    }

    /**
     * Добавление в голову очереди.
     * В качестве параметров метод принимает проинициализированный одномерный целочисленный массив и новое значение.
     * Данное значение должен быть добавлено в голову очереди.
     *
     * @param list which needs to be updated
     * @param elementToAdd to the head of list
     * @return updated list
     */
    public int[] addToHead(int[] list, int elementToAdd) {
        int[] updatedList = new int[list.length + 1];
        updatedList[updatedList.length - 1] = elementToAdd;
        for (int j : updatedList) {
            updatedList[j] = list[j];
        }
        return updatedList;
    }

    /**
     * Получение из головы очереди.
     * В качестве параметра метод принимает проинициализированный одномерный целочисленный массив.
     * Ближайшее значение должно быть извлечено из головы очереди и возвращено в качестве возвращаемого значения метода.
     *
     * @param list from which we get value
     * @return required value
     */
    public int getValueFromHead(int[] list) {
        return list[list.length - 1];
    }

    /**
     * Добавление в хвост очереди.
     * В качестве параметров метод принимает проинициализированный одномерный целочисленный массив и новое значение.
     * Данное значение должен быть добавлено в хвост очереди.
     *
     * @param list which needs to be updated
     * @param elementToAdd to the tail of list
     */
    public int[] addToTail(int[] list, int elementToAdd) {
        int[] updatedList = new int[list.length + 1];
        updatedList[0] = elementToAdd;
        for (int i = 1; i < updatedList.length; i++) {
            updatedList[i] = list[i - 1];
        }
        return updatedList;
    }

    /**
     * Получение из хвоста очереди.
     * В качестве параметра метод принимает проинициализированный одномерный целочисленный массив.
     * Ближайшее значение должно быть извлечено из хвоста очереди и возвращено в качестве возвращаемого значения метода.
     *
     * @param list from which we get value
     * @return required value
     */
    public int getValueFromTail(int[] list) {
        return list[0];
    }
}
