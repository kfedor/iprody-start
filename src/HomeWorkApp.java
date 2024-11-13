
public class HomeWorkApp {
    public static void main(String[] args) {
        int a = 55;
        int b = -40;
        int value = -88;
        String stringToPrint = "Строка на печать.";
        int amountToPrint = 5;
        int year = 1100;
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkRange(a, b));
        checkValue(value);
        System.out.println(checkIfValueIsNegative(value));
        printString(stringToPrint, amountToPrint);
        System.out.println(isLeapYear(year));

    }

    /**
     * 1. Создайте метод printThreeWords(),
     * который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.
     */
    public static void printThreeWords() {
        System.out.println("""
                Orange
                Banana
                Apple""");
    }

    /**
     * 2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b,
     * и инициализируйте их любыми значениями, которыми захотите.
     * Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0,
     * то вывести в консоль сообщение “Сумма положительная”,
     * в противном случае - “Сумма отрицательная”;
     */
    public static void checkSumSign() {
        int a = 10;
        int b = -50;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    /**
     * 3. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
     * Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”,
     * если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно),
     * то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;
     */
    public static void printColor() {
        int value = -44;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    /**
     * 4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b,
     * и инициализируйте их любыми значениями, которыми захотите. Если a больше или равно b,
     * то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
     */
    public static void compareNumbers() {
        int a = 99;
        int b = -33;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    /**
     * 5. Написать метод, принимающий на вход два целых числа и проверяющий,
     * что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true,
     * в противном случае – false.
     */
    public static boolean checkRange(int a, int b) {
        return (a + b >= 10) && (a + b <= 20);
    }

    /**
     * 6. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
     * положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
     */
    public static void checkValue(int value) {
        if (value < 0) {
            System.out.println("Входящее число является отрицательным.");
        } else {
            System.out.println("Входящее число является положительным.");
        }
    }

    /**
     * 7. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
     * если число отрицательное, и вернуть false если положительное.
     */
    public static boolean checkIfValueIsNegative(int value) {
        return value < 0;
    }

    /**
     * 8. Написать метод, которому в качестве аргументов передается строка и число,
     * метод должен отпечатать в консоль указанную строку, указанное количество раз;
     */
    public static void printString(String stringToPrint, int amountToPrint) {
        for (int i = 0; i < amountToPrint; i++) {
            System.out.println(stringToPrint);
        }
    }

    /**
     * 9. Написать метод, который определяет, является ли год високосным,
     * и возвращает boolean (високосный - true, не високосный - false).
     * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}