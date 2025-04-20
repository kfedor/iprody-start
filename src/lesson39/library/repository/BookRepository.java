package lesson39.library.repository;


import org.hibernate.Session;
import org.hibernate.rest.library.entity.Book;
import org.hibernate.rest.library.util.HibernateUtil;

import java.util.List;

public class BookRepository {

    private static final BookRepository INSTANCE = new BookRepository();

    private BookRepository() {
    }

    public List<Book> findBooksByReaderId(Integer readerId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "SELECT bb.book FROM BorrowedBook bb WHERE bb.reader.readerId = :readerId", Book.class)
                    .setParameter("readerId", readerId)
                    .getResultList();

        }
    }

    public Book save(Book book) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(book);
            session.getTransaction().commit();
        }
        return book;
    }

    public static BookRepository getInstance() {
        return INSTANCE;
    }

}
