package lesson39.library.util;


import org.hibernate.Session;
import org.hibernate.rest.library.dto.BorrowedBookDto;
import org.hibernate.rest.library.entity.Book;
import org.hibernate.rest.library.entity.BookStatus;
import org.hibernate.rest.library.entity.BorrowedBook;
import org.hibernate.rest.library.entity.Reader;
import org.hibernate.rest.library.repository.BorrowedBookRepository;

public class BorrowedBookMapper {

    private static final BorrowedBookRepository borrowedBookRepository = BorrowedBookRepository.getInstance();

    private BorrowedBookMapper(){
    }

    public static BorrowedBook toEntity(BorrowedBookDto borrowedBookDto, Session session) {
        BorrowedBook borrowedBook = new BorrowedBook();
        borrowedBook.setBook(borrowedBookRepository.getById(Book.class, borrowedBookDto.getBookId(), session));
        borrowedBook.setReader(borrowedBookRepository.getById(Reader.class, borrowedBookDto.getReaderId(), session));
        borrowedBook.setBorrowDate(borrowedBookDto.getBorrowDate());
        if(borrowedBookDto.getReturnDate() != null) {
            borrowedBook.setReturnDate(borrowedBookDto.getReturnDate());
            borrowedBook.setStatus(BookStatus.RETURNED);
        } else {
            borrowedBook.setStatus(BookStatus.BORROWED);
        }
        return borrowedBook;
    }

    public static BorrowedBookDto toDto(BorrowedBook borrowedBook){
        BorrowedBookDto borrowedBookDto = new BorrowedBookDto();
        borrowedBookDto.setBorrowId(borrowedBook.getBorrowId());
        borrowedBookDto.setBook(borrowedBook.getBook());
        borrowedBookDto.setReader(borrowedBook.getReader());
        borrowedBookDto.setBorrowDate(borrowedBook.getBorrowDate());
        if(borrowedBook.getReturnDate() != null) {
            borrowedBookDto.setReturnDate(borrowedBook.getReturnDate());
            borrowedBookDto.setStatus(BookStatus.RETURNED);
        } else {
            borrowedBookDto.setStatus(BookStatus.BORROWED);
        }
        return  borrowedBookDto;
    }

}
