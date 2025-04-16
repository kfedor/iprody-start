package lesson39.library.config;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.hibernate.rest.library.api.BookApi;
import org.hibernate.rest.library.api.BorrowedBookApi;
import org.hibernate.rest.library.api.ReaderApi;

@ApplicationPath("/library")
public class LibraryConfig extends ResourceConfig {

    public LibraryConfig() {
        register(BookApi.class);
        register(ReaderApi.class);
        register(BorrowedBookApi.class);
        register(MoxyJsonFeature.class);
        register(new LoggingFeature());
    }

}
