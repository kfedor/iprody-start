package lesson36.java.dto;

import entity.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowedBookDto {

    private Long bookId;
    private Long readerId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private BookStatus status;
}