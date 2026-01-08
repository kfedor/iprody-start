package lesson47.kfedor.controller;

import com.github.kfedor.dto.book.BookDetailedDto;
import com.github.kfedor.dto.book.BookRequestDto;
import com.github.kfedor.dto.book.BookSummaryDto;
import com.github.kfedor.entity.Book;
import com.github.kfedor.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookSummaryDto> getBooks() {
        return bookService.getAllBooks().stream()
                .map(book -> new BookSummaryDto(book.getTitle(), book.getAuthor().getName()))
                .toList();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable(name = "id") UUID id) {
        return bookService.getById(id);
    }

    @PostMapping
    public BookDetailedDto createBook(@RequestBody BookRequestDto requestToCreate) {
        return toBookDetailedDto(bookService.createBook(requestToCreate));
    }

    @PutMapping("/{id}")
    public BookDetailedDto updateBook(@PathVariable(name = "id") UUID id, @RequestBody BookRequestDto bookDtoToUpdate) {
        return toBookDetailedDto(bookService.updateBook(id, bookDtoToUpdate));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable(name = "id") UUID id) {
        bookService.deleteBook(id);
    }

    @PostMapping("/{id}/borrow")
    public ResponseEntity<String> borrow(@PathVariable(name = "id") UUID bookId, @RequestParam(name = "userId") UUID userId) {
        bookService.borrowBook(bookId, userId);
        return ResponseEntity.ok("The book has been successfully borrowed.");
    }

    @PostMapping("/{id}/return")
    public ResponseEntity<String> returnBook(@PathVariable(name = "id") UUID bookId, @RequestParam(name = "userId") UUID userId) {
        bookService.returnBook(bookId, userId);
        return ResponseEntity.ok("The book has been successfully returned.");
    }

    private BookDetailedDto toBookDetailedDto(Book book) {
        return new BookDetailedDto(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                book.getAuthor().getName(),
                book.getAvailable()
        );
    }
}
