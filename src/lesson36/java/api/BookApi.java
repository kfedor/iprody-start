package lesson36.java.api;


import dao.BookDao;
import dto.BookDto;
import entity.Book;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/books")
public class BookApi {

    private final BookDao bookDao = BookDao.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooksByReaderId(@QueryParam("id") Long readerId) {
        return bookDao.getAllBooksByReaderId(readerId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book create(BookDto bookDto) {
        return bookDao.save(
                BookDto.builder()
                        .title(bookDto.getTitle())
                        .author(bookDto.getAuthor())
                        .build());
    }
}