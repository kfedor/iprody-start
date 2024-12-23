package lesson13.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PhoneBook {

    private List<BookRecord> recordList;

    public PhoneBook(List<BookRecord> recordList) {
        this.recordList = recordList;
    }

    /**
     * Method adds input record to phone book.
     *
     * @param record which should be added to phone book.
     */
    public void add(BookRecord record) {
        recordList.add(record);
    }

    /**
     * Method finds and returns a record by name if exists.
     *
     * @param name of record that should be found.
     * @return record if exists, else optional empty.
     */
    public Optional<BookRecord> find(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name can't be null.");
        }
        for (BookRecord record : recordList) {
            if (name.equals(record.name())) {
                return Optional.of(record);
            }
        }
        return Optional.empty();
    }

    /**
     * Method finds all records by one name and returns a list with it.
     * @param name of record that should be found.
     * @return list of records or empty list.
     */
    public List<BookRecord> findAll(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name can't be null.");
        }
        List<BookRecord> records = new ArrayList<>();
        for (BookRecord record : recordList) {
            if (name.equals(record.name())) {
                records.add(record);
            }
        }
        return records;
    }
}
