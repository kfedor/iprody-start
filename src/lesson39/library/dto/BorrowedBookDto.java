package lesson39.library.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.rest.library.entity.Book;
import org.hibernate.rest.library.entity.BookStatus;
import org.hibernate.rest.library.entity.Reader;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowedBookDto {

    private Integer borrowId;
    private Integer bookId;
    private Integer readerId;
    private Book book;
    private Reader reader;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private BookStatus status;
}