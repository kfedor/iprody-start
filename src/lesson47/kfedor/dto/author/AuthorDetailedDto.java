package lesson47.kfedor.dto.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDetailedDto {

    private UUID authorId;
    private String authorName;
    private LocalDate birthDate;
}