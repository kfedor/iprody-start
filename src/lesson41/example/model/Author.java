package lesson41.example.model;

import lombok.Data;

@Data
public class Author {

    private Integer id;
    private String name;
    private String country;
    private Book book;
}
