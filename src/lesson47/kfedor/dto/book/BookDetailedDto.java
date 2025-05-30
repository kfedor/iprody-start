package lesson47.kfedor.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailedDto {

    private UUID id;
    private String title;
    private String isbn;
    private String authorName;
    private Boolean available;
}
