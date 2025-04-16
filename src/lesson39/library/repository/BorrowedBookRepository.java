package lesson39.library.repository;

import org.hibernate.Session;
import org.hibernate.rest.library.entity.BorrowedBook;
import org.hibernate.rest.library.entity.GettingEntityById;

public class BorrowedBookRepository {

    private static final BorrowedBookRepository INSTANCE = new BorrowedBookRepository();

    private BorrowedBookRepository(){
    }

    public BorrowedBook save(BorrowedBook borrowedBook, Session session) {
           session.persist(borrowedBook);
        return borrowedBook;
    }

    public <E extends GettingEntityById> E getById(Class<E> clazz, Integer entityId, Session session) {
            return session.get(clazz, entityId);
    }

    public static BorrowedBookRepository getInstance(){
        return INSTANCE;
    }
}
