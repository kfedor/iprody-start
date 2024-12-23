package lesson13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTraining {


    /**
     * Task 1. Method counts occurrence of string to find in list.
     *
     * @param strings      list of strings used to find a target
     * @param targetString for which it is necessary to count occurrence
     * @return amount of target string occurrence in list
     */
    public int countOccurrence(List<String> strings, String targetString) {
        int count = 0;
        for (String string : strings) {
            if (string.equals(targetString)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Task 2. Method that converts array to list
     *
     * @param values array of ints
     * @return list of ints from array
     */
    public List<Integer> toList(int[] values) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int value : values) {
            integers.add(value);
        }
        return integers;
    }

    /**
     * Task 3. Method finds unique integers in list.
     *
     * @param integers - list where it is necessary to find unique ints
     * @return list contains unique ints only
     */
    public List<Integer> findUnique(List<Integer> integers) {
        List<Integer> uniqueInts = new ArrayList<>();
        for (int value : integers) {
            if (!uniqueInts.contains(integers.get(value))) {
                uniqueInts.add(integers.get(value));
            }
        }
        return uniqueInts;
    }

    /**
     * Task 4. Method counts the number of occurrences of each word in the list and prints it.
     *
     * @param strings list with strings to count occurrences
     */
    public void calcOccurrence(List<String> strings) {
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            if (!temp.contains(strings.get(i))) {
                System.out.println(strings.get(i) + ":" + Collections.frequency(strings, strings.get(i)));
                temp.add(strings.get(i));
            }
        }
    }

    /**
     * Task 5. Method find the number of occurrences of each word in the list and returns it as a list of collections.
     *
     * @param strings list with strings to count occurrences
     * @return list of collections which describes number of occurrences of each word.
     */
    public List<Object> findOccurrence(List<String> strings) {
        List<Object> lists = new ArrayList<>();
        List<String> check = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            if (!check.contains(strings.get(i))) {
                List<String> temp = new ArrayList<>();
                temp.add((strings.get(i) + ":" + Collections.frequency(strings, strings.get(i))));
                lists.add(temp);
                check.add(strings.get(i));
            }
        }
        return lists;
    }

}
