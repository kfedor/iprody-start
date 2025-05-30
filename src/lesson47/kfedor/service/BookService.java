package lesson47.kfedor.service;

import com.github.kfedor.dto.book.BookRequestDto;
import com.github.kfedor.entity.Author;
import com.github.kfedor.entity.Book;
import com.github.kfedor.entity.User;
import com.github.kfedor.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository repository;
    private final AuthorService authorService;
    private final UserService userService;

    @Autowired
    public BookService(BookRepository repository, AuthorService authorService, UserService userService) {
        this.repository = repository;
        this.authorService = authorService;
        this.userService = userService;
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getById(UUID bookId) {
        return repository.findById(bookId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no book with such id."));
    }

    public Book saveBook(Book book) {
        return repository.save(book);
    }

    public Book createBook(BookRequestDto bookToCreate) {

        Author author = authorService.getById(bookToCreate.getAuthorId());

        Book book = new Book();
        book.setTitle(bookToCreate.getTitle());
        book.setIsbn(bookToCreate.getIsbn());
        book.setAuthor(author);
        book.setAvailable(bookToCreate.getAvailable());
        return saveBook(book);
    }

    public Book updateBook(UUID id, BookRequestDto bookToUpdate) {
        Author author = authorService.getById(bookToUpdate.getAuthorId());

        Book book = repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

        book.setTitle(bookToUpdate.getTitle());
        book.setIsbn(bookToUpdate.getIsbn());
        book.setAuthor(author);
        book.setAvailable(bookToUpdate.getAvailable());
        return saveBook(book);
    }

    public void deleteBook(UUID id) {
        repository.deleteById(id);
    }

    @Transactional
    public void borrowBook(UUID bookId, UUID userId) {
        Book book = getById(bookId);
        User user = userService.getById(userId);
        if (book.getAvailable()) {
            user.getBorrowedBooks().add(book);
            book.setAvailable(false);
            saveBook(book);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Book is not available");
        }
    }

    @Transactional
    public void returnBook(UUID bookId, UUID userId) {
        Book book = getById(bookId);
        User user = userService.getById(userId);
        user.getBorrowedBooks().remove(book);
        book.setAvailable(true);
        saveBook(book);
    }
}
