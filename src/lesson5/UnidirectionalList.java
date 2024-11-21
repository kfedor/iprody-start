package lesson5;

/**
 * Необходимо реализовать репрезентацию структуры данных “Односвязный список”,
 * в основе которой будет лежать просто одномерный массив. Реализация должно выражать в нескольких методах,
 * позволяющих создать очередь и выполнять операции над ней.
 * Важно, подразумевается что у экземпляра “Списка” всегда будет статическая длина,
 * о которой разработчик уведомлен, что исключает ошибки в случае выхода за пределы длины списка.
 */
public class UnidirectionalList {

    /**
     * Инициализация списка.
     * В качестве параметров метод принимает размер списка и инициализирует его.
     * Возвращающемся значением должен быть одномерный целочисленный массив указанной длины.
     *
     * @param size of list to initialize
     * @return initialized list
     */
    public int[] initializeList(int size) {
        return new int[size];
    }

    /**
     * Добавление в список.
     * В качестве параметров метод принимает проинициализированный одномерный целочисленный массив
     * и новое значение. Данное значение должно быть добавлено в конец списка.
     *
     * @param list which needs to be updated
     * @param elementToAdd to list
     * @return updated list
     */
    public int[] add(int[] list, int elementToAdd) {
        int[] updatedList = new int[list.length + 1];
        updatedList[updatedList.length - 1] = elementToAdd;
        for (int j : list) {
            updatedList[j] = list[j];
        }
        return updatedList;
    }

    /**
     * Получение значения по индексу.
     * В качестве параметра метод принимает проинициализированный одномерный целочисленный массив.
     * Значение соответствующее указанному индексу должно быть получено из списка
     * и возвращено в качестве возвращаемого значения метода.
     *
     * @param list from which we need to get value
     * @param index under which the required value is stored
     * @return required value
     */
    public int getValue(int[] list, int index) {
        return list[index];
    }

    /**
     * Получение длины списка.
     * В качестве параметра метод принимает проинициализированный одномерный целочисленный массив.
     * Значение соответствующее длине списка должно быть возвращено в качестве возвращаемого значения метода.
     *
     * @param list get the length of
     * @return length of the list
     */
    public int size(int[] list) {
        return list.length;
    }
}
