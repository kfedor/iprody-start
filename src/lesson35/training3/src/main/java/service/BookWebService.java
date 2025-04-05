package service;

import dao.BookDao;
import dto.BookDto;
import entity.Book;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(name = "BookWebService")
public class BookWebService {

    private final BookDao bookDao = BookDao.getInstance();

    @WebMethod(operationName = "saveBook")
    public Book saveBook(
            @WebParam(name = "title") String title,
            @WebParam(name = "author") String author,
            @WebParam(name = "year") Integer publishedYear,
            @WebParam(name = "genre") String genre) {
        return bookDao.save(new BookDto(title, author, publishedYear, genre));
    }
}
