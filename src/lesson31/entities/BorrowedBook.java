package lesson31.entities;

import lesson31.util.enums.BookStatus;

import java.time.LocalDate;

public class BorrowedBook {

    private int borrowId;
    private Book book;
    private Reader reader;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private BookStatus status;

    public BorrowedBook(int borrowId, Book book, Reader reader, LocalDate borrowDate, LocalDate returnDate, BookStatus status) {
        this.borrowId = borrowId;
        this.book = book;
        this.reader = reader;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
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

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
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
