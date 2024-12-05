package lesson8;

public class Lesson8 {

    /**
     * 1. Реализовать метод findSymbolOccurance.
     * Метод принимает в качестве параметров строку и символ. Необходимо вычислить,
     * сколько раз символ встречается в переданной строке и вернуть это числовое значение.
     *
     * @param source string where needs to find a char
     * @param target a char to find in source string
     * @return number of chars found
     */
    public int findSymbolOccurance(String source, char target) {
        int result = 0;
        char[] charArray = source.toCharArray();
        for (char j : charArray) {
            if (j == target) {
                result++;
            }
        }
        return result;
    }

    /**
     * 2. Реализовать метод findWordPosition.
     * Метод принимает в качестве параметров две строки (source, target).
     * Необходимо выяснить, является ли target (подстрока) частью строки source.
     * Если да, тогда вернуть номер позиции (индекс) первого элемента подстроки в строке, иначе вернуть -1.
     * <p>
     * Пример 1: Source: Apollo Target: pollo Result: 1 Пример 2: Source: Apple Target: Plant Result: -1
     *
     * @param source source string where needs to find a substring
     * @param target substring to find in source string
     * @return index of the first substring character
     */
    public int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    /**
     * 3. Реализовать метод stringReverse.
     * Метод принимает в качестве параметра строку.
     * Необходимо развернуть данную строку и вернуть измененный вариант.
     * Пример 1: Hello -> olleH
     *
     * @param source string to reverse
     * @return reversed string
     */
    public String stringReverse(String source) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = source.length() - 1; i >= 0; i--) {
            stringBuilder.append(source.charAt(i));
        }
        return String.valueOf(stringBuilder);
    }

    /**
     * 4. Реализовать метод isPalindrome.
     * Метод принимает в качестве параметра строку. Необходимо Проверить является ли переданная строка палиндромом.
     * Если да, тогда вернут true, иначе false.
     * Пример 1: ERE -> true
     * Пример 2: Allo -> false
     *
     * @param source string to check if palindrome
     * @return boolean result of checking
     */
    public boolean isPalindrome(String source) {
        return source.equals(stringReverse(source));
    }
}
