package lesson31.service.interfaces;

import lesson31.entities.Book;
import lesson31.entities.BorrowedBook;
import lesson31.entities.OccupiedBook;
import lesson31.entities.Reader;
import lesson31.util.enums.BookStatus;

import java.util.List;

public interface LibraryAPI {

    Book addBook(String title, String author, int publishedYear, String genre);

    BorrowedBook updateBookStatus(BorrowedBook borrowedBook, BookStatus newStatus);

    Reader addExistedReaderToDatabase(Reader reader);

    List<OccupiedBook> getAllOccupiedBooks();

    Reader updateReadersData(Reader reader, String email, String phone);

    List<Book> booksWithDefinedStatus(BookStatus status);

    List<Book> findBorrowedBooksAfterDate(String date);

}
