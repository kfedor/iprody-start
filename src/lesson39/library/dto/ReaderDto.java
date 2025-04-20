package lesson39.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReaderDto {

    private Integer readerId;
    private String name;
    private String email;
    private String phone;
}
