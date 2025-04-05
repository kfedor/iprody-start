package entity;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDate;
import java.util.Objects;

@XmlRootElement
public class BorrowedBook {

    private Long borrowId;
    private Book book;
    private Reader reader;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private BookStatus status;

    public BorrowedBook(Long borrowId, Book book, Reader reader, LocalDate borrowDate, LocalDate returnDate, BookStatus status) {
        this.borrowId = borrowId;
        this.book = book;
        this.reader = reader;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public BorrowedBook(Long borrowId, Book book, Reader reader, LocalDate borrowDate, BookStatus status) {
        this.borrowId = borrowId;
        this.book = book;
        this.reader = reader;
        this.borrowDate = borrowDate;
        this.status = status;
    }

    public BorrowedBook() {
    }

    @XmlElement
    public Long getBorrowId() {
        return borrowId;
    }

    @XmlElement
    public Book getBook() {
        return book;
    }

    @XmlElement
    public Reader getReader() {
        return reader;
    }

    @XmlElement
    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    @XmlElement
    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @XmlElement
    public BookStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BorrowedBook that = (BorrowedBook) o;
        return Objects.equals(borrowId, that.borrowId) && Objects.equals(book, that.book) && Objects.equals(reader, that.reader) && Objects.equals(borrowDate, that.borrowDate) && Objects.equals(returnDate, that.returnDate) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(borrowId, book, reader, borrowDate, returnDate, status);
    }

    @Override
    public String toString() {
        return "BorrowedBook{" +
               "borrowId=" + borrowId +
               ", book=" + book +
               ", reader=" + reader +
               ", borrowDate=" + borrowDate +
               ", returnDate=" + returnDate +
               ", status=" + status +
               '}';
    }
}
