package lesson36.java.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowedBook {

    private Long borrowId;
    private Book book;
    private Reader reader;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private BookStatus status;
}
