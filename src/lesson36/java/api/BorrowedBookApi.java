package lesson36.java.api;

import dao.BorrowedBookDao;
import dto.BorrowedBookDto;
import entity.BookStatus;
import entity.BorrowedBook;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;

@Path("/borrowedBook")
public class BorrowedBookApi {

    private final BorrowedBookDao dao = BorrowedBookDao.getInstance();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BorrowedBook create(BorrowedBookDto dto) {
        return dao.save(
                BorrowedBookDto.builder()
                        .bookId(dto.getBookId())
                        .readerId(dto.getReaderId())
                        .borrowDate(LocalDate.now())
                        .status(BookStatus.BORROWED)
                        .build()
        );
    }
}
