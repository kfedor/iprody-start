package dto;

import entity.BookStatus;

import java.time.LocalDate;
import java.util.Optional;


public class BorrowedBookDto {

    private Long bookId;
    private Long readerId;
    private LocalDate borrowDate;
    private Optional<LocalDate> returnDate;
    private BookStatus status;

    public BorrowedBookDto(Long bookId, Long readerId, LocalDate borrowDate, Optional<LocalDate> returnDate, BookStatus status) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Optional<LocalDate> getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Optional<LocalDate> returnDate) {
        this.returnDate = returnDate;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
