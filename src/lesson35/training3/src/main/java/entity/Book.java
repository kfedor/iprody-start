package entity;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Objects;

@XmlRootElement
public class Book {
    private Long bookId;
    private String title;
    private String author;
    private Integer publishedYear;
    private String genre;

    public Book(Long bookId, String title, String author, Integer publishedYear, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.genre = genre;
    }

    public Book() {
    }

    @XmlElement
    public Long getBookId() {
        return bookId;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }

    @XmlElement
    public String getAuthor() {
        return author;
    }

    @XmlElement
    public Integer getPublishedYear() {
        return publishedYear;
    }

    @XmlElement
    public String getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(publishedYear, book.publishedYear) && Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, author, publishedYear, genre);
    }


    @Override
    public String toString() {
        return "Book{" +
               "bookId=" + bookId +
               ", title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", publishedYear=" + publishedYear +
               ", genre='" + genre + '\'' +
               '}';
    }
}
