package lesson47.kfedor.dto.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequestDto {

    private String authorName;
    private LocalDate birthDate;
}
