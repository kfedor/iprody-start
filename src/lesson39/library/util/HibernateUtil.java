package lesson39.library.util;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.rest.library.entity.Book;
import org.hibernate.rest.library.entity.BorrowedBook;
import org.hibernate.rest.library.entity.Reader;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    @Getter
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();

            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/library");
            configuration.setProperty("hibernate.connection.username", "admin");
            configuration.setProperty("hibernate.connection.password", "admin");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.format_sql", "true");
            configuration.setProperty("hibernate.hbm2ddl.auto", "validate");
            configuration.setProperty("hibernate.transaction.coordinator_class", "jdbc");
            configuration.setProperty("hibernate.current_session_context_class", "thread");

            configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(Reader.class);
            configuration.addAnnotatedClass(BorrowedBook.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Не удалось создать SessionFactory", e);
        }
    }
}
