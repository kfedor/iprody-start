package lesson39.library.repository;

import org.hibernate.Session;
import org.hibernate.rest.library.entity.Reader;
import org.hibernate.rest.library.util.HibernateUtil;

public class ReaderRepository {

    private static final ReaderRepository INSTANCE = new ReaderRepository();

    private ReaderRepository(){
    }

    public Reader save(Reader reader) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(reader);
            session.getTransaction().commit();
        }
        return reader;
    }


    public static ReaderRepository getInstance() {
        return INSTANCE;
    }
}
