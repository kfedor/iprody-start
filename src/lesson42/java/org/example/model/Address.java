package lesson42.java.org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {
    private int id;
    private String city;
    private String street;
    private String postal_code;
    private int user_id;

}
