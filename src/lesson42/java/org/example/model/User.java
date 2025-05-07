package lesson42.java.org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String email;
    private List<Address> addresses;

}
