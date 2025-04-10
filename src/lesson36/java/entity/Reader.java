package lesson36.java.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader {

    private Long readerId;
    private String name;
    private String email;
    private String phone;
}
