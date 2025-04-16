package lesson39.library.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlRootElement
public class BookDto {

    private Integer bookId;
    private String title;
    private String author;
    private Integer publishedYear;
    private String genre;
}
