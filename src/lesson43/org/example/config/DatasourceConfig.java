package lesson43.org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource managerDataSource = new DriverManagerDataSource();
        managerDataSource.setUrl("jdbc:postgresql://localhost:5432/users");
        managerDataSource.setUsername("admin");
        managerDataSource.setPassword("admin");
        managerDataSource.setDriverClassName("org.postgresql.Driver");
        return managerDataSource;
    }
}
