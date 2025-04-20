package lesson39.library.api;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hibernate.rest.library.dto.BookDto;
import org.hibernate.rest.library.entity.Book;
import org.hibernate.rest.library.repository.BookRepository;
import org.hibernate.rest.library.util.BookMapper;

import java.util.List;
import java.util.stream.Collectors;

@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookApi {

    private final BookRepository bookRepository = BookRepository.getInstance();

    @GET
    @Path("/{id}")
    public Response findBooksByReaderId(@PathParam("id") Integer id) {
        List<BookDto> dtoList = bookRepository.findBooksByReaderId(id).stream()
                .map(BookMapper::toDto)
                .collect(Collectors.toList());

        GenericEntity<List<BookDto>> entity = new GenericEntity<>(dtoList) {};

        return Response.ok(entity).build();
    }

    @POST
    public Response create(BookDto bookDto) {
        Book book = BookMapper.toEntity(bookDto);
        Book saved = bookRepository.save(book);
        BookDto savedDto = BookMapper.toDto(saved);
        return Response.status(Response.Status.CREATED)
                .entity(savedDto)
                .build();
    }
}