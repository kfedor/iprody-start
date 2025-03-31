import dao.BorrowedBookDao;
import dto.BorrowedBookDto;
import entity.BookStatus;

import java.time.LocalDate;
import java.util.Optional;

public class ApplicationRunner {
    public static void main(String[] args) {

        BorrowedBookDto borrowedBookDto = new BorrowedBookDto(
                1L,
                2L,
                LocalDate.of(2024,12, 10),
                Optional.empty(),
                BookStatus.BORROWED);
        BorrowedBookDao instance = BorrowedBookDao.getInstance();
        System.out.println(instance.save(borrowedBookDto));
    }
}
