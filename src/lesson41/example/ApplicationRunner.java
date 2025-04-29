package lesson41.example;

import org.example.config.ApplicationConfig;
import org.example.dao.AuthorDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        AuthorDao authorDao = context.getBean(AuthorDao.class);

        System.out.println(authorDao.findById(2L));

    }
}
