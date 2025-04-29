package lesson41.example.model;

import lombok.Data;

@Data
public class Book {

    private Integer id;
    private String title;
    private Integer publishedYear;
    private Integer authorId;
}
