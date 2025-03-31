package service;

import dao.BorrowedBookDao;
import dto.BorrowedBookDto;
import entity.BookStatus;
import entity.BorrowedBook;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.time.LocalDate;
import java.util.Optional;

@WebService(name = "BorrowedBook")
public class BorrowedBookWebService {

    private final BorrowedBookDao borrowedBookDao = BorrowedBookDao.getInstance();

    @WebMethod(operationName = "saveBorrowedBook")
    public BorrowedBook saveBorrowedBook(
            @WebParam(name = "bookId") Long bookId,
            @WebParam(name = "readerId") Long readerId,
            @WebParam(name = "borrowDate") String borrowDateStr,
            @WebParam(name = "returnDate") String returnDateStr,
            @WebParam(name = "status") String statusStr) {

        LocalDate borrowDate = LocalDate.parse(borrowDateStr);

        Optional<LocalDate> returnDate = (returnDateStr != null && !returnDateStr.isEmpty())
                ? Optional.of(LocalDate.parse(returnDateStr))
                : Optional.empty();
        return borrowedBookDao.save(new BorrowedBookDto(bookId, readerId, borrowDate, returnDate, BookStatus.valueOf(statusStr.toUpperCase())));
    }
}
