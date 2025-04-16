package lesson39.library.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.rest.library.dto.BorrowedBookDto;
import org.hibernate.rest.library.entity.BorrowedBook;
import org.hibernate.rest.library.repository.BorrowedBookRepository;
import org.hibernate.rest.library.util.BorrowedBookMapper;
import org.hibernate.rest.library.util.HibernateUtil;

@Path("/borrowedBook")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BorrowedBookApi {

    private static final BorrowedBookRepository borrowedBookRepository = BorrowedBookRepository.getInstance();

    @POST
    public Response create(BorrowedBookDto borrowedBookDto) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            BorrowedBook borrowedBook = BorrowedBookMapper.toEntity(borrowedBookDto, session);
            BorrowedBook savedBorrowedBook = borrowedBookRepository.save(borrowedBook, session);
            transaction.commit();
            BorrowedBookDto savedDto = BorrowedBookMapper.toDto(savedBorrowedBook);
            return Response.status(Response.Status.CREATED).entity(savedDto).build();
        }
    }
}
