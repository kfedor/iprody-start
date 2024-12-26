package lesson13;

import lesson13.phonebook.BookRecord;
import lesson13.phonebook.PhoneBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CollectionsTraining collectionsTraining = new CollectionsTraining();

        //Task 1 check
        List<String> stringList = Arrays.asList(
                "cat", "dog", "bird", "bird", "bird",
                "dog", "dog", "dog", "dog", "cat");
        System.out.println(collectionsTraining.countOccurrence(stringList, "dog"));

        //Task 3 check
        List<Integer> ints = Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5);
        System.out.println(collectionsTraining.findUnique(ints));

        //Task 4 check
        collectionsTraining.calcOccurrence(stringList);

        //Task 5 check
        System.out.println(collectionsTraining.findOccurrence(stringList));

        //PhoneBook check

        List<BookRecord> bookRecords = new ArrayList<>();
        bookRecords.add(new BookRecord("Petr", "777"));
        bookRecords.add(new BookRecord("Dasha", "999"));
        bookRecords.add(new BookRecord("Petr", "222"));

        PhoneBook phoneBook = new PhoneBook(bookRecords);

        phoneBook.add(new BookRecord("Dasha", "555"));

        System.out.println(phoneBook.find("Petr"));

        System.out.println(phoneBook.findAll("Dasha"));

    }
}
