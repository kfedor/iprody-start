package lesson36.java.api;

import dao.ReaderDao;
import dto.ReaderDto;
import entity.Reader;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/readers")
public class LibraryApi {

    private final ReaderDao readerDao = ReaderDao.getInstance();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Reader create(ReaderDto readerDto) {
        return readerDao.save(
                ReaderDto.builder()
                        .name(readerDto.getName())
                        .email(readerDto.getEmail())
                        .phone(readerDto.getPhone())
                        .build());
    }

}
