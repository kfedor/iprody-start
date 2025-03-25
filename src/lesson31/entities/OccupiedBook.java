package lesson31.entities;

public class OccupiedBook {

    private Book book;
    private Reader reader;

    public OccupiedBook(Book book, Reader reader) {
        this.book = book;
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "OccupiedBook{" +
               "book=" + book +
               ", reader=" + reader +
               '}';
    }
}
