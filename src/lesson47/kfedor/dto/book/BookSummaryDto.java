package lesson47.kfedor.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSummaryDto {

    private String title;
    private String authorName;

}
