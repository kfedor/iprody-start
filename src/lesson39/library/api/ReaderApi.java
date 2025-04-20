package lesson39.library.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hibernate.rest.library.dto.ReaderDto;
import org.hibernate.rest.library.entity.Reader;
import org.hibernate.rest.library.repository.ReaderRepository;
import org.hibernate.rest.library.util.ReaderMapper;

@Path("/readers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReaderApi {

    private final ReaderRepository readerRepository = ReaderRepository.getInstance();

    @POST
    public Response create(ReaderDto readerDto) {
        Reader reader = ReaderMapper.toEntity(readerDto);
        Reader savedReader = readerRepository.save(reader);
        ReaderDto dto = ReaderMapper.toDto(savedReader);
        return Response.status(Response.Status.CREATED).entity(dto).build();
    }
}
