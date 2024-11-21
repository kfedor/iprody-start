package lesson5;

/**
 * Необходимо реализовать репрезентацию структуры данных “Очередь”,
 * в основе которой будет лежать просто одномерный массив.
 * Реализация должно выражать в нескольких методах, позволяющих создать очередь и выполнять операции над ней.
 */
public class Queue {

    /**
     * Инициализация очереди.
     * В качестве параметров метод принимает размер очереди и инициализирует ее.
     * Возвращающемся значением должен быть одномерный целочисленный массив указанной длины.
     *
     * @param size to initialize queue
     * @return initialized queue
     */
    public int[] initializeQueue(int size) {
        return new int[size];
    }

    /**
     * Добавление в очередь.
     * В качестве параметров метод принимает проинициализированный одномерный целочисленный массив
     * и новое значение. Данное значение должно быть добавлено в очередь.
     *
     * @param queue which needs to be updated
     * @param elementToAdd to queue
     * @return updated queue
     */
    public int[] add(int[] queue, int elementToAdd) {
        int[] updatedQueue = new int[queue.length + 1];
        updatedQueue[0] = elementToAdd;
        for (int i = 1; i < updatedQueue.length; i++) {
            updatedQueue[i] = queue[i - 1];
        }
        return updatedQueue;
    }

    /**
     * Получение из очереди.
     * В качестве параметра метод принимает проинициализированный одномерный целочисленный массив.
     * Ближайшее значение (согласно принципу FIFO) должно быть извлечено из очереди
     * и возвращено в качестве возвращаемого значения метода.
     *
     * @param queue from which we need to get value
     * @return required value
     */
    public int getValue(int[] queue) {
        return queue[queue.length - 1];
    }

}
