package lesson39.library.util;

import org.hibernate.rest.library.dto.BookDto;
import org.hibernate.rest.library.entity.Book;

public class BookMapper {

    private BookMapper() {
    }

    public static Book toEntity(BookDto dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        if (dto.getPublishedYear() != null) {
            book.setPublishedYear(dto.getPublishedYear());
        }
        if (dto.getGenre() != null) {
            book.setGenre(dto.getGenre());
        }
        return book;
    }

    public static BookDto toDto(Book book) {
        BookDto dto = new BookDto();
        dto.setBookId(book.getBookId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        if (book.getPublishedYear() != null) {
            dto.setPublishedYear(book.getPublishedYear());
        }
        if (book.getGenre() != null) {
            dto.setGenre(book.getGenre());
        }
        return dto;
    }
}
