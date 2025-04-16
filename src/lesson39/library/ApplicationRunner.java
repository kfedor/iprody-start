package lesson39.library;


import org.hibernate.rest.library.api.BorrowedBookApi;
import org.hibernate.rest.library.dto.BorrowedBookDto;
import org.hibernate.rest.library.entity.BookStatus;

import java.time.LocalDate;

public class ApplicationRunner {
    public static void main(String[] args) {
        BorrowedBookDto dto = BorrowedBookDto.builder()
                .bookId(3)
                .readerId(1)
                .borrowDate(LocalDate.now())
                .status(BookStatus.BORROWED)
                .build();

        BorrowedBookApi borrowedBookApi = new BorrowedBookApi();
        System.out.println(borrowedBookApi.create(dto));

    }
}
